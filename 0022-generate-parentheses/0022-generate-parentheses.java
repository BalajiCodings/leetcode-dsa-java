class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(n, sb, 0, 0, result);
        return result;
    }

    private void backtrack(int n, StringBuilder sb, int open, int close, List<String> result) {

        if(sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        if(open < n) {
            sb.append('(');
            backtrack(n, sb, open + 1, close, result);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(close < open) {
            sb.append(')');
            backtrack(n, sb, open, close + 1, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}