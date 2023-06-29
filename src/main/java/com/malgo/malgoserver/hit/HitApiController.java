package com.malgo.malgoserver.hit;

import com.malgo.malgoserver.support.ApiResponse;
import com.malgo.malgoserver.support.ApiResponseGenerator;
import com.malgo.malgoserver.support.MessageCode;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class HitApiController {

	private final HitService hitService;

	@GetMapping("/hit/{limit}")
	public ApiResponse<ApiResponse.SuccessBody<List<String>>> findHitKeywords(
			@PathVariable int limit) {
		return ApiResponseGenerator.success(
				hitService.findHitKeywords(limit), HttpStatus.OK, MessageCode.SUCCESS);
	}
}
