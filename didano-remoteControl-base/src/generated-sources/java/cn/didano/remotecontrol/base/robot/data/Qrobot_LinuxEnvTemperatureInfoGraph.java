package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrobot_LinuxEnvTemperatureInfoGraph is a Querydsl query type for robot_LinuxEnvTemperatureInfoGraph
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qrobot_LinuxEnvTemperatureInfoGraph extends EntityPathBase<robot_LinuxEnvTemperatureInfoGraph> {

    private static final long serialVersionUID = 310787036L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrobot_LinuxEnvTemperatureInfoGraph robot_LinuxEnvTemperatureInfoGraph = new Qrobot_LinuxEnvTemperatureInfoGraph("robot_LinuxEnvTemperatureInfoGraph");

    public final QrInfo _super;

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final NumberPath<Long> createDate1 = createNumber("createDate1", Long.class);

    public final NumberPath<Long> createDate2 = createNumber("createDate2", Long.class);

    // inherited
    public final org.bson.types.QObjectId id;

    public final StringPath linux_cpu_temperature = createString("linux_cpu_temperature");

    public final StringPath linux_cpu_temperature2 = createString("linux_cpu_temperature2");

    public final StringPath linux_env_temperature = createString("linux_env_temperature");

    public final StringPath linux_env_temperature2 = createString("linux_env_temperature2");

    //inherited
    public final NumberPath<Integer> version;

    public Qrobot_LinuxEnvTemperatureInfoGraph(String variable) {
        this(robot_LinuxEnvTemperatureInfoGraph.class, forVariable(variable), INITS);
    }

    public Qrobot_LinuxEnvTemperatureInfoGraph(Path<? extends robot_LinuxEnvTemperatureInfoGraph> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrobot_LinuxEnvTemperatureInfoGraph(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrobot_LinuxEnvTemperatureInfoGraph(PathMetadata metadata, PathInits inits) {
        this(robot_LinuxEnvTemperatureInfoGraph.class, metadata, inits);
    }

    public Qrobot_LinuxEnvTemperatureInfoGraph(Class<? extends robot_LinuxEnvTemperatureInfoGraph> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

