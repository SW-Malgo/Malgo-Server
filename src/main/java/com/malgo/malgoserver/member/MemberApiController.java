package com.malgo.malgoserver.member;

import com.malgo.malgoserver.member.request.MemberRequest;
import com.malgo.malgoserver.support.ApiResponse;
import com.malgo.malgoserver.support.ApiResponseGenerator;
import com.malgo.malgoserver.support.MessageCode;
import com.malgo.malgoserver.util.token.Token;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberApiController {

	private final MemberService memberService;

	@PostMapping("/member")
	public ApiResponse<ApiResponse.SuccessBody<Token>> registerMember(
			@RequestBody @Valid MemberRequest form) {
		return ApiResponseGenerator.success(
				memberService.save(form), HttpStatus.OK, MessageCode.SUCCESS);
	}
}
