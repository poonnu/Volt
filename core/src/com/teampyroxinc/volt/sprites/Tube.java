package com.teampyroxinc.volt.sprites;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.teampyroxinc.volt.states.GameStateManager;

import java.util.Random;

public class Tube {
    private static final int FLUCTUATION = 100;
    private static final int MAX = 300;
    private static final int ALL = 300;
    private static final int LOWEST_OPENING = 130;
    private Texture topTube, bottomTube,hosTube;
    private Vector2 posTopTube,posBotTube,posHosTube;
    private Rectangle boundsTop,boundsBot,boundsHos;
    private Random rand;

    public GameStateManager gsm;


    public Tube(float x) {
        topTube = new Texture ("vertical.png");
        bottomTube = new Texture("vertical2.png");
        hosTube = new Texture("horizontal.png");
        rand = new Random();


        posTopTube = new Vector2(x + 100, rand.nextInt(FLUCTUATION)  + LOWEST_OPENING);
        posHosTube = new Vector2(x + 250, 0);
        posBotTube = new Vector2(x + 400 + 320, rand.nextInt(MAX));





        boundsTop = new Rectangle(posTopTube.x,posTopTube.y, topTube.getWidth(),topTube.getHeight());
        boundsBot = new Rectangle(posBotTube.x,posBotTube.y,bottomTube.getWidth(),bottomTube.getHeight());
        boundsHos = new Rectangle(posHosTube.x,posHosTube.y,hosTube.getWidth(),hosTube.getHeight());
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }


    public void reposition(float x){

        posTopTube.set(x , rand.nextInt(FLUCTUATION)  + LOWEST_OPENING);
        posHosTube.set(x+150,0);
        posBotTube.set(x + 300 + 320 ,rand.nextInt(MAX));



        boundsTop.setPosition(posTopTube.x,posTopTube.y);
        boundsBot.setPosition(posBotTube.x,posBotTube.y);
        boundsHos.setPosition(posHosTube.x,posHosTube.y);
    }


    public Vector2 getPosHosTube() {
        return posHosTube;
    }

    public Texture getHosTube() {
        return hosTube;
    }

    public boolean collides(Rectangle player){
        return player.overlaps(boundsTop) || player.overlaps(boundsBot) || player.overlaps(boundsHos);

    }


    public void dispose(){
        topTube.dispose();
        bottomTube.dispose();
        hosTube.dispose();
    }



}


