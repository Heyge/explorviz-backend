package net.explorviz.repository.helper;

import java.sql.Timestamp;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Helper class providing methods for creating a dummy landscape
 *
 * @author Christian Zirkelbach (czi@informatik.uni-kiel.de)
 *
 */
public class DummyLandscapeHelper {
	/**
	 * Returns the current timestamp for dummy queries
	 *
	 * @return current timestamp
	 */
	public static long getCurrentTimestamp() {
		final Timestamp timestamp = new Timestamp(System.nanoTime());
		return timestamp.getTime();
	}

	/**
	 * Returns a random number between minValue and maxValue
	 *
	 * @param minValue
	 *            (minimum random value)
	 * @param maxValue
	 *            (maximum random value)
	 * @return random number
	 */
	public static int getRandomNum(final int minValue, final int maxValue) {
		if (minValue > 0 && maxValue > 0)
			return ThreadLocalRandom.current().nextInt(minValue, maxValue + 1);
		else
			return 0;
	}

	/**
	 * Returns a unique next sequence number
	 *
	 * @return next unique number
	 */
	public static int getNextSequenceId() {
		final AtomicInteger seqId = new AtomicInteger();
		return seqId.getAndIncrement();
	}

}
