class Solution {
    // one-directional BFS, AC
    public int ladderLength(String start, String end, List<String> dict) {
        Set<String> set = new HashSet<>(dict);
        if (!set.contains(end)) {
            return 0;
        }

        Deque<String> q = new LinkedList<>();
        q.offer(start);
        int dist = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(end)) {
                    return dist;
                }
                getNeighbours(q, cur, set);
            }
            dist++;
        }
        return 0;
    }

    private void getNeighbours(Deque<String> q, String cur, Set<String> set) {
        char[] chars = cur.toCharArray();
        for (int i = 0; i < cur.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;
                String neighbour = new String(chars);
                if (set.contains(neighbour)) {
                    q.offer(neighbour);
                    set.remove(neighbour);
                }
            }
            chars[i] = cur.charAt(i);
        }
    }
}





class Solution {
    // bi-directional BFS, AC
    public int ladderLength(String start, String end, List<String> list) {
        Set<String> dict = new HashSet<>(list);
        if (!dict.contains(end)) {
            return 0;
        }

        Set<String> sSet = new HashSet<>();
        Set<String> eSet = new HashSet<>();
        sSet.add(start);
        eSet.add(end);
        dict.remove(end);

        int dist = 2;
        while (!sSet.isEmpty() && !eSet.isEmpty()) {
            if (sSet.size() < eSet.size()) {
                if (find(sSet, eSet, dict)) {
                    return dist;
                }
            } else {
                if (find(eSet, sSet, dict)) {
                    return dist;
                }
            }
            dist++;
        }

        return 0;
    }

    private boolean find(Set<String> fromSet, Set<String> toSet, Set<String> dict) {
        Set<String> neighbours = new HashSet<>();
        for (String str : fromSet) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String neighbour = new String(chars);
                    if (toSet.contains(neighbour)) {
                        return true;
                    }
                    if (dict.contains(neighbour)) {
                        neighbours.add(neighbour);
                        dict.remove(neighbour);
                    }
                }
                chars[i] = str.charAt(i);
            }
        }

        fromSet.clear();
        fromSet.addAll(neighbours);

        return false;
    }
}
