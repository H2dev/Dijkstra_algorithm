package hr.razv.h2.dijkstra;

import java.util.ArrayList;

public class ResultModel {
	
	ArrayList<Character> resultRoute = new ArrayList<Character>();
	int resultRouteDistance = 0;
	
	public ResultModel(ArrayList<Character> resultRoute,
			int resultRouteDistance) {
		super();
		this.resultRoute = resultRoute;
		this.resultRouteDistance = resultRouteDistance;
	}

	public ArrayList<Character> getResultRoute() {
		return resultRoute;
	}

	public void setResultRoute(ArrayList<Character> resultRoute) {
		this.resultRoute = resultRoute;
	}

	public int getResultRouteDistance() {
		return resultRouteDistance;
	}

	public void setResultRouteDistance(int resultRouteDistance) {
		this.resultRouteDistance = resultRouteDistance;
	}

}
