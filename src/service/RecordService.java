package service;

import java.util.Date;

import dao.RecordDAO;
import gui.entity.Category;
import gui.entity.Record;

public class RecordService {
	// RecordService消费记录业务类只有一个方法add
	// 根据消费金额，消费分类，备注和日期添加一条消费记录
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
