package com.logikas.common.persistence.domain.jpa;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QJpaSoftDeletable is a Querydsl query type for JpaSoftDeletable
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QJpaSoftDeletable extends EntityPathBase<JpaSoftDeletable<? extends java.io.Serializable>> {

    private static final long serialVersionUID = -1261246531;

    public static final QJpaSoftDeletable jpaSoftDeletable = new QJpaSoftDeletable("jpaSoftDeletable");

    public final QJpaPersistable _super = new QJpaPersistable(this);

    public final DateTimePath<java.util.Date> deletedDate = createDateTime("deletedDate", java.util.Date.class);

    //inherited
    public final SimplePath<java.io.Serializable> id = _super.id;

    @SuppressWarnings("all")
    public QJpaSoftDeletable(String variable) {
        super((Class)JpaSoftDeletable.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QJpaSoftDeletable(Path<? extends JpaSoftDeletable> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    @SuppressWarnings("all")
    public QJpaSoftDeletable(PathMetadata<?> metadata) {
        super((Class)JpaSoftDeletable.class, metadata);
    }

}

