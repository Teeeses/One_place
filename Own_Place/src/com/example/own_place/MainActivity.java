package com.example.own_place;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class MainActivity extends Activity implements OnLoadCompleteListener, OnClickListener{
	
	private Button btneasy;
	private Button btnmedium;
	private Button btnhard;
	
	private boolean howManyClick;
	public static int buttonClick;
	public int easyMediumHardLevel;																
	public static int availableLevel;
	private SharedPreferences mSettings;
	// How many in the counter.
	private static final String APP_PREFERENCES_COUNTER = "counter";
	// Name file settings.
	public static final String APP_PREFERENCES = "mysettings";
	
	private SoundPool sound;
    private int soundKnopka;
    private Animation anim1;
		
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        createButton();
        //sound = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        //sound.setOnLoadCompleteListener(this);
        //soundKnopka = sound.load(this, R.raw.knopka, 1);
        //SoundFon = sound.load(this, R.raw.f, 1);
        
        anim1 = null;
		anim1 = AnimationUtils.loadAnimation(this, R.anim.scale);
		
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);        
        availableLevel = 8;
        easyMediumHardLevel = 1;
        
        load();
    }
    
    public void createButton()
    {
    	btneasy = (Button)findViewById(R.id.btneasy);
        btnmedium = (Button)findViewById(R.id.btnmedium);
        btnhard = (Button)findViewById(R.id.btnhard);     
        btneasy.setOnClickListener(this);
        btnmedium.setOnClickListener(this);
        btnhard.setOnClickListener(this);
    }
    
	@Override
	public void onClick(View v) {
		if (howManyClick == false) {
			howManyClick = true;
			switch (v.getId()) {
			case R.id.btneasy:
				buttonClick = 1;
				break;
			case R.id.btnmedium:
				sound.play(soundKnopka, 1, 1, 0, 0, 1);
				buttonClick = 2;
				break;
			case R.id.btnhard:
				sound.play(soundKnopka, 1, 1, 0, 0, 1);
				buttonClick = 3;
				break;
			default:
				break;
			}
			Intent i = new Intent(this, LevelActivity.class);
			this.startActivity(i);
		}
	}
	
	public void load() {
    	if (mSettings.contains(APP_PREFERENCES_COUNTER)) {
    		// Get the number of settings.
    		availableLevel = mSettings.getInt(APP_PREFERENCES_COUNTER, 0);
    	}
    }
    
    public void save() {
    	Editor editor = mSettings.edit();
    	editor.putInt(APP_PREFERENCES_COUNTER, availableLevel);
    	editor.commit();
    }
    
    @Override
    protected void onResume() {
      super.onResume();
      btneasy.startAnimation(anim1);
      btnmedium.startAnimation(anim1);
      btnhard.startAnimation(anim1);
      howManyClick = false;
    }
    
    @Override
    protected void onDestroy() {
    	save();
    	super.onDestroy();
    }

	@Override
	public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
		// TODO Auto-generated method stub		
	}
}