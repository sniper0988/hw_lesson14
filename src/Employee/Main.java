package Employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //объект класса BufferedReader для дальнейшего считывания с данных с консоли
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите число работников");
        int num = Integer.parseInt(reader.readLine());

        //лист с работниками
        List<Employee> employees = Employee.employeeGenerator(num);
        System.out.println("---Работники---");
        System.out.println(employees.toString());
        // 1. сортировка по имени
        // сначала создал компаратор, который сортирует по имени
        System.out.println("---Работники остортированные по имени---");
        Comparator<Employee> employeeComparator1 = new EmployeeNameComparator();
        //создал TreeSet в который будут добавлятся работники
        TreeSet<Employee> treeSet1 = new TreeSet<>(employeeComparator1);
        //заполнение treeSet1
        for(Employee employee: employees){
            treeSet1.add(employee);
        }
        //вывел TreeSet с работниками
        System.out.println(treeSet1);

        System.out.println("---Работники остортированные по имени и зп---");
        // 2. сортировка по имени и зп
        // сначала создал компаратор, который сортирует сначала по имени, затем по зп
        Comparator<Employee> employeeComparator2 = new EmployeeNameComparator()
                .thenComparing(new EmployeeSalaryComparator());

        //создал TreeSet в который будут добавлятся работники
        TreeSet<Employee> treeSet2 = new TreeSet<>(employeeComparator2);
        // заполнил TreeSet работниками
        for(Employee employee: employees){
            treeSet2.add(employee);
        }
        //вывел TreeSet с работниками
        System.out.println(treeSet2);

        System.out.println("---Работники остортированные по имени, зарплате, возрасту и компании---");
        // 2. сортировка по имени и зп
        // сначала создал компаратор
        Comparator<Employee> employeeComparator3 = new EmployeeNameComparator()
                .thenComparing(new EmployeeSalaryComparator()).thenComparing(new EmployeeAgeComparator()).thenComparing(new EmployeeCompanyComparator());

        //создал TreeSet в который будут добавлятся работники
        TreeSet<Employee> treeSet3 = new TreeSet<>(employeeComparator3);
        // заполнил TreeSet работниками
        for(Employee employee: employees){
            treeSet3.add(employee);
        }
        //вывел TreeSet с работниками
        System.out.println(treeSet3);
    }
}
