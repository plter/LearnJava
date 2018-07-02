package top.yunp;

import java.util.concurrent.ExecutorService;

public class Task {
    private final ExecutorService executorService;

    public Task(ExecutorService executorService, String taskName) {
        this.executorService = executorService;

        executorService.submit(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(100);
                    System.out.println("Run " + taskName + " " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        });
    }
}
