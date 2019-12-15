import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Employee {
	//private attributes of employee's informations
	private String name;
	private String address;
	private Date dateOfBirth;
	private Date hireDate;
	private double salary;
	//static list of employees
	public static List<Employee> employees=new ArrayList<Employee>(); 
	//constructor for the employee class
	public Employee(String name,String address,Date dateOfBirth,Date hireDate,double salary)
	{
		this.name=name;
		this.address=address;
		this.dateOfBirth=dateOfBirth;
		this.hireDate=hireDate;
		this.salary=salary;
	}
	//method to print an employee's data after a new employee is entered
	public void printDataForNewEmployee()
	{
		System.out.println("=====================");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("Data for the new employee as entered");
		System.out.println("Name: "+name);
		System.out.println("Address: "+address);
		System.out.println("DOB: "+dateFormat.format(dateOfBirth));
		System.out.println("Hire date: "+dateFormat.format(hireDate));
		System.out.println("Yearly salary: "+salary);		
		System.out.println("=====================");
	}
	//method to print a list of employees in employee list
	public static void printEmployeesListNames()
	{
		int i=1;
		for (Employee employee : employees) {
			System.out.println(i+". "+employee.name);
			i++;
		}
	}
	//method to print an chosen employee's data in the employees list
	public static void printDataForChosenEmployee(int employeeOrder)
	{
		Employee chosenEmployee=employees.get(employeeOrder-1);
		System.out.println("=====================");
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		System.out.println("Data for the new employee as entered");
		System.out.println("Name: "+chosenEmployee.name);
		System.out.println("Address: "+chosenEmployee.address);
		System.out.println("DOB: "+dateFormat.format(chosenEmployee.dateOfBirth));
		System.out.println("Hire date: "+dateFormat.format(chosenEmployee.hireDate));
		System.out.println("Yearly salary: "+chosenEmployee.salary);		
		System.out.println("=====================");
	}
}
