package com.crayon.LearningVertifycode.concurrent;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用管程 搭建一个同时只允许一个线程进行出入队操作的队列
 */
public class MonitorAndConditionImplBlockQueue {

    // 以队列中存在 8 个元素为 队列已满的条件
    private Queue<String> queue = new ArrayDeque<>(16);
    private Lock lock = new ReentrantLock();

    private Condition isFull = lock.newCondition();
    private Condition isEmpty = lock.newCondition();

    public void enqueue(String ele) {
        try {
            lock.lock();
            while (queue.size() >= 8) {
                isFull.await();
            }
            queue.offer(ele);
            // 入队新元素，通知空队列的等待线程
            isEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public String dequeue() {
        String poll = null;
        try {
            lock.lock();
            while (queue.isEmpty()) {
                isEmpty.await();
            }
            poll = queue.poll();
            // 出队了一个元素，通知已满的等待线程
            isFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return poll;
    }

}
