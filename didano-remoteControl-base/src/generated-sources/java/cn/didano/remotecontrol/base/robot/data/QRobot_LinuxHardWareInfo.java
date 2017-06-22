package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRobot_LinuxHardWareInfo is a Querydsl query type for Robot_LinuxHardWareInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRobot_LinuxHardWareInfo extends EntityPathBase<Robot_LinuxHardWareInfo> {

    private static final long serialVersionUID = -1168355981L;

    public static final QRobot_LinuxHardWareInfo robot_LinuxHardWareInfo = new QRobot_LinuxHardWareInfo("robot_LinuxHardWareInfo");

    public final QRInfo _super = new QRInfo(this);

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    public final StringPath deviceNo = createString("deviceNo");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath linux_hard_ecid_0 = createString("linux_hard_ecid_0");

    public final StringPath linux_hard_ecid_1 = createString("linux_hard_ecid_1");

    public final StringPath linux_hard_ecid_2 = createString("linux_hard_ecid_2");

    public final StringPath linux_hard_ecid_3 = createString("linux_hard_ecid_3");

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QRobot_LinuxHardWareInfo(String variable) {
        super(Robot_LinuxHardWareInfo.class, forVariable(variable));
    }

    public QRobot_LinuxHardWareInfo(Path<? extends Robot_LinuxHardWareInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRobot_LinuxHardWareInfo(PathMetadata metadata) {
        super(Robot_LinuxHardWareInfo.class, metadata);
    }

}

