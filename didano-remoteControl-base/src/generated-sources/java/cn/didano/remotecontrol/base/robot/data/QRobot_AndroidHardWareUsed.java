package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRobot_AndroidHardWareUsed is a Querydsl query type for Robot_AndroidHardWareUsed
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRobot_AndroidHardWareUsed extends EntityPathBase<Robot_AndroidHardWareUsed> {

    private static final long serialVersionUID = -2048419011L;

    public static final QRobot_AndroidHardWareUsed robot_AndroidHardWareUsed = new QRobot_AndroidHardWareUsed("robot_AndroidHardWareUsed");

    public final QRInfo _super = new QRInfo(this);

    public final StringPath android_cpu_used = createString("android_cpu_used");

    public final StringPath android_cpu_used_app = createString("android_cpu_used_app");

    public final StringPath android_cpu_used_time = createString("android_cpu_used_time");

    public final StringPath android_flash_used = createString("android_flash_used");

    public final StringPath android_flash_used_time = createString("android_flash_used_time");

    public final StringPath android_memory_used = createString("android_memory_used");

    public final StringPath android_memory_used_app = createString("android_memory_used_app");

    public final StringPath android_memory_used_time = createString("android_memory_used_time");

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    public final StringPath deviceNo = createString("deviceNo");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath linux_wifi_signal = createString("linux_wifi_signal");

    public final StringPath linux_wifi_signal_time = createString("linux_wifi_signal_time");

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QRobot_AndroidHardWareUsed(String variable) {
        super(Robot_AndroidHardWareUsed.class, forVariable(variable));
    }

    public QRobot_AndroidHardWareUsed(Path<? extends Robot_AndroidHardWareUsed> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRobot_AndroidHardWareUsed(PathMetadata metadata) {
        super(Robot_AndroidHardWareUsed.class, metadata);
    }

}

