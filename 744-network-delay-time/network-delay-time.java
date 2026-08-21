

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Adjacency list banao
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        
        for (int[] t : times) {
            int u = t[0], v = t[1], w = t[2];
            adj.get(u).add(new int[]{v, w});
        }
        
        // Dijkstra chalao source k se
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{k, 0});
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], d = cur[1];
            
            if (d > dist[node]) continue;
            
            for (int[] edge : adj.get(node)) {
                int next = edge[0], weight = edge[1];
                if (dist[node] + weight < dist[next]) {
                    dist[next] = dist[node] + weight;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }
        
        // Maximum distance nikalo (1 se n tak, 0 index skip karo)
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, dist[i]);
        }
        
        return maxTime;
    }
}