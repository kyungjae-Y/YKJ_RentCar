package com.basic.rentcar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.basic.rentcar.vo.User;

public class UserDAO {
	private UserDAO() {
	}

	static private UserDAO instance = new UserDAO();

	static public UserDAO getInstance() {
		return instance;
	}

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public void getConnect() {
		String URL = "jdbc:mysql://localhost:3306/mvc05db?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String user = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int userInsert(User u) {
		String SQL = "insert into user(id,pw,email,tel,hobby,job,age,info) value(?,?,?,?,?,?,?,?)";
		getConnect();
		int cnt = -1;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, u.getId());
			ps.setString(2, u.getPw());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getTel());
			ps.setString(5, u.getHobby());
			ps.setString(6, u.getJob());
			ps.setString(7, u.getAge());
			ps.setString(8, u.getInfo());
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	public ArrayList<User> userList() {
		String SQL = "select * from user";
		getConnect();
		ArrayList<User> list = new ArrayList<User>();
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("no");
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				String hobby = rs.getString("hobby");
				String job = rs.getString("job");
				String age = rs.getString("age");
				String info = rs.getString("info");
				User u = new User(no, id, pw, email, tel, hobby, job, age, info);
				list.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	public boolean isValidId(String id) {
		String SQL = "select pw from user where id=?";
		getConnect();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			rs = ps.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return false;
	}

	public boolean checkLogin(String id, String pw) {
		String SQL = "select * from user where id=? and pw=?";
		getConnect();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return false;
	}

	public int getUserNo(String id) {
		String SQL = "select no from user where id=?";
		getConnect();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("no");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return -1;
	}

	public int userDelete(String id) {
		String SQL = "delete from user where id=?";
		getConnect();
		int cnt = -1;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	public User userContent(int no) {
		String SQL = "select * from user where no=?";
		getConnect();
		User u = null;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String email = rs.getString("email");
				String tel = rs.getString("tel");
				String hobby = rs.getString("hobby");
				String job = rs.getString("job");
				String age = rs.getString("age");
				String info = rs.getString("info");
				u = new User(no, id, pw, email, tel, hobby, job, age, info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return u;
	}

	public int userUpdate(User u) {
		String SQL = "update user set pw=?, email=?, tel=?, hobby=?, job=?, age=?, info=?";
		getConnect();
		int cnt = -1;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, u.getPw());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getTel());
			ps.setString(4, u.getHobby());
			ps.setString(5, u.getJob());
			ps.setString(6, u.getAge());
			ps.setString(7, u.getInfo());
			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	public void dbClose() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
