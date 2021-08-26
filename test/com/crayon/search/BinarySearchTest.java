package com.crayon.search;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @ParameterizedTest
    @MethodSource
    void binarySearch(int[] input, int value, boolean result) {
        assertEquals(result, new BinarySearch().binarySearch(input, value));
    }

    static List<Arguments> binarySearch() {
        List<Arguments> objects = new ArrayList<>();
        objects.add(Arguments.arguments(new int[]{}, 3, false));
        objects.add(Arguments.arguments(new int[]{1}, 1, true));
        objects.add(Arguments.arguments(new int[]{1}, 2, false));
        objects.add(Arguments.arguments(new int[]{1,2}, 1, true));
        objects.add(Arguments.arguments(new int[]{1,2}, 2, true));
        objects.add(Arguments.arguments(new int[]{1,2}, 3, false));
        objects.add(Arguments.arguments(new int[]{1,2,3}, 4, false));
        objects.add(Arguments.arguments(new int[]{1,2,3}, 2, true));
        objects.add(Arguments.arguments(new int[]{1,2,3,4}, 4, true));
        objects.add(Arguments.arguments(new int[]{1,2,3,4}, 5, false));
        return objects;
    }
}