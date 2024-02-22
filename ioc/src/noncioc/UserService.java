package noncioc;

public class UserService {

	// UserService는 자신이 사용할 객체(의존하는 객체)를 직접 생성했다.(직접 결정했다.)
	// 확장성이 떨어짐
	//UserJdvcDao dao = new UserJdvcDao();
	
	UserMybatisDao dao = new UserMybatisDao();
	
	public void 회원가입기능() {
		dao.insertUser();
	}
	
	public void 내정보조회기능() {
		dao.getUser();
	}
}
