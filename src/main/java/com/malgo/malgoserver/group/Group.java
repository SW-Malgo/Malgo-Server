package com.malgo.malgoserver.group;

import lombok.*;

import javax.persistence.*;

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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "company_id")
//    private Company company;

    private Long max_count;
}
