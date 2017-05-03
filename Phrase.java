import java.util.ArrayList;

public class Phrase {
	public int melodyCorrection;
	public boolean open;
	public boolean pac;
	public ArrayList<Block> blocks;
	//Some sort of ornamentation information
	public Phrase(int melodyOctave){
		this.blocks = new ArrayList<>();
		this.open = false;
		this.pac = false;
		this.melodyCorrection = 12*melodyOctave;
	}

	public String toString(){
		return "("+blocks+")";
	}

	public static ArrayList<ArrayList<Note>> toNotes(Phrase work, Style s,int k){
		ArrayList<Note> lh = new ArrayList<>();
		ArrayList<Note> rh = new ArrayList<>();
		int key = k;
		
		for(int j = 0; j < work.blocks.size(); j ++){
			Block b = work.blocks.get(j);
			ArrayList<Note> tempLH = new ArrayList<>();
			tempLH.addAll(s.bass(key, b.baseNote, b.highNote, b.midNote, b.duration, work.open && j == work.blocks.size()-1, work.pac,b.basLily));
			lh.addAll(tempLH);

			ArrayList<Note> tempRH = new ArrayList<>();
			if(j == 0){
				tempRH = s.melody(key, b, 0, work.blocks.get(1).melodyNote, false,true,work.melodyCorrection,false);
			}else if(j == work.blocks.size()-1){
				tempRH = s.melody(key, b, work.blocks.get(j-1).melodyNote, 0, true,false,work.melodyCorrection,work.open);
			}else{
				tempRH = s.melody(key, b, work.blocks.get(j-1).melodyNote, work.blocks.get(j+1).melodyNote, true, true,work.melodyCorrection,false);
			}
			rh.addAll(tempRH);
		}

		ArrayList<ArrayList<Note>> ret = new ArrayList<>();
		ret.add(lh);
		ret.add(rh);
		return ret;

	}

}