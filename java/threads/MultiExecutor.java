/*
 * Copyright 2019, FMR LLC.
 * All Rights Reserved
 * Fidelity Confidential Information
 */

import java.util.List;
import java.util.ArrayList;

public class MultiExecutor {

    // Add any necessary member variables here
    private List<Runnable> tasks = new ArrayList<>();

    /*
     * @param tasks to executed concurrently
     */
    public MultiExecutor(List<Runnable> tasks) {
        this.tasks = tasks;
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        List<Thread> threads = new ArrayList<>(tasks.size());

        for (Runnable task: tasks) {
            Thread thread = new Thread(task);
            threads.add(thread);
        }

        for (Thread thread: threads) {
            thread.start();
        }
    }
}