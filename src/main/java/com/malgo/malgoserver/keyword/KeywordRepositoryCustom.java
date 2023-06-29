package com.malgo.malgoserver.keyword;

import java.util.List;
import java.util.Optional;

public interface KeywordRepositoryCustom {
	Keyword save(Keyword keyword);

	List<Keyword> findByTags(List<String> tags);

	List<Keyword> findAll();

	Keyword findOne(Long id);

	Keyword findById(long id);
}
