

import opennlp.tools.parser.ParserModel;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.chunking.Parser;
import opennlp.tools.parser.*;
import opennlp.tools.cmdline.parser.ParserTool;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

class ProcessSent
{
	private Parser parser;
	int scores;
	
	public ProcessSent() throws Exception
	{
		//constructor to instantiate parser model.
		InputStream is = new FileInputStream("assets/en-parser-chunking.bin");
		ParserModel model1 = new ParserModel(is);
	    parser = (opennlp.tools.parser.chunking.Parser)ParserFactory.create(model1);
	    scores = 0;
	}
	/*
	 * Parse input sentence to get parse trees. Library calls to NLP library.
	 */
	private double parseSentence(String sentence )
	{
		Parse topParse[] = ParserTool.parseLine(sentence, parser, 1);
			     
		topParse[0].show();
		System.out.println(topParse[0].getProb());
		return topParse[0].getProb();
		   		      
	}
	
	/*
	 * Checks for the presence of bag of words / tag words in input sentence.
	 */
	
	private boolean CheckWords(String sentence, String words)
	{
		int hits = 0;
		
		ArrayList <String> bagOfWords = new ArrayList<String>();
		bagOfWords.addAll(Arrays.asList(words.split("\\s+")));
		//new ArrayList (); words.split("\\s+");
		int size = bagOfWords.size();
		for(String w : sentence.split("\\s+"))
		{
			//System.out.println(w + " , "+bagOfWords.size());
			for (String word : bagOfWords)
			{
				if(w.contains(word))
				{
					hits++;
					bagOfWords.remove(word);
					//System.out.println(bagOfWords.size());
					break;
				}
			}
		}
		
		System.out.println(hits);
		
		if(hits == size)
			return true;
		else
			return false;
	}
	
	/*
	 * Computes and returns score for the sentence. 
	 * The calculation is dependent on tag words and threshold values 
	 * set for the sentence.
	 */

	public int scores(String sentence, String words, double threshold)
	{
		/*Step - 1 : check if all words in bag of words are present in sentence 
		 * else award a zero score.
		 * 
		 * Step - 2 : parse the sentence and get the probability value.
		 * 
		 * Step - 3: compare the probability value returned against the set threshold value
		 * and return appropriate score value.
		*/
		
		if(CheckWords(sentence, words))
		{
			Double d = (Double)parseSentence(sentence);
			//System.out.println(d);
			System.out.println(d.toString().substring(0, 8)+ "  "+ String.valueOf(threshold));
			
			if(d.toString().substring(0, 8).equals(String.valueOf(threshold)))
			 	scores = 10; 
			else if(d > threshold)
				scores = 5;
			else
				scores = -5;
			return scores;
		}
		
		return scores;
	}
}





