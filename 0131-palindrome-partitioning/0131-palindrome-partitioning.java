class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> result = new ArrayList<>();
        boolean[][] dp = new boolean[n][n];

        for(int end = 0; end < n; end++) {
            for(int start = 0; start <= end; start++) {
                if(s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                    dp[start][end] = true;
                }
            }
        }

        backtrack(s, 0, new ArrayList<>(), result, dp);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> result, boolean[][] dp) {

        if(start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int end = start; end < s.length(); end++) {
            if(dp[start][end]) {
                path.add(s.substring(start, end + 1));
                backtrack(s, end + 1, path, result, dp);
                path.remove(path.size() - 1);
            }
        }
    }
}