package mazebot.maze;
import java.util.ArrayList;
import java.util.Random;

import javax.vecmath.Vector3d;

import mazebot.core.MazeEnvironment;
import mazebot.core.MazeGenerator;
import simbad.sim.Wall;

public class DepthFirstGenerator implements MazeGenerator {
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
		Vector3d t1 = new Vector3d();
		Vector3d t2 = new Vector3d();
		
		Wall w5 = new Wall(new Vector3d(-10, 0, 6), 1, 1, env);
		
		env.add(w5);
		Wall w6 = new Wall(new Vector3d(-10, 0, 6), 1, 1, env);
		env.add(w6);
		w5.translateTo(t1);
		w6.translateTo(t2);
		
		if(t1.getX() == t2.getX() && t1.getY() == t2.getY()) {
			System.out.println("y");
		}
		
		int x = 0;
		int y = 0;
		Random rn = new Random();
		int range = 4 - 1 + 1;
		int randomNum =  rn.nextInt(range) + 1;
		int randomRotate = rn.nextInt(range) + 1;
		
		
		while(j<210) {
			randomNum =  rn.nextInt(range) + 1;
			randomRotate = rn.nextInt(range/2) + 1;
			
			if(randomNum == 1 && x<9) {
				x+=2;
			}

			if(randomNum == 2 && y<9) {
				y+=2;
			}

			if(randomNum == 3 && x>-9) {
				x-=2;
			}

			if(randomNum == 4 && y>-9) {
				y-=2;
			}
			
			w[j] = new Wall(new Vector3d(x, 0, y), 2, 1, env);
			v[j] = new Vector3d(x, y, 0);
			boolean duplicate = true;
			
			if(randomRotate == 1) {
				w[j].rotate90(1);
			}
			
			for(i = 0; i<j-1;i++) {
				if(v[j].getX() == v[i].getX() && v[j].getY() == v[i].getY()) {
					duplicate = false;
					break;
				}
			}
			
			if(duplicate == true) {
				env.add(w[j]);
				j++;
		}
	} 
	}

}
