package com.malgo.malgoserver.member;

import com.malgo.malgoserver.Keyword.converter.KeywordConverter;
import com.malgo.malgoserver.company.Company;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@ToString
@Builder(toBuilder = true)
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
	@Convert(converter = KeywordConverter.class)
	private List<Long> keyword = new ArrayList<>();

	@NotNull @CreationTimestamp private LocalDateTime createAt;
	@NotNull @UpdateTimestamp private LocalDateTime updateAt;
}
