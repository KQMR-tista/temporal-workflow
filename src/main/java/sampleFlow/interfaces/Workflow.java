package sampleFlow.interfaces;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface Workflow {

    @WorkflowMethod
    public void initiateExampleWorkflowMethod();

}
