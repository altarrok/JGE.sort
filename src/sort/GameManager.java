package sort;

import engine.AbstractGame;
import engine.GameContainer;
import engine.Renderer;
import engine.audio.SoundClip;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GameManager extends AbstractGame {
    /**
     * GAME CONSTANTS =========================
     */
    private static final int tileSize = 32;
    private static final int tiledWidth = 56;
    private static final int tiledHeight = 30;
    private static final int width = tileSize*tiledWidth;
    private static final int height = tileSize*tiledHeight + 35;
    private static final float scale = 1f;
    private static final double wantedFps = 240.0;


    private ArrayList<GameObject> objects = new ArrayList<>();
//    private SoundClip sc = new SoundClip("/audio/clc.wav"); // TODO figure out sound
    private SoundClip sc = null;
    private Sorter s;
    private Menu m;

    public GameManager() {
        m = new Menu();
    }

    @Override
    public void update(GameContainer gc, float dTime) {
        if (gc.getInput().isKeyDown(KeyEvent.VK_ESCAPE)) {
            objects.removeAll(objects);
            m.setActive();
        }
        if (m.isActive) {
            Class<? extends Sorter> k = m.update(gc, dTime);
            if (k != null) {
                IntObj[] a = IntObj.arrCtr(1650, gc);
                for (IntObj intObj : a) {
                    objects.add(intObj);
                }
                try {
                    s = k.getConstructor(IntObj[].class, SoundClip.class).newInstance(a, sc);
                } catch (Exception e) {
                    s = new SelectionSorter(a, sc);
                }
                objects.add(new SorterText(s));
            }
        }
        else {
            for (int i = 0; i < objects.size(); i++) {
                // Updating objects
                objects.get(i).update(gc, dTime);
                // Removing objects
                if (objects.get(i).isDead()) {
                    objects.remove(i);
                    i--;
                }

            }
            if (s.sortStep()) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                objects.removeAll(objects);
                m.setActive();
            }
        }
    }

    @Override
    public void render(GameContainer gc, Renderer renderer) {
        if (m.isActive) m.render(gc, renderer);
        else {
            renderer.setAmbientColor(0xFF000000);
            for (GameObject object : objects) {
                object.render(gc, renderer);
            }
        }
    }

    public static void main(String[] args) {
        GameContainer gc = new GameContainer(new GameManager());
        gc.setWidth(width);
        gc.setHeight(height);
        gc.setScale(scale);
        gc.setFPS(wantedFps);
        gc.setDrawFPS(true);
        gc.setTileSize(tileSize);
        gc.start();
    }

    public GameObject getObject(String tag) {
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getTag().equals(tag)) {
                return objects.get(i);
            }
        }
        return null;
    }

}
