class Solution {
    List<String> res;

    public void generateAbb(String input, int idx, String output, int count) {
        if (idx == input.length()) {
            if (count > 0)
                res.add(output + count);
            else
                res.add(output);
            return;
        }

        char ch = input.charAt(idx);
        generateAbb(input, idx + 1, output + ((count == 0) ? "" : count) + ch, 0); // yes
        generateAbb(input, idx + 1, output, count + 1); // no
    }

    public List<String> generateAbbreviations(String word) {
        res = new ArrayList<>();
        generateAbb(word, 0, "", 0);
        return res;
    }
}