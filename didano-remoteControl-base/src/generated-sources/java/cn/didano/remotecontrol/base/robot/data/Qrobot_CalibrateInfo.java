package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrobot_CalibrateInfo is a Querydsl query type for robot_CalibrateInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qrobot_CalibrateInfo extends EntityPathBase<robot_CalibrateInfo> {

    private static final long serialVersionUID = -2131092418L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrobot_CalibrateInfo robot_CalibrateInfo = new Qrobot_CalibrateInfo("robot_CalibrateInfo");

    public final QrInfo _super;

    public final StringPath calibrate_raw_weight = createString("calibrate_raw_weight");

    public final StringPath calibrate_standard_weight = createString("calibrate_standard_weight");

    public final StringPath calibrate_zero_weight = createString("calibrate_zero_weight");

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final StringPath deviceNo = createString("deviceNo");

    // inherited
    public final org.bson.types.QObjectId id;

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version;

    public Qrobot_CalibrateInfo(String variable) {
        this(robot_CalibrateInfo.class, forVariable(variable), INITS);
    }

    public Qrobot_CalibrateInfo(Path<? extends robot_CalibrateInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrobot_CalibrateInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrobot_CalibrateInfo(PathMetadata metadata, PathInits inits) {
        this(robot_CalibrateInfo.class, metadata, inits);
    }

    public Qrobot_CalibrateInfo(Class<? extends robot_CalibrateInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

