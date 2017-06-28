package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrobot_FinalRecogResult is a Querydsl query type for robot_FinalRecogResult
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qrobot_FinalRecogResult extends EntityPathBase<robot_FinalRecogResult> {

    private static final long serialVersionUID = -1346772858L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrobot_FinalRecogResult robot_FinalRecogResult = new Qrobot_FinalRecogResult("robot_FinalRecogResult");

    public final QrInfo _super;

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final StringPath deviceNo = createString("deviceNo");

    // inherited
    public final org.bson.types.QObjectId id;

    public final StringPath recognition_result_id = createString("recognition_result_id");

    public final StringPath recognition_result_reason = createString("recognition_result_reason");

    public final StringPath recognition_result_scene = createString("recognition_result_scene");

    public final StringPath recognition_result_time_consumed_ms = createString("recognition_result_time_consumed_ms");

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version;

    public Qrobot_FinalRecogResult(String variable) {
        this(robot_FinalRecogResult.class, forVariable(variable), INITS);
    }

    public Qrobot_FinalRecogResult(Path<? extends robot_FinalRecogResult> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrobot_FinalRecogResult(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrobot_FinalRecogResult(PathMetadata metadata, PathInits inits) {
        this(robot_FinalRecogResult.class, metadata, inits);
    }

    public Qrobot_FinalRecogResult(Class<? extends robot_FinalRecogResult> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

