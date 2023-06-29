package com.malgo.malgoserver.hit;

import com.malgo.malgoserver.Keyword.Keyword;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
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

	@NotNull
	@CreationTimestamp
	private LocalDateTime createAt;
	@NotNull
	@UpdateTimestamp
	private LocalDateTime updateAt;

	public Hit() {

	}
}
