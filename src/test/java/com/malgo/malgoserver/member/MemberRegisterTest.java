package com.malgo.malgoserver.member;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.malgo.malgoserver.company.Company;
import com.malgo.malgoserver.company.CompanyRepository;
import com.malgo.malgoserver.keyword.Keyword;
import com.malgo.malgoserver.keyword.KeywordRepository;
import java.util.ArrayList;
import java.util.List;
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

	@Autowired ObjectMapper mapper;

	String[] keywords = {"독서", "AI", "자기계발"};

	private static final String CERTIFICATION_ID = "hackathon@gmail.com";
	private static final String PASSWORD = "hackathon1234";

	private static final String COMPANY_NAME = "삼성전자";
	private static final String COMPANY_CODE = "dEb25A";

	@Test
	public void 정상_회원가입() throws Exception {
		Company company = Company.builder().name("삼성전자").code(COMPANY_CODE).build();
		Company savedCompany = companyRepository.save(company);

		List<Keyword> keywordList = new ArrayList<>();
		for (int i = 0; i < keywords.length; i++) {
			keywordList.add(Keyword.builder().tag(keywords[i]).build());
		}
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
	public void 키워드_생성() {
		List<Keyword> savedKeywordList = new ArrayList<>();
		for (int i = 0; i < keywords.length; i++) {
			savedKeywordList.add(Keyword.builder().tag(keywords[i]).build());
		}

		assertThat(savedKeywordList.size()).isEqualTo(keywords.length);
		for (int i = 0; i < keywords.length; i++)
			assertThat(savedKeywordList.get(i).getTag()).isEqualTo(keywords[i]);
	}
}
