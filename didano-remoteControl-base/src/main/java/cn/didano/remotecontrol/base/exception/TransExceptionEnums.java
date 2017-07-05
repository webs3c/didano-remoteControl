package cn.didano.remotecontrol.base.exception;

/**
 * 数据库操作检测错误信息 准备去掉这个
 * 
 * @author stephen Created on 2016年12月26日 上午11:24:32
 */
public class TransExceptionEnums implements ExceptionEnums {
	private BackType backType;

	public TransExceptionEnums(BackType backType) {
		this.backType = backType;
	}

	@Override
	public int getCode() {
		return backType.getCode();
	}

	@Override
	public String getMessage() {
		return backType.getMessage();
	}

}