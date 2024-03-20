package com.example.user;

import com.example.common.BaseDateTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*
 * @Entity
 * 		- 이 클래스가 데이터베이스의 테이블과 매핑되는 엔티티 클래스임을 나타낸다.
 * 		- 엔티티는 데이터의 집합이다. 보통 테이블에 저장되는 하나의 레코드를 말한다.
 * 		- 엔티티는 저장되고, 관리할 대상이 되는 데이터다.
 * 
 * @table
 * 		- ddl-auto 설정으로 테이블을 자동으로 생성할 때 지정된 이름으로 테이블을 생성한다.
 * 		- 지정하지 않으면 클래스이름과 동일한 테이블을 생성한다.
 * 
 * @Id
 * 		- 해당 프로퍼티가 엔티티를 식별하는 값을 포함하고 있는 프로퍼티임을 나타낸다.
 *		- 이 어노테이션이 지정된 프로퍼티는 기본키 컬럼의 값을 표현하는 프러퍼티다. 
 * 
 * @GeneratedValue
 * 		- 기본키 값을 생성하는 방법을 지정하는 어노테이션이다.
 * 		- IDENTITY
 * 				+ 기본키 생성을 데이터베이스에 위임하는 방식이다.
 * 				+ id값을 따로 할당하지 않아도 데이터베이스가 자동으로 auto_increment를 사용하여 기본키값을 생성한다.
 * 				+ mysql, mariadb, h2 데이터베이스에서 주로 사용한다.
 * 		- SEQUENCE
 * 				+ 별도의 Sequence 객체를 이용해서 일련번호를 발행하고, 그 값을 기본키 값으로 사용하는 방식이다.
 * 				+ oracle  데이터베이스에서 주로 사용한다.
 * 				+ @SequenceFenerator 어노테이션으로 해당 엔티티에서 사용할 시퀸스를 설정한다.
 * 		- TABLE
 * 				+ 기본키 값을 관리하는 별도의 테이블을 사용하는 방법이다.
 * 				+ 모든 데이터베이스에 사용가능한 방법이다. 
 * 		- AUTO
 * 				+ default 기본키 생성 방식이다.
 * 				+ 데이터베이스에 따라 적절한 기본키를 자동으로 생성한다.
 */

@Entity
@Table(name = "board_users")
@SequenceGenerator(
	name = "user_pk_generator",
	sequenceName = "board_users_seq",
	initialValue = 1,
	allocationSize = 1
)
@Getter
@Setter
public class User extends BaseDateTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_pk_generator")
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String name;
	
	
	@Column(nullable = false, unique = true)
	private String email;
	
	
	@Column(nullable = false)
	private String tel;
	
	@Enumerated(EnumType.STRING)
	private UserRole userRole;
}
