package ATU_Program;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;


public class ProcessTest {
	List<Person> list;
	List<Person> K1_list;
	List<Person> K2_list;
	List<Person> K3_list;
	int size = 11;
	Person one,two,three,four,five,six,seven,eight,nine,ten,eleven;
	Engine check;
	Team test1;
	Team test2;
	Team test3;
	Team[] teamlist = new Team[3];
	
	@Before
	public void setup() throws Exception{
		
		one = new Person("Amy", "20120201","5","4","true","true","true","nothing","1");
		two = new Person("Bruce", "20120202","4","5","true","true","false","nothing","2");
		three = new Person("Cat", "20120203","3","6","true","true","true","nothing","3");
		four = new Person("Blue", "20120204","7","3","true","true","true","nothing","4");
		five = new Person("Durian", "20120205","1","6","true","true","false","nothing","5");
		six = new Person("Fool", "20120206","6","7","true","true","false","nothing","6");
		seven = new Person("Gantt", "20120207","8","2","true","true","false","nothing","7");
		eight = new Person("Hedwig", "20120208","5","5","true","true","false","nothing","8");
		nine = new Person("Isaac", "20120209","2","1","true","true","false","nothing","9");
		ten = new Person("Jack", "20120210","4","6","true","true","true","nothing","10");
		eleven = new Person("King", "20120211","7","8","true","true","true","nothing","11");
		
		list = new ArrayList<>();
		list.add(one);
		list.add(two);
		list.add(three);
		list.add(four);
		list.add(five);
		list.add(six);
		list.add(seven);
		list.add(eight);
		list.add(nine);
		list.add(ten);
		list.add(eleven);
		
		K1_list = new ArrayList<>();
		K1_list.add(seven);
		K1_list.add(four);
		K1_list.add(eleven);
		
		K2_list = new ArrayList<>();
		K2_list.add(nine);
		K2_list.add(two);
		K2_list.add(three);
		
		K3_list = new ArrayList<>();
		K3_list.add(five);
		K3_list.add(six);
		K3_list.add(ten);
		
		check = new Engine(size, list);
		
		test1 = new Team(1,4,seven,nine,five,eight,"Durian");
		test2 = new Team(2,4,four,two,six,one,"Amy");
		test3 = new Team(3,3,eleven,three,ten,null,"King");
		teamlist[0] = test1;
		teamlist[1] = test2;
		teamlist[2] = test3;
	}
	
	@Test
	public void process_get_size() {
		assertEquals(size, check.getsize());
	}
	
	@Test
	public void process_get_list() {
		assertEquals(list, check.get_list());
	}

	@Test
	public void process_get_K1list() {
		check.arrange_K1(list);
		assertEquals(K1_list, check.get_K1list());
	}
	
	@Test
	public void process_get_K2list() {
		check.arrange_K1(list);
		check.arrange_K2(list);
		assertEquals(K2_list, check.get_K2list());
	}
	
	@Test
	public void process_get_K3list() {
		check.arrange_K1(list);
		check.arrange_K2(list);
		check.arrange_K3(list);
		assertEquals(K3_list, check.get_K3list());
	}
	
	@Test
	public void get_teamlist() {
		check.form_team();
		assertArrayEquals(teamlist, check.get_teamlist());
	}
	
	@Test
	public void get_team() {
		check.form_team();
		assertEquals(test1, check.get_team(1));
		assertEquals(test2, check.get_team(2));
		assertEquals(test3, check.get_team(3));
	}
}