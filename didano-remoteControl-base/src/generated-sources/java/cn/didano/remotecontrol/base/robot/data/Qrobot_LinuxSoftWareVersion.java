package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrobot_LinuxSoftWareVersion is a Querydsl query type for robot_LinuxSoftWareVersion
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qrobot_LinuxSoftWareVersion extends EntityPathBase<robot_LinuxSoftWareVersion> {

    private static final long serialVersionUID = 1527366964L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrobot_LinuxSoftWareVersion robot_LinuxSoftWareVersion = new Qrobot_LinuxSoftWareVersion("robot_LinuxSoftWareVersion");

    public final QrInfo _super;

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final StringPath deviceNo = createString("deviceNo");

    // inherited
    public final org.bson.types.QObjectId id;

    public final StringPath linux_version_kernel = createString("linux_version_kernel");

    public final StringPath linux_version_software = createString("linux_version_software");

    public final StringPath linux_version_system = createString("linux_version_system");

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version;

    public Qrobot_LinuxSoftWareVersion(String variable) {
        this(robot_LinuxSoftWareVersion.class, forVariable(variable), INITS);
    }

    public Qrobot_LinuxSoftWareVersion(Path<? extends robot_LinuxSoftWareVersion> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrobot_LinuxSoftWareVersion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrobot_LinuxSoftWareVersion(PathMetadata metadata, PathInits inits) {
        this(robot_LinuxSoftWareVersion.class, metadata, inits);
    }

    public Qrobot_LinuxSoftWareVersion(Class<? extends robot_LinuxSoftWareVersion> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

