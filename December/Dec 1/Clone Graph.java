public class Solution {
    
    private Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        
        dfs(node);
        for (UndirectedGraphNode n : map.keySet()) {
            for (UndirectedGraphNode temp : n.neighbors) {
                map.get(n).neighbors.add(map.get(temp));
            }
        }
        
        return map.get(node);
    }
    
    private void dfs(UndirectedGraphNode node) {
        if (map.containsKey(node)) {
            return;
        }
        map.put(node, new UndirectedGraphNode(node.label));
        for (UndirectedGraphNode n : node.neighbors) {
            dfs(n);
        }
    }
}