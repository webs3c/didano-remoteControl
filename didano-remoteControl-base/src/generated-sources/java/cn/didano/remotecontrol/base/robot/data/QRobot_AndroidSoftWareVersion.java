package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRobot_AndroidSoftWareVersion is a Querydsl query type for Robot_AndroidSoftWareVersion
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRobot_AndroidSoftWareVersion extends EntityPathBase<Robot_AndroidSoftWareVersion> {

    private static final long serialVersionUID = 1150344377L;

    public static final QRobot_AndroidSoftWareVersion robot_AndroidSoftWareVersion = new QRobot_AndroidSoftWareVersion("robot_AndroidSoftWareVersion");

    public final QRInfo _super = new QRInfo(this);

    public final StringPath andriod_version_kernel = createString("andriod_version_kernel");

    public final StringPath andriod_version_software = createString("andriod_version_software");

    public final StringPath andriod_version_system = createString("andriod_version_system");

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    public final StringPath deviceNo = createString("deviceNo");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QRobot_AndroidSoftWareVersion(String variable) {
        super(Robot_AndroidSoftWareVersion.class, forVariable(variable));
    }

    public QRobot_AndroidSoftWareVersion(Path<? extends Robot_AndroidSoftWareVersion> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRobot_AndroidSoftWareVersion(PathMetadata metadata) {
        super(Robot_AndroidSoftWareVersion.class, metadata);
    }

}

