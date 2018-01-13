package com.hmys.frame.core.constants;

/**
 * 
 * @ClassName: SqlId
 * @Description: TODO
 * @author zhuyawen
 * @date 2017-11-29
 *
 */
public interface SqlId {
	public String SQL_SELECT_COUNT = "selectCount";
	public String SQL_SELECT = "select";
	public String SQL_EXIST = "exist";
	public String SQL_LOAD = "load";
	public String SQL_LOAD_EQUAL = "load_equal";
	public String SQL_SELECT_BY_PRIMARY_KEY = "selectByPrimaryKey";
	public String SQL_UPDATE_BY_ID = "updateByPrimaryKey";
	public String SQL_UPDATE_BY_ID_SELECTIVE = "updateByPrimaryKeySelective";
	public String SQL_DELETE = "delete";
	public String SQL_DELETE_ALL = "delete_all";
	public String SQL_DELETE_BATCH = "delete_batch";
	public String SQL_DELETE_BY_ID = "deleteById";
	public String SQL_INSERT = "insert";
	public String SQL_INSERT_SELECTIVE = "insertSelective";
	public String SQL_INSERT_BATCH = "insert_batch";
	/** 多表关联的自定义sql语句 */
	public String SQL_SELECT_LIST = "select_list";
}
