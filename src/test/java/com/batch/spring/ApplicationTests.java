//package com.batch.spring;
//
//import com.batch.spring.domain.Member;
//import com.batch.spring.domain.QMember;
//import com.batch.spring.domain.Team;
//import com.querydsl.core.QueryResults;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.transaction.annotation.Transactional;
//
//
//import javax.persistence.EntityManager;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest
//@Transactional
//class ApplicationTests {
//
//
//    @Autowired
//    EntityManager em;
//
//    JPAQueryFactory queryFactory;
//
//    @BeforeEach
//    public void before() throws Exception {
//        queryFactory = new JPAQueryFactory(em);
//
//        //given
//        Team teamA = new Team("teamA");
//        Team teamB = new Team("teamB");
//        em.persist(teamA);
//        em.persist(teamB);
//
//        Member member1 = new Member("member1", 10, teamA);
//        Member member2 = new Member("member2", 20, teamA);
//
//        Member member3 = new Member("member3", 30, teamB);
//        Member member4 = new Member("member4", 40, teamB);
//        em.persist(member1);
//        em.persist(member2);
//        em.persist(member3);
//        em.persist(member4);
//
//        em.flush();
//        em.clear();
//
//        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
//        for (Member member : members) {
//            System.out.println("member = " + member);
//            System.out.println("member.getTeam() = " + member.getTeam());
//        }
//
//    }
//
//    @Test
//    public void startQuerydsl() throws Exception {
//        //member1을 찾아라.
//        QMember m = QMember.member;
//        Member findMember = queryFactory.select(m)
//                .from(m)
//                .where(m.username.eq("member1"))//파라미터 바인딩 처리
//                .fetchOne();
//        assertThat(findMember.getUsername()).isEqualTo("member1");
//    }
//
//    @Test
//    public void searchAndParam() throws Exception {
//        //given
//        QMember member = QMember.member;
//        Member findMember = queryFactory
//                .selectFrom(member)
//                .where(
//
//                        member.username.eq("member1"),
//                        member.age.eq(10)
//
//                        //같은 방식   and or 쓰냐 안쓰냐 차이
////                        member.username.eq("member1")
////                        .and(member.age.eq(10))
//
//                )
//                .fetchOne();
//        assertThat(findMember.getUsername()).isEqualTo("member1");
//    }
//
//
//    @Test
//    public void resultFetchTest() throws Exception {
//        QMember member = QMember.member;
//
//        //given
//        List<Member> fetch = queryFactory
//                .selectFrom(member)
//                .fetch();
//
//        //.NonUniqueResultException 에러 발생 expect
////        Member fetchOne = queryFactory
////                .selectFrom(QMember.member)
////                .fetchOne();
//
//
//        Member fetchFirst = queryFactory
//                .selectFrom(QMember.member)
//                .fetchFirst();
//
//        QueryResults<Member> results = queryFactory
//                .selectFrom(member)
//                .fetchResults();
//
//        results.getTotal();
//        List<Member> content = results.getResults();
//
//        long total = queryFactory
//                .selectFrom(member)
//                .fetchCount();
//
//
//    }
//    /**
//     * 회원 정렬 순서
//     * 1. 회원 나이 내림차순(desc)
//     * 2. 회원 이름 올림차순(asc)
//     * 단 2에서 회원 이름이 없으면 마지막에 출력(nulls last)
//     *
//     * @throws Exception
//     */
//    @Test
//    public void sort() throws Exception {
//        QMember member = QMember.member;
//        //given
//        em.persist(new Member(null, 100));
//        em.persist(new Member("member5", 100));
//        em.persist(new Member("member6", 100));
//
//        List<Member> result = queryFactory
//                .selectFrom(member)
//                .where(member.age.eq(100))
//                .orderBy(member.age.desc(), member.username.asc().nullsLast())
//                .fetch();
//
//        Member member5 = result.get(0);
//        Member member6 = result.get(1);
//        Member memberNull = result.get(2);
//        assertThat(member5.getUsername()).isEqualTo("member5");
//        assertThat(member6.getUsername()).isEqualTo("member6");
//        assertThat(memberNull.getUsername()).isNull();
//    }
//}
