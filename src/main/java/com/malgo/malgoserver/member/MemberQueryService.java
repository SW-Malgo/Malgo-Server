package com.malgo.malgoserver.member;

import com.malgo.malgoserver.company.CompanyRepository;
import com.malgo.malgoserver.config.security.AuditorHolder;
import com.malgo.malgoserver.keyword.Keyword;
import com.malgo.malgoserver.keyword.KeywordRepository;
import com.malgo.malgoserver.member.response.MemberResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberQueryService {

	private final MemberRepository memberRepository;
	private final CompanyRepository companyRepository;
	private final KeywordRepository keywordRepository;

	public MemberResponse findMemberHome() {
		Long memberId = AuditorHolder.get().getMemberId();

		List<Keyword> keywords =
				memberRepository.findOne(memberId).getKeywords().stream()
						.map(keywordRepository::findOne)
						.collect(Collectors.toList());

		List<String> tags = keywords.stream().map(Keyword::getTag).collect(Collectors.toList());

		return MemberResponse.builder().count(memberId).keywords(tags).build();
	}

	public String findCompany() {
		return companyRepository.findOne(AuditorHolder.get().getCompanyId()).get().getName();
	}
}
