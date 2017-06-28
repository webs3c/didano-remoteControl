package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrobot_AndroidSoftWareVersion is a Querydsl query type for robot_AndroidSoftWareVersion
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qrobot_AndroidSoftWareVersion extends EntityPathBase<robot_AndroidSoftWareVersion> {

    private static final long serialVersionUID = 1588709529L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrobot_AndroidSoftWareVersion robot_AndroidSoftWareVersion = new Qrobot_AndroidSoftWareVersion("robot_AndroidSoftWareVersion");

    public final QrInfo _super;

    public final StringPath andriod_version_kernel = createString("andriod_version_kernel");

    public final StringPath andriod_version_software = createString("andriod_version_software");

    public final StringPath andriod_version_system = createString("andriod_version_system");

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final StringPath deviceNo = createString("deviceNo");

    // inherited
    public final org.bson.types.QObjectId id;

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version;

    public Qrobot_AndroidSoftWareVersion(String variable) {
        this(robot_AndroidSoftWareVersion.class, forVariable(variable), INITS);
    }

    public Qrobot_AndroidSoftWareVersion(Path<? extends robot_AndroidSoftWareVersion> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrobot_AndroidSoftWareVersion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrobot_AndroidSoftWareVersion(PathMetadata metadata, PathInits inits) {
        this(robot_AndroidSoftWareVersion.class, metadata, inits);
    }

    public Qrobot_AndroidSoftWareVersion(Class<? extends robot_AndroidSoftWareVersion> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

