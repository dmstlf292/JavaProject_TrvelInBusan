package tib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import member.MemberBean;

public class CommentsMgr {

	private DBConnectionMgr pool;
	public CommentsMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	
	//���� ����Ʈ
	public Vector<CommentsMgr> getListNote(String sid){
		
	
		Connection con = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		String sql = null;
		Vector<CommentsMgr>vlist = new Vector<CommentsMgr>();
		
		try {
			con = pool.getConnection();
			sql="select * from Comments order by widx";
			pstmt = con.prepareStatement(sql); 
			rs= pstmt.executeQuery();
			while(rs.next()) {
				CommentsBean bean = new CommentsBean();
				bean.setWidx(rs.getInt("widx"));
				bean.setIdx(rs.getInt("idx"));
				bean.setWdate(rs.getString("wdate"));
				bean.setCtent(rs.getString("ctent"));
				vlist.addElement(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con,pstmt,rs);
		}
		return vlist;
	}
	
	/*
	//���� ��������
	public NoteBean getNote(int no) {}
	
	//���� �Է�
	public boolean insertNote(NoteBean bean) {}
	
	//��������
	public boolean deleteNote(int no) {}

	//���� Ȯ��
	public void readNote(int no){}*/
}
