package leetcode34;

public class FindIndexOfFirstLastPositionElementFunction {
	
	// O(logn) solution cause its like binary search
	// Required input to be sorted, doesn't matter if there is duplicates
	  public int[] searchRange(int[] nums, int target) {
	        // The starting index of the target
	        int start = findStartOfTarget(nums, target);
	        
	        // If not found, return {-1,-1}
	        if(start == nums.length || nums[start] != target){
	            int[] notFound = {-1,-1};
	            return notFound;
	        }
	        
	        // + 1 to the target to get the starting element of next element of end index
	        // - 1 will get the previous index which is the end point of the target
	        // Doesn't matter if the ending index is the same as starting index
	        int end = findStartOfTarget(nums, target + 1) - 1;
	        
	        int[] solution = {start, end};
	        
	        return solution;
	    }
	    
	  	// This function take O(logn) since its just binary search
	    private static int findStartOfTarget(int[] nums, int target){
	        int lowerBound = 0;
	        
	        // nums.length instead of nums.length - 1 because for the end index, we increase the target by 1, which will get to out of bound and - 1 will do the trick
	        int upperBound = nums.length;
	        
	        while(lowerBound < upperBound){
	        	// Could use upperbound + lowerbound /2, but this way will prevent negative
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
	    
	    // o(n) solution but pretty clever 
	    public int[] searchRange1(int[] nums, int target) {
	        int[] solution = {-1,-1};
	        
	        // O(n)
	        for(int i = 0; i < nums.length; i++){
	        	// Get the first index
	            if(nums[i] == target && solution[0] == -1){
	                solution[0] = i;
	            }
	            
	            // Get the last index
	            if(nums[i] == target && solution[0] != -1){
	                solution[1] = i;
	            }
	        }
	        
	        return solution;
	    }
}
