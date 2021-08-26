package com.crayon.LearningVertifycode.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Crayon
 */
public class ThreadPool {

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.submit()
//        scheduledExecutorService.schedule()
    }

}
