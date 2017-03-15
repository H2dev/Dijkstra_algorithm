package hr.razv.h2.dijkstra;

import java.util.ArrayList;
import java.util.Collections;

public class NodeList {

	public String[][] matrixSus;

	public NodeList(String matrixSus[][]) {
		this.matrixSus = matrixSus;
	}

	public ResultModel calculateRouteDistance() {

		int n = matrixSus[0].length;
		int difference;
		int lastIndex;
		int routeDistance;

		ArrayList<Node> S = new ArrayList<Node>();
		ArrayList<Node> T = new ArrayList<Node>();
		ArrayList<Character> distance = new ArrayList<Character>();

		Character finalPoint = new Character('A');

		Node a = new Node('A', 0);
		S.add(a);

		// FILLING IN THE BEGINNING - 'T' LIST
		Node b;
		Node c;

		for (int i = 1; i < n; i++) {

			if (!matrixSus[i][0].equals("#")) {
				b = new Node((char) (65 + i), Integer.valueOf(matrixSus[i][0]));
			} else {
				b = new Node((char) (65 + i), (char) '#');
			}
			if (i == (n - 1)) {
				finalPoint = b.getPoint();
			}

			T.add(b);
		}

		// ADDING IN THE 'S' LIST
		while (T.size() > 0) {

			int indexMinDistance = 0;
			int minDistance = T.get(0).getDistance();
			char minPoint = T.get(0).getPoint();

			for (int i = 1; i < T.size(); i++) {
				if (T.get(i).getInfinitive() != '#' && T.get(i).getDistance() < minDistance) {
					minDistance = T.get(i).getDistance();
					minPoint = T.get(i).getPoint();
					indexMinDistance = i;
				}
			}

			c = new Node(minPoint, minDistance);
			S.add(c);
			if (finalPoint.equals(c.getPoint())) {
				break;
			}
			T.remove(indexMinDistance);

			// MODIFICATING NEW DISTANCES IN THE 'T' LIST
			for (int i = 0; i < T.size(); i++) {

				String nextDistance = matrixSus[(int) minPoint - 65][(int) T.get(i).getPoint() - 65];
				if (!nextDistance.equals("#"))
					if (minDistance + Integer.valueOf(nextDistance) < T.get(i).getDistance()) {
						T.get(i).setDistance(minDistance + Integer.valueOf(nextDistance));
					}
				if (T.get(i).getInfinitive() == '#' && (!nextDistance.equals("#"))) {
					T.get(i).setDistance(minDistance + Integer.valueOf(nextDistance));
					T.get(i).setInfinitive(' ');
				}

			}

		}

		// FILLING THE ROUTE
		lastIndex = S.size() - 1;
		distance.add(S.get(lastIndex).getPoint());

		for (int i = S.size() - 2; i >= 0; i--) {
			difference = S.get(lastIndex).getDistance() - S.get(i).getDistance();
			String stringForChecking = matrixSus[(int) S.get(lastIndex).getPoint() - 65][(int) S.get(i).getPoint()
					- 65];
			if (stringForChecking.equals("#") || stringForChecking == null) {
			} else if (difference == Integer.valueOf(stringForChecking)) {
				distance.add(S.get(i).getPoint());
				lastIndex = i;
			}
		}
		routeDistance = S.get(S.size() - 1).getDistance();
		Collections.reverse(distance);

		return new ResultModel(distance, routeDistance);
	}
}