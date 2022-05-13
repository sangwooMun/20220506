package co.project.userImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.project.Menu;
import co.project.dao.DataSource;
import co.project.user.User;
import co.project.user.UserService;

public class UserServiceImpl implements UserService {

	private DataSource dao = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	// 회원가입
	public int userJoin(String userId, String userName) {
		int n = 0;
		String sql = "INSERT INTO USERS VALUES(?,?,1,0,0,2)";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			psmt.setString(2, userName);
			n = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	// 로그인
	public User userlogin(String userId) {
		User ur = new User();
		String sql = "SELECT * FROM USERS WHERE USERID=?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			rs = psmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userId)) {
					ur = new User();
					ur.setUserId(rs.getString("USERID"));
					ur.setUserName(rs.getString("USERNAME"));
					ur.setUserLever(rs.getInt("USERLEVEL"));
					ur.setMoney(rs.getInt("MONEY"));
					ur.setBurgerNum(rs.getInt("BURGERNUM"));
					return ur;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null;

	}

	public List<User> userSelectList() {
		List<User> list = new ArrayList<User>();
		User us;
		String sql = "SELECT * FROM USERS";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				us = new User();
				us.setUserId(rs.getString("USERID"));
				us.setUserName(rs.getString("USERNAME"));
				us.setUserLever(rs.getInt("USERLEVEL"));
				us.setMoney(rs.getInt("MONEY"));
				us.setBurgerNum(rs.getInt("BURGERNUM"));
				list.add(us);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	public User userInfo(User ur) {
		// 유저 정보
		String sql = "SELECT * FROM USERS WHERE USERID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, ur.getUserId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				ur = new User();
				ur.setUserId(rs.getString("USERID"));
				ur.setUserName(rs.getString("USERNAME"));
				ur.setUserLever(rs.getInt("USERLEVEL"));
				ur.setMoney(rs.getInt("MONEY"));
				ur.setBurgerNum(rs.getInt("BURGERNUM"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return ur;
	}


	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int burgerAdd(User ur) {
		int u = 0;
		String sql ="UPDATE USERS SET BURGERNUM = BURGERNUM + ? WHERE USERID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, ur.getBurgerNum());
			psmt.setString(2, ur.getUserId());
			u = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
		
	}

	@Override
	public int userInfoUpdate(User ur) {
		System.out.println(ur);
		// 정보 업데이트
		int u = 0;
		String sql = "UPDATE USERS SET USERLEVEL = ?, BURGERNUM = ? WHERE USERID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, ur.getUserLever());
			psmt.setInt(2, ur.getBurgerNum());
			psmt.setString(3, ur.getUserId());
			u = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
//	String sql = "UPDATE USERS SET USERLEVEL = USERLEVEL +(TRUNC ( BURGERNUM/20 )) WHERE USERID = ?";
//	String sql = "UPDATE USERS SET BURGERNUM = BURGERNUM + 1 WHERE USERID = ?";
//	String sql = "UPDATE USERS SET USERLEVEL = ?, BURGERNUM = ? WHERE USERID = ?";
}
