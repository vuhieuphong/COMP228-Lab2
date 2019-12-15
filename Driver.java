import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Driver {
	//static method to display user menu
	private static void displayMenu() {
		System.out.println("MENU:");
		System.out.println("a: Add new employee ");
		System.out.println("b: View employee profile ");
		System.out.println("Any other key: Exit ");
	}
	//static method to enter a new employee info
	private static void enterEmployeeInfo(Scanner input) {
		System.out.print("Please enter the name of the employee: ");
		String name=input.next();
		System.out.print("Please enter the new employee's address: ");
		input=new Scanner(System.in);
		String address=input.next();
		input=new Scanner(System.in);			
		System.out.print("Please enter the new employee's date of birth (MM/dd/yyyy): ");
		String dateOfBirthString=input.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateFormat.setLenient(false);
		Date dateOfBirth=null;
		while(dateOfBirth==null)
		{
			try {
			    dateOfBirth = dateFormat.parse(dateOfBirthString);
			} catch (ParseException e) {
			    dateOfBirth=null;
			    System.out.print("Invalid birthday. Try again (MM/dd/yyyy): ");
			    input=new Scanner(System.in);
				dateOfBirthString=input.next();
			}
		}
		SimpleDateFormat newDateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
		System.out.println("You entered: "+newDateFormat.format(dateOfBirth));
		input=new Scanner(System.in);					
		System.out.print("Please enter the date that the new employee is hired (MM/dd/yyyy): ");
		String hireDateString=input.next();
		Date hireDate=null;
		while(hireDate==null)
		{
			try {
			    hireDate = dateFormat.parse(hireDateString);
			} catch (ParseException e) {
			    hireDate=null;
			    System.out.print("Invalid hire date. Try again (mm/dd/yyyy): ");
			    input=new Scanner(System.in);
			    hireDateString=input.next();
			}
		}
		System.out.println("You entered: "+newDateFormat.format(hireDate));
		
		input=new Scanner(System.in);	
		System.out.print("Please enter the new employee's yearly salary: ");
		double salary=input.nextDouble();
		
		Employee newEmployee=new Employee(name, address, dateOfBirth, hireDate, salary);
		Employee.employees.add(newEmployee);
		newEmployee.printDataForNewEmployee();
		System.out.println();
	}
	//static method to choose and view an employee's info
	private static void viewEmployeeInfo(Scanner input) {
		if(Employee.employees.size()==0)
		{
			System.out.println("No employee record found!");
			System.out.println();
		}
		else
		{
			Employee.printEmployeesListNames();
			System.out.print("Choose the employee profile you want to see: ");
			int employeeOrder=input.nextInt();				
			while(true)
			{
				if(employeeOrder>Employee.employees.size()||employeeOrder<=0)
				{
					System.out.print("Invalid employee. Try again. ");
					System.out.print("Choose the employee profile you want to see: ");
					employeeOrder=input.nextInt();
				}
				else 
				{
					Employee.printDataForChosenEmployee(employeeOrder);
					System.out.println();
					break;							
				}
			}			

		}
	}
	
	public static void main(String[] args) {
		//ask for user input		
		while(true)
		{
			displayMenu();
			Scanner input=new Scanner(System.in);			
			System.out.print("Which menu choice do you want to make: ");
			String choice=input.next();
			if(choice.equals("a"))
			{
				enterEmployeeInfo(input);
			}
			else if(choice.equals("b"))
			{
				
				viewEmployeeInfo(input);
	        }
			else
			{
				System.out.println("Goodbye!");
				input.close();
				break;
			}
		}
		
	}
}


