package service;

import java.util.Collections;
import java.util.List;

import dao.CategoryDAO;
import dao.RecordDAO;
import gui.entity.Category;
import gui.entity.Record;

public class CategoryService {

	CategoryDAO categoryDao = new CategoryDAO();
	RecordDAO recordDao = new RecordDAO();

	// 查询出所有的Category，然后根据每种分类，再把分类对应的消费记录总数查出来，并且设置在对应分类实例的recordNumer上。
	// 最后再根据recordNumer进行倒排序，让消费频率高的分类放在前面。
	public List<Category> list() {
		List<Category> cs = categoryDao.list();
		for (Category c : cs) {
			List<Record> rs = recordDao.list(c.id);
			c.recordNuber = rs.size();
		}
		Collections.sort(cs, (c1, c2) -> c2.recordNuber - c1.recordNuber);
		return cs;
	}

	// 增加一种分类
	public void add(String name) {
		Category c = new Category();
		c.setName(name);
		categoryDao.add(c);
	}

	// 更新分类
	public void update(int id, String name) {
		Category c = new Category();
		c.setName(name);
		c.setId(id);
		categoryDao.update(c);
	}

	// 删除分类
	public void delete(int id) {
		categoryDao.delete(id);
	}

}
