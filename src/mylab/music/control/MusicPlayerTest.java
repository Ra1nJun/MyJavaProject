package mylab.music.control;

import mylab.music.entity.MP3;
import mylab.music.entity.Vinyl;

public class MusicPlayerTest {
	public static void main(String[] args) {
		System.out.println("===== ���� ��� �ý��� �׽�Ʈ =====");
		
		System.out.println("\n--- MP3 �׽�Ʈ ---");
		MP3 mpTest = new MP3("Dynamite","BTS","MP3",5);
		mpTest.displayInfo();
		mpTest.play();
		mpTest.setVolume(8);
		mpTest.play();
		mpTest.stop();
		
		System.out.println("\n--- Vinyl �׽�Ʈ ---");
		Vinyl vinylTest = new Vinyl("Yesterday","The Beatles",33);
		vinylTest.displayInfo();
		vinylTest.play();
		vinylTest.clean();
		
		System.out.println("\n--- ������ �׽�Ʈ ---");
		mpTest = new MP3("Butter","BTS","MP3",4);
		mpTest.displayInfo();
		mpTest.play();
		
		System.out.println("\n--- ĳ���� �׽�Ʈ ---");
		mpTest.setVolume(3);
		mpTest.play();
		mpTest.setVolume(7);
		mpTest.stop();
	}
}
