// Name: Kexiang Fang
// Email: kfang25@wisc.edu
// Team: GB
// Role: Data Wrangler 1
// TA: Dan
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>

/**
 * This class used two private helper methods to generate one array of the data of vertices and 
 * one array of the data of edges. The public method generateGraph() used these two arrays to 
 * generate a graph which contains most of UW-Madison teaching buildings. Other developers can use 
 * generateGraph() method to create a graph and then develop more functionalities of UW-Madison Map,
 * and can use verticesToString() to show the user how many buildings are stored in our map and 
 * what are they.  
 * 
 * @author Kexiang Fang
 *
 */
public class MapInfo {
  private String[] vertices; // a String array to store the raw data of vertices
  private String[] edges; // a String array to store the raw data of edges
  // the raw data of vertices
  private String verticesData = "Chamberlin Hall, Babcock Hall, Sewell Social Sciences, "
      + "Grainger Hall, Computer Sciences, Helen C. White Hall, Conrad A. Elvehjem Building, "
      + "Medical Sciences Center, Union South, Plant Sciences, Mosse Humanities Building, "
      + "Noland Hall, Van Vleck Hall, Van Hise Hall, Ingraham Hall, Education Building, "
      + "Brogden Psychology Building, Educational Sciences, Engineering Hall, Sterling Hall";
  // the raw data of edges
  private String edgesData = "Chamberlin Hall, Sterling Hall, 6\r\n" + 
      "Sterling Hall, Chamberlin Hall, 6\r\n" + 
      "Chamberlin Hall, Medical Sciences Center, 20\r\n" + 
      "Medical Sciences Center, Chamberlin Hall, 20\r\n" + 
      "Chamberlin Hall, Brogden Psychology Building, 20\r\n" + 
      "Brogden Psychology Building, Chamberlin Hall, 20\r\n" + 
      "Chamberlin Hall, Van Hise Hall, 10\r\n" + 
      "Van Hise Hall, Chamberlin Hall, 10\r\n" + 
      "Chamberlin Hall, Grainger Hall, 30\r\n" + 
      "Grainger Hall, Chamberlin Hall, 30\r\n" + 
      "Chamberlin Hall, Babcock Hall, 50\r\n" + 
      "Babcock Hall, Chamberlin Hall, 50\r\n" + 
      "Sterling Hall, Van Vleck Hall, 8\r\n" + 
      "Van Vleck Hall, Sterling Hall, 8\r\n" + 
      "Van Vleck Hall, Ingraham Hall, 20\r\n" + 
      "Ingraham Hall, Van Vleck Hall, 20\r\n" + 
      "Ingraham Hall, Sewell Social Sciences, 8\r\n" + 
      "Sewell Social Sciences, Ingraham Hall, 8\r\n" + 
      "Sewell Social Sciences, Van Hise Hall, 10\r\n" + 
      "Van Hise Hall, Sewell Social Sciences, 10\r\n" + 
      "Ingraham Hall, Van Hise Hall, 20\r\n" + 
      "Van Hise Hall, Ingraham Hall, 20\r\n" + 
      "Sewell Social Sciences, Helen C. White Hall, 30\r\n" + 
      "Helen C. White Hall, Sewell Social Sciences, 30\r\n" + 
      "Sewell Social Sciences, Education Building, 20\r\n" + 
      "Education Building, Sewell Social Sciences, 20\r\n" + 
      "Education Building, Helen C. White Hall, 20\r\n" + 
      "Helen C. White Hall, Education Building, 20\r\n" + 
      "Helen C. White Hall, Grainger Hall, 30\r\n" + 
      "Grainger Hall, Helen C. White Hall, 30\r\n" + 
      "Grainger Hall, Mosse Humanities Building, 10\r\n" + 
      "Mosse Humanities Building, Grainger Hall, 10\r\n" + 
      "Grainger Hall, Educational Sciences, 20\r\n" + 
      "Educational Sciences, Grainger Hall, 20\r\n" + 
      "Grainger Hall, Noland Hall, 30\r\n" + 
      "Noland Hall, Grainger Hall, 30\r\n" + 
      "Noland Hall, Computer Sciences, 20\r\n" + 
      "Computer Sciences, Noland Hall, 20\r\n" + 
      "Brogden Psychology Building, Computer Sciences, 20\r\n" + 
      "Computer Sciences, Brogden Psychology Building, 20\r\n" + 
      "Brogden Psychology Building, Medical Sciences Center, 30\r\n" + 
      "Medical Sciences Center, Brogden Psychology Building, 30\r\n" + 
      "Brogden Psychology Building, Union South, 20\r\n" + 
      "Union South, Brogden Psychology Building, 20\r\n" + 
      "Computer Sciences, Union South, 20\r\n" + 
      "Union South, Computer Sciences, 20\r\n" + 
      "Union South, Engineering Hall, 20\r\n" + 
      "Engineering Hall, Union South, 20\r\n" + 
      "Engineering Hall, Medical Sciences Center, 50\r\n" + 
      "Medical Sciences Center, Engineering Hall, 50\r\n" + 
      "Engineering Hall, Babcock Hall, 30\r\n" + 
      "Babcock Hall, Engineering Hall, 30\r\n" + 
      "Babcock Hall, Sewell Social Sciences, 50\r\n" + 
      "Sewell Social Sciences, Babcock Hall, 50\r\n" + 
      "Babcock Hall, Computer Sciences, 40\r\n" + 
      "Computer Sciences, Babcock Hall, 40\r\n" + 
      "Grainger Hall, Computer Sciences, 30\r\n" + 
      "Computer Sciences, Grainger Hall, 30\r\n" + 
      "Computer Sciences, Helen C. White Hall, 60\r\n" + 
      "Helen C. White Hall, Computer Sciences, 60\r\n" + 
      "Computer Sciences, Sewell Social Sciences, 40\r\n" + 
      "Sewell Social Sciences, Computer Sciences, 40\r\n" + 
      "Helen C. White Hall, Union South, 70\r\n" +
      "Union South, Helen C. White Hall, 70\r\n" +
      "Helen C. White Hall, Medical Sciences Center, 60\r\n" +
      "Medical Sciences Center, Helen C. White Hall, 60\r\n" +
      "Conrad A. Elvehjem Building, Grainger Hall, 20\r\n" + 
      "Grainger Hall, Conrad A. Elvehjem Building, 20\r\n" + 
      "Conrad A. Elvehjem Building, Computer Sciences, 50\r\n" + 
      "Computer Sciences, Conrad A. Elvehjem Building, 50\r\n" + 
      "Sewell Social Sciences, Conrad A. Elvehjem Building, 40\r\n" + 
      "Conrad A. Elvehjem Building, Sewell Social Sciences, 40\r\n" + 
      "Medical Sciences Center, Grainger Hall, 50\r\n" +
      "Grainger Hall, Medical Sciences Center, 50\r\n" +
      "Medical Sciences Center, Babcock Hall, 40\r\n" +
      "Babcock Hall, Medical Sciences Center, 40\r\n" +
      "Union South, Noland Hall, 20\r\n" + 
      "Noland Hall, Union South, 20\r\n" + 
      "Plant Sciences, Sewell Social Sciences, 40\r\n" +
      "Sewell Social Sciences, Plant Sciences, 40\r\n" +
      "Mosse Humanities Building, Conrad A. Elvehjem Building, 7\r\n" + 
      "Conrad A. Elvehjem Building, Mosse Humanities Building, 7\r\n" + 
      "Mosse Humanities Building, Plant Sciences, 70\r\n" + 
      "Plant Sciences, Mosse Humanities Building, 70\r\n" + 
      "Noland Hall, Mosse Humanities Building, 40\r\n" + 
      "Mosse Humanities Building, Noland Hall, 40\r\n" + 
      "Noland Hall, Medical Sciences Center, 50\r\n" +
      "Medical Sciences Center, Noland Hall, 50";
  
