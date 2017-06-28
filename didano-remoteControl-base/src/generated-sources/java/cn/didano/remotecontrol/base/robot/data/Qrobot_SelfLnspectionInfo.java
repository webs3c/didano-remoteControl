package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * Qrobot_SelfLnspectionInfo is a Querydsl query type for robot_SelfLnspectionInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class Qrobot_SelfLnspectionInfo extends EntityPathBase<robot_SelfLnspectionInfo> {

    private static final long serialVersionUID = -236677886L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final Qrobot_SelfLnspectionInfo robot_SelfLnspectionInfo = new Qrobot_SelfLnspectionInfo("robot_SelfLnspectionInfo");

    public final QrInfo _super;

    //inherited
    public final DateTimePath<java.util.Date> createDate;

    public final StringPath deviceNo = createString("deviceNo");

    // inherited
    public final org.bson.types.QObjectId id;

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
    public final NumberPath<Integer> version;

    public Qrobot_SelfLnspectionInfo(String variable) {
        this(robot_SelfLnspectionInfo.class, forVariable(variable), INITS);
    }

    public Qrobot_SelfLnspectionInfo(Path<? extends robot_SelfLnspectionInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public Qrobot_SelfLnspectionInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public Qrobot_SelfLnspectionInfo(PathMetadata metadata, PathInits inits) {
        this(robot_SelfLnspectionInfo.class, metadata, inits);
    }

    public Qrobot_SelfLnspectionInfo(Class<? extends robot_SelfLnspectionInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this._super = new QrInfo(type, metadata, inits);
        this.createDate = _super.createDate;
        this.id = _super.id;
        this.version = _super.version;
    }

}

