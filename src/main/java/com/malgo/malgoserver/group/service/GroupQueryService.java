package com.malgo.malgoserver.group.service;

import com.malgo.malgoserver.group.entity.Group;
import com.malgo.malgoserver.group.entity.GroupRepository;
import com.malgo.malgoserver.keyword.Keyword;
import com.malgo.malgoserver.keyword.KeywordRepository;
import com.malgo.malgoserver.keywordgroup.KeywordGroup;
import com.malgo.malgoserver.keywordgroup.KeywordGroupRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GroupQueryService {

    private final GroupRepository groupRepository;
    private final KeywordRepository keywordRepository;
    private final KeywordGroupRepository keywordGroupRepository;

    public List<Group> queryGroup(List<Long> keywordIds, Boolean withKeyword) {

        List<Keyword> keywords = keywordIds.stream()
                .map(id -> keywordRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException()))
                .collect(Collectors.toList());

        if (withKeyword == true) {
            return keywords.stream()
                    .flatMap(ks -> keywordGroupRepository.findAllByKeyword(ks).stream())
                    .map(kg -> groupRepository.findById(kg.getGroup().getId())
                            .orElseThrow(() -> new IllegalArgumentException()))
                    .collect(Collectors.toList());
        }
        if (withKeyword == false) {
            return keywords.stream()
                    .flatMap(ks -> keywordGroupRepository.findAllByKeywordNot(ks).stream())
                    .map(kg -> groupRepository.findById(kg.getGroup().getId())
                            .orElseThrow(() -> new IllegalArgumentException()))
                    .collect(Collectors.toList());
        }

        throw new IllegalArgumentException();
    }

}
