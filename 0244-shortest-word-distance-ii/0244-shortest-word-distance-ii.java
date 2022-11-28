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
        int index1 = 0;
        int index2 = 0;
        int size1 = list1.size();
        int size2 = list2.size();
        while (index1 < size1 && index2 < size2) {
            min = Math.min(Math.abs(list1.get(index1) - list2.get(index2)), min);
            if (list1.get(index1) < list2.get(index2)){
                index1++;
            }else{
                index2++;
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