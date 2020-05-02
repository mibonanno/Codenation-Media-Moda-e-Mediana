package br.com.codenation;

import java.util.stream.IntStream;

import static java.util.Arrays.sort;

public class StatisticUtil {

	public static int average(int[] elements) {
		return (int) IntStream.of(elements)
				.average()
				.orElse(-1);
	}

	public static int mode(int[] elements) {
		int maxCount = 0;
		int mode = 0;
		for (int element : elements) {
			int count = 0;
			for (int comparingElement : elements) {
				if (element == comparingElement) {
					count++;
				}
			}
			if (count > maxCount) {
				maxCount = count;
				mode = element;
			}
		}
		return mode;
	}

	public static int median(int[] elements) {
		sort(elements);
		if (isEven(elements)) {
			return getCenterElement(elements);
		} else {
			return getAverageOfTwoCenterElements(elements);
		}
	}

	private static boolean isEven(int[] elements) {
		return elements.length % 2 == 1;
	}

	private static int getCenterElement(int[] elements) {
		return elements[elements.length / 2];
	}

	private static int getAverageOfTwoCenterElements(int[] elements) {
		return (elements[elements.length / 2] + elements[elements.length / 2 - 1]) / 2;
	}
}