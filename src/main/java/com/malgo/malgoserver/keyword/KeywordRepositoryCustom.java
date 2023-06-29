package com.malgo.malgoserver.keyword;

import java.util.List;

public interface KeywordRepositoryCustom {

	List<Keyword> findByTags(List<String> tags);

	List<Keyword> findAll();

	Keyword findOne(Long id);

	Keyword findById(long id);
}
