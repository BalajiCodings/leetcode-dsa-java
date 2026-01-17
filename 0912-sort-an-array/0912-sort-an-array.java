class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if(left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        List<Integer> temp = new ArrayList<>();

        int low = left;
        int high = mid + 1;

        while(low <= mid && high <= right) {
            if(arr[low] <= arr[high]) {
                temp.add(arr[low++]);
            } else {
                temp.add(arr[high++]);
            }
        }

        while(low <= mid) {
            temp.add(arr[low++]);
        }

        while(high <= right) {
            temp.add(arr[high++]);
        }

        for(int i = left; i <= right; i++) {
            arr[i] = temp.get(i - left);
        }
    }
}