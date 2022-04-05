package EmployeeWageComp;

public class TotalWageEachCompany {

	public static final int IS_PART_TIME = 1;
	public static final int IS_FULL_TIME = 2;
	
	private final String company;
	private final int empRatePerHour;
	private final int numOfWorkingDays;
	private final int maxHourPerMOnth;
	private int totalEmpWage;
	
	public TotalWageEachCompany(String company, int empRatePerHour, int numOfWorkingDays, int maxHourPerMonth) {
		
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHourPerMOnth = maxHourPerMonth;
	}
	
	public void computeEmpWage() {
		int empHrs = 0, totalEmpHrs = 0, totalWorkingDays = 0;
		while (totalEmpHrs <= maxHourPerMOnth && totalWorkingDays < numOfWorkingDays) {
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
		totalEmpWage = totalEmpHrs * empRatePerHour;
	}
	public String toString() {
		return "Total Emp Wage for Company: " +company+ " is:" + totalEmpWage;
	}
	public static void main(String[] args) {
		TotalWageEachCompany dMart = new TotalWageEachCompany("DMart", 20, 2, 10);
		TotalWageEachCompany reliance = new TotalWageEachCompany("Reliance", 10, 4, 20 );
		dMart.computeEmpWage();
		System.out.println(dMart);
		reliance.computeEmpWage();
		System.out.println(reliance);
	}
	}
	

