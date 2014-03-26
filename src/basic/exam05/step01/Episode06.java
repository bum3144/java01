package basic.exam05.step01;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* BufferedInputStream/buggeredOutputStream
 * - 파일을 읽을 때 1 바이트씩 읽는 것 보다 왕창 읽는 것이 더 빠르다.
 * - 파일 읽기 시간 = data seek time + data transfer time
 * => data seek time: HDD 해더를 움직여 데이터가 있는 트랙으로 이동한 후
 * 										트랙이 돌 때 섹터를 찾는 것 까지의 시간
 * 예 ) 1byte 읽는데 걸리는 시간 = data seek time(예: 0.0085초)
 * 																+ data transfer time(예: 0.000000003초)
 */
public class Episode06 {

	public static void main(String[] args) throws Exception {
		// BufferedInputStream 의 사용 + buf 사용
		FileInputStream in = new FileInputStream("D:/javaide/eclipse-jee-kepler-SR1-win32.zip");
		BufferedInputStream in2 = new BufferedInputStream(in);
		
		byte[] buf = new byte[1024];
		int len = 0;	 // 읽어들인 바이트 수
		int b;
		int count = 0;
		long startTime = System.currentTimeMillis();
		while((b = in2.read(buf)) != -1){
			if((++count % 10000) == 0){
				System.out.print(".");
				count = 0;
			}
		}
		long duration = System.currentTimeMillis() - startTime;
		System.out.println("경과된 시간(밀리초) =" + duration);
		
		in2.close();
		in.close();
	}


	public static void main05(String[] args) throws Exception {
		// BufferedInputStream 의 사용
		FileInputStream in = new FileInputStream("D:/javaide/eclipse-jee-kepler-SR1-win32.zip");
		BufferedInputStream in2 = new BufferedInputStream(in);
		

		int b;
		int count = 0;
		long startTime = System.currentTimeMillis();
		while((b = in.read()) != -1){
			if((++count % 1000000) == 0){
				System.out.print(".");
				count = 0;
			}
		}
		long duration = System.currentTimeMillis() - startTime;
		System.out.println("경과된 시간(밀리초) =" + duration);
		
		in2.close();
		in.close();
	}



	public static void main04(String[] args) throws Exception {
		// 8192바이트씩 데이터 읽기
		FileInputStream in = new FileInputStream("D:/javaide/eclipse-jee-kepler-SR1-win32.zip");

		byte[] buf = new byte[8192];	// 보통 버퍼의 크기를 1024 ~ 8192 정도로 설정
		int len = 0;
		int count = 0;
		long startTime = System.currentTimeMillis();
		while((len = in.read(buf)) != -1){
			if((++count % 100) == 0){
				System.out.print(".");
				count = 0;
			}
		}
		long duration = System.currentTimeMillis() - startTime;
		System.out.println("경과된 시간(밀리초) =" + duration);
		in.close();
	}


	public static void main03(String[] args) throws Exception {
		// 1바이트씩 데이터 읽기
		FileInputStream in = new FileInputStream("D:/javaide/eclipse-jee-kepler-SR1-win32.zip");

		int b;
		int count = 0;
		long startTime = System.currentTimeMillis();
		while((b = in.read()) != -1){
			if((++count % 1000000) == 0){
				System.out.print(".");
				count = 0;
			}
		}
		long duration = System.currentTimeMillis() - startTime;
		System.out.println("경과된 시간(밀리초) =" + duration);
		in.close();
	}
	
	
	public static void main02(String[] args) throws Exception {
		// 데이터 읽기
		FileInputStream in = new FileInputStream("student3.dat");
		DataInputStream in2 = new DataInputStream(in);
		
		String name = in2.readUTF();
		int kor = in2.readInt();
		int eng = in2.readInt();
		int math = in2.readInt();
		int sum = in2.readInt();
		
		System.out.println(name);
		System.out.println(kor);
		System.out.println(eng);
		System.out.println(math);
		System.out.println(sum);
		
		in2.close();
		in.close();
	}
	
	
	public static void main01(String[] args) throws Exception {
		// 데이터 출력 
		FileOutputStream out = new FileOutputStream("student3.dat");
		DataOutputStream out2 = new DataOutputStream(out);
		
		String name = "홍길동";
		int kor = 90, eng = 100, math = 80, sum = 270;

		out2.writeUTF(name); 	
		out2.writeInt(kor);			
		out2.writeInt(eng);			
		out2.writeInt(math);	
		out2.writeInt(sum);		
		
		out2.close();
		out.close();
	}

}









