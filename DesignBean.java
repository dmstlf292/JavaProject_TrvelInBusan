package tib;

//빈즈네이밍 : 테이블명+Bean
//빈즈 : 레코드(한줄) 단위를 데이터 덩어리
public class DesignBean {

	private int dcode ;
	private int idx;
	private String period;
	private String ddate;
	private String area;
	private String dage;
	private String gender;
	private String nump;
	
	
	                 //getXxx
	public int getDcode() {
		return dcode;
	}                 
	                   //setXxx(타입 컬럼명)
	public void setDcode(int dcode) {
		this.dcode = dcode;
	}
	///////////////////////////
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
////////////////////////////////////////////	
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	/////////////////////////
	
	public String getDdate() {
		return ddate;
	}
	public void setDdate(String ddate) {
		this.ddate = ddate;
	}
    ////////////////////////////////
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	///////////////////////////////
	public String getDage() {
		return dage;
	}
	public void setDage(String dage) {
		this.dage = dage;
	}
	
	////////////////////////////////
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	////////////////////////////////////////////
	public String getNump() {
		return nump;
	}
	public void setNump(String nump) {
		this.nump = nump;
	}
}
