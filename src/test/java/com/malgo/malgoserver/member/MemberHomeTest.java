package com.malgo.malgoserver.member;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.malgo.malgoserver.company.CompanyRepository;
import com.malgo.malgoserver.keyword.KeywordRepository;
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
public class MemberHomeTest {

	@Autowired MockMvc mvc;

	@Autowired MemberRepository memberRepository;
	@Autowired CompanyRepository companyRepository;
	@Autowired KeywordRepository keywordRepository;

	@Autowired ObjectMapper mapper;

	String[] keywords = {"독서", "AI", "자기계발"};

	//    private static final String CERTIFICATION_ID = "hackathon@gmail.com";
	//    private static final String PASSWORD = "hackathon1234";
	//
	//    private static final String COMPANY_NAME = "삼성전자";
	//    private static final String COMPANY_CODE = "dEb25A";

	@Test
	public void 회원_정보_조회_home() {}
}
