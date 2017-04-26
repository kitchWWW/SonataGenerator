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

		String  timeStamp = args[0];
		ArrayList<Integer> intervals = new ArrayList<>();
		intervals.add(0);
		intervals.add(1);
		intervals.add(4);

		ArrayList<Insturment> insturments = new ArrayList<>();
		insturments.add(new Insturment("RH","","\"treble\"",false,false));
		insturments.add(new Insturment("LH","","\"bass\"",false,false));

		ArrayList<Idea> oneTemp = MovementOne.generate();
		ArrayList<ArrayList<Note>> pianoPart = Idea.toNotes(oneTemp);
		pianoPart.get(1).add(0,new Note("\\tempo 4 = 112"));
		pianoPart.get(0).add(0,new Note("\\key g \\major"));
		pianoPart.get(1).add(0,new Note("\\key g \\major"));
		String rhFinal = Note.toString(pianoPart.get(1));
		String lhFinal = Note.toString(pianoPart.get(0));

		//System.out.println(rhFinal);
		//System.out.println(lhFinal);



		//System.out.println(oneFinal);

		ArrayList<String> finalPart = new ArrayList<>();
		finalPart.add(rhFinal);
		finalPart.add(lhFinal);
		buildParts(timeStamp,"PianoSonata", finalPart,insturments);
		
		//System.out.println("Done?");

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
			File file = new File("templates/piano.ly");
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

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("I guess we give up now...");
		}
	}

}
