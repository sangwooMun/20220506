package co.project.userImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.project.dao.DataSource;
import co.project.user.User;
import co.project.user.UserService;

public class UserServiceImpl implements UserService{
	
	private DataSource dao = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	// 로그인
//	public String userlogin(String USEDID) {
//		String sql = "SELECT * FROM USER WHERE USERID=?";
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, "USERID");
//			rs=psmt.executeQuery();
//			if(rs.next()) {
//				if(rs.getString(1).equals(USEDID)) {
//					System.out.println("로그인 성공");
//				}else {
//					System.out.println("로그인 실패");
//				}
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return userlogin(USEDID);
//		
//	}
	
	
	@Override
	public User userInfoList(User us) {
		//유저 정보
		String sql = "SELECT * FROM users WHERE USERID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, us.getUSERID());
			rs = psmt.executeQuery();
			if(rs.next()) {
				us = new User();
				us.setUSERID(rs.getString("USERID"));
				us.setUSERLEVEL(rs.getInt("USERLEVEL"));
				us.setMONETY(rs.getInt("MONETY"));
				us.setBURGERNUM(rs.getInt("BURGERNUM"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
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
			if(rs != null)rs.close();
			if(psmt != null)psmt.close();
			if(conn != null)conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
