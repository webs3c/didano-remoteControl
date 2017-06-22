package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRobot_FinalRecogResult is a Querydsl query type for Robot_FinalRecogResult
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRobot_FinalRecogResult extends EntityPathBase<Robot_FinalRecogResult> {

    private static final long serialVersionUID = -553481050L;

    public static final QRobot_FinalRecogResult robot_FinalRecogResult = new QRobot_FinalRecogResult("robot_FinalRecogResult");

    public final QRInfo _super = new QRInfo(this);

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    public final StringPath deviceNo = createString("deviceNo");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath recognition_result_id = createString("recognition_result_id");

    public final StringPath recognition_result_reason = createString("recognition_result_reason");

    public final StringPath recognition_result_scene = createString("recognition_result_scene");

    public final StringPath recognition_result_time_consumed_ms = createString("recognition_result_time_consumed_ms");

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QRobot_FinalRecogResult(String variable) {
        super(Robot_FinalRecogResult.class, forVariable(variable));
    }

    public QRobot_FinalRecogResult(Path<? extends Robot_FinalRecogResult> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRobot_FinalRecogResult(PathMetadata metadata) {
        super(Robot_FinalRecogResult.class, metadata);
    }

}

