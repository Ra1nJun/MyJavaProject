package mylab.book.entity;

public class Magazine extends Publication {
	private String publishPeriod;
	
	public Magazine(String title, String publishDate, int page, int price, String publishingPeriod) {
		super(title, publishDate, page, price);
		this.publishPeriod = publishingPeriod;
	}
	
	@Override
	public String toString() {
		return super.getTitle()+" [잡지] 발행주기:"+publishPeriod+", "+super.toString();
	}
}
