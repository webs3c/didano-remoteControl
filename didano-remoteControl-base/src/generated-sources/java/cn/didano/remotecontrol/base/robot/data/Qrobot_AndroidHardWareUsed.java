package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrobot_AndroidHardWareUsed is a Querydsl query type for robot_AndroidHardWareUsed
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qrobot_AndroidHardWareUsed extends EntityPathBase<robot_AndroidHardWareUsed> {

    private static final long serialVersionUID = 200358749L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrobot_AndroidHardWareUsed robot_AndroidHardWareUsed = new Qrobot_AndroidHardWareUsed("robot_AndroidHardWareUsed");

    public final QrInfo _super;

    public final StringPath android_cpu_used = createString("android_cpu_used");

    public final StringPath android_cpu_used_app = createString("android_cpu_used_app");

    public final StringPath android_cpu_used_time = createString("android_cpu_used_time");

    public final StringPath android_flash_used = createString("android_flash_used");

    public final StringPath android_flash_used_time = createString("android_flash_used_time");

    public final StringPath android_memory_used = createString("android_memory_used");

    public final StringPath android_memory_used_app = createString("android_memory_used_app");

    public final StringPath android_memory_used_time = createString("android_memory_used_time");

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final StringPath deviceNo = createString("deviceNo");

    // inherited
    public final org.bson.types.QObjectId id;

    public final StringPath linux_wifi_signal = createString("linux_wifi_signal");

    public final StringPath linux_wifi_signal_time = createString("linux_wifi_signal_time");

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version;

    public Qrobot_AndroidHardWareUsed(String variable) {
        this(robot_AndroidHardWareUsed.class, forVariable(variable), INITS);
    }

    public Qrobot_AndroidHardWareUsed(Path<? extends robot_AndroidHardWareUsed> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrobot_AndroidHardWareUsed(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrobot_AndroidHardWareUsed(PathMetadata metadata, PathInits inits) {
        this(robot_AndroidHardWareUsed.class, metadata, inits);
    }

    public Qrobot_AndroidHardWareUsed(Class<? extends robot_AndroidHardWareUsed> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

