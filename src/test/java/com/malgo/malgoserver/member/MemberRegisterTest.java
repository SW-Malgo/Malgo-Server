package com.malgo.malgoserver.member;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.malgo.malgoserver.company.Company;
import com.malgo.malgoserver.company.CompanyRepository;
import com.malgo.malgoserver.keyword.Keyword;
import com.malgo.malgoserver.keyword.KeywordRepository;
import com.malgo.malgoserver.member.request.MemberRequest;
import com.malgo.malgoserver.util.token.Token;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
@ActiveProfiles("dev")
public class MemberRegisterTest {

	@Autowired MockMvc mvc;

	@Autowired MemberRepository memberRepository;
	@Autowired CompanyRepository companyRepository;
	@Autowired KeywordRepository keywordRepository;
	@Autowired MemberService memberService;

	@Autowired ObjectMapper mapper;

	public static final String[] keywords = {"독서", "AI", "자기계발"};

	public static final String CERTIFICATION_ID = "hackathon@gmail.com";
	public static final String PASSWORD = "hackathon1234";

	public static final String COMPANY_NAME = "삼성전자";
	public static final String COMPANY_CODE = "dEb25A";

	@Test
	public void 정상_회원가입_service() throws Exception {
		Company company = Company.builder().name("삼성전자").code(COMPANY_CODE).build();
		Company savedCompany = companyRepository.save(company);

		for (int i = 0; i < keywords.length; i++) {
			keywordRepository.save(Keyword.builder().tag(keywords[i]).build());
		}

		List<String> keywordList =
				keywordRepository.findAll().stream().map(Keyword::getTag).collect(Collectors.toList());

		MemberRequest request =
				MemberRequest.builder()
						.certificationId(CERTIFICATION_ID)
						.password(PASSWORD)
						.code(COMPANY_CODE)
						.keywords(keywordList)
						.build();
		Token token = memberService.save(request);

		Optional<Member> savedMember = memberRepository.findByCertificationId(CERTIFICATION_ID);

		assertThat(savedMember.isPresent()).isTrue();
		assertThat(savedMember.get().getCertificationId()).isEqualTo(CERTIFICATION_ID);
		assertThat(savedMember.get().getPassword()).isEqualTo(PASSWORD);
		assertThat(savedMember.get().getCompany().getName()).isEqualTo(COMPANY_NAME);
		assertThat(savedMember.get().getCompany().getCode()).isEqualTo(COMPANY_CODE);
		for (int i = 0; i < keywordList.size(); i++) {
			assertThat(keywordRepository.findOne(savedMember.get().getKeywords().get(i)).getTag())
					.isEqualTo(keywordList.get(i));
		}
		assertThat(savedMember.get().getCreateAt()).isNotNull();
		assertThat(savedMember.get().getUpdateAt()).isNotNull();
		assertThat(token.getAccessToken()).isNotNull();
		assertThat(token.getRefreshToken()).isNotNull();
	}

	@Test
	public void 정상_회원가입_repository() throws Exception {
		Company company = Company.builder().name("삼성전자").code(COMPANY_CODE).build();
		companyRepository.save(company);

		for (int i = 0; i < keywords.length; i++) {
			keywordRepository.save(Keyword.builder().tag(keywords[i]).build());
		}

		List<Long> longKeywordList =
				keywordRepository.findAll().stream().map(Keyword::getId).collect(Collectors.toList());

		Member member =
				Member.builder()
						.certificationId(CERTIFICATION_ID)
						.password(PASSWORD)
						.company(company)
						.keywords(longKeywordList)
						.build();
		memberRepository.save(member);

		Optional<Member> savedMember = memberRepository.findByCertificationId(CERTIFICATION_ID);

		assertThat(savedMember.isPresent()).isTrue();
		assertThat(savedMember.get().getCertificationId()).isEqualTo(CERTIFICATION_ID);
		assertThat(savedMember.get().getPassword()).isEqualTo(PASSWORD);
		assertThat(savedMember.get().getCompany().getName()).isEqualTo(COMPANY_NAME);
		assertThat(savedMember.get().getCompany().getCode()).isEqualTo(COMPANY_CODE);
		assertThat(savedMember.get().getKeywords()).isEqualTo(longKeywordList);
		assertThat(savedMember.get().getCreateAt()).isNotNull();
		assertThat(savedMember.get().getUpdateAt()).isNotNull();
	}

	@Test
	public void 회사_조회() {
		Company company = Company.builder().name("삼성전자").code(COMPANY_CODE).build();
		companyRepository.save(company);
		Optional<Company> savedCompany = companyRepository.findOneByCode(COMPANY_CODE);

		assertThat(savedCompany.isPresent()).isTrue();
		assertThat(savedCompany.get().getName()).isEqualTo(COMPANY_NAME);
		assertThat(savedCompany.get().getCode()).isEqualTo(COMPANY_CODE);
		assertThat(savedCompany.get().getCreateAt()).isNotNull();
		assertThat(savedCompany.get().getUpdateAt()).isNotNull();
	}

	@Test
	public void 회사_생성() {
		Company company = Company.builder().name("삼성전자").code(COMPANY_CODE).build();

		Company savedCompany = companyRepository.save(company);

		assertThat(savedCompany).isNotNull();
		assertThat(savedCompany.getName()).isEqualTo(COMPANY_NAME);
		assertThat(savedCompany.getCode()).isEqualTo(COMPANY_CODE);
		assertThat(savedCompany.getCreateAt()).isNotNull();
		assertThat(savedCompany.getUpdateAt()).isNotNull();
	}

	@Test
	public void 키워드_조회() {
		for (int i = 0; i < keywords.length; i++) {
			keywordRepository.save(Keyword.builder().tag(keywords[i]).build());
		}

		List<Keyword> savedKeywordList = keywordRepository.findAll();

		assertThat(savedKeywordList.size()).isEqualTo(keywords.length);
		for (int i = 0; i < keywords.length; i++)
			assertThat(savedKeywordList.get(i).getTag()).isEqualTo(keywords[i]);
	}

	@Test
	public void 키워드_생성() {
		List<Keyword> savedKeywordList = new ArrayList<>();
		for (int i = 0; i < keywords.length; i++) {
			savedKeywordList.add(keywordRepository.save(Keyword.builder().tag(keywords[i]).build()));
		}

		assertThat(savedKeywordList.size()).isEqualTo(keywords.length);
		for (int i = 0; i < keywords.length; i++)
			assertThat(savedKeywordList.get(i).getTag()).isEqualTo(keywords[i]);
	}

	@Test
	public void 멤버_키워드_조회() {
		List<Keyword> savedKeywordList = new ArrayList<>();
		for (int i = 0; i < keywords.length; i++) {
			savedKeywordList.add(Keyword.builder().tag(keywords[i]).build());
		}
	}
}
