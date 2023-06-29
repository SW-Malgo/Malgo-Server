package com.malgo.malgoserver.member;

import com.malgo.malgoserver.company.Company;
import com.malgo.malgoserver.company.CompanyRepository;
import com.malgo.malgoserver.keyword.Keyword;
import com.malgo.malgoserver.keyword.KeywordRepository;
import com.malgo.malgoserver.member.request.MemberRequest;
import com.malgo.malgoserver.member.response.MemberResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

	private final MemberRepository memberRepository;
	private final CompanyRepository companyRepository;
	private final KeywordRepository keywordRepository;

	public MemberResponse save(MemberRequest form) {
		Optional<Company> company = companyRepository.findOneByCode(form.getCode());

		if (company.isPresent()) {
			Member member =
					Member.builder()
							.certificationId(form.getCertificationId())
							.password(form.getPassword())
							.company(company.get())
							.keyword(convertToLongKeywords(form.getKeyword()))
							.build();
			memberRepository.save(member);
			return new MemberResponse(member, form.getKeyword());
		}
		return null;
	}

	private List<Long> convertToLongKeywords(List<String> keywords) {
		return keywordRepository.findByTags(keywords).stream()
				.map(Keyword::getId)
				.collect(Collectors.toList());
	}
}
