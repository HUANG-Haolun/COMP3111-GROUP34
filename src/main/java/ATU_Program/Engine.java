package ATU_Program;
import java.util.ArrayList;
import java.util.List;
import atu.input.*;

/**
 * The class for arranging and forming the team and its list.
 * 
 * @author jujonghyeon25
 * @see Team, Person
 */
public class Engine {
	int size;
	List<Person> list;
	List<Person> K1_list;
	List<Person> K2_list;
	List<Person> K3_list;
	Team[] team_list;
	//List<Team> team_list;
	
	/**
	 * The constructor for Engine class. Initializes the attributes like team_list,
	 * K1_list, K2_list, and K3_list. It also assigns the value to the 
	 * attributes size and list by copying the value from the parameter.
	 * 
	 * @param size The size of the given list, which is total number of students.
	 * @param input The list of Person instances that is holding all the data about the students.
	 */
	public Engine(int size, List<Person> input) {
		this.size = size;
		this.list = new ArrayList<>();
		this.K1_list = new ArrayList<>();
		this.K2_list = new ArrayList<>();
		this.K3_list = new ArrayList<>();
		this.team_list = new Team[size/3];
		for (int i = 0; i < size; ++i)
			this.list.add(input.get(i));
	}

	/**
	 * The method that returns the size attribute of the Engine instance.
	 * 
	 * @return integer instance of {@link Engine#size}
	 */
	public int getsize() {
		return this.size;
	}
	
	/**
	 * The method that sets a value to the size attribute of the Engine instance.
	 * 
	 * @param i The size of the students in the list of Engine instance.
	 */
	public void setsize(int i) {
		this.size = i;
	}
	
	/**
	 * The method that returns the list of the students of the Engine instance.
	 * 
	 * @return List<Person> instance of {@link Engine#list}
	 */
	public List<Person> get_list() {
		return this.list;
	}
	
	/**
	 * The method that copies value of the parameter and assigns it to the
	 * student list attribute of the Engine class.
	 * 
	 * @param csv the list of the students
	 */
	public void setList(List<Person> csv) {
		this.list = csv;
	}
	
	/**
	 * The method that returns the K1_list of the students of the Engine instance.
	 * 
	 * @return List<Person> instance of {@link Engine#K1_list}
	 */
	public List<Person> get_K1list() {
		return this.K1_list;
	}
	
	/**
	 * The method that returns the K2_list of the students of the Engine instance.
	 * 
	 * @return List<Person> instance of {@link Engine#K2_list}
	 */
	public List<Person> get_K2list() {
		return this.K2_list;
	}
	
	/**
	 * The method that returns the K3_list of the students of the Engine instance.
	 * 
	 * @return List<Person> instance of {@link Engine#K3_list}
	 */
	public List<Person> get_K3list() {
		return this.K3_list;
	}

	/**
	 * The method that copies value of the parameter and uses it to sort a list into
	 * the Person instances with descending order of K1_energy and if they have same
	 * K1_energy, then Person instance with lower K2_energy will be in previous order. 
	 * Finally, the first one-third Person instances of the sorted list is copied to 
	 * the K1_list of the Engine.
	 * 
	 * @param list the list of the students
	 */
	public void arrange_K1(List<Person> list){
		List<Person> copy = new ArrayList<>(list);
		for (int i = 1; i < list.size(); ++i) {
			int j = i - 1;
			while (j >= 0 && copy.get(j+1).getK1energy() >= copy.get(j).getK1energy()) {
				if (copy.get(j+1).getK1energy() == copy.get(j).getK1energy()) {
					if (copy.get(j+1).getK2energy() < copy.get(j).getK2energy()) {
						Person temp = copy.get(j+1);
						copy.set(j+1,copy.get(j));
						copy.set(j,temp);
					}
					--j;
				} else {
					Person temp = copy.get(j+1);
					copy.set(j+1,copy.get(j));
					copy.set(j,temp);
					--j;
				}
			}
		}
		for (int i = 0; i < list.size()/3; ++i) {
			this.K1_list.add(copy.get(i));
		}
	}
	
	/**
	 * The method that copies value of the parameter and uses it to sort a list into
	 * the Person instances with ascending order of K2_energy and if they have same
	 * K2_energy, then Person instance with lower K1_energy will be in previous order. 
	 * Finally, the one-third Person instances of the sorted list which are not 
	 * present in the K1_list are copied to the K2_list of the Engine.
	 * 
	 * @param list the list of the students
	 */
	public void arrange_K2(List<Person> list){
		List<Person> copy = new ArrayList<>(list);
		for (int i = 1; i < list.size(); ++i) {
			int j = i - 1;
			while (j >= 0 && copy.get(j+1).getK2energy() <= copy.get(j).getK2energy()) {
				if (copy.get(j+1).getK2energy() == copy.get(j).getK2energy()) {
					if (copy.get(j+1).getK1energy() < copy.get(j).getK1energy()) {
						Person temp = copy.get(j+1);
						copy.set(j+1,copy.get(j));
						copy.set(j,temp);
					}
					--j;
				} else {
					Person temp = copy.get(j+1);
					copy.set(j+1,copy.get(j));
					copy.set(j,temp);
					--j;
				}
			}
		}
		for (int i = 0; i < list.size(); ++i) {
			if (!this.K1_list.contains(copy.get(i)))
				this.K2_list.add(copy.get(i));
			if (this.K2_list.size() == list.size()/3)
				break;
		}
	}
	
