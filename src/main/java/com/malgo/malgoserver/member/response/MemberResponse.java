package com.malgo.malgoserver.member.response;

import java.util.List;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
@Data
public class MemberResponse {

	private Long count;

	private List<String> keywords;
}
