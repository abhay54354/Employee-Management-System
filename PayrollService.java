import java.io.*;
if (empMap.containsKey(e.getId())) {
throw new EmployeeException("Employee ID already exists");
}
empMap.put(e.getId(), e);
saveData();
}


public void updateSalary(int id, double salary) throws EmployeeException {
Employee e = empMap.get(id);
if (e == null) {
throw new EmployeeException("Employee not found");
}
e.setBasicSalary(salary);
saveData();
}


public void viewAll() {
empMap.values().forEach(System.out::println);
}


public Employee search(int id) throws EmployeeException {
if (!empMap.containsKey(id)) {
throw new EmployeeException("Employee not found");
}
return empMap.get(id);
}


public void generateSalarySlip(int id) throws EmployeeException {
Employee e = search(id);


Runnable task = () -> {
try {
double basic = e.getBasicSalary();
double hra = basic * 0.20;
double da = basic * 0.10;
double gross = basic + hra + da;
double tax = gross < 50000 ? gross * 0.05 : gross * 0.10;
double net = gross - tax;


String slip = "Employee ID: " + e.getId() + "\n" +
"Name: " + e.getName() + "\n" +
"Department: " + e.getDepartment() + "\n" +
"Gross Salary: " + gross + "\n" +
"Tax: " + tax + "\n" +
"Net Salary: " + net;


new File("salary_slips").mkdir();
FileWriter fw = new FileWriter("salary_slips/" + e.getId() + ".txt");
fw.write(EncryptionUtil.encrypt(slip));
fw.close();


System.out.println("Salary slip generated for employee " + e.getId());
} catch (Exception ex) {
ex.printStackTrace();
}
};


new Thread(task).start();
}


private void saveData() {
try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE))) {
oos.writeObject(empMap);
} catch (IOException e) {
e.printStackTrace();
}
}


private void loadData() {
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE))) {
empMap = (Map<Integer, Employee>) ois.readObject();
} catch (Exception e) {
empMap = new HashMap<>();
}
}
}
