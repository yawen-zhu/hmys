package com.hmys.frame.core.exception;

/**
 * 
 * @ClassName: DaoException
 * @Description: Dao层异常信息
 * @author zhuyawen
 * @date 2017年11月28日 下午10:44:26
 *
 */
public class DaoException extends RuntimeException {

	/**
	 * @fields serialVersionUID
	 */
	private static final long serialVersionUID = 8350049272861703406L;

	public DaoException() {
		super();
	}

	public DaoException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(String message) {
		super(message);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}

}
