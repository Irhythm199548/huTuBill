package test;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		System.out.println("List×ª×Ö·û´®");
		List<String> list1 = new ArrayList<String>();
		StringBuffer l = new StringBuffer();
		list1.add("1;");
		list1.add("2;");
		list1.add("3;");
		for (String ln : list1) {
			l.append(ln);
		}
		System.out.println(l);
	}

}
