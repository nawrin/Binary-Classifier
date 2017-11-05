import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Scanner;


public class DecisionTreeTest {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String fileName = "COMP1210-F2015-DecisionTree.csv";
		ArrayList<Comp1210Grade> grades;
		ArrayList<String> list = new ArrayList<String>();
		
		System.out.println("Enter attributes for Tree generation. Enter q to quit: ");
		String input = scanner.nextLine();
		while(!input.equalsIgnoreCase("q")) {
			list.add(input);
			input = scanner.nextLine();
		}
		/*list.add("exam1");
		//list.add("exam2");
		list.add("quizAvg");
		list.add("actvAvg");
		//list.add("quiz03");
		list.add("projAvg");
		//list.add("proj08");
		//list.add("proj09");
*/		
		Feature feature = new Feature();
		grades = feature.readFile(fileName, list);
		
		ArrayList<Entry<Integer, ArrayList<Node>>> nodeList = new ArrayList<>();
		DecisionTree DT;
		Node rootNode = null;
		int treeLevel = 0;
		while(true) {
			if (grades.get(0).getAttrs().size() == 0) {
				Entry<Integer, ArrayList<Node>> tmp = (Entry<Integer, ArrayList<Node>>) nodeList.get(treeLevel);
				ArrayList<Node> nodes = tmp.getValue();
				
				for(Node node : nodes) {
					if (!node.isLeaf()) {
						if (node.getPassCount() > node.getFailCount())
							node.setFinal_label("pass");
						else
							node.setFinal_label("fail");
					}
				}
				break;
			}
			
			DT = new DecisionTree(grades);
			String attr = DT.getAttributeWithHighestGain();
			if (treeLevel == 0) {
				ArrayList<Node> node = new ArrayList<Node>();
				rootNode = new Node(attr);
				rootNode.setRoot(true);
				node.add(rootNode);
				int p = 0;
				int n = 0;
				for (Comp1210Grade grade : grades) {
					if (grade.getFinal_grade().equalsIgnoreCase("pass")) {
						p++;
					}
					else {
						n++;
					}
				}
				rootNode.setPassCount(p);
				rootNode.setFailCount(n);
				
				Entry<Integer, ArrayList<Node>> entry = new java.util.AbstractMap.SimpleEntry<Integer, ArrayList<Node>>(treeLevel, node);
				nodeList.add(entry);
				createPartition(rootNode, nodeList, grades, treeLevel);
				rootNode.setRoot(false);
				removeAttributeFromGrade(attr, grades);
				treeLevel++;
			}
			else{
				Entry<Integer, ArrayList<Node>> tmp = (Entry<Integer, ArrayList<Node>>) nodeList.get(treeLevel);
				ArrayList<Node> nodes = tmp.getValue();
				ArrayList<Comp1210Grade> grade;
				for(Node node : nodes) {
					if (!node.isLeaf()) {
						node.setRoot(true);
						node.setNodeName(attr);
						if (node.getLinkType().equalsIgnoreCase("type1")) {
							grade = node.getGradeList1();
						}
						else {
							grade = node.getGradeList2();
						}
						/*else {
							grade = node.getGradeList3();
						}*/
						createPartition(node, nodeList, grade, treeLevel);
						node.setRoot(false);
					}
				}
				removeAttributeFromGrade(attr, grades);
				treeLevel++;			
			}
			
			if (!checkEachLevel(nodeList, treeLevel)) break;
				
		}
		
