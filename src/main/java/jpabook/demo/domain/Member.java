package jpabook.demo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
//@NamedQuery(
//        name = "Member.findByName",
//        query = "select m from Member m where m.name = :name"
//)

@NamedQueries({
        @NamedQuery(
                name = "Member.findByName",
                query = "select m from Member m where m.name = :name"),
        @NamedQuery(
                name = "Member.count",
                query = "select count(m) from Member m"
        )
})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Integer age;

    public Member(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
