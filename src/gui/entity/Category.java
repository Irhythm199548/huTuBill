package gui.entity;

public class Category {
	public int id; // ����
	public String name; // ����

	public int recordNuber; // ���Ѽ�¼��

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

	// �����ṩ��һ��toString�������ں���JComboBox����ʾ��ʱ�򣬻���ô˷�����������ʾ��������
	public String toString() {
		return name;
	}
}
