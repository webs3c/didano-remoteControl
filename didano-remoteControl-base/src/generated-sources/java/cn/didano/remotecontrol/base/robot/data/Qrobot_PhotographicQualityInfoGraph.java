package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrobot_PhotographicQualityInfoGraph is a Querydsl query type for robot_PhotographicQualityInfoGraph
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qrobot_PhotographicQualityInfoGraph extends EntityPathBase<robot_PhotographicQualityInfoGraph> {

    private static final long serialVersionUID = -1689820082L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrobot_PhotographicQualityInfoGraph robot_PhotographicQualityInfoGraph = new Qrobot_PhotographicQualityInfoGraph("robot_PhotographicQualityInfoGraph");

    public final QrInfo _super;

    public final StringPath confidence_statistics_average = createString("confidence_statistics_average");

    public final StringPath confidence_statistics_average2 = createString("confidence_statistics_average2");

    public final StringPath confidence_statistics_max = createString("confidence_statistics_max");

    public final StringPath confidence_statistics_max2 = createString("confidence_statistics_max2");

    public final StringPath confidence_statistics_min = createString("confidence_statistics_min");

    public final StringPath confidence_statistics_min2 = createString("confidence_statistics_min2");

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final NumberPath<Long> createDate1 = createNumber("createDate1", Long.class);

    public final NumberPath<Long> createDate2 = createNumber("createDate2", Long.class);

    // inherited
    public final org.bson.types.QObjectId id;

    //inherited
    public final NumberPath<Integer> version;

    public Qrobot_PhotographicQualityInfoGraph(String variable) {
        this(robot_PhotographicQualityInfoGraph.class, forVariable(variable), INITS);
    }

    public Qrobot_PhotographicQualityInfoGraph(Path<? extends robot_PhotographicQualityInfoGraph> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrobot_PhotographicQualityInfoGraph(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrobot_PhotographicQualityInfoGraph(PathMetadata metadata, PathInits inits) {
        this(robot_PhotographicQualityInfoGraph.class, metadata, inits);
    }

    public Qrobot_PhotographicQualityInfoGraph(Class<? extends robot_PhotographicQualityInfoGraph> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

