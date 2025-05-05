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
		return "å ����: "+title+"\t����: "+author+"\tISBN: "
				+isbn+" ���ǳ⵵: "+publishYear+"\t���� ���� ����: "
				+(isAvailable?"����":"���� ��");
	}
}
