package com.example.own_place;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class LevelActivity extends Activity implements OnClickListener 
{

	private int numberButtons = 15;
	private Button[] arrayButtons;
	
	private LinearLayout layout;
	public static int levelClick;
	private boolean howManyClick;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{		
		super.onCreate(savedInstanceState);
		
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);   
		setContentView(R.layout.level);
		
		layout = (LinearLayout) findViewById(R.id.layout);
		arrayButtons = new Button[numberButtons];
		
		createButtons();
	}
	
	@Override
	public void onClick(View v) 
	{
		if (howManyClick == false) {
			howManyClick = true;
			switch (v.getId()) {
			case R.id.button1:
				levelClick = 1;
				break;
			case R.id.button2:
				levelClick = 2;
				break;
			case R.id.button3:
				levelClick = 3;
				break;
			case R.id.button4:
				levelClick = 4;
				break;
			case R.id.button5:
				levelClick = 5;
				break;
			case R.id.button6:
				levelClick = 6;
				break;
			case R.id.button7:
				levelClick = 7;
				break;
			case R.id.button8:
				levelClick = 8;
				break;
			case R.id.button9:
				levelClick = 9;
				break;
			case R.id.button10:
				levelClick = 10;
				break;
			case R.id.button11:
				levelClick = 11;
				break;
			case R.id.button12:
				levelClick = 12;
				break;
			case R.id.button13:
				levelClick = 13;
				break;
			case R.id.button14:
				levelClick = 14;
				break;
			case R.id.button15:
				levelClick = 15;
				break;
			default:
				break;
			}
			Intent i = new Intent(this, GameActivity.class);
			this.startActivity(i);
		}
	}
	
	private void createButtons()
	{	
		Button button1 = (Button) findViewById(R.id.button1);
		arrayButtons[0] = button1;
		Button button2 = (Button) findViewById(R.id.button2);
		arrayButtons[1] = button2;
		Button button3 = (Button) findViewById(R.id.button3);
		arrayButtons[2] = button3;
		Button button4 = (Button) findViewById(R.id.button4);
		arrayButtons[3] = button4;
		Button button5 = (Button) findViewById(R.id.button5);
		arrayButtons[4] = button5;
		Button button6 = (Button) findViewById(R.id.button6);
		arrayButtons[5] = button6;
		Button button7 = (Button) findViewById(R.id.button7);
		arrayButtons[6] = button7;
		Button button8 = (Button) findViewById(R.id.button8);
		arrayButtons[7] = button8;
		Button button9 = (Button) findViewById(R.id.button9);
		arrayButtons[8] = button9;
		Button button10 = (Button) findViewById(R.id.button10);
		arrayButtons[9] = button10;
		Button button11 = (Button) findViewById(R.id.button11);
		arrayButtons[10] = button11;
		Button button12 = (Button) findViewById(R.id.button12);
		arrayButtons[11] = button12;
		Button button13 = (Button) findViewById(R.id.button13);
		arrayButtons[12] = button13;
		Button button14 = (Button) findViewById(R.id.button14);
		arrayButtons[13] = button14;
		Button button15 = (Button) findViewById(R.id.button15);
		arrayButtons[14] = button15;
		
		for(int i = 0; i < numberButtons; i++)
		{
			if(MainActivity.availableLevel >= i + 1)
			{
				arrayButtons[i].setBackgroundResource(R.drawable.box_button);
				arrayButtons[i].setText(Integer.toString(i + 1));
			}
			else
			{
				arrayButtons[i].setBackgroundResource(R.drawable.close_button);
				arrayButtons[i].setEnabled(false);
			}
			arrayButtons[i].setOnClickListener(this);
		}
	}
	
	@Override
    protected void onResume() 
	{
      super.onResume();
      howManyClick = false;
	  Animation anim = null;
      anim = AnimationUtils.loadAnimation(this, R.anim.scale);
      layout.startAnimation(anim);
    }
}
