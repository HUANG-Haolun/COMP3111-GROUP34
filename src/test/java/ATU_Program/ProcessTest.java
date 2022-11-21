package ATU_Program;
import atu.input.*;
import atu.process.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;

public class ProcessTest {
	//for team size with 2 extra
	List<Person> list_2 = new ArrayList<>();
	List<Person> K1_list_2 = new ArrayList<>();
	List<Person> K2_list_2 = new ArrayList<>();
	List<Person> K3_list_2 = new ArrayList<>();
	int size_2 = 11;
	Person one,two,three,four,five,six,seven,eight,nine,ten,eleven;
	Engine check_2;
	
	//for team size with 1 extra
	List<Person> list_1 = new ArrayList<>();
	List<Person> K1_list_1 = new ArrayList<>();
	List<Person> K2_list_1 = new ArrayList<>();
	List<Person> K3_list_1 = new ArrayList<>();
	int size_1 = 10;
	Engine check_1;
	
	//for team size with no extra
	List<Person> list_0 = new ArrayList<>();
	List<Person> K1_list_0 = new ArrayList<>();
	List<Person> K2_list_0 = new ArrayList<>();
	List<Person> K3_list_0 = new ArrayList<>();
	int size_0 = 9;
	Engine check_0;
	
	@Before
	public void setup() throws Exception{
		
		one = new Person("20120201","Amy","5","4","1","1","1","nothing","1");
		two = new Person("20120202","Bruce","4","5","1","1","0","nothing","2");
		three = new Person("20120203","Cat","3","6","1","1","1","nothing","3");
		four = new Person("20120204","Blue","7","3","1","1","1","nothing","4");
		five = new Person("20120205","Durian","1","6","1","1","0","nothing","5");
		six = new Person("20120206","Fool","6","7","1","1","0","nothing","6");
		seven = new Person("20120207","Gantt","8","2","1","1","0","nothing","7");
		eight = new Person("20120208","Hedwig","5","5","1","1","0","nothing","8");
		nine = new Person("20120209","Isaac","2","1","1","1","0","nothing","9");
		ten = new Person("20120210","Jack","4","6","1","1","1","nothing","10");
		eleven = new Person("20120211","King","7","8","1","1","1","nothing","11");
		
		//adding the Person to the list when there is two extra people
		list_2.add(one);
		list_2.add(two);
		list_2.add(three);
		list_2.add(four);
		list_2.add(five);
		list_2.add(six);
		list_2.add(seven);
		list_2.add(eight);
		list_2.add(nine);
		list_2.add(ten);
		list_2.add(eleven);
		
		K1_list_2.add(seven);
		K1_list_2.add(four);
		K1_list_2.add(eleven);
		
		K2_list_2.add(nine);
		K2_list_2.add(one);
		K2_list_2.add(two);
		
		K3_list_2.add(six);
		K3_list_2.add(five);
		K3_list_2.add(three);
		
		check_2 = new Engine(size_2, list_2);
		
		//adding the Person to the list when there is one extra person
		list_1.add(one);
		list_1.add(two);
		list_1.add(three);
		list_1.add(four);
		list_1.add(five);
		list_1.add(six);
		list_1.add(seven);
		list_1.add(eight);
		list_1.add(nine);
		list_1.add(ten);
				
		K1_list_1.add(seven);
		K1_list_1.add(four);
		K1_list_1.add(six);
		
		K2_list_1.add(nine);
		K2_list_1.add(one);
		K2_list_1.add(two);
		
		K3_list_1.add(five);
		K3_list_1.add(three);
		K3_list_1.add(ten);
			
		check_1 = new Engine(size_1, list_1);
		
		//adding the Person to the list when there is one extra person
		list_0.add(one);
		list_0.add(two);
		list_0.add(three);
		list_0.add(four);
		list_0.add(five);
		list_0.add(six);
		list_0.add(seven);
		list_0.add(eight);
		list_0.add(nine);
					
		K1_list_0.add(seven);
		K1_list_0.add(four);
		K1_list_0.add(six);
		
		K2_list_0.add(nine);
		K2_list_0.add(one);
		K2_list_0.add(two);
				
		K3_list_0.add(five);
		K3_list_0.add(three);
		K3_list_0.add(eight);
					
		check_0 = new Engine(size_0, list_0);
	}
	
