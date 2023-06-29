package com.malgo.malgoserver.member.request;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberRequest {

	@NotNull private String certificationId;

	@NotNull private String password;

	@NotNull private String code;

	@NotNull private List<String> keyword;
}
