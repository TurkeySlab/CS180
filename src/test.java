import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class test {
	public static void main( String args[] ) throws IOException
	{
		Course c = new Course("yea", new Professor("a", 1000, "j"));
		
		try {
			c.dropStudent(null);
		} catch (DropFromCourseException e) {
			// TODO Auto-generated catch block
			System.out.println("j");
		}
	
	}
}
