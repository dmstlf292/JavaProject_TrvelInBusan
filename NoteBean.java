package tib;

//빈즈네이밍 : 테이블명+Bean
//빈즈 : 레코드 (한줄) 단위의 데이터 덩어리, 집합군
public class NoteBean {
	
	private int no;
	private String rid;
	private String sid;
	private String title;
	private String note;
	private String ndate;
	private String modea;

						
	public int getNo() {
		return no;
	}
								
	public void setNo(int no) {
		this.no = no;
	}
	
	public String getRid() {
		return rid;
	}
	public void setRid(String name) {
		this.rid = rid;
	}
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getNdate() {
		return ndate;
	}
	public void setNdate(String ndate) {
		this.ndate = ndate;
	}
	
	
	public String getModea() {
		return modea;
	}
	public void setModea(String modea) {
		this.modea = modea;
	}

	
}
