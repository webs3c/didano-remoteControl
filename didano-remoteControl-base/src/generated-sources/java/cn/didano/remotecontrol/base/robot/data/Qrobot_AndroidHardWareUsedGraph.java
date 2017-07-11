package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrobot_AndroidHardWareUsedGraph is a Querydsl query type for robot_AndroidHardWareUsedGraph
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qrobot_AndroidHardWareUsedGraph extends EntityPathBase<robot_AndroidHardWareUsedGraph> {

    private static final long serialVersionUID = 325855217L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrobot_AndroidHardWareUsedGraph robot_AndroidHardWareUsedGraph = new Qrobot_AndroidHardWareUsedGraph("robot_AndroidHardWareUsedGraph");

    public final QrInfo _super;

    public final StringPath android_cpu_used = createString("android_cpu_used");

    public final StringPath android_cpu_used2 = createString("android_cpu_used2");

    public final StringPath android_flash_used = createString("android_flash_used");

    public final StringPath android_flash_used2 = createString("android_flash_used2");

    public final StringPath android_memory_used = createString("android_memory_used");

    public final StringPath android_memory_used2 = createString("android_memory_used2");

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final NumberPath<Long> createDate1 = createNumber("createDate1", Long.class);

    public final NumberPath<Long> createDate2 = createNumber("createDate2", Long.class);

    // inherited
    public final org.bson.types.QObjectId id;

    public final StringPath linux_wifi_signal = createString("linux_wifi_signal");

    public final StringPath linux_wifi_signal2 = createString("linux_wifi_signal2");

    //inherited
    public final NumberPath<Integer> version;

    public Qrobot_AndroidHardWareUsedGraph(String variable) {
        this(robot_AndroidHardWareUsedGraph.class, forVariable(variable), INITS);
    }

    public Qrobot_AndroidHardWareUsedGraph(Path<? extends robot_AndroidHardWareUsedGraph> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrobot_AndroidHardWareUsedGraph(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrobot_AndroidHardWareUsedGraph(PathMetadata metadata, PathInits inits) {
        this(robot_AndroidHardWareUsedGraph.class, metadata, inits);
    }

    public Qrobot_AndroidHardWareUsedGraph(Class<? extends robot_AndroidHardWareUsedGraph> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

