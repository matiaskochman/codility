package pruebas.outcodility;

import java.awt.Rectangle;

import org.junit.Test;
public class AreaOfIntersection {

	@Test
	public void test(){
		areaOfIntersection(0, 2, 5, 10, 3, 1, 20, 15);
	}
	
	public int areaOfIntersection(int k, int l, int m, int n, int p, int q, int r, int s){
		
		int rect1_low = l;
		int rect1_left = k;
		int rect1_top = n;
		int rect1_right = m;
		
		int rect2_low = q;
		int rect2_left = p;
		int rect2_top = s;
		int rect2_right = r;
		
		Point a = new Point(k,n);
		Point b = new Point(k,l);
		Point c = new Point(m,n);
		Point d = new Point(m,l);
		
		//Rectangle r1 = new Rectangle(k,n,m-k,n-l);
		Rectangle r1 = new Rectangle(k,l,m-k,n-l);
		
		double w1 = r1.getMaxX();
		double w2 = r1.getMaxY();
		double w3 = r1.getMinX();
		double w4 = r1.getMinY();
		
		
		//Rectangle r2 = new Rectangle(p,s,r-p,s-q);
		Rectangle r2 = new Rectangle(p,q,r-p,s-q);
		
		/*
		a = new Point(p,s);
		b = new Point(p,q);
		c = new Point(r,s);
		d = new Point(r,q);
		*/
		
		//Rectangle r2 = new Rectangle();
		
		//r2.isInterceptedBy(r1);
		
		return 0;
	}
	
	class Point{
		int x;
		int y;
		
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	/*
	class Rectangle{
		Point a;
		Point b;
		Point c;
		Point d;
		
		public Rectangle(Point a,Point b,Point c,Point d){
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
		}
		
		public boolean isInterceptedBy(Rectangle r1){
			
			boolean b1 = containsPoint(r1.a);
			boolean b2 = containsPoint(r1.b);
			boolean b3 = containsPoint(r1.c);
			boolean b4 = containsPoint(r1.d);
			
			return false;
		}
		
		public boolean containsPoint(Point p){
			
			if((this.a.y > p.y)&&(this.a.x < p.x)){
				if((this.b.y < p.y)&&(this.b.x < p.x)){
					if((this.c.y > p.y)&&(this.c.x > p.x)){
						if((this.d.y < p.y)&&(this.d.x > p.x)){
							return true;
						}
					}
				}
			}
			
			return false;
		}
		
	}
	*/
}