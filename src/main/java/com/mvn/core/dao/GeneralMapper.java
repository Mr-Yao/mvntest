package com.mvn.core.dao;

import com.mvn.core.mybatis.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * mvntest
 *
 * @author Created by LiYao on 2017-03-03 22:46.
 */
@Repository
public interface GeneralMapper extends BaseMapper {

    
	int executeSql(@Param("sql") String sql);

}
