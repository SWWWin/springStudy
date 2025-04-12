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

            //저장
            Team team = new Team();
            team.setName("TeamA");
            //team.getMembers().add(member);
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            //member.changeTeam(team); //**
            em.persist(member);

            //team.getMembers().add(member); //** <- 메서드에 넣어 두면 편하다

            team.addMember(member);
            em.flush();
            em.clear();

            Team findTeam = em.find(Team.class, team.getId()); //1차 캐시
            List<Member> mebers = findTeam.getMembers();

            for(Member m : mebers) {
                System.out.println("m = " + m.getUsername());
            }

            tx.commit();
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
