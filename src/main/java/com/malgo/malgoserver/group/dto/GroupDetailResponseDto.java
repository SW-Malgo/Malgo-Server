package com.malgo.malgoserver.group.dto;

import com.malgo.malgoserver.keyword.Keyword;
import com.malgo.malgoserver.member.Member;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class GroupDetailResponseDto {

	private String groupName;

	private List<Keyword> keywords;

	private long memberCount;

	private List<Member> members;

	private String groupContent;

	private List<String> images;
}
