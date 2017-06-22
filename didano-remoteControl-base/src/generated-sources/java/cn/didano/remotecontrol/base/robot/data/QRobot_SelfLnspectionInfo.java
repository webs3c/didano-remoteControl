package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRobot_SelfLnspectionInfo is a Querydsl query type for Robot_SelfLnspectionInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRobot_SelfLnspectionInfo extends EntityPathBase<Robot_SelfLnspectionInfo> {

    private static final long serialVersionUID = 1907538210L;

    public static final QRobot_SelfLnspectionInfo robot_SelfLnspectionInfo = new QRobot_SelfLnspectionInfo("robot_SelfLnspectionInfo");

    public final QRInfo _super = new QRInfo(this);

    //inherited
    public final DateTimePath<java.util.Date> createDate = _super.createDate;

    public final StringPath deviceNo = createString("deviceNo");

    //inherited
    public final StringPath id = _super.id;

    public final StringPath schoolName = createString("schoolName");

    public final StringPath selfcheck_black_camera = createString("selfcheck_black_camera");

    public final StringPath selfcheck_color_camera = createString("selfcheck_color_camera");

    public final StringPath selfcheck_face_camera = createString("selfcheck_face_camera");

    public final StringPath selfcheck_lepton = createString("selfcheck_lepton");

    public final StringPath selfcheck_motion = createString("selfcheck_motion");

    public final StringPath selfcheck_qrcode_camera = createString("selfcheck_qrcode_camera");

    public final StringPath selfcheck_rfid = createString("selfcheck_rfid");

    public final StringPath selfcheck_voice = createString("selfcheck_voice");

    public final StringPath systemType = createString("systemType");

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QRobot_SelfLnspectionInfo(String variable) {
        super(Robot_SelfLnspectionInfo.class, forVariable(variable));
    }

    public QRobot_SelfLnspectionInfo(Path<? extends Robot_SelfLnspectionInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRobot_SelfLnspectionInfo(PathMetadata metadata) {
        super(Robot_SelfLnspectionInfo.class, metadata);
    }

}

