package jpabook.demo;

import jpabook.demo.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            logic(em);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void logic(EntityManager em) {

        Member member = new Member("kang", 23);
        em.persist(member);

        Member targetMember = em.find(Member.class, 1L);
        System.out.println("targetMember = " + targetMember.getName() + ", age= " + member.getAge());

        List<Member> members = em.createQuery("select m from Member m", Member.class)
                .getResultList();

        System.out.println("members.size = " + members.size());
    }

}