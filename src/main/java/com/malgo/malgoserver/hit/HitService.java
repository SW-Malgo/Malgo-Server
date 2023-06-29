package com.malgo.malgoserver.hit;

import com.malgo.malgoserver.keyword.Keyword;
import com.malgo.malgoserver.keyword.KeywordRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class HitService {

	private final HitRepository hitRepository;
	private final KeywordRepository keywordRepository;

	public List<String> findHitKeywords(int limit) {
		List<Hit> hits = hitRepository.findHitKeywords(limit);
		return hits.stream().map(Hit::getKeyword).collect(Collectors.toList()).stream()
				.map(Keyword::getTag)
				.collect(Collectors.toList());
	}
}
