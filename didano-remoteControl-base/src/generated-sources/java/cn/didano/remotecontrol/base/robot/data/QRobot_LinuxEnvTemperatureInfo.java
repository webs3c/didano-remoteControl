package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRobot_LinuxEnvTemperatureInfo is a Querydsl query type for Robot_LinuxEnvTemperatureInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRobot_LinuxEnvTemperatureInfo extends EntityPathBase<Robot_LinuxEnvTemperatureInfo> {

    private static final long serialVersionUID = 20090994L;

    public static final QRobot_LinuxEnvTemperatureInfo robot_LinuxEnvTemperatureInfo = new QRobot_LinuxEnvTemperatureInfo("robot_LinuxEnvTemperatureInfo");

    public final QRInfo _super = new QRInfo(this);

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    public final StringPath deviceNo = createString("deviceNo");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath linux_cpu_temperature = createString("linux_cpu_temperature");

    public final StringPath linux_env_temperature = createString("linux_env_temperature");

    public final StringPath linux_temperature_time = createString("linux_temperature_time");

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QRobot_LinuxEnvTemperatureInfo(String variable) {
        super(Robot_LinuxEnvTemperatureInfo.class, forVariable(variable));
    }

    public QRobot_LinuxEnvTemperatureInfo(Path<? extends Robot_LinuxEnvTemperatureInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRobot_LinuxEnvTemperatureInfo(PathMetadata metadata) {
        super(Robot_LinuxEnvTemperatureInfo.class, metadata);
    }

}

