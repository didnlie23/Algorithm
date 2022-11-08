class Solution {
    public int[][] highFive(int[][] items) {
        Arrays.sort(items, new Comparator<int[]>(){
            public int compare(int[] o1, int[] o2){
                if (o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }else{
                    return o1[0] - o2[0];
                }
            }
        });
        
        Queue<int[]> queue= new LinkedList<>();
        
        int length = items.length;
        int id = Integer.MAX_VALUE;
        for(int i=0;i<length;i++){
            if (id != items[i][0]){
                int sum = 0;
                for(int j=i;j<i+5;j++){
                    sum += items[j][1];
                }
                queue.offer(new int[]{items[i][0], (int)Math.floor(sum/5)});
                id = items[i][0];
            }
        }
        
        int size = queue.size();
        int[][] answer = new int[size][2];
        for(int i=0;i<size;i++){
            answer[i] = queue.poll();
        }
        
        return answer;
    }
}