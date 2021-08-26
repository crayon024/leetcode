package com.crayon.linkedlist;

import com.crayon.ListNode;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author Crayon
 */
public class ListNodeUtil {

    public static ListNode createListNodeTrain() {
        ListNode list = new ListNode(3);
        int[] ints = IntStream.generate(() -> {
                    Random random = new Random();
                    return random.nextInt(15);
                })
                .limit(7)
                .toArray();
        
        ListNode head = list;
        for (int i : ints) {
            list.next = new ListNode(i);
            System.out.println(list.toString());
            list = list.next;
        }
        return head;
    }
}
