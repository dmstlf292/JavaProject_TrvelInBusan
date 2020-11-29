package tib;

//빈즈네이밍 : 테이블명+Bean
//빈즈 : 레코드 (한줄) 단위의 데이터 덩어리, 집합군
public class CommentsBean {

	private int widx; 
	private int idx;
	private String wdate; 
	private String ctent; 

	
	
	public int getWidx() {
		return widx;
	}
	public void setWidx(int widx) {
		this.widx = widx;
	}
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	
	public String getWdate() {//그룹소개내용
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	
	public String getCtent() {//그룹소개내용
		return ctent;
	}
	public void setCtent(String ctent) {
		this.ctent = ctent;
	}
	
}
	
	

