import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class MovementOne {

	public static ArrayList<Idea> generate(int key,int keyType, int ptType,int stType,boolean analyze){

		ArrayList<Integer> styleOrder = new ArrayList<>();
		styleOrder.add(0);//quarter notes
		styleOrder.add(1);//eight note - dotted quarter
		styleOrder.add(2);//dotted quarter - eight note
		styleOrder.add(3);//three notes
		styleOrder.add(4);//runs and fun stuff
		long seed = System.nanoTime();
		Collections.shuffle(styleOrder, new Random(seed));

		ArrayList<Phrase> openingOptions = new ArrayList<>();
		Phrase phr = new Phrase(1);
		phr.blocks.add(new Block(analyze,0,7,4,4,8,"\n%lab\n","\n%key\nI"));
		phr.blocks.add(new Block(analyze,2,7,5,5,8,"mi-fa-so","V43"));
		phr.blocks.add(new Block(analyze,4,7,4,7,16,"","I6"));
		phr.open = false;
		openingOptions.add(phr);
		phr = new Phrase(1);
		phr.blocks.add(new Block(analyze,0,7,4,4,8,"\n%lab\n","\n%key\nI"));
		phr.blocks.add(new Block(analyze,-1,7,5,2,8,"mi-re-mi","V65"));
		phr.blocks.add(new Block(analyze,0,7,4,4,16,"","I"));
		phr.open = false;
		openingOptions.add(phr);
		phr = new Phrase(1);
		phr.blocks.add(new Block(analyze,0,7,4,4,8,"\n%lab\n","\n%key\nI"));
		phr.blocks.add(new Block(analyze,-1,7,5,5,8,"mi-fa-mi","V65"));
		phr.blocks.add(new Block(analyze,0,7,4,4,16,"","I"));
		phr.open = false;
		openingOptions.add(phr);
		phr = new Phrase(1);
		phr.blocks.add(new Block(analyze,0,7,4,4,8,"\n%lab\n","\n%key\nI"));
		phr.blocks.add(new Block(analyze,-1,7,5,2,8,"mi-re-re-mi","V65"));
		phr.blocks.add(new Block(analyze,-1,7,5,2,8,"","(V65)"));
		phr.blocks.add(new Block(analyze,0,7,4,4,8,"","I"));
		phr.open = false;
		openingOptions.add(phr);
		phr = new Phrase(1);
		phr.blocks.add(new Block(analyze,0,7,4,4,8,"\n%lab\n","\n%key\nI"));
		phr.blocks.add(new Block(analyze,-1,7,5,5,8,"mi-fa-fa-mi","V65"));
		phr.blocks.add(new Block(analyze,-1,7,5,5,8,"","(V65)"));
		phr.blocks.add(new Block(analyze,0,7,4,4,8,"","I"));
		phr.open = false;
		openingOptions.add(phr);
		phr = new Phrase(1);
		phr.blocks.add(new Block(analyze,0,7,4,4,8,"\n%lab\n","\n%key\nI"));
		phr.blocks.add(new Block(analyze,-1,7,5,2,8,"mi-re-fa-mi","V65"));
		phr.blocks.add(new Block(analyze,2,7,5,5,8,"","V43"));
		phr.blocks.add(new Block(analyze,0,7,4,4,8,"","I"));
		phr.open = false;
		openingOptions.add(phr);



		ArrayList<Phrase> endingOptions = new ArrayList<>();
		
		//Ending options are
		//0: reg HC
		//1: reg PAC
		//2: Prin HC
		//3: Prin PAC

		phr = new Phrase(1);
		phr.blocks.add(new Block(analyze,-1,7,2,5,8,"fa-mi-re","V65"));
		phr.blocks.add(new Block(analyze,0,7,4,4,8,"","I"));
		phr.blocks.add(new Block(analyze,-5,5,-1,2,16,"HC","V7"));
		phr.open = true;
		phr.pac = false;
		endingOptions.add(phr);
		phr = new Phrase(1);
		phr.blocks.add(new Block(analyze,-8,0,-5,7,4,"Decent from 5","I6"));
		phr.blocks.add(new Block(analyze,-7,0,-3,5,4,"","IV"));
		phr.blocks.add(new Block(analyze,-5,0,4,4,4,"","V64"));
		phr.blocks.add(new Block(analyze,-5,-1,2,2,4,"","(53)"));
		phr.blocks.add(new Block(analyze,0,7,4,0,16,"PAC","I"));
		phr.open = true;
		phr.pac = true;
		endingOptions.add(phr);

		phr = new Phrase(1);
		phr.blocks.add(new Block(analyze,-7,0,-3,9,4,"Prin","IV"));
		phr.blocks.add(new Block(analyze,-8,0,-5,7,4,"","I6"));
		phr.blocks.add(new Block(analyze,-10,-1,-7,5,4,"","vii°6"));
		phr.blocks.add(new Block(analyze,-12,-5,-8,4,4,"","I"));
		phr.blocks.add(new Block(analyze,-5,2,-1,2,16,"HC","V"));
		phr.open = true;
		phr.pac = false;
		endingOptions.add(phr);
		phr = new Phrase(1);
		phr.blocks.add(new Block(analyze,-7,0,-3,9,4,"Prin","IV"));
		phr.blocks.add(new Block(analyze,-8,0,-5,7,4,"","I6"));
		phr.blocks.add(new Block(analyze,-10,-1,-7,5,4,"","vii°6"));
		phr.blocks.add(new Block(analyze,-12,-5,-8,4,4,"","I"));
		phr.blocks.add(new Block(analyze,-7,2,-3,2,4,"","ii6"));
		phr.blocks.add(new Block(analyze,-5,2,-1,-1,4,"","V"));
		phr.blocks.add(new Block(analyze,0,7,4,0,8,"PAC","I"));
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
		phr.blocks.add(new Block(analyze,-1,7,2,5,8,"fa mi re","V65"));
		phr.blocks.add(new Block(analyze,0,7,4,4,8,"","I"));
		phr.open = false;
		endingOptionsWithoutCad.add(phr);
		phr = new Phrase(1);
		phr.blocks.add(new Block(analyze,-8,0,-5,7,4,"Decent from 5","I6"));
		phr.blocks.add(new Block(analyze,-7,0,-3,5,4,"","IV"));
		phr.blocks.add(new Block(analyze,-5,0,4,4,4,"","V64"));
		phr.blocks.add(new Block(analyze,-5,-1,2,2,4,"","(53)"));
		phr.open = false;
		endingOptionsWithoutCad.add(phr);
		phr = new Phrase(1);
		phr.blocks.add(new Block(analyze,-7,0,-3,9,4,"Prin","IV"));
		phr.blocks.add(new Block(analyze,-8,0,-5,7,4,"","I6"));
		phr.blocks.add(new Block(analyze,-10,-1,-7,5,4,"","vii°6"));
		phr.blocks.add(new Block(analyze,-12,-5,-8,4,4,"","I"));
		phr.open = false;
		endingOptionsWithoutCad.add(phr);
		phr = new Phrase(1);
		phr.blocks.add(new Block(analyze,-7,0,-3,9,4,"Prin","IV"));
		phr.blocks.add(new Block(analyze,-8,0,-5,7,4,"","I6"));
		phr.blocks.add(new Block(analyze,-10,-1,-7,5,4,"","vii°6"));
		phr.blocks.add(new Block(analyze,-12,-5,-8,4,4,"","I"));
		phr.blocks.add(new Block(analyze,-7,2,-3,2,8,"","ii6"));
		phr.blocks.add(new Block(analyze,-5,2,-1,-1,8,"","V"));
		phr.open = false;
		endingOptionsWithoutCad.add(phr);



		ArrayList<Phrase> transitionAOptions = new ArrayList<>();

		phr = new Phrase(2);
		phr.blocks.add(new Block(analyze,-1,7,2,-1,8,"Transition","V6"));
		phr.blocks.add(new Block(analyze,0,7,4,-5,8,"","I"));
		phr.blocks.add(new Block(analyze,-1,7,2,-1,8,"","V6"));
		phr.open = false;
		transitionAOptions.add(phr);

		phr = new Phrase(2);
		phr.blocks.add(new Block(analyze,0,7,4,4,8,"Transition","I"));	//IV
		phr.blocks.add(new Block(analyze,-1,7,5,5,8,"","V65"));	//V/IV
		phr.open = false;
		transitionAOptions.add(phr);


		ArrayList<Phrase> transitionBOptions = new ArrayList<>();

		phr = new Phrase(2);
		phr.blocks.add(new Block(analyze,5,12,9,0,8,"","I / \n%key\n IV"));	//IV
		phr.blocks.add(new Block(analyze,7,16,12,4,8,"","V64"));	//V64
		phr.blocks.add(new Block(analyze,7,14,11,2,8,"","(53)"));	//V53
		phr.blocks.add(new Block(analyze,12,16,12,0,16,"PAC","I"));	//I
		phr.open = false;
		transitionBOptions.add(phr);

		phr = new Phrase(2);
		phr.blocks.add(new Block(analyze,5,12,9,5,8,"","I / \n%key\n IV "));	//IV
		phr.blocks.add(new Block(analyze,5,14,9,9,8,"","ii6"));	//ii6
		phr.blocks.add(new Block(analyze,7,14,11,5,4,"","V7"));	//V7
		phr.blocks.add(new Block(analyze,5,14,11,7,4,"","V42"));	//V42
		phr.blocks.add(new Block(analyze,4,7,12,4,4,"","I6"));	//I6
		phr.blocks.add(new Block(analyze,5,14,9,5,4,"","ii6"));	//ii6
		phr.blocks.add(new Block(analyze,7,16,12,4,4,"","V64"));	//V64
		phr.blocks.add(new Block(analyze,7,14,11,2,4,"","(53)"));	//V53
		phr.blocks.add(new Block(analyze,0,7,4,0,8,"PAC","I"));
		phr.open = false;
		transitionBOptions.add(phr);




		ArrayList<Phrase> transitionNoModOptions = new ArrayList<>();

		phr = new Phrase(1);
		phr.blocks.add(new Block(analyze,-1,7,2,11,8,"Transition","V6"));	//V6
		phr.blocks.add(new Block(analyze,0,7,4,7,8,"","I"));	//I
		phr.blocks.add(new Block(analyze,-1,7,2,11,8,"","V6"));	//V6
		phr.blocks.add(new Block(analyze,0,7,4,7,8,"","I"));	//I
		phr.blocks.add(new Block(analyze,-5,4,0,4,8,"","V64"));	//V64
		phr.blocks.add(new Block(analyze,-5,2,-1,2,8,"","(53)"));	//V53
		phr.blocks.add(new Block(analyze,0,4,0,0,16,"PAC","I"));	//I
		phr.open = false;
		transitionNoModOptions.add(phr);

		phr = new Phrase(1);
		phr.blocks.add(new Block(analyze,0,7,4,4,8,"Transition","I"));	//I
		phr.blocks.add(new Block(analyze,-1,7,5,5,8,"","V65"));	//V65
		phr.blocks.add(new Block(analyze,0,7,4,7,8,"","I"));	//I
		phr.blocks.add(new Block(analyze,-7,2,-3,9,8,"","ii6"));	//ii6
		phr.blocks.add(new Block(analyze,-5,2,-1,5,4,"","V7"));	//V7
		phr.blocks.add(new Block(analyze,-7,2,-1,7,4,"","V42"));	//V42
		phr.blocks.add(new Block(analyze,-8,-5,0,4,4,"","I6"));	//I6
		phr.blocks.add(new Block(analyze,-7,2,-3,5,4,"","ii6"));	//ii6
		phr.blocks.add(new Block(analyze,-5,4,0,4,4,"","V64"));	//V64
		phr.blocks.add(new Block(analyze,-5,2,-1,2,4,"","V53"));	//V53
		phr.blocks.add(new Block(analyze,0,7,4,0,8,"PAC","I"));	//i <- lol yes we have mode mixture rn
		phr.open = false;
		transitionNoModOptions.add(phr);






		ArrayList<Phrase> developmentOptions = new ArrayList<>();

		phr = new Phrase(2);
		phr.blocks.add(new Block(analyze,0,7,5,4,8,"Development","I"));	//I
		phr.blocks.add(new Block(analyze,-1,7,2,2,8,"","V6"));	//V6
		phr.blocks.add(new Block(analyze,-3,4,0,0,8,"","vi"));	//vi
		phr.blocks.add(new Block(analyze,-5,4,-1,4,8,"","iii6"));	//iii
		phr.blocks.add(new Block(analyze,-7,0,-3,5,8,"","IV"));	//IV
		phr.blocks.add(new Block(analyze,-7,2,-1,7,8,"","V42"));	//V42
		phr.blocks.add(new Block(analyze,-8,0,-5,4,16,"","I6"));	//I6

		phr.blocks.add(new Block(analyze,0,7,5,4,4,"","I"));	//I
		phr.blocks.add(new Block(analyze,-1,7,2,5,4,"","V6"));	//V6
		phr.blocks.add(new Block(analyze,-3,4,0,4,4,"","vi"));	//vi
		phr.blocks.add(new Block(analyze,-5,4,-1,4,4,"","iii6"));	//iii
		phr.blocks.add(new Block(analyze,-7,0,-3,5,8,"","IV"));	//IV
		phr.blocks.add(new Block(analyze,-8,0,-5,4,8,"","I6"));	//I6
		phr.blocks.add(new Block(analyze,-7,2,-3,2,8,"","ii6"));	//ii6
		phr.blocks.add(new Block(analyze,-5,2,-1,2,8,"","V"));	//V
		//do standing after this

		phr.open = false;
		developmentOptions.add(phr);


		Phrase standing = new Phrase(2);
		standing.blocks.add(new Block(analyze,0,12,4,0,4,"\n%lab\n","\n%key\n"));
		standing.blocks.add(new Block(analyze,4,12,7,7,4,"",""));
		standing.blocks.add(new Block(analyze,0,12,4,0,4,"",""));
		standing.blocks.add(new Block(analyze,4,12,7,7,4,"",""));
		standing.blocks.add(new Block(analyze,0,12,4,0,8,"",""));
		standing.blocks.add(new Block(analyze,4,12,7,7,8,"",""));
		standing.blocks.add(new Block(analyze,0,7,4,0,16,"\n%lab\n",""));
		standing.open = true;
		standing.pac = true;

		Phrase trill = new Phrase(2);
		trill.blocks.add(new Block(analyze,7,14,11,2,16,"",""));
		trill.trill = true;




//Actually start composing the sonata now

		ArrayList<Idea> sonata = new ArrayList<>();


		ArrayList<Idea> openingTheme = new ArrayList<>();		
		int openingFirstAntIndex = ThreadLocalRandom.current().nextInt(0,openingOptions.size());
		int openingFirstConsIndex = ThreadLocalRandom.current().nextInt(0,2)*2;
		int openingSecondAntIndex = openingFirstAntIndex;
		int openingSecondConsIndex = openingFirstConsIndex + 1;

		Style openingFirstStyle = new Style(styleOrder.get(0),keyType);
		Style openingSecondStyle = new Style(styleOrder.get(1),keyType);
		
		openingTheme.add(new Idea(openingOptions.get(openingFirstAntIndex),openingFirstStyle,key));
		openingTheme.add(new Idea(endingOptions.get(openingFirstConsIndex),openingFirstStyle,key));
		openingTheme.add(new Idea(openingOptions.get(openingSecondAntIndex),openingFirstStyle,key));
		openingTheme.add(new Idea(endingOptions.get(openingSecondConsIndex),openingSecondStyle,key));

		sonata.addAll(openingTheme);

//Now Transition to Dominant

		int transitionIndex = ThreadLocalRandom.current().nextInt(0,transitionAOptions.size());;
		Style thirdStyle = new Style(styleOrder.get(2),keyType);
		sonata.add(new Idea(transitionAOptions.get(transitionIndex),thirdStyle,key));
		sonata.add(new Idea(transitionBOptions.get(transitionIndex),thirdStyle,key-5));

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

		Style secondFirstStyle = new Style(styleOrder.get(3),keyType);
		Style secondSecondStyle = new Style(styleOrder.get(4),keyType);

		secondTheme.add(new Idea(openingOptions.get(secondFirstAntIndex),secondFirstStyle,key-5));
		secondTheme.add(new Idea(endingOptions.get(secondFirstConsIndex),secondFirstStyle,key-5));
		secondTheme.add(new Idea(openingOptions.get(secondSecondAntIndex),secondFirstStyle,key-5));
		secondTheme.add(new Idea(endingOptions.get(secondSecondConsIndex),secondSecondStyle,key-5));

		sonata.addAll(secondTheme);

//Dat repeate bar

		sonata.add(new Idea("\\bar \":|.\""));

//Now on to the development

		int developmentIndex = 0;
		Style developmentStyle = new Style(styleOrder.get(1),keyType);
		sonata.add(new Idea(developmentOptions.get(developmentIndex),developmentStyle,key-5));
		sonata.add(new Idea(standing,developmentStyle,key-5));//standing

//And now we just add the opening theme verbatium back in, plus transition without modulation

		sonata.addAll(openingTheme);
		sonata.add(new Idea(transitionNoModOptions.get(transitionIndex),thirdStyle,key));

//And also the second theme, but this time in the home key

		ArrayList<Idea> secondThemeHomeKey = new ArrayList<>();
		secondThemeHomeKey.add(new Idea(openingOptions.get(secondFirstAntIndex),secondFirstStyle,key));
		secondThemeHomeKey.add(new Idea(endingOptions.get(secondFirstConsIndex),secondFirstStyle,key));
		secondThemeHomeKey.add(new Idea(openingOptions.get(secondSecondAntIndex),secondFirstStyle,key));
		secondThemeHomeKey.add(new Idea(endingOptionsWithoutCad.get(secondSecondConsIndex),secondSecondStyle,key));

		sonata.addAll(secondThemeHomeKey);

//Finish with a cood cadence confirmation. Sounds A-OK to me
		sonata.add(new Idea(trill,developmentStyle,key-12));
		sonata.add(new Idea(standing,developmentStyle,key-12));//standing

//Go home you are done

		return sonata;
	}

}