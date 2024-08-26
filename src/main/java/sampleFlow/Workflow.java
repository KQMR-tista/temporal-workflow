package sampleFlow;

import io.temporal.activity.ActivityOptions;
import io.temporal.workflow.Async;
import io.temporal.workflow.Promise;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Workflow implements WorkflowImplementation {

    private final Activity activity =
            io.temporal.workflow.Workflow.newActivityStub(Activity.class,
                    ActivityOptions.newBuilder().setStartToCloseTimeout(Duration.ofSeconds(20)).build());

    @Override
    public void initiateExampleWorkflowMethod() {
        List<Promise<String>> promiseList = new ArrayList<>();

        /* Sequential */
        String activityOne = Async.function(activity::performActivityOne).get();
        io.temporal.workflow.Workflow.sleep(Duration.ofSeconds(30));
        String activityTwo = Async.function(activity::performActivityTwo).get();
        io.temporal.workflow.Workflow.sleep(Duration.ofSeconds(30));

        /* Parallel */
        promiseList.add(Async.function(activity::performActivityThree));
        promiseList.add(Async.function(activity::performActivityFour));
        io.temporal.workflow.Workflow.sleep(Duration.ofSeconds(30));

        List<String> parallelActivitylist = promiseList.stream().map(Promise::get).toList();

        /* Sequential */
        String activityFive = Async.function(activity::performActivityFive).get();
        io.temporal.workflow.Workflow.sleep(Duration.ofSeconds(30));
    }
}
