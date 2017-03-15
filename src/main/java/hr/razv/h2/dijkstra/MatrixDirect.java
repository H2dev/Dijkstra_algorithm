package hr.razv.h2.dijkstra;

public class MatrixDirect {
	
	public static ResultModel processMatrix( int n, String[][] matrixSus ) {
	
		NodeList nodeList = new NodeList( matrixSus );
		ResultModel result = nodeList.calculateRouteDistance();   
				
		return result;
	}
	

}
