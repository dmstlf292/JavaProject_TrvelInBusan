package tib;

//������̹� : ���̺��+Bean
//���� : ���ڵ� (����) ������ ������ ���, ���ձ�
public class MeetBean {

	private int didx; //ȸ��id
	private int dcode;//�����ڵ�(����)
	private String mtent; // ���� �� ����׷� �Ұ� �Է�

	
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

	
	
	public String getMtent() {//�׷�Ұ�����
		return mtent;
	}
	public void setMtent(String mtent) {
		this.mtent = mtent;
	}
	

}
