package tib;

//빈즈네이밍 : 테이블명+Bean
//빈즈 : 레코드 (한줄) 단위의 데이터 덩어리, 집합군
public class MdesignBean {

	private int didx; 
	private int dcode;
	private int tidx; 

	
	
	public int getDidx() {//회원Idx
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

	
	
	public int getTidx() {//그룹소개내용
		return tidx;
	}
	public void setTidx(int tidx) {
		this.tidx = tidx;
	}
}
