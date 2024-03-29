package jpabook.jpashop.domain;


import jpabook.jpashop.domain.item.Item;

import javax.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name="order_id") // 이쪽 한쪽해주면 이제 다른쪽 연결
    private Order order;

    private int orderPrice; // 주문 가격
    private int count; // 주문 수량

}
