package com.malgo.malgoserver.groupmembers;

import com.malgo.malgoserver.group.Group;
import com.malgo.malgoserver.member.Member;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class GroupMembers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_member_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_fk")
	private Member member;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_fk")
	private Group group;

	private LocalDateTime createAt;

	private LocalDateTime updateAt;
}
