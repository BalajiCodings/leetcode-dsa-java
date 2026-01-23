class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        HashMap<Character, Integer> needM = new HashMap<>();
        for(char c: t.toCharArray()) {
            needM.put(c, needM.getOrDefault(c, 0) + 1);
        }

        int requiredChars = needM.size(); 

        HashMap<Character, Integer> windowM = new HashMap<>();
        int left = 0, right = 0;
        int start = 0;
        int minLen = Integer.MAX_VALUE;
        int formedChars = 0;

        while(right < s.length()) {
            char ch = s.charAt(right);

            //Expand window
            windowM.put(ch, windowM.getOrDefault(ch, 0) + 1);

            if(needM.containsKey(ch) &&
                needM.get(ch).intValue() == windowM.get(ch).intValue()) {
                    formedChars++;
            }

            while(left <= right && formedChars == requiredChars) {

                if(right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char remove = s.charAt(left);
                windowM.put(remove, windowM.get(remove) - 1);

                if(needM.containsKey(remove) &&
                    needM.get(remove) > windowM.get(remove)) {
                        formedChars--;
                }

                left++;
            }


            right++;
        }

        return minLen == Integer.MAX_VALUE? "" : s.substring(start, start + minLen);

    }
}