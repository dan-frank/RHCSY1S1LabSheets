import java.util.*;
import java.io.*;

class FictionUniversal
{
	public static void main (String[] args)
	{

		ArrayList<ArrayList<String>> nodes = new ArrayList<ArrayList<String>>();

		try
		{
			Scanner in = new Scanner(new File("FictionFile2.txt"));
			while (in.hasNext())
			{
				String fileLine = in.nextLine();
				String[] splitLine = fileLine.split(",");
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(splitLine[0]);
				temp.add(splitLine[1]);
				if (splitLine.length > 3)
				{
					temp.add(splitLine[2]);
					temp.add(splitLine[3]);
					temp.add(splitLine[4]);
					temp.add(splitLine[5]);
				}
				nodes.add(temp);
			}
		}
		catch (Exception el)
		{
		    System.err.println("File read error " + el.getMessage());
		}

		boolean game = true;
		int j = 0;

		while (game)
		{
			System.out.println(nodes.get(j).get(1));
			if (nodes.get(j).size() > 2)
			{
				System.out.println("Choose " + nodes.get(j).get(2) + " (1) or " + nodes.get(j).get(4) + " (2)");
				Scanner gamein = new Scanner(System.in);
				int option = gamein.nextInt();

				switch(option)
				{
					case 1:
						j = Integer.parseInt(nodes.get(j).get(3));
						break;
					case 2:
						j = Integer.parseInt(nodes.get(j).get(5));
						break;
					default:
						System.out.println("Enter either 1 or 2");
				}
			}
			else
			{
				game = false;
			}
		}
		
	}
}
		
