class Solution {
    // 1a Combination Sum, for loop
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void helper(int[] candidates, int target, List<List<Integer>> res,
                        List<Integer> path, int index) {
        if (target <= 0 || index >= candidates.length) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], res, path, i);
            path.remove(path.size() - 1);
        }
    }
}



class Solution {
  // 1b Combination Sum, choose/not choose
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
      List<List<Integer>> res = new ArrayList<>();
      search(target, 0, new ArrayList<>(), res, candidates);
      return res;
  }

  private void search(int target, int startIndex, List<Integer> path,
                      List<List<Integer>> res, int[] candidates) {
      if (target < 0) {
          return;
      }

      if (target == 0) {
          res.add(path);
          return;
      }

      if (startIndex >= candidates.length) {
          return;
      }

      List<Integer> firstPath = new ArrayList<>(path);
      firstPath.add(candidates[startIndex]);
      search(target - candidates[startIndex],
             startIndex, firstPath, res, candidates);
      search(target, startIndex + 1, path, res, candidates);
  }
}



class Solution {
    // 2a Combination Sum II, for loop
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }

    private void helper(int[] candidates, int target, List<List<Integer>> res,
                        List<Integer> path, int index) {
        if (target <= 0 || index >= candidates.length) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            if (target - candidates[i] < 0) {
                break;
            }
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], res, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}



class Solution {
  // 2b Combination Sum II, choose/not choose
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        search(target, 0, new ArrayList<>(), res, candidates);
        return res;
    }

    private void search(int target, int startIndex, List<Integer> path,
                        List<List<Integer>> res, int[] candidates) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (startIndex >= candidates.length) {
            return;
        }

        List<Integer> firstPath = new ArrayList<>(path);
        firstPath.add(candidates[startIndex]);
        search(target - candidates[startIndex],
               startIndex + 1, firstPath, res, candidates);
        while (startIndex + 1 < candidates.length
               && candidates[startIndex] == candidates[startIndex + 1]) {
            startIndex++;
        }
        search(target, startIndex + 1, path, res, candidates);
    }
}



class Solution {
    // 3a Combination Sum III, for loop
    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(target, res, new ArrayList<>(), k, 1);
        return res;
    }

    private void helper(int target, List<List<Integer>> res,
                        List<Integer> path, int k, int value) {
        if (target == 0 && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0 || path.size() > k) {
            return;
        }

        for (int v = value; v <= 9; v++) {
            if (target - v < 0) {
                break;
            }
            path.add(v);
            helper(target - v, res, path, k, v + 1);
            path.remove(path.size() - 1);
        }
    }
}



class Solution {
    // 3b Combination Sum III, choose/not choose
    public List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> res = new ArrayList<>();
        search(target, 1, k, new ArrayList<>(), res);
        return res;
    }

    private void search(int target, int value, int k,
                        List<Integer> path, List<List<Integer>> res) {
        if (target == 0 && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target < 0 || path.size() > k || value > 9) {
            return;
        }

        // choose current value
        path.add(value);
        search(target - value, value + 1, k, path, res);
        path.remove(path.size() - 1);
        // not choose current value
        search(target, value + 1, k, path, res);
    }
}



class Solution {
    // Time Limit Exceeded
    // 4a Combination Sum IV, for loop
    public int combinationSum4(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, res, new ArrayList<>());
        return res.size();
    }

    private void helper(int[] candidates, int target, List<List<Integer>> res,
                        List<Integer> path) {
        if (target <= 0) {
            if (target == 0) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = 0; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], res, path);
            path.remove(path.size() - 1);
        }
    }
}



class Solution {
    // Time Limit Exceeded
    // 4b Combination Sum IV, choose/not choose
    public int combinationSum4(int[] candidates, int target) {
        int[] res = new int[1];
        search(target, 0, new ArrayList<>(), res, candidates);
        return res[0];
    }

    private void search(int target, int startIndex, List<Integer> path,
                      int[] res, int[] candidates) {
        if (target < 0) {
          return;
        }
        if (target == 0) {
            res[0] += findN(path);
            return;
        }
        if (startIndex >= candidates.length) {
          return;
        }

        List<Integer> firstPath = new ArrayList<>(path);
        firstPath.add(candidates[startIndex]);
        search(target - candidates[startIndex], startIndex, firstPath, res,
               candidates);
        search(target, startIndex + 1, path, res, candidates);
    }

    private int findN(List<Integer> path) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : path) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int n = path.size();
        int res = 1;
        for (int key : map.keySet()) {
            int value = map.get(key);
            res *= C(n, value);
            n = n - value;
            if (n == 0) {
                break;
            }
        }

        return res;
    }

    private int C(int n, int r) {
        // C(n, r) = n! / r! / (n-r)!
        long res = 1;
        for (long x = r + 1; x <= n; x++) {
            res *= x;
        }
        for (long x = n - r; x > 1; x--) {
            res /= x;
        }
        return (int) res;
    }
}



class Solution {
    // 4b Combination Sum IV, DP, AC
    public int combinationSum4(int[] candidates, int target) {
        int[] comb = new int[target + 1];
        comb[0] = 1;
        Arrays.sort(candidates);
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < candidates.length; j++) {
                if (candidates[j] >= comb.length) {
                    break;
                }
                if (i - candidates[j] < 0) {
                    continue;
                }
                comb[i] += comb[i - candidates[j]];
            }
        }
        System.out.println(Arrays.toString(comb));
        return comb[target];
    }
}