	/**
	 * The method that copies value of the parameter and uses it to sort a list into
	 * the Person instances with descending order of K2_energy and if they have same
	 * K2_energy, then Person instance with lower K1_energy will be in previous order. 
	 * Finally, the first one-third Person instances of the sorted list which are not 
	 * present in both K1_list and K2_list are copied to the K2_list of the Engine.
	 *
	 * @param list the list of the students
	 */
	public void arrange_K3(List<Person> list){
		List<Person> copy = new ArrayList<>(list);
		for (int i = 1; i < list.size(); ++i) {
			int j = i - 1;
			while (j >= 0 && copy.get(j+1).getK2energy() >= copy.get(j).getK2energy()) {
				if (copy.get(j+1).getK2energy() == copy.get(j).getK2energy()) {
					if (copy.get(j+1).getK1energy() < copy.get(j).getK1energy()) {
						Person temp = copy.get(j+1);
						copy.set(j+1,copy.get(j));
						copy.set(j,temp);
					}
					--j;
				} else {
					Person temp = copy.get(j+1);
					copy.set(j+1,copy.get(j));
					copy.set(j,temp);
					--j;
				}
			}
		}
		for (int i = 0; i < list.size(); ++i) {
			if (!this.K1_list.contains(copy.get(i)) && !this.K2_list.contains(copy.get(i)))
				this.K3_list.add(copy.get(i));
			if (this.K3_list.size() == list.size()/3)
				break;
		}
	}
	
