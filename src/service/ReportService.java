package service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.RecordDAO;
import gui.entity.Record;
import util.DateUtil;

public class ReportService {
	/**
	 * ��ȡĳһ������ѽ�� ��ȡĳһ��������ܽ���������ѿ����ж�ʣ� ���⼸�����Ѽ���������һ��
	 * 
	 * @param d
	 * @param monthRawData
	 * @return
	 */

	public int getDaySpend(Date d, List<Record> monthRawData) {
		int daySpend = 0;
		for (Record record : monthRawData) {
			if (record.date.equals(d)) {
				daySpend += record.spend;
			}
		}
		return daySpend;
	}

	/**
	 * ��ȡһ���µ����Ѽ��ϼ�¼ ����һ�����Ѽ�¼���ϣ����豾����30�죬 ��ô������Ͼ���30��Record��ÿ��Record��Ӧһ��������ܽ�
	 * �������û�����ѣ������ѽ��Ϊ0.
	 * 
	 * @return
	 */
	public List<Record> listThisMonthRecords() {
		RecordDAO dao = new RecordDAO();
		List<Record> monthRawData = dao.listThisMonth();
		List<Record> result = new ArrayList<>();
		Date monthBegin = DateUtil.monthBegin();
		int monthTotalDay = DateUtil.thisMonthTotalDay();
		Calendar c = Calendar.getInstance();
		for (int i = 0; i < monthTotalDay; i++) {
			Record r = new Record();
			c.add(Calendar.DATE, i);
			c.setTime(monthBegin);
			Date eachDayOfThisMonth = c.getTime();
			int daySpend = getDaySpend(eachDayOfThisMonth, monthRawData);
			r.spend = daySpend;
			result.add(r);
		}
		return result;
	}
}
