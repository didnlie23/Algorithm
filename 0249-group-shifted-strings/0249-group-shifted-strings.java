class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0;i<strings.length;i++){
            String temp = strings[i];
            StringBuilder sb = new StringBuilder();
            char first = temp.charAt(0);
            for(int j=1;j<temp.length();j++){
                int distance = temp.charAt(j) - first;
                sb.append(String.valueOf((char)((distance+26)%26+'a')));
            }
            String key = sb.toString();
            if (map.containsKey(key)){
                map.get(key).add(temp);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(temp);
                map.put(key, list);
            }
        }
        List<List<String>> result = new LinkedList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    // public static int calDistance(char c1, char c2){
    //     int distance = c1 - c2;
    //     return distance >= 0?distance:distance+26;
    // }
}