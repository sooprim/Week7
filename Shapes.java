package shapes;

interface shape2d
{
	abstract void parameters();
	abstract float area();
    abstract float perimeter();
}
interface shape3d 
{    	
	abstract float volume();
}

class Triangle implements shape2d
{
	int sidea, sideb, sidec, height;	
	Triangle (int a, int b, int c, int h)
	{        
		sidea = a;
		sideb = b;
		sidec = c;
		height = h;
		System.out.println ("new triangle created");    
	}
	public float  perimeter()
	{ 
		return sidea + sideb + sidec;
	}
	
	public void parameters ()
	{ 
		 System.out.println ("side a: "+ sidea + ", side b: " + sideb + ", side c: " + sidec);		
	}
	public float area ()
	{ 
		return sidea*height/2;
	} 
	public boolean rectangular ()
	{ 
		if (sidea*sidea+sideb*sideb==sidec*sidec)
		return true;
		else
		return false;	
	}
}
class Sphere implements shape2d, shape3d
{ 
	int radius;
	Sphere (int r )
	{        
		radius=r;
		System.out.println ("new sphere created");    
	}
	
	public void parameters ()
	{ 
	 System.out.println ("radius: "+ radius);	 		
	}
	public float perimeter() 
	{
		return 0; 
	}
	
	public float area () 
	{ 
		return (float)Math.PI*4*radius*radius;		
	}
	public float volume () 
	{
		return (float)Math.PI*radius*radius*radius*((float) 4/3);		
	}
}

public class Shapes 
{    
	public static void main (String[] XXX) 
	{   
		Triangle t1 = new Triangle(3,5,6,3);
		Sphere s1 = new Sphere(4);
		shape2d t2 = new Triangle(8,2,10,16);
		shape2d s2 = new Sphere(3);
		shape3d s3 = new Sphere(7);
		
		//t1
		System.out.println("\ntriangle 1:");
		t1.parameters();
		System.out.println("area, perimeter, rectangular");
		System.out.println(t1.area() + ", " + t1.perimeter() + ", " + t1.rectangular());
	
		//s1
		System.out.println("\nsphere 1:");
		s1.parameters();
		System.out.println("area, perimeter, volume");
		System.out.println(s1.area() + ", " + s1.perimeter() + ", " + s1.volume());
	
		//t2
		System.out.println("\ntriangle 2:");
		t2.parameters();
		System.out.println("area, perimeter, rectangular");
		System.out.println(t1.area() + ", " + t1.perimeter() + ", " + ((Triangle)t2).rectangular());
		
		//s2
		System.out.println("\nsphere 2:");
		s2.parameters();
		System.out.println("area, volume");
		System.out.println(s1.area() + ", " +((Sphere)s2).volume());
		
		//s3
		System.out.println("\nsphere 3:");
		((Sphere)s3).parameters();
		System.out.println("area, perimeter, volume");
		System.out.println(((shape2d)s3).area() + ", " + ((shape2d)s3).perimeter() + ", " + s3.volume());
        }
}
