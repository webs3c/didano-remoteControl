package cn.didano.base.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRobot_School is a Querydsl query type for Robot_School
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRobot_School extends EntityPathBase<Robot_School> {

    private static final long serialVersionUID = 805868035L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRobot_School robot_School = new QRobot_School("robot_School");

    public final cn.didano.remotecontrol.base.robot.data.QrInfo _super;

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final StringPath deviceNo = createString("deviceNo");

    // inherited
    public final org.bson.types.QObjectId id;

    public final StringPath schoolName = createString("schoolName");

    public final NumberPath<Integer> systemType = createNumber("systemType", Integer.class);

    //inherited
    public final NumberPath<Integer> version;

    public QRobot_School(String variable) {
        this(Robot_School.class, forVariable(variable), INITS);
    }

    public QRobot_School(Path<? extends Robot_School> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRobot_School(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRobot_School(PathMetadata metadata, PathInits inits) {
        this(Robot_School.class, metadata, inits);
    }

    public QRobot_School(Class<? extends Robot_School> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new cn.didano.remotecontrol.base.robot.data.QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

