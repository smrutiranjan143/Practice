package com.practice.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class PracticeLogging {
	private final Logger logger;

	private PracticeLogging(Class<?> clazz) {
		logger = LoggerFactory.getLogger(clazz);
	}

	public static PracticeLogging getLogger(Class<?> clazz) {
		return new PracticeLogging(clazz);
	}

	public void debug(String message) {
		logger.debug(message);
	}

	public void debug(String message, Object... args) {
		logger.debug(message, args);
	}

	public void info(String message) {
		logger.info(message);
	}

	public void info(String message, Object... args) {
		logger.info(message, args);
	}

	public void warn(String message) {
		logger.warn(message);
	}

	public void warn(String message, Object... args) {
		logger.warn(message, args);
	}

	public void warn(String message, Throwable error, Object... args) {
		logger.warn(message, error, args);
	}

	public void error(String message, Throwable error) {
		logger.error(message, error);
	}

	public void error(String message, Throwable error, Object... args) {
		logger.error(message, error, args);
	}

}