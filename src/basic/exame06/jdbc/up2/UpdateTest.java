package basic.exame06.jdbc.up2;


/* SubjectDao 사용 
 */
public class UpdateTest {

	public static void main(String[] args) throws Throwable {

		SubjectDao dao = new SubjectDao();
		SubjectVo subject = new SubjectVo();
		
		subject.no = 106;
		subject.title = "친절한 용범C";
		subject.description = "기압골의 영향으로 12일 오후에 남부지방과 제주도에서 비가 시작되어 13일에는 전국에 비가 오겠고";
		System.out.println("변경 성공!");
		
		dao.update(subject);
	}

}












