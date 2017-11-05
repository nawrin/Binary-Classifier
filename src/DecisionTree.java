import java.util.ArrayList;
import java.util.Map.Entry;



public class DecisionTree {
	private ArrayList<Comp1210Grade> gradeList;
	private static final int CATEGORY = 3;
	
	public DecisionTree(ArrayList<Comp1210Grade> gradeList) {
		this.gradeList = gradeList;
	}

	public ArrayList<Comp1210Grade> getGradeList() {
		return gradeList;
	}

	public void setGradeList(ArrayList<Comp1210Grade> gradeList) {
		this.gradeList = gradeList;
	}
	
	public String getAttributeWithHighestGain() {
		Comp1210Grade gradeEntry = gradeList.get(0);
		double max = Double.MIN_VALUE;
		String highestGainAttr = null;
		for (Entry<String, Double> attr : gradeEntry.getAttrs()) {
			double gain = calculateGain(attr);
			if (gain > max) {
				max = gain;
				highestGainAttr = attr.getKey();
			}
		}
		return highestGainAttr;
	}
	private double calculateGain(Entry<String, Double> attribute) {
		return calculateEntropyOfGoal() - calculateRemainder(attribute);		
	}
	
	private double calculateRemainder(Entry<String, Double> attributes) {
		double remainder = 0;
		
		for (int i = 0; i < CATEGORY; i++) {
			remainder += calculateSum(i, attributes.getKey());
		}
		
		
		return remainder;
	}
	
	private double calculateSum(int i, String attribute) {
		int category = 0;
		int categoryWithPass = 0;
		for (Comp1210Grade grade : gradeList) {
			
			for (Entry<String, Double> attr : grade.getAttrs()) {
				if (attr.getKey().equalsIgnoreCase(attribute)) {
					//3 category of data
					//(0-30), (31- 59) and (>=60))
					if (i == 0) {
						if (attr.getValue() >=0 && attr.getValue() <= 30) {
							category++;
							if (grade.getFinal_grade().equalsIgnoreCase("pass")) {
								categoryWithPass++;
							}
						}
						
					}
					else if (i == 1) {
						if (attr.getValue() > 30 && attr.getValue() < 60) {
							category++;
							if (grade.getFinal_grade().equalsIgnoreCase("pass")) {
								categoryWithPass++;
							}
						}
					}
					else {
						if (attr.getValue() >= 60) {
							category++;
							if (grade.getFinal_grade().equalsIgnoreCase("pass")) {
								categoryWithPass++;
							}
						}
					}
					
				}
			}
		}
		double b, q = 0;
		if (category != 0) {
			q = (double) categoryWithPass/category;
		}
	
		if (q == 0 || q == 1) 
			b = 0;
		else
			b = calculateEntropy(q);
		return b * ((double) category/gradeList.size());
	}
	
	private double calculateEntropyOfGoal() {
		int p = 0;
		int n = 0;
		for (Comp1210Grade grade : gradeList) {
			if (grade.getFinal_grade().equalsIgnoreCase("pass")) {
				p++;
			}
			else {
				n++;
			}
		}
		double q = (double) p/(p+n);
		return calculateEntropy(q);
	}
	
	private double calculateEntropy(double q) {
		return - (q * (Math.log(q) / Math.log(2)) + (1 - q) * (Math.log(1 - q) / Math.log(2)));
	}
}
