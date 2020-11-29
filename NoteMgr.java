package tib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class NoteMgr {

	private DBConnectionMgr pool;
	public NoteMgr() {
		pool = DBConnectionMgr.getInstance();
	}

	//쪽지 리스트
	public Vector<NoteBean> getListNote(String sid){
		
		Connection con = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		String sql = null; 
		Vector<NoteBean>vlist = new Vector<NoteBean>();
		
		try {
			con = pool.getConnection();
			sql="select * from notes order by no";
			pstmt = con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			while(rs.next()){
				NoteBean bean = new NoteBean();
				bean.setNo(rs.getInt("no"));
				bean.setRid(rs.getString("rid"));
				bean.setSid(rs.getString("sid"));
				bean.setTitle(rs.getString("title"));
				bean.setNote(rs.getString("note"));
				bean.setNdate(rs.getString("ndate"));
				bean.setModea(rs.getString("modea"));
				vlist.addElement(bean);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con,pstmt,rs);
		}
		return vlist;

	}
	
	//쪽지 가져오기
	public NoteBean getNote(int no) {
		Connection con = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		String sql = null; 
		NoteBean bean = new NoteBean();
		try {
			con = pool.getConnection();
			sql = "select * from notes where no=?";
			pstmt.setInt(1, no);
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setNo(rs.getInt(1));
				bean.setRid(rs.getString(2));
				bean.setSid(rs.getString(3));
				bean.setTitle(rs.getString(4));
				bean.setNote(rs.getString(5));
				bean.setNdate(rs.getString(6));
				bean.setModea(rs.getString(7));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
			
	}
	
	//쪽지 입력
	public boolean insertNote(NoteBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert into notes(no,rid,sid,title,note)"
					+ "values(seqmember.nextval,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bean.getNo());
			pstmt.setString(2, bean.getRid());
			pstmt.setString(3, bean.getSid());
			pstmt.setString(4, bean.getTitle());
			pstmt.setString(5, bean.getNote());

			int cnt = pstmt.executeUpdate();//insert,update,delete
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
		
	}
	
	//쪽지삭제
	public boolean deleteNote(int no) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "delete from notes where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			int cnt = pstmt.executeUpdate();
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
		
		
	}

	//쪽지 확인
	public boolean readNote(int no){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "delete from notes where no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			int cnt = pstmt.executeUpdate();
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
		
		
	}
}
