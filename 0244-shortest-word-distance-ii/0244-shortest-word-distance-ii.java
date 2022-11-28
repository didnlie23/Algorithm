class WordDistance {

    Map<String, ArrayList<Integer>> list;
    public WordDistance(String[] wordsDict) {
        list = new HashMap<>();
        for(int i=0,iEnd= wordsDict.length;i<iEnd;i++){
            if (list.containsKey(wordsDict[i])){
                list.get(wordsDict[i]).add(i);
            }else{
                list.put(wordsDict[i], new ArrayList<>());
                list.get(wordsDict[i]).add(i);
            }
        }
    }

    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        ArrayList<Integer> list1 = list.get(word1);
        ArrayList<Integer> list2 = list.get(word2);
        int diff = -1;
        for(int i=0,iEnd=list1.size();i<iEnd;i++){
            for(int j=0,jEnd=list2.size();j<jEnd;j++){
                diff = Math.abs(list1.get(i) - list2.get(j));
                if (diff < min){
                    min = diff;
                }
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */