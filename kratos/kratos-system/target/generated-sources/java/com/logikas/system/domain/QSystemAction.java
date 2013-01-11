package com.logikas.system.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QSystemAction is a Querydsl query type for SystemAction
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSystemAction extends EntityPathBase<SystemAction> {

    private static final long serialVersionUID = 1582122291;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QSystemAction systemAction = new QSystemAction("systemAction");

    public final com.logikas.common.persistence.domain.jpa.QJpaPersistable _super = new com.logikas.common.persistence.domain.jpa.QJpaPersistable(this);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final QSystemDomain systemDomain;

    public QSystemAction(String variable) {
        this(SystemAction.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QSystemAction(Path<? extends SystemAction> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSystemAction(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSystemAction(PathMetadata<?> metadata, PathInits inits) {
        this(SystemAction.class, metadata, inits);
    }

    public QSystemAction(Class<? extends SystemAction> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.systemDomain = inits.isInitialized("systemDomain") ? new QSystemDomain(forProperty("systemDomain")) : null;
    }

}

