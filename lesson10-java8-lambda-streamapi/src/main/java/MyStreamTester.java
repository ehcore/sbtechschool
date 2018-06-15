import streamsapi.MyStream;
import java.util.*;


public class MyStreamTester {
    public static void main(String[] args) {
        List<String> list = MyStream.of(Arrays.asList("aaa","bbb","ccc"))
                .transform(a->a+"ddsd")
                .filter(a->"cccddsd".equals(a))

                .collect();
        //System.out.println(list);

        List<Person> people = new ArrayList<>();
        people.add(new Person("Bob",44));
        people.add(new Person("Mike",29));
        people.add(new Person("Katie",35));
        people.add(new Person("Jane",28));
        people.add(new Person("Bill",49));
        people.add(new Person("Zara",32));

        List<Person> personList = MyStream.of(people)
                .filter((Person p)->p.getAge()>=35)
                .transform((p)->new Person(((Person)p).getName(),
                                ((Person)p).getAge()-5))
                .filter((p)->((Person)p).getAge()>=35)
                .collect();

        //System.out.println(personList);

        Map personMap = MyStream.of(people)
                .filter((Person p)->p.getAge()>=35)
                .toMap(p->((Person)p).getName(),p->p);
        System.out.println(personMap);
   }
}