import java.io.*;
import java.util.Vector;
public class Main {

	public static void main(String[] args) throws IOException 
	{
		 
	        WordPriorityQueue check = new WordPriorityQueue();
			File file = new File("test.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String readInLine;
			String singleLine = "";
			int count = 0;
			while((readInLine = br.readLine()) != null)
			{
				singleLine = singleLine + readInLine + " ";	
			}
			String[] arrString = singleLine.split(" ");
		    for(int i=0; i<arrString.length; i++)
		    {
		    	String yo = arrString[i];
		    	Word test = new Word(yo, 1, i+1);
		    	check.enqueue(test);
		    	count++;
		    }
		    check.print();
		    
		    Vector<Word> test = new Vector<Word>();
		    for(int i=0; i<count; i++)
		    {
		    	test.addElement(check.getAtIndex(i));
		    }

		    for (int gap = test.size() / 2; gap > 0; gap /= 2) 
		    {
		        for (int i = gap; i < test.size(); i++) 
		        {
		            int key = test.get(i).getFirstLocation();
		            int jee = test.get(i).getCount();
		            String hee = test.get(i).getValue();
		            int j = i;
		            while (j >= gap && test.get(j-gap).getFirstLocation() > key) 
		            {
		                test.get(j).setFirstLocation(test.get(j-gap).getFirstLocation());
		                test.get(j).setValue(test.get(j-gap).getValue());
		    			test.get(j).setCount(test.get(j-gap).getCount());
		                j -= gap;
		            }
		            test.get(j).setFirstLocation(key);
		            test.get(j).setValue(hee);
		            test.get(j).setCount(jee);
		            
		            }
		    }
		    int current = test.get(0).getFirstLocation();
		    boolean found = false;
		    System.out.println(test.get(0).getValue() + " occurred " + test.get(0).getCount() + " time(s) and its first location in the list was " + 
	    		    test.get(0).getFirstLocation());
		    for(int i=0; i<test.size(); i++)
		    {
		        if (current == test.get(i).getFirstLocation() && !found) 
		        {
		            found = true;
		        } 
		        else if (current != test.get(i).getFirstLocation()) 
		        {
			    	System.out.println(test.get(i).getValue() + " occurred " + test.get(i).getCount() + " time(s) and its first location in the list was " + 
			    		    test.get(i).getFirstLocation());
		            current = test.get(i).getFirstLocation();
		        }
		    }
	    }
}

