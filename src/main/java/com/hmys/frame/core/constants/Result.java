package com.hmys.frame.core.constants;

import java.io.Serializable;

/**
 * @Description:  
 * @Author:  yawen.zhu
 * @Date:  2017/12/2 11:57
 * @Modified:
 */
public class Result implements Serializable {
	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = 5905715228490291386L;
	/**
	 * @fields status 状态信息，正确返回OK，否则返回 ERROR，如果返回ERROR则需要填写Message信息
	 */
	private Status status;
	/**
	 * @fields record 消息对象
	 */
	private Object message;

	/**
	 * 预留字段
	 */
	private boolean success;

	/**
	 * @fields 修改时候给form赋值（修改时，获取到一条数据后，json必须的两个参数data和success，
	 *         否则不会进入到js的success方法，请参考用户管理修改。 ）
	 */
	private Object data;

	public Result() {
		super();
	}

	/**
	 * @description
	 * @param status
	 *            状态
	 * @param message
	 *            消息
	 */
	public Result(Status status, Object message) {
		this.status = status;
		this.message = message;
	}

	/**
	 * 
	 * @ClassName: Status
	 * @Description: 结果类型信息
	 * @author zhangl
	 * @date 2016年9月15日 上午10:32:57
	 *
	 */
	public enum Status {
		OK, ERROR
	}

	/**
	 * 添加成功结果信息
	 * 
	 * @param message
	 */
	public void addOK(Object message) {
		this.message = message;
		this.status = Status.OK;
	}

	/**
	 * 添加错误消息
	 * 
	 * @param message
	 */
	public void addError(Object message) {
		this.message = message;
		this.status = Status.ERROR;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public boolean isSuccess() {
		if (status != null && status == Status.OK) {
			return true;
		}
		return false;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}