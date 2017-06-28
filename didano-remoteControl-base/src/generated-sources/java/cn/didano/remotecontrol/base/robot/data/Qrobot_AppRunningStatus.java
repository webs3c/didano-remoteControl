package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrobot_AppRunningStatus is a Querydsl query type for robot_AppRunningStatus
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qrobot_AppRunningStatus extends EntityPathBase<robot_AppRunningStatus> {

    private static final long serialVersionUID = -1073778393L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrobot_AppRunningStatus robot_AppRunningStatus = new Qrobot_AppRunningStatus("robot_AppRunningStatus");

    public final QrInfo _super;

    public final StringPath android_app_status = createString("android_app_status");

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final StringPath deviceNo = createString("deviceNo");

    // inherited
    public final org.bson.types.QObjectId id;

    public final StringPath linux_app_status = createString("linux_app_status");

    public final StringPath motion_app_status = createString("motion_app_status");

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version;

    public Qrobot_AppRunningStatus(String variable) {
        this(robot_AppRunningStatus.class, forVariable(variable), INITS);
    }

    public Qrobot_AppRunningStatus(Path<? extends robot_AppRunningStatus> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrobot_AppRunningStatus(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrobot_AppRunningStatus(PathMetadata metadata, PathInits inits) {
        this(robot_AppRunningStatus.class, metadata, inits);
    }

    public Qrobot_AppRunningStatus(Class<? extends robot_AppRunningStatus> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

