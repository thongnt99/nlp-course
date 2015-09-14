package nlp.group1.week2;

import java.util.ArrayList;
import java.util.List;

public class Resource {
	public static List<String> marks;
	
	static{
		marks = new ArrayList<String>();
		marks.add(".");
		marks.add(",");		
		marks.add("/");
		marks.add("\\");		
		marks.add("?");
		marks.add("!");		
		marks.add("(");
		marks.add(")");
		marks.add("-");
		marks.add(":");
		marks.add("\"");
		marks.add("'");
		marks.add(";");
		marks.add("_");			
	}
}
