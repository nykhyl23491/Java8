package com.app.emp;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 20, 30, 11, 20, 33, 4, 44, 55, 20);

		// collect the result of a Stream into Set
		System.out.println("Case 1 ::");
		Set<Integer> set = new HashSet<Integer>();
		set = numbers.stream().collect(Collectors.toSet());
		set.forEach(System.out::println);

		// collect the result of a Stream into list
		System.out.println("Case 2 ::");
		List<Integer> list = numbers.stream().collect(Collectors.toList());
		list.forEach(System.out::println);

		// create Map from the elements of Stream (first remove the duplicates)
		System.out.println("Case 3 ::");
		Map<Object, Object> map = new HashMap();
		map = numbers.stream().distinct().collect(Collectors.toMap(num -> num, num -> num));
		map.forEach((k, v) -> System.out.println(k + " " + v));

		// find summary statistics from a Stream of numbers
		System.out.println("Case 4 ::");
		IntSummaryStatistics statistics = numbers.stream().collect(Collectors.summarizingInt(num -> num));
		System.out.println(statistics);

		// partition the result of Stream in two parts i.e., odd and even
		System.out.println("Case 5 ::");
		Map<Boolean, List<Integer>> result = numbers.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
		result.forEach((k, v) -> System.out.println(k + " " + v));

		// create comma separated string from numbers
		System.out.println("Case 6 ::");
		String str = numbers.stream().map(num -> num.toString()).collect(Collectors.joining(","));
		System.out.println(str);

	}
}
