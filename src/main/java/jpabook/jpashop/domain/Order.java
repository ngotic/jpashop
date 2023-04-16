package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;


import javax.persistence.*; // 이렇게 해놓고 코딩하는게 좋다.
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders") // 이렇게 안적어주면 그냥 order가 되버린다.
@Getter @Setter
public class Order {
    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;
    @ManyToOne // Order의 입장에서 member는 다대일
    @JoinColumn(name="member_id") // ★ 맵핑을 뭘로 할거냐? > FK 적어라
    private Member member; // order와 member는 다대1 관계다.
    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();
    @OneToOne
    @JoinColumn(name="delivery_id")
    private Delivery delivery;
    private LocalDateTime orderDate; // 주문시간 원래는 ★ Date쓰면 어노테이션
    // 해야하는데 LocalDateTime쓰면 hibernate가 알아서 지원해준다.
    @Enumerated(EnumType.STRING)
    private OrderStatus status; // 주문의 상태이다. enum으로 만든다 > [ ORDER, CANCEL ]
}
