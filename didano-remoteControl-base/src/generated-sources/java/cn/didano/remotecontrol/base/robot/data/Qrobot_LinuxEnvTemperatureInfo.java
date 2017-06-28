package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrobot_LinuxEnvTemperatureInfo is a Querydsl query type for robot_LinuxEnvTemperatureInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qrobot_LinuxEnvTemperatureInfo extends EntityPathBase<robot_LinuxEnvTemperatureInfo> {

    private static final long serialVersionUID = 724508818L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrobot_LinuxEnvTemperatureInfo robot_LinuxEnvTemperatureInfo = new Qrobot_LinuxEnvTemperatureInfo("robot_LinuxEnvTemperatureInfo");

    public final QrInfo _super;

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final StringPath deviceNo = createString("deviceNo");

    // inherited
    public final org.bson.types.QObjectId id;

    public final StringPath linux_cpu_temperature = createString("linux_cpu_temperature");

    public final StringPath linux_env_temperature = createString("linux_env_temperature");

    public final StringPath linux_temperature_time = createString("linux_temperature_time");

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version;

    public Qrobot_LinuxEnvTemperatureInfo(String variable) {
        this(robot_LinuxEnvTemperatureInfo.class, forVariable(variable), INITS);
    }

    public Qrobot_LinuxEnvTemperatureInfo(Path<? extends robot_LinuxEnvTemperatureInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrobot_LinuxEnvTemperatureInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrobot_LinuxEnvTemperatureInfo(PathMetadata metadata, PathInits inits) {
        this(robot_LinuxEnvTemperatureInfo.class, metadata, inits);
    }

    public Qrobot_LinuxEnvTemperatureInfo(Class<? extends robot_LinuxEnvTemperatureInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

