package com.malgo.malgoserver.member;

import com.malgo.malgoserver.member.request.MemberRequest;
import com.malgo.malgoserver.member.response.MemberResponse;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class MemberApiController {

	private final MemberService memberService;

	@PostMapping("/member")
	public ResponseEntity<MemberResponse> registerMember(@RequestBody @Valid MemberRequest form) {
		MemberResponse response = memberService.save(form);
		return (response != null) ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
	}
}
