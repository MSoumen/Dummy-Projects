import java.util.*;
import java.io.*;

public class FindMatch{
	private static ArrayList<String> males = new ArrayList<>();
	private static ArrayList<String> females = new ArrayList<>();

	static{
		try{
			File boys = new File("boys.txt"),
				girls = new File("girls.txt");
			Scanner b_readObj = new Scanner(boys);
			Scanner g_readObj = new Scanner(girls);
			while(b_readObj.hasNextLine() && g_readObj.hasNextLine()){
				String b_name = b_readObj.nextLine();
				String g_name = g_readObj.nextLine();
				males.add(b_name);
				females.add(g_name);
			}
			while(b_readObj.hasNextLine()) {String b_name = b_readObj.nextLine(); males.add(b_name);}
			while(g_readObj.hasNextLine()) {String g_name = g_readObj.nextLine(); females.add(g_name);}

			b_readObj.close();
			g_readObj.close();

		}
		catch(FileNotFoundException e){e.printStackTrace();}
	}

	static String getMatch(String name, String sex){
		Random rand = new Random();
		String match;
		int availPeople=0;
		do{
			if(sex.equals("M") || sex.equals("m")){
				availPeople = females.size();
				match = females.get(rand.nextInt(availPeople));
			}
			else{
				availPeople = males.size();
				match = males.get(rand.nextInt(availPeople));
			}
		}while(match.equals(name));
		
		return match.toUpperCase();
	}

	private static void printSlow(String text, int time){
		try{
			for(char c: text.toCharArray()){
				// System.out.print(Character.toUpperCase(c)+"");
				System.out.print(c+"");
				Thread.sleep(time);
			}
		}catch(Exception e){e.printStackTrace();}		
	}

	public static void matchMaking(String name1, String sex){
		String name2;
		char sign=3;
		int dur=350;

		name1 = name1.toUpperCase();
		System.out.println("\n");

		if(sex.equals("M") || sex.equals("m")) sex="M";
		else if(sex.equals("F") || sex.equals("f")) sex="F";

		String match = getMatch(name1, sex);
		printSlow(name1, dur);
		System.out.print("  "+(char)sign+"  ");
		printSlow(match, dur);

		System.out.println("\n\nNow, see "+match+" likes whom . . .\n");
		sex = (sex.equals("M")) ? "F":"M";

		name2 = (getMatch(match, sex));
		printSlow(match, dur);
		System.out.print("  "+(char)sign+"  ");
		printSlow(name2, dur);

		if(name1.equals(name2))System.out.println("\n\n\nWooho.. Its a Match !"+(char)sign);
		else System.out.println("\n\n\nBetter Luck Next Time !"+sign);
	}

	public static void main(String[] args) throws InterruptedException,IllegalArgumentException{
		if(args.length==0){
			System.out.println("Usage: FindMatch your_name your_gender(M/F)");
			throw new IllegalArgumentException("No argument passed!");
		}
		Scanner in = new Scanner(System.in);
		String name1, name2, sex, ch;
		char sign=3;
		int count;
		int dur=100;
		do{
			// System.out.print("\nEnter your name and sex(M/F) : ");
			// name1 = in.next(); 
			// sex = in.next();
			name1 = args[0]; 
			sex = args[1];
			matchMaking(name1, sex);

			System.out.print("\nPlay again?(Y/N): ");
			ch = in.next();
		}while(ch.equals("Y") || ch.equals("y"));

		System.out.println("\nGood Bye!");
	}

}