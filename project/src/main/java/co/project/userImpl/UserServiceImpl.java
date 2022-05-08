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
	public int userJoin(String USERID, String USERNAME) {
		int n = 0;
		String sql = "INSERT INTO USERS VALUES(?,?,1,0,0,2)";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, USERID);
			psmt.setString(2, USERNAME);
			n = psmt.executeUpdate();
				System.out.println("회원가입 성공");
				Menu menu = new Menu();
				menu.mainhome();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	// 로그인
	public User userlogin(String USERID) {
		User us = null;
		String sql = "SELECT * FROM USERS WHERE USERID=?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, USERID);
			rs = psmt.executeQuery();
			if (rs.next()) {
					System.out.println("로그인 성공");
					Menu menu = new Menu();
					menu.mainList();
				} else {
					System.out.println("로그인 실패");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return us;

	}
	
	public List<User> userSelectList(){
		List<User> list = new ArrayList<User>();
		User us;
		String sql = "SELECT * FROM USERS";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				us = new User();
				us.setUSERID(rs.getString("USERID"));
				us.setUSERNAME(rs.getString("USERNAME"));
				us.setUSERLEVEL(rs.getInt("USERLEVEL"));
				us.setMONEY(rs.getInt("MONEY"));
				us.setBURGERNUM(rs.getInt("BURGERNUM"));
				us.setBURGER_MAX(rs.getInt("BURGER_MAX"));
				list.add(us);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}
	
	
	@Override
	public User userInfoList(User us) {
		// 유저 정보
		String sql = "SELECT * FROM USERS WHERE USERID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, us.getUSERID());
			rs = psmt.executeQuery();
			if (rs.next()) {
				us = new User();
				us.setUSERID(rs.getString("USERID"));
				us.setUSERNAME(rs.getString("USERNAME"));
				us.setUSERLEVEL(rs.getInt("USERLEVEL"));
				us.setMONEY(rs.getInt("MONEY"));
				us.setBURGERNUM(rs.getInt("BURGERNUM"));
				us.setBURGER_MAX(rs.getInt("BURGER_MAX"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return us;
	}

	@Override
	public int userModedate(User us) {
		// 일반 모드
		return 0;
	}

	@Override
	public int userSysModedate(User us) {
		// 관리자 모드
		return 0;
	}

	@Override
	public int usershopUpdate(User us) {
		// 주방 확장
		return 0;
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

}
