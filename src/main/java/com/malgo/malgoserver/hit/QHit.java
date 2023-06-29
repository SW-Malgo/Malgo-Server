package com.malgo.malgoserver.hit;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.PathInits;
import javax.annotation.processing.Generated;

/** QPost is a Querydsl query type for Post */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QHit extends EntityPathBase<Post> {
	public static QHit post;

	public QHit(Class<? extends Post> type, String variable) {
		super(type, variable);
	}

	public QHit(Class<? extends Post> type, PathMetadata metadata) {
		super(type, metadata);
	}

	public QHit(
			Class<? extends Post> type,
			PathMetadata metadata,
			@org.jetbrains.annotations.Nullable PathInits inits) {
		super(type, metadata, inits);
	}
}
