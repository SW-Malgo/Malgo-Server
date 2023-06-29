package com.malgo.malgoserver.member.response;

import com.malgo.malgoserver.member.Member;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberResponse {

	public MemberResponse(Member member, List<String> keywords) {
		this.certificationId = member.getCertificationId();
		this.password = member.getPassword();
		this.code = member.getCompany().getCode();
		this.keywords = keywords;
	}

	private String certificationId;

	private String password;

	private String code;

	private List<String> keywords;
}
