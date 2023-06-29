package com.malgo.malgoserver.hit;

import com.malgo.malgoserver.keyword.Keyword;
import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class HitRepository {
	private final EntityManager em;

	public Keyword save(Keyword hit) {
		em.persist(hit);
		return hit;
	}

	public List<Keyword> findAll() {
		return em.createQuery("select h from Keyword h", Keyword.class).getResultList();
	}

	public Keyword findOne(Long id) {
		return em.find(Keyword.class, id);
	}

	public List<Hit> findHitKeywords(int limit) {
		return em.createQuery("select h from Hit h order by h.count desc", Hit.class)
				.setMaxResults(limit)
				.getResultList();
	}
}