	//Tests the case where there are two extra people
	
	@Test
	public void process_get_size_2() {
		assertEquals(size_2, check_2.getsize());
	}
	
	@Test
	public void process_get_list_2() {
		assertEquals(list_2, check_2.get_list());
	}

	@Test
	public void process_get_list_descending_2() {
		List<Person> testing = new ArrayList<>();
		testing.add(seven);
		testing.add(four);
		testing.add(eleven);
		testing.add(six);
		testing.add(one);
		testing.add(eight);
		testing.add(two);
		testing.add(ten);
		testing.add(three);
		testing.add(nine);
		testing.add(five);
		check_2.arrange_list(list_2);
		assertEquals(testing, check_2.get_list_descending());
	}
	
	@Test
	public void process_get_K1list_2() {
		check_2.arrange_K1(list_2);
		assertEquals(K1_list_2, check_2.get_K1list());
	}
	
	@Test
	public void process_get_K2list_2() {
		check_2.arrange_K1(list_2);
		check_2.arrange_K2(list_2);
		assertEquals(K2_list_2, check_2.get_K2list());
	}
	
	@Test
	public void process_get_K3list_2() {
		check_2.arrange_K1(list_2);
		check_2.arrange_K2(list_2);
		check_2.arrange_K3(list_2);
		assertEquals(K3_list_2, check_2.get_K3list());
	}
	
	@Test
	public void get_A1_2() {
		check_2.form_team();
		assertEquals(seven,check_2.get_team(1).get_A());
	}
	
	@Test
	public void get_B1_2() {
		check_2.form_team();
		assertEquals(nine,check_2.get_team(1).get_B());
	}
	
	@Test
	public void get_C1_2() {
		check_2.form_team();
		assertEquals(six,check_2.get_team(1).get_C());
	}
	
	@Test
	public void get_D1_2() {
		check_2.form_team();
		assertEquals(two,check_2.get_team(1).get_D());
	}
	
	@Test
	public void get_leader1_2() {
		check_2.form_team();
		assertEquals("Fool",check_2.get_team(1).get_Leader());
	}
	
	@Test
	public void get_num1_2() {
		check_2.form_team();
		assertEquals(4,check_2.get_team(1).get_num());
	}
	
	@Test
	public void get_id1_2() {
		check_2.form_team();
		assertEquals(1,check_2.get_team(1).get_teamid());
	}
	
	@Test
	public void get_A2_2() {
		check_2.form_team();
		assertEquals(four,check_2.get_team(2).get_A());
	}
	
	@Test
	public void get_B2_2() {
		check_2.form_team();
		assertEquals(one,check_2.get_team(2).get_B());
	}
	
	@Test
	public void get_C2_2() {
		check_2.form_team();
		assertEquals(three,check_2.get_team(2).get_C());
	}
	
	@Test
	public void get_D2_2() {
		check_2.form_team();
		assertEquals(eight,check_2.get_team(2).get_D());
	}
	
	@Test
	public void get_leader2_2() {
		check_2.form_team();
		assertEquals("Cat",check_2.get_team(2).get_Leader());
	}
	
	@Test
	public void get_num2_2() {
		check_2.form_team();
		assertEquals(4,check_2.get_team(2).get_num());
	}
	
	@Test
	public void get_id2_2() {
		check_2.form_team();
		assertEquals(2,check_2.get_team(2).get_teamid());
	}
	
	@Test
	public void get_A3_2() {
		check_2.form_team();
		assertEquals(eleven,check_2.get_team(3).get_A());
	}
	
	@Test
	public void get_B3_2() {
		check_2.form_team();
		assertEquals(five,check_2.get_team(3).get_B());
	}
	
	@Test
	public void get_C3_2() {
		check_2.form_team();
		assertEquals(ten,check_2.get_team(3).get_C());
	}
	
	@Test
	public void get_D3_2() {
		check_2.form_team();
		assertEquals(null,check_2.get_team(3).get_D());
	}
	
	@Test
	public void get_leader3_2() {
		check_2.form_team();
		assertEquals("King",check_2.get_team(3).get_Leader());
	}
	