  /**
   * The private helper method that store the raw data of vertices into an array
   */
  private void preloadVertices() {
    vertices = verticesData.split(", ");
  }
  
  /**
   * Front end developers can use this method to show the user how many buildings are stored in our 
   * map and what are they.
   * 
   * @return a String representation of all building (vertices) stored in this graph 
   */
  public String verticesToString() {
    String toStr = "There are 20 building stored in the UW-Madison Map:\n";
    String vertexToStr[] = verticesData.split(", ");
    for (String vertex: vertexToStr) {
      toStr += vertex + "\n";
    }
    return toStr;
  }
  
  /**
   * The private helper method that store the raw data of edges into an array
   */
  private void preloadEdges() {
    edges = edgesData.split("\r\n");
  }
  
  /**
   * This method used vertices array and edges array to generate a graph which contains most of 
   * UW-Madison teaching buildings. Other developers can use this method to create a graph and 
   * then develop more functionalities of UW-Madison Map.
   */
  public void generateGraph(CS400Graph<String> graph) {
    preloadVertices();
    preloadEdges();
    for (String vertex: vertices) {
      graph.insertVertex(vertex);
    }
    for (String edge: edges) {
      String[] edgeInfos = edge.split(", ");
      graph.insertEdge(edgeInfos[0], edgeInfos[1], Integer.parseInt(edgeInfos[2]));
    }
  }
}


