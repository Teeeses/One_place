package com.example.own_place;

import android.util.Log;

public class LogicGame 
{
	// Wall - 1.
	// Empty cell - 0.
	// Red cub - 2.
	// Blue cub - 3.
	// Star - 4.
	// Stenka sprava - 5.
	// Stenka sleva - 6
	// Star blue = 11.
	// Star red = 10.
	// Star yello = 12. 
	
	public int mFieldX;
	public int mFieldY;
	public int width;
	public int height;
	public int cellWH;
	public int marginLeft;
	public int marginTop;											
	
	public int redFinishX;
	public int redFinishY;
	public int redStartX;
	public int redStartY;
	public int blueFinishX;
	public int blueFinishY;
	public int blueStartX;
	public int blueStartY;
	
	public int direction;
	public boolean temp = true;
	// 0 - up, 1 - down, 2 - left, 3 - right.
	
	public int x1, x2, y1, y2;
	public int mField[][];
	public int locationBoxs[][];
	
	private static final String TAG = "mylog";
	
	public LogicGame()
	{		
		Log.d("TAG", "AAA");
		if(MainActivity.buttonClick == 1)
		{
			if(LevelActivity.levelClick == 1)
			{
				mFieldX = 8;
				mFieldY = 8;
				mField = new int[mFieldX][mFieldY];
				mField = new int[][]
				{				
						{1,5,1,5,1,5,5,1},
						{1,0,0,0,0,2,0,5},
						{1,0,1,1,0,1,0,1},
						{1,0,0,0,0,1,0,5},
						{1,0,1,0,1,0,0,5},
						{5,0,1,0,0,0,0,1},
						{1,0,0,3,1,0,0,1},
						{5,5,1,5,6,5,5,5},
				};
				locationBoxs = new int[mFieldX][mFieldY];
				locationBoxs = new int[][]
				{				
						{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,2,0,0},
						{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0},
						{0,0,0,0,0,0,0,0},
						{0,0,0,3,0,0,0,0},
						{0,0,0,0,0,0,0,0},
				};
			}
			if(LevelActivity.levelClick == 2)
			{
				mFieldX = 8;
				mFieldY = 8;
				mField = new int[mFieldX][mFieldY];
				mField = new int[][]
				{				
						{1, 5, 1, 5, 1, 5, 5, 1},
						{1, 0, 0, 3, 0, 0, 0, 5},
						{1, 0, 0, 0, 0, 1, 0, 1},
						{1, 0, 0, 0, 0, 1, 0, 5},
						{1, 0, 0, 1, 0, 2, 0, 5},
						{5, 0, 1, 1, 0, 0, 1, 1},
						{1, 0, 0, 0, 0, 0, 0, 1},
						{5, 5, 1, 5, 6, 5, 5, 5},
				};
			}
			if(LevelActivity.levelClick == 3)
			{
				mFieldX = 8;
				mFieldY = 8;
				mField = new int[mFieldX][mFieldY];
				mField = new int[][]
				{				
						{1, 5, 1, 5, 1, 5, 5, 1},
						{1, 0, 0, 0, 0, 0, 0, 5},
						{1, 0, 0, 0, 1, 0, 0, 1},
						{1, 0, 1, 0, 0, 0, 0, 5},
						{1, 2, 3, 0, 1, 0, 0, 5},
						{5, 0, 0, 0, 0, 0, 1, 1},
						{1, 1, 0, 0, 0, 0, 0, 1},
						{5, 5, 1, 5, 6, 5, 5, 5},
				};
			}
			if(LevelActivity.levelClick == 4)
			{
				mFieldX = 8;
				mFieldY = 8;
				mField = new int[mFieldX][mFieldY];
				mField = new int[][]
				{						
						{1, 5, 1, 5, 1, 5, 5, 1},
						{6, 0, 0, 0, 0, 0, 0, 5},
						{1, 0, 3, 0, 0, 0, 0, 1},
						{1, 0, 0, 1, 0, 0, 0, 5},
						{1, 1, 0, 0, 0, 0, 1, 5},
						{5, 0, 2, 1, 0, 0, 0, 1},
						{1, 0, 0, 0, 0, 0, 1, 1},
						{5, 5, 1, 5, 6, 5, 5, 5},
				};
			}
			if(LevelActivity.levelClick == 5)
			{
				mFieldX = 10;
				mFieldY = 10;
				mField = new int[mFieldX][mFieldY];
				mField = new int[][]
				{				
						{1,5,1,5,1,5,5,1,1,1},
						{1,0,0,0,0,0,0,0,1,5},
						{1,0,1,1,1,0,1,0,0,1},
						{1,0,1,0,0,0,0,1,0,5},
						{1,0,1,0,1,1,1,0,0,5},
						{1,0,1,0,1,0,1,0,1,5},
						{1,0,1,0,0,0,0,0,1,5},
						{5,0,1,1,1,0,1,1,1,1},
						{1,0,0,0,0,0,0,2,3,1},
						{5,5,1,5,6,5,5,1,1,5},
				};
			}
			if(LevelActivity.levelClick == 6)
			{
				mFieldX = 10;
				mFieldY = 10;
				mField = new int[mFieldX][mFieldY];
				mField = new int[][]
				{				
						{1,1,1,1,1,1,1,1},					
						{1,0,1,0,0,0,1,1},
						{1,0,0,0,1,0,0,1},
						{1,0,1,0,1,1,0,1},
						{1,0,1,0,3,0,0,1},
						{1,0,2,0,1,0,0,1},
						{1,0,1,0,1,0,0,1},
						{1,1,1,1,1,1,1,1},
				};
			}
			if(LevelActivity.levelClick == 7)
			{
				mFieldX = 10;
				mFieldY = 10;
				mField = new int[mFieldX][mFieldY];
				mField = new int[][]
				{				
						{1,1,1,1,1,1,1,1,1,1},
						{1,1,4,1,0,1,0,0,3,1},
						{1,1,0,0,0,0,0,1,1,1},
						{1,0,0,0,1,1,0,0,0,1},
						{1,1,0,1,1,0,0,0,1,1},
						{1,0,0,0,0,0,0,0,0,1},
						{1,1,1,0,1,0,0,1,0,1},
						{1,1,4,0,0,0,0,0,0,1},
						{1,1,1,0,0,0,1,1,2,1},
						{1,1,1,1,1,1,1,1,1,1},
				};
			}
			if(LevelActivity.levelClick == 8)
			{
				
				mFieldX = 10;
				mFieldY = 10;
				mField = new int[mFieldX][mFieldY];
				mField = new int[][]
				{				
						{1,1,1,1,1,1,1,1,1,1},
						{1,1,1,0,1,1,0,0,1,1},
						{1,1,3,0,0,0,0,0,0,1},
						{1,1,1,0,1,1,0,1,0,1},
						{1,1,1,0,1,1,0,1,0,1},
						{1,0,0,0,0,0,0,0,0,1},
						{1,0,1,0,0,0,0,1,0,1},
						{1,0,1,1,0,1,0,1,0,1},
						{1,2,0,0,0,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1},
				};
			}
			if(LevelActivity.levelClick == 9)
			{
				mFieldX = 10;
				mFieldY = 10;
				mField = new int[mFieldX][mFieldY];
				mField = new int[][]
				{				
						{1,5,1,5,1,5,5,1,1,1},
						{1,0,0,0,0,0,0,0,0,5},
						{1,0,0,1,0,0,0,1,0,1},
						{1,0,1,2,5,0,0,0,4,5},
						{1,0,0,0,0,0,0,0,0,5},
						{1,0,0,0,0,0,0,0,0,5},
						{1,1,0,0,0,0,0,0,0,1},
						{1,0,0,0,0,0,1,0,0,1},
						{1,3,1,0,0,4,0,0,0,1},
						{5,5,1,5,6,5,5,1,1,5},
				};
			}
		}
	}
	
	
	 public int[][] getmField() 
	 {
		 return mField;
	 }
	 
