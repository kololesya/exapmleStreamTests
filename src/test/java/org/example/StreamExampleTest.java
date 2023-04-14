package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExampleTest {
    List<EmployeeTest> employeeTestList = new ArrayList<>();
    @BeforeEach
    public void setEmployeeTestList(){
        EmployeeTest employeeTest = new EmployeeTest("Mark", "Nowak", 16, List.of("Teamwork", "Reliability", "Active listening"));
        EmployeeTest employeeTest1 = new EmployeeTest("Jan", "Sokolow", 14, List.of("Collaboration", "Teamwork", "Respectfulness"));
        EmployeeTest employeeTest2 = new EmployeeTest("Monika", "Kopij", 35, List.of("Respectfulness", "Reliability", "Teamwork"));
        EmployeeTest employeeTest3 = new EmployeeTest("Igor", "Kowalski", 45, List.of("Teamwork", "Respectfulness", "Effective communication"));
        EmployeeTest employeeTest4 = new EmployeeTest("Sabina", "Sokolowa", 21, List.of("Reliability", "Teamwork", "Reliability"));
        EmployeeTest employeeTest5 = new EmployeeTest("Przemek", "Kopij", 38, List.of("Active listening", "Collaboration", "Teamwork"));

        employeeTestList.add(employeeTest);
        employeeTestList.add(employeeTest1);
        employeeTestList.add(employeeTest2);
        employeeTestList.add(employeeTest3);
        employeeTestList.add(employeeTest4);
        employeeTestList.add(employeeTest5);
    }

    @Test
    public void newWayStream(){
        List<String> names = List.of("Marek", "Kasia", "Michal", "Daniel");
//        List <String> nameM;
//        for (){
//            nameM += name;
//        }
        List<String> nameStartingWithM = names
                .stream()
                .filter(name -> name.toLowerCase().equals("marek"))
                .collect(Collectors.toList());
        System.out.println(nameStartingWithM);
    }

    @Test
    public void firstStream()  {
        employeeTestList.forEach(System.out::println);
    }

    @Test
    public void mapOperator(){
        employeeTestList.stream().map(EmployeeTest::getFirstName).forEach(System.out::println);
        List <String> newList = employeeTestList
                .stream()
                .map(element -> element.getFirstName() + " " + element.getLastName())
                .collect(Collectors.toList());
        employeeTestList
                .stream()
                .map(element -> element.getFirstName() + " " + element.getLastName())
                .forEach(System.out::println);
    }


    @Test
    public void flatMapOperator(){
        List<List<String>> allSkills = employeeTestList
                .stream().
                map(EmployeeTest::getSkills).
                collect(Collectors.toList());
        System.out.println(allSkills);

        List<String> allSkilsFloatMap = employeeTestList.stream().
                map(EmployeeTest::getSkills).
                flatMap(list -> list.stream()).
                distinct().
                collect(Collectors.toList());

        System.out.println(allSkilsFloatMap);
    }

    @Test
    public void sortedOperator(){
        employeeTestList.stream().
                sorted(Comparator.comparing(EmployeeTest::getFirstName)).
                forEach(System.out::println);
    }

    @Test
    public void limitOperator(){
        employeeTestList
                .stream()
                .sorted(Comparator.comparing(EmployeeTest::getFirstName))
                .limit(2)
                .forEach(System.out::println);
    }

    @Test
    public void skipOperator(){ //пропустить первіе два єлемента
        employeeTestList.stream().
                sorted(Comparator.comparing(EmployeeTest::getAge)).
                skip(2).
                forEach(System.out::println);
    }

    @Test
    public void countOperator(){
        long numberOfElements = employeeTestList
                .stream()
                .filter(employeeTest -> employeeTest.getFirstName().startsWith("M"))
                .count(); //for (int i =1; ...){
        //count += i; }
        System.out.println(numberOfElements);
    }

    @Test
    public void minOperator(){
        EmployeeTest youngest = employeeTestList.stream()
                .min(Comparator.comparing(EmployeeTest::getAge))
                .get();
        System.out.println(youngest);
    }

    @Test
    public void maxOperator(){
        EmployeeTest oldest = employeeTestList.stream()
                .max(Comparator.comparing(EmployeeTest::getAge))
                .get();
        System.out.println(oldest);
    }

    @Test
    public void findFirst(){
        EmployeeTest first = employeeTestList
                .stream()
                .filter(employeeTest -> employeeTest.getFirstName().startsWith("M"))
                .findFirst()
                .get();
        System.out.println(first);
    }

    @Test
    public void allMatchOperator(){
        boolean b = employeeTestList.stream()
                .allMatch(employeeTest -> employeeTest.getFirstName().startsWith("M"));
        System.out.println(b);
    }

    @Test
    public void anyMatchOperator(){
        boolean c = employeeTestList.stream()
                .anyMatch(employeeTest -> employeeTest.getFirstName().startsWith("M"));
        System.out.println(c);
    }

    @Test
    public void nonMatchOperator(){
        boolean a = employeeTestList.stream()
                .noneMatch(employeeTest -> employeeTest.getFirstName().startsWith("D"));
        System.out.println(a);
    }

    @Test
    public void reduceOperator(){
        long b = employeeTestList.stream()
                .map(EmployeeTest::getAge)
                .reduce(0, Integer :: sum);
        System.out.println(b);
    }

    @Test
    public void takeWhileOperator(){
        employeeTestList.stream()
                .sorted(Comparator.comparing(EmployeeTest::getFirstName))
                .takeWhile((employeeTest -> employeeTest.getAge() > 18))
                .forEach(System.out::println);
    }

    @Test
    public void dropWhileOperator(){ //прочитать!!!
        employeeTestList.stream()
                .sorted(Comparator.comparing(EmployeeTest::getAge))
                .dropWhile(employeeTest -> employeeTest.getAge() < 18)
                .forEach(System.out::println);
    }
}
