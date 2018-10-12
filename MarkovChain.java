package edu.exeter.cs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MarkovChain {
    public static HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    static String strr = "That thou hast her it "							//teaching sonnets
            + "is not all my grief, And yet it may be said I "
            + "loved her dearly, That she hath thee"
            + " is of my wailing chief, A loss"
            + " in love that touches me more nearly. "
            + "Loving offenders thus I will excuse ye,"
            + " Thou dost love her, because thou know'st I "
            + "love her, And for my sake even so doth she abuse me,"
            + " Suff'ring my friend for my sake to approve her."
            + " If I lose thee, my loss is my love's gain, And"
            + " losing her, my friend hath found that loss, Both"
            + " find each other, and I lose both twain,And both"
            + " for my sake lay on me this cross, But here's the"
            + " joy, my friend and I are one, Sweet flattery,"
            + " then she loves but me alone. Was it the proud full "
            + "sail of his great verse, Bound for the "
            + "prize of (all too precious) you, That "
            + "did my ripe thoughts in my brain inhearse, "
            + "Making their tomb the womb wherein they "
            + "grew? Was it his spirit, by spirits taught "
            + "to write, Above a mortal pitch, that struck"
            + " me dead? No, neither he, nor his compeers"
            + " by night Giving him aid, my verse "
            + "astonished. He nor that affable familiar"
            + " ghost Which nightly gulls him with "
            + "intelligence, As victors of my silence "
            + "cannot boast, I was not sick of any fear"
            + " from thence. But when your countenance "
            + "filled up his line, Then lacked I matter, "
            + "that enfeebled mine. Whilst I alone did call upon thy aid, "
            + "My verse alone had all thy gentle grace,But now my gracious"
            + " numbers are decayed, And my sick muse doth give an other place."
            + "I grant (sweet love) thy lovely argument Deserves the travail of a "
            + "worthier pen, Yet what of thee thy poet doth invent, He robs thee of, "
            + "and pays it thee again, He lends thee virtue, and he stole that word, "
            + "From thy behaviour, beauty doth he give And found it in thy "
            + "cheek: he can afford No praise to thee, but what in thee doth "
            + "live. Then thank him not for that which he say, Since what he owes "
            + "thee, thou thy self dost pay. Poor soul the centre of my sinful earth, My sinful earth these rebel powers array,Why dost thou pine within and suffer dearth Painting thy outward walls so costly gay? Why so large cost "
            + "having so short a lease, Dost thou upon thy fading mansion spend?"
            + " Shall worms inheritors of this excess Eat up thy charge? is this"
            + " thy body's end? Then soul live thou upon thy servant's loss, And "
            + "let that pine to aggravate thy store; Buy terms divine in selling"
            + " hours of dross; within be fed, without be rich no more, So "
            + "shall thou feed on death, that feeds on men, And death once "
            + "dead, there's no more dying then. Love is too young to know what conscience is, Yet who knows not "
            + "conscience is born of love? Then gentle "
            + "cheater urge not my amiss, Lest guilty of my faults thy "
            + "sweet self prove. For thou betraying me, I do betray My nobler "
            + "part to my gross body's treason, My soul doth tell my body that"
            + " he may, Triumph in love, flesh stays no farther reason, But rising "
            + "at thy name doth point out thee, As his triumphant prize, proud of this "
            + "pride, He is contented thy poor drudge to be, To stand in thy affairs, fall "
            + "by thy side. No want of conscience hold it that I call, Her love, for whose"
            + " dear love I rise and fall.";

    static String song = "I am hot "						//song to figure out
            + "You are blank "
            + "You blank around "
            + "Like you blank "
            + "Who I blank "
            + "But you don't "
            + "You have got me on "
            + "My blank "

            + "I blank slipping into the blank "
            + "And I am trying to keep from blank "
            + "Baby you blank the blank hotter "
            + "Cause I'm burnin' up, burnin' up "
            + "For you baby "

            + "Come on girl "

            + "I blank "
            + "So blank "
            + "Cannot hold myself back "
            + "High heels "
            + "Red dress "
            + "All by blank "
            + "Gotta catch my breath "

            + "I blank slipping into the blank "
            + "And I am trying to keep from blank "
            + "Baby you blank the blank hotter "
            + "Cause Im burnin' up, burnin' up "
            + "For you baby "

            + "Walk in the blank "
            + "All I can blank is you "

            + "Oh "

            + "Staring me blank "
            + "I know you blank it too "

            + "I blank slipping into the blank "
            + "And Im trying to keep from blank "
            + "Baby you blank the blank hotter "
            + "Cause Im burnin' up, burnin' up "
            + "For you baby  "

            + "I blank slipping into the blank "
            + "And Im trying to keep from blank "
            + "Baby you blank the blank hotter "
            + "Cause Im burnin' up, burnin' up "
            + "For you baby "

            + "Burnin' up in the place tonight "
            + "And the blank singing loud "
            + "Get up and blank "
            + "Big robs for blank "
            + "Stop, drop and blank "
            + "More and more "
            + "I got JB with blank "
            + "Come on blank bring the blank around "

            + "I blank slipping into the blank "
            + "And Im trying to keep from blank "
            + "Baby you blank the blank hotter "
            + "Cause Im burnin' up, burnin' up "
            + "For you baby ";

    static String str = strr.replaceAll("’", "");				//gets rid of apostrophes etc
    static int wordcount = 0;
    public int[] probability = new int[wordcount];

    public static void main(String[] args) {					//main - calls and prints the remake method
        System.out.println(remake(song, strr));
    }

    public static ArrayList<String> createList(String str) {		//makes a list of words out of a string of words
        ArrayList<String> words = new ArrayList<String>();
        String delimiters = "[\\W]+";
        String[] list = str.split(delimiters);				//splits the large string into an array of strings

        for (String s: list) {								//for each string in the array add to arraylist and incriment wordcount

            String wrd = s.toLowerCase();

            words.add(wrd);
            wordcount++;
        }
        System.out.println(words.size());
        return words;
    }

    public static HashMap<String, ArrayList<String>> createMap(ArrayList<String> words)		//creates a map with all the words that ever follow the key as the values
    {
        String temp1, temp2;
        for(int s = 0; s < words.size()-1; s++){			//checks all but last word
            temp1 = (words.get(s)).toLowerCase();
            temp2 = (words.get(s+1)).toLowerCase();
            if(map.containsKey(temp1)) 						//if the word already exists
            {
                ArrayList<String> w = new ArrayList<String>();
                w = map.get(temp1);							//duplicates current list of words and adds to it
                w.add(temp2);
                map.put(temp1, w);					//overwrites old value, adds new list
            } else {
                ArrayList<String> stuff = new ArrayList<String>();
                stuff.add(temp2);
                map.put(temp1, stuff); 			//adds new key and list
            }
        }
        return map;
    }

    public static String compare(String words, String str)		//tries to predict a word
    {
        str = str.toLowerCase();
        ArrayList<String> text = createList(words);			//calls createlist to make a list of strings
        createMap(text);									//calls createmap on the list
        Random r = new Random();
        String returnstring = "";
        for(String s: map.keySet())							//randomly chooses a word in the list of words that follow the chosen word
        {
            if(s.equals(str))
            {
                ArrayList<String> w = map.get(s);
                returnstring = w.get(r.nextInt(w.size()));
            }
        }
        System.out.println(returnstring);
        return returnstring;
    }

    public static String remake(String song, String sonnets)			//remake method - returns altered song
    {
        song = song.toLowerCase();										//makes sure it's lower case
        String returnstring = "";
        ArrayList<String> lyrics = createList(song);					//calls create list to make a list of the words in the song
        for(int i = 0; i< lyrics.size(); i++)
        {
            if(lyrics.get(i).equals("blank") || lyrics.get(i).equals("blank "))			//for each word, checks if it is "blank" and if it is, tries to guess a word
            {
                returnstring = returnstring + " " + compare(sonnets, lyrics.get(i-1));		//calls compare to predict a word

            }
            if(!lyrics.get(i).equals("blank"))
            {
                returnstring = returnstring + " " + lyrics.get(i);
            }

        }
        return returnstring;
    }
}

