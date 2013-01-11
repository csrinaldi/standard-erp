package com.logikas.common.persistence.domain.jpa;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QJpaPersistable is a Querydsl query type for JpaPersistable
 */
@Generated("com.mysema.query.codegen.SupertypeSerializer")
public class QJpaPersistable extends EntityPathBase<JpaPersistable<? extends java.io.Serializable>> {

    private static final long serialVersionUID = -454217631;

    public static final QJpaPersistable jpaPersistable = new QJpaPersistable("jpaPersistable");

    public final SimplePath<java.io.Serializable> id = createSimple("id", java.io.Serializable.class);

    @SuppressWarnings("all")
    public QJpaPersistable(String variable) {
        super((Class)JpaPersistable.class, forVariable(variable));
    }

    @SuppressWarnings("all")
    public QJpaPersistable(Path<? extends JpaPersistable> path) {
        super((Class)path.getType(), path.getMetadata());
    }

    @SuppressWarnings("all")
    public QJpaPersistable(PathMetadata<?> metadata) {
        super((Class)JpaPersistable.class, metadata);
    }

}

