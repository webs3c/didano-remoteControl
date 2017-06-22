package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRobot_LinuxStartUpRecord is a Querydsl query type for Robot_LinuxStartUpRecord
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRobot_LinuxStartUpRecord extends EntityPathBase<Robot_LinuxStartUpRecord> {

    private static final long serialVersionUID = 1079108177L;

    public static final QRobot_LinuxStartUpRecord robot_LinuxStartUpRecord = new QRobot_LinuxStartUpRecord("robot_LinuxStartUpRecord");

    public final QRInfo _super = new QRInfo(this);

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    public final StringPath deviceNo = createString("deviceNo");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath poweroff_time = createString("poweroff_time");

    public final StringPath schoolName = createString("schoolName");

    public final StringPath startup_reason = createString("startup_reason");

    public final StringPath startup_time = createString("startup_time");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QRobot_LinuxStartUpRecord(String variable) {
        super(Robot_LinuxStartUpRecord.class, forVariable(variable));
    }

    public QRobot_LinuxStartUpRecord(Path<? extends Robot_LinuxStartUpRecord> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRobot_LinuxStartUpRecord(PathMetadata metadata) {
        super(Robot_LinuxStartUpRecord.class, metadata);
    }

}

