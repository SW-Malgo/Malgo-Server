package com.malgo.malgoserver.member.response;

import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberResponse {

	public MemberResponse(Long count, List<String> keywords) {
		this.count = count;
		this.keywords = keywords;
	}

	private Long count;

	private List<String> keywords;
}
