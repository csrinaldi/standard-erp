package com.logikas.system.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QSystemUserRole is a Querydsl query type for SystemUserRole
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSystemUserRole extends EntityPathBase<SystemUserRole> {

    private static final long serialVersionUID = 1390739102;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QSystemUserRole systemUserRole = new QSystemUserRole("systemUserRole");

    public final com.logikas.common.auditory.domain.jpa.QJpaAuditable _super = new com.logikas.common.auditory.domain.jpa.QJpaAuditable(this);

    public final QSystemUser createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    public final DateTimePath<java.util.Date> expirationDate = createDateTime("expirationDate", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QSystemRole role;

    public final QSystemUser updatedBy;

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    public final QSystemUser user;

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QSystemUserRole(String variable) {
        this(SystemUserRole.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QSystemUserRole(Path<? extends SystemUserRole> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSystemUserRole(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSystemUserRole(PathMetadata<?> metadata, PathInits inits) {
        this(SystemUserRole.class, metadata, inits);
    }

    public QSystemUserRole(Class<? extends SystemUserRole> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new QSystemUser(forProperty("createdBy"), inits.get("createdBy")) : null;
        this.role = inits.isInitialized("role") ? new QSystemRole(forProperty("role"), inits.get("role")) : null;
        this.updatedBy = inits.isInitialized("updatedBy") ? new QSystemUser(forProperty("updatedBy"), inits.get("updatedBy")) : null;
        this.user = inits.isInitialized("user") ? new QSystemUser(forProperty("user"), inits.get("user")) : null;
    }

}
