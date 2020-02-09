package jpabook.demo;


import com.querydsl.jpa.impl.JPAQuery;
import jpabook.demo.domain.Member;

import javax.persistence.*;
import java.util.List;

import static jpabook.demo.domain.QMember.member;


public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            queryDSL(emf);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }

    private static void queryDSL(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        Member member = new Member("kang", 23);
        em.persist(member);

        //queryDSL 추가해야함.
    }

//    /** Criteria */
//    private static void logic(EntityManager em) {
//
//        Member member = new Member("kang", 23);
//        em.persist(member);
//
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//
//        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
//
//        Root<Member> m = cq.from(Member.class);
//        cq.select(m);
//
//        TypedQuery<Member> query = em.createQuery(cq);
//        List<Member> members = query.getResultList();
//
//        for (Member member1 : members) {
//            System.out.println(member1.getName());
//        }
//    }
}


//    private static void logic(EntityManager em) {
//
//        Member member = new Member("kang", 23);
//        em.persist(member);
//
//        List<Member> resultList = em.createNamedQuery("Member.findByName", Member.class)
//                .setParameter("name", "kang")
//                .getResultList();
//
//        for (Member member1 : resultList) {
//            System.out.println(member1.getName());
//        }
//


//        TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m ORDER BY m.name DESC", Member.class);
//
//        query.setFirstResult(10);
//        query.setMaxResults(20);
//        query.getResultList();
//    }
//}

//    private static void logic(EntityManager em) {
//
//        Member member = new Member("kang", 23);
//        em.persist(member);
//
//        TypedQuery<UserDto> query = em.createQuery("SELECT new jpabook.demo.dto.UserDto(m.name, m.age) FROM Member m", UserDto.class);
//
//        List<UserDto> resultList = query.getResultList();
//
//        for (UserDto userDto : resultList) {
//            System.out.println(userDto);
//        }
//
//    }
//}

//    private static void logic(EntityManager em) {
//
//        Member member = new Member("kang", 23);
//        em.persist(member);
//
//        String name = "kang";
//        TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m where m.name = :name", Member.class);
//        query.setParameter("name", name);
//        List<Member> members = query.getResultList();
//        for (Member member1 : members) {
//            System.out.println(member1);
//        }
//
//        List<Object[]> resultList = em.createQuery("SELECT m.name, m.age FROM Member m")
//                .getResultList();
//
//        for (Object[] row : resultList) {
//            String username = (String) row[0];
//            Integer age = (Integer) row[1];
//
//            System.out.println(username);
//            System.out.println(age);
//        }
//    }
//}

//    private static void logic(EntityManager em) {
//
//        Member member = new Member("kang", 23);
//        em.persist(member);
//
//        Member targetMember = em.find(Member.class, 1L);
//        System.out.println("targetMember = " + targetMember.getName() + ", age= " + member.getAge());
//
//        List<Member> members = em.createQuery("select m from Member m", Member.class)
//                .getResultList();
//
//        System.out.println("members.size = " + members.size());
//
//        /** JPQL + TypeQuery */
//        TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m" , Member.class);
//        List<Member> resultList = query.getResultList();
//        for (Member member1 : resultList) {
//            System.out.println("member1 = " + member1.getName());
//        }
//
//        /** JPQL + Query */
//        Query query1 = em.createQuery("SELECT m.name, m.age FROM Member m" , Member.class);
//        List resultList1 = query1.getResultList();
//        for (Object o : resultList1) {
//            Object[] result = (Object[]) o;
//            System.out.println("username " + result[0]);
//            System.out.println("age " + result[1]);
//        }
//
//        String name ="kang";
//
//    }
//}