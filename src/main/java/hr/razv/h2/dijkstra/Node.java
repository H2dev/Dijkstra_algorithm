package hr.razv.h2.dijkstra;

public class Node {
	
	char point;
	int distance;
	char infinitive;
	
	public Node(char point, int distance) {
		this.point = point;
		this.distance = distance;
	}
	
	public Node(char point, char infinitive) {
		this.point = point;
		this.infinitive = infinitive;
	}
	
	public String getNode () {
		
		String node = new String();
		
		if (this.infinitive == '#')
			node = node.concat(Character.toString(point)).concat(", ").concat(Character.toString(infinitive));
		else
			node = node.concat(Character.toString(point)).concat(", ").concat(Integer.toString(distance));
		
		return node;
	}

	public char getPoint() {
		return point;
	}

	public void setPoint(char point) {
		this.point = point;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public char getInfinitive() {
		return infinitive;
	}

	public void setInfinitive(char infinitive) {
		this.infinitive = infinitive;
	}

}
