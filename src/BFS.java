import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.*;

public class BFS {
	static int[] dist;
	static Queue q = new LinkedList<Integer>();
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        dist= new int[adj.length];
        for(int i=0; i<dist.length;i++){
        	dist[i]=Integer.MAX_VALUE;
        }
        dist[s]=0;
        q.offer(s);
        
        
        while(!q.isEmpty()){
        	int u= (int) q.remove();
        	for(int v: adj[u]){
        		if(dist[v]==Integer.MAX_VALUE){
        			q.offer(v);
        			dist[v]=dist[u]+1;
        			
        		}
        		
        	}
        	
        }
        if(dist[t]!=Integer.MAX_VALUE){
        	return dist[t];
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    	/*while(true){
    	int n=(int)(Math.random()*1000000)+2;
    	int m=(int)(Math.random()*1000000);
    	
    	ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = (int)(Math.random()*n)+1;
            y = (int)(Math.random()*n)+1;
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
           // System.out.println(x+' '+y);
        }
        System.out.print(' ');
        int x =(int)(Math.random()*n)+1;;
        int y = (int)(Math.random()*n)+1;;
        System.out.println(distance(adj, x, y));
        System.out.println(' ');
    	}*/
    }
}