	 public int[][] getLocationBoxs() 
	 {
		 return locationBoxs;
	 }
	 
	 public void foundX1X2Y1Y2() 
	 {
		 for (int i = 0; i < mFieldX; i++) 
		 {
			 for (int j = 0; j < mFieldY; j++) 
			 {
				 if(mField[i][j] == 2)
				 {
					 x1 = i;
					 y1 = j;
					 redStartX = marginLeft + cellWH*j;
					 redStartY = marginTop + cellWH*i;
					 redFinishX = redStartX;
					 redFinishY = redStartY;
				 } 
				 else if(mField[i][j] == 3)
				 {
					 x2 = i;
					 y2 = j;
					 blueStartX = marginLeft + cellWH*j;
					 blueStartY = marginTop + cellWH*i;
					 blueFinishX = blueStartX;
					 blueFinishY = blueStartY;
				 }
				 
			 }
		 }
	 }

	 public void setDirectionAndMoveCubs(int side1, int side2, double angle, boolean redTemp, boolean blueTemp) 
	 {
		 redStartX = redFinishX;
		 redStartY = redFinishY;
		 blueStartX = blueFinishX;
		 blueStartY = blueFinishY;
		 Log.d(TAG, side1 + " " + side2 + " " + angle);
	 	 if ((side1 <= 0 && side2 >= 0 && angle < 30) || (side1 <= 0 && side2 <= 0 && angle > -30)) {
			 if (redTemp) {
				 while(mField[x1][y1 + 1] != 1 && mField[x1][y1 + 1] != 5 && mField[x1][y1 + 1] != 6 && locationBoxs[x1][y1 + 1] != 3) {
				  	 locationBoxs[x1][y1] = 0;
				  	 locationBoxs[x1][y1 + 1] = 2;
					 y1++;
					 redFinishX = redFinishX + cellWH;
				 }
			 }
			 if (blueTemp) {
				 while(mField[x2][y2 + 1] != 1 && mField[x2][y2 + 1] != 5 && mField[x2][y2 + 1] != 6 && locationBoxs[x2][y2 + 1] != 2) {
					 locationBoxs[x2][y2] = 0;
					 locationBoxs[x2][y2 + 1] = 3;
					 y2++;
					 blueFinishX = blueFinishX + cellWH;
				 }
			 }
		 }
		 if ((side1 <= 0 && side2 >= 0 && angle > 60) || (side1 >= 0 && side2 >= 0 && angle > 60 )) {
			 if (redTemp) {
				 while(mField[x1 - 1][y1] != 1 && mField[x1 - 1][y1] != 5 && mField[x1 - 1][y1] != 6 && locationBoxs[x1 - 1][y1] != 3) {
					 locationBoxs[x1][y1] = 0;
					 locationBoxs[x1 - 1][y1] = 2;
					 x1--;
					 redFinishY = redFinishY - cellWH;
				 }
			 }
			 if (blueTemp) {
				 while(mField[x2 - 1][y2] != 1 && mField[x2 - 1][y2] != 5 && mField[x2 - 1][y2] != 6 && locationBoxs[x2 - 1][y2] != 2) {
					 locationBoxs[x2][y2] = 0;
					 locationBoxs[x2 - 1][y2] = 3;
					 x2--;
					 blueFinishY = blueFinishY - cellWH;
				 }
			 }
		 }
		 if ((side1 >= 0 && side2 >= 0 && angle < 30) || (side1 >= 0 && side2 <= 0 && angle > -30)) {
			 if (redTemp) {
				 while(mField[x1][y1 - 1] != 1 && mField[x1][y1 - 1] != 5 && mField[x1][y1 - 1] != 6 && locationBoxs[x1][y1 - 1] != 3) {
					 locationBoxs[x1][y1] = 0;
					 locationBoxs[x1][y1 - 1] = 2;
					 y1--;
					 redFinishX = redFinishX - cellWH;
				 }
			 }
			 if (blueTemp) {
				 while(mField[x2][y2 - 1] != 1 && mField[x2][y2 - 1] != 5 && mField[x2][y2 - 1] != 6 && locationBoxs[x2][y2 - 1] != 2) {
					 locationBoxs[x2][y2] = 0;
					 locationBoxs[x2][y2 - 1] = 3;
					 y2--;
					 blueFinishX = blueFinishX - cellWH;
				 }
			 }
		 }
		 if ((side1 >= 0 && side2 <= 0 && angle < -60) || (side1 <= 0 && side2 <= 0 && angle < -60)) {
			 if (redTemp) {
				 while(mField[x1 + 1][y1] != 1 && mField[x1 + 1][y1] != 5 && mField[x1 + 1][y1] != 6 && locationBoxs[x1 + 1][y1] != 3) {
					 locationBoxs[x1][y1] = 0;
					 locationBoxs[x1 + 1][y1] = 2;
					 x1++;
					 redFinishY = redFinishY + cellWH;
				 }
			 }
			 if (blueTemp) {
				 while(mField[x2 + 1][y2] != 1 && mField[x2 + 1][y2] != 5 && mField[x2 + 1][y2] != 6 && locationBoxs[x2 + 1][y2] != 2) {
					 locationBoxs[x2][y2] = 0;
					 locationBoxs[x2 + 1][y2] = 3;
					 x2++;
					 blueFinishY = blueFinishY + cellWH;
				 }
			 }
		 }
	 }
	 
	
	 
}
