package com.malgo.malgoserver.company;

import java.time.LocalDateTime;
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
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private Long id;

	@NotNull private String name;
	@NotNull private String code;

	@Column(nullable = false, updatable = false)
	@CreatedDate
	private LocalDateTime createAt;

	@Column(nullable = false)
	@LastModifiedDate
	private LocalDateTime updateAt;
}
