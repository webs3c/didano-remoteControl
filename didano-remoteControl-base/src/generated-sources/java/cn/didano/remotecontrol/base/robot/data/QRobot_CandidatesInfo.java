package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRobot_CandidatesInfo is a Querydsl query type for Robot_CandidatesInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRobot_CandidatesInfo extends EntityPathBase<Robot_CandidatesInfo> {

    private static final long serialVersionUID = 1702730037L;

    public static final QRobot_CandidatesInfo robot_CandidatesInfo = new QRobot_CandidatesInfo("robot_CandidatesInfo");

    public final QRInfo _super = new QRInfo(this);

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
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    public final StringPath deviceNo = createString("deviceNo");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QRobot_CandidatesInfo(String variable) {
        super(Robot_CandidatesInfo.class, forVariable(variable));
    }

    public QRobot_CandidatesInfo(Path<? extends Robot_CandidatesInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRobot_CandidatesInfo(PathMetadata metadata) {
        super(Robot_CandidatesInfo.class, metadata);
    }

}

