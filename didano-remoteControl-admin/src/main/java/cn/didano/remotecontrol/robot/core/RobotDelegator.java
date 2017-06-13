package cn.didano.remotecontrol.robot.core;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

import cn.didano.base.model.Robot_School;
import cn.didano.remotecontrol.base.exception.BackType;
import cn.didano.remotecontrol.base.json.Out;
import cn.didano.remotecontrol.base.robot.service.Robot_SchoolService;
import cn.didano.remotecontrol.robot.controller.RobotUpController;

/**
 * 负责处理方法名称到实际方法调用，以映射方式实现
 * 
 * @author stephen.wang 2017年3月5日
 */
public class RobotDelegator {
	@Autowired
	private Robot_SchoolService fsnr_SchoolService;
	
	
	static Logger logger = Logger.getLogger(RobotDelegator.class);

	public RobotDelegator() {
	}

	/**
	 * 处理调用
	 * 
	 * @param robot
	 * @param report
	 */
	public void handle(String service_no, RobotUpController robot, UpInfo upInfo) {
		Object back = null;
		Out<String> out = new Out<String>();
		try {
			//yang 添加msql根据设备编号查询学校信息
			//得到设备编号
			Robot_School r_school=new Robot_School();
			Robot_School findSchollName=new Robot_School();
			if(upInfo.getDeviceNo()!=""){
				System.err.println(upInfo.getDeviceNo()+"____________________________");
				r_school.setDeviceNo(upInfo.getDeviceNo());
				System.err.println(r_school.getDeviceNo()+"<*******************************>");
				findSchollName = fsnr_SchoolService.findSchollName(r_school);
				if(findSchollName.getSchoolName()==null){
					findSchollName.setSchoolName("未知学校");
				}
			}else{
				findSchollName.setSchoolName("未知学校");
			}
			
			System.err.println(findSchollName.getSchoolName()+"------------------");
			//------------------------------------------------------------
			ObjectMapper mapper = new ObjectMapper();
			Class<?> para = getParameterType(robot, upInfo.getMethodName());
			if (para != null) {
				String jsonString = mapper.writeValueAsString(upInfo.getInfo());
				jsonString=jsonString.substring(0,jsonString.length()-1);
				jsonString+=",\"deviceNo\":\""+upInfo.getDeviceNo()+"\",\"systemType\":\""+upInfo.getSystem_type()+"\",\"schoolName\":\""+findSchollName.getSchoolName()+"\"}";
				System.err.println(jsonString+"--------");
				Object[] o = new Object[] { mapper.readValue(jsonString, para) };
				back = invokeMethod(robot, upInfo.getMethodName(), o);
				if (back == null) {// 说明出现了异常
					out.setBackTypeWithLog(BackType.FAIL_DIAGNOSE_WRONG);
				} else {
					out = (Out<String>) back;
				}
			} else {
				// para 参数找不到，说明method没找到
				out.setBackTypeWithLog(BackType.FAIL_DIAGNOSE_WRONG_METHOD);
			}
		} catch(UnrecognizedPropertyException ue){
			out.setBackTypeWithLog(BackType.FAIL_DIAGNOSE_WRONG_FORMAT,ue.getMessage());
		} catch (NoSuchMethodException | SecurityException | ClassNotFoundException e) {
			out.setBackTypeWithLog(BackType.FAIL_DIAGNOSE_WRONG);
		} catch (Exception ex) {
			out.setBackTypeWithLog(BackType.FAIL_DIAGNOSE_WRONG);
			ex.printStackTrace();
		}
		
		
		if (out.isSuccess()) {
			// 客户端上报信息，执行成功，则服务器端无返回信息
			// 什么也不做
		} else {
			// 有异常，反馈客户端错误信息
			RobotWebSocketHandler.sendMessage(service_no, out);
		}
	}

	/**
	 * 触发control方法
	 * 
	 * @param owner
	 * @param methodName
	 * @param args
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {
		Class ownerClass = owner.getClass();
		Class[] argsClass = new Class[args.length];
		for (int i = 0, j = args.length; i < j; i++) {
			argsClass[i] = args[i].getClass();
		}
		Method method = ownerClass.getMethod(methodName, argsClass);
		return method.invoke(owner, args);
	}

	/**
	 * 获取方法第一个参数，需要确保每个接口方法只有一个
	 * 
	 * @param owner
	 * @param mymethodName
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	private Class<?> getParameterType(Object owner, String mymethodName) {
		Class ownerClass = owner.getClass();
		Method[] methods = ownerClass.getMethods();
		for (Method method : methods) {
			String methodName = method.getName();
			while (methodName.equals(mymethodName)) {
				Class<?>[] parameterTypes = method.getParameterTypes();
				return parameterTypes[0];
			}
		}
		return null;
	}

}
