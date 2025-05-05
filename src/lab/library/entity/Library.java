package lab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Book> books = new ArrayList<>();
	private String name;
	
	public Library(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void addBook(Book book) {
		books.add(book);
		System.out.println("������ �߰��Ǿ����ϴ�: "+book.getTitle());
	}
	
	public void findBookByTitle(String title) {
		for (Book book : books) {
			if (book.getTitle().equals(title)) {
				System.out.println("�������� �˻� ���:");
				System.out.println(book);
			}
		}
	}
	public void findBookByAuthor(String author) {
		for (Book book : books) {
			if (book.getAuthor().equals(author)) {
				System.out.println("���ڷ� �˻� ���:");
				System.out.println(book);
			}
		}
	}
	public void findBookByISBN(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) {
				System.out.println("ISBN���� �˻� ���:");
				book.toString();
			}
		}
	}
	
	public void checkOutBook(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) {
				if (book.checkOut() == true) {
					System.out.println("���� ���� ����!");
					System.out.println("����� ���� ����:");
					System.out.println(book);
				}
			}
		}
	}
	
	public void returnBook(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) {
				if (book.checkOut() == false) {
					book.returnBook();
					System.out.println("���� �ݳ� ����!");
					System.out.println("�ݳ��� ���� ����:");
					System.out.println(book);
				}
			}
		}
	}
	
	public void getAvailableBooks() {
		for (Book book : books) {
			if (book.isAvailable() == true) {
				System.out.println(book);
				System.out.println("------------------------");
			}
		}
	}
	
	public void getAllBooks() {
		for (Book book : books) {
			System.out.println(book);
		}
	}
	
	public int getTotalBooks() {
        return books.size();
    }

    // ���� ������ ���� ��
    public int getAvailableBooksCount() {
    	int Cnt = 0;
    	for (Book book : books) {
			if (book.isAvailable() == true) {
				Cnt++;
			}
		}
    	return Cnt;
    }

    // ���� ���� ���� ��
    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }
	
}
