package com.malgo.malgoserver.keywordgroup;

import com.malgo.malgoserver.group.entity.Group;
import com.malgo.malgoserver.keyword.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KeywordGroupRepository extends JpaRepository<KeywordGroup, Long> {
    List<KeywordGroup> findAllByKeyword(Keyword keyword);

    List<KeywordGroup> findAllByKeywordNot(Keyword keyword);

    List<KeywordGroup> findAllByGroup(Group group);
}
