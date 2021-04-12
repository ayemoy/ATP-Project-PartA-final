package test;
import algorithms.maze3D.IMaze3DGenerator;
import algorithms.maze3D.Maze3D;
import algorithms.maze3D.MyMaze3DGenerator;
import algorithms.maze3D.SearchableMaze3D;
import algorithms.mazeGenerators.*;
import algorithms.search.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RunMaze3DGenerator {
    public static void main(String[] args) {
        IMaze3DGenerator lolo = new MyMaze3DGenerator();
        Maze3D maze = lolo.generate(20, 50,40);
        //SearchableMaze3D searchableMaze = new SearchableMaze3D(maze);

        //long time = lolo.measureAlgorithmTimeMillis(9, 19, 19);
       // System.out.println(time/1000);
        maze.print();

        //searchableMaze.getAllSuccessors();

  }

}
