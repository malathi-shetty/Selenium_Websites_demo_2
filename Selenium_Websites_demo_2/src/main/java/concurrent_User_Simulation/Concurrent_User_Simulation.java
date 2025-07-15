package concurrent_User_Simulation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Concurrent_User_Simulation {

	public static final int Num_Users = 10;
	public static final String ENDPOINT_URL = "http://your-endpoint-url.com";

	public static void main(String[] args) {
		// Write a script that simulates 1000 concurrent users hitting an endpoint.

		// Create a thread pool
		ExecutorService executor = Executors.newFixedThreadPool(Num_Users);
		// executor.submit(new UserTask());

		for (int i = 0; i < Num_Users; i++) {
			executor.submit(new UserTask(ENDPOINT_URL));
		}

		// Shut down the executor service
		executor.shutdown();
		executor.shutdown();
		try {
			// Wait for all tasks to complete or timeout after 10 minutes
			if (!executor.awaitTermination(10, TimeUnit.MINUTES)) {
				System.out.println("Timed out waiting for tasks to finish.");
				// Optionally force shutdown remaining tasks
				executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			System.err.println("Interrupted while waiting for tasks to finish.");
			executor.shutdownNow();
			Thread.currentThread().interrupt(); // Restore interrupted status
		}

		System.out.println("Simulation completed.");
	}
}
/*
 * Executor (create and manage threads), Tasks (submit user tasks), Shutdown
 * (terminate the executor), Alert (notify completion).
 */