package tib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import member.MemberBean;

public class DesignMgr {
	
	private DBConnectionMgr pool;
	
	public DesignMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	
	public Vector<DesignBean> getListDesign(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		Vector<DesignBean> vlist = new Vector<DesignBean>();
		try {
			con = pool.getConnection();
			sql = "select * from design order by dcode";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DesignBean bean =new DesignBean();
				bean.setDcode(rs.getInt("dcode"));
				bean.setIdx(rs.getInt("idx"));
				bean.setPeriod(rs.getString("period"));
				bean.setDdate(rs.getString("ddate"));
				bean.setArea(rs.getString("area"));
				bean.setDage(rs.getString("dage"));
				bean.setGender(rs.getString("gender"));
				bean.setNump(rs.getString("nump"));
				vlist.addElement(bean);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con,pstmt,rs);
		}
		return vlist;
	}
	
	//레코드 한개 가져오기
		public DesignBean  getDesign(int dcode) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = null;
			DesignBean bean = new DesignBean();
			try {
				con = pool.getConnection();
				sql = "select * from design where dcode = ?";
				//매개변수 idx를 첫번째 ?에 세팅
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, dcode);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					bean.setDcode(rs.getInt("dcode"));
					bean.setIdx(rs.getInt("idx"));
					bean.setPeriod(rs.getString("period"));
					bean.setDdate(rs.getString("ddate"));
					bean.setArea(rs.getString("area"));
					bean.setDage(rs.getString("dage"));
					bean.setGender(rs.getString("gender"));
					bean.setNump(rs.getString("nump"));
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return bean;
		}
		
	
	//입력
	public boolean insertDesign(DesignBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert into design(dcode,idx,period,ddate,area,dage,gender,nump)"
					+ "values(seqdesign.nextval,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);						
			pstmt.setInt(1, bean.getIdx());
			pstmt.setString(2, bean.getPeriod());
			pstmt.setString(3, bean.getDdate());
			pstmt.setString(4, bean.getArea());
			pstmt.setString(5, bean.getDage());
			pstmt.setString(6, bean.getGender());
			pstmt.setString(7, bean.getNump());
			
			int cnt = pstmt.executeUpdate();//insert,update,delete
			if(cnt==1) flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {

	}

}
