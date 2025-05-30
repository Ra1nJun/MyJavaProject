package mylab.library.control;

import mylab.library.entity.Book;
import mylab.library.entity.Library;

public class LibraryManagementSystem {

	public static void main(String[] args) {
		Library library = new Library("중앙 도서관");
		
		addSampleBooks(library);
        
        // c. 도서관 정보 출력
        System.out.println("=== "+library.getName()+" ===");
        libraryInfo(library);
        
        // d. 기능 테스트
        testFindBook(library);
        testCheckOut(library);
        testReturn(library);
        
        // e. 대출 가능한 도서 목록 출력
        displayAvailableBooks(library);
	}
	
	 private static void addSampleBooks(Library library) {
		 library.addBook(new Book("자바 프로그래밍", "김자바", "978-89-01-12345-6", 2022));
		 library.addBook(new Book("객체지향의 사실과 오해", "조영호", "978-89-01-67890-1", 2015));
		 library.addBook(new Book("Clean Code", "Robert C. Martin", "978-0-13-235088-4", 2008));
		 library.addBook(new Book("Effective Java", "Joshua Bloch", "978-89-01-67890-1", 2018));
		 library.addBook(new Book("Head First Java", "Kathy Sierra", "978-0-596-00920-5", 2005));
		 library.addBook(new Book("자바의 정석", "남궁성", "978-89-01-14077-4", 2019));
    }
	 
	 private static void testFindBook(Library library) {
		 System.out.println("=== 도서 검색 테스트 ===");
         
         // 제목으로 검색
         library.findBookByTitle("자바의 정석");
         System.out.println("");
         // 저자로 검색
         library.findBookByAuthor("Robert C. Martin");
         System.out.println("");
    }    

    private static void testCheckOut(Library library) {
         System.out.println("=== 도서 대출 테스트 ===");
         
         library.checkOutBook("978-89-01-14077-4");
         System.out.println("");
         
         System.out.println("도서관 현재 상태");
         libraryInfo(library);
    }

    private static void testReturn(Library library) {
         System.out.println("=== 도서 반납 테스트 ===");
         
         library.returnBook("978-89-01-14077-4");
         System.out.println("");
         
         System.out.println("도서관 현재 상태");
         libraryInfo(library);
    }

    private static void displayAvailableBooks(Library library) {
         System.out.println("=== 대출 가능한 도서 목록 ===");
         library.getAvailableBooks();
    }
    
    public static void libraryInfo(Library library) {
        System.out.println("전체 도서 수: " + library.getTotalBooks());
        System.out.println("대출 가능 도서 수: " + library.getAvailableBooksCount());
        System.out.println("대출 중인 도서 수: " + library.getBorrowedBooksCount());
        System.out.println();
    }
}
