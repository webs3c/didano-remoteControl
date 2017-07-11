package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrobot_LinuxHardWareUsedGraph is a Querydsl query type for robot_LinuxHardWareUsedGraph
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qrobot_LinuxHardWareUsedGraph extends EntityPathBase<robot_LinuxHardWareUsedGraph> {

    private static final long serialVersionUID = 1505192396L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrobot_LinuxHardWareUsedGraph robot_LinuxHardWareUsedGraph = new Qrobot_LinuxHardWareUsedGraph("robot_LinuxHardWareUsedGraph");

    public final QrInfo _super;

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final NumberPath<Long> createDate1 = createNumber("createDate1", Long.class);

    public final NumberPath<Long> createDate2 = createNumber("createDate2", Long.class);

    // inherited
    public final org.bson.types.QObjectId id;

    public final StringPath linux_cpu_used = createString("linux_cpu_used");

    public final StringPath linux_cpu_used2 = createString("linux_cpu_used2");

    public final StringPath linux_flash_used = createString("linux_flash_used");

    public final StringPath linux_flash_used2 = createString("linux_flash_used2");

    public final StringPath linux_memory_used = createString("linux_memory_used");

    public final StringPath linux_memory_used2 = createString("linux_memory_used2");

    public final StringPath linux_wifi_signal = createString("linux_wifi_signal");

    public final StringPath linux_wifi_signal2 = createString("linux_wifi_signal2");

    //inherited
    public final NumberPath<Integer> version;

    public Qrobot_LinuxHardWareUsedGraph(String variable) {
        this(robot_LinuxHardWareUsedGraph.class, forVariable(variable), INITS);
    }

    public Qrobot_LinuxHardWareUsedGraph(Path<? extends robot_LinuxHardWareUsedGraph> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrobot_LinuxHardWareUsedGraph(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrobot_LinuxHardWareUsedGraph(PathMetadata metadata, PathInits inits) {
        this(robot_LinuxHardWareUsedGraph.class, metadata, inits);
    }

    public Qrobot_LinuxHardWareUsedGraph(Class<? extends robot_LinuxHardWareUsedGraph> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

