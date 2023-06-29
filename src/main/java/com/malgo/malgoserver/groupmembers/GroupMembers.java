package com.malgo.malgoserver.groupmembers;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

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
