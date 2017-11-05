import java.util.ArrayList;


public class Node {
	private String nodeName;
	private boolean isLeaf;
	private ArrayList<String> partition1;
	private ArrayList<String> partition2;
	private ArrayList<String> partition3;
	private String final_label;
	private Node parent;
	private Node category1;
	private Node category2;
	private Node category3;
	private boolean isRoot;
	private int passCount;
	private int failCount;
	private String linkType;
	//private String linkType2;
	//private String linkType3;
	private ArrayList<Comp1210Grade> gradeList1;
	private ArrayList<Comp1210Grade> gradeList2;
	private ArrayList<Comp1210Grade> gradeList3;
	
	
	
	public String getLinkType() {
		return linkType;
	}

	public void setLinkType(String linkType1) {
		this.linkType = linkType1;
	}

	/*public String getLinkType2() {
		return linkType2;
	}

	public void setLinkType2(String linkType2) {
		this.linkType2 = linkType2;
	}

	public String getLinkType3() {
		return linkType3;
	}

	public void setLinkType3(String linkType3) {
		this.linkType3 = linkType3;
	}*/

	public ArrayList<Comp1210Grade> getGradeList1() {
		return gradeList1;
	}

	public void setGradeList1(ArrayList<Comp1210Grade> gradeList1) {
		this.gradeList1 = gradeList1;
	}

	public ArrayList<Comp1210Grade> getGradeList2() {
		return gradeList2;
	}

	public void setGradeList2(ArrayList<Comp1210Grade> gradeList2) {
		this.gradeList2 = gradeList2;
	}

	public ArrayList<Comp1210Grade> getGradeList3() {
		return gradeList3;
	}

	public void setGradeList3(ArrayList<Comp1210Grade> gradeList3) {
		this.gradeList3 = gradeList3;
	}
	
	public int getPassCount() {
		return passCount;
	}

	public void setPassCount(int passCount) {
		this.passCount = passCount;
	}

	public int getFailCount() {
		return failCount;
	}

	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}

	public boolean isRoot() {
		return isRoot;
	}

	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}

	private ArrayList<Comp1210Grade> grades;
	
	public Node(String name) {
		//grades = gradeList;
		nodeName = name;
	}
	
	public Node getCategory1() {
		return category1;
	}

	public void setCategory1(Node category1) {
		this.category1 = category1;
	}

	public Node getCategory2() {
		return category2;
	}

	public void setCategory2(Node category2) {
		this.category2 = category2;
	}

	public Node getCategory3() {
		return category3;
	}

	public void setCategory3(Node category3) {
		this.category3 = category3;
	}

	public void createTree() {
		
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public ArrayList<String> getPartition1() {
		return partition1;
	}

	public void setPartition1(ArrayList<String> partition1) {
		this.partition1 = partition1;
	}

	public ArrayList<String> getPartition2() {
		return partition2;
	}

	public void setPartition2(ArrayList<String> partition2) {
		this.partition2 = partition2;
	}

	public ArrayList<String> getPartition3() {
		return partition3;
	}

	public void setPartition3(ArrayList<String> partition3) {
		this.partition3 = partition3;
	}

	public String getFinal_label() {
		return final_label;
	}

	public void setFinal_label(String final_label) {
		this.final_label = final_label;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public ArrayList<Comp1210Grade> getGrades() {
		return grades;
	}

	public void setGrades(ArrayList<Comp1210Grade> grades) {
		this.grades = grades;
	}
}
