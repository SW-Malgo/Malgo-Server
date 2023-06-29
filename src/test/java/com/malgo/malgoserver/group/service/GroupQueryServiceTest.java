package com.malgo.malgoserver.group.service;

import com.malgo.malgoserver.group.entity.Group;
import com.malgo.malgoserver.group.entity.GroupRepository;
import com.malgo.malgoserver.keyword.Keyword;
import com.malgo.malgoserver.keyword.KeywordRepository;
import com.malgo.malgoserver.keywordgroup.KeywordGroup;
import com.malgo.malgoserver.keywordgroup.KeywordGroupRepository;
import com.malgo.malgoserver.member.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class GroupQueryServiceTest {

    @Autowired
    GroupQueryService groupQueryService;
    @Autowired
    KeywordRepository keywordRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    KeywordGroupRepository keywordGroupRepository;

    @Test
    public void queryGroup() {

        Keyword keyword1 = Keyword.builder()
                .tag("운동")
                .build();
        Keyword newKeyword1 = keywordRepository.save(keyword1);

        Group group1 = Group.builder()
                .name("운동그룹")
                .groupContent("asd")
                .max_count(2l)
                .build();
        Group newGroup1 = groupRepository.save(group1);

        KeywordGroup keywordGroup1 = KeywordGroup.builder()
                .keyword(newKeyword1)
                .group(newGroup1)
                .build();
        keywordGroupRepository.save(keywordGroup1);

        Keyword keyword2 = Keyword.builder()
                .tag("게임")
                .build();
        Keyword newKeyword2 = keywordRepository.save(keyword2);

        Group group2 = Group.builder()
                .name("게임그룹")
                .groupContent("asd")
                .max_count(2l)
                .build();
        Group newGroup2 = groupRepository.save(group2);

        KeywordGroup keywordGroup2 = KeywordGroup.builder()
                .keyword(newKeyword2)
                .group(newGroup2)
                .build();
        keywordGroupRepository.save(keywordGroup2);

        List<Long> keywords = Arrays.asList(
                newKeyword1.getId()
        );

        List<Group> findGroups = groupQueryService.queryGroup(keywords, false);
        findGroups.forEach((g) -> System.out.println(g.getName()));

    }

}