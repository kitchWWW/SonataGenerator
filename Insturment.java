
//[{name:"guitar",staff:"treble_8",crescendo:true,tremolo:false,notes:[71,72,74,76],midi:"violin"},{name:"guitar",staff:"treble_8",crescendo:true,tremolo:false,notes:[71,72,74,76],midi:"violin"},{name:"guitar",staff:"treble_8",crescendo:true,tremolo:false,notes:[71,72,74,76],midi:"violin"},{name:"guitar",staff:"treble_8",crescendo:true,tremolo:false,notes:[71,72,74,76],midi:"violin"}]

public class Insturment {
	String name;
	String staff;
	Boolean crescendo;
	Boolean tremolo;
	Integer[] notes;
	String midi;

	public Insturment(String name, String midi, String staff, Boolean crescendo, Boolean tremolo, Integer[] notes){
		this.name = name;
		this.staff = staff;
		this.crescendo = crescendo;
		this.tremolo = tremolo;
		this.notes = notes;
		this.midi = midi;
	}

}