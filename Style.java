import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class Style{

	public int relate = 0;	//-1 = prev note, 0 = self, 1 = next
	public int offset = 0;	//-1 ,0,1 (direction from current)
	public int firstDuration = 1;//1,2,3
	public int numbNotes = 0;
	public int bassStyle = 0;
	//Integer[] notes = {0,2,4,5,7,9,11};
	ArrayList<Integer> realNotes = new ArrayList<>();//Arrays.asList(notes)


	public Style(int numb){
		relate= ThreadLocalRandom.current().nextInt(-1,2);
		offset= ThreadLocalRandom.current().nextInt(-1,2);
		firstDuration = ThreadLocalRandom.current().nextInt(1,4);
		numbNotes = numb;
		bassStyle = ThreadLocalRandom.current().nextInt(1,3);
		

		realNotes.add(0);
		realNotes.add(2);
		realNotes.add(4);
		realNotes.add(5);
		realNotes.add(7);
		realNotes.add(9);
		realNotes.add(11);
	}

	//prevNote and nextNote should both 
	public ArrayList<Note> melody(int key,int note, int dur, int prevNote, int nextNote, boolean hasPrev, boolean hasNext, int melodyCorrection){
		ArrayList<Note> ret = new ArrayList<>();
		
		int index = realNotes.indexOf(prevNote);

		if(hasNext == false && dur <16){
			ret.add(new Note(key+melodyCorrection+note,dur,""));
			return ret;
		}


		if(numbNotes == 2){
			int firDir = 0;
			int secDir = 0;
			if(dur == 8){
				firDir = firstDuration * 2;
				secDir = 8 - firDir;
			}else if (dur == 16){
				if(firstDuration == 3 || firstDuration == 1){
					firDir = 4;
					secDir = 16 - firDir;
				}else{
					firDir = firstDuration * 2;
					secDir = 16 - firDir;				
				}
			}else if (dur == 4){
				firDir = firstDuration;
				secDir = 4 - firDir;
			}
			if(relate ==-1 && hasPrev){
				ret.add(new Note(key+melodyCorrection+noteFromNote(prevNote,offset,note),firDir,""));
				ret.add(new Note(key+melodyCorrection+note,secDir,""));

			}else if (relate == 1 && hasNext){
				ret.add(new Note(key+melodyCorrection+note,firDir,""));
				ret.add(new Note(key+melodyCorrection+noteFromNote(nextNote,offset,note),secDir,""));
			}else{
				ret.add(new Note(key+melodyCorrection+noteFromNote(note,offset,note),firDir,""));
				ret.add(new Note(key+melodyCorrection+note,secDir,""));
			}

		}else if (numbNotes == 3){
			int firDir = 0;
			int secDir = 0;
			int thiDir = 0;
			if(dur == 8){
				if(firstDuration == 1){
					firDir = 2;
					secDir = 2;
					thiDir = 4;
				}else if(firstDuration == 2){
					firDir = 2;
					secDir = 4;
					thiDir = 2;
				}else{
					firDir = 4;
					secDir = 2;
					thiDir = 2;
				}
			}else if (dur == 16){
				if(firstDuration == 1){
					firDir = 6;
					secDir = 2;
					thiDir = 8;
				}else if(firstDuration == 2){
					firDir = 2;
					secDir = 6;
					thiDir = 8;
				}else{
					firDir = 4;
					secDir = 4;
					thiDir = 8;
				}
			}else if (dur == 4){
				if(firstDuration ==1){
					firDir = 1;
					secDir = 2;
					thiDir = 1;
				}else if(firstDuration == 2){
					firDir = 1;
					secDir = 1;
					thiDir = 2;
				}else{
					firDir = 2;
					secDir = 2;
					thiDir = 0;	
				}
			}
				ret.add(new Note(key+melodyCorrection+note,firDir,""));
				ret.add(new Note(key+melodyCorrection+noteFromNote(note,offset,note),secDir,""));
				if(thiDir != 0 ){
					ret.add(new Note(key+melodyCorrection+note,thiDir,""));
				}

		}else if(numbNotes == 4){

		}
		return ret;
	}

	private int noteFromNote(int orig, int relation,int avoid){
		if(relation == 0){
			return orig;
		}
		int octaveCheck = 0;
		if(orig < 0){
			orig +=12;
			octaveCheck = -12;
		}
		int index = realNotes.indexOf(orig%12) + relation;
		if(index ==-1){
			octaveCheck += -12;
			index += 7;
		}else if(index == 7){
			octaveCheck += 12;
			index -=7;
		}
		int result = realNotes.get(index) + octaveCheck;
		if(result == avoid){
			return noteFromNote(orig,-relation,avoid);
		}
		return result;
	}


	public ArrayList<Note> bass(int key, int bassN, int highN, int midN, int duration, boolean open,boolean pac){
		ArrayList<Note> ret = new ArrayList<>();
		if(!open){
			ret.add(new Note(key+bassN,2,""));
			ret.add(new Note(key+highN,2,""));
			while(Note.dur(ret)<duration){
				ret.add(new Note(key+midN,2,""));
				ret.add(new Note(key+highN,2,""));
			}
		}else{
			if(bassStyle == 1){
				if(!pac){
					ret.add(new Note(key+bassN,2,""));
					ret.add(new Note(key+bassN+12,2,""));
					ret.add(new Note(key+highN,2,""));
					ret.add(new Note(key+midN,2,""));
					ret.add(new Note(key+bassN,8,""));
				}else{
					ret.add(new Note(key+bassN,2,""));
					ret.add(new Note(key+bassN-12,2,""));
					ret.add(new Note(key+midN-12,2,""));
					ret.add(new Note(key+highN-12,2,""));
					ret.add(new Note(key+bassN,8,""));											
				}
			}else if(bassStyle == 2){
				if(!pac){
					ret.add(new Note(-1,2,""));
					ret.add(new Note(key+bassN,2,""));
					ret.add(new Note(key+midN,2,""));
					ret.add(new Note(key+highN,2,""));
					ret.add(new Note(key+midN,2,""));
					ret.add(new Note(key+bassN,2,""));
					ret.add(new Note(key+highN-12,4,""));
				}else{
					ret.add(new Note(key+bassN,4,""));
					ret.add(new Note(key+highN-12,4,""));
					ret.add(new Note(key+bassN-12,8,""));
				}
			}
		}
		return ret;
	}


	public Style(Style s){
		while(relate == s.relate){
			relate = ThreadLocalRandom.current().nextInt(-1,2);
		}
		while(offset == s.offset){
			offset = ThreadLocalRandom.current().nextInt(-1,2);
		}
		while(firstDuration == s.firstDuration){
			firstDuration = ThreadLocalRandom.current().nextInt(1,4);
		}
		numbNotes = s.numbNotes;
		bassStyle = s.bassStyle;

		realNotes.add(0);
		realNotes.add(2);
		realNotes.add(4);
		realNotes.add(5);
		realNotes.add(7);
		realNotes.add(9);
		realNotes.add(11);
	}
}