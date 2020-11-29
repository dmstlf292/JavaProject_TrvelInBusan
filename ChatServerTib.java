package tib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServerTib {

	Vector<CThread2> vc;
	ServerSocket server;
	int port = 8002;

	public ChatServerTib() {
		try {
			server = new ServerSocket(port);
			vc = new Vector<CThread2>();
		} catch (Exception e) {
			System.err.println("Error in Server");
			e.printStackTrace();
			System.exit(1);// ���������� ����
		}
		System.out.println("****************************");
		System.out.println("Ŭ���̾�Ʈ�� ������ ��ٸ��� �ֽ��ϴ�.");
		System.out.println("****************************");
		try {
			while (true) {
				Socket sock = server.accept();
				CThread2 ct = new CThread2(sock);
				ct.start();
				vc.add(ct);
			}
		} catch (Exception e) {
			System.err.println("Error in Socket");
			e.printStackTrace();
		}
	}

	// ���ӵ� ��� Ŭ���̾�Ʈ���� �޼��� ����
	public void sendAllMessage(String msg) {
		for (int i = 0; i < vc.size(); i++) {
			CThread2 ct = vc.get(i);
			ct.sendMessage(msg);
		}
	}

	// Vector�� Client�� ����
	public void removeClient(CThread2 ct) {
		vc.remove(ct);
	}

	class CThread2 extends Thread {
		
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id = "�͸�";
		
		public CThread2(Socket sock) {
			try {
				this.sock = sock;
				in = new BufferedReader(
						new InputStreamReader(
								sock.getInputStream()));
				out = new PrintWriter(
						sock.getOutputStream(),true);
				System.out.println(sock+" ���ӵ�....");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				out.println("����Ͻ� ���̵� �Է��ϼ���.");
				while(true) {
					String line = in.readLine();
					if(line==null) break;
					else routine(line);// Ŭ���̾�Ʈ���� �޽��� ������� ���������� �˻��� ������ Ŭ���̾�Ʈ���� ������ ������ �ϰԲ� �޼ҵ� ���ٴ°�
				}
			} catch (Exception e) {
				//������ Client�� Vector���� �����Ѵ�.
				removeClient(this);
				System.err.println(sock+"["+id+"] ������...");
				//e.printStackTrace();
			}
			
		}
		//Client �� ���� ���۵� �������� �� data �м� �޼ҵ�
		public void routine(String line) {
			//CHAT:bbb;�����. //CHAT�� ��������, �ڿ��� ������(�������ݾȿ� ���� ������ ������)
			int idx = line.indexOf(':'); // ;�� �ƴ϶� : �̴�!!!!!
			String cmd=line.substring(0,idx);//CHAT
			String data=line.substring(idx+1);//bbb;�����.
			
			if(cmd.equals(ChatProtocolTib.ID)) {
				if(data!=null&&data.length()>0) {
					//ID:ȫ�浿
					id=data;
					//���ο� �����ڰ� �߰��� �Ǿ -> List ������
					sendAllMessage(ChatProtocolTib.CHATLIST+":"+getId());
					//���ο� ������ ȯ�� �޼���
					sendAllMessage(ChatProtocolTib.CHATALL+":"+"["+id+"] ���� ���� �Ͽ����ϴ�.");
				}
			}else if (cmd.equals(ChatProtocolTib.CHAT)) {
				//CHAT:bbb;�����.
				idx=data.indexOf(";");
				cmd=data.substring(0,idx);//bbb
				data=data.substring(idx+1);//�����
				//bbb CThread2�� ã�´�.
				CThread2 ct=findClient(cmd);
				if(ct!=null) {
					//bbb
					ct.sendMessage(ChatProtocolTib.CHAT+":"+"["+id+"(S)]" + data);
					//aaa(�߽� : ����)
					sendMessage(ChatProtocolTib.CHAT+":"+"["+id+"(S)]" + data);
				}else {
					//aaa 
					sendMessage(ChatProtocolTib.CHAT+":"+"["+cmd+"] �����ڰ� �ƴմϴ�." + data);
				}	
			}else if (cmd.equals(ChatProtocolTib.MESSAGE)) {
				//MESSAGE:bbb;������ ¥���OK?
				idx=data.indexOf(";");
				cmd=data.substring(0,idx);//bbb
				data=data.substring(idx+1);//������ ¥���OK?
				CThread2 ct=findClient(cmd);
				if(ct!=null) {
					//bbb���� ������ ������.
					ct.sendMessage(ChatProtocolTib.MESSAGE+":"+id+";"+data);
				}else {
					sendMessage(ChatProtocolTib.CHAT+":"+"["+cmd+"] �����ڰ� �ƴմϴ�." + data);
				}
			}else if (cmd.equals(ChatProtocolTib.CHATALL)) {
				//CHATALL:[aaa] ��� ȭ����!!!
				sendAllMessage(ChatProtocolTib.CHATALL+":"+"["+id+"]"+data);
			}
		}
		
		//�Ű������� ���� id������ CThread2�� ã��
		public CThread2 findClient(String id) {//����Ŭ������ ������
			CThread2 ct = null;//CThread2�� bbb�� �ȴ�.
			for (int i = 0; i < vc.size(); i++) {
				ct=vc.get(i);
				//ã�����ϴ� id�� ��ġ�ϸ� �ڿ� �ִ� ���� �˻� ���ʿ��ϴ�.
				if(ct.id.equals(id))
					break;
			}
			return ct;
		}
		
		//���ӵ� ��� id�� ����(�����ڴ� ; ex)aaa;bbb;ȫ�浿; ) �Ѵ�.
		///�̺κ� �߿�***************************************
		public String getIDs() {
			String ids="";
			for (int i = 0; i < vc.size(); i++) {
				CThread2 ct=vc.get(i);
				ids+=ct.id+";";
			}
			
			return ids;
		}
		
		public void sendMessage(String msg){
			out.println(msg);
		}
		
	}//---CThread2

	public static void main(String[] args) {
		new ChatServerTib();
	}
}
