package com.vip.test.service.impl;

import com.vip.test.service.ThreadPoolTestService;
import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.concurrent.*;

/**
 * Created by jack on 16/11/5.
 */
@Log
@Service
public class ThreadPoolTestServiceImpl implements ThreadPoolTestService {

    @Override
    @Async
    public void testAsync() {
        log.info(Thread.currentThread().getName() + " Async Test");
    }

    @Override
    public void testNotShutdownThreadPoolInvoke() {
        ExecutorService exec = Executors.newCachedThreadPool();
        try {
            Future<String> future = exec.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    TimeUnit.SECONDS.sleep(10);
                    return Thread.currentThread().getName() + "11111";
                }
            });

            log.info("Future Test:" + future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void destroy(){
        log.info("test destroy()");
    }
}