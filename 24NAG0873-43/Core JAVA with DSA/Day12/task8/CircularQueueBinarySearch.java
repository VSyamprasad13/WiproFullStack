package day12.task8;

public class CircularQueueBinarySearch {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[left]) { // Rotation point is to the right
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Search left half
                } else {
                    left = mid + 1; // Search right half
                }
            } else { // Rotation point is to the left
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // Search right half
                } else {
                    right = mid - 1; // Search left half
                }
            }
        }
        
        return -1; // Element not found
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        
        int index = search(nums, target);
        
        if (index != -1) {
            System.out.println("Element " + target + " found at index " + index);
        } else {
            System.out.println("Element " + target + " not found");
        }
    }
}
