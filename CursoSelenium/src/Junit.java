import org.junit.Assert;
import org.junit.Test;

public class Junit {
	@Test
	public void teste()
	{
		int a = 2;
		int b = 3;
		System.out.println(a+b);
	}
	
	
	@Test
	public void testeNumero()
	{
		int a = 2;
		int b = 3;
		Assert.assertEquals(5, a+b);
	}
	
	@Test
	public void testeString(){
		String nome = "Glaucia Pelaquin";
		Assert.assertEquals("Glaucia Pelaquin", nome);
		
	}
	
	@Test
	public void testesperaumverdadeiro() {
		Assert.assertTrue(true);
	}
	
	@Test
	public void testesperaumverdadeiro2() {
		Assert.assertTrue(false);
	}
	
	@Test
	public void testesperaumfalso() {
		Assert.assertFalse(false);
	}
	
	@Test
	public void testesperaumfalso2() {
		Assert.assertFalse(true);
		
	}
	
	
	
	
	

}
