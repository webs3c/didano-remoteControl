package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRobot_LinuxSoftWareVersion is a Querydsl query type for Robot_LinuxSoftWareVersion
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRobot_LinuxSoftWareVersion extends EntityPathBase<Robot_LinuxSoftWareVersion> {

    private static final long serialVersionUID = 534733140L;

    public static final QRobot_LinuxSoftWareVersion robot_LinuxSoftWareVersion = new QRobot_LinuxSoftWareVersion("robot_LinuxSoftWareVersion");

    public final QRInfo _super = new QRInfo(this);

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    public final StringPath deviceNo = createString("deviceNo");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath linux_version_kernel = createString("linux_version_kernel");

    public final StringPath linux_version_software = createString("linux_version_software");

    public final StringPath linux_version_system = createString("linux_version_system");

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QRobot_LinuxSoftWareVersion(String variable) {
        super(Robot_LinuxSoftWareVersion.class, forVariable(variable));
    }

    public QRobot_LinuxSoftWareVersion(Path<? extends Robot_LinuxSoftWareVersion> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRobot_LinuxSoftWareVersion(PathMetadata metadata) {
        super(Robot_LinuxSoftWareVersion.class, metadata);
    }

}

