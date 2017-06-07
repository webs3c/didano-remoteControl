package cn.didano.remotecontrol.base.robot.data.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import cn.didano.remotecontrol.base.robot.data.Robot_UploadType;
/**
 * 硬件信息容器
 * @author stephen.wang  2017年3月14日 
 */
public interface TypeNameRepository extends MongoRepository<Robot_UploadType, String> {
}
