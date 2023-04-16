package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// Repository가 Entity 같은 것을 찾아주는 애들이다. > DAO와 비슷한것이라고 보면 된다.
@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager em;

    public Long save(Member member){
        // 저장하는 코드다.
        em.persist(member);
        return member.getId();
        // id만 리턴한다. 커맨드랑 쿼리랑 분리한다의 원칙에 의해
        // 그리고 id만 있으면 조회 가능하니까
    }
    public Member find(Long id) {
        return em.find(Member.class, id);
    }
}