	@Test
	public void get_num3_2() {
		check_2.form_team();
		assertEquals(3,check_2.get_team(3).get_num());
	}
	
	@Test
	public void get_id3_2() {
		check_2.form_team();
		assertEquals(3,check_2.get_team(3).get_teamid());
	}
	
	//From here it test for the case where there is only one extra person
	
	@Test
	public void process_get_size_1() {
		assertEquals(size_1, check_1.getsize());
	}
	
	@Test
	public void process_get_list_1() {
		assertEquals(list_1, check_1.get_list());
	}

	@Test
	public void process_get_K1list_1() {
		check_1.arrange_K1(list_1);
		assertEquals(K1_list_1, check_1.get_K1list());
	}
	
	@Test
	public void process_get_K2list_1() {
		check_1.arrange_K1(list_1);
		check_1.arrange_K2(list_1);
		assertEquals(K2_list_1, check_1.get_K2list());
	}
	
	@Test
	public void process_get_K3list_1() {
		check_1.arrange_K1(list_1);
		check_1.arrange_K2(list_1);
		check_1.arrange_K3(list_1);
		assertEquals(K3_list_1, check_1.get_K3list());
	}
	
	@Test
	public void get_A1_1() {
		check_1.form_team();
		assertEquals(seven,check_1.get_team(1).get_A());
	}
	
	@Test
	public void get_B1_1() {
		check_1.form_team();
		assertEquals(nine,check_1.get_team(1).get_B());
	}
	
	@Test
	public void get_C1_1() {
		check_1.form_team();
		assertEquals(five,check_1.get_team(1).get_C());
	}
	
	@Test
	public void get_D1_1() {
		check_1.form_team();
		assertEquals(two,check_1.get_team(1).get_D());
	}
	
	@Test
	public void get_leader1_1() {
		check_1.form_team();
		assertEquals("Durian",check_1.get_team(1).get_Leader());
	}
	
	@Test
	public void get_num1_1() {
		check_1.form_team();
		assertEquals(4,check_1.get_team(1).get_num());
	}
	
	@Test
	public void get_id1_1() {
		check_1.form_team();
		assertEquals(1,check_1.get_team(1).get_teamid());
	}
	
	@Test
	public void get_A2_1() {
		check_1.form_team();
		assertEquals(four,check_1.get_team(2).get_A());
	}
	
	@Test
	public void get_B2_1() {
		check_1.form_team();
		assertEquals(one,check_1.get_team(2).get_B());
	}
	
	@Test
	public void get_C2_1() {
		check_1.form_team();
		assertEquals(three,check_1.get_team(2).get_C());
	}
	
	@Test
	public void get_D2_1() {
		check_1.form_team();
		assertEquals(null,check_1.get_team(2).get_D());
	}
	
	@Test
	public void get_leader2_1() {
		check_1.form_team();
		assertEquals("Cat",check_1.get_team(2).get_Leader());
	}
	
	@Test
	public void get_num2_1() {
		check_1.form_team();
		assertEquals(3,check_1.get_team(2).get_num());
	}
	
	@Test
	public void get_id2_1() {
		check_1.form_team();
		assertEquals(2,check_1.get_team(2).get_teamid());
	}
	
	@Test
	public void get_A3_1() {
		check_1.form_team();
		assertEquals(six,check_1.get_team(3).get_A());
	}
	
	@Test
	public void get_B3_1() {
		check_1.form_team();
		assertEquals(eight,check_1.get_team(3).get_B());
	}
	
	@Test
	public void get_C3_1() {
		check_1.form_team();
		assertEquals(ten,check_1.get_team(3).get_C());
	}
	
	@Test
	public void get_D3_1() {
		check_1.form_team();
		assertEquals(null,check_1.get_team(3).get_D());
	}
	
	@Test
	public void get_leader3_1() {
		check_1.form_team();
		assertEquals("Jack",check_1.get_team(3).get_Leader());
	}
	
	@Test
	public void get_num3_1() {
		check_1.form_team();
		assertEquals(3,check_1.get_team(3).get_num());
	}
	
	@Test
	public void get_id3_1() {
		check_1.form_team();
		assertEquals(3,check_1.get_team(3).get_teamid());
	}
	
	//From here it test for the case where there is no extra person
	
