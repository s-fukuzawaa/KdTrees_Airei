import java.awt.Color;


public class KdTree implements PointContainer
{
	private static class Node
	{
		private Point2D p;
		private RectHV rect=new RectHV(0,0,1,1);
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
  
    
    public void insert(Point2D p)
    {
    	if(p==null)
    	{
    		throw new java.lang.NullPointerException();
    	}
    	insert(p,root, true);
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
    				insertrect(cur.lb,cur,true, xy);
    				//if on cur's left side=true, cur's right side=false
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
    				insertrect(cur.rt,cur,false,xy);
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
    				insertrect(cur.lb,cur,true,xy);

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
    				insertrect(cur.rt,cur,false,xy);

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
    
    private void insertrect(Node added, Node cur, boolean lorr, boolean xyofcur)
    {
    	if(lorr==true)
    	{
    		if(xyofcur==true)
    		{
    			added.rect=new RectHV(cur.rect.xmin(),cur.rect.ymin(),cur.p.x(),cur.rect.ymax());
    		}
    		else
    		{
    			added.rect=new RectHV(cur.rect.xmin(),cur.rect.ymin(),cur.rect.xmax(),cur.p.y());
    		}
    	}
    	else
    	{
    		if(xyofcur==true)
    		{
    			added.rect=new RectHV(cur.p.x(),cur.rect.ymin(), cur.rect.xmax(), cur.rect.ymax());
    		}
    		else
    		{
    			added.rect=new RectHV(cur.rect.xmin(),cur.rect.ymin(), cur.rect.xmax(), cur.p.y());
    		}
    	}
    	
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
    	if(cur.p.x()==p.x()&&cur.p.y()==p.y())
    	{
    		return true;
    	}
    	
    	if(xy==true)
    	{
    		if(p.x()<cur.p.x())
        	{
    			
    			if(cur.lb==null)
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
    			if(cur.rt==null)
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
    			if(cur.lb==null)
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
    			if(cur.rt==null)
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
        //canvas.setPenRadius(.01);
    	//canvas.setPenColor(Color.BLACK);
    	//canvas.point();
    	//
    	// For dividing lines, use these calls:
    	//canvas.setPenRadius(.002);
    	//canvas.setPenColor(Color.RED); //for vertical dividing lines)
    	//canvas.setPenColor(Color.BLUE); //(for horizontal dividing lines)
    	
    	//xory true for x
    	//canvas.line(added.x(), addedrect.ymin(), added.x(), addedrect.ymax());
       draw(canvas, root, true);


        // Don't forget to remove this!
    }
    private void draw(Canvas canvas, Node cur, boolean xy)
    {
    	if(cur==null)
    	{
    		return;
    	}
    	else
    	{
    		if(xy==true)
    		{
    			canvas.setPenRadius(.01);
    	    	canvas.setPenColor(Color.BLACK);
    			canvas.point(cur.p.x(), cur.p.y());
    			canvas.setPenRadius(.002);
    	    	canvas.setPenColor(Color.RED); //for vertical dividing lines)
    	    	//canvas.setPenColor(Color.BLUE); 
        		canvas.line(cur.p.x(), cur.rect.ymin(), cur.p.x(), cur.rect.ymax());
            	draw(canvas, cur.lb,false);
            	draw(canvas, cur.rt,false);
    		}
    		else
    		{
    			canvas.setPenRadius(.01);
    	    	canvas.setPenColor(Color.BLACK);
    			canvas.point(cur.p.x(), cur.p.y());
    			canvas.setPenRadius(.002);
    	    	//canvas.setPenColor(Color.RED); //for vertical dividing lines)
    	    	canvas.setPenColor(Color.BLUE); 
        		canvas.line(cur.rect.xmin(), cur.p.y(), cur.rect.xmax(), cur.p.y());
            	draw(canvas, cur.lb,true);
            	draw(canvas, cur.rt,true);
    		}
    		
        	

    	}
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
    	test.insert(new Point2D(0.0,0.8));
    	test.insert(new Point2D(0.9,0.7));
    	test.insert(new Point2D(0.5,0.3));
    	test.insert(new Point2D(0.1,0.1));
    	test.insert(new Point2D(0.9,0.4));
    	test.insert(new Point2D(0.7,0.7));
    	


    }
}