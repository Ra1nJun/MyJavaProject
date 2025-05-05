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
		System.out.println("도서가 추가되었습니다: "+book.getTitle());
	}
	
	public void findBookByTitle(String title) {
		for (Book book : books) {
			if (book.getTitle().equals(title)) {
				System.out.println("제목으로 검색 결과:");
				System.out.println(book);
			}
		}
	}
	public void findBookByAuthor(String author) {
		for (Book book : books) {
			if (book.getAuthor().equals(author)) {
				System.out.println("저자로 검색 결과:");
				System.out.println(book);
			}
		}
	}
	public void findBookByISBN(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) {
				System.out.println("ISBN으로 검색 결과:");
				book.toString();
			}
		}
	}
	
	public void checkOutBook(String isbn) {
		for (Book book : books) {
			if (book.getIsbn().equals(isbn)) {
				if (book.checkOut() == true) {
					System.out.println("도서 대출 성공!");
					System.out.println("대출된 도서 정보:");
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
					System.out.println("도서 반납 성공!");
					System.out.println("반납된 도서 정보:");
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

    // 대출 가능한 도서 수
    public int getAvailableBooksCount() {
    	int Cnt = 0;
    	for (Book book : books) {
			if (book.isAvailable() == true) {
				Cnt++;
			}
		}
    	return Cnt;
    }

    // 대출 중인 도서 수
    public int getBorrowedBooksCount() {
        return getTotalBooks() - getAvailableBooksCount();
    }
	
}
