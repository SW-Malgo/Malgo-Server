package com.malgo.malgoserver.keyword;

import java.util.List;

public interface KeywordRepositoryCustom {
	Keyword save(Keyword keyword);

	List<Keyword> findByTags(List<String> tags);

	List<Keyword> findAll();

	Keyword findOne(Long id);
}
