
public class test {
	public static void main( String args[] )
	{
		Teacher t = new Teacher("egg", 100000, "eh");
		Teacher t1 = t;
		
		System.out.println(t.getID());
		System.out.println(t1.getID());
		
	
	
	}
}
