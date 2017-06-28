package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrobot_LinuxStartUpRecord is a Querydsl query type for robot_LinuxStartUpRecord
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qrobot_LinuxStartUpRecord extends EntityPathBase<robot_LinuxStartUpRecord> {

    private static final long serialVersionUID = -1065107919L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrobot_LinuxStartUpRecord robot_LinuxStartUpRecord = new Qrobot_LinuxStartUpRecord("robot_LinuxStartUpRecord");

    public final QrInfo _super;

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final StringPath deviceNo = createString("deviceNo");

    // inherited
    public final org.bson.types.QObjectId id;

    public final StringPath poweroff_time = createString("poweroff_time");

    public final StringPath schoolName = createString("schoolName");

    public final StringPath startup_reason = createString("startup_reason");

    public final StringPath startup_time = createString("startup_time");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version;

    public Qrobot_LinuxStartUpRecord(String variable) {
        this(robot_LinuxStartUpRecord.class, forVariable(variable), INITS);
    }

    public Qrobot_LinuxStartUpRecord(Path<? extends robot_LinuxStartUpRecord> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrobot_LinuxStartUpRecord(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrobot_LinuxStartUpRecord(PathMetadata metadata, PathInits inits) {
        this(robot_LinuxStartUpRecord.class, metadata, inits);
    }

    public Qrobot_LinuxStartUpRecord(Class<? extends robot_LinuxStartUpRecord> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

