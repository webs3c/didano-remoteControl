package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrobot_LinuxHardWareInfo is a Querydsl query type for robot_LinuxHardWareInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qrobot_LinuxHardWareInfo extends EntityPathBase<robot_LinuxHardWareInfo> {

    private static final long serialVersionUID = 9401747L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrobot_LinuxHardWareInfo robot_LinuxHardWareInfo = new Qrobot_LinuxHardWareInfo("robot_LinuxHardWareInfo");

    public final QrInfo _super;

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final StringPath deviceNo = createString("deviceNo");

    // inherited
    public final org.bson.types.QObjectId id;

    public final StringPath linux_hard_ecid_0 = createString("linux_hard_ecid_0");

    public final StringPath linux_hard_ecid_1 = createString("linux_hard_ecid_1");

    public final StringPath linux_hard_ecid_2 = createString("linux_hard_ecid_2");

    public final StringPath linux_hard_ecid_3 = createString("linux_hard_ecid_3");

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version;

    public Qrobot_LinuxHardWareInfo(String variable) {
        this(robot_LinuxHardWareInfo.class, forVariable(variable), INITS);
    }

    public Qrobot_LinuxHardWareInfo(Path<? extends robot_LinuxHardWareInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrobot_LinuxHardWareInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrobot_LinuxHardWareInfo(PathMetadata metadata, PathInits inits) {
        this(robot_LinuxHardWareInfo.class, metadata, inits);
    }

    public Qrobot_LinuxHardWareInfo(Class<? extends robot_LinuxHardWareInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

