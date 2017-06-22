package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRobot_AppRunningStatus is a Querydsl query type for Robot_AppRunningStatus
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRobot_AppRunningStatus extends EntityPathBase<Robot_AppRunningStatus> {

    private static final long serialVersionUID = -280486585L;

    public static final QRobot_AppRunningStatus robot_AppRunningStatus = new QRobot_AppRunningStatus("robot_AppRunningStatus");

    public final QRInfo _super = new QRInfo(this);

    public final StringPath android_app_status = createString("android_app_status");

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    public final StringPath deviceNo = createString("deviceNo");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath linux_app_status = createString("linux_app_status");

    public final StringPath motion_app_status = createString("motion_app_status");

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QRobot_AppRunningStatus(String variable) {
        super(Robot_AppRunningStatus.class, forVariable(variable));
    }

    public QRobot_AppRunningStatus(Path<? extends Robot_AppRunningStatus> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRobot_AppRunningStatus(PathMetadata metadata) {
        super(Robot_AppRunningStatus.class, metadata);
    }

}

