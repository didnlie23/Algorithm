class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0;i<strings.length;i++){
            String temp = strings[i];
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(0)).append(",");
            char first = temp.charAt(0);
            for(int j=1;j<temp.length();j++){
                sb.append(String.valueOf(calDistance(temp.charAt(j), first))).append(",");
            }
            if (map.containsKey(sb.toString())){
                map.get(sb.toString()).add(temp);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(temp);
                map.put(sb.toString(), list);
            }
        }
        List<List<String>> result = new LinkedList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    public static int calDistance(char c1, char c2){
        int distance = c1 - c2;
        return distance >= 0?distance:distance+26;
    }
}