package com.logikas.common.auditory.domain.jpa;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QJpaAuditable is a Querydsl query type for JpaAuditable
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QJpaAuditable extends EntityPathBase<JpaAuditable<?, ? extends java.io.Serializable>> {

    private static final long serialVersionUID = 923899140;

    public static final QJpaAuditable jpaAuditable = new QJpaAuditable("jpaAuditable");

    public final com.logikas.common.persistence.domain.jpa.QJpaPersistable _super = new com.logikas.common.persistence.domain.jpa.QJpaPersistable(this);

    public final SimplePath<Object> createdBy = createSimple("createdBy", Object.class);

    public final DateTimePath<java.util.Date> createdDate = createDateTime("createdDate", java.util.Date.class);

    //inherited
    public final SimplePath<java.io.Serializable> id = _super.id;

    public final SimplePath<Object> updatedBy = createSimple("updatedBy", Object.class);

    public final DateTimePath<java.util.Date> updatedDate = createDateTime("updatedDate", java.util.Date.class);

    @SuppressWarnings("all")
    public QJpaAuditable(String variable) {
        super((Class)JpaAuditable.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QJpaAuditable(Path<? extends JpaAuditable> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    @SuppressWarnings("all")
    public QJpaAuditable(PathMetadata<?> metadata) {
        super((Class)JpaAuditable.class, metadata);
    }

}

