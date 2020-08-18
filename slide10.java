/*Question:
Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length. Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Input: nums = [1,1,1,2,2,3]

Output :  5

Explanation:  As a number in the nums array can appear twice thus we have to remove only one ‘1’ from the above array and print the length of the array.
*/

class RemoveDuplicatesSortedArrayII {
  private static int removeDuplicates(int[] nums) {
    int n = nums.length;
    int j = 0;

    for (int i = 0; i < n; i++) {
      if (i < n - 2 && nums[i] == nums[i + 2]) {
        continue;
      }

      nums[j++] = nums[i];
    }

    return j;
  }

  public static void main(String[] args) {
    int[] nums = new int[] { 1, 1, 1, 3, 5, 5, 7 };
    int newLength = removeDuplicates(nums);

    System.out.println("Length of array after removing duplicates = " + newLength);

    System.out.print("Array = ");
    for (int i = 0; i < newLength; i++) {
      System.out.print(nums[i] + " ");
    }
    System.out.println();
  }
}