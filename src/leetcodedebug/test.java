package leetcodedebug;

import java.util.ArrayList;
import java.util.HashSet;

public class test {
    public static void main(String[] args)
	{
    	ArrayList<Interval> intervals = new ArrayList<Interval>();
    	Interval newInterval = new Interval(7,8);
    	Interval i1 = new Interval(1,3);
    	Interval i2 = new Interval(6,8);
    	Interval i3 = new Interval(9,9);
    	intervals.add(i1);
    	intervals.add(i2);
    	intervals.add(i3);
    	insertinterval test = new insertinterval();
    	test.insert(intervals, newInterval);
    	
    	
	}
}
