package jpabook.jpashop.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name ="ORDERS")//DB마다 되는 경우도 있고 안 되는 경우도 있기 때문에 복수로
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private Long id;


    private Member member;


    private LocalDateTime orderDate; //order_date, ORDER_DATE가 관례, springboot에서는 바꿔주는 것을 기본으로 한다

    @Enumerated(EnumType.STRING)
    private OrderStatus OrderStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public jpabook.jpashop.domain.OrderStatus getOrderStatus() {
        return OrderStatus;
    }

    public void setOrderStatus(jpabook.jpashop.domain.OrderStatus orderStatus) {
        OrderStatus = orderStatus;
    }
}