		printTree(nodeList);
	}
	
	private static void printTree(ArrayList<Entry<Integer, ArrayList<Node>>> nodeList) {
		Entry<Integer, ArrayList<Node>> tmp;
		ArrayList<Node> nodes;
		for (int i = 0; i < nodeList.size(); i++) {
			tmp = nodeList.get(i);
			nodes = tmp.getValue();
			for (Node node : nodes) {
				if (!node.isLeaf()) {
					System.out.print("Level" + i + ":\t" + node.getNodeName() + "\tPass->" +node.getPassCount()+ "\tFail-> " + node.getFailCount());
				}
				else {
					System.out.print("\t" + node.getFinal_label());
				}
			}
			System.out.println();
		}
	}
	
	private static boolean checkEachLevel(ArrayList<Entry<Integer, ArrayList<Node>>> nodeList, int treeLevel) {
		Entry<Integer, ArrayList<Node>> tmp = (Entry<Integer, ArrayList<Node>>) nodeList.get(treeLevel);
		ArrayList<Node> nodes = tmp.getValue();
		
		for(Node node : nodes) {
			if (!node.isLeaf()) {
				return true;
			}
		}
		return false;
	}
	
	private static void removeAttributeFromGrade(String attr, ArrayList<Comp1210Grade> grades) {
		ArrayList<Comp1210Grade> tmp = grades;
		for (Comp1210Grade g : tmp) {
			for (int i = 0; i < g.getAttrs().size(); i++) {
				if (g.getAttrs().get(i).getKey().equalsIgnoreCase(attr)) {
					g.getAttrs().remove(i);
				}
			}
		}
		grades = tmp;
	}
	
	//partition a node based on category
	private static void createPartition(Node node, ArrayList<Entry<Integer, ArrayList<Node>>> nodeList, ArrayList<Comp1210Grade> grades, int treeLevel) {
		ArrayList<String> part1 = new ArrayList<String>();
		ArrayList<String> part2 = new ArrayList<String>();
		ArrayList<String> part3 = new ArrayList<String>();
		
		ArrayList<Comp1210Grade> gradeList1 = new ArrayList<Comp1210Grade>();
		ArrayList<Comp1210Grade> gradeList2 = new ArrayList<Comp1210Grade>();
		ArrayList<Comp1210Grade> gradeList3 = new ArrayList<Comp1210Grade>();
		
		Node category1 = new Node("");
		Node category2 = new Node("");
		Node category3 = new Node("");
		
		//nodeList.add(node);
		for (Comp1210Grade grade : grades) {
			for (Entry<String, Double> entry : grade.getAttrs()) {
				if (entry.getKey().equalsIgnoreCase(node.getNodeName())) {
					if (node.getNodeName().contains("proj")) {
						double value = entry.getValue() * .25;
						if(value >=0 && value < 15) {
							part1.add(grade.getFinal_grade());
							gradeList1.add(grade);
							break;
						}
						else if(value >= 15 && value <= 25) {
							part2.add(grade.getFinal_grade());
							gradeList2.add(grade);
							break;
						}
					}
					
					if (node.getNodeName().contains("exam1")) {
						double value = entry.getValue() * .15;
						if(value >=0 && value < 9) {
							part1.add(grade.getFinal_grade());
							gradeList1.add(grade);
							break;
						}
						else if(value >= 9 && value <= 15) {
							part2.add(grade.getFinal_grade());
							gradeList2.add(grade);
							break;
						}
					}
					
					if (node.getNodeName().contains("exam2")) {
						double value = entry.getValue() * .15;
						if(value >=0 && value < 9) {
							part1.add(grade.getFinal_grade());
							gradeList1.add(grade);
							break;
						}
						else if(value >= 9 && value <= 15) {
							part2.add(grade.getFinal_grade());
							gradeList2.add(grade);
							break;
						}
					}
					
					if (node.getNodeName().contains("final")) {
						double value = entry.getValue() * .30;
						if(value >=0 && value < 18) {
							part1.add(grade.getFinal_grade());
							gradeList1.add(grade);
							break;
						}
						else if(value >= 18 && value <= 30) {
							part2.add(grade.getFinal_grade());
							gradeList2.add(grade);
							break;
						}
					}
					
					if (node.getNodeName().contains("quiz")) {
						double value = entry.getValue() * .10;
						if(value >=0 && value < 6) {
							part1.add(grade.getFinal_grade());
							gradeList1.add(grade);
							break;
						}
						else if(value >= 6 && value <= 10) {
							part2.add(grade.getFinal_grade());
							gradeList2.add(grade);
							break;
						}
					}
					if (node.getNodeName().contains("act")) {
						double value = entry.getValue() * .05;
						if(value >=0 && value < 3) {
							part1.add(grade.getFinal_grade());
							gradeList1.add(grade);
							break;
						}
						else if(value >= 3 && value <= 5) {
							part2.add(grade.getFinal_grade());
							gradeList2.add(grade);
							break;
						}
					}
					
					/*if(entry.getValue() >=0 && entry.getValue() <=30) {
						part1.add(grade.getFinal_grade());
						gradeList1.add(grade);
						break;
					}
					else if(entry.getValue() > 30 && entry.getValue() < 60) {
						part2.add(grade.getFinal_grade());
						gradeList2.add(grade);
						break;
					}
					else {
						part3.add(grade.getFinal_grade());
						gradeList3.add(grade);
						break;
					}*/
				}
			}
		}
		
		node.setPartition1(part1);
		node.setPartition2(part2);
		//node.setPartition3(part3);
		
		int countPass = 0;
		int countFail = 0;
		
		if (node.getPartition1().size() > 0) {
			for (String s : node.getPartition1()) {
				if (s.equalsIgnoreCase("pass")) {
					countPass++;
				}
				else
					countFail++;
			}
			
			if (countPass == node.getPartition1().size() || countFail == node.getPartition1().size()) {
				node.setCategory1(category1);
				node.getCategory1().setLeaf(true);
				node.getCategory1().setGradeList1(gradeList1);
				node.getCategory1().setPassCount(countPass);
				node.getCategory1().setFailCount(countFail);
				node.getCategory1().setParent(node);
				node.getCategory1().setLinkType("type1");
				if (countPass == node.getPartition1().size())
					node.getCategory1().setFinal_label("pass");
				else
					node.getCategory1().setFinal_label("fail");
			}
			
			else {
				category1.setLeaf(false);
				category1.setParent(node);
				category1.setPassCount(countPass);
				category1.setFailCount(countFail);
				category1.setGradeList1(gradeList1);
				category1.setLinkType("type1");
				node.setCategory1(category1);
			}
			
		}
		else {
			node.setCategory1(category1);
			node.getCategory1().setLeaf(true);
			node.getCategory1().setParent(node);
			node.getCategory1().setLinkType("type1");
			//node.getCategory1().setPassCount(countPass);
			//node.getCategory1().setFailCount(countFail);
			
			if (node.getPassCount() > node.getFailCount())
				node.getCategory1().setFinal_label("pass");
			else
				node.getCategory1().setFinal_label("fail");
		}
		
		
		
		
		int countPassPart2 = 0;
		int countFailPart2 = 0;
		
		if (node.getPartition2().size() > 0) {
			for (String s : node.getPartition2()) {
				if (s.equalsIgnoreCase("pass")) {
					countPassPart2++;
				}
				else
					countFailPart2++;
			}
			
			if (countPassPart2 == node.getPartition2().size() || countFailPart2 == node.getPartition2().size()) {
				node.setCategory2(category2);
				node.getCategory2().setLeaf(true);
				node.getCategory2().setPassCount(countPassPart2);
				node.getCategory2().setFailCount(countFailPart2);
				node.getCategory2().setGradeList2(gradeList2);
				node.getCategory2().setLinkType("type2");
				node.setParent(node);
				if (countPassPart2 == node.getPartition2().size())
					node.getCategory2().setFinal_label("pass");
				else
					node.getCategory2().setFinal_label("fail");
			}
			else {
				category2.setLeaf(false);
				category2.setParent(node);
				category2.setPassCount(countPassPart2);
				category2.setFailCount(countFailPart2);
				category2.setGradeList2(gradeList2);
				category2.setLinkType("type2");
				node.setCategory2(category2);
			}
		}
		else {
			node.setCategory2(category2);
			node.getCategory2().setLeaf(true);
			node.getCategory2().setParent(node);
			node.getCategory2().setLinkType("type2");
			if (node.getPassCount() > node.getFailCount())
				node.getCategory2().setFinal_label("pass");
			else
				node.getCategory2().setFinal_label("fail");
		}
		
		/*int countPassPart3 = 0;
		int countFailPart3 = 0;
		
		if (node.getPartition3().size() > 0) {
			for (String s : node.getPartition3()) {
				if (s.equalsIgnoreCase("pass")) {
					countPassPart3++;
				}
				else
					countFailPart3++;
			}
			
			if (countPassPart3 == node.getPartition3().size() || countFailPart3 == node.getPartition3().size()) {
				node.setCategory3(category3);
				node.getCategory3().setLeaf(true);
				node.getCategory3().setPassCount(countPassPart3);
				node.getCategory3().setFailCount(countFailPart3);
				node.getCategory3().setGradeList3(gradeList3);
				node.getCategory3().setLinkType("type3");
				node.setParent(node);
				if (countPassPart3 == node.getPartition3().size())
					node.getCategory3().setFinal_label("pass");
				else
					node.getCategory3().setFinal_label("fail");
			}
			else {
				category3.setLeaf(false);
				category3.setParent(node);
				category3.setPassCount(countPassPart3);
				category3.setFailCount(countFailPart3);
				category3.setGradeList3(gradeList3);
				category3.setLinkType("type3");
				node.setCategory3(category3);
			}
		}
		else {
			node.setCategory3(category3);
			node.getCategory3().setLeaf(true);
			node.getCategory3().setParent(node);
			node.getCategory3().setLinkType("type3");
			if (node.getPassCount() > node.getFailCount())
				node.getCategory3().setFinal_label("pass");
			else
				node.getCategory3().setFinal_label("fail");
		}*/
		
		//update nodeList
		ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(category1);
		nodes.add(category2);
		//nodes.add(category3);
		
		boolean isAlreadyPresent = false;;
		for (Entry<Integer, ArrayList<Node>> e : nodeList) {
			if (e.getKey() == treeLevel + 1) {
				isAlreadyPresent = true;
			}
		}
		if (!isAlreadyPresent) {
			Entry<Integer, ArrayList<Node>> entry = new java.util.AbstractMap.SimpleEntry<Integer, ArrayList<Node>>(treeLevel+1, nodes);
			nodeList.add(entry);
		}
		else {
			nodeList.get(treeLevel + 1).getValue().addAll(nodes);
		}
		
	}
}
