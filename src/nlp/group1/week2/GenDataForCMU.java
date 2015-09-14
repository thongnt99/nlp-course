package nlp.group1.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.kohsuke.args4j.CmdLineParser;

public class GenDataForCMU {
	public static void main(String[] args){
		CmdOption cmdOption = new CmdOption();
		CmdLineParser parser = new CmdLineParser(cmdOption);
		try{
			if (args.length == 0){
				showHelp(parser);
				return;
			}
			parser.parseArgument(args);
			perform(cmdOption);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	public static void perform(CmdOption cmdOption){
		genData(cmdOption.testFile,cmdOption.rmMarks);
		genData(cmdOption.trainFile, cmdOption.rmMarks);
	}
	public static void genData(String inFileName,boolean rmMarks){
		String fileExt = inFileName.substring(inFileName.lastIndexOf("."));
		String outFileName  = inFileName.replace(fileExt, "_CMU"+fileExt);
		File inFile = new File(inFileName);
		File outFile = new File(outFileName);
		String line;
		String cmuLine;
		BufferedReader br;
		BufferedWriter bw;			
		try {
			 br = new BufferedReader(new FileReader(inFile));
			 bw = new BufferedWriter(new FileWriter(outFile));
			 while ( (line = br.readLine()) != null){
				 cmuLine = "<s> ";
				 line = line.replaceAll("\\.$"," .");
				 String[] tokens = line.toLowerCase().split(" ");
				 for (String token : tokens){
					 if (!rmMarks)
						 cmuLine +=" " + token;
					 else if (!Resource.marks.contains(token))
						 cmuLine +=" " + token;					 
				 }
				 cmuLine += " </s>";							 
				 cmuLine = cmuLine.replaceAll("(\\s+)"," ");
				 bw.write(cmuLine+"\n");
			 }
			 br.close();
			 bw.close();
		} catch (IOException e) {
			System.out.println("Error while reading file "+inFileName);
			e.printStackTrace();
		}
	}
	private static void showHelp(CmdLineParser parser){
		System.out.println("GenDataForCMU [options ...] [arguments ...]");
		parser.printUsage(System.out);
	}
}
