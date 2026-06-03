class Solution {

    public String encode(List<String> strs) {
        // take strings and encode
        // hello, rajdeep, 3$3
        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            int len = str.length();
            sb.append(len).append("$").append(str);
        }
        //5$hello7$rajdeep3$3$3
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int fromIndex = 0;
         while(fromIndex < str.length()) {
            int preWordDelimiterPos = str.indexOf("$", fromIndex);
            int len = Integer.parseInt(str.substring(fromIndex, preWordDelimiterPos));
            // prePos + 1 gives start of string, len + 1 gives end (exclusive) of that string
            int start = preWordDelimiterPos + 1;
            int end = start + len - 1; // hello, 0 + 5 makes it already 0-4th index, with 5th index becoming exclusive
            result.add(str.substring(start, end + 1));
            fromIndex = end + 1;
        }
        return result;
    }
}
