package com.malgo.malgoserver.groupmembers;

import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class GroupMembers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_member_id")
	private Long id;

	private Long member_id;

	private Long group_id;

	private LocalDateTime createAt;

	private LocalDateTime updateAt;
}
