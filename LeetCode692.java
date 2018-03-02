class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Queue<String> pq = new PriorityQueue<>(
            (str1, str2) -> (map.get(str1) == map.get(str2) ? str2.compareTo(str1) : map.get(str1) - map.get(str2)));

        for (String key : map.keySet()) {
            pq.offer(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll());
        }
        Collections.reverse(res);

        return res;
    }
}