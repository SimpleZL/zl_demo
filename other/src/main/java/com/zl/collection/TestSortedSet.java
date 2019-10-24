package com.zl.collection;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-08-12
 */
public class TestSortedSet<K, V> {
    private K key;
    private V value;

    /**
     * 方法泛型
     *
     * @param name
     * @param <T>
     */
    public static <T, V> void sayHello(T name, V time) {
        System.out.println(name.toString().concat(time.toString()));
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        ArrayList<Future> futures = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Callable c = new CallbaleThread();
            Future future = pool.submit(c);
            futures.add(future);
        }
        pool.shutdown();
        for (Future future : futures) {
            System.out.println(future.get());
        }

    }

    public static class CallbaleThread implements Callable<String> {

        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public String call() throws Exception {
            Thread.sleep(3000);
            return "hello  call ";
        }
    }
}
