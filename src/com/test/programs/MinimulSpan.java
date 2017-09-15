package com.test.programs;

public class MinimulSpan {

	public static void main(String[] args) {
		int a[]= new int[]{1234,4571};
		int m[]= new int[]{4321,1291};
		System.out.println(minimumMoves(a,m));
	}

	public static int minimumMoves(int a[], int m[]) {
		int moves = 0;

		int sizeA = a.length;
		int sizeM = m.length;
		if (sizeA != sizeM) {
			return 0;
		}

		for (int i = 0; i < sizeA; i++) {
			String s1 = a[i] + "";
			String s2 = m[i] + "";

			char[] ch1 = s1.toCharArray();
			char[] ch2 = s2.toCharArray();

			for (int j = 0; j < ch1.length; j++) {
				int val1 = (int) ch1[j];
				int val2 = (int) ch2[j];

				if (val1 > val2) {
					moves = moves + (val1 - val2);
				} else {
					moves = moves + (val2 - val1);
				}

			}

		}
		return moves;
	}

}
