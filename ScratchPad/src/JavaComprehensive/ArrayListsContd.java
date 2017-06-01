package JavaComprehensive;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListsContd {

	public static void main(String[] args) {
		ArrayList todoList = new ArrayList();
		todoList.add("Buy gourmet");
		todoList.add("See funny cat pictures online");
		todoList.add("Walk the cat");
		
		ArrayList<Double> list1 = new ArrayList<Double>();
		list1.add(10.5);
		list1.add(30.5);
		list1.add(1, 20.5); // clobbers 30.5
		list1.add(2, 50.5); // adds to end
		list1.remove(0); // removes 10.5, 20.5 becomes 0th
		System.out.println(list1);
		
		LinkedList<Double> list2 = new LinkedList<Double>();
		list2.add(10.5);
		list2.add(1,20.5);
		list2.remove(1);
		System.out.println(list2);
		
		
	}

}
