package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            Member member = em.find(Member.class, 1L);
//            printMember(member);
            // printMemberAndTeam(member);

            Member member1 = new Member();
            member1.setUsername("hello1");
            em.persist(member1);


            Member member2 = new Member();
            member2.setUsername("hello2");
            em.persist(member2);
            em.flush();
            em.clear();

            Member m1 = em.find(Member.class, member1.getId());
            System.out.println("m1.getClass() = " + m1.getClass());

            Member reference = em.getReference(Member.class, member1.getId());
            System.out.println("reference.getClass() = " + reference.getClass());

            System.out.println("(m1 == reference) = " + (m1 == reference));

//            Member findMember = em.find(Member.class, member1.getId());
            Member findMember = em.getReference(Member.class, member1.getId());
            System.out.println("----------------------------------");
            System.out.println("before findMember = " + findMember.getClass());
//            System.out.println("findMember.getId() = " + findMember.getId());
            System.out.println("findMember.getUsername() = " + findMember.getUsername());
            System.out.println("findMember.getUsername() = " + findMember.getUsername());
            System.out.println("after findMember = " + findMember.getClass());


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void printMember(Member member) {
        System.out.println("member.getUsername() = " + member.getUsername());
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUsername();
        System.out.println("username = " + username);

        Team team = member.getTeam();
        System.out.println("team = " + team);

    }
}
