package sampleFlow;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface WorkflowImplementation {

    @WorkflowMethod
    public void initiateExampleWorkflowMethod();

}
