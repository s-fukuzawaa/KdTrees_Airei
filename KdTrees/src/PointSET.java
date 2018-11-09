import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

public class PointSET implements PointContainer
{    
	private SET s;
    public boolean isEmpty()
    {
    	if(s==null)
    	{
    		throw new java.lang.NullPointerException();
    	}
    	return false;
    }
    
    public int size()
    {
    	if(s==null)
    	{
    		throw new java.lang.NullPointerException();
    	}
    	
        return s.size();
    }
    
    public void insert(Point2D p)
    {
    	if(p==null)
    	{
    		throw new java.lang.NullPointerException();
    	}
        s.add(p);
    }
    
    public boolean contains(Point2D p)
    {
    	if(p==null)
    	{
    		throw new java.lang.NullPointerException();
    	}
        return s.contains(p);
    }
    
    public void draw(Canvas canvas)
    {
    	if(canvas==null)
    	{
    		throw new java.lang.NullPointerException();
    	}
    	
    	
        canvas.setPenColor(Color.BLACK);
        canvas.setPenRadius(.01);
        
        // TODO: Insert code here to call the point() method on canvas
        // for each point that has been inserted into your PointSET
        Iterator<Point2D> i=s.iterator();
        while(i.hasNext())
        {
        	canvas.point(i.next().x(), i.next().y());
        }
        	
        
        // Don't forget to remove this!
    }
   
    public Iterable<Point2D> range(RectHV rect)
    {
    	if(rect==null)
    	{
    		throw new java.lang.NullPointerException();
    	}
    	ArrayList<Point2D> range= new ArrayList<Point2D>();
    	Iterator<Point2D> r=s.iterator();
    	while(r.hasNext())
    	{
    		if(r.next().x()>=rect.xmin()&&r.next().x()<=rect.xmax()&&r.next().y()>=rect.ymin()&&r.next().y()<=rect.ymax())
    		{
    			range.add(r.next());
    		}
    	}
    	
    	return range;
    }
    
    public Point2D nearest(Point2D p)
    {
    	if(p==null)
    	{
    		throw new java.lang.NullPointerException();
    	}
    	
    	
        Iterator<Point2D> i=s.iterator();
        double distance=i.next().distanceTo(p);
        Point2D near=p;
        while(i.hasNext())
        {
        	if(i.next().distanceTo(p)<distance)
        	{
        		distance=i.next().distanceTo(p);
        		near=i.next();
        	}
        }
        return  near;
    }
}