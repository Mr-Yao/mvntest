package test;

import com.mvn.core.base.BaseService;
import com.mvn.core.entity.Pagination;
import com.mvn.core.mybatis.CRUDTemplate;
import com.mvn.user.entity.User;
import com.mvn.web.FileRead;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-main.xml" })

public class Test {

	private static final Logger LOG = LoggerFactory.getLogger(Test.class);

	@Autowired
	private BaseService bs;

	public static void main(String[] args) throws Exception {
	}

	public void test1() {

	}

	@org.junit.Test
	public void test2() {
		List<User> list = bs.selectAll(User.class, "");
		for (Object obj : list) {
			System.err.println(obj);
		}
	}

	@org.junit.Test
	public void test3() throws Exception {
		Pagination<User> page = new Pagination<>();
		List<User> list = bs.selectByPage(User.class, page, "");
		for (Object obj : list) {
			System.err.println(CRUDTemplate.update(obj));
		}
	}

	@org.junit.Test
	public void test4() {
		User u = new User();
		u.setName("sam");
		u.setAge(20);
		u.setBirthday(new Date());

		System.err.println(bs.insert(u));

		System.out.println("id:" + u.getId());

	}

	@org.junit.Test
	public void test5() {
		User u = new User();
		u.setName("sam");
		u.setAge(20);
		u.setBirthday(new Date());
		User u1 = new User();
		u1.setName("sam1");
		u1.setAge(20);
		u1.setBirthday(new Date());

		List<User> list = new ArrayList<>();
		list.add(u);
		list.add(u1);

		System.err.println(bs.insertList(list));

		System.out.println("id:" + u.getId());

	}

	@org.junit.Test
	public void test6() {
		User u = bs.selectOne(User.class, "name = 'sam1' order by id limit 1");
		System.err.println(u);

		bs.delete(u);

		User u1 = bs.selectById(User.class, 17);
		System.err.println(u1);
		u1.setName("sam2");
		bs.update(u1);
	}

	@org.junit.Test
	public void test7() throws Exception {
		FileRead.read("H:test.sql");
	}

}
