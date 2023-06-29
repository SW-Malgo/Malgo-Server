package com.malgo.malgoserver.Keyword;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
public class Keyword {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "keyword_id")
	@NotNull
	private Long id;

	@NotNull private String tag;

	@NotNull
	@CreationTimestamp
	private LocalDateTime createAt;
	@NotNull
	@UpdateTimestamp
	private LocalDateTime updateAt;

	public Keyword() {

	}
}
