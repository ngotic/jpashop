package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name="delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded // 내장타입이다.
    private Address address;

    @Enumerated(EnumType.STRING) // Enum 타입은 @Enumerated을 넣어야 한다.
    private DeliveryStatus status; // READY, COMP
}
