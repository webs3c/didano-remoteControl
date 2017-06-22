package cn.didano.remotecontrol.base.robot.data;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRInfo is a Querydsl query type for RInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRInfo extends EntityPathBase<RInfo> {

    private static final long serialVersionUID = 381812222L;

    public static final QRInfo rInfo = new QRInfo("rInfo");

    public final DateTimePath<java.util.Date> createDate = createDateTime("createDate", java.util.Date.class);

    public final StringPath id = createString("id");

    public final NumberPath<Integer> version = createNumber("version", Integer.class);

    public QRInfo(String variable) {
        super(RInfo.class, forVariable(variable));
    }

    public QRInfo(Path<? extends RInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRInfo(PathMetadata metadata) {
        super(RInfo.class, metadata);
    }

}

