package hk.mc4u.junit5seleniumtest;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppTest2 {

	@BeforeEach
	public void init() {
	}

	@Test
	public void test01() {

		log.info("Test01 started");
		ExecutorService executors = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 100; i++) {
			log.info("Added:" + i);
			executors.execute(new Task());
		}
		log.info("Test01 ended");
	}

	class Task implements Runnable {

		@Override
		public void run(){
			String threadName = Thread.currentThread().getName();
			int millis = (new Random()).nextInt(1000);
			log.info("exec current thread: " + threadName + ":" + millis);
			for(int i=0; i<millis; i++) {
				//do nothing
			}
		}

	}
}
