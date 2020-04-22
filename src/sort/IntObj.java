package sort;

import engine.GameContainer;
import engine.Renderer;

import java.util.Random;

public class IntObj extends GameObject {
    private int val;
    private int arrSize;
    private static Random rand = new Random();
    private boolean isActive = false;
    private boolean done = false;

    public IntObj(int n, int pos, int arrSize) {
        val = n;
        this.posX = pos;
        this.arrSize = arrSize;
    }

    public static IntObj[] arrCtr(int size, GameContainer gc) {
        IntObj[] arr = new IntObj[size];
        for (int i = 0; i < size; i++) {
            arr[i] = new IntObj( rand.nextInt(gc.getHeight() - 50), i, size);
        }
        return arr;
    }

    public void print() {
        System.out.println(this.val);
    }

//    float n =0;
    @Override
    public void update(GameContainer gc, float dt) {
//        n += dt;
//        if (n >= 0) {
//            n = 0;
//            deactivate();
//        }
        deactivate();
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        r.fillRect((int) (this.posX * (gc.getWidth() / (double) arrSize)), gc.getHeight() - 50 - val, gc.getWidth() / arrSize, val, (done ? 0xFF00FFFF : (isActive ? 0xFFFF0000 : 0xFF00FF00)));
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void activate() {
        isActive = true;
    }

    public void deactivate() {
        isActive = false;
    }

    public void done() {
        done = true;
    }
}
