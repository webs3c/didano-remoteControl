package cn.didano.base.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRobot_School is a Querydsl query type for Robot_School
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRobot_School extends EntityPathBase<Robot_School> {

    private static final long serialVersionUID = 805868035L;

    public static final QRobot_School robot_School = new QRobot_School("robot_School");

    public final cn.didano.remotecontrol.base.robot.data.QRInfo _super = new cn.didano.remotecontrol.base.robot.data.QRInfo(this);

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    public final StringPath deviceNo = createString("deviceNo");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath schoolName = createString("schoolName");

    public final NumberPath<Integer> systemType = createNumber("systemType", Integer.class);

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QRobot_School(String variable) {
        super(Robot_School.class, forVariable(variable));
    }

    public QRobot_School(Path<? extends Robot_School> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRobot_School(PathMetadata metadata) {
        super(Robot_School.class, metadata);
    }

}

