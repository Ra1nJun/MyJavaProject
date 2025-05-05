package workshop.person.control;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import workshop.person.entity.PersonEntity;

public class PersonManagerArrayList {
	public static void main(String[] args) {
//		ArrayList<PersonEntity> personlist = new ArrayList<>();
		
		List<PersonEntity> personList = new ArrayList<>();
//		List<PersonEntity> personlist3 = new LinkedList<>();

//		PersonEntity[] persons = new PersonEntity[10];
		
		PersonManagerArrayList mgr = new PersonManagerArrayList();
		mgr.fillPersons(personList);
		mgr.showPersons(personList);
		System.out.println(mgr.findByGender(personList, '��'));
		mgr.showPerson(personList, "���ϴ�");
		
	}
	
	public void showPerson(List<PersonEntity> persons, String name) {
		for (PersonEntity p : persons) {
			if (p.getName().equals(name)) {
				System.out.println("[�̸�] "+ p.getName());
				System.out.println("[����] "+ p.getGender());
				System.out.println("[��ȭ��ȣ] "+ p.getPhone());
				System.out.println("[�ּ�] "+ p.getPhone());
				break;
			}
		}
	}
	
	public int findByGender(List<PersonEntity> persons, char gender) {
		int genderCnt = 0;
		
		for (PersonEntity p : persons) {
			if (p.getGender() == gender) {
				genderCnt ++;
			}
		}
		
		return genderCnt;
	}

	public void showPersons(List<PersonEntity> persons) {
		for (PersonEntity p : persons) {
			System.out.println(p.getName() + " / " + p.getGender() + " / " + p.getPhone());
		}
	}

	public void fillPersons(List<PersonEntity> persons) {
		persons.add(new PersonEntity("�̼�ȣ","7212121028102", "��õ ��籸", "032-392-2932"));
		persons.add(new PersonEntity("���ϴ�","7302132363217", "���� ������", "02-362-1932"));
		persons.add(new PersonEntity("�ڿ���","7503111233201", "���� ���ϱ�", "02-887-1542"));
		persons.add(new PersonEntity("���μ�","7312041038988", "���� ������", "032-384-2223"));
		persons.add(new PersonEntity("ȫ����","7606221021341", "���� ��õ��", "02-158-7333"));
		persons.add(new PersonEntity("�̹̼�","7502142021321", "���� ������", "02-323-1934"));
		persons.add(new PersonEntity("�ڼ���","7402061023101", "���� ���α�", "02-308-0932"));
		persons.add(new PersonEntity("������","7103282025101", "���� ����", "02-452-0939"));
		persons.add(new PersonEntity("Ȳ����","7806231031101", "��õ �߱�", "032-327-2202"));
		persons.add(new PersonEntity("��ö��","7601211025101", "��õ ��籸", "032-122-7832"));
	}
}
