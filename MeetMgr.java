package tib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import member.MemberBean;

public class MeetMgr {

	private DBConnectionMgr pool;
	public MeetMgr() {
		pool = DBConnectionMgr.getInstance();
	}
	
	
	public Vector<MeetBean> getListMeet(){
		Connection con = null;
		
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		String sql = null; 
		Vector<MeetBean>vlist = new Vector<MeetBean>();
		try {
			con = pool.getConnection();
			sql="select * from meet order by didx";
			pstmt = con.prepareStatement(sql); 
			rs= pstmt.executeQuery();
			while(rs.next()) {
				MeetBean bean = new MeetBean();
				bean.setDidx(rs.getInt("didx"));//여행코드
				bean.setDcode(rs.getInt("dcode"));//날짜 = 여행일자
				bean.setMtent(rs.getString("mtent"));//여행지 = 구별
				vlist.addElement(bean);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con,pstmt,rs);
		}
		return vlist;
	}
	
	//입력->여행 패키지 소개하는 란
	//seqmember.nextval : 자동증가

		public boolean insertMeet(MeetBean bean) {
			Connection con = null;
			PreparedStatement pstmt = null;
			String sql = null;
			boolean flag = false;
			try {
				con = pool.getConnection();
				//? 쓰는 이유? 들어갈 값
				sql = "insert into meet(didx,dcode,mtent)"
						+ "values(?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, bean.getDidx());
				pstmt.setInt(2, bean.getDcode());
				pstmt.setString(3, bean.getMtent());
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













