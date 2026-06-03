class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return Collections.emptyList();
        if(strs.length==1) return List.of(List.of(strs[0]));
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            map.computeIfAbsent(String.valueOf(chars), k -> new ArrayList<>()).add(str);
        }
        for(List<String> value : map.values()) {
            result.add(value);
        }
        return result;
    }
}
