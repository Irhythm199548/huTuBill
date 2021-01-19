package gui.entity;

import java.util.Date;

public class Record {
	public int spend; // 消费金额
	public int id; // 主键
	public int cid; // 分类信息id
	public String comment; // 备注
	public Date date; // 日期

	public int getSpend() {
		return spend;
	}

	public void setSpend(int spend) {
		this.spend = spend;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
