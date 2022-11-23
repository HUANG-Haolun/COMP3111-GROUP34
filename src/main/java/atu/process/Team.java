package atu.process;
/**
 * The class that represents the team. It has attributes of 3-4 students, team id, 
 * number of the member, Leader's name and their average of K1 and K2 energies.
 * 
 * @author jujonghyeon25
 * @see atu.process.Person
 */
import atu.input.*;

/**
 * The class that represents the team. It has attributes of 3-4 students, team
 * id,
 * number of the member, Leader's name and their average of K1 and K2 energies.
 */
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

	/**
	 * The constructor for Engine class. Initializes the attributes like teamid,
	 * num,
	 * A, B, C, D, and Leader. It also calculates the average of K1_energy and
	 * K2_energy of the Person instance A, B, C, and D, and assigns it to the
	 * attribute K1_average and K2_average of the Team instance.
	 * 
	 * @param id The id of the Team
	 * @param no The number of members of the Team that ranges from 3 to 4
	 * @param i  The Person instance, which is the first student of the Team
	 * @param j  The Person instance, which is the second student of the Team
	 * @param k  The Person instance, which is the third student of the Team
	 * @param l  The Person instance, which is the fourth student of the Team
	 *           (optional)
	 * @param boss The name of the leader of the Team
	 */
	public Team(int id, int no, Person i, Person j, Person k, Person l, String boss) {
		this.teamid = id;
		this.num = no;
		this.A = i;
		this.B = j;
		this.C = k;
		this.D = l;
		this.Leader = boss;
		if (this.D == null) {
			this.K1_average = (A.getK1energy() + B.getK1energy() + C.getK1energy()) / 3.0f;
			this.K2_average = (A.getK2energy() + B.getK2energy() + C.getK2energy()) / 3.0f;
		} else {
			this.K1_average = (A.getK1energy() + B.getK1energy() + C.getK1energy() + D.getK1energy()) / 4.0f;
			this.K2_average = (A.getK2energy() + B.getK2energy() + C.getK2energy() + D.getK2energy()) / 4.0f;
		}
	}

	/**
	 * The method that returns the id of the Team.
	 * 
	 * @return integer instance of {@link Team#teamid}
	 */
	public int get_teamid() {
		return this.teamid;
	}

	/**
	 * The method that sets a value to the id of the Team instance.
	 * 
	 * @param id The id of the Team instance.
	 */
	public void set_teamid(int id) {
		this.teamid = id;
	}

	/**
	 * The method that returns the number of the members in the Team.
	 * 
	 * @return integer instance of {@link Team#num}
	 */
	public int get_num() {
		return this.num;
	}

	/**
	 * The method that sets a value to the number of the members in the Team
	 * instance.
	 * 
	 * @param no The number of the members in the Team instance.
	 */
	public void set_num(int no) {
		this.num = no;
	}

	/**
	 * The method that returns the first member/student in the Team.
	 * 
	 * @return Person instance of {@link Team#A}
	 */
	public Person get_A() {
		return this.A;
	}

	/**
	 * The method that sets the first member to the Team instance.
	 * 
	 * @param man The first member in the Team instance.
	 */
	public void set_A(Person man) {
		this.A = man;
	}

	/**
	 * The method that returns the second member/student in the Team.
	 * 
	 * @return Person instance of {@link Team#B}
	 */
	public Person get_B() {
		return this.B;
	}

	/**
	 * The method that sets the second member to the Team instance.
	 * 
	 * @param man The second member in the Team instance.
	 */
	public void set_B(Person man) {
		this.B = man;
	}

	/**
	 * The method that returns the third member/student in the Team.
	 * 
	 * @return Person instance of {@link Team#C}
	 */
	public Person get_C() {
		return this.C;
	}

	/**
	 * The method that sets the third member to the Team instance.
	 * 
	 * @param man The third member in the Team instance.
	 */
	public void set_C(Person man) {
		this.C = man;
	}

	/**
	 * The method that returns the fourth member/student in the Team. (Optional)
	 * 
	 * @return Person instance of {@link Team#D}
	 */
	public Person get_D() {
		return this.D;
	}

	/**
	 * The method that sets the fourth member to the Team instance.
	 * 
	 * @param man The fourth member in the Team instance.
	 */
	public void set_D(Person man) {
		this.D = man;
	}

	/**
	 * The method that returns the name of the Leader in the Team.
	 * 
	 * @return String instance of {@link Team#Leader}
	 */
	public String get_Leader() {
		return this.Leader;
	}

	/**
	 * The method that returns the value of average K1_energy of the Team.
	 * 
	 * @return float instance of {@link Team#K1_average}
	 */
	public float get_K1_average() {
		return this.K1_average;
	}

	/**
	 * The method that returns the value of average K2_energy of the Team.
	 * 
	 * @return float instance of {@link Team#K2_average}
	 */
	public float get_K2_average() {
		return this.K2_average;
	}
}