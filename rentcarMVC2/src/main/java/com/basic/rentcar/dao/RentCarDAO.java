package com.basic.rentcar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.basic.rentcar.vo.JoinCarView;
import com.basic.rentcar.vo.Rentcar;
import com.basic.rentcar.vo.Reservation;

public class RentCarDAO {
	private RentCarDAO() {
	}

	private static RentCarDAO dao = new RentCarDAO();

	public static RentCarDAO getInstance() {
		return dao;
	}

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public void getConnection() {
		String URL = "jdbc:mysql://localhost:3306/rentcardb01?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
		String user = "root";
		String password = "1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getUser(String id, String pw) {
		String SQL = "select * from member where id=? and pw=?";
		getConnection();
		int cnt = 0;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			if (rs.next()) {
				cnt = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	public ArrayList<Rentcar> getSelectCar() {
		String SQL = "select * from rentcar order by no desc limit 3";
		getConnection();
		ArrayList<Rentcar> carlist = new ArrayList<Rentcar>();
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			int cnt = 0;
			while (rs.next()) {
				Rentcar rc = new Rentcar();
				rc.setNo(rs.getInt("no"));
				rc.setName(rs.getString("name"));
				rc.setCategory(rs.getInt("category"));
				rc.setPrice(rs.getInt("price"));
				rc.setUsepeople(rs.getInt("usepeople"));
				rc.setTotalQty(rs.getInt("total_qty"));
				rc.setCompany(rs.getString("company"));
				rc.setImg(rs.getString("img"));
				rc.setInfo(rs.getString("info"));
				carlist.add(rc);
				cnt++;
				if (cnt > 2)
					break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return carlist;
	}

	public Rentcar getOneCar(int no) {
		String SQL = "select * from rentcar where no=?";
		Rentcar rc = new Rentcar();
		getConnection();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if (rs.next()) {
				rc.setNo(no);
				rc.setName(rs.getString("name"));
				rc.setCategory(rs.getInt("category"));
				rc.setPrice(rs.getInt("price"));
				rc.setUsepeople(rs.getInt("usepeople"));
				rc.setTotalQty(rs.getInt("total_qty"));
				rc.setCompany(rs.getString("company"));
				rc.setImg(rs.getString("img"));
				rc.setInfo(rs.getString("info"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return rc;
	}

	public void setReserveCar(Reservation reser) {
		String SQL = "insert into carreserve(no, id, qty, dday, rday," + "usein, usewifi, usenavi, useseat)" + "values(?,?,?,?,?,?,?,?,?)";
		getConnection();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, reser.getNo());
			ps.setString(2, reser.getId());
			ps.setInt(3, reser.getQty());
			ps.setInt(4, reser.getDday());
			ps.setString(5, reser.getRday());
			ps.setInt(6, reser.getUsein());
			ps.setInt(7, reser.getUsewifi());
			ps.setInt(8, reser.getUsenavi());
			ps.setInt(9, reser.getUseseat());
			if (ps.executeUpdate() > 0) {
				updateRentcarQty(reser.getNo(), reser.getQty());
				System.out.println("차량 예약 완료");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	private void updateRentcarQty(int no, int rentQty) {
		String SQL = "update rentcar set total_qty = total_qty - ? where no=?";
		getConnection();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, rentQty);
			ps.setInt(2, no);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	public ArrayList<Rentcar> getAllCar() {
		String SQL = "select * from rentcar";
		ArrayList<Rentcar> rentlist = new ArrayList<>();
		Rentcar rc = null;
		getConnection();
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {
				rc = new Rentcar();
				rc.setNo(rs.getInt("no"));
				rc.setName(rs.getString("name"));
				rc.setCategory(rs.getInt("category"));
				rc.setPrice(rs.getInt("price"));
				rc.setUsepeople(rs.getInt("usepeople"));
				rc.setTotalQty(rs.getInt("total_qty"));
				rc.setCompany(rs.getString("company"));
				rc.setImg(rs.getString("img"));
				rc.setInfo(rs.getString("info"));
				rentlist.add(rc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return rentlist;
	}

	public ArrayList<Rentcar> getCategoryCar(int category) {
		String SQL = "select * from rentcar where category=?";
		ArrayList<Rentcar> carlist = new ArrayList<>();
		Rentcar rc = null;
		getConnection();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, category);
			rs = ps.executeQuery();
			while (rs.next()) {
				rc = new Rentcar();
				rc.setNo(rs.getInt("no"));
				rc.setName(rs.getString("name"));
				rc.setCategory(rs.getInt("category"));
				rc.setPrice(rs.getInt("price"));
				rc.setUsepeople(rs.getInt("usepeople"));
				rc.setTotalQty(rs.getInt("total_qty"));
				rc.setCompany(rs.getString("company"));
				rc.setImg(rs.getString("img"));
				rc.setInfo(rs.getString("into"));
				carlist.add(rc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return carlist;
	}

	public ArrayList<JoinCarView> getAllReserve(String id) {
		String SQL = "select * from rentcar a2, carreserve a1 where a1.id=? and a1.no = a2.no";
		ArrayList<JoinCarView> jclist = new ArrayList<>();
		JoinCarView jc = null;
		getConnection();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				jc = new JoinCarView();
				jc.setNo(rs.getInt("no"));
				jc.setReserveSeq(rs.getInt("reserve_seq"));
				jc.setName(rs.getString("name"));
				jc.setPrice(rs.getInt("price"));
				jc.setImg(rs.getString("img"));
				jc.setQty(rs.getInt("qty"));
				jc.setDday(rs.getInt("dday"));
				jc.setRday(rs.getString("rday"));
				jc.setUsein(rs.getInt("usein"));
				jc.setUsewifi(rs.getInt("usewifi"));
				jc.setUsenavi(rs.getInt("usenavi"));
				jc.setUseseat(rs.getInt("useseat"));
				jclist.add(jc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return jclist;
	}

	public void carRemoveReserve(int reserveSeq, int qty, int no) {
		String SQL = "delete from carreserve where reserve_seq=?";
		getConnection();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, reserveSeq);
			if (ps.executeUpdate() > 0) {
				backRentcarQty(no, qty);
				System.out.println("삭제 완료");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	public void backRentcarQty(int no, int rentQty) {
		String SQL = "update rentcar set total_qty=total_qty+? where no=?";
		getConnection();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, rentQty);
			ps.setInt(2, no);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	public void dbClose() {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}