package task37.task3702;

import task37.task3702.female.FemaleFactory;
import task37.task3702.male.MaleFactory;

public class FactoryProducer {

    public static AbstractFactory getFactory(HumanFactoryType type) {
        AbstractFactory factory = null;
        if (HumanFactoryType.MALE == type) factory = new MaleFactory();
        else if (HumanFactoryType.FEMALE == type) factory = new FemaleFactory();

        return factory;
    }

    public static enum HumanFactoryType {
        MALE,
        FEMALE
    }
}
