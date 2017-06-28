package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QrInfo is a Querydsl query type for rInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QrInfo extends EntityPathBase<rInfo> {

    private static final long serialVersionUID = 411364894L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QrInfo rInfo = new QrInfo("rInfo");

    public final DateTimePath<java.util.Date> createDate = createDateTime("createDate", java.util.Date.class);

    public final org.bson.types.QObjectId id;

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QrInfo(String variable) {
        this(rInfo.class, forVariable(variable), INITS);
    }

    public QrInfo(Path<? extends rInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QrInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QrInfo(PathMetadata metadata, PathInits inits) {
        this(rInfo.class, metadata, inits);
    }

    public QrInfo(Class<? extends rInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.id = inits.isInitialized("id") ? new org.bson.types.QObjectId(forProperty("id")) : null;
    }

}

