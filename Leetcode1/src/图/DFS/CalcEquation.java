package 图.DFS;

import java.util.*;

/**
 * ClassName: CalcEquation
 * Package: 图.DFS
 * Description:
 *
 * @Author zbc
 * @Create 2024/8/7 上午9:37
 * @Version 1.0
 */
public class CalcEquation {
    double[] ans;
    HashMap<String, List<Cell>> graph;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        ans = new double[queries.size()];
        Arrays.fill(ans, -1.0);
        //建双向有权图
        //ArrayList<ArrayList<String>> graph = new ArrayList<>();
        graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            double value = values[i];
            graph.computeIfAbsent(from, key -> new ArrayList<>()).add(new Cell(to, value));
            graph.computeIfAbsent(to, key -> new ArrayList<>()).add(new Cell(from, 1.0 / value));
        }
        for (int i = 0; i < queries.size(); i++) {
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);
            if(graph.containsKey(from) && graph.containsKey(to)){
                dfs(from , to, 1.0, i, new HashSet<>());
            }
        }
        return ans;
    }
    public void dfs(String cur, String to, double value, int i, HashSet<String> visited){
        if(visited.contains(cur)){
            return;
        }
        if(cur.equals(to)){
            ans[i] = value;
            return;
        }
        visited.add(cur);
        for (Cell cell : graph.get(cur)) {

            dfs(cell.str, to, value * cell.value, i, visited);
            //这里不需要回溯，假设当前结点为a，a的邻接节点有b、c、d
            //在for循环之前将a加入set，那么在for循环中，b、c、d都是在下一层才加入set，本层不需要回溯
        }
    }


    class Cell{
        String str;
        double value;
        Cell(String str, double value){
            this.str = str;
            this.value = value;
        }
    }


}
