package com.malgo.malgoserver.keyword;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class KeywordService {

	private final KeywordRepository keywordRepository;

	public Long createKeyword(String tag) {

		if (keywordRepository.existsByTag(tag)) {
			throw new IllegalArgumentException("존재하는 키워드 입니다.");
		}
		Keyword keyword = Keyword.builder().tag(tag).build();
		return keywordRepository.save(keyword).getId();
	}
}
