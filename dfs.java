import java.util.*;

public class dfs
{
    public static ArrayList<Integer> find(int cur, ArrayList<ArrayList<Integer>> neighbors, boolean visited[], ArrayList<Integer> ans)
    {
        visited[cur] = true;
        ans.add(cur);

        for(int i=0; i<neighbors.get(cur).size(); i++)
        {
            int neighbor = neighbors.get(cur).get(i);

            if(visited[neighbor] == false)
            {
                find(neighbor, neighbors, visited, ans);
            }
        }

        return ans;
    }

    public static void main(String args[])
    {
        ArrayList<ArrayList<Integer>> neighbors = new ArrayList<ArrayList<Integer>>();

        for(int i=0; i<5; i++)
        {
            neighbors.add(new ArrayList<Integer>());
        }

        neighbors.get(0).add(1);
        neighbors.get(0).add(2);

        neighbors.get(1).add(0);
        neighbors.get(1).add(3);

        neighbors.get(2).add(0);
        neighbors.get(2).add(3);

        neighbors.get(3).add(1);
        neighbors.get(3).add(2);
        neighbors.get(3).add(4);

        neighbors.get(4).add(3);

        boolean visited[] = new boolean[5];


        
        System.out.println(find(
            0, neighbors, visited, new ArrayList<Integer>()));
    }
}