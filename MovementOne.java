import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class MovementOne {

	public static ArrayList<ArrayList<TempNote>> generate(ArrayList<Insturment> insturments){

		ArrayList<ArrayList<TempNote>> mvmtOne = new ArrayList<>();
		
		int totalParts = insturments.size();

		for(int i = 0; i< totalParts; i++){
			mvmtOne.add(new ArrayList<TempNote>());
		}
		//Add all the notes to make it music
		int totalLength = 16*32;

		for(int i = 0; i< totalParts; i ++){

			for(int j = 0; j < 2*i; j ++){
				mvmtOne.get(i).add(new TempNote(-1,16));
			}
			mvmtOne.get(i).addAll(genMusic(TempNote.dur(mvmtOne.get(i)), totalLength));

			mvmtOne.get(i).get(i*2).message +="\\mp ^\"Like Raindrops\" ";
			while(TempNote.dur(mvmtOne.get(i))>totalLength){
				mvmtOne.get(i).remove(mvmtOne.get(i).size()-1);
			}
		}
		//add Harmonic Shifts
		int index = ThreadLocalRandom.current().nextInt(2*16*4, totalLength/2);
		index = (index/8) * 8;
		for(int i = 0; i <totalParts; i ++){
			if(TempNote.get(mvmtOne.get(i),index).tempValue != -1){
				TempNote.get(mvmtOne.get(i),index).message +="\\mp";
				TempNote.insert(mvmtOne.get(i),new TempNote(1,4),index);
				TempNote.insert(mvmtOne.get(i),new TempNote(2,4,"\\mf"),index);
			}else{
				mvmtOne.get(i).addAll(genMusic(TempNote.dur(mvmtOne.get(i)), totalLength+8));
			}
		}
		index = ThreadLocalRandom.current().nextInt(index+16, totalLength-16*8);
		index = (index/8) * 8;
		for(int i = 0; i <totalParts; i ++){
			if(TempNote.get(mvmtOne.get(i),index).tempValue != -1){
				TempNote.get(mvmtOne.get(i),index).message +="\\mp";
				TempNote.insert(mvmtOne.get(i),new TempNote(3,4),index);
				TempNote.insert(mvmtOne.get(i),new TempNote(2,4,"\\mf"),index);
			}else{
				mvmtOne.get(i).addAll(genMusic(TempNote.dur(mvmtOne.get(i)), totalLength+8));
			}
		}
		index = ThreadLocalRandom.current().nextInt(totalLength-16*8, totalLength-1);
		index = (index/16) * 16;
		for(int i = 0; i <totalParts; i ++){
			if(TempNote.get(mvmtOne.get(i),index-1).tempValue != -1){
				TempNote.get(mvmtOne.get(i),index).message +="\\sp";
				TempNote.insert(mvmtOne.get(i),new TempNote(3,1,""),index);
				TempNote.insert(mvmtOne.get(i),new TempNote(2,1),index);
				TempNote.insert(mvmtOne.get(i),new TempNote(0,1),index);
				TempNote.insert(mvmtOne.get(i),new TempNote(1,1),index);
				TempNote.insert(mvmtOne.get(i),new TempNote(2,8),index);
				TempNote.insert(mvmtOne.get(i),new TempNote(1,8,"\\f\\<"),index);
			}else{
				mvmtOne.get(i).addAll(genMusic(TempNote.dur(mvmtOne.get(i)), totalLength+16));
			}
		}

		for(int i = 0; i < totalParts; i ++){
			while(TempNote.dur(mvmtOne.get(i))>totalLength+32){
				mvmtOne.get(i).remove(mvmtOne.get(i).size()-1);
				//System.out.println("culling");
			}
		}

		//add Ending note
		for(int i = 0; i <totalParts; i ++){
			mvmtOne.get(i).add(new TempNote(1,4));
			mvmtOne.get(i).add(new TempNote(-1,4));
			mvmtOne.get(i).add(new TempNote(-1,8));
			mvmtOne.get(i).add(0, new TempNote("\\tempo \"Adagio\" 4 = 60"));
		}

		return mvmtOne;
	}

	private static ArrayList<TempNote> genMusic(int startingProgress, int totalLength){
		ArrayList<TempNote> ret = new ArrayList<>();
		//System.out.println("Called:"+startingProgress+" "+totalLength);
		while(TempNote.dur(ret)+startingProgress<totalLength){
			double progress = TempNote.dur(ret)/(double) totalLength;
			if(Math.random()*2< progress){
				ret.add(new TempNote(0,1,"("));
				ret.add(new TempNote(1,1,")"));
			}else{
				ret.add(new TempNote(1,2,"-."));
			}
			if(Math.random()>.5){
				ret.add(new TempNote(1,2,"-."));
			}
			if(Math.random()*2< progress){
				ret.add(new TempNote(3,1,"("));
				ret.add(new TempNote(2,1,")"));
			}else{
				ret.add(new TempNote(2,2,"-."));
			}if(Math.random()>.5){
				ret.add(new TempNote(2,2,"-."));
			}
		}
		return ret;	
	}

}