package com.malgo.malgoserver.member;

import com.malgo.malgoserver.company.Company;
import com.malgo.malgoserver.converter.KeywordToArray;
import com.malgo.malgoserver.member.request.MemberRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@NoArgsConstructor
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	@NotNull
	private Long id;

	@NotNull private String certificationId;
	@NotNull private String password;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Company company;

	@NotNull
	@Convert(converter = KeywordToArray.class)
	private List<Long> keyword = new ArrayList<>();

	@NotNull @CreationTimestamp private LocalDateTime createAt;
	@NotNull @UpdateTimestamp private LocalDateTime updateAt;

	@Builder
	public Member(String certificationId, String password, Company company, List<Long> keyword) {
		this.certificationId = certificationId;
		this.password = password;
		this.company = company;
		this.keyword = keyword;
	}
	
}
