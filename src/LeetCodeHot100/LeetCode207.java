package LeetCodeHot100;

import java.util.*;

public class LeetCode207 {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 0}, {2,0}, {0,2}};
//        int[][] grid = new int[][]{{1,4},{2,4},{3 ,1},{3,2}};
//        int[][] grid = new int[][]{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};
//        int[][] grid = new int[][]{{1,0},{2,0},{2,1},{3,1},{3,2},{4,2},{4,3},{5,3},{5,4},{6,4},{6,5},{7,5},{7,6},{8,6},{8,7},{9,7},{9,8},{10,8},{10,9},{11,9},{11,10},{12,10},{12,11},{13,11},{13,12},{14,12},{14,13},{15,13},{15,14},{16,14},{16,15},{17,15},{17,16},{18,16},{18,17},{19,17},{19,18},{20,18},{20,19},{21,19},{21,20},{22,20},{22,21},{23,21},{23,22},{24,22},{24,23},{25,23},{25,24},{26,24},{26,25},{27,25},{27,26},{28,26},{28,27},{29,27},{29,28},{30,28},{30,29},{31,29},{31,30},{32,30},{32,31},{33,31},{33,32},{34,32},{34,33},{35,33},{35,34},{36,34},{36,35},{37,35},{37,36},{38,36},{38,37},{39,37},{39,38},{40,38},{40,39},{41,39},{41,40},{42,40},{42,41},{43,41},{43,42},{44,42},{44,43},{45,43},{45,44},{46,44},{46,45},{47,45},{47,46},{48,46},{48,47},{49,47},{49,48},{50,48},{50,49},{51,49},{51,50},{52,50},{52,51},{53,51},{53,52},{54,52},{54,53},{55,53},{55,54},{56,54},{56,55},{57,55},{57,56},{58,56},{58,57},{59,57},{59,58},{60,58},{60,59},{61,59},{61,60},{62,60},{62,61},{63,61},{63,62},{64,62},{64,63},{65,63},{65,64},{66,64},{66,65},{67,65},{67,66},{68,66},{68,67},{69,67},{69,68},{70,68},{70,69},{71,69},{71,70},{72,70},{72,71},{73,71},{73,72},{74,72},{74,73},{75,73},{75,74},{76,74},{76,75},{77,75},{77,76},{78,76},{78,77},{79,77},{79,78},{80,78},{80,79},{81,79},{81,80},{82,80},{82,81},{83,81},{83,82},{84,82},{84,83},{85,83},{85,84},{86,84},{86,85},{87,85},{87,86},{88,86},{88,87},{89,87},{89,88},{90,88},{90,89},{91,89},{91,90},{92,90},{92,91},{93,91},{93,92},{94,92},{94,93},{95,93},{95,94},{96,94},{96,95},{97,95},{97,96},{98,96},{98,97},{99,97}};
//        System.out.println(canFinishSlow(20, grid));
        System.out.println(canFinish(100, grid));

    }

    /**
     * 第一版本只击败了 5%```
     * 主要是用了个 hashset 记录路径，并且还十分讲究的结束 clear 了```不 clear > 62%
     * 而且好像刚好看反了题意，但是通过了```也没回头细看
     *
     * 第二版研究了下别人的提交，用 visited 数组代替 hashset, 击败 91%
     */
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> queue = new ArrayList<>();
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses;i++) {
            queue.add(new ArrayList<>());
        }
        for (int[] arr : prerequisites) {
            List<Integer> list = queue.get(arr[1]);
            list.add(arr[0]);
        }
        for (int[] arr : prerequisites) {
            if (!dfs(queue, visited, arr[1])) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(List<List<Integer>> map, int[] visited, Integer cur) {
        if (visited[cur] == 1) {
            return false;
        }
        if (visited[cur] == -1) {
            return true;
        } else {
            visited[cur] = 1;
        }
        if (map.get(cur).size() != 0) {
            for (Integer value : map.get(cur)) {
                if (!dfs(map, visited, value)) {
                    return false;
                }
            }
        }
        visited[cur] = -1;
        return true;
    }

    /**
     * 第一版\
     *
     */
    public static boolean canFinishSlow(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        boolean[] visited = new boolean[numCourses];
        for (int[] arr : prerequisites) {
            List<Integer> list = map.get(arr[0]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(arr[0], list);
            }
            list.add(arr[1]);
        }
        for (int[] arr : prerequisites) {

            Set<Integer> path = new HashSet<>();
            if (!dfsLow(map, visited, arr[0], path)) {
                return false;
            }
            path.clear();
        }
        return true;
    }

    private static boolean dfsLow(HashMap<Integer, List<Integer>> map, boolean[] visited, Integer cur, Set<Integer> path) {
        System.out.println("dfs cur = " +cur +", path = " + Arrays.toString(path.toArray()));
        if (!path.add(cur)) {
            return false;
        }
        if (visited[cur]) {
            return true;
        } else {
            visited[cur] = true;
        }
        if (map.get(cur) == null) {
            return true;
        }
        for (Integer value : map.get(cur)) {
            if (!dfsLow(map, visited, value, path)) {
                return false;
            }
            path.remove(value);
        }
        return true;
    }

}