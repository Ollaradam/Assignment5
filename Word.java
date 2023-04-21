
public class Word {

	private String value;
	private int count = 0;
	private int firstLocation;	
	String data;
	int priority;
	public Word(String s, int newCount, int newFirstLocation) 
	{
		setValue(s);
		setCount(newCount);
		setFirstLocation(newFirstLocation);
		data = s;
		if (startsWithVowel(data))
        {
			priority = 2;
        }
        else if (startsWithLetter(data)) 
        {
        	priority = 1;
        } 
        else  
        {
        	priority = 0;
        }

	}
	
	public void setValue(String newValue)
	{
		this.value = newValue;
	}
	
	public void setCount(int newCount)
	{
		this.count = newCount;
	}
	
	public void setFirstLocation(int newLocation)
	{
		this.firstLocation = newLocation;
	}
	
	public String getValue()
	{
		return value;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public int getFirstLocation()
	{
		return firstLocation;
	}
	
	public static boolean startsWithVowel(String s)
	{
		if(s==null || s==" ")
		{
			return false;
		}
		else
		{
			char ch = s.charAt(0);
			if((ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u')
					 || (ch == 'A') || (ch == 'E') || (ch == 'I') || (ch == 'O') || (ch == 'U'))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
	
	public static boolean startsWithLetter(String s)
	{
		if(s==null || s==" ")
		{
			return false;
		}
		else
		{
			char ch = s.charAt(0);
			if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	}
}
