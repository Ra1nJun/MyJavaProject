package mylab.book.control;

import java.util.ArrayList;
import java.util.List;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class ShoppingCart {
	private List<Publication> items;

	public ShoppingCart() {
		items = new ArrayList<Publication>();
	}
	
	public void addItem(Publication item) {
		items.add(item);
		System.out.println("��ٱ��Ͽ� ���ο� ǰ���� �߰��Ǿ����ϴ�.");
	}
	
	public boolean removeItem(String title) {
		for (Publication item : items) {
			if ((item.getTitle()).equals(title)) {
				items.remove(item);
				return true;
			}
		}
		return false;
	}
	
	public void displayCart() {
		System.out.println("\n==== ���� ���� ��� ====");
		for (Publication item : items) {
			System.out.println(item);
		}
		System.out.println("\n==================");
		System.out.println("�� ����:"+calculateTotalPrice());
		
		System.out.println("\n==== ���� ���� ====");
		calculateDiscountedPrice();
	}
	
	public int calculateTotalPrice() {
		int result=0;
		for (Publication item : items) {
			result += item.getPrice();
		}
		return result;
	}
	
	public void calculateDiscountedPrice() {
		double rate;
		for (Publication item : items) {
			if (item instanceof Magazine) {
				rate = item.getPrice() * 0.1;
				System.out.println("10% ����");
			}
			else if (item instanceof Novel) {
				rate = item.getPrice() * 0.15;
				System.out.println("15% ����");
			}
			else if (item instanceof ReferenceBook) {
				rate = item.getPrice() * 0.2;
				System.out.println("20% ����");
			}
			else {
				continue;
			}
			System.out.println(item.getTitle()+" ���� �� ����: "+item.getPrice()+"��");
			item.setPrice((int)(item.getPrice() - rate));
			System.out.println(item.getTitle()+" ���� �� ����: "+item.getPrice()+"��");
			System.out.println("����: "+(int)rate+"��\n");
		}
	}
	
	public void printStatistics() {
		int m=0, n=0, r=0, x=0;
		for (Publication item : items) {
			if (item instanceof Magazine) {
				m += 1;
			}
			else if (item instanceof Novel) {
				n += 1;
			}
			else if (item instanceof ReferenceBook) {
				r += 1;
			} else {
				x += 1;
			}
		}
		System.out.println("Magazine:"+m+", Novel:"+n+", Reference:"+r+", NoType:"+x);
	}
	
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		
		cart.addItem(new Magazine("����ũ�μ���Ʈ","2007-10-01",328,9900,"�ſ�"));
		cart.addItem(new Magazine("�濵����ǻ��","2007-10-03",316,9000,"�ſ�"));
		cart.addItem(new Novel("���߿�","2007-07-01",396,9800,"����������������","����Ҽ�"));
		cart.addItem(new Novel("���ѻ꼺","2007-04-14",383,11000,"����","���ϼҼ�"));
		cart.addItem(new ReferenceBook("�ǿ��������α׷���","2007-01-14",496,25000,"����Ʈ�������"));
		cart.addItem(new Novel("�ҳ��̿´�","2014-05-01",216,15000,"�Ѱ�","����Ҽ�"));
		cart.addItem(new Novel("�ۺ������ʴ´�","2021-09-09",332,15120,"�Ѱ�","����Ҽ�"));
		
		cart.displayCart();
		cart.printStatistics();
		cart.removeItem("���߿�");
		cart.displayCart();
	}
}
