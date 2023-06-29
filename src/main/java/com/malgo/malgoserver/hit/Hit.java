package com.malgo.malgoserver.hit;

import com.malgo.malgoserver.Keyword.Keyword;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

	@Builder
	public Hit(int count, Keyword keyword) {
		this.count = count;
		this.keyword = keyword;
	}
}
