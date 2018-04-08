package mazebot.maze;

import java.util.ArrayList;

import javax.vecmath.Vector3d;

import mazebot.core.MazeEnvironment;
import mazebot.core.MazeGenerator;
import simbad.sim.Wall;

public class Empty implements MazeGenerator {
	static ArrayList<Integer> wallX = new ArrayList<Integer>();
	static ArrayList<Integer> wallY = new ArrayList<Integer>();
	
	@Override
	public void generate(MazeEnvironment env) {
		// TODO Auto-generated method stub
		Wall[] w = new Wall[400];
		Vector3d[] v = new Vector3d[400];
		int i = 0, j = 0;
		
		for(i = -10;i<10;i++) {
			w[j] = new Wall(new Vector3d(i, 0, -10), 1, 1, env);
			v[j] = new Vector3d(i, 0, -10);
			wallX.add(10);
			wallY.add(i);
			//w[j].rotate90(1);
			env.add(w[j]);
			j++;
		}

		for(i = -10;i<10;i++) {
			w[j] = new Wall(new Vector3d(10, 0, i), 1, 1, env);
			v[j] = new Vector3d(10, 0, i);
			w[j].rotate90(1);
			env.add(w[j]);
			j++;
		}

		for(i = -10;i<10;i++) {
			w[j] = new Wall(new Vector3d(i, 0, 10), 1, 1, env);
			v[j] = new Vector3d(i, 0, 10);
			//w[j].rotate90(1);
			env.add(w[j]);
			j++;
		}

		for(i = -10;i<10;i++) {
			w[j] = new Wall(new Vector3d(-10, 0, i), 1, 1, env);
			v[j] = new Vector3d(-10, 0, i);
			w[j].rotate90(1);
			env.add(w[j]);
			j++;
		}
	}
}