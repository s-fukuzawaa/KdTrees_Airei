import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

public class PointSET implements PointContainer
{    
	private SET<Point2D> s;
	public PointSET()
	{
		this.s=new SET<Point2D>();
	}
    public boolean isEmpty()
    {
    	return s.isEmpty();
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
    	if(p==null||s==null)
    	{
    		throw new java.lang.NullPointerException();
    	}
        return s.contains(p);
    }
    
    public void draw(Canvas canvas)
    {
    	if(canvas==null||s==null)
    	{
    		throw new java.lang.NullPointerException();
    	}
    	
    	
        canvas.setPenColor(Color.BLACK);
        canvas.setPenRadius(.01);
        
        // TODO: Insert code here to call the point() method on canvas
        // for each point that has been inserted into your PointSET
        for(Point2D p : s)
        {
        	canvas.point(p.x(), p.y());
        }
        	
        
        // Don't forget to remove this!
    }
   
    public Iterable<Point2D> range(RectHV rect)
    {
    	if(rect==null||s==null)
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
    	if(p==null||s==null)
    	{
    		throw new java.lang.NullPointerException();
    	}
    	
    	
        Point2D near=p;
        for(Point2D n : s)
        {
        	if(n.distanceTo(p)<near.distanceTo(p)||near==p)
        	{
        		
        		near=n;
        	}
        }
        return  near;
    }
}