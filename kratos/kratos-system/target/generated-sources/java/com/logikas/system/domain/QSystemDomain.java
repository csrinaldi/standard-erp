package com.logikas.system.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QSystemDomain is a Querydsl query type for SystemDomain
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSystemDomain extends EntityPathBase<SystemDomain> {

    private static final long serialVersionUID = 1678875585;

    public static final QSystemDomain systemDomain = new QSystemDomain("systemDomain");

    public final com.logikas.common.persistence.domain.jpa.QJpaPersistable _super = new com.logikas.common.persistence.domain.jpa.QJpaPersistable(this);

    public final ListPath<SystemAction, QSystemAction> actions = this.<SystemAction, QSystemAction>createList("actions", SystemAction.class, QSystemAction.class, PathInits.DIRECT);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QSystemDomain(String variable) {
        super(SystemDomain.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QSystemDomain(Path<? extends SystemDomain> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    public QSystemDomain(PathMetadata<?> metadata) {
        super(SystemDomain.class, metadata);
    }

}

