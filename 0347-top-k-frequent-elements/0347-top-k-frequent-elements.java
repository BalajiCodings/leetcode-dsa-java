class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for(int num : freq.keySet()) {
            int f = freq.get(num);
            if(bucket[f] == null) {
                bucket[f] = new ArrayList<>();
            }
            bucket[f].add(num);
        }

        int[] result = new int[k];
        int ind = 0;

        for(int i = bucket.length - 1; i >= 0 && ind < k; i--) {
            if(bucket[i] != null) {
                for(int num : bucket[i]) {
                    result[ind++] = num;
                    if(ind == k) break;
                }
            }
        }

        return result;
    }
}