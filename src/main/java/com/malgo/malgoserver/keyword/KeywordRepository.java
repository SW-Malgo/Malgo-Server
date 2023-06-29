package com.malgo.malgoserver.keyword;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<Keyword, Long>, KeywordRepositoryCustom {
	Optional<Keyword> findByTag(String tag);

	Boolean existsByTag(String tag);
}
