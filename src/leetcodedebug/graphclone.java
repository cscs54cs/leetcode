package leetcodedebug;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class graphclone {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> h=new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        if(node==null)  return node;
        q.offer(node);
        UndirectedGraphNode head =null,cur,newcur;
        while(!q.isEmpty())
        {
            cur=q.poll();
            if(!h.containsKey(cur))
            {
                newcur = new UndirectedGraphNode(cur.label);
                h.put(cur,newcur);
            }
            else
            {
                newcur = (UndirectedGraphNode) h.get(cur);
            }
            if(head==null)  head = newcur;
            for(UndirectedGraphNode nei: cur.neighbors)
            {
                q.offer(nei);
                if(h.containsKey(nei))
                {
                    newcur.neighbors.add((UndirectedGraphNode) h.get(nei));
                }
                else
                {
                    UndirectedGraphNode temp = new UndirectedGraphNode(nei.label);
                    h.put(nei,temp);
                    newcur.neighbors.add(temp);
                }
            }
        }
        return head;
    }
}
