package binaryTreeCustom;

public class FindIndexOfFirstLastPositionElementFunction {
	  public int[] searchRange(int[] nums, int target) {
	        // The starting index of the target
	        int start = findStartOfTarget(nums, target);
	        
	        if(start == nums.length || nums[start] != target){
	            int[] notFound = {-1,-1};
	            return notFound;
	        }
	        
	        // Find the next index by + 1 since it will get the starting point, and then - 1 will get the previous index which is the end point of the target
	        int end = findStartOfTarget(nums, target + 1) - 1;
	        
	        int[] solution = {start, end};
	        
	        return solution;
	    }
	    
	    private static int findStartOfTarget(int[] nums, int target){
	        int lowerBound = 0;
	        int upperBound = nums.length;
	        
	        while(lowerBound < upperBound){
	            int mid = lowerBound + ((upperBound - lowerBound) / 2);
	            
	            // lowerBound <= mid < upperBound
	            if(target <= nums[mid]){
	                // Not mid - 1 when A[mid] == target
	                // Can be mid even if A[mid] > target because mid < upperBound
	                upperBound = mid;
	            } else if(target > nums[mid]) {
	                // getting the start of the target
	                lowerBound = mid + 1;
	            }
	            
	        }
	        
	        return lowerBound;
	    }
}
