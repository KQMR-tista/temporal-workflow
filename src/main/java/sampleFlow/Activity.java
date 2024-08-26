package sampleFlow;

import io.temporal.activity.ActivityInterface;

@ActivityInterface
public interface Activity {

    public String performActivityOne();

    public String performActivityTwo();

    public String performActivityThree();

    public String performActivityFour();

    public String performActivityFive();
}
