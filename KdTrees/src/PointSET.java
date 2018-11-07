import java.awt.Color;

public class PointSET implements PointContainer
{    
	private SET s;
    public boolean isEmpty()
    {
    	return s==null;
    }
    
    public int size()
    {
        return s.size();
    }
    
    public void insert(Point2D p)
    {
        s.add(p);;
    }
    
    public boolean contains(Point2D p)
    {
        return s.contains(p);
    }
    
    public void draw(Canvas canvas)
    {
        canvas.setPenColor(Color.BLACK);
        canvas.setPenRadius(.01);
        
        // TODO: Insert code here to call the point() method on canvas
        // for each point that has been inserted into your PointSET
        Iterator<Key> i=s.iterator();
        
        // Don't forget to remove this!
    	throw new UnsupportedOperationException();
    }
    
    public Iterable<Point2D> range(RectHV rect)
    {
    	throw new UnsupportedOperationException();
    }
    
    public Point2D nearest(Point2D p)
    {
    	throw new UnsupportedOperationException();
    }
}