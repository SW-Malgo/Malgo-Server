package com.malgo.malgoserver.company;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	@NotNull
	private Long id;

	@NotNull private String name;
	@NotNull private String code;

	@NotNull
	@CreationTimestamp
	private LocalDateTime createAt;
	@NotNull
	@UpdateTimestamp
	private LocalDateTime updateAt;

	public Company() {

	}
}
