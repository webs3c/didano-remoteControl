package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrobot_AndriodCPUTemperature is a Querydsl query type for robot_AndriodCPUTemperature
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qrobot_AndriodCPUTemperature extends EntityPathBase<robot_AndriodCPUTemperature> {

    private static final long serialVersionUID = 2089393496L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrobot_AndriodCPUTemperature robot_AndriodCPUTemperature = new Qrobot_AndriodCPUTemperature("robot_AndriodCPUTemperature");

    public final QrInfo _super;

    public final StringPath android_cpu_temperature = createString("android_cpu_temperature");

    public final StringPath android_temperature_time = createString("android_temperature_time");

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final StringPath deviceNo = createString("deviceNo");

    // inherited
    public final org.bson.types.QObjectId id;

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version;

    public Qrobot_AndriodCPUTemperature(String variable) {
        this(robot_AndriodCPUTemperature.class, forVariable(variable), INITS);
    }

    public Qrobot_AndriodCPUTemperature(Path<? extends robot_AndriodCPUTemperature> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrobot_AndriodCPUTemperature(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrobot_AndriodCPUTemperature(PathMetadata metadata, PathInits inits) {
        this(robot_AndriodCPUTemperature.class, metadata, inits);
    }

    public Qrobot_AndriodCPUTemperature(Class<? extends robot_AndriodCPUTemperature> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

