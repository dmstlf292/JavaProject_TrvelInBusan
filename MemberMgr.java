package tib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

//DB와 연동에 필요한 모든 기능을 객체화 시킨 클래스
public class MemberMgr {

	// DB 연결 객체 10개 만들어 놓음. pool이
	private DBConnectionMgr pool;

	public MemberMgr() {
		pool = DBConnectionMgr.getInstance();// 인스턴스 방식으로 객체를 생성해서 가져옴
	}

	// <리스트>
	// 리스트 :리스트는 memberSwing에서 볼수있고 입력버튼을 누르면 Signin클래스를 호출
	// 제네릭 : Vector에 저장되는 타입을 MemberBean 지정(옵션-해도되고 안해도되고)
	public Vector<MemberBean> getListMember() {
		// DB연결 실행 공식
		Connection con = null;// DB연결 객체
		PreparedStatement pstmt = null;// sql문 만드는 객체
		ResultSet rs = null;// select문 실행 결과값 리턴 객체
		String sql = null;// prepareStatement변수명이 sql로 되어 있기 때문에 sql로 선언했음 다른 이름으로 선언해도 됌
		Vector<MemberBean> vlist = new Vector<MemberBean>();// 결과값 받아오는 백타
		try {
			// pool 객체에서 빌려옴
			con = pool.getConnection();
			// sql문 선언
			sql = "select * from member order by idx";// 모든레코드를 내림차순으로 가져옴
			// DB에 실행하기 위해 pstmt문 생성
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();// DB 실행 후 결과값 리턴,rs가 실행된 sql문의 결과값을 가리킴
			while (rs.next()/* 현재 cursor에서 다음 cursor로 이동, 사이에 레코드가 있으면 true */) {
				MemberBean bean = new MemberBean();
				bean.setIdx(rs.getInt("idx"));
				bean.setId(rs.getString("id"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setBirth(rs.getString("birth"));
				bean.setPassword(rs.getString("password"));
				bean.setGender(rs.getString("gender"));
				bean.setPhone(rs.getString("phone"));
				bean.setImg(rs.getString("img"));
				// 레코드를 저장시킨 빈즈를 Vector에 저장
				vlist.addElement(bean);
			} // ---while
		} catch (Exception e) {
			e.printStackTrace();// 에러 내용을 보여준다.
		} finally {
			// con은 반납, pstmt이랑 rs는 close 해야함.
			pool.freeConnection(con, pstmt, rs);
		}
		return vlist;
	}

	// id와 비밀번호 비교 같은 값 가져오기
	public MemberBean getMember(String id, String ps) {// 규칙에 위반되었다는데 왜 위반 되었는지 모르겠음
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MemberBean bean = new MemberBean();
		try {
			con = pool.getConnection();// pool에서 객체빌려옴
			// sql = "select * from member where id=? and password = ? ";//쿼리문 미완성
			sql = "select * from member where  id=? and password= ? ";
			// 매개변수 id를 첫번째 ?에 세팅
			pstmt = con.prepareStatement(sql);// sql문 만듬
			pstmt.setString(1, id);
			pstmt.setString(2, ps);
			rs = pstmt.executeQuery();// 실행후 결과값 가리킴
			// pstmt.setString(2, id);//첫번재 물음표에 id를 넣는다.쿼리문 완성

			if (rs.next()) {
				bean.setIdx(rs.getInt(1));// 테이블 스키마 인텍스(컬럼 순서 번호 1부터 출발),컬럼명 넣어도 됌
				bean.setId(rs.getString(2));// 2=id
				bean.setName(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setBirth(rs.getString(5));
				bean.setPassword(rs.getString(6));
				bean.setGender(rs.getString(7));
				bean.setPhone(rs.getString(8));
				bean.setImg(rs.getString(9));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);// 커넥션 반납
		}
		return bean;
	}

	public MemberBean getMember(String id) {// 규칙에 위반되었다는데 왜 위반 되었는지 모르겠음
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MemberBean bean = new MemberBean();
		try {
			con = pool.getConnection();// pool에서 객체빌려옴
			// sql = "select * from member where id=? and password = ? ";//쿼리문 미완성
			sql = "select * from member where  id=? ";
			// 매개변수 id를 첫번째 ?에 세팅
			pstmt = con.prepareStatement(sql);// sql문 만듬
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();// 실행후 결과값 가리킴
			// pstmt.setString(2, id);//첫번재 물음표에 id를 넣는다.쿼리문 완성

			if (rs.next()) {
				bean.setIdx(rs.getInt(1));// 테이블 스키마 인텍스(컬럼 순서 번호 1부터 출발),컬럼명 넣어도 됌
				bean.setId(rs.getString(2));// 2=id
				bean.setName(rs.getString(3));
				bean.setEmail(rs.getString(4));
				bean.setBirth(rs.getString(5));
				bean.setPassword(rs.getString(6));
				bean.setGender(rs.getString(7));
				bean.setPhone(rs.getString(8));
				bean.setImg(rs.getString(9));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);// 커넥션 반납
		}
		return bean;
	}

	/*
	 * //< 레코드 한개 가져오기-수정하기전에 가져와야함으로 > public MemberBean getMember(int idx) {
	 * 
	 * //자동생성기능추가:window-> preference - > java->editor->templates->new->name :
	 * 코딩하느단어 //description:설명하는 부분으로 중요하지 않음 , pattern : 실행하는 코드 -> //appay and
	 * close버튼 클릭 Connection con = null; PreparedStatement pstmt = null; ResultSet
	 * rs = null; String sql = null; MemberBean bean = new MemberBean(); try { con =
	 * pool.getConnection();//pool에서 객체빌려옴 sql =
	 * "select * from member where idx=?";//쿼리문 미완성 //매개변수 idx를 첫번째 ?에 세팅 pstmt =
	 * con.prepareStatement(sql);//sql문 만듬 pstmt.setInt(1, idx);//첫번재 물음표에 idx를
	 * 넣는다.쿼리문 완성 rs = pstmt.executeQuery();//실행후 결과값 가리킴 if(rs.next()) {
	 * bean.setIdx(rs.getInt(1));//테이블 스키마 인텍스(컬럼 순서 번호 1부터 출발),컬럼명 넣어도 됌
	 * bean.setId(rs.getString(2));//2=id bean.setName(rs.getString(3));
	 * bean.setEmail(rs.getString(4)); bean.setBirth(rs.getString(5));
	 * bean.setPassword(rs.getString(6)); bean.setGender(rs.getString(7));
	 * bean.setPhone(rs.getString(8)); bean.setImg(rs.getString(9)); } } catch
	 * (Exception e) { e.printStackTrace(); } finally { pool.freeConnection(con,
	 * pstmt, rs);//커넥션 반납 } return bean; }
	 */

	// 입력
	public boolean insertMember(MemberBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "insert into member(idx,id,name,email,birth,password,gender,phone,img)"
					+ "values(seqmbr.nextval,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getEmail());
			pstmt.setString(4, bean.getBirth());
			pstmt.setString(5, bean.getPassword());
			pstmt.setString(6, bean.getGender());
			pstmt.setString(7, bean.getPhone());
			pstmt.setString(8, bean.getImg());
			int cnt = pstmt.executeUpdate();// insert,update,delete
			if (cnt == 1)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}

	// 수정

	public boolean updateMember(MemberBean bean) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "update member set id=?, name=?, email=?, birth=?, password=?, gender=?, phone=?, img=? "
					+ "where idx =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getId());
			pstmt.setString(2, bean.getName());
			pstmt.setString(3, bean.getEmail());
			pstmt.setString(4, bean.getBirth());
			pstmt.setString(5, bean.getPassword());
			pstmt.setString(6, bean.getGender());
			pstmt.setString(7, bean.getPhone());
			pstmt.setString(8, bean.getImg());
			pstmt.setInt(9, bean.getIdx());
			int cnt = pstmt.executeUpdate();// insert,update,delete
			if (cnt == 1)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}

	// 삭제
	public boolean deleteMember(int idx) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		boolean flag = false;
		try {
			con = pool.getConnection();
			sql = "delete from tblMember where idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			int cnt = pstmt.executeUpdate();
			if (cnt == 1)
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return flag;
	}
}
