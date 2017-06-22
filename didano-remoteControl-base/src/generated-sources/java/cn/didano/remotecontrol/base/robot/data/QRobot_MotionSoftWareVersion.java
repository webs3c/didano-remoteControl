package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRobot_MotionSoftWareVersion is a Querydsl query type for Robot_MotionSoftWareVersion
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRobot_MotionSoftWareVersion extends EntityPathBase<Robot_MotionSoftWareVersion> {

    private static final long serialVersionUID = 988385668L;

    public static final QRobot_MotionSoftWareVersion robot_MotionSoftWareVersion = new QRobot_MotionSoftWareVersion("robot_MotionSoftWareVersion");

    public final QRInfo _super = new QRInfo(this);

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    public final StringPath deviceNo = createString("deviceNo");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath motion_version_software = createString("motion_version_software");

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QRobot_MotionSoftWareVersion(String variable) {
        super(Robot_MotionSoftWareVersion.class, forVariable(variable));
    }

    public QRobot_MotionSoftWareVersion(Path<? extends Robot_MotionSoftWareVersion> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRobot_MotionSoftWareVersion(PathMetadata metadata) {
        super(Robot_MotionSoftWareVersion.class, metadata);
    }

}

