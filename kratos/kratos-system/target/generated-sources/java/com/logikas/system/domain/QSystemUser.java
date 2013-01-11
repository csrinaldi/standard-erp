package com.logikas.system.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QSystemUser is a Querydsl query type for SystemUser
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSystemUser extends EntityPathBase<SystemUser> {

    private static final long serialVersionUID = 958680584;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QSystemUser systemUser = new QSystemUser("systemUser");

    public final com.logikas.common.auditory.domain.jpa.QJpaSoftDeletableAuditable _super = new com.logikas.common.auditory.domain.jpa.QJpaSoftDeletableAuditable(this);

    public final QSystemUser createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    //inherited
    public final DateTimePath<java.util.Date> deletedDate = _super.deletedDate;

    public final DateTimePath<java.util.Date> expirationDate = createDateTime("expirationDate", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final QSystemUser updatedBy;

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    public final ListPath<SystemUserRole, QSystemUserRole> userRoles = this.<SystemUserRole, QSystemUserRole>createList("userRoles", SystemUserRole.class, QSystemUserRole.class, PathInits.DIRECT);

    public final ListPath<SystemUserToken, QSystemUserToken> userTokens = this.<SystemUserToken, QSystemUserToken>createList("userTokens", SystemUserToken.class, QSystemUserToken.class, PathInits.DIRECT);

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QSystemUser(String variable) {
        this(SystemUser.class, forVariable(variable), INITS);
    }

    @SuppressWarnings("all")
    public QSystemUser(Path<? extends SystemUser> path) {
        this((Class)path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSystemUser(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QSystemUser(PathMetadata<?> metadata, PathInits inits) {
        this(SystemUser.class, metadata, inits);
    }

    public QSystemUser(Class<? extends SystemUser> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.createdBy = inits.isInitialized("createdBy") ? new QSystemUser(forProperty("createdBy"), inits.get("createdBy")) : null;
        this.updatedBy = inits.isInitialized("updatedBy") ? new QSystemUser(forProperty("updatedBy"), inits.get("updatedBy")) : null;
    }

}

