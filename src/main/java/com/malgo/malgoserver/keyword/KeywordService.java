package com.malgo.malgoserver.keyword;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class KeywordService {

    private final KeywordRepository keywordRepository;

    public long createKeyword(String tag) {

        if (keywordRepository.existsByTag(tag)) {
            return -1l;
        }
        Keyword keyword = Keyword.builder()
                .tag(tag)
                .build();
        return keywordRepository.save(keyword).getId();
    }
}
