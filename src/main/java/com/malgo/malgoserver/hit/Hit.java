package com.malgo.malgoserver.hit;

import com.malgo.malgoserver.keyword.Keyword;
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
public class Hit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hit_id")
	@NotNull
	private Long id;

	@NotNull private Long count;

	@NotNull
	@OneToOne(fetch = FetchType.LAZY)
	private Keyword keyword;

	@NotNull @CreatedDate private LocalDateTime createAt;
	@NotNull @LastModifiedDate private LocalDateTime updateAt;
}
