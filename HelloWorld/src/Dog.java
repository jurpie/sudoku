
public class Dog {
	public String name;
	
	public Dog(String name)
	{
		this.name = name;
	}

	
	void bark(){
		System.out.print(name + ": woof\n");
	}
	
	void dig(){
		System.out.print("lalala\n");
	}
}