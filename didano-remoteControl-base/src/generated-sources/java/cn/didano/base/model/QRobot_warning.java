package cn.didano.base.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRobot_warning is a Querydsl query type for Robot_warning
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRobot_warning extends EntityPathBase<Robot_warning> {

    private static final long serialVersionUID = 1049408269L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRobot_warning robot_warning = new QRobot_warning("robot_warning");

    public final cn.didano.remotecontrol.base.robot.data.QrInfo _super;

    public final StringPath betweenNumber = createString("betweenNumber");

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final StringPath deviceNo = createString("deviceNo");

    // inherited
    public final org.bson.types.QObjectId id;

    public final StringPath morningNumber = createString("morningNumber");

    public final StringPath schoolName = createString("schoolName");

    public final NumberPath<Integer> schoolNumber = createNumber("schoolNumber", Integer.class);

    public final NumberPath<Integer> systemType = createNumber("systemType", Integer.class);

    //inherited
    public final NumberPath<Integer> version;

    public QRobot_warning(String variable) {
        this(Robot_warning.class, forVariable(variable), INITS);
    }

    public QRobot_warning(Path<? extends Robot_warning> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRobot_warning(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRobot_warning(PathMetadata metadata, PathInits inits) {
        this(Robot_warning.class, metadata, inits);
    }

    public QRobot_warning(Class<? extends Robot_warning> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new cn.didano.remotecontrol.base.robot.data.QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

