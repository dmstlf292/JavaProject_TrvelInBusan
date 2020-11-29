package tib;

//빈즈네이밍 : 테이블명+Bean
//빈즈 : 레코드 (한줄) 단위의 데이터 덩어리, 집합군
public class MeetBean {

	private int didx; //회원id
	private int dcode;//여행코드(복합)
	private String mtent; // 본인 및 여행그룹 소개 입력

	
	public int getDidx() {//Didx
		return didx;
	}
	public void setDidx(int didx) {
		this.didx = didx;
	}
	
	public int getDcode() {//Dcode
		return dcode;
	}
	public void setDcode(int dcode) {
		this.dcode = dcode;
	}

	
	
	public String getMtent() {//그룹소개내용
		return mtent;
	}
	public void setMtent(String mtent) {
		this.mtent = mtent;
	}
	

}
