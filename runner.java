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
		int key = (int) Integer.parseInt(args[1]);
		int ptType = (int) Integer.parseInt(args[2]);
		int stType = (int) Integer.parseInt(args[3]);
		boolean analyze = (boolean) (Integer.parseInt(args[4])==1);//true if ==1, false(no writing) if 2

		if(key < 49 || key > 60){
			key = 55
		}

		int keyType = 0;
		if((key%12 == 0 || key%12 == 5 || key%12 == 7)){
			keyType = 0;
		}else if(key%12 == 2 || key%12 == 4 ||key%12 == 9){
			keyType = 1;
		}else if(key% 12== 11||key%12 == 6 ){
			keyType = 3;
		}else{
			keyType = 2;
		}
		System.out.println("Key type: "+ keyType);

		ArrayList<Insturment> insturments = new ArrayList<>();
		insturments.add(new Insturment("RH","","\"treble\"",false,false));
		insturments.add(new Insturment("LH","","\"bass\"",false,false));

		ArrayList<Idea> oneTemp = MovementOne.generate(key,keyType,ptType,stType,analyze);
		ArrayList<ArrayList<Note>> pianoPart = Idea.toNotes(oneTemp);

		pianoPart.get(0).add(0,new Note("\\key "+Note.stringFromMidiNumber(key,keyType)+" \\major \\partial 8 { r8 }"));
		if(key<60){
			pianoPart.get(1).add(0,new Note("\\key "+Note.stringFromMidiNumber(key,keyType)+" \\major \\partial 8 { "+Note.stringFromMidiNumber(key,keyType)+"'8 }"));			
		}else{
			pianoPart.get(1).add(0,new Note("\\key "+Note.stringFromMidiNumber(key,keyType)+" \\major \\partial 8 { "+Note.stringFromMidiNumber(key,keyType)+"''8 }"));
		}
		pianoPart.get(1).add(0,new Note("\\tempo Allegro 4 = 112"));
		String rhFinal = Note.toString(pianoPart.get(1));
		String lhFinal = Note.toString(pianoPart.get(0));


		String[] labels = {"P.T.\" ^\"Exposition","","S.T.","","Standing on V","","P.T.\" ^\"Recapitulation","","S.T.","","","PAC"};
		int index = 0;
		while(rhFinal.indexOf("\n%lab\n")!= -1){
			int ind = rhFinal.indexOf("\n%lab\n");
			rhFinal = rhFinal.substring(0,ind)+labels[index]+rhFinal.substring(ind+6);
			index++;
		}

		String[] keys = {"G:","","D:","","","I / G:V","(G:)","","","","I","","","","","","",""};
		index = 0;
		while(lhFinal.indexOf("\n%key\n")!= -1){
			int ind = lhFinal.indexOf("\n%key\n");
			lhFinal = lhFinal.substring(0,ind)+keys[index]+lhFinal.substring(ind+6);
			index++;
		}

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
