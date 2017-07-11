package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrobot_AndriodCPUTemperatureGraph is a Querydsl query type for robot_AndriodCPUTemperatureGraph
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qrobot_AndriodCPUTemperatureGraph extends EntityPathBase<robot_AndriodCPUTemperatureGraph> {

    private static final long serialVersionUID = 1949878998L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrobot_AndriodCPUTemperatureGraph robot_AndriodCPUTemperatureGraph = new Qrobot_AndriodCPUTemperatureGraph("robot_AndriodCPUTemperatureGraph");

    public final QrInfo _super;

    public final StringPath android_cpu_temperature = createString("android_cpu_temperature");

    public final StringPath android_cpu_temperature2 = createString("android_cpu_temperature2");

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final NumberPath<Long> createDate1 = createNumber("createDate1", Long.class);

    public final NumberPath<Long> createDate2 = createNumber("createDate2", Long.class);

    // inherited
    public final org.bson.types.QObjectId id;

    //inherited
    public final NumberPath<Integer> version;

    public Qrobot_AndriodCPUTemperatureGraph(String variable) {
        this(robot_AndriodCPUTemperatureGraph.class, forVariable(variable), INITS);
    }

    public Qrobot_AndriodCPUTemperatureGraph(Path<? extends robot_AndriodCPUTemperatureGraph> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrobot_AndriodCPUTemperatureGraph(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrobot_AndriodCPUTemperatureGraph(PathMetadata metadata, PathInits inits) {
        this(robot_AndriodCPUTemperatureGraph.class, metadata, inits);
    }

    public Qrobot_AndriodCPUTemperatureGraph(Class<? extends robot_AndriodCPUTemperatureGraph> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

