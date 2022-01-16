public class TwoSum {
    HashMap<Integer, Integer> freq;

    public TwoSum() {
        freq = new HashMap<>();
    }

    public void add(int number) {
        freq.put(number, freq.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        for (Integer key : freq.keySet()) {
            int comp = value - key;
            int freq_comp = freq.getOrDefault(comp, 0);

            if (value - key == key) {
                if (freq_comp >= 2)
                    return true;
            } else {
                if (freq_comp >= 1)
                    return true;
            }
        }
        return false;
    }
}