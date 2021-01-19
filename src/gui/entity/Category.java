package gui.entity;

public class Category {
	public int id; // 主键
	public String name; // 名称

	public int recordNuber; // 消费记录数

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRecordNuber() {
		return recordNuber;
	}

	public void setRecordNuber(int recordNuber) {
		this.recordNuber = recordNuber;
	}

	// 这里提供了一个toString方法，在后续JComboBox中显示的时候，会调用此方法，用于显示分类名称
	public String toString() {
		return name;
	}
}
