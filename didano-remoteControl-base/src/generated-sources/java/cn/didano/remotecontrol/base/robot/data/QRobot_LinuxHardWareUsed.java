package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRobot_LinuxHardWareUsed is a Querydsl query type for Robot_LinuxHardWareUsed
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRobot_LinuxHardWareUsed extends EntityPathBase<Robot_LinuxHardWareUsed> {

    private static final long serialVersionUID = -1167993726L;

    public static final QRobot_LinuxHardWareUsed robot_LinuxHardWareUsed = new QRobot_LinuxHardWareUsed("robot_LinuxHardWareUsed");

    public final QRInfo _super = new QRInfo(this);

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    public final StringPath deviceNo = createString("deviceNo");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath linux_cpu_used = createString("linux_cpu_used");

    public final StringPath linux_cpu_used_app = createString("linux_cpu_used_app");

    public final StringPath linux_cpu_used_time = createString("linux_cpu_used_time");

    public final StringPath linux_flash_used = createString("linux_flash_used");

    public final StringPath linux_flash_used_time = createString("linux_flash_used_time");

    public final StringPath linux_memory_used = createString("linux_memory_used");

    public final StringPath linux_memory_used_app = createString("linux_memory_used_app");

    public final StringPath linux_memory_used_time = createString("linux_memory_used_time");

    public final StringPath linux_wifi_signal = createString("linux_wifi_signal");

    public final StringPath linux_wifi_signal_time = createString("linux_wifi_signal_time");

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QRobot_LinuxHardWareUsed(String variable) {
        super(Robot_LinuxHardWareUsed.class, forVariable(variable));
    }

    public QRobot_LinuxHardWareUsed(Path<? extends Robot_LinuxHardWareUsed> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRobot_LinuxHardWareUsed(PathMetadata metadata) {
        super(Robot_LinuxHardWareUsed.class, metadata);
    }

}

