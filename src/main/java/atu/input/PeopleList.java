package atu.input;

import atu.input.Person;
import java.util.ArrayList;
import java.util.List;

public class PeopleList {
	private float[] k1_energy = {0,100,0};
	private float[] k2_energy = {0,100,0};
	private int k3_trick1 = 0;
	private int k3_trick2 = 0;
	private int my_pref = 0;
	List<Person> students = new ArrayList<>();
	public PeopleList(){

	}
	public PeopleList(float[] k1_energy, float[] k2_energy, int k3_trick1, int k3_trick2, int my_preference) {
		this.k1_energy = k1_energy;
		this.k2_energy = k2_energy;
		this.k3_trick1 = k3_trick1;
		this.k3_trick2 = k3_trick2;
		this.my_pref = my_preference;
	}

	public float[] getk1() {
		return k1_energy;
	}

	public void setk1(float[] var) {
		k1_energy = var;
	}

	public float[] getk2() {
		return k2_energy;
	}

	public void setk2(float[] var) {
		k2_energy = var;
	}

	public int getk3t1() {
		return k3_trick1;
	}

	public void setk3t1(int var) {
		k3_trick1 = var;
	}

	public int getk3t2() {
		return k3_trick2;
	}

	public void setk3t2(int var) {
		k3_trick2 = var;
	}

	public int getpref() {
		return my_pref;
	}

	public void setpref(int var) {
		my_pref = var;
	}

	public void addStudent(Person p){
		students.add(p);
	}
}
