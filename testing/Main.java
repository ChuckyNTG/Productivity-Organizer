import java.util.ArrayList;

public class Main
{
	
	public static void main(String[] args)
	{
		ArrayList<Person> p1 = new ArrayList<Person>();
		ArrayList<Person> p2 = new ArrayList<Person>();
		Person guy = new Person("charles",20);
		p1.add(guy);
		p1.get(0).print();
		p2.add(p1.get(0));
		p2.get(0).print();
		
		p1.get(0).setAge(30);
		p2.get(0).print();
		

	}

}
