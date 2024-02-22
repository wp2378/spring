package ioc;

/**
 * ProductService는 상품정보를 등록, 조회, 수정한다.
 * ProductService는 상품정보를 등록, 조회, 수정하기 위해서 ProductDao인터페이스를 구현한 객체가 필요하다.
 * @author jhta
 *
 */
public class ProductService {

	// 기존에 쓰던 객체생성방법
	// ProductJdbcDao dao1 = new ProductJdbcDao(); 
	// ProductDao dao2 = new ProductJdbcDao(); 
	
	// 스프링에서 쓰는 객체생성방법
	private ProductDao dao;
	
	public void setDao(ProductDao dao) {
		System.out.println("조립되는 객체: " + dao);
		this.dao = dao;
	}
	
	public void 신규상품등록() {
		dao.insertProduct();
	}
	
	public void 상품상세정보조회() {
		dao.getProduct();
	}
	
	public void 상품정보수정() {
		dao.updateProduct();
	}
}
