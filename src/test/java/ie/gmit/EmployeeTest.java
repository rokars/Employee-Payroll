/*
    Rokas Cesiunas
    10 Mar 2021
    Employee Payroll Exam
 */

package ie.gmit;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    // test
    @Test
    void setUpEmployee() {
        assertDoesNotThrow(() -> {new Employee("Mr", "Johhny", "012345", "0874567", "Full-time", 20);});

        Employee e = new Employee("Mr", "Johhny", "012345", "0874567", "Full-time", 20);
        assertEquals("Mr", e.getTitle());
        assertEquals("Johhny", e.getName());
        assertEquals("012345", e.getPPS_ID());
        assertEquals("0874567", e.getPhone());
        assertEquals("Full-time", e.getEmployement_Type());
        assertEquals(20, e.getAge());
    }

    @Test
    void testEmployeeTitle() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {new Employee("Sir", "Johhny", "012345", "0874567", "Full-time", 20);});
        assertEquals("Invalid employee title" , e.getMessage());

        Employee p = new Employee("Mr", "Johhny", "012345", "0874567", "Full-time", 20);
        p.setTitle("Mr");
        assertEquals("Mr", p.getTitle());
        p.setTitle("Mrs");
        assertEquals("Mrs", p.getTitle());
        p.setTitle("Miss");
        assertEquals("Miss", p.getTitle());
    }

    @Test
    void testEmployeeName() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {new Employee("Mr", "Jo", "012345", "0874567", "Full-time", 20);});
        assertEquals("Employee name must contain atleast 5 characters" , e.getMessage());

        e = assertThrows(IllegalArgumentException.class, () -> {new Employee("Mr", "Billy Aniki Herrington  ", "012345", "0874567", "Full-time", 20);});
        assertEquals("Employee name must be less than 22 characters" , e.getMessage());
    }

    @Test
    void testEmployeePPSID() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {new Employee("Mr", "Johhny", "012", "0874567", "Full-time", 20);});
        assertEquals("Employee PPS should be 6 characters", e.getMessage());
    }

    @Test
    void testEmployeePhone() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {new Employee("Mr", "Johhny", "012345", "087", "Full-time", 20);});
        assertEquals("Employee phone number should be 7 characters", e.getMessage());
    }

    @Test
    void testEmployeeEmployementType() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {new Employee("Mr", "Johhny", "012345", "0874567", "Half-time", 20);});
        assertEquals("Invalid employee employement type", e.getMessage());
    }

    @Test
    void testEmployeeAge() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> {new Employee("Mr", "Johhny", "012345", "0874567", "Full-time", 5);});
        assertEquals("Age must be over 18", e.getMessage());
    }

    @Test
    void testEmployeeList() {
        assertDoesNotThrow((Executable) EmployeeList::new);

        EmployeeList el = new EmployeeList();
        el.addEmployee(new Employee("Mr", "Johhny", "012345", "0874567", "Full-time", 20));
        assertEquals(1, el.getListSize());
        el.addEmployee(new Employee("Mr", "Richard", "123456", "0874568", "Full-time", 50));
        assertEquals(2, el.getListSize());

        assertThrows(IllegalArgumentException.class, () -> {el.addEmployee(new Employee("Mr", "Johhny", "012345", "0874567", "Full-time", 20));});


        Employee e1 = new Employee("Mrs", "Silver", "345678", "0871234", "Part-time", 56);
        assertDoesNotThrow(() -> {el.addEmployee(e1);});
        el.deleteEmployee(e1);

        assertEquals(2, el.getListSize());

        Employee e2 = new Employee("Mrs", "Silver", "323331", "0871234", "Part-time", 56);
        assertFalse(el.deleteEmployee(e2));
    }
}
