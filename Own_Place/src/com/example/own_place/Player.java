package com.example.own_place;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;

public class Player
{
	private static final String TAG = "mylog";
	private LogicGame game;
	public SurfaceGame gameView;
	
	public Bitmap redBitmap;
	public Bitmap blueBitmap;
	
	public Player(SurfaceGame gameView, LogicGame game)
	{
		this.gameView = gameView;
		this.game = game;
	}
	
	protected void onDraw(Canvas canvas) 
	{
		for(int i = 0; i < game.mFieldX; i++)
    	{
			for(int j = 0; j < game.mFieldY; j++)
			{
				if (game.locationBoxs[i][j] == 2) {
					canvas.drawBitmap(redBitmap, game.marginLeft + game.cellWH*j, game.marginTop + game.cellWH*i, null);
				}
				if (game.locationBoxs[i][j] == 3) {
					canvas.drawBitmap(blueBitmap, game.marginLeft + game.cellWH*j, game.marginTop + game.cellWH*i, null);
				}
			}
    	}
	}
    
    public void createBitmap(Bitmap red, Bitmap blue)
    {
    	redBitmap = red;
    	blueBitmap = blue;
    }   
}
