public class Jump_Game_II {
    /*
    You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
    Each element nums[i] represents the maximum length of a forward jump from index i. In other words,
     if you are at nums[i], you can jump to any nums[i + j] where:
            0 <= j <= nums[i] and
    i + j < n
    Return the minimum number of jumps to reach nums[n - 1].
    The test cases are generated such that you can reach nums[n - 1].

    Example 1:
        Input: nums = [2,3,1,1,4]
        Output: 2
        Explanation: The minimum number of jumps to reach the last index is 2.
        Jump 1 step from index 0 to 1, then 3 steps to the last index.

    Example 2:
        Input: nums = [2,3,0,1,4]
        Output: 2

    Constraints:
            1 <= nums.length <= 104
            0 <= nums[i] <= 1000
    It's guaranteed that you can reach nums[n - 1].
            */

public static void main(String[] args) {
	Jump_Game_II test = new Jump_Game_II();
	int[] nums = {2,3,1,1,4};
	System.out.println(test.jump(nums));
}
    public int jump(int[] nums) {
        int jumps = 0;          // number of jumps made
        int currentEnd = 0;     // How far can I get with the jumps made
        int farthest = 0;       // The farthest point I can reach from the explored points

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]); // I update the farthest point possible.
            if (i == currentEnd) {                      // If I reach the end of the current jump
                jumps++;                                // I need to make another jump
                currentEnd = farthest;                  // I update the current end point
            }
        }
        return jumps;
    }

}
