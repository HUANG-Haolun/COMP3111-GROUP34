package atu.input;

/**
 * Created by HUANG Haolun on 2022/10/20.
 * This class is used to store the data of the csv file.
 * It contains the data of the csv file and the methods to get the data.
 * It also contains the methods to set the data.
 * @author HUANG Haolun(hhuangbl@connect.ust.hk)
 * @version 1.0
 * @since 1.0
 * @see Person
 */

import atu.input.Person;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to store the data of the csv file.
 * It contains the data of the csv file and the methods to get the data.
 * It also contains the methods to set the data.
 */
public class PeopleList {
	private float[] k1_energy = { 0, 100, 0 };
	private float[] k2_energy = { 0, 100, 0 };
	private int k3_trick1 = 0;
	private int k3_trick2 = 0;
	private int my_pref = 0;
	private int size = 0;
	List<Person> students = new ArrayList<>();

	/**
	 * This method is the default constructor of the class.
	 */
	public PeopleList() {
	}

	/**
	 * This method is the constructor of the class PeopleList.
	 * 
	 * @param k1_energy The array of the energy of the first trick.
	 * @param k2_energy The array of the energy of the second trick.
	 * @param k3_trick1 The number of the people who choose the k3 first trick.
	 * @param k3_trick2 The number of the people who choose the k3 second trick.
	 * @param my_preference The number of the people who prefer to do leader.
	 */
	public PeopleList(float[] k1_energy, float[] k2_energy, int k3_trick1, int k3_trick2, int my_preference) {
		this.k1_energy = k1_energy;
		this.k2_energy = k2_energy;
		this.k3_trick1 = k3_trick1;
		this.k3_trick2 = k3_trick2;
		this.my_pref = my_preference;
	}

	/**
	 * This method is used to get the array of the energy of the k1.
	 * @return float[] The array of the energy of the k1.
	 */
	public float[] getk1() {
		return k1_energy;
	}

	/**
	 * This method is used to set the array of the energy of the k1.
	 * @param var The array of the energy of the k1.
	 */
	public void setk1(float[] var) {
		k1_energy = var;
	}

	/**
	 * This method is used to get the array of the energy of the k2.
	 * @return float[] The array of the energy of the k2.
	 */
	public float[] getk2() {
		return k2_energy;
	}

	/** 
	 * This method is used to set the array of the energy of the k2.
	 * @param var The array of the energy of the k2.
	 */
	public void setk2(float[] var) {
		k2_energy = var;
	}

	/**
	 * This method is used to get the number of the people who choose the k3 trick 1.
	 * @return int The number of the people who choose the first trick.
	 */
	public int getk3t1() {
		return k3_trick1;
	}

	/**
	 * This method is used to set the number of the people who choose the k3 trick 1.
	 * @param var The number of the people who choose the first trick.
	 */
	public void setk3t1(int var) {
		k3_trick1 = var;
	}

	/**
	 * This method is used to get the number of the people who choose the k3 trick 2.
	 * @return int The number of the people who choose the second trick.
	 */
	public int getk3t2() {
		return k3_trick2;
	}

	/**
	 * This method is used to set the number of the people who choose the k3 trick 2.
	 * @param var The number of the people who choose the second trick.
	 */
	public void setk3t2(int var) {
		k3_trick2 = var;
	}

	/**
	 * This method is used to get the number of the people who prefer to do leader.
	 * @return int The number of the people who prefer to do leader.
	 */
	public int getpref() {
		return my_pref;
	}

	/**
	 * This method is used to set the number of the people who prefer to do leader.
	 * @param var The number of the people who prefer to do leader.
	 */
	public void setpref(int var) {
		my_pref = var;
	}

	/**
	 * This method is used to add a person to the list.
	 * @param p The person to be added.
	 */
	public void addStudent(Person p) {
		students.add(p);
		size++;
	}

	/**
	 * This method is used to get the size of the list.
	 * @return int The size of the list.
	 */
	public int size() {
		return size;
	}

	/**
	 * This method is used to get the person at the index.
	 * @return List The list of the people.
	 */
	public List<Person> getStudents() {
		return students;
	}
}
