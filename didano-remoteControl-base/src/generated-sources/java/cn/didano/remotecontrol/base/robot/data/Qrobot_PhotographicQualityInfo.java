package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrobot_PhotographicQualityInfo is a Querydsl query type for robot_PhotographicQualityInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qrobot_PhotographicQualityInfo extends EntityPathBase<robot_PhotographicQualityInfo> {

    private static final long serialVersionUID = 1974401248L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrobot_PhotographicQualityInfo robot_PhotographicQualityInfo = new Qrobot_PhotographicQualityInfo("robot_PhotographicQualityInfo");

    public final QrInfo _super;

    public final StringPath confidence_statistics_average = createString("confidence_statistics_average");

    public final StringPath confidence_statistics_max = createString("confidence_statistics_max");

    public final StringPath confidence_statistics_min = createString("confidence_statistics_min");

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final StringPath deviceNo = createString("deviceNo");

    // inherited
    public final org.bson.types.QObjectId id;

    public final StringPath schoolName = createString("schoolName");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version;

    public Qrobot_PhotographicQualityInfo(String variable) {
        this(robot_PhotographicQualityInfo.class, forVariable(variable), INITS);
    }

    public Qrobot_PhotographicQualityInfo(Path<? extends robot_PhotographicQualityInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrobot_PhotographicQualityInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrobot_PhotographicQualityInfo(PathMetadata metadata, PathInits inits) {
        this(robot_PhotographicQualityInfo.class, metadata, inits);
    }

    public Qrobot_PhotographicQualityInfo(Class<? extends robot_PhotographicQualityInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

