package jpabook.jpashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter // lombok을 쓰니까 이렇게 넣은 것이다.
public class Member {

// 식별자를 ID에 맵핑을 해주고 GeneratedValue로 자동생성되게 만든다.
    @Id @GeneratedValue
    private Long id; // PK로 잡고
    private String username;

}
