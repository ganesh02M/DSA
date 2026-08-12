class Solution {
   public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    backtrack(candidates, target, 0, new ArrayList<>(), res);
    return res;
}
private void backtrack(int[] c, int target, int start, List<Integer> cur, List<List<Integer>> res) {
    if (target == 0) { res.add(new ArrayList<>(cur)); return; }
    if (target < 0) return;
    for (int i = start; i < c.length; i++) {
        cur.add(c[i]);
        backtrack(c, target - c[i], i, cur, res); // i (not i+1) => reuse allowed
        cur.remove(cur.size() - 1);
    }
}
}