package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrobot_UploadType is a Querydsl query type for robot_UploadType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qrobot_UploadType extends EntityPathBase<robot_UploadType> {

    private static final long serialVersionUID = 771675474L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrobot_UploadType robot_UploadType = new Qrobot_UploadType("robot_UploadType");

    public final QrInfo _super;

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    // inherited
    public final org.bson.types.QObjectId id;

    public final StringPath methodName = createString("methodName");

    public final StringPath typeName = createString("typeName");

    //inherited
    public final NumberPath<Integer> version;

    public Qrobot_UploadType(String variable) {
        this(robot_UploadType.class, forVariable(variable), INITS);
    }

    public Qrobot_UploadType(Path<? extends robot_UploadType> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrobot_UploadType(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrobot_UploadType(PathMetadata metadata, PathInits inits) {
        this(robot_UploadType.class, metadata, inits);
    }

    public Qrobot_UploadType(Class<? extends robot_UploadType> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

