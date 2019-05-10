package com.xdclass.atomic;


import java.util.concurrent.atomic.AtomicIntegerArray;

/*
*   AtomicIntegerArrayDemo
* */
public class AtomicIntegerArrayDemo {

    public static void main(String[] args) {
        int[] arr = new int[]{3,2};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);

        //  给下标为1的元素加2
        System.out.println(atomicIntegerArray.addAndGet(0, 7));


        int result = atomicIntegerArray.accumulateAndGet(0, 11, (left, right) ->
                left > right ? left : right
        );
        System.out.println(result);

    }

}
