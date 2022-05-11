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
		User user = new User();
		String sql = "SELECT * FROM USERS WHERE USERID=?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userId);
			rs = psmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(userId)) {
					return user;
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
				us.setBurger_Max(rs.getInt("BURGER_MAX"));
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
	public int userInfoList(User us) {
		// 유저 정보
		int u = 0;
		String sql = "SELECT * FROM USERS WHERE USERID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, us.getUserId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				us = new User();
				us.setUserId(rs.getString("USERID"));
				us.setUserName(rs.getString("USERNAME"));
				us.setUserLever(rs.getInt("USERLEVEL"));
				us.setMoney(rs.getInt("MONEY"));
				us.setBurgerNum(rs.getInt("BURGERNUM"));
				us.setBurger_Max(rs.getInt("BURGER_MAX"));
				if(rs.getString(1).equals(us.getUserId())) {
					return u;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return u;
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

	@Override
	public int userInfoUpdate(User us) {
		System.out.println(us);
		// 정보 업데이트
		int u = 0;
		String sql = "UPDATE USERS SET USERLEVEL = ?, BURGERNUM = ? WHERE USERID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, us.getUserLever());
			psmt.setInt(2, us.getBurgerNum());
			psmt.setString(3, us.getUserId());
			u = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

}


//user.setUserName(rs.getString("USERNAME"));
//user.setUserLever(rs.getInt("USERLEVEL"));
//user.setMoney(rs.getInt("MONEY"));
//user.setBurgerNum(rs.getInt("BURGERNUM"));
//user.setBurger_Max(rs.getInt("BURGER_MAX"));