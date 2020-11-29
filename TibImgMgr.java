package tib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//db연동에 필요한 모든 기능을 객체화 시킨것
public class TibImgMgr {

	private DBConnectionMgr pool;

	public TibImgMgr() {
		pool = DBConnectionMgr.getInstance();// 객체생성
	}

	// 리스트
	// 제네릭: Vector에 저장되는 타입을 MemberBean 지정(옵션)
	public Vector<TravelBean> getListMember() {

		// DB연결 실행 공식
		Connection con = null; // DB연결 객체]
		PreparedStatement pstmt = null; // sql 문 만드는 객체
		ResultSet rs = null; // select문 실행 결과값 리턴 객체
		String sql = null;
		Vector<TravelBean> vlist = new Vector<TravelBean>();
		try {
			// pool 객체에서 빌려옴
			con = pool.getConnection();
			// sql문 선언
			sql = "select MAIN_IMG_NORMAL from travel where uc_seq = ?";
			// DB에 실행하기 위해 pstmt 문 생성
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// DB 실행 후 결과값 리턴(DB값을 자바로 가져옴)
			while (rs.next()/* 현재 커서에서 다음 커서로 이동 */) {
				TravelBean bean = new TravelBean();
				bean.setMAIN_IMG_THUMB(rs.getString("MAIN_IMG_THUMB"));
		
				// 레코드를 저장시킨 빈즈를 Vector에 저장
				vlist.addElement(bean);

			} // --While
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// con은 반납, pstmt이랑 rs는 close 해야함.
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}

	// 레코드 한개 가져오기
	public TravelBean getTravel(String MAIN_IMG_THUMB) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		TravelBean bean = new TravelBean();

		try {
			con = pool.getConnection();
			sql = "select * from travel where uc_seq = ?";
			// 매개변수 idx를 첫번째 물음표에 셋팅
			pstmt = con.prepareStatement(sql); // 실행
			pstmt.setString(1, MAIN_IMG_THUMB); // 커리문 완성
			rs = pstmt.executeQuery(); // 실행된 값을 받음,
			if (rs.next()) {
				bean.setMAIN_IMG_THUMB(rs.getString("MAIN_IMG_THUMB"));
	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return bean;
	}
}
