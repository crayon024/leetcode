package com.crayon.sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OnSort2TimeTest {
    @ParameterizedTest
    @MethodSource
    void testInsertSort(int[] input, int[] result) {
        assertArrayEquals(result, OnSort2Time.selectSort(input));
    }

    static List<Arguments> testInsertSort() {
        List<Arguments> objects = new ArrayList<>();
        objects.add(Arguments.arguments(new int[]{2,5,1,6,7,3}, new int[]{7,6,5,3,2,1}));
        objects.add(Arguments.arguments(new int[]{1}, new int[]{1}));
        objects.add(Arguments.arguments(new int[]{2,1}, new int[]{2,1}));
        objects.add(Arguments.arguments(new int[]{1,2}, new int[]{2,1}));
        objects.add(Arguments.arguments(new int[]{3,1,9,10,3,6,8,55,2,34,6} , new int[]{55,34,10,9,8,6,6,3,3,2,1}));
        return objects;
    }
}