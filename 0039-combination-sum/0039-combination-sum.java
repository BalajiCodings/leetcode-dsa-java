class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int target, int start, List<Integer> path, List<List<Integer>> result) {

        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if(target < 0) return;

        for(int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, target - nums[i], i, path, result);
            path.remove(path.size() - 1);
        }
    }
}