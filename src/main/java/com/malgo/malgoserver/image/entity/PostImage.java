package com.malgo.malgoserver.image.entity;

import com.malgo.malgoserver.grouppost.GroupPost;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@ToString
@Builder(toBuilder = true)
public class PostImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postImage_id")
	private Long id;

	@Column(nullable = false)
	private String source;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "group_post_fk")
	private GroupPost groupPost;

	@NotNull @CreationTimestamp private LocalDateTime createAt;

	@NotNull @UpdateTimestamp private LocalDateTime updateAt;
}