	@Test
	public void process_get_size_0() {
		assertEquals(size_0, check_0.getsize());
	}
		
	@Test
	public void process_get_list_0() {
		assertEquals(list_0, check_0.get_list());
	}

	@Test
	public void process_get_K1list_0() {
		check_0.arrange_K1(list_0);
		assertEquals(K1_list_0, check_0.get_K1list());
	}
		
	@Test
	public void process_get_K2list_0() {
		check_0.arrange_K1(list_0);
		check_0.arrange_K2(list_0);
		assertEquals(K2_list_0, check_0.get_K2list());
	}
		
	@Test
	public void process_get_K3list_0() {
		check_0.arrange_K1(list_0);
		check_0.arrange_K2(list_0);
		check_0.arrange_K3(list_0);
		assertEquals(K3_list_0, check_0.get_K3list());
	}
		
	@Test
	public void get_A1_0() {
		check_0.form_team();
		assertEquals(seven,check_0.get_team(1).get_A());
	}
	
	@Test
	public void get_B1_0() {
		check_0.form_team();
		assertEquals(nine,check_0.get_team(1).get_B());
	}
	
	@Test
	public void get_C1_0() {
		check_0.form_team();
		assertEquals(five,check_0.get_team(1).get_C());
	}
	
	@Test
	public void get_D1_0() {
		check_0.form_team();
		assertEquals(null,check_0.get_team(1).get_D());
	}
		
	@Test
	public void get_leader1_0() {
		check_0.form_team();
		assertEquals("Durian",check_0.get_team(1).get_Leader());
	}
		
	@Test
	public void get_num1_0() {
		check_0.form_team();
		assertEquals(3,check_0.get_team(1).get_num());
	}
		
	@Test
	public void get_id1_0() {
		check_0.form_team();
		assertEquals(1,check_0.get_team(1).get_teamid());
	}
		
	@Test
	public void get_A2_0() {
		check_0.form_team();
		assertEquals(four,check_0.get_team(2).get_A());
	}
		
	@Test
	public void get_B2_0() {
		check_0.form_team();
		assertEquals(one,check_0.get_team(2).get_B());
	}
		
	@Test
	public void get_C2_0() {
		check_0.form_team();
		assertEquals(three,check_0.get_team(2).get_C());
	}
	
	@Test
	public void get_D2_0() {
		check_0.form_team();
		assertEquals(null,check_0.get_team(2).get_D());
	}
		
	@Test
	public void get_leader2_0() {
		check_0.form_team();
		assertEquals("Cat",check_0.get_team(2).get_Leader());
	}
		
	@Test
	public void get_num2_0() {
		check_0.form_team();
		assertEquals(3,check_0.get_team(2).get_num());
	}
		
	@Test
	public void get_id2_0() {
		check_0.form_team();
		assertEquals(2,check_0.get_team(2).get_teamid());
	}
	
	@Test
	public void get_A3_0() {
		check_0.form_team();
		assertEquals(six,check_0.get_team(3).get_A());
	}
		
	@Test
	public void get_B3_0() {
		check_0.form_team();
		assertEquals(two,check_0.get_team(3).get_B());
	}
		
	@Test
	public void get_C3_0() {
		check_0.form_team();
		assertEquals(eight,check_0.get_team(3).get_C());
	}
		
	@Test
	public void get_D3_0() {
		check_0.form_team();
		assertEquals(null,check_0.get_team(3).get_D());
	}
		
	@Test
	public void get_leader3_0() {
		check_0.form_team();
		assertEquals("Fool",check_0.get_team(3).get_Leader());
	}
	
	@Test
	public void get_num3_0() {
		check_0.form_team();
		assertEquals(3,check_0.get_team(3).get_num());
	}
	
	@Test
	public void get_id3_0() {
		check_0.form_team();
		assertEquals(3,check_0.get_team(3).get_teamid());
	}
	
	@Test
	public void get_K1_average_0() {
		check_0.form_team();
		assertEquals(5.0,check_0.get_team(3).get_K1_average(),0.001);
	}
	
	@Test
	public void get_K2_average_0() {
		check_0.form_team();
		assertEquals(5.6667,check_0.get_team(3).get_K2_average(),0.001);
	}
}