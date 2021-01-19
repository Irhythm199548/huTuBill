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

	// ��ѯ�����е�Category��Ȼ�����ÿ�ַ��࣬�ٰѷ����Ӧ�����Ѽ�¼��������������������ڶ�Ӧ����ʵ����recordNumer�ϡ�
	// ����ٸ���recordNumer���е�����������Ƶ�ʸߵķ������ǰ�档
	public List<Category> list() {
		List<Category> cs = categoryDao.list();
		for (Category c : cs) {
			List<Record> rs = recordDao.list(c.id);
			c.recordNuber = rs.size();
		}
		Collections.sort(cs, (c1, c2) -> c2.recordNuber - c1.recordNuber);
		return cs;
	}

	// ����һ�ַ���
	public void add(String name) {
		Category c = new Category();
		c.setName(name);
		categoryDao.add(c);
	}

	// ���·���
	public void update(int id, String name) {
		Category c = new Category();
		c.setName(name);
		c.setId(id);
		categoryDao.update(c);
	}

	// ɾ������
	public void delete(int id) {
		categoryDao.delete(id);
	}

}
