package tib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import member.MemberBean;

public class MdesignMgr {

	private DBConnectionMgr pool;
	public MdesignMgr() {
		pool = DBConnectionMgr.getInstance();
	}

	//�����ڵ�, ��¥, ������
	public Vector<MdesignBean> getListMdesign(){
		Connection con = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		String sql = null; 
		Vector<MdesignBean>vlist = new Vector<MdesignBean>();
		try {
			con = pool.getConnection();
			sql="select * from mdesign order by didx";
			pstmt = con.prepareStatement(sql); 
			rs= pstmt.executeQuery();
			while(rs.next()) {
				MdesignBean bean = new MdesignBean();
				bean.setDidx(rs.getInt("didx"));//�����ڵ�
				bean.setDcode(rs.getInt("dcode"));//��¥ = ��������
				bean.setTidx(rs.getInt("tidx"));//������ = ����
				vlist.addElement(bean);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con,pstmt,rs);
		}
		return vlist;
	}
	
	//���ڵ� �Ѱ� ��������//
	public MdesignBean  getMdesign(int didx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MdesignBean bean = new MdesignBean();
		try {
			con = pool.getConnection();
			//���� select aid from orders join products using(pid) where pcity = '����';
			//trvl���̺�(�⺻Ű tidx) + mdesign ���̺� �����ϱ�
			
			sql = "select place from mdesign m join trvl t on (m.tidx = t.tidx) where tidx =?;"; // �̷��� �ϸ� ��Ұ� ���?
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, didx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bean.setDidx(rs.getInt(1));
				bean.setDcode(rs.getInt(2));
				bean.setTidx(rs.getInt(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
	
}
