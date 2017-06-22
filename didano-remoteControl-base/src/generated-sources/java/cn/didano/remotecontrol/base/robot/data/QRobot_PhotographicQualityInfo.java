package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRobot_PhotographicQualityInfo is a Querydsl query type for Robot_PhotographicQualityInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRobot_PhotographicQualityInfo extends EntityPathBase<Robot_PhotographicQualityInfo> {

    private static final long serialVersionUID = 1269983424L;

    public static final QRobot_PhotographicQualityInfo robot_PhotographicQualityInfo = new QRobot_PhotographicQualityInfo("robot_PhotographicQualityInfo");

    public final QRInfo _super = new QRInfo(this);

    public final StringPath confidence_statistics_average = createString("confidence_statistics_average");

    public final StringPath confidence_statistics_max = createString("confidence_statistics_max");

    public final StringPath confidence_statistics_min = createString("confidence_statistics_min");

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    public final StringPath deviceNo = createString("deviceNo");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QRobot_PhotographicQualityInfo(String variable) {
        super(Robot_PhotographicQualityInfo.class, forVariable(variable));
    }

    public QRobot_PhotographicQualityInfo(Path<? extends Robot_PhotographicQualityInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRobot_PhotographicQualityInfo(PathMetadata metadata) {
        super(Robot_PhotographicQualityInfo.class, metadata);
    }

}

