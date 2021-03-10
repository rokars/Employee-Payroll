package ie.gmit;

import java.util.ArrayList;

public class EmployeeList {

    private ArrayList<Employee> employees;
    private int count = 0;

    public EmployeeList() {
        employees = new ArrayList<Employee>();
    }

    public void addEmployee(Employee e) {
        if (findEmployee(e.getPPS_ID()) == null)
        {
            employees.add(e);
            count++;
        }
        else {
            throw new IllegalArgumentException("Duplicate Employee details found, no object added");
        }

    }

    public Employee findEmployee(String pps) {

        for (int i = 0; i < count; i++) {
            Employee emp = employees.get(i);
            if (emp.getPPS_ID().equals(pps)) {
                return emp;
            }
        }

        return null;
    }

    public boolean deleteEmployee(Employee e) {
        if (findEmployee(e.getPPS_ID()) != null)
        {
            employees.remove(e);
            count--;
            return true;
        }
        else {
            return false;
        }
    }

    public int getListSize() {
        return count;
    }
}
