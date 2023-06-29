package com.malgo.malgoserver.company;

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
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	@NotNull
	private Long id;

	@NotNull private String name;
	@NotNull private String code;

	@NotNull @CreationTimestamp private LocalDateTime createAt;
	@NotNull @UpdateTimestamp private LocalDateTime updateAt;
}
