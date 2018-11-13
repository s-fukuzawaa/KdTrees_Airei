import java.awt.Color;


public class KdTree implements PointContainer
{
	private static class Node
	{
		private Point2D p;
		private RectHV rect;
		private Node lb;
		private Node rt;
	}
	
	private Node root;
	
    public boolean isEmpty()
    {
    	return root==null;
    }
    
    public int size()
    {
    	return size();
    }
    
    private int size(Node root)
    {
       
        if(root==null)
        {
            return 0;
        }
        
        else
        {
            return 1+size(root.lb)+size(root.rt);
        }

    }
    
    public void insert(Point2D p)
    {
    	throw new UnsupportedOperationException();
    }
    
    public boolean contains(Point2D p)
    {
    	throw new UnsupportedOperationException();
    }

    public void draw(Canvas canvas)
    {
    	// Use canvas to draw your points and dividing lines
    	//
    	// For points, use these calls:
        //    canvas.setPenRadius(.01);
    	//    canvas.setPenColor(Color.BLACK);
    	//    canvas.point(put your parameters here)
    	//
    	// For dividing lines, use these calls:
    	//    canvas.setPenRadius(.002);
    	//	  canvas.setPenColor(Color.RED); (for vertical dividing lines)
    	//	  canvas.setPenColor(Color.BLUE); (for horizontal dividing lines)
    	//    canvas.line(put your parameters here)


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