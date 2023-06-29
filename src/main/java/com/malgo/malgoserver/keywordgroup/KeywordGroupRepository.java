package com.malgo.malgoserver.keywordgroup;

import com.malgo.malgoserver.group.entity.Group;
import com.malgo.malgoserver.keyword.Keyword;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordGroupRepository extends JpaRepository<KeywordGroup, Long> {
	List<KeywordGroup> findAllByKeyword(Keyword keyword);

	List<KeywordGroup> findAllByKeywordNot(Keyword keyword);

	List<KeywordGroup> findAllByGroup(Group group);
}
