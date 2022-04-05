package EmployeeWageComp;

public class CompanyEmpWage {
	public final String company;
	public final int empRatePerHour;
	public final int numOfWorkingDays;
	public final int maxHourPerMOnth;
	public int totalEmpWage;
	
public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHourPerMonth) {
		
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHourPerMOnth = maxHourPerMonth;
}
public void setTotalEmpWage(int totalEmpWage) {
	this.totalEmpWage = totalEmpWage;

}

public String toString() {
	return " Tptal EmpWagefor Company: " +company+ " is: " +totalEmpWage;
	
}
}
public class EmpWageBuilderArray{
	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	
	private int numOfCompany = 0;
	private CompanyEmpWage[] companyEmpWageArray;
	
	public EmpWageBuilderArray() {
		companyEmpWageArray = new CompanyEmpWage[5];
	}
	private void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
		companyEmpWageArray[numOfCompany] = new CompanyEmpWage(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
	
		numOfCompany++;
		
	}
	
	private void computeEmpWage() {
		for (int i = 0; i < numOfCompany; i++) {
			companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
			
		}
	}
private int computeEmpWage(CompanyEmpWage companyEmpWage) {
	int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
	while (totalEmpHrs <= companyEmpWage.maxHourPerMOnth && totalWorkingDays < companyEmpWage.numOfWorkingDays) {
		totalWorkingDays++;
		int empCheck = (int) Math.floor(Math.random() * 10)% 3;
		switch (empCheck) {
		case IS_PART_TIME:
			empHrs = 4;
			break;
		case IS_FULL_TIME:
			empHrs = 8;
			break;
			default:
				empHrs = 0;
		}
		totalEmpHrs += empHrs;
		System.out.println("Day#: " + totalWorkingDays + "Emp Hrs: " + empHrs);
	}
	return totalEmpHrs * companyEmpWage.empRatePerHour;
	
}

public static void main(String[] args) {
	EmpWageBuilderArray empWageBuilder = new EmpWageBuilderArray();
	empWageBuilder.addCompanyEmpWage("DMART", 20, 2, 10);
	empWageBuilder.addCompanyEmpWage("Reliance",10, 4, 20);
	empWageBuilder.computeEmpWage();
}

}
