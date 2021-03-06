package com.mvn.core.base;

import com.mvn.core.dao.GeneralMapper;
import com.mvn.core.entity.Pagination;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 基础业务接口实现类
 *
 * @author Created by LiYao on 2017-03-03 22:38.
 */
public class BaseServiceImpl implements BaseService {

	@Autowired
	private GeneralMapper generalMapper;

	@Override
	public <T> T selectOne(Class<T> clazz, String where) {
		List<T> list = this.selectAll(clazz, where);
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public <T> T selectById(Class<T> clazz, Object id) {
		if (id == null) {
			return null;
		}
		List<T> list = generalMapper.selectById(clazz, id);
		if (list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public <T> List<T> selectAll(Class<T> clazz, String where) {
		return generalMapper.selectAll(clazz, where);
	}

	@Override
	public <T> List<T> selectByPage(Class<T> clazz, Pagination<T> pagination, String where) {
		return generalMapper.selectByPage(clazz, pagination, where);
	}

	@Override
	public <T> int insert(T obj) {
		return generalMapper.insert(obj);
	}

	@Override
	public <T> int insertList(List<T> list) {
		return generalMapper.insertList(list);
	}

	@Override
	public <T> int delete(T obj) {
		return generalMapper.delete(obj);
	}

	@Override
	public <T> int update(T obj) {
		return generalMapper.update(obj);
	}
}
