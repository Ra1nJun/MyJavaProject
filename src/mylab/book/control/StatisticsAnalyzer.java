package mylab.book.control;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

public class StatisticsAnalyzer {
	    // Ÿ�Ժ� ��� ���� ���
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
    
    // ���ǹ� ���� ���� ���
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
    
    // Ư�� ���� ���ǹ� ���� ���
    public double calculatePublicationRatioByYear(Publication[] publications, String year) {
        int count = 0;
        
        for (Publication pub : publications) {
            if (pub.getPublishDate() != null && pub.getPublishDate().startsWith(year)) {
                count++;
            }
        }
        
        return (double) count / publications.length * 100;
    }
    
    // ���ǹ� Ÿ�� Ȯ�� ���� �޼���
    private String getPublicationType(Publication pub) {
        if (pub instanceof Novel) {
            return "-�Ҽ�";
        } else if (pub instanceof Magazine) {
            return "-����";
        } else if (pub instanceof ReferenceBook) {
            return "-����";
        } else {
            return "-��Ÿ";
        }
    }
    
    // ��� ���� ���
    public void printStatistics(Publication[] publications) {
        DecimalFormat df = new DecimalFormat("#,###.##");
        
        System.out.println("===== ���ǹ� ��� �м� =====");
        
        // Ÿ�Ժ� ��� ���� ���
        Map<String, Double> avgPrices = calculateAveragePriceByType(publications);
        System.out.println("1. Ÿ�Ժ� ��� ����:");
        for (Map.Entry<String, Double> entry : avgPrices.entrySet()) {
            System.out.println(entry.getKey() + ": " + df.format(entry.getValue()) + "��");
        }
        
        // ���ǹ� ���� ���� ���
        Map<String, Double> distribution = calculatePublicationDistribution(publications);
        System.out.println("\n2. ���ǹ� ���� ����:");
        for (Map.Entry<String, Double> entry : distribution.entrySet()) {
            System.out.println(entry.getKey() + ": " + df.format(entry.getValue()) + "%");
        }
        
        // 2007�⵵ ���ǹ� ���� ���
        double ratio2007 = calculatePublicationRatioByYear(publications, "2007");
        System.out.print("\n3. 2007�⵵ ���ǹ� ����: ");
        System.out.println(df.format(ratio2007) + "%");
        
        System.out.println("===========================");
    }
}
