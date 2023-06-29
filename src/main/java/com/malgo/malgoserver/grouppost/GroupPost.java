package com.malgo.malgoserver.grouppost;

import com.malgo.malgoserver.group.Group;
import java.time.LocalDateTime;
import javax.persistence.*;
import lombok.*;

@Entity
@Builder(toBuilder = true)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class GroupPost {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_post_id")
	private Long id;

	private String content;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_id")
	private Group group;

	private LocalDateTime createAt;

	private LocalDateTime updateAt;
}
