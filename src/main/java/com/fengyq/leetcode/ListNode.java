package com.fengyq.leetcode;

import java.nio.ByteBuffer;
import java.util.concurrent.*;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       /* ExecutorService executorService= Executors.newCachedThreadPool();
        Future future=executorService.submit(new Callable() {
            @Override
            public String call() throws InterruptedException {
                System.out.println("Task begin!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    throw e;
                }
                System.out.println("Task end!");
                return "Done";
            }
        });
        Thread.sleep(100);
        future.cancel(false);
        System.out.println(future.get());
        executorService.shutdown();*/
        ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
        byte[] value="a".getBytes();
        //byteBuffer.putInt(value.length);
        byteBuffer.put(value);
        byteBuffer.flip();
        System.out.println(byteBuffer.remaining());
        byte[] res=new byte[byteBuffer.remaining()];
        byteBuffer.get(res);
    }
}
