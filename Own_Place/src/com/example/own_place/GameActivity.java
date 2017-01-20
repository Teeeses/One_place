package com.example.own_place;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;

public class GameActivity extends Activity implements OnTouchListener 
{
	
	private SurfaceGame surf;
	public LogicGame game;
	private int start_x, finish_x, start_y, finish_y;
	private boolean redTemp;
	private boolean blueTemp;
	
	private double angle;
	
	@SuppressLint("ClickableViewAccessibility") 
	public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        game = new LogicGame();
        surf = new SurfaceGame(this, game);
        this.setContentView(surf);
        
        surf.setOnTouchListener(this);
    }
	
	@SuppressLint("ClickableViewAccessibility") @Override
	public boolean onTouch(View v, MotionEvent event) 
	{
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			start_x = (int)event.getX();
			start_y = (int)event.getY();
			checkClickedBox();
			break;
		case MotionEvent.ACTION_UP:
			finish_x = (int)event.getX();
			finish_y = (int)event.getY();
			int side1 = findSide1();
			int side2 = findSide2();
			int hypotenuse = setHypotenuse(side1, side2);
			findAngle(side2, hypotenuse);
			checkHeightHypotenuse(hypotenuse, side1, side2);
			break;
		default:
			break;
		}
		return true;
	}
	
	private int setHypotenuse(int side1, int side2) 
	{
		int hypotenuse = (int) (Math.sqrt(Math.abs(side1*side1) + Math.abs(side2*side2)));
		return hypotenuse;
	}
	
	private int findSide1()
	{
		return (start_x - finish_x);
	}
	
	private int findSide2()
	{
		return (start_y - finish_y);
	}
	
	private void findAngle(int side, int hypotenuse)
	{
		angle = (Math.asin((double)side/hypotenuse))*57.295;
	}
	
	private void checkHeightHypotenuse(int hypotenuse, int side1, int side2)
	{
		if (hypotenuse > 30 && ((angle < 30 && angle > -30) || (angle > 60) || (angle < -60))) {	
			game.setDirectionAndMoveCubs(side1, side2, angle, redTemp, blueTemp);
		}
	}
	
	private void checkClickedBox() 
	{
		surf.invalidate();
		redTemp = false;
		blueTemp = false;
		int x = (start_x - game.marginLeft)/game.cellWH;
		int y = (start_y - game.marginTop)/game.cellWH;
		if (x >= 0 && x < game.mFieldY && y >= 0 && y < game.mFieldX && (start_x - game.marginLeft) > 0 && (start_y - surf.game.marginTop) > 0)
		{
			if (x == game.y2 && y == game.x2)
				blueTemp = true;
			if (x == game.y1 && y == game.x1)
				redTemp = true;
		}
	}
	
	@Override
    protected void onResume() 
	{
      super.onResume();
    }	
}
