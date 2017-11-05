import java.util.ArrayList;
import java.util.Map.Entry;

/**
 * Holds the grade of a student
 * @author nawrin
 *
 */
public class Comp1210Grade {
	private String final_grade;
	
	private ArrayList<Entry<String, Double>> attrs;
	private ArrayList<Double> attributes;
	
	/*public Comp1210Grade(String final_grade, ArrayList<Double> attributes) {
		this.final_grade = final_grade;
		this.attributes = attributes;
	}*/
	
	public Comp1210Grade(String final_grade, ArrayList<Entry<String, Double>> attrs) {
		this.final_grade = final_grade;
		this.attrs = attrs;
	}
	

	public ArrayList<Entry<String, Double>> getAttrs() {
		return attrs;
	}


	public void setAttrs(ArrayList<Entry<String, Double>> attrs) {
		this.attrs = attrs;
	}


	public String getFinal_grade() {
		return final_grade;
	}

	public void setFinal_grade(String final_grade) {
		this.final_grade = final_grade;
	}

	public ArrayList<Double> getAttributes() {
		return attributes;
	}

	public void setAttributes(ArrayList<Double> attributes) {
		this.attributes = attributes;
	}
	
	
}
