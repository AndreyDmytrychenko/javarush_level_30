package task37.task3702.female;

import task37.task3702.AbstractFactory;
import task37.task3702.Human;

public class FemaleFactory implements AbstractFactory {
    public Human getPerson(int age) {
        if (age < 0) try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Вы указали не корректный возраст");
        }
        Human human = new Woman();

        if (age <= KidGirl.MAX_AGE)  human = new KidGirl();

        else if (age <= TeenGirl.MAX_AGE) human = new TeenGirl();

        return human;
    }
}

