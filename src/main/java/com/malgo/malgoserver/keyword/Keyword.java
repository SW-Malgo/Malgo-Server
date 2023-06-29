package com.malgo.malgoserver.keyword;

import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Keyword {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "keyword_id")
	@NotNull
	private Long id;

	@NotNull private String tag;

	@NotNull @CreatedDate private LocalDateTime createAt;
	@NotNull @LastModifiedDate private LocalDateTime updateAt;
}
