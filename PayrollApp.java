import java.util.Scanner;


public class PayrollApp {
public static void main(String[] args) {


PayrollService service = new PayrollService();
Scanner sc = new Scanner(System.in);


while (true) {
System.out.println("\n1.Add 2.Update 3.View 4.Slip 5.Search 6.Exit");
int choice = sc.nextInt();


try {
switch (choice) {
case 1:
System.out.print("ID: ");
int id = sc.nextInt();
System.out.print("Name: ");
String name = sc.next();
System.out.print("Dept: ");
String dept = sc.next();
System.out.print("Salary: ");
double sal = sc.nextDouble();


service.addEmployee(new Employee(id, name, dept, sal));
break;


case 2:
System.out.print("ID: ");
service.updateSalary(sc.nextInt(), sc.nextDouble());
break;


case 3:
service.viewAll();
break;


case 4:
System.out.print("ID: ");
service.generateSalarySlip(sc.nextInt());
break;


case 5:
System.out.println(service.search(sc.nextInt()));
break;


case 6:
System.exit(0);


default:
System.out.println("Wrong choice");
}
} catch (EmployeeException e) {
System.out.println(e.getMessage());
}
}
}
}
