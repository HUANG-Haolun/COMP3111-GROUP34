package ATU_Program;
import java.util.ArrayList;
import java.util.List;
import atu.input.*;


public class Engine {
	int size;
	List<Person> list;
	List<Person> K1_list;
	List<Person> K2_list;
	List<Person> K3_list;
	Team[] team_list;
	//List<Team> team_list;
	
	public Engine(int size, List<Person> input) {
		this.size = size;
		this.list = new ArrayList<>();
		this.K1_list = new ArrayList<>();
		this.K2_list = new ArrayList<>();
		this.K3_list = new ArrayList<>();
		this.team_list = new Team[size/3];
		//this.team_list = new ArrayList<>();
		for (int i = 0; i < size; ++i)
			this.list.add(input.get(i));
	}

	public int getsize() {
		return this.size;
	}
	
	public void setsize(int i) {
		this.size = i;
	}

	public List<Person> get_list() {
		return this.list;
	}
	
	public void setList(List<Person> csv) {
		this.list = csv;
	}
	
	public List<Person> get_K1list() {
		return this.K1_list;
	}
	
	public List<Person> get_K2list() {
		return this.K2_list;
	}
	
	public List<Person> get_K3list() {
		return this.K3_list;
	}

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

	public Team[] get_teamlist() {
		return this.team_list;
	}

	public Team get_team(int i){
		return this.team_list[i-1];
	}

}