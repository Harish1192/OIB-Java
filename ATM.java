import java.util.*;
class atmInterface
{
	double balance;
	int Account;
	int prevt;
	String uPin;
	String uId;
	int n=0;
	atmInterface(){}
	atmInterface(String a,String b)
	{	
		this.uId=a;
		this.uPin=b;
	}	
	void validate()
	{
		System.out.println("Welcome ");
		System.out.println("Enter User Id: ");
		Scanner s=new Scanner(System.in);
		String id=s.nextLine();
                        System.out.println("Enter User Pin");
                        String pin=s.next();
		if(id.equals(uId) && pin.equals(uPin))
		{
		           System.out.println("Login Success");
			Menu();
		}
		else
		{
			
			System.out.println("Incorrect ID/PIN . Try Again");
			if(n<3) //no of attempts allowed
			{
				n++;
				validate();
			}
		}
	}
	void deposit(int amt)
	{
		if(amt!=0)
		{
			balance=balance+amt;
			prevt=amt;
		}
	}
	void withdraw(int amt)
	{
		if(this.balance > amt)
		{
			balance= balance-amt;
			prevt= -amt;	
		}
		else
		{
			System.out.println("Insufficient Balance");
		}
	}
	void getPrevTransaction()
	{
		if(prevt>0)
		{
			System.out.println("Deposit: "+prevt);
		}
		else if(prevt<0)
		{
			System.out.println("Withdraw: "+Math.abs(prevt));	
		}
		else
		{
			System.out.println("No Transaction Occured");
		}
	}
	public void transfer(double amt,atmInterface a)
	{
		if(this.balance<amt)
		{
			System.out.println("Insufficient Balance");
		}
		else
		{
			this.balance-=amt;
			a.balance+=amt;
			System.out.println("Now" +this.uId +"'s balance is "+ this.balance);
			
		}
	}
	public void Menu()
	{
		int ch;
		Scanner s=new Scanner(System.in);
		System.out.println("Your Id: "+uId);
		do
		{
			System.out.println();
			System.out.println("1. Check Balance");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Previous Transaction");
			System.out.println("5. Transfer");
			System.out.println("6. Exit");
			
			System.out.println("Enter your choice");
			
			ch=s.nextInt();
			System.out.println();
			switch(ch)
			{
				case 1:
					System.out.println("Balance "+balance);
					break;
				case 2:
					System.out.println("Enter amount of deposit: ");
					int amt=s.nextInt();
					deposit(amt);
					break;
				case 3:
					System.out.println("Enter amount of Withdraw: ");
					int wamt=s.nextInt();
					withdraw(wamt);
					break;
				case 4:
					getPrevTransaction();
					break;
				case 5:
					System.out.println("To ");
					atmInterface x=new atmInterface("abc","1000");
					System.out.println(x.uId);
					System.out.println("Amount Transfer");
					double tam=s.nextDouble();
					transfer(tam,x);
					break;
				case 6:
					break;
				default:
					System.out.println("Invalid Choice");
					break;

					
			}
		}while(ch!=6);
	} 
}
public class ATM
{
	public static void main(String args[])
	{
		atmInterface user=new atmInterface("Harish","9999");
		user.validate();
	}
}













