package jpabook.jpashop;



import jakarta.persistence.*;
import jpabook.jpashop.domain.Order;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager(); // 모든 활동을 할 때마다 엔티티 매니저를 작동시켜야만 한

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Order order = em.find(Order.class, 1L);
            Long memberId = order.getMember().getId();

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
