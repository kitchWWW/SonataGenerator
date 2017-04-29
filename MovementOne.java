import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class MovementOne {

	public static ArrayList<Idea> generate(){
		ArrayList<Phrase> openingOptions = new ArrayList<>();
		Phrase phr = new Phrase(1);
		phr.blocks.add(new Block(0,7,4,4,8));
		phr.blocks.add(new Block(2,7,5,5,8));
		phr.blocks.add(new Block(4,7,4,7,16));
		phr.open = false;
		openingOptions.add(phr);
		phr = new Phrase(1);
		phr.blocks.add(new Block(0,7,4,4,8));
		phr.blocks.add(new Block(-1,7,5,2,8));
		phr.blocks.add(new Block(0,7,4,4,16));
		phr.open = false;
		openingOptions.add(phr);
		phr = new Phrase(1);
		phr.blocks.add(new Block(0,7,4,4,8));
		phr.blocks.add(new Block(-1,7,5,5,8));
		phr.blocks.add(new Block(0,7,4,4,16));
		phr.open = false;
		openingOptions.add(phr);
		phr = new Phrase(1);
		phr.blocks.add(new Block(0,7,4,4,8));
		phr.blocks.add(new Block(-1,7,5,2,8));
		phr.blocks.add(new Block(-1,7,5,2,8));
		phr.blocks.add(new Block(0,7,4,4,8));
		phr.open = false;
		openingOptions.add(phr);
		phr = new Phrase(1);
		phr.blocks.add(new Block(0,7,4,4,8));
		phr.blocks.add(new Block(-1,7,5,5,8));
		phr.blocks.add(new Block(-1,7,5,5,8));
		phr.blocks.add(new Block(0,7,4,4,8));
		phr.open = false;
		openingOptions.add(phr);
		phr = new Phrase(1);
		phr.blocks.add(new Block(0,7,4,4,8));
		phr.blocks.add(new Block(-1,7,5,2,8));
		phr.blocks.add(new Block(2,7,5,5,8));
		phr.blocks.add(new Block(0,7,4,4,8));
		phr.open = false;
		openingOptions.add(phr);



		ArrayList<Phrase> endingOptions = new ArrayList<>();
		
		//Ending options are
		//0: reg HC
		//1: reg PAC
		//2: Prin HC
		//3: Prin PAC

		phr = new Phrase(1);
		phr.blocks.add(new Block(-1,7,2,5,8));
		phr.blocks.add(new Block(0,7,4,4,8));
		phr.blocks.add(new Block(-5,5,-1,2,16));
		phr.open = true;
		phr.pac = false;
		endingOptions.add(phr);
		phr = new Phrase(1);
		phr.blocks.add(new Block(-8,0,-5,7,4));
		phr.blocks.add(new Block(-7,0,-3,5,4));
		phr.blocks.add(new Block(-5,0,4,4,4));
		phr.blocks.add(new Block(-5,-1,2,2,4));
		phr.blocks.add(new Block(0,7,4,0,16));
		phr.open = true;
		phr.pac = true;
		endingOptions.add(phr);

		phr = new Phrase(1);
		phr.blocks.add(new Block(-7,0,-3,9,4));
		phr.blocks.add(new Block(-8,0,-5,7,4));
		phr.blocks.add(new Block(-10,-1,-7,5,4));
		phr.blocks.add(new Block(-12,-5,-8,4,4));
		phr.blocks.add(new Block(-5,2,-1,2,16));
		phr.open = true;
		phr.pac = false;
		endingOptions.add(phr);
		phr = new Phrase(1);
		phr.blocks.add(new Block(-7,0,-3,9,4));
		phr.blocks.add(new Block(-8,0,-5,7,4));
		phr.blocks.add(new Block(-10,-1,-7,5,4));
		phr.blocks.add(new Block(-12,-5,-8,4,4));
		phr.blocks.add(new Block(-7,2,-3,2,4));
		phr.blocks.add(new Block(-5,2,-1,-1,4));
		phr.blocks.add(new Block(0,7,4,0,8));
		phr.open = true;
		phr.pac = true;
		endingOptions.add(phr);



		ArrayList<Phrase> endingOptionsWithoutCad = new ArrayList<>();
		
		//Ending options are
		//0: reg HC
		//1: reg PAC
		//2: Prin HC
		//3: Prin PAC

		phr = new Phrase(1);
		phr.blocks.add(new Block(-1,7,2,5,8));
		phr.blocks.add(new Block(0,7,4,4,8));
		phr.open = false;
		endingOptionsWithoutCad.add(phr);
		phr = new Phrase(1);
		phr.blocks.add(new Block(-8,0,-5,7,4));
		phr.blocks.add(new Block(-7,0,-3,5,4));
		phr.blocks.add(new Block(-5,0,4,4,4));
		phr.blocks.add(new Block(-5,-1,2,2,4));
		phr.open = false;
		endingOptionsWithoutCad.add(phr);
		phr = new Phrase(1);
		phr.blocks.add(new Block(-7,0,-3,9,4));
		phr.blocks.add(new Block(-8,0,-5,7,4));
		phr.blocks.add(new Block(-10,-1,-7,5,4));
		phr.blocks.add(new Block(-12,-5,-8,4,4));
		phr.open = false;
		endingOptionsWithoutCad.add(phr);
		phr = new Phrase(1);
		phr.blocks.add(new Block(-7,0,-3,9,4));
		phr.blocks.add(new Block(-8,0,-5,7,4));
		phr.blocks.add(new Block(-10,-1,-7,5,4));
		phr.blocks.add(new Block(-12,-5,-8,4,4));
		phr.blocks.add(new Block(-7,2,-3,2,8));
		phr.blocks.add(new Block(-5,2,-1,-1,8));
		phr.open = false;
		endingOptionsWithoutCad.add(phr);



		ArrayList<Phrase> transitionOptions = new ArrayList<>();

		phr = new Phrase(2);
		phr.blocks.add(new Block(4,12,7,4,8));	//I6
		phr.blocks.add(new Block(5,12,9,0,8));	//IV
		phr.blocks.add(new Block(4,12,7,4,8));	//I6
		phr.blocks.add(new Block(5,12,9,0,8));	//IV
		phr.blocks.add(new Block(7,16,12,4,8));	//V64
		phr.blocks.add(new Block(7,14,11,2,8));	//V53
		phr.blocks.add(new Block(12,16,12,0,16));	//I
		phr.open = false;
		transitionOptions.add(phr);

		phr = new Phrase(2);
		phr.blocks.add(new Block(5,12,9,9,8));	//IV
		phr.blocks.add(new Block(4,12,10,7,8));	//V/IV
		phr.blocks.add(new Block(5,12,9,5,8));	//IV
		phr.blocks.add(new Block(5,14,9,9,8));	//ii6
		phr.blocks.add(new Block(7,14,11,5,4));	//V7
		phr.blocks.add(new Block(5,14,11,7,4));	//V42
		phr.blocks.add(new Block(4,7,12,4,4));	//I6
		phr.blocks.add(new Block(5,14,9,5,4));	//ii6
		phr.blocks.add(new Block(7,16,12,4,4));	//V64
		phr.blocks.add(new Block(7,14,11,2,4));	//V53
		phr.blocks.add(new Block(0,7,4,0,8));
		phr.open = false;
		transitionOptions.add(phr);


		ArrayList<Phrase> transitionNoModOptions = new ArrayList<>();

		phr = new Phrase(1);
		phr.blocks.add(new Block(-1,7,2,11,8));	//V6
		phr.blocks.add(new Block(0,7,4,7,8));	//I
		phr.blocks.add(new Block(-1,7,2,11,8));	//V6
		phr.blocks.add(new Block(0,7,4,7,8));	//I
		phr.blocks.add(new Block(-5,4,0,4,8));	//V64
		phr.blocks.add(new Block(-5,2,-1,2,8));	//V53
		phr.blocks.add(new Block(0,4,0,0,16));	//I
		phr.open = false;
		transitionNoModOptions.add(phr);

		phr = new Phrase(1);
		phr.blocks.add(new Block(0,7,4,4,8));	//I
		phr.blocks.add(new Block(-1,7,5,5,8));	//V65
		phr.blocks.add(new Block(0,7,4,7,8));	//I
		phr.blocks.add(new Block(-7,2,-3,9,8));	//ii6
		phr.blocks.add(new Block(-5,2,-1,5,4));	//V7
		phr.blocks.add(new Block(-7,2,-1,7,4));	//V42
		phr.blocks.add(new Block(-8,-5,0,4,4));	//I6
		phr.blocks.add(new Block(-7,2,-3,5,4));	//ii6
		phr.blocks.add(new Block(-5,4,0,4,4));	//V64
		phr.blocks.add(new Block(-5,2,-1,2,4));	//V53
		phr.blocks.add(new Block(0,7,4,0,8));	//i
		phr.open = false;
		transitionNoModOptions.add(phr);






		ArrayList<Phrase> developmentOptions = new ArrayList<>();

		phr = new Phrase(2);
		phr.blocks.add(new Block(0,7,5,4,8));	//I
		phr.blocks.add(new Block(-1,7,2,2,8));	//V6
		phr.blocks.add(new Block(-3,4,0,0,8));	//vi
		phr.blocks.add(new Block(-5,4,-1,4,8));	//III
		phr.blocks.add(new Block(-7,0,-3,5,8));	//IV
		phr.blocks.add(new Block(-7,2,-1,7,8));	//V42
		phr.blocks.add(new Block(-8,0,-5,4,16));	//I6

		phr.blocks.add(new Block(0,7,5,4,4));	//I
		phr.blocks.add(new Block(-1,7,2,5,4));	//V6
		phr.blocks.add(new Block(-3,4,0,4,4));	//vi
		phr.blocks.add(new Block(-5,4,-1,4,4));	//III
		phr.blocks.add(new Block(-7,0,-3,5,8));	//IV
		phr.blocks.add(new Block(-8,0,-5,4,8));	//I6
		phr.blocks.add(new Block(-7,2,-3,2,8));	//ii6
		phr.blocks.add(new Block(-5,2,-1,2,8));	//V
		//do standing after this

		phr.open = false;
		developmentOptions.add(phr);


		Phrase standing = new Phrase(2);
		standing.blocks.add(new Block(0,12,7,0,4));
		standing.blocks.add(new Block(4,12,7,7,4));
		standing.blocks.add(new Block(0,12,7,0,4));
		standing.blocks.add(new Block(4,12,7,7,4));
		standing.blocks.add(new Block(0,12,7,0,8));
		standing.blocks.add(new Block(4,12,7,7,8));
		standing.blocks.add(new Block(0,7,4,0,16));
		standing.open = true;
		standing.pac = true;






//Actually start composing the sonata now

		ArrayList<Idea> sonata = new ArrayList<>();


		ArrayList<Idea> openingTheme = new ArrayList<>();		
		int openingFirstAntIndex = ThreadLocalRandom.current().nextInt(0,openingOptions.size());
		int openingFirstConsIndex = ThreadLocalRandom.current().nextInt(0,2)*2;
		int openingSecondAntIndex = openingFirstAntIndex;
		int openingSecondConsIndex = openingFirstConsIndex + 1;

		Style openingFirstStyle = new Style(2);
		Style openingSecondStyle = new Style(3);
		
		openingTheme.add(new Idea(openingOptions.get(openingFirstAntIndex),openingFirstStyle,55));
		openingTheme.add(new Idea(endingOptions.get(openingFirstConsIndex),openingFirstStyle,55));
		openingTheme.add(new Idea(openingOptions.get(openingSecondAntIndex),openingSecondStyle,55));
		openingTheme.add(new Idea(endingOptions.get(openingSecondConsIndex),openingSecondStyle,55));

		sonata.addAll(openingTheme);

//Now Transition to Dominant

		int transitionIndex = ThreadLocalRandom.current().nextInt(0,transitionOptions.size());;
		Style thirdStyle = new Style(openingSecondStyle);
		sonata.add(new Idea(transitionOptions.get(transitionIndex),thirdStyle,50));

//Now Add the Second theme

		ArrayList<Idea> secondTheme = new ArrayList<>();

		int secondFirstAntIndex = ThreadLocalRandom.current().nextInt(0,openingOptions.size());
		while(secondFirstAntIndex == openingFirstAntIndex){
			secondFirstAntIndex = ThreadLocalRandom.current().nextInt(0,openingOptions.size());
		}
		int secondFirstConsIndex = ThreadLocalRandom.current().nextInt(0,2)*2;
		while(secondFirstConsIndex == openingFirstConsIndex){
			secondFirstConsIndex = ThreadLocalRandom.current().nextInt(0,2)*2;
		}
		int secondSecondAntIndex = secondFirstAntIndex;
		int secondSecondConsIndex = secondFirstConsIndex + 1;

		Style secondFirstStyle = new Style(openingFirstStyle);
		Style secondSecondStyle = new Style(openingSecondStyle);

		secondTheme.add(new Idea(openingOptions.get(secondFirstAntIndex),secondFirstStyle,50));
		secondTheme.add(new Idea(endingOptions.get(secondFirstConsIndex),secondFirstStyle,50));
		secondTheme.add(new Idea(openingOptions.get(secondSecondAntIndex),secondSecondStyle,50));
		secondTheme.add(new Idea(endingOptions.get(secondSecondConsIndex),secondSecondStyle,50));

		sonata.addAll(secondTheme);

//Dat repeate bar

		sonata.add(new Idea("\\bar \":|.\""));

//Now on to the development

		int developmentIndex = 0;
		Style developmentStyle = new Style(secondSecondStyle);
		sonata.add(new Idea(developmentOptions.get(developmentIndex),developmentStyle,50));
		sonata.add(new Idea(standing,developmentStyle,50));//standing

//And now we just add the opening theme verbatium back in, plus transition without modulation

		sonata.addAll(openingTheme);
		sonata.add(new Idea(transitionNoModOptions.get(transitionIndex),thirdStyle,55));

//And also the second theme, but this time in the home key

		ArrayList<Idea> secondThemeHomeKey = new ArrayList<>();
		secondThemeHomeKey.add(new Idea(openingOptions.get(secondFirstAntIndex),secondFirstStyle,55));
		secondThemeHomeKey.add(new Idea(endingOptions.get(secondFirstConsIndex),secondFirstStyle,55));
		secondThemeHomeKey.add(new Idea(openingOptions.get(secondSecondAntIndex),secondSecondStyle,55));
		secondThemeHomeKey.add(new Idea(endingOptionsWithoutCad.get(secondSecondConsIndex),secondSecondStyle,55));

		sonata.addAll(secondThemeHomeKey);

//Finish with a cood cadence confirmation. Sounds A-OK to me

		sonata.add(new Idea(standing,developmentStyle,55));//standing

//Go home you are done

		return sonata;
	}

}