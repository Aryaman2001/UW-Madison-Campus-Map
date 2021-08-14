// --== CS400 File Header Information ==--
// Name: Yiting Liao
// Email: liao52@wisc.edu
// Team: GB
// Role: Front End Developer 1
// TA: Dan
// Lecturer: Gary Dahl
// Notes to Grader: <optional extra notes>
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Front end implementation for this project based on graph and Dijkstra's shortest algorithm
 * 
 * @author Yiting liao
 *
 */
public class FrontEnd {
  public static Backend backend;

  /**
   * Here is the main method to run the program
   * 
   * @param args
   */
  public static void main(String[] args) {
    List<String> path = new ArrayList<>();
    backend = new Backend();
    System.out.println("Welcome to UW-Madison’s campus tool");
    System.out.println(
        "Enter N to add building into your path,Enter D remove building from your path,Enter Q to calc the shortest distance and exit the tool");
    Scanner sc = new Scanner(System.in);
    while (true) {
      String in = sc.nextLine();
      if ("N".equals(in)) {
        addBuilding(path);
      } else if ("D".equals(in)) {
        removeBuilding(path);
      } else if ("Q".equals(in)) {
        break;
      } else {
        System.out.println("command is not correct");
      }
    }
    if (path.size() == 1) {
      return;
    }
    // to calculate the distance between two building which the user add
    System.out.println("The shortest path is " + backend.getPath(path.stream().findFirst().get(),
        path.stream().skip(path.size() - 1).findFirst().get()));
    System.out.println("The shortest path's distance is " + backend.getPathDistance(
        path.stream().findFirst().get(), path.stream().skip(path.size() - 1).findFirst().get()));
  }

  /**
   * This method here is to add the specified building.
   * 
   * @param path
   */
  public static void addBuilding(List<String> path) {
    System.out.println("Please input your  building");
    Scanner sc = new Scanner(System.in);
    String building = sc.nextLine().trim();
    if (!backend.containsVertex(building)) {
      System.out.println("your added building does not exist");
    } else {
      path.add(building);
      System.out.println(building + " has been add to path");
    }
    System.out.println(
        "Enter N to add building into your path,Enter D remove building from your path,Enter Q to calc the shortest distance and exit the tool");
  }

  /**
   * this method here is to remove the building the user add
   * 
   * @param path
   */
  public static void removeBuilding(List<String> path) {
    String building;
    Scanner sc = new Scanner(System.in);
    System.out.println("please input your  building");
    building = sc.nextLine().trim();
    if ("Chamberlin Hall".equals(building)) {
      System.out.println("can't remove Chamberlin Hall");
    }
    if (path.indexOf(building) == -1) {
      System.out.println("the building dose not exist your path");
    } else {
      path.remove(path.indexOf(building));
      System.out.println(building + "has been remove from path");
    }

    System.out.println(
        "Enter N to add building into your path,Enter D remove building from your path,Enter Q to calc the shortest distance and exit the tool");
  }
}