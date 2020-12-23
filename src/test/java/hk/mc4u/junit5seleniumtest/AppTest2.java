package hk.mc4u.junit5seleniumtest;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AppTest2 {
	ExecutorService executors;

	@BeforeEach
	public void init() {
		executors = Executors.newFixedThreadPool(10);
	}

	@Test
	public void test01() {

		log.info("Test01 started");
		for (int i = 0; i < 100; i++) {
			executors.execute(new Task());
		}

		log.info("Test01 ended");
	}

	@AfterEach
	public void cleanup() throws InterruptedException {
		Thread.sleep(10000);
	}

	class Task implements Runnable {

		@Override
		public void run() {
			String threadName = Thread.currentThread().getName();
			int millis = (new Random()).nextInt(1000);
			log.info("exec current thread: " + threadName + ":" + millis);
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
