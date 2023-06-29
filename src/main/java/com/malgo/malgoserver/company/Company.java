package com.malgo.malgoserver.company;

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
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	@NotNull
	private Long id;

	@NotNull private String name;
	@NotNull private String code;

	@NotNull @CreatedDate private LocalDateTime createAt;
	@NotNull @LastModifiedDate private LocalDateTime updateAt;
}
