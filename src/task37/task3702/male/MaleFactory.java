package task37.task3702.male;

import task37.task3702.AbstractFactory;
import task37.task3702.Human;

public class MaleFactory implements AbstractFactory {

    public Human getPerson(int age) {
        if (age < 0) try {
            throw new Exception();
        } catch (Exception e) {
            System.out.println("Вы указали не корректный возраст");
        }
        Human human = new Man();

        if (age <= KidBoy.MAX_AGE)  human = new KidBoy();

        else if (age <= TeenBoy.MAX_AGE) human = new TeenBoy();

        return human;
    }
}
