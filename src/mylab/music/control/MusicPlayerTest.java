package mylab.music.control;

import mylab.music.entity.MP3;
import mylab.music.entity.Vinyl;

public class MusicPlayerTest {
	public static void main(String[] args) {
		System.out.println("===== 음악 재생 시스템 테스트 =====");
		
		System.out.println("\n--- MP3 테스트 ---");
		MP3 mpTest = new MP3("Dynamite","BTS","MP3",5);
		mpTest.displayInfo();
		mpTest.play();
		mpTest.setVolume(8);
		mpTest.play();
		mpTest.stop();
		
		System.out.println("\n--- Vinyl 테스트 ---");
		Vinyl vinylTest = new Vinyl("Yesterday","The Beatles",33);
		vinylTest.displayInfo();
		vinylTest.play();
		vinylTest.clean();
		
		System.out.println("\n--- 다형성 테스트 ---");
		mpTest = new MP3("Butter","BTS","MP3",4);
		mpTest.displayInfo();
		mpTest.play();
		
		System.out.println("\n--- 캐스팅 테스트 ---");
		mpTest.setVolume(3);
		mpTest.play();
		mpTest.setVolume(7);
		mpTest.stop();
	}
}
