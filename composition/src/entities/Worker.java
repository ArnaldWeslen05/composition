package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkLevel;

public class Worker {

	private String name;
	private WorkLevel level;
	private Double baseSalary;

	private Department departament;
	private List<HourCrontact> contracts = new ArrayList<>();

	public Worker() {

	}

	public Worker(String name, WorkLevel level, Double baseSalary, Department departament) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkLevel getLevel() {
		return level;
	}

	public void setLevel(WorkLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartament() {
		return departament;
	}

	public void setDepartament(Department departament) {
		this.departament = departament;
	}

	public List<HourCrontact> getContracts() {
		return contracts;
	}

	public void addContract(HourCrontact contract) {
		contracts.add(contract);
	}

	public void removeContract(HourCrontact contract) {
		contracts.remove(contract);
	}

	public double income( int year , int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for ( HourCrontact c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR); 
			int c_month = 1 + cal.get(Calendar.MONTH);
			if(year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}

}
