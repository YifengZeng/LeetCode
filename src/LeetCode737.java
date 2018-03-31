class Solution {
    // BFS AC
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2,
                                          String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }

        Map<String, Set<String>> map = initMap(pairs);

        for (int i = 0; i < words1.length; i++) {
            if (!isSimilar(words1[i], words2[i], map)) {
                return false;
            }
        }
        return true;
    }

    private boolean isSimilar(String str1, String str2,
                              Map<String, Set<String>> map) {
        if (str1.equals(str2)) {
            return true;
        }
        if (!map.containsKey(str1) || !map.containsKey(str2)) {
            return false;
        }

        Set<String> visited = new HashSet<>();
        Deque<String> q = new LinkedList<>();
        visited.add(str1);
        q.offer(str1);

        while (!q.isEmpty()) {
            String cur = q.poll();
            for (String next : map.get(cur)) {
                if (next.equals(str2)) {
                    return true;
                }
                if (!visited.contains(next)) {
                    q.offer(next);
                    visited.add(next);
                }
            }
        }
        return false;
    }

    private Map<String, Set<String>> initMap(String[][] pairs) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String[] p : pairs) {
            map.put(p[0], map.getOrDefault(p[0], new HashSet<>()));
            map.get(p[0]).add(p[1]);
            map.put(p[1], map.getOrDefault(p[1], new HashSet<>()));
            map.get(p[1]).add(p[0]);
        }

        return map;
    }
}




class Solution {
    // DFS AC
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2,
                                          String[][] pairs) {
      if (words1.length != words2.length) {
          return false;
      }

      Map<String, Set<String>> map = initMap(pairs);
      for (int i = 0; i < words1.length; i++) {
          if (!isSimilar(words1[i], words2[i], map)) {
              return false;
          }
      }

      return true;
    }

    private boolean isSimilar(String source, String target, Map<String,
                              Set<String>> map) {
      if (source.equals(target)) {
          return true;
      }
      if (!map.containsKey(source) || !map.containsKey(target)) {
          return false;
      }

      Set<String> visited = new HashSet<>();
      visited.add(source);
      return dfsHelper(source, target, map, visited);
    }

    private boolean dfsHelper(String cur, String target,
                              Map<String, Set<String>> map,
                              Set<String> visited) {
      if (cur.equals(target)) {
          return true;
      }

      for (String next : map.get(cur)) {
          if (!visited.contains(next)) {
              visited.add(next);
              if (dfsHelper(next, target, map, visited)) {
                  return true;
              }
          }
      }

      return false;
    }

    private Map<String, Set<String>> initMap(String[][] pairs) {
      Map<String, Set<String>> map = new HashMap<>();
      for (String[] p : pairs) {
          map.put(p[0], map.getOrDefault(p[0], new HashSet<>()));
          map.get(p[0]).add(p[1]);
          map.put(p[1], map.getOrDefault(p[1], new HashSet<>()));
          map.get(p[1]).add(p[0]);
      }

      return map;
    }
}




class Solution {
    // union find AC
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2,
                                          String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }

        Map<String, String> parents = initMap(pairs);
        for (int i = 0; i < words1.length; i++) {
            if (!isSimilar(words1[i], words2[i], parents)) {
                return false;
            }
        }

        return true;
    }

    private boolean isSimilar(String source, String target,
                              Map<String, String> parents) {
        if (source.equals(target)) {
            return true;
        }
        if (!parents.containsKey(source) || !parents.containsKey(target)) {
            return false;
        }
        String pa = find(parents, source);
        String pb = find(parents, target);
        return pa.equals(pb);
    }

    private Map<String, String> initMap(String[][] pairs) {
        Map<String, String> parents = new HashMap<>();
        for (String[] p : pairs) {
            if (!parents.containsKey(p[0])) {
                parents.put(p[0], p[0]);
            }
            if (!parents.containsKey(p[1])) {
                parents.put(p[1], p[1]);
            }

            String pa = find(parents, p[0]);
            String pb = find(parents, p[1]);
            // union
            if (!pa.equals(pb)) {
                parents.put(pa, pb);
            }
        }

        return parents;
    }

    private String find(Map<String, String> parents, String str) {
        while (!parents.get(str).equals(str)) {
            parents.put(str, parents.get(parents.get(str)));
            str = parents.get(str);
        }
        return str;
    }
}
