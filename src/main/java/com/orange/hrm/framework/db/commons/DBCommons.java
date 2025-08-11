package com.orange.hrm.framework.db.commons;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.orange.hrm.framework.utilities.DBUtil;

public class DBCommons {
	public static List<Map<String,String>> readdata(String Query) throws SQLException
	{
	List<Map<String,String>>datalist=new ArrayList<>();	
	ResultSet dataset=DBUtil.getData(Query);
	while(dataset.next())
	{
		Map<String,String>rowdata=new HashMap<>();
		for(int c=1;c<dataset.getMetaData().getColumnCount();c++)
		{
		String ColumnName=dataset.getMetaData().getColumnName(c);
		String ColumnValue=dataset.getString(c);
		rowdata.put(ColumnName, ColumnValue);
		}
		datalist.add(rowdata);
	}
	return datalist;
	}
}
