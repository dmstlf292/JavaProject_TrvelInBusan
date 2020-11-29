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

	//여행코드, 날짜, 여행지
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
				bean.setDidx(rs.getInt("didx"));//여행코드
				bean.setDcode(rs.getInt("dcode"));//날짜 = 여행일자
				bean.setTidx(rs.getInt("tidx"));//여행지 = 구별
				vlist.addElement(bean);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con,pstmt,rs);
		}
		return vlist;
	}
	
	//레코드 한개 가져오기//
	public MdesignBean  getMdesign(int didx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MdesignBean bean = new MdesignBean();
		try {
			con = pool.getConnection();
			//예시 select aid from orders join products using(pid) where pcity = '광주';
			//trvl테이블(기본키 tidx) + mdesign 테이블 조인하기
			
			sql = "select place from mdesign m join trvl t on (m.tidx = t.tidx) where tidx =?;"; // 이렇게 하면 장소가 뜬다?
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
