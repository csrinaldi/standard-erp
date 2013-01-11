package com.logikas.common.auditory.domain.jpa;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QJpaSoftDeletableAuditable is a Querydsl query type for JpaSoftDeletableAuditable
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QJpaSoftDeletableAuditable extends EntityPathBase<JpaSoftDeletableAuditable<?, ? extends java.io.Serializable>> {

    private static final long serialVersionUID = -36220772;

    public static final QJpaSoftDeletableAuditable jpaSoftDeletableAuditable = new QJpaSoftDeletableAuditable("jpaSoftDeletableAuditable");

    public final QJpaAuditable _super = new QJpaAuditable(this);

    //inherited
    public final SimplePath<Object> createdBy = _super.createdBy;

    //inherited
    public final DateTimePath<java.util.Date> createdDate = _super.createdDate;

    public final DateTimePath<java.util.Date> deletedDate = createDateTime("deletedDate", java.util.Date.class);

    //inherited
    public final SimplePath<java.io.Serializable> id = _super.id;

    //inherited
    public final SimplePath<Object> updatedBy = _super.updatedBy;

    //inherited
    public final DateTimePath<java.util.Date> updatedDate = _super.updatedDate;

    @SuppressWarnings("all")
    public QJpaSoftDeletableAuditable(String variable) {
        super((Class)JpaSoftDeletableAuditable.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QJpaSoftDeletableAuditable(Path<? extends JpaSoftDeletableAuditable> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    @SuppressWarnings("all")
    public QJpaSoftDeletableAuditable(PathMetadata<?> metadata) {
        super((Class)JpaSoftDeletableAuditable.class, metadata);
    }

}

