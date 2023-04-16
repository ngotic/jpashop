package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.jni.Address;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter // Lombok으로 getter, setter처리
public class Member {
    @Id
    @GeneratedValue
    @Column(name="member_id") // pk이름이 member_id이다. 그래서! 컬럼명을 준다. 그냥 두면 id이름 그래도 된다.
    private Long id;

    private String name;

    @Embedded
    private Address address; // 이렇게 내장 타입을 쓸 때는 한쪽에 Embedded나 Embeddable 하나만 있어도 된다.

    // 객체는 그냥 참조를 못한다.//member 라는것은 객체이름을 쓰는 것이다.
    @OneToMany(mappedBy = "member") // table상 여기 칼럼이 없는데도 코딩을 하네?
    private List<Order> orders = new ArrayList<>();
    // 하나의 회원이 여러개의 상품주문
}
