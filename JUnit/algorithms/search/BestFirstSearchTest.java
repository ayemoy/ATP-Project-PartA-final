package algorithms.search;
import algorithms.maze3D.IMaze3DGenerator;
import algorithms.maze3D.Maze3D;
import algorithms.maze3D.MyMaze3DGenerator;
import algorithms.maze3D.SearchableMaze3D;
import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestFirstSearchTest {

    BestFirstSearch bestfsAlgo;
    private BestFirstSearch best;
    //private BreadthFirstSearch bfs;
    private Maze maze;


    @Test
    void searchGoalstate() {
    }

    @Test
    void getName() {
    }

    @Test
    void getNumberOfNodesEvaluated() {
        bestfsAlgo =new BestFirstSearch();
        assertEquals(0, bestfsAlgo.getNumberOfNodesEvaluated());
    }
    @Test
    void solve3D() {
        bestfsAlgo =new BestFirstSearch();
        IMaze3DGenerator lolo = new MyMaze3DGenerator();
        Maze3D maze = lolo.generate(20, 50,40);
        SearchableMaze3D searchableMaze = new SearchableMaze3D(maze);
        assertNotNull(bestfsAlgo.solve(searchableMaze));

    }

    @Test
    void solveNull() {
        bestfsAlgo =new BestFirstSearch();
        assertThrows(NullPointerException.class,()-> bestfsAlgo.solve(null));
    }

    @Test
    void CheckPathLength(){
        IMazeGenerator lolo = new MyMazeGenerator();
        Maze maze = lolo.generate(1000, 1000);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        bestfsAlgo = new BestFirstSearch();
        BreadthFirstSearch breadth= new BreadthFirstSearch();
        Solution s1= bestfsAlgo.solve(searchableMaze);
        Solution s2=breadth.solve(searchableMaze);
        assertTrue(s2.getSolutionPath().size() <= s1.getSolutionPath().size());
    }


    @Test
    void checkTime(){
        IMazeGenerator lolo = new MyMazeGenerator();
        Maze maze = lolo.generate(1000, 1000);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        bestfsAlgo =new BestFirstSearch();
        //assertTimeout(Duration.ofMinutes(1),()->bfs.solve(searchableMaze));
    }
    @Test
    void checkCost(){
        IMazeGenerator lolo = new MyMazeGenerator();
        Maze maze = lolo.generate(1000, 1000);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        bestfsAlgo = new BestFirstSearch();
        BreadthFirstSearch breadth= new BreadthFirstSearch();
        bestfsAlgo.solve(searchableMaze);
        breadth.solve(searchableMaze);
        assertTrue(bestfsAlgo.searchGoalstate(searchableMaze).getCost() <= breadth.searchGoalstate(searchableMaze).getCost());
    }


}