package com.logikas.system.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QSystemRole is a Querydsl query type for SystemRole
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSystemRole extends EntityPathBase<SystemRole> {

    private static final long serialVersionUID = 958587571;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QSystemRole systemRole = new QSystemRole("systemRole");

    public final com.logikas.common.auditory.domain.jpa.QJpaAuditable _super = new com.logikas.common.auditory.domain.jpa.QJpaAuditable(this);

    public final QSystemUser createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    public final StringPath description = createString("description");

    public final DateTimePath<java.util.Date> expirationDate = createDateTime("expirationDate", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<SystemRolePermission, QSystemRolePermission> rolePermissions = this.<SystemRolePermission, QSystemRolePermission>createList("rolePermissions", SystemRolePermission.class, QSystemRolePermission.class, PathInits.DIRECT);

    public final QSystemUser updatedBy;

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QSystemRole(String variable) {
        this(SystemRole.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QSystemRole(Path<? extends SystemRole> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSystemRole(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSystemRole(PathMetadata<?> metadata, PathInits inits) {
        this(SystemRole.class, metadata, inits);
    }

    public QSystemRole(Class<? extends SystemRole> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new QSystemUser(forProperty("createdBy"), inits.get("createdBy")) : null;
        this.updatedBy = inits.isInitialized("updatedBy") ? new QSystemUser(forProperty("updatedBy"), inits.get("updatedBy")) : null;
    }

}

