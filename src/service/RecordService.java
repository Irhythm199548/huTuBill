package service;

import java.util.Date;

import dao.RecordDAO;
import gui.entity.Category;
import gui.entity.Record;

public class RecordService {
	// RecordService���Ѽ�¼ҵ����ֻ��һ������add
	// �������ѽ����ѷ��࣬��ע���������һ�����Ѽ�¼
	RecordDAO recordDao = new RecordDAO();

	public void add(int spend, Category c, String coment, Date date) {
		Record r = new Record();
		r.spend = spend;
		r.cid = c.id;
		r.comment = coment;
		r.date = date;
		recordDao.add(r);
	}
}
