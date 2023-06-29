package com.malgo.malgoserver.hit;

import com.malgo.malgoserver.keyword.KeywordRepository;
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
		//		List<Hit> hits = hitRepository.findHitKeywords(limit);
		//		Map<String, Object> rankMap = new HashMap<>();
		//
		//		for (Hit hit : hits) {
		//			rankMap.put("keyword", hit.getKeyword().getTag());
		//			rankMap.put("rank", hit.get);
		//		}
		//		return rankMap;

	}
}
