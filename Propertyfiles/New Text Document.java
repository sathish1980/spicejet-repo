package name;

import jan2021.javabasics22122020;

public class class2   {
	
	javabasics22122020 js= new javabasics22122020();
	public void method2(int age)
	{
		//int age=19;
		//int sa=js.A;
	 if(age>=18) 
		{
		System.out.println("You ar elegible to vote");	
		 if(age>60)
			{
				System.out.println("You ar elegible for senior citizen");	
				
				if(age>80)
				{
					System.out.println("You ar elegible for super senior citizen");
				}
			}
			
		}
		else if(age >=16)
		{
		System.out.println("You will be elegible to vote in 2 yeaars");
		}
		else if(age >=14)
		{
		System.out.println("You will be elegible to vote in 4 yeaars");
		}
		else
		{
			System.out.println("You are not elegible to vote");	
		}
		
		//System.out.println(sa);
	}
	
	public void switchstatement(int age)
	{
		switch(age)
		{
		case 18:
			System.out.println("You are  elegible to vote");
		break;
		case 45:
			System.out.println("You are  elegible to vote");
		break;
		case 65:
			System.out.println("You are  elegible for senior citizen vote");
		break;
		case 89:
			System.out.println("You are  elegible for super senior citizen vote");
		break;
		default :
			System.out.println("You are  not elegible to vote");
			break;
		
		
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		class2 c2= new class2();
		c2.switchstatement(89);

	}

}
package name;

import jan2021.javabasics22122020;

public class class2   {
	
	javabasics22122020 js= new javabasics22122020();
	public void method2(int age)
	{
		//int age=19;
		//int sa=js.A;
	 if(age>=18) 
		{
		System.out.println("You ar elegible to vote");	
		 if(age>60)
			{
				System.out.println("You ar elegible for senior citizen");	
				
				if(age>80)
				{
					System.out.println("You ar elegible for super senior citizen");
				}
			}
			
		}
		else if(age >=16)
		{
		System.out.println("You will be elegible to vote in 2 yeaars");
		}
		else if(age >=14)
		{
		System.out.println("You will be elegible to vote in 4 yeaars");
		}
		else
		{
			System.out.println("You are not elegible to vote");	
		}
		
		//System.out.println(sa);
	}
	
	public void switchstatement(int age)
	{
		switch(age)
		{
		case 18:
			System.out.println("You are  elegible to vote");
		break;
		case 45:
			System.out.println("You are  elegible to vote");
		break;
		case 65:
			System.out.println("You are  elegible for senior citizen vote");
		break;
		case 89:
			System.out.println("You are  elegible for super senior citizen vote");
		break;
		default :
			System.out.println("You are  not elegible to vote");
			break;
		
		
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		class2 c2= new class2();
		c2.switchstatement(89);

	}

}
