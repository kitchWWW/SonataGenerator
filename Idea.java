import java.util.ArrayList;


public class Idea{
	public Phrase p;
	public Style s;
	public int k;
	private Boolean real;
	public String message;

	public Idea(Phrase pr, Style st,int key){
		p = pr;
		s = st;
		k = key;
		real = true;
	}

	public Idea(String str){
		message = str;
		real = false;
	}

	public static ArrayList<ArrayList<Note>> toNotes(ArrayList<Idea> work){
		ArrayList<ArrayList<Note>> ret = new ArrayList<>();
		ret.add(new ArrayList<Note>());
		ret.add(new ArrayList<Note>());
		
		for(int i = 0; i < work.size(); i ++){
			if(work.get(i).real){
				ArrayList<ArrayList<Note>> curWork = Phrase.toNotes(work.get(i).p, work.get(i).s,work.get(i).k);
				ret.get(0).addAll(curWork.get(0));
				ret.get(1).addAll(curWork.get(1));				
			}else{
				ret.get(0).add(new Note(work.get(i).message));
				ret.get(1).add(new Note(work.get(i).message));
			}
		}
		return ret;	
	}
}