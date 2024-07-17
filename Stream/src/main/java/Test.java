import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ClassName: Test
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author zbc
 * @Create 2024/7/17 下午2:11
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Sherry", 9000, 24, "female", "New York"));
        personList.add(new Person("Tom", 8900, 22, "male", "Washington"));
        personList.add(new Person("Jack", 9000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 8800, 26, "male", "New York"));
        personList.add(new Person("Alisa", 9000, 26, "female", "New York"));

        //薪资高于8000美元的员工
        List<String> list = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());
        System.out.println(list);

        Optional<Person> max = personList.stream().max((a, b) -> a.getSalary() - b.getSalary());
        System.out.println("薪资最高的员工" + max.get().getSalary());

        List<String> list1 = personList.stream().sorted((a, b) -> {
            if (a.getSalary() == b.getSalary()) {
                return b.getAge() - a.getAge();
            } else {
                return b.getSalary() - a.getSalary();
            }
        }).map(Person::getName).collect(Collectors.toList());
        System.out.println(list1);

    }
}
