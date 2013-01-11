package com.logikas.system.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QSystemRolePermission is a Querydsl query type for SystemRolePermission
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSystemRolePermission extends EntityPathBase<SystemRolePermission> {

    private static final long serialVersionUID = 273744098;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QSystemRolePermission systemRolePermission = new QSystemRolePermission("systemRolePermission");

    public final com.logikas.common.auditory.domain.jpa.QJpaAuditable _super = new com.logikas.common.auditory.domain.jpa.QJpaAuditable(this);

    public final QSystemAction action;

    public final QSystemUser createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    public final DateTimePath<java.util.Date> expirationDate = createDateTime("expirationDate", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QSystemRole role;

    public final QSystemUser updatedBy;

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public final StringPath wildcard = createString("wildcard");

    public QSystemRolePermission(String variable) {
        this(SystemRolePermission.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QSystemRolePermission(Path<? extends SystemRolePermission> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSystemRolePermission(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSystemRolePermission(PathMetadata<?> metadata, PathInits inits) {
        this(SystemRolePermission.class, metadata, inits);
    }

    public QSystemRolePermission(Class<? extends SystemRolePermission> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.action = inits.isInitialized("action") ? new QSystemAction(forProperty("action"), inits.get("action")) : null;
        this.createdBy = inits.isInitialized("createdBy") ? new QSystemUser(forProperty("createdBy"), inits.get("createdBy")) : null;
        this.role = inits.isInitialized("role") ? new QSystemRole(forProperty("role"), inits.get("role")) : null;
        this.updatedBy = inits.isInitialized("updatedBy") ? new QSystemUser(forProperty("updatedBy"), inits.get("updatedBy")) : null;
    }

}

