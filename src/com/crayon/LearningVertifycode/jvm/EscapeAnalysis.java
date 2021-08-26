package com.crayon.LearningVertifycode.jvm;

public class EscapeAnalysis {

    private static final int COUNT = 100000000;

    public static void main(String[] args) throws InterruptedException {
        long l = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            allocate();
        }
        long l2 = System.currentTimeMillis();

        System.out.println(l2 - l);
//        User user = new User();
//        synchronized (user) {
            while (true) {
//                user.wait();
            }
//        }
    }

    private static void allocate() {
        User user = new User();
    }

}
