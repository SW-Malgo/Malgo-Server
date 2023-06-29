package com.malgo.malgoserver.company;

import java.util.Optional;
import javax.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CompanyRepository {
	private final EntityManager em;

	public Optional<Company> findOneByCode(String code) {
		return em
				.createQuery("select c from Company c where c.code = :code", Company.class)
				.setParameter("code", code)
				.getResultList()
				.stream()
				.findFirst();
	}
}
