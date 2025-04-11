package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager(); // 모든 활동을 할 때마다 엔티티 매니저를 작동시켜야만 한

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{

            Member member = new Member();

            member.setUsername("C");

            em.persist(member);
            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
