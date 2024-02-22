package ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		// ClassPathXmlApplicationContext 컨테이너의 역할
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
		// getBean context.xml에서 bean을 꺼내오는 메소드
		// 매개변수는 
		ProductService productService = ctx.getBean(ProductService.class);
		
		productService.신규상품등록();
		productService.상품상세정보조회();
		productService.상품정보수정();
	}
}
