package com.mjc813.p633;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableSubmitExample2 {
    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        Long ms = System.currentTimeMillis();
        ISumLoop is = num -> {
            System.out.println(num);
        };
        for (int i = 1; i <= 100000; i++) {
            final int idx = i;
            executorService.execute(() -> {
                Long sum = 0L;
                for (int j = 1; j <= idx; j++) {
                    sum += j;
                }
                //is.print(sum);
            });
        }
        executorService.shutdown();
        ms = System.currentTimeMillis() - ms;
        System.out.printf("totalMills = %d\n", ms);
    }
}

//- p633 의 소스를 직접 개발해서 실행해보시고 나서 14줄을 i <= 100000; 까지로 바꿔서 실행해보면
//	main 스레드는 점점 속도가 느려질 겁니다. Future<Long>, Callable<Long>, Long sum, Long result
//- main 스레드는 30번 줄에서 다른 스레드가 계산을 끝날때까지 기다리기 때문입니다.
//- public interface ISumLoop {
//		public void print(Long num);
//	}
//	ISumLoop 인터페이스 print 메소드를 구현하여 main 스레드가 좀더 빨리 실행 되도록 개선해 보세요
//	즉 main 스레드는 다른 스레드 계산이 끝날때까지 기다리지 않고 계속 실행되도록 해 보세요.