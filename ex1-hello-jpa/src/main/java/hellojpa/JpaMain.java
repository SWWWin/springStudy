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
//            //Member findMember = em.find(Member.class, 1L);
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(5)
//                    .setMaxResults(8)
//                    .getResultList();
//            // 멤버 객체를 대상으로 테이블을 다 가지고 오라고 한다
//
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }


            //영속
            Member member = em.find(Member.class, 150L);
            member.setName("AAAAA");

            em.detach(member); //ejsms JPA에서 관리하지 않는다

            System.out.println("==============");
            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
