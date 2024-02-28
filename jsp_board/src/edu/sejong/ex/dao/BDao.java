package edu.sejong.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import edu.sejong.ex.dto.BDto;

public class BDao {

	// 커넥션 풀 객체
	private DataSource dataSource = null;

	public BDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<BDto> list() {
		List<BDto> dtos = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from mvc_board order by bgroup desc, bstep asc";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bhit");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");

				BDto dto = new BDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return dtos;
	}
	
	public void write(String bname, String btitle, String bcontent) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) " + 
					 "values (mvc_board_seq.nextval, ? , ? , ? , 0, mvc_board_seq.currval, 0, 0)";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			
			int rn = pstmt.executeUpdate();		
			
			System.out.println("insert 실행 결과 : " + rn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void modify(BDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update mvc_board set btitle = ? , bcontent = ? where bid = ? and bname = ?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getBtitle());
			pstmt.setString(2, dto.getBcontent());
			pstmt.setInt(3, dto.getBid());
			pstmt.setString(4, dto.getBname());
			
			int rn = pstmt.executeUpdate();		
			
			System.out.println("insert 실행 결과 : " + rn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void delete(BDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from mvc_board where bid = ?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getBid());			
			
			int rn = pstmt.executeUpdate();		
			
			System.out.println("insert 실행 결과 : " + rn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public BDto contentView(int bID) {
		BDto dto = new BDto();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from mvc_board where bid = ?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bhit");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");

				dto = new BDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}

	public BDto replyView(String bidStr) {
		
		BDto dto = new BDto();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from mvc_board where bid = ?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.valueOf(bidStr));
			rs = pstmt.executeQuery();
			if (rs.next()) {
				int bid = rs.getInt("bid");
				String bname = rs.getString("bname");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				Timestamp bdate = rs.getTimestamp("bdate");
				int bhit = rs.getInt("bhit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");

				dto = new BDto(bid, bname, btitle, bcontent, bdate, bhit, bgroup, bstep, bindent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}

	public void reply(String bidStr, String bname, String btitle, String bcontent, String bgroup, String bstep,
			String bindent) {
		replyShape(bgroup, bstep);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) " + 
					 "values (mvc_board_seq.nextval, ? , ? , ? , ?, ?, ?)";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bname);
			pstmt.setString(2, btitle);
			pstmt.setString(3, bcontent);
			pstmt.setInt(4, Integer.valueOf(bgroup));
			pstmt.setInt(5, Integer.valueOf(bstep)+1);
			pstmt.setInt(6, Integer.valueOf(bindent)+1);
			
			int rn = pstmt.executeUpdate();		
			
			System.out.println("insert 실행 결과 : " + rn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	private void replyShape(String bgroup, String bstep) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update mvc_board set bstep = bstep+1 where bgroup = ? and bstep > ?";
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(4, Integer.valueOf(bgroup));
			pstmt.setInt(5, Integer.valueOf(bstep)+1);
			
			int rn = pstmt.executeUpdate();		
			
			System.out.println("insert 실행 결과 : " + rn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();			
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}	
}
