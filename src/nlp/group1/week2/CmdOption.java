package nlp.group1.week2;

import org.kohsuke.args4j.Option;

public class CmdOption {
	@Option(name="-test",usage="specify input test file") 
	String testFile;
	@Option(name="-train",usage="specify input test file") 
	String trainFile;
	@Option(name="-rmMarks",usage="specify whether to remove marks character")
	boolean rmMarks = false;
}