	/**
	 * The method that first copies value of the parameter and uses it to sort a list 
	 * into the Person instances with descending order. Then, the remaining number of
	 * the students after division with 3 from the size of the list is calculated and
	 * that number of the students are removed from the list from the middle of the 
	 * K1_list, which will be near to the mean value of K1_energy.
	 * 
	 * After that, since the original list must be obtained, the list of Engine class 
	 * is used again for remaining execution. Then, the removed Person instances are
	 * once again removed from this newly brought list. 
	 * 
	 * The list is then used to arrange K1_list, K2_list and K3_list. After that for
	 * each iteration, one Person instance from each three lists are brought into 
	 * team and the leader is chosen by comparing the preferences of being the leader 
	 * and Person instance who has the highest K2_energy.
	 * 
	 * Finally, the Person instances (students) that are removed from the list are
	 * designated to the different teams each according to the number of removed 
	 * students. The previously chosen leader and the newly added students are 
	 * compared same way with the previous method to update the new leader. Then the 
	 * Team instances are created and all the Team instances that are created is 
	 * added to the team_list by team i having the array index i - 1. 
	 */
	public void form_team(){
		//Arrange the copy in K1 decreasing order
		List<Person> copy = new ArrayList<>(this.list);
		for (int i = 1; i < copy.size(); ++i) {
			int j = i - 1;
			while (j >= 0 && copy.get(j+1).getK1energy() >= copy.get(j).getK1energy()) {
				if (copy.get(j+1).getK1energy() == copy.get(j).getK1energy()) {
					if (copy.get(j+1).getK2energy() < copy.get(j).getK2energy()) {
						Person temp = copy.get(j+1);
						copy.set(j+1,copy.get(j));
						copy.set(j,temp);
					}
					--j;
				} else {
					Person temp = copy.get(j+1);
					copy.set(j+1,copy.get(j));
					copy.set(j,temp);
					--j;
				}
			}
		}
		int left = 0;
		Person extra = null;
		Person extra1 = null;
		Person extra2 = null;
		//if not divisible by 3
		if (this.size % 3 == 1) {
			extra = copy.remove(copy.size()/2);
			left = 1;
		} else if (this.size % 3 == 2){
			extra1 = copy.remove(copy.size()/2);
			extra2 = copy.remove(copy.size()/2);
			left = 2;
		}
		//receive the original list again to maintain the order of original list
		copy = new ArrayList<>(this.list);
		if (this.size % 3 == 1) {
			copy.remove(extra);
		} else if (this.size % 3 == 2){
			copy.remove(extra1);
			copy.remove(extra2);
			left = 2;
		}
		//arrange K1, K2 and K3 list
		this.arrange_K1(copy);
		this.arrange_K2(copy);
		this.arrange_K3(copy);
		int num = 3;
		//create teams
		for (int i = 0; i < copy.size()/num; ++i) {
			int teamid = i + 1;
			Person a = this.K1_list.get(i);
			Person b = this.K2_list.get(i);
			Person c = this.K3_list.get(i);
			Person d = null;
			String leader;
			//choose team leader
			int a_K2 = a.getK2energy();
			int b_K2 = b.getK2energy();
			int c_K2 = c.getK2energy();
			if (a.getMypreference() == 1) {
				if (b.getMypreference() == 1) {
					if (c.getMypreference() == 1)
						leader = (((a_K2>=b_K2?a_K2:b_K2)>=c_K2)?(a_K2>=b_K2?a:b):c).getStudentname();
					else leader = (a_K2>=b_K2?a:b).getStudentname();
				} else {
					if (c.getMypreference() == 1)
						leader = (a_K2>=c_K2?a:c).getStudentname();
					else leader = a.getStudentname();
				}
			} else {
				if (b.getMypreference() == 1) {
					if (c.getMypreference() == 1)
						leader = (b_K2>=c_K2?b:c).getStudentname();
					else leader = b.getStudentname();
				} else {
					if (c.getMypreference() == 1)
						leader = c.getStudentname();
					else
						leader = (((a_K2>=b_K2?a_K2:b_K2)>=c_K2)?(a_K2>=b_K2?a:b):c).getStudentname();
				}
			}
			Team temp = new Team(teamid,num,a,b,c,d,leader);
			//add to team list
			this.team_list[i] = temp;
		}
		//all the teams are made with 3 members, extra need to be added.
		if (left == 1) {
			//add extra student
			num = 4;
			int teamid = 1;
			Person a = this.team_list[0].get_A();
			Person b = this.team_list[0].get_B();
			Person c = this.team_list[0].get_C();
			Person d = extra;
			String leader = this.team_list[0].get_Leader();
			Person candidate = null;
			if (leader.equals(a.getStudentname()))
				candidate = a;
			else if (leader.equals(b.getStudentname()))
				candidate = b;
			else candidate = c;
			int K2_candidate = candidate.getK2energy();
			int K2_D = d.getK2energy();
			if (d.getMypreference() == 1) {
				if (candidate.getMypreference() == 1) {
					leader = (K2_candidate>K2_D?candidate:d).getStudentname();
				}
				else {
					leader = d.getStudentname();
				}
			} else {
				if ((candidate.getMypreference() == 0) && (d.getMypreference() == 0))
					leader = (K2_candidate>K2_D?candidate:d).getStudentname();
			}
			Team replace = new Team(teamid,num,a,b,c,d,leader);
			this.team_list[0] = replace;
		}
		//add 2 extra students to separate team
		if (left == 2) {
			//add 1st student
			num = 4;
			int teamid = 1;
			Person a = this.team_list[0].get_A();
			Person b = this.team_list[0].get_B();
			Person c = this.team_list[0].get_C();
			Person d = extra2;
			String leader = this.team_list[0].get_Leader();
			Person candidate = null;
			if (leader.equals(a.getStudentname()))
				candidate = a;
			else if (leader.equals(b.getStudentname()))
				candidate = b;
			else candidate = c;
			int K2_candidate = candidate.getK2energy();
			int K2_D = d.getK2energy();
			if (d.getMypreference() == 1) {
				if (candidate.getMypreference() == 1) {
					leader = (K2_candidate>K2_D?candidate:d).getStudentname();
				}
				else {
					leader = d.getStudentname();
				}
			} else {
				if ((candidate.getMypreference() == 0) && (d.getMypreference() == 0))
					leader = (K2_candidate>K2_D?candidate:d).getStudentname();
			}
			Team replace = new Team(teamid,num,a,b,c,d,leader);
			team_list[0] = replace;
			//add second student
			teamid = 2;
			a = this.team_list[1].get_A();
			b = this.team_list[1].get_B();
			c = this.team_list[1].get_C();
			d = extra1;
			leader = this.team_list[1].get_Leader();
			if (leader.equals(a.getStudentname()))
				candidate = a;
			else if (leader.equals(b.getStudentname()))
				candidate = b;
			else candidate = c;
			K2_candidate = candidate.getK2energy();
			K2_D = d.getK2energy();
			if (d.getMypreference() == 1) {
				if (candidate.getMypreference() == 1) {
					leader = (K2_candidate>K2_D?candidate:d).getStudentname();
				}
				else {
					leader = d.getStudentname();
				}
			} else {
				if ((candidate.getMypreference() == 0) && (d.getMypreference() == 0))
					leader = (K2_candidate>K2_D?candidate:d).getStudentname();
			}
			Team replace1 = new Team(teamid,num,a,b,c,d,leader);
			team_list[1] = replace1;
		}
	}

	/**
	 * The method that returns the array of Team instances from the Engine instance.
	 * 
	 * @return Team[] instance of {@link Engine#team_list}
	 */
	public Team[] get_teamlist() {
		return this.team_list;
	}

	/**
	 * The method that returns the Team instance by using the team id as the parameter.
	 * 
	 * @param i the id of the Team instance
	 * @return Team instance of Team from the {@link Engine#team_list}
	 */
	public Team get_team(int i){
		return this.team_list[i-1];
	}

}