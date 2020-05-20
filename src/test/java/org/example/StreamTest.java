package org.example;

import org.example.data.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class StreamTest {

    @Test
    public void listTest() {
        //todo create immutable list
        ArrayList<Integer> intList = new ArrayList<>();

        intList.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
        intList.add(7);

        long count = intList.stream().count();
        assertEquals(7, count);

        int sum = intList.stream().mapToInt(Integer::intValue).sum();
        assertEquals(28, sum);

        double doubles[] = new double[]{1, 2, 3, 4};
        Arrays.stream(doubles).sum();
    }

    @Test
    public void collectors() {
        List<Employee> employees = getEmployees();
        int maxAge = employees.stream().mapToInt(Employee::getAge).max().getAsInt();
        assertEquals(40, maxAge);

        double minSalary = employees.stream()
                .sorted(this::compare).findFirst().get().getSalary();
        assertEquals(300.2d, minSalary);

    }

    private int compare(Employee d1, Employee d2){
        int i = Double.compare(d1.getSalary(), d2.getSalary());
        return i;
    }


    private List<Employee> getEmployees() {
        Employee ash = new Employee("ash", 30, 400.0);
        Employee john = new Employee("john", 32, 300.2d);
        Employee alan = new Employee("alan", 40, 400.25);
        Employee marty = new Employee("marty", 25, 500.9d);

        return new ArrayList<>(Arrays.asList(ash, john, alan, marty));
    }
}
