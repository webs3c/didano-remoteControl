package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrobot_LinuxHardWareUsed is a Querydsl query type for robot_LinuxHardWareUsed
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qrobot_LinuxHardWareUsed extends EntityPathBase<robot_LinuxHardWareUsed> {

    private static final long serialVersionUID = 9764002L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrobot_LinuxHardWareUsed robot_LinuxHardWareUsed = new Qrobot_LinuxHardWareUsed("robot_LinuxHardWareUsed");

    public final QrInfo _super;

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final StringPath deviceNo = createString("deviceNo");

    // inherited
    public final org.bson.types.QObjectId id;

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
    public final NumberPath<Integer> version;

    public Qrobot_LinuxHardWareUsed(String variable) {
        this(robot_LinuxHardWareUsed.class, forVariable(variable), INITS);
    }

    public Qrobot_LinuxHardWareUsed(Path<? extends robot_LinuxHardWareUsed> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrobot_LinuxHardWareUsed(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrobot_LinuxHardWareUsed(PathMetadata metadata, PathInits inits) {
        this(robot_LinuxHardWareUsed.class, metadata, inits);
    }

    public Qrobot_LinuxHardWareUsed(Class<? extends robot_LinuxHardWareUsed> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

