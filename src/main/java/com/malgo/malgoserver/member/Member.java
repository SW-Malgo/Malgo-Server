package com.malgo.malgoserver.member;

import com.malgo.malgoserver.company.Company;
import com.malgo.malgoserver.keyword.converter.KeywordConverter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@ToString
@Builder(toBuilder = true)
@EntityListeners(AuditingEntityListener.class)
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;

	@NotNull private String certificationId;
	@NotNull private String password;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	private Company company;

	@NotNull
	@Convert(converter = KeywordConverter.class)
	@Builder.Default
	private List<Long> keyword = new ArrayList<>();

	@Column(nullable = false, updatable = false)
	@CreatedDate
	private LocalDateTime createAt;

	@Column(nullable = false)
	@LastModifiedDate
	private LocalDateTime updateAt;
}
