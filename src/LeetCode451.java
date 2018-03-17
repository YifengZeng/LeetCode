class Solution {
    // AC nlogn
    class Pair {
        char ch;
        int count;
        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Pair> list = new ArrayList<>();
        for (Map.Entry entry : map.entrySet()) {
            list.add(new Pair((char) entry.getKey(), (int) entry.getValue()));
        }

        Collections.sort(list, (a, b) -> b.count - a.count);
        StringBuilder sb = new StringBuilder();
        for (Pair p : list) {
            for (int i = 0; i < p.count; i++) {
                sb.append(p.ch);
            }
        }

        return sb.toString();
    }
}




class Solution {
    // AC, nlogn
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Character[] Chars = new Character[chars.length];
        int[] hash = new int[256];
        int i = 0;
        for (char ch : chars) {
            hash[ch]++;
            Chars[i++] = ch;
        }

        Arrays.sort(Chars, (a, b) -> (hash[b] == hash[a] ? (int) a - (int) b : hash[b] - hash[a]));

        i = 0;
        for (Character ch : Chars) {
            chars[i++] = (char) ch;
        }
        return new String(chars);
    }
}




class Solution {
    // AC bucket sort, O(n)
    public String frequencySort(String s) {
        int[] hash = new int[256];
        for (char ch : s.toCharArray()) {
            hash[ch]++;
        }

        List<Character>[] bucket = new List[s.length() + 1];
        for (int i = 0; i < 256; i++) {
            if (hash[i] == 0) {
                continue;
            }
            if (bucket[hash[i]] == null) {
                bucket[hash[i]] = new ArrayList<>();
            }
            bucket[hash[i]].add((char) i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i >= 0; i--) {
            if (bucket[i] == null) {
                continue;
            }
            for (Character ch : bucket[i]) {
                for (int j = 0; j < i; j++) {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}
