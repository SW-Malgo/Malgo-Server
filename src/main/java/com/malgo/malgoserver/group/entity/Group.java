package com.malgo.malgoserver.group.entity;

import com.malgo.malgoserver.company.Company;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "group_entity")
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_id")
	private Long id;

	private String name;

	private Long ownerId;

	@Column(name = "group_content")
	private String groupContent;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_fk")
	private Company company;

	private Long max_count;

	@Column(nullable = false, updatable = false)
	@CreatedDate
	private LocalDateTime createAt;

	@Column(nullable = false)
	@LastModifiedDate
	private LocalDateTime updateAt;
}
