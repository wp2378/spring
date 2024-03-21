package com.example.post;

import java.util.Set;

import com.example.common.BaseDateTimeEntity;
import com.example.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/*
 * @ManyToOne
 * 		- N:1(다대일)  연관관계를 표현하는 어노테이션이다.
 * 		- @ManyToOne 어노테이션이 붙어 있는 엔티티가 N이고, 반대 엔티티가 1이다.
 * 		  즉 Post엔티티가 N이고, User엔티티가 1이다.
 * 		- 가장 많이 사용되는 연관관계 표현 어노테이션이다.
 * 			ManyToMany 는 절대 쓸일이 없다
 */

@Entity
@Table(name="board_posts")
@SequenceGenerator(
	name = "post_pk_generator",
	sequenceName = "board_posts_seq",
	initialValue = 1000,
	allocationSize = 1
)
@Setter
@Getter
public class Post extends BaseDateTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_pk_generator")
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@ManyToOne // 연관관계 어노테이션 many는 자기 one은 연관있는 자식한테 설정한다.
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Column(nullable = false)
	private String content;	
	
	/*
	 *	양방향 연관관계 매핑
	 *		-양방향 연관관계 매핑은 두 객체가 서로 참조해야 하는 상황에서 정의하는 연관관계 매핑방식이다.
	 *		- 데이터베이스에서 테이블간의 관계는 단방향 매핑이 존재한다.
	 *		- 양방향 연관관계 매핑을 할때는 반드시 한쪽의 객체에 mappedBy 옵션을 설정해야 한다.
	 *
	 *		- 객체 입장에서는 참조 관계가 양방향이 되었으나, 데이터베이스 입장에서는 자식 테이블의 외래키만으로 관계설정이 충분하기 때문에, 추가적인 설정이 필요하다.
	 *		- mappedBy 옵션은 자신이 이 연관관계의 주인이 아님을 설정하는 것이다.
	 * 		- mappedBy 옵션에서는 반대쪽에 자신이 매핑되어 있는 필드명을 적으면 된다.
	 * 		- 연관관계의 주인은 1:N의 경우 N이 연관관계의 주인이다.즉, 외래키를 가지고 있는 쪽이 연관관계의 주인이다.
	 * 
	 * 양방향 연관관계 설정
	 *  	- 객체 입장에서 설정하는 연관관계 매핑이다.
	 */
	 
	 // CascadeType.REMOVE 테이블 삭제시 같이 사라짐
	@OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE) //mappedBy 연관관계의 주인이 누군지 알려주는 @어노테이션
	private Set<PostVoter> postVoters;
}
