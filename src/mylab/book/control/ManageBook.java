package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class ManageBook {
	public static void main(String[] args) {
		Publication[] pubs = {
				new Magazine("마이크로소프트","2007-10-01",328,9900,"매월"),
				new Magazine("경영과컴퓨터","2007-10-03",316,9000,"매월"),
				new Novel("빠삐용","2007-07-01",396,9800,"베르나르베르베르","현대소설"),
				new Novel("남한산성","2007-04-14",383,11000,"김훈","대하소설"),
				new ReferenceBook("실용주의프로그래머","2007-01-14",496,25000,"소프트웨어공학"),
				new Novel("소년이온다","2014-05-01",216,15000,"한강","장편소설"),
				new Novel("작별하지않는다","2021-09-09",332,15120,"한강","장편소설")
		};
		
		System.out.println("===== 도서 정보 출력 =====");
        for (int i = 0; i < pubs.length; i++) {
            System.out.println((i + 1) + ". " + pubs[i]);
        }

        Publication target = pubs[2];
        int originalPrice = target.getPrice(); 
        modifyPrice(target); // 가격 변경 메서드 호출

        // 변경된 가격과 차액 출력
        System.out.println("\n===가격 변경===");
        System.out.println(target.getTitle()+" 변경 전 가격: "+originalPrice+"원");
		System.out.println(target.getTitle()+" 변경 후 가격: "+target.getPrice()+"원");
		System.out.println("차액: "+(originalPrice-target.getPrice())+"원\n");
		
		StatisticsAnalyzer stats = new StatisticsAnalyzer();
        stats.printStatistics(pubs);
	}
	
	public static void modifyPrice(Publication pub) {
		if (pub instanceof Magazine) {
			pub.setPrice((int)(pub.getPrice() *0.6));
		}
		else if (pub instanceof Novel) {
			pub.setPrice((int)(pub.getPrice() *0.8));
		}
		else if (pub instanceof ReferenceBook) {
			pub.setPrice((int)(pub.getPrice() *0.9));
		}
	}
}
