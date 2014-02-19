package leetcodedebug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
class LNode {  
    int no;  
    String val;  
    LinkedList<LNode> prev;      
      
    LNode(int no, String v) {  
        this.no = no;  
        this.val = v;  
    }  
      
    void addPrev(LNode pNode) {  
        if (prev == null) {  
            prev = new LinkedList<LNode>();  
        }  
        prev.add(pNode);  
    }  
}
public class wordladdarii {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        //HashSet visited = new HashSet();
		ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        HashMap<String, LNode> backmap = new HashMap<String,LNode>();
        HashSet<String>	h = new HashSet<String>();
        ArrayList<Queue<String>> actionQueue = new  ArrayList<Queue<String>>();
        actionQueue.add(new LinkedList<String>());
        actionQueue.add(new LinkedList<String>());
        String cur,temp;
        actionQueue.get(0).offer(start);
        int level =0;
        LNode startnode = new LNode(level,start);
        backmap.put(start,startnode);
        boolean find = false;
        int swi=0;
        char[] wordArray;
        while(!actionQueue.get(swi).isEmpty())
        {
            cur=actionQueue.get(swi).poll();
            if(dict.contains(cur))
                h.add(cur);

            for (int i = 0; i < cur.length(); i++) {
                wordArray = cur.toCharArray();
                // change that letter to something else
                for (char c = 97; c <= 122; c++) {
                    if (c != cur.charAt(i)) {
                        wordArray[i] = c;
                        String nei = new String(wordArray);
                        if(dict.contains(nei))
                        {
                        	
                        	if(!h.contains(nei))
                        		actionQueue.get(1^swi).offer(nei);
                        	if(!(nei.equals(end))) 
                        		h.add(nei);
                        	if(backmap.get(nei)==null)
                        	{
                        		LNode tempnode = new LNode(level+1,nei);
                        		backmap.put(nei,tempnode);
                        		backmap.get(nei).addPrev(backmap.get(cur));
                        	}
                        	else
                        	{
                        		if(backmap.get(nei).prev!=null&&backmap.get(cur).no<=backmap.get(nei).prev.get(0).no)
                        			backmap.get(nei).addPrev(backmap.get(cur));
                        	}
                        }
                        if(nei.equals(end))
                        {
                        	find = true;
                        	actionQueue.get(1^swi).clear();
                        	/*
                        	temp=nei;

                            ArrayList<String> re = new ArrayList<String>();
                            while(!temp.equals(start))
                            {
                                re.add(0,temp);
                                temp=backmap.get(temp);
                            }
                            re.add(0,start);
                            ret.add(re);
                            */
                        }

                    }
                }
            }
        

            if(find) 
            	actionQueue.get(1^swi).clear();
            if(actionQueue.get(swi).isEmpty())
            {
            	level++;
                swi = swi^1;
            }
        }
    	printpath(backmap.get(end),new ArrayList<String>(),ret,start);
        return ret;
    }
    void printpath(LNode node,ArrayList<String> re,ArrayList<ArrayList<String>> ret,String start)
    {
    	if(node==null)	return;
    	if(node.val.equals(start))
    	{
    		re.add(0,start);
    		ret.add(re);
    		return;
    	}
    	re.add(0,node.val);
    	if(node.prev!=null)
    	{
	    	for(LNode p : node.prev)
	    	{
	    		printpath(p,(ArrayList<String>)re.clone(),ret,start);
	    	}
    	}
    }
}
