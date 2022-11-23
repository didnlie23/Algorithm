class TwoSum {
    private Map<Integer, Integer> map;

    public TwoSum() {
        map = new HashMap<>();
    }

    public void add(int number) {
        if (map.containsKey(number)) map.put(number, map.get(number) + 1); else map.put(number, 1);
    }

    public boolean find(int value) {
        for (Integer key : map.keySet()) {
            int pair = value - key;
            if (pair != key && map.containsKey(pair)) {
                return true;
            } else if (pair == key && map.get(key) > 1) {
                return true;
            }
        }
        return false;
    }
}
/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
