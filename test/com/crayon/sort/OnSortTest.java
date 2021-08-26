package com.crayon.sort;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

/*
 https://junit.org/junit5/
 */

class OnSortTest {

    @ParameterizedTest
    @MethodSource
    void testBubbleSort(int[] input, int[] result) {
        assertArrayEquals(result, OnSort.bubbleSort(input));
    }

    static List<Arguments> testBubbleSort() {
        List<Arguments> objects = new ArrayList<>();
        objects.add(Arguments.arguments(new int[]{2,5,1,6,7,3}, new int[]{1,2,3,5,6,7}));
        objects.add(Arguments.arguments(new int[]{1}, new int[]{1}));
        objects.add(Arguments.arguments(new int[]{2,1}, new int[]{1,2}));
        objects.add(Arguments.arguments(new int[]{1,2}, new int[]{1,2}));
        objects.add(Arguments.arguments(null , null));
        objects.add(Arguments.arguments(new int[]{} , null));
        return objects;
    }

    @Test
    void insertSort() {
    }

    @Test
    void selectSort() {
    }
}