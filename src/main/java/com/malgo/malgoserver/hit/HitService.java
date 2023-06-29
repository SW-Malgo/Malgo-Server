package com.malgo.malgoserver.hit;

import com.malgo.malgoserver.keyword.KeywordRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class HitService {

	private final HitRepository hitRepository;
	private final KeywordRepository keywordRepository;

	public Map<String, Object> findHitKeywords(int limit) {
		List<Object[]> results = hitRepository.findHitKeywords(limit);
		Map<String, Object> rankMap = new HashMap<>();

		for (Object[] result : results) {
			rankMap.put("keyword", result[0]);
			rankMap.put("rank", result[1]);
		}
		return rankMap;
	}
}
