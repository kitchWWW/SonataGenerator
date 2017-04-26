import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class Block {

	public int baseNote; //midi pitch
	public int highNote;	//midi
	public int midNote;	//midi
	public int melodyNote;//midi
	public int duration;	//in 16th notes

	public Block(int bass, int high, int low, int melody, int dur){
		baseNote = bass;
		highNote = high;
		midNote = low;
		melodyNote = melody;
		duration = dur;
	}

	public String toString(){
		return "("+baseNote+","+highNote+","+midNote+" "+melodyNote+")";
	}

}