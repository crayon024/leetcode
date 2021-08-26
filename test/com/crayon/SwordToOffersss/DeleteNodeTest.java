package com.crayon.SwordToOffersss;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeleteNodeTest {

    @ParameterizedTest
    @MethodSource
    void testDeleteNode(int i) {

    }

    static List<Arguments> testDeleteNode() {
        List<Arguments> objects = new ArrayList<>();
        objects.add(Arguments.arguments(new int[]{3,4,5,1,2}, 1));
        objects.add(Arguments.arguments(new int[]{}, -1));
        objects.add(Arguments.arguments(new int[]{2}, 2));
        objects.add(Arguments.arguments(new int[]{2,1}, 1));
        objects.add(Arguments.arguments(new int[]{2,2,2,0,1}, 0));
        return objects;
    }
}