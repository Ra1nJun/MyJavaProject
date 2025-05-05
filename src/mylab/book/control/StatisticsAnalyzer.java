package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {
	    // 타입별 평균 가격 계산
    public Map<String, Double> calculateAveragePriceByType(Publication[] publications) {
        Map<String, Integer> typeTotalPrice = new HashMap<>();
        Map<String, Integer> typeCount = new HashMap<>();
        
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            typeTotalPrice.put(type, typeTotalPrice.getOrDefault(type, 0) + pub.getPrice());
            typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
        }
        
        Map<String, Double> averagePriceMap = new HashMap<>();
        for (String type : typeTotalPrice.keySet()) {
            double average = (double) typeTotalPrice.get(type) / typeCount.get(type);
            averagePriceMap.put(type, average);
        }
        
        return averagePriceMap;
    }
    
    // 출판물 유형 분포 계산
    public Map<String, Double> calculatePublicationDistribution(Publication[] publications) {
        Map<String, Integer> typeCount = new HashMap<>();
        
        for (Publication pub : publications) {
            String type = getPublicationType(pub);
            typeCount.put(type, typeCount.getOrDefault(type, 0) + 1);
        }
        
        Map<String, Double> distributionMap = new HashMap<>();
        int total = publications.length;
        
        for (String type : typeCount.keySet()) {
            double percentage = (double) typeCount.get(type) / total * 100;
            distributionMap.put(type, percentage);
        }
        
        return distributionMap;
    }
    
    // 특정 연도 출판물 비율 계산
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        
        for (Publication pub : publications) {
            if (pub.getPublishDate() != null && pub.getPublishDate().startsWith(year)) {
                count++;
            }
        }
        
        return (double) count / publications.length * 100;
    }
    
    // 출판물 타입 확인 헬퍼 메서드
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "-소설";
        } else if (pub instanceof Magazine) {
            return "-잡지";
        } else if (pub instanceof ReferenceBook) {
            return "-참고서";
        } else {
            return "-기타";
        }
    }
    
    // 통계 정보 출력
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        
        System.out.println("===== 출판물 통계 분석 =====");
        
        // 타입별 평균 가격 출력
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        System.out.println("1. 타입별 평균 가격:");
        for (Map.Entry<String, Double> entry : avgPrices.entrySet()) {
            System.out.println(entry.getKey() + ": " + df.format(entry.getValue()) + "원");
        }
        
        // 출판물 유형 분포 출력
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        System.out.println("\n2. 출판물 유형 분포:");
        for (Map.Entry<String, Double> entry : distribution.entrySet()) {
            System.out.println(entry.getKey() + ": " + df.format(entry.getValue()) + "%");
        }
        
        // 2007년도 출판물 비율 출력
        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");
        System.out.print("\n3. 2007년도 출판물 비율: ");
        System.out.println(df.format(ratio2007) + "%");
        
        System.out.println("===========================");
    }
}
