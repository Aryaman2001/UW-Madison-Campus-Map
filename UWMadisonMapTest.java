// --== CS400 File Header Information ==-- 
// Name: Aryaman Agarwal
// Email: agarwal59@wisc.edu
// Team: GB
// Role: Test Engineer 2
// TA: Dan
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * UWMadisonMapTest uses Junit to test the Backend class, which is provided data
 * by the MapInfo class. Specifically tests the containsVertex, addBuilding,
 * getPath and getPathDistance methods.
 * 
 * @author Aryaman Agarwal
 *
 */
public class UWMadisonMapTest {

	/**
	 * Testing the containsVertex method with some vertices that exist and some
	 * which do not.
	 */
	@Test
	void testContainsVertex() {
		{// test #1: calling containsVertex on vertices that exist
			Backend test1 = new Backend();
			String[] vertices = { "Chamberlin Hall", "Babcock Hall", "Sewell Social Sciences", "Computer Sciences",
					"Helen C. White Hall", "Union South", "Plant Sciences", "Mosse Humanities Building", "Noland Hall",
					"Van Vleck Hall", "Van Hise Hall", "Education Building", "Brogden Psychology Building",
					"Educational Sciences" };

			for (int i = 0; i < vertices.length; ++i) {
				if (!test1.containsVertex(vertices[i])) {
					fail("Missing Vertex " + vertices[i]);
				}
			}
		}

		{// test #2: calling containsVertex on vertices that do not exist
			Backend test2 = new Backend();
			String[] vertices = { "ChamberlinHall", "Babock Hall", "Sewell Sciences", "Grainnger Hall",
					"Computer Scices", "Test Hall", "Van Hise", "ngraham Hal" };

			for (int i = 0; i < vertices.length; ++i) {
				if (test2.containsVertex(vertices[i])) {
					fail("Unexpected Vertex " + vertices[i]);
				}
			}
		}
	}

	/**
	 * Tests the addBuilding method. Adding new buildings, adding null and adding
	 * duplicates are tested.
	 */
	@Test
	void testAddBuilding() {
		{// test #1: testing adding new buildings
			Backend test1 = new Backend();
			if (!test1.addBuilding("Test Hall") || !test1.containsVertex("Test Hall")) {
				fail("addbuilding did not work as expected");
			}

			if (!test1.addBuilding("12345") || !test1.containsVertex("12345")) {
				fail("addbuilding did not work as expected");
			}

			if (!test1.addBuilding(".") || !test1.containsVertex(".")) {
				fail("addbuilding did not work as expected");
			}
		}

		{// test #2: testing adding null
			Backend test2 = new Backend();
			try {
				test2.addBuilding(null);
				fail("null was added");
			} catch (NullPointerException e1) {
				// addBuilding works as expected
			} catch (Exception e2) {
				fail("Unexpected exceeption thrown");
			}
		}

		{// test #3: testing adding duplicates
			Backend test3 = new Backend();
			test3.addBuilding("Test Hall");

			if (test3.addBuilding("Chamberlin Hall")) {
				fail("addbuilding added a duplicate");
			}
			if (test3.addBuilding("Test Hall")) {
				fail("addbuilding added a duplicate");
			}
			if (test3.addBuilding("Sterling Hall")) {
				fail("addbuilding added a duplicate");
			}
		}
	}

	/**
	 * Tests pathing by between two adjacent vertices and two distant vertices in
	 * the graph.
	 */
	@Test
	void testPath() {
		{// test#1: testing path between adjacent vertices
			Backend test1 = new Backend();
			String startBuilding = "Van Vleck Hall";
			String endBuilding = "Ingraham Hall";

			String retPath = test1.getPath(startBuilding, endBuilding);
			int retDistance = test1.getPathDistance(startBuilding, endBuilding);

			if (!retPath.equals("[" + startBuilding + ", " + endBuilding + "]")) {
				fail("getPath did not work as expected");
			}
			if (retDistance != 20) {
				fail("getPathDistance did not work as expected");
			}
		}

		{// test#2: testing path between adjacent vertices
			Backend test2 = new Backend();
			String startBuilding = "Sewell Social Sciences";
			String endBuilding = "Helen C. White Hall";

			String retPath = test2.getPath(startBuilding, endBuilding);
			int retDistance = test2.getPathDistance(startBuilding, endBuilding);

			if (!retPath.equals("[" + startBuilding + ", " + endBuilding + "]")) {
				fail("getPath did not work as expected");
			}
			if (retDistance != 30) {
				fail("getPathDistance did not work as expected");
			}
		}

		{// test#3: testing path between distant vertices
			Backend test3 = new Backend();
			String startBuilding = "Brogden Psychology Building";
			String endBuilding = "Noland Hall";

			String retPath = test3.getPath(startBuilding, endBuilding);
			int retDistance = test3.getPathDistance(startBuilding, endBuilding);

			if (!retPath.equals("[Brogden Psychology Building, Computer Sciences, Noland Hall]")) {
				fail("getPath did not work as expected");
			}
			if (retDistance != 40) {
				fail("getPathDistance did not work as expected");
			}
		}
	}
}
