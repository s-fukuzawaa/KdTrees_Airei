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
    	if(root==null)
    	{
    		throw new java.lang.NullPointerException();
    	}
    	
    	return size(root);
    }
    
    private int size(Node cur)
    {
       
        if(cur==null)
        {
    		return 0;
        }
        
        else
        {
            return 1+size(cur.lb)+size(cur.rt);
        }

    }
    
    private void insert(Point2D p, Node cur, boolean xy)
    {
    	Node n= new Node();
    	n.p=p;
    	if(cur==null)
    	{
    		root=n;
    		return;
    	}
    	if(xy==true)
    	{
    		if(p.x()<cur.p.x())
        	{
    			if(cur.lb==null)
    			{
    				cur.lb=n;
    				return;
    			}
    			else
    			{
    				insert(p,cur.lb,false);
    				return;
    			}
        	}
    		
    		else
    		{
    			if(cur.rt==null)
    			{
    				cur.rt=n;
    				return;
    			}
    			else
    			{
    				insert(p,cur.rt,false);
    				return;
    			}
    		}
    	}
    	else
    	{
    		if(p.y()<cur.p.y())
        	{
    			if(cur.lb==null)
    			{
    				cur.lb=n;
    				return;
    			}
    			else
    			{
    				insert(p,cur.lb,true);
    				return;
    			}
        	}
    		
    		else
    		{
    			if(cur.rt==null)
    			{
    				cur.rt=n;
    				return;
    			}
    			else
    			{
    				insert(p,cur.rt,true);
    				return;
    			}
    		}
    	}
    	
    }
    
    public void insert(Point2D p)
    {
    	if(p==null)
    	{
    		throw new java.lang.NullPointerException();
    	}
    	
    	insert(p,root, true);
    }
    
    public boolean contains(Point2D p)
    {
    	if(p==null||root==null)
    	{
    		throw new java.lang.NullPointerException();
    	}
    	return contains(p,root,true);
    }
    private boolean contains(Point2D p, Node cur, boolean xy)
    {
    	
    	
    	if(xy==true)
    	{
    		if(p.x()<cur.p.x())
        	{
    			if(cur.lb.p.x()==p.x()&&cur.lb.p.y()==p.y())
    			{
    				return true;
    			}
    			else if(cur.lb==null)
    			{
    				return false;
    			}
    			else
    			{
    				return contains(p,cur.lb,false);
    				
    			}
        	}
    		
    		else
    		{
    			if(cur.rt.p.x()==p.x()&&cur.rt.p.y()==p.y())
    			{
    				return true;
    			}
    			else if(cur.rt==null)
    			{
    				return false;
    			}
    			else
    			{
    				return contains(p,cur.rt,false);
    				
    			}
    		}
    	}
    	else
    	{
    		if(p.y()<cur.p.y())
        	{
    			if(cur.lb.p.x()==p.x()&&cur.lb.p.y()==p.y())
    			{
    				return true;
    			}
    			else if(cur.lb==null)
    			{
    				return false;
    			}
    			else
    			{
    				return contains(p,cur.lb,true);
    				
    			}
        	}
    		
    		else
    		{
    			if(cur.rt.p.x()==p.x()&&cur.rt.p.y()==p.y())
    			{
    				return true;
    			}
    			else if(cur.rt==null)
    			{
    				return false;
    			}
    			else
    			{
    				return contains(p,cur.rt,true);
    			}
    		}
    	}
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
    
    public static void main(String[] args)
    {
    	KdTree test= new KdTree();
    	test.insert(new Point2D(0.3,0.4));
    	test.insert(new Point2D(0.4,0.5));
    	/*test.insert(new Point2D(3,4));
    	test.insert(new Point2D(3,4));
    	test.insert(new Point2D(3,4));
    	test.insert(new Point2D(3,4));
    	test.insert(new Point2D(3,4));
    	test.insert(new Point2D(3,4));*/
    	System.out.print(test.size());

    }
}