package com.malgo.malgoserver.keyword;

import java.util.List;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class KeywordRepositoryCustomImpl implements KeywordRepositoryCustom {
	private final EntityManager em;

	public Keyword save(Keyword keyword) {
		em.persist(keyword);
		return keyword;
	}

	public List<Keyword> findByTags(List<String> tags) {
		return em.createQuery("select k from Keyword k where k.tag in :tags", Keyword.class)
				.setParameter("tags", tags)
				.getResultList();
	}

	public List<Keyword> findAll() {
		return em.createQuery("select k from Keyword k", Keyword.class).getResultList();
	}

	public Keyword findOne(Long id) {
		return em.find(Keyword.class, id);
	}

	@Override
	public Keyword findById(long id) {
		return em.createQuery("select k from Keyword k where k.id in :id", Keyword.class)
				.setParameter("id", id)
				.getResultList()
				.get(0);
	}
}
