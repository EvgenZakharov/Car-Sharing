import java.util.Scanner;

class SelectionContext {

    private PersonSelectionAlgorithm algorithm;

    public void setAlgorithm(PersonSelectionAlgorithm algorithm) {
        // write your code here
        this.algorithm = algorithm;
    }

    public Person[] selectPersons(Person[] persons) {
        // write your code here
        return algorithm.select(persons);
    }
}

interface PersonSelectionAlgorithm {

    Person[] select(Person[] persons);
}

class TakePersonsWithStepAlgorithm implements PersonSelectionAlgorithm {

    private final int step;

    public TakePersonsWithStepAlgorithm(int step) {
        // write your code here
        this.step = step;
    }

    @Override
    public Person[] select(Person[] persons) {
        // write your code here
        int size = (persons.length + step - 1) / step; // Рассчитываем размер итогового массива
        Person[] result = new Person[size];
        int index = 0;

        for (int i = 0; i < persons.length; i += step) {
            result[index++] = persons[i];
        }

        return result;
    }
}


class TakeLastPersonsAlgorithm implements PersonSelectionAlgorithm {

    private final int count;

    public TakeLastPersonsAlgorithm(int count) {
        // write your code here
        this.count = count;
    }

    @Override
    public Person[] select(Person[] persons) {
        // write your code here
        if (count > persons.length) {
            return persons; // Если count больше длины массива, возвращаем всех
        }

        Person[] result = new Person[count];
        System.arraycopy(persons, persons.length - count, result, 0, count);

        return result;
    }
}

class Person {

    String name;

    public Person(String name) {
        this.name = name;
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int count = Integer.parseInt(scanner.nextLine()); //длина массива persons
        final Person[] persons = new Person[count]; //пустой массив persons

        for (int i = 0; i < count; i++) {
            persons[i] = new Person(scanner.nextLine()); //заполнили массив persons
        }

        final String[] configs = scanner.nextLine().split("\\s+"); //массив из algType, param

        final PersonSelectionAlgorithm alg = create(configs[0], Integer.parseInt(configs[1])); //выбор алгоритма
        SelectionContext ctx = new SelectionContext();
        ctx.setAlgorithm(alg); //установка алгоритма

        final Person[] selected = ctx.selectPersons(persons); //массив selected
        for (Person p : selected) {
            System.out.println(p.name);
        }
    }

    public static PersonSelectionAlgorithm create(String algType, int param) {
        switch (algType) {
            case "STEP": {
                return new TakePersonsWithStepAlgorithm(param);
            }
            case "LAST": {
                return new TakeLastPersonsAlgorithm(param);
            }
            default: {
                throw new IllegalArgumentException("Unknown algorithm type " + algType);
            }
        }
    }
}