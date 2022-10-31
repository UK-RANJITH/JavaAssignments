package week1.day3;

import java.util.Arrays;

public class LearnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] score = { 100, 11, 9,9,9,9,23, 22, 33, 44, 43, 55, 1, 66, 77, 88, 99 };
		int length = score.length;
		System.out.println("total count   " + length);
		System.out.println("score of 0th value  " + score[0]);
		System.out.println("score of last value  " + score[length - 1]);

		// large to small
		Arrays.sort(score);
		for (int i = score.length - 1; i >= 0; i--) {
			System.out.println(score[i]);

		}
		System.out.println("desc");

		// small to large
		for (int i = 0; i <= score.length - 1; i++) {
			System.out.println(score[i]);

		}
		System.out.println("asc");

	}
}

