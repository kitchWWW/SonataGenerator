import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class Block {

	public int baseNote; //midi pitch
	public int highNote;	//midi
	public int midNote;	//midi
	public int melodyNote;//midi
	public int duration;	//in 16th notes
	public String topLily;
	public String basLily;
	public boolean analyze;

	public Block(boolean markups,int bass, int high, int low, int melody, int dur, String top, String bottom){
		baseNote = bass;
		highNote = high;
		midNote = low;
		melodyNote = melody;
		duration = dur;
		analyze = markups;
		if(analyze){
			topLily = top;
			basLily = bottom;
		}else{
			topLily = "";
			basLily = "";
		}
		
		//System.out.println(topLily);
	}

	public String toString(){
		return "("+baseNote+","+highNote+","+midNote+" "+melodyNote+")";
	}

}