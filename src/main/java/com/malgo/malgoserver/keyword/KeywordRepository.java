package com.malgo.malgoserver.keyword;

import java.util.Optional;

public interface KeywordRepository extends KeywordRepositoryCustom {
	Optional<Keyword> findByTag(String tag);

	Boolean existByTag(String tag);
}
