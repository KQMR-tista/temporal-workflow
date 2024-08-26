package sampleFlow;

import io.temporal.api.common.v1.WorkflowExecution;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;

public class InitiateWorkFlow {
    private static String TASK_QUEUE = "EXAMPLE_TASK_QUEUE";

    public static void main(String[] args) {

        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);

        WorkflowOptions options = WorkflowOptions.newBuilder()
                .setTaskQueue(TASK_QUEUE)
                .build();

        WorkflowImplementation workflow = client.newWorkflowStub(WorkflowImplementation.class, options);

        WorkflowExecution we = WorkflowClient.start(workflow::initiateExampleWorkflowMethod);

    }
}
