package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRobot_UploadType is a Querydsl query type for Robot_UploadType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRobot_UploadType extends EntityPathBase<Robot_UploadType> {

    private static final long serialVersionUID = -71100046L;

    public static final QRobot_UploadType robot_UploadType = new QRobot_UploadType("robot_UploadType");

    public final QRInfo _super = new QRInfo(this);

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    //inherited
    public final StringPath id = _super.id;

    public final StringPath methodName = createString("methodName");

    public final StringPath typeName = createString("typeName");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QRobot_UploadType(String variable) {
        super(Robot_UploadType.class, forVariable(variable));
    }

    public QRobot_UploadType(Path<? extends Robot_UploadType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRobot_UploadType(PathMetadata metadata) {
        super(Robot_UploadType.class, metadata);
    }

}

