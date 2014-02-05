package leetcodedebug;

public class maxpointsonaline {
	/**
	 * Definition for a point.
	 * class Point {
	 *     int x;
	 *     int y;
	 *     Point() { x = 0; y = 0; }
	 *     Point(int a, int b) { x = a; y = b; }
	 * }
	 */
	public int maxPoints(Point[] points) {
        int max=-1;
        int count=0;
        if(points.length<=2)
        {
            return points.length;
        }
        for(int i=0;i<points.length;i++)
        {
            for(int j=i+1;j<points.length;j++)
            {
                for(int k=0;k<points.length;k++)
                {
                    if(check(points[i],points[j],points[k]))
                    {
                        count++;           
                    }
                
                }
                if(max<count)   max=count;
                count=0;
            }
        }
        return max;
    }
    public boolean check(Point a, Point b, Point c)
    {
        if((a.x==c.x)&&(a.y==c.y))   return true;
        if((b.x==c.x)&&(b.y==c.y))	return true;
        if(a.x==b.x)
        {
            return (c.x==a.x);
        }
        if(a.y==b.y)
        {
            return (c.y==a.y);
        }
        return  (double)(a.y-c.y)/(double)(a.x-c.x)==(double)(b.y-c.y)/(double)(b.x-c.x);
    }
}
