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
		System.out.println("장바구니에 새로운 품목이 추가되었습니다.");
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
		System.out.println("\n==== 도서 정보 출력 ====");
		for (Publication item : items) {
			System.out.println(item);
		}
		System.out.println("\n==================");
		System.out.println("총 가격:"+calculateTotalPrice());
		
		System.out.println("\n==== 가격 변경 ====");
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
				System.out.println("10% 할인");
			}
			else if (item instanceof Novel) {
				rate = item.getPrice() * 0.15;
				System.out.println("15% 할인");
			}
			else if (item instanceof ReferenceBook) {
				rate = item.getPrice() * 0.2;
				System.out.println("20% 할인");
			}
			else {
				continue;
			}
			System.out.println(item.getTitle()+" 변경 전 가격: "+item.getPrice()+"원");
			item.setPrice((int)(item.getPrice() - rate));
			System.out.println(item.getTitle()+" 변경 후 가격: "+item.getPrice()+"원");
			System.out.println("차액: "+(int)rate+"원\n");
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
		
		cart.addItem(new Magazine("마이크로소프트","2007-10-01",328,9900,"매월"));
		cart.addItem(new Magazine("경영과컴퓨터","2007-10-03",316,9000,"매월"));
		cart.addItem(new Novel("빠삐용","2007-07-01",396,9800,"베르나르베르베르","현대소설"));
		cart.addItem(new Novel("남한산성","2007-04-14",383,11000,"김훈","대하소설"));
		cart.addItem(new ReferenceBook("실용주의프로그래머","2007-01-14",496,25000,"소프트웨어공학"));
		cart.addItem(new Novel("소년이온다","2014-05-01",216,15000,"한강","장편소설"));
		cart.addItem(new Novel("작별하지않는다","2021-09-09",332,15120,"한강","장편소설"));
		
		cart.displayCart();
		cart.printStatistics();
		cart.removeItem("빠삐용");
		cart.displayCart();
	}
}
