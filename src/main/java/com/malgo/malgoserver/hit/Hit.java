package com.malgo.malgoserver.hit;

import com.malgo.malgoserver.Keyword.Keyword;
import java.time.LocalDateTime;
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
public class Hit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hit_id")
	@NotNull
	private Long id;

	@NotNull private int count;

	@NotNull
	@OneToOne(fetch = FetchType.LAZY)
	private Keyword keyword;

	@NotNull @CreationTimestamp private LocalDateTime createAt;
	@NotNull @UpdateTimestamp private LocalDateTime updateAt;
}
