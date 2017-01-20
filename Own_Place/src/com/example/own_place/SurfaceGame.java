package com.example.own_place;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

@SuppressLint("WrongCall") public class SurfaceGame extends SurfaceView
{	      
	private static final String TAG = "mylog";
	
	private GameThread mThread;
    private boolean running = false; 
	public LogicGame game;
	public Player player;
	
	public Bitmap redBitmap;
	public Bitmap blueBitmap;
	private Bitmap wall_1;
	private Bitmap wall_2;
	private Bitmap stenaFlower;
	private Paint paint;
	public BitmapFactory.Options options;
	
	public SurfaceGame(Context context, LogicGame g) 
    {
        super(context);
        mThread = new GameThread(this);
        game = g;
        findTheDemensions();
		createBitmap();
		game.foundX1X2Y1Y2();
        player = new Player(this, game);
		player.createBitmap(redBitmap, blueBitmap);
		createPaint();
		threading();
    }
    
    protected void onDraw(Canvas canvas) 
    {  
    	Log.d("TAG", "KKK");
    	canvas.drawRect(game.marginLeft, game.marginTop, game.marginLeft + game.mFieldY*game.cellWH, game.marginTop + game.mFieldX*game.cellWH, paint);
    	for(int i = 0; i < game.mFieldX; i++)
    	{
			for(int j = 0; j < game.mFieldY; j++)
			{
				if (game.mField[i][j] == 1) {
					canvas.drawBitmap(wall_1, game.marginLeft + game.cellWH*j, game.marginTop + game.cellWH*i, null);
				}
				if (game.mField[i][j] == 5) {
					canvas.drawBitmap(wall_2, game.marginLeft + game.cellWH*j, game.marginTop + game.cellWH*i, null);
				}
				if (game.mField[i][j] == 6) {
					canvas.drawBitmap(stenaFlower, game.marginLeft + game.cellWH*j, game.marginTop + game.cellWH*i, null);
				}
			}
    	}
    	player.onDraw(canvas);
    }
	
	private void findTheDemensions() 
	{
        DisplayMetrics displaymetrics = getResources().getDisplayMetrics();
        game.width = displaymetrics.widthPixels;
        game.height = displaymetrics.heightPixels;
		game.cellWH = game.width/(game.mFieldY + 1);
		game.marginLeft = (game.width - game.cellWH*(game.mFieldY))/2;
		game.marginTop = (game.height - game.cellWH*(game.mFieldX))/2;
	}
	
	private void createPaint()
	{
		paint = new Paint();
		paint.setColor(Color.WHITE);
	}
	
	@SuppressWarnings("deprecation")
	private void createBitmap() 
	{	
		options = new BitmapFactory.Options();
    	options.inPurgeable = true;
    	
    	redBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.red_box, options);
    	blueBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.blue_box, options);
    	wall_1 = BitmapFactory.decodeResource(getResources(), R.drawable.wall_1, options);
    	wall_2 = BitmapFactory.decodeResource(getResources(), R.drawable.wall_2, options);
    	stenaFlower = BitmapFactory.decodeResource(getResources(), R.drawable.wall_flower, options);
    	
    	blueBitmap = Bitmap.createScaledBitmap(blueBitmap, game.cellWH, game.cellWH, true);
        redBitmap = Bitmap.createScaledBitmap(redBitmap, game.cellWH, game.cellWH, true);
        wall_1 = Bitmap.createScaledBitmap(wall_1, game.cellWH, game.cellWH, true);
        wall_2 = Bitmap.createScaledBitmap(wall_2, game.cellWH, game.cellWH, true);
        stenaFlower = Bitmap.createScaledBitmap(stenaFlower, game.cellWH, game.cellWH, true);
	}
	
	public void threading()
	{
		getHolder().addCallback(new SurfaceHolder.Callback() 
        {
               public void surfaceDestroyed(SurfaceHolder holder) 
               {
            	   boolean retry = true;
            	    mThread.setRunning(false);
            	    while (retry)
            	    {
            	        try
            	        {
            	            mThread.join();
            	            retry = false;
            	        }
            	        catch (InterruptedException e) { }
            	    }
               }

               public void surfaceCreated(SurfaceHolder holder) 
               {
            	   mThread.setRunning(true);
            	   mThread.start();
               }

               public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) 
               {
            	   //mThread.setRunning(false);
               }
        });
	}
	
	public class GameThread extends Thread
    {
        private SurfaceGame view;	 
        
        public GameThread(SurfaceGame view) 
        {
              this.view = view;
        }

        public void setRunning(boolean run) 
        {
              running = run;
        }

        public void run()
        {
            while (running)
            {
                Canvas canvas = null;
                try
                {
                    canvas = view.getHolder().lockCanvas();
                    synchronized (view.getHolder())
                    {
                        onDraw(canvas);
                    }
                }
                catch (Exception e) { }
                finally
                {
                    if (canvas != null)
                    {
                    	view.getHolder().unlockCanvasAndPost(canvas);
                    }
                }
            }
        }
    }
}
