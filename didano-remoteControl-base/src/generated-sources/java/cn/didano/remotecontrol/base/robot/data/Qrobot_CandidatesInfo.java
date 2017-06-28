package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrobot_CandidatesInfo is a Querydsl query type for robot_CandidatesInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qrobot_CandidatesInfo extends EntityPathBase<robot_CandidatesInfo> {

    private static final long serialVersionUID = 1505256725L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrobot_CandidatesInfo robot_CandidatesInfo = new Qrobot_CandidatesInfo("robot_CandidatesInfo");

    public final QrInfo _super;

    public final StringPath candidates_final_score = createString("candidates_final_score");

    public final StringPath candidates_height_diff = createString("candidates_height_diff");

    public final StringPath candidates_id = createString("candidates_id");

    public final StringPath candidates_lftface_brightness = createString("candidates_lftface_brightness");

    public final StringPath candidates_pic = createString("candidates_pic");

    public final StringPath candidates_rgtface_brightness = createString("candidates_rgtface_brightness");

    public final StringPath candidates_score = createString("candidates_score");

    public final StringPath candidates_sid = createString("candidates_sid");

    public final StringPath candidates_weight_diff = createString("candidates_weight_diff");

    public final StringPath candidates_whole_brightness = createString("candidates_whole_brightness");

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final StringPath deviceNo = createString("deviceNo");

    // inherited
    public final org.bson.types.QObjectId id;

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version;

    public Qrobot_CandidatesInfo(String variable) {
        this(robot_CandidatesInfo.class, forVariable(variable), INITS);
    }

    public Qrobot_CandidatesInfo(Path<? extends robot_CandidatesInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrobot_CandidatesInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrobot_CandidatesInfo(PathMetadata metadata, PathInits inits) {
        this(robot_CandidatesInfo.class, metadata, inits);
    }

    public Qrobot_CandidatesInfo(Class<? extends robot_CandidatesInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

