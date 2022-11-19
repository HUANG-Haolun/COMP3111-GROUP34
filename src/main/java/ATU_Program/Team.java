package ATU_Program;

public class Team {
	private int teamid = 0;
	private int num = 3;
	private Person A;
	private Person B;
	private Person C;
	private Person D;
	private String Leader;
	private float K1_average;
	private float K2_average;
	
	public Team(int id,int no,Person i,Person j,Person k,Person l,String boss){
		this.teamid = id;
		this.num = no;
		this.A = i;
		this.B = j;
		this.C = k;
		this.D = l;
		this.Leader = boss;
		if (this.D == null) {
			this.K1_average = (A.getK1energy()+B.getK1energy()+C.getK1energy())/3;
			this.K2_average = (A.getK2energy()+B.getK2energy()+C.getK2energy())/3;
		} else {
			this.K1_average = (A.getK1energy()+B.getK1energy()+C.getK1energy()+D.getK1energy())/4;
			this.K2_average = (A.getK2energy()+B.getK2energy()+C.getK2energy()+D.getK2energy())/4;
		}
	}
	
	public int get_teamid() {
		return this.teamid;
	}
	
	public void set_teamid(int id) {
		this.teamid = id;
	}
	
	public int get_num() {
		return this.num;
	}
	
	public void set_num(int no) {
		this.num = no;
	}
	
	public Person get_A() {
		return this.A;
	}
	
	public void set_A(Person man) {
		this.A = man;
	}
	
	public Person get_B() {
		return this.B;
	}
	
	public void set_B(Person man) {
		this.B = man;
	}
	
	public Person get_C() {
		return this.C;
	}
	
	public void set_C(Person man) {
		this.C = man;
	}
	
	public Person get_D() {
		return this.D;
	}
	
	public void set_D(Person man) {
		this.D = man;
	}
	
	public String get_Leader() {
		return this.Leader;
	}
	
	public float get_K1_average() {
		return this.K1_average;
	}
	
	public float get_K2_average() {
		return this.K2_average;
	}
}