package mylab.book.entity;

public class ReferenceBook extends Publication {
	private String field;
	
	public ReferenceBook(String title, String publishDate, int page, int price, String field ) {
		super(title, publishDate, page, price);
		this.field = field;
	}
	
	@Override
	public String toString() {
		return super.getTitle()+" [참고서] 분야:"+field+", "+super.toString();
	}
}
