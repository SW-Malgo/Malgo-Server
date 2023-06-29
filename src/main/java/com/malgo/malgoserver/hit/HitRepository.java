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

	public List<Object[]> findHitKeywords(int limit) {
		return em.createNativeQuery(
						"SELECT k.keyword, rank() OVER (ORDER BY h.count DESC) AS rank "
								+ "FROM hit h "
								+ "JOIN keyword k ON h.keyword_keyword_id = k.keyword_id "
								+ "WHERE rank <= :limit")
				.setParameter("limit", limit)
				.getResultList();
	}
}
