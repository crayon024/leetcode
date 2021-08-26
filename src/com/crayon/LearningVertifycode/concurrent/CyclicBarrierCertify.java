package com.crayon.LearningVertifycode.concurrent;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.StampedLock;

/**
 *  CyclicBarrier(count, runnable), 循环屏障。线程到达时，会被屏障挡住。
 *  等到线程到达规定的数量 count 后，放行，且 CyclicBarrier 会自动重置 count，意味着可以重复利用
 *  必须调用 count 次 await 才会通过，否则一直等待
 *  通过后，会先执行传入 runnable 的 run() 逻辑
 */
public class CyclicBarrierCertify implements Runnable{

    private static final Integer Count = 4;

    private CyclicBarrier cyclicBarrier = new CyclicBarrier(4, this);

    Lock lock = new ReentrantLock();
    StampedLock stampedLock = new StampedLock();

    private ConcurrentHashMap<String, Integer> bankwaterSheet = new ConcurrentHashMap<>(4);

    private Executor executor = Executors.newFixedThreadPool(4);

    private void count() {
        for (int i = 0; i < Count; i++) {
            executor.execute(() -> {
                bankwaterSheet.put(Thread.currentThread().getName(), 1);
                try {
                    cyclicBarrier.await(1, TimeUnit.MILLISECONDS);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void main(String[] args) {
        CyclicBarrierCertify cyclicBarrierCertify = new CyclicBarrierCertify();
        cyclicBarrierCertify.count();

    }

    @Override
    public void run() {
        int result = 0;
        Set<Map.Entry<String, Integer>> entries = bankwaterSheet.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            result+= entry.getValue();
        }

        bankwaterSheet.put("result", result);
        System.out.println(result);
    }
}
