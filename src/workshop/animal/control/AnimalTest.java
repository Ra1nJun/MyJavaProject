package workshop.animal.control;

import workshop.animal.entity.Animal;
import workshop.animal.entity.Cat;
import workshop.animal.entity.Pet;

public class AnimalTest {

	public static void main(String[] args) {
		Cat cat1 = new Cat();    //pet 메서드 3개 + animal 매서드 2개 = 5개 호출 가능
		Pet cat2 = new Cat();    //pet 메서드 3개
		Animal cat3 = new Cat(); //animal 매서드 2개
		
		
		cat1.setName("Tom");
		System.out.println(cat1.getName());
		cat1.play();
		cat1.eat();
		cat1.walk();
		
		cat2.setName("Miyo");
		System.out.println(cat2.getName());
		cat2.play();
		
		cat3.eat();
		cat3.walk();
	}

}
