import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map.Entry;


public class Feature {
	/**
	 * Read the csv file and create a list of Comp1210Grade
	 * @param fileName
	 * @return
	 */
	public ArrayList<Comp1210Grade> readFile(String fileName, ArrayList<String> attributes) {
		ArrayList<Comp1210Grade> grades = new ArrayList<Comp1210Grade>();
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		
		try {

			br = new BufferedReader(new FileReader(fileName));
			line = br.readLine();
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] grade = line.split(cvsSplitBy);
				String finalGrade = grade[0];
				
				if (attributes.size() > 0) {
					ArrayList<Entry<String, Double>> entryList = new ArrayList<>();
					for (String attribute : attributes) {
						if (attribute.equalsIgnoreCase("exam1")) {
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("exam1", Double.parseDouble(grade[1]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("exam2")) {
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("exam2", Double.parseDouble(grade[2]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("finalExam")) {
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("finalExam", Double.parseDouble(grade[3]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("actvAvg")) {
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("actvAvg", Double.parseDouble(grade[4]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("quizAvg")) {
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("quizAvg", Double.parseDouble(grade[5]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("projAvg")) {
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("projAvg", Double.parseDouble(grade[6]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("actv01")) {
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("actv01", Double.parseDouble(grade[7]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("actv02")) {
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("actv02", Double.parseDouble(grade[8]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("actv03")) {
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("actv03", Double.parseDouble(grade[9]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("actv04A"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("actv04A", Double.parseDouble(grade[10]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("actv04B"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("actv04B", Double.parseDouble(grade[11]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("actv05"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("actv05", Double.parseDouble(grade[12]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("actv06"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("actv06", Double.parseDouble(grade[13]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("actv07A"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("actv07A", Double.parseDouble(grade[14]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("actv07B"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("actv07B", Double.parseDouble(grade[15]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("actv08"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("actv08", Double.parseDouble(grade[16]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("actv09"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("actv09", Double.parseDouble(grade[17]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("actv10"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("actv10", Double.parseDouble(grade[18]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("actv11"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("actv11", Double.parseDouble(grade[19]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("quiz01"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("quiz01", Double.parseDouble(grade[20]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("quiz02"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("quiz02", Double.parseDouble(grade[21]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("quiz03"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("quiz03", Double.parseDouble(grade[22]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("quiz04"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("quiz04", Double.parseDouble(grade[23]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("quiz05"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("quiz05", Double.parseDouble(grade[24]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("quiz06"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("quiz06", Double.parseDouble(grade[25]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("quiz07"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("quiz07", Double.parseDouble(grade[26]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("quiz08"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("quiz08", Double.parseDouble(grade[27]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("quiz09"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("quiz09", Double.parseDouble(grade[28]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("quiz10"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("quiz10", Double.parseDouble(grade[29]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("quiz11"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("quiz11", Double.parseDouble(grade[30]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("proj01"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("proj01", Double.parseDouble(grade[31]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("proj02"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("proj02", Double.parseDouble(grade[32]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("proj03"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("proj03", Double.parseDouble(grade[33]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("proj04"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("proj04", Double.parseDouble(grade[34]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("proj05"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("proj05", Double.parseDouble(grade[35]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("proj06"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("proj06", Double.parseDouble(grade[36]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("proj07A"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("proj07A", Double.parseDouble(grade[37]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("proj07B"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("proj07B", Double.parseDouble(grade[38]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("proj08"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("proj08", Double.parseDouble(grade[39]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("proj09"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("proj09", Double.parseDouble(grade[40]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("proj10"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("proj10", Double.parseDouble(grade[41]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("proj11"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("proj11", Double.parseDouble(grade[42]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("Absent"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("Absent", Double.parseDouble(grade[43]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("Tardy"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("Tardy", Double.parseDouble(grade[44]));
							entryList.add(entry);
						}
						else if (attribute.equalsIgnoreCase("Bonus"))
						{
							Entry<String, Double> entry = new java.util.AbstractMap.SimpleEntry<>("Bonus", Double.parseDouble(grade[45]));
							entryList.add(entry);
						}
								
					}
					Comp1210Grade compGrade = new Comp1210Grade(finalGrade, entryList);
					grades.add(compGrade);
				}		
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return grades;
	}
	
	
}
