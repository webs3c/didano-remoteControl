package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrobot_MotionSoftWareVersion is a Querydsl query type for robot_MotionSoftWareVersion
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qrobot_MotionSoftWareVersion extends EntityPathBase<robot_MotionSoftWareVersion> {

    private static final long serialVersionUID = 1695263140L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrobot_MotionSoftWareVersion robot_MotionSoftWareVersion = new Qrobot_MotionSoftWareVersion("robot_MotionSoftWareVersion");

    public final QrInfo _super;

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final StringPath deviceNo = createString("deviceNo");

    // inherited
    public final org.bson.types.QObjectId id;

    public final StringPath motion_version_software = createString("motion_version_software");

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version;

    public Qrobot_MotionSoftWareVersion(String variable) {
        this(robot_MotionSoftWareVersion.class, forVariable(variable), INITS);
    }

    public Qrobot_MotionSoftWareVersion(Path<? extends robot_MotionSoftWareVersion> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrobot_MotionSoftWareVersion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrobot_MotionSoftWareVersion(PathMetadata metadata, PathInits inits) {
        this(robot_MotionSoftWareVersion.class, metadata, inits);
    }

    public Qrobot_MotionSoftWareVersion(Class<? extends robot_MotionSoftWareVersion> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

