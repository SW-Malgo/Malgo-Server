package com.malgo.malgoserver.member.request;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
@Data
public class MemberRequest {

	@NotNull private String certificationId;

	@NotNull private String password;

	@NotNull private String code;

	@NotNull private List<String> keywords;
}
