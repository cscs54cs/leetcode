package leetcodedebug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int size;
    int capacity=0;
    Map ca;
    Item head;
    Item end;
    Map keytoitem;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        ca=new HashMap<Integer,Integer>();
        keytoitem = new HashMap<Integer,Item>();
        this.size=0;
        this.head = new Item(0);
        this.end = new Item(0);
        head.pre=null;
        head.next=end;
        end.pre=head;
        end.next=null;
    }
    
    public int get(int key) {
        if(this.ca.containsKey(key))
        {
            movetohead(key);
            return (int) ca.get(key);
        }
        else
        {
            return -1;
        }
    }
    public void movetohead(int key)
    {
        Item cur = (Item) keytoitem.get(key);
        cur.pre.next=cur.next;
        cur.next.pre=cur.pre;
        cur.next=this.head.next;
        this.head.next.pre = cur;
        cur.pre=this.head;
        this.head.next=cur;
    }
    public void removelast()
    {
        int rmkey = end.pre.key;
        Item rmitem = (Item) keytoitem.get(rmkey);
        this.ca.remove(rmkey);
        this.keytoitem.remove(rmkey);
        end.pre = rmitem.pre;
        rmitem.next=end;
        this.size=this.ca.size();
    }
    
    public void set(int key, int value) {
        if(this.size<this.capacity)
        {
            this.ca.put(key,value);
            Item temp = new Item(key);
            this.keytoitem.put(key,temp);
            temp.next=this.head.next;
            temp.pre = this.head;
            temp.next.pre=temp;
            head.next=temp;
            this.size=this.ca.size();
        }
        else
        {
            this.removelast();
            this.ca.put(key,value);
            Item temp = new Item(key);
            this.keytoitem.put(key,temp);
            temp.next=this.head.next;
            temp.pre = this.head;
            temp.next.pre=temp;
            head.next=temp;
            this.size=this.ca.size();
        }
    }
    public static void main(String[] args)
	{
		 LRUCache test = new LRUCache(2);
		 test.set(2,1);
		 test.set(2,2);
		 test.get(2);
		 test.set(1, 1);
		 test.set(4,1);
		 test.get(2);
		 
	}
}
class Item{
    public int key;
    public Item pre;
    public Item next;
    public Item(int key)
    {
        this.key=key;
        next=null;
        pre=null;
    }
}

