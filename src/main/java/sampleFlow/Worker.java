package sampleFlow;

import io.temporal.client.WorkflowClient;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.worker.WorkerFactory;

public class Worker {

    private static String TASK_QUEUE = "EXAMPLE_TASK_QUEUE";

    public static void main(String[] args) {
        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);
        WorkerFactory factory = WorkerFactory.newInstance(client);
        io.temporal.worker.Worker worker = factory.newWorker(TASK_QUEUE);

        worker.registerWorkflowImplementationTypes(Workflow.class);
        worker.registerActivitiesImplementations(new ActivityImplementation());
        factory.start();
    }
}
