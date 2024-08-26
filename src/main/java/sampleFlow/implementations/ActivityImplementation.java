package sampleFlow.implementations;

import sampleFlow.interfaces.Activity;

public class ActivityImplementation implements Activity {
    @Override
    public String performActivityOne() {
        return "Performing activity one";
    }

    @Override
    public String performActivityTwo() {
        return "Performing activity two";
    }

    @Override
    public String performActivityThree() {
        return "Performing activity three";
    }

    @Override
    public String performActivityFour() {
        return "Performing activity four";
    }

    @Override
    public String performActivityFive() {
        return "Performing activity five";
    }
}
