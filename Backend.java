// --== CS400 File Header Information ==--
// Name: Liza Szymborski
// Email: lmszymborski@wisc.edu
// Team: GB
// Role: Back End Developer 1
// TA: Daniel Kiel
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>
/**
 * This backend class navigates the CS400Graph Ensures that all search terms are trimmed and to
 * lower case so search terms can be found even when not correctly formatted Allows the user to get
 * connecting buildings for any building name, get the shortest path and distance for any building
 * to another building, add an edge from one building to another, add a new building to the graph,
 * check if the graph contains an edge from one building to another, check if the graph contains a
 * given building, and remove a building from the graph
 * 
 * @author lizaszymborski
 *
 */
public class Backend {
  private CS400Graph<String> graph;

  /**
   * create new Backend type with the CS400Graph parametized with String
   */
  public Backend() {
    graph = new CS400Graph<>();
    MapInfo mapInfo = new MapInfo();
    mapInfo.generateGraph(graph);

  }

  /**
   * adds an edge with source building, target building, and distance connecting
   * 
   * @param source   - source building
   * @param target   - building the edge is connecting to
   * @param distance - weight of edge
   * @return true if added correctly, false if not
   */
  public boolean addEdge(String source, String target, int distance) {
    if (graph.insertEdge(source.trim(),
            target.trim(), distance)) // if it successfully adds
      // the edge
      return true;
    return false;
  }

  /**
   * adds a vertex with name to the graph
   * 
   * @param name - name of the building
   * @return true if added correctly, false if not
   */
  public boolean addBuilding(String name) {
    if (graph.insertVertex(name.trim())) // if it successfully adds the vertex
      return true;
    return false;
  }

  /**
   * removes a vertex with passed in name to the graph
   * 
   * @param name - name of vertex to remove
   * @return - true if removed correctly, false if not
   */
  public boolean removeBuilding(String name) {
    if (graph.removeVertex(name.trim())) // if it successfully removes vertex
      return true;
    return false;
  }

  /**
   * removes the connection from one building to another
   * 
   * @param source - source building of the edge
   * @param target - target building of the edge
   * @return true if removed correctly, false if not
   */
  public boolean removeEdge(String source, String target) {
    if (graph.removeEdge(source.trim(), target.trim()))
      return true;
    return false;
  }

  /**
   * checks if the graph contain a vertex with name passed in
   * 
   * @param name - name of vertex to check
   * @return true if it contains it, false if not
   */
  public boolean containsVertex(String name) {
    if (graph.containsVertex(name.trim()))
      return true;
    return false;
  }

  /**
   * Checks if the graph contains an edge from source to target
   * 
   * @param source - source vertex name
   * @param target - source target name
   * @return true if it does, false if not
   */
  public boolean containsEdge(String source, String target) {
    if (graph.containsEdge(source.trim(), target.trim()))
      return true;
    return false;
  }

  /**
   * Returns all the connecting buildings to the name passed in
   * 
   * @param name - name of the vertex to look up
   * @return - string of all the connecting buildings
   */
  public String connectingBuildings(String name) {
    return graph.vertices.get(name.trim()).edgesLeaving.toString();
  }

  /**
   * Returns the shortest path from start to end
   * 
   * @param start - where it is starting
   * @param end   - where it is ending
   * @return - string of the shortest path connecting
   */
  public String getPath(String start, String end) {
    return graph.shortestPath(start.trim(), end.trim()).toString();
  }

  /**
   * Returns the shortest path distance from start to end
   * 
   * @param start - where it is starting
   * @param end   - where it is ending
   * @return - total distance of the shortest path connecting
   */
  public int getPathDistance(String start, String end) {
    return graph.getPathCost(start.trim(), end.trim());
  }
}