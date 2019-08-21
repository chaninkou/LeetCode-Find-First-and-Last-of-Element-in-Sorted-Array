package binaryTreeCustom;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		
		int target = 8;
		
		System.out.println("Nums: " + Arrays.toString(nums));
		System.out.println("Target: " + target);
		
		FindIndexOfFirstLastPositionElementFunction solution = new FindIndexOfFirstLastPositionElementFunction();
		
		System.out.println("Solution: " + Arrays.toString(solution.searchRange(nums, target)));
		
	}
}
