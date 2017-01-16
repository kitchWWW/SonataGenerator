import java.util.ArrayList;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class runner {

	public static void main(String[] args) {
		//Following should be moved to be taken as arguments
		String  timeStamp = args[0];
		//System.out.println(args[0]);
		//System.out.println(args[1]);
		//System.out.println(args[2]);
		//System.out.println(args[3]);
		//System.out.println(args[4]);
		//System.out.println(args[5]);
		
		//Gson gson = new Gson();
		//Insturment test = gson.fromJson(args[1], Insturment.class);
		ArrayList<Insturment> insturments = new ArrayList<>();
		insturments.add(new Insturment("Guitar","Violin","\"treble\"",false,false,new Integer[]{71,72,74,76}));
		insturments.add(new Insturment("Guitar","Violin","\"treble\"",false,false,new Integer[]{71,72,74,76}));
		insturments.add(new Insturment("Guitar","Violin","\"treble\"",false,false,new Integer[]{71,72,74,76}));
		insturments.add(new Insturment("Guitar","Violin","\"treble\"",false,false,new Integer[]{71,72,74,76}));
		insturments.add(new Insturment("Guitar","Violin","\"treble\"",false,false,new Integer[]{71,72,74,76}));
		insturments.add(new Insturment("Guitar","Violin","\"treble\"",false,false,new Integer[]{71,72,74,76}));
		insturments.add(new Insturment("Guitar","Violin","\"treble\"",false,false,new Integer[]{71,72,74,76}));
		insturments.add(new Insturment("Guitar","Violin","\"treble\"",false,false,new Integer[]{71,72,74,76}));
		insturments.add(new Insturment("Guitar","Violin","\"treble\"",false,false,new Integer[]{71,72,74,76}));


//		 possibleNotes.add(new ArrayList<>(Arrays.asList(71,72,74,76)));
//		 possibleNotes.add(new ArrayList<>(Arrays.asList(65,67,71,72)));
//		 possibleNotes.add(new ArrayList<>(Arrays.asList(62,64,67,69)));
//		 possibleNotes.add(new ArrayList<>(Arrays.asList(59,60,64,65)));

		// possibleNotes.add(new ArrayList<>(Arrays.asList(66,69,70,71)));
		// possibleNotes.add(new ArrayList<>(Arrays.asList(61,63,65,67)));
		// possibleNotes.add(new ArrayList<>(Arrays.asList(50,52,56,58)));
		// possibleNotes.add(new ArrayList<>(Arrays.asList(44,46,49,51)));

//		possibleNotes.add(new ArrayList<>(Arrays.asList(69,72,74,76)));
//		possibleNotes.add(new ArrayList<>(Arrays.asList(64,65,67,69)));
//		possibleNotes.add(new ArrayList<>(Arrays.asList(53,55,57,59)));
//		possibleNotes.add(new ArrayList<>(Arrays.asList(45,48,52,53)));

		ArrayList<ArrayList<TempNote>> oneTemp = MovementOne.generate(insturments);
		
		ArrayList<ArrayList<TempNote>> twoTemp = MovementTwo.generate(insturments,TempNote.strip(oneTemp));

		for(int i = 0; i < insturments.size(); i ++){
			oneTemp.get(i).add(new TempNote("\\bar\"||\" \n \\break \n "));
			oneTemp.get(i).addAll(twoTemp.get(i));
		}
		ArrayList<String> finalParts = tempNotesToParts(oneTemp,insturments);

		buildParts(timeStamp,"EpochMusic", finalParts,insturments);


	}
	private static ArrayList<String> tempNotesToParts(ArrayList<ArrayList<TempNote>> tempNotes,
		ArrayList<Insturment> insturments){
		ArrayList<String> ret = new ArrayList<>();
		for(int i = 0; i < tempNotes.size(); i ++){
			//swap out the temp notes for real ones, then use toString to make it a strin
			ret.add(Note.toString(TempNote.swap(tempNotes.get(i),insturments.get(i))));
		}
		return ret;
	}	

	private static void buildParts(String timeStamp, String title,
		ArrayList<String> parts, ArrayList<Insturment> insturments){
		try {
			ArrayList<String> longParts = new ArrayList<>();
			for(int index = 0; index < insturments.size(); index++){
				String newPart = "";
				File partFile = new File("templates/part.ly");
		        Scanner ps = new Scanner(partFile);
				while (ps.hasNextLine()) {
		            String i = ps.nextLine();

		            if(i.startsWith("%part")){
		            	newPart+= parts.get(index) +"\n";

		            }else if(i.startsWith("%name")){
		            	newPart+= insturments.get(index).name +"\n";

		            }else if(i.startsWith("%clef")){
		            	newPart+= insturments.get(index).staff +"\n";
		            
		            }else if(i.contains("%midi")){
		            	i = i.substring(0,i.indexOf("%midi"));
		            	newPart+= i+""+insturments.get(index).midi +"\"\n";

		            }else{
		            	newPart+=i + "\n";
		            }
		        }
		        longParts.add(newPart);
			}



			String res = "";
			File file = new File("templates/score.ly");
	        Scanner sc = new Scanner(file);

	        while (sc.hasNextLine()) {
	            String i = sc.nextLine();
	            if(i.startsWith("%part")){
	            	i = i.substring(5);
	            	int index = Integer.parseInt(i);
	            	if(index < longParts.size()){
	            		res+= longParts.get(index) +"\n";
	            	}
	            }else if(i.startsWith("%timeStamp")){
	            	res+= timeStamp +"\n";
	            }
	            else{
	            	res+=i + "\n";
	            }
	        }
        	sc.close();
			PrintWriter writer = new PrintWriter("out/"+timeStamp+"/"+title+"Score.ly", "UTF-8");
			writer.println(res);
			writer.close();


			res = "";
			file = new File("templates/parts.ly");
	        sc = new Scanner(file);

	        while (sc.hasNextLine()) {
	            String i = sc.nextLine();
	            if(i.startsWith("%part")){
	            	i = i.substring(5);
	            	int index = Integer.parseInt(i);
	            	if(index < longParts.size()){
	            		res+= longParts.get(index) +"\n";
	            	}
	            }else if(i.startsWith("%timeStamp")){
	            	res+= timeStamp +"\n";
	            }
	            else{
	            	res+=i + "\n";
	            }
	        }
        	sc.close();
			writer = new PrintWriter("out/"+timeStamp+"/"+title+"Parts.ly", "UTF-8");
			writer.println(res);
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("I guess we give up now...");
		}
	}

}
