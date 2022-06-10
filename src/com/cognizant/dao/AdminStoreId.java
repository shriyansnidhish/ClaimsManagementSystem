package com.cognizant.dao;

import java.util.ArrayList;
import java.util.List;

public class AdminStoreId {

	static List<Integer> idList = new ArrayList<Integer>();
	static List<String> idList1 = new ArrayList<String>();
	static char arr[] = new char[10];
	static int generatedId;
	static int ch = 65;

	public static void addId(int id) {
		idList.add(0, id);
		generatedId = id;
	}

	public static String getId() {

		int len = arr.length;
		for (int x = 0; x < len; x++) {
			arr[x] = (char) ch;
			// System.out.println("arr"+arr[x]);
			if (ch < 90)
				ch++;
			else
				ch = 65;
		}
		ch = 65;
		int x = generatedId;
		String str = "";
		int temp = x;
		while (temp != 0) {
			int d = temp % 10;
			char ch = arr[d];
			str = ch + str;
			temp = temp / 10;
		}
		idList1.add(0, str);

		return idList1.get(0);

	}
}
