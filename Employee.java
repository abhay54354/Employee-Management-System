import java.io.Serializable;


public class Employee implements Serializable {
private int id;
private String name;
private String department;
private double basicSalary;


public Employee(int id, String name, String department, double basicSalary) {
this.id = id;
this.name = name;
this.department = department;
this.basicSalary = basicSalary;
}


public int getId() {
return id;
}


public String getName() {
return name;
}


public String getDepartment() {
return department;
}


public double getBasicSalary() {
return basicSalary;
}


public void setBasicSalary(double basicSalary) {
this.basicSalary = basicSalary;
}


@Override
public String toString() {
return id + " | " + name + " | " + department + " | " + basicSalary;
}
}
