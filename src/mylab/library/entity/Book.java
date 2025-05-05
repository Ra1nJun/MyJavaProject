package mylab.library.entity;

public class Book {
	private String title;
	private String author;
	private String isbn;
	private int publishYear;
	private boolean isAvailable;
	
	public Book() {
	}
	
	public Book(String title, String author, String isbn, int publishYear) {
		setTitle(title);
		this.author = author;
		this.isbn = isbn;
		this.publishYear = publishYear;
		this.isAvailable = true;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getPublishYear() {
		return publishYear;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public boolean checkOut() {
		if (isAvailable == true) {
			isAvailable = false;
			return true;
		} else {
			return false;
		}
	}
	
	public void returnBook() {
		this.isAvailable = true;
	}
	
	@Override
	public String toString() {
		return "책 제목: "+title+"\t저자: "+author+"\tISBN: "
				+isbn+" 출판년도: "+publishYear+"\t대출 가능 여부: "
				+(isAvailable?"가능":"대출 중");
	}
}
