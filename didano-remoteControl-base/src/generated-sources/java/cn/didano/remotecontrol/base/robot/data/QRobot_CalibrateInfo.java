package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRobot_CalibrateInfo is a Querydsl query type for Robot_CalibrateInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRobot_CalibrateInfo extends EntityPathBase<Robot_CalibrateInfo> {

    private static final long serialVersionUID = -877796322L;

    public static final QRobot_CalibrateInfo robot_CalibrateInfo = new QRobot_CalibrateInfo("robot_CalibrateInfo");

    public final QRInfo _super = new QRInfo(this);

    public final StringPath calibrate_raw_weight = createString("calibrate_raw_weight");

    public final StringPath calibrate_standard_weight = createString("calibrate_standard_weight");

    public final StringPath calibrate_zero_weight = createString("calibrate_zero_weight");

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    public final StringPath deviceNo = createString("deviceNo");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QRobot_CalibrateInfo(String variable) {
        super(Robot_CalibrateInfo.class, forVariable(variable));
    }

    public QRobot_CalibrateInfo(Path<? extends Robot_CalibrateInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRobot_CalibrateInfo(PathMetadata metadata) {
        super(Robot_CalibrateInfo.class, metadata);
    }

}

