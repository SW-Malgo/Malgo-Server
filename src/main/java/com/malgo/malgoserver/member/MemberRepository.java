package com.malgo.malgoserver.member;

import java.util.Optional;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

	private final EntityManager em;

	public Member save(Member member) {
		em.persist(member);
		return member;
	}

	public Member findOne(Long id) {
		return em.find(Member.class, id);
	}

	public String remove(Member member) {
		em.remove(member);
		return member.getCertificationId();
	}

	public Optional<Member> findByCertificationId(String certificationId) {
		if (certificationId == null) return Optional.empty();

		return em
				.createQuery(
						"select m from Member m where m.certificationId = :certificationId", Member.class)
				.setParameter("certificationId", certificationId)
				.getResultList()
				.stream()
				.findFirst();
	}
}
