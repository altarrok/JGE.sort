package sort;

import engine.GameContainer;
import engine.Renderer;

public class SorterText extends GameObject {
    Sorter sorter;

    public SorterText(Sorter sorter) {
        this.sorter = sorter;
    }

    @Override
    public void update(GameContainer gc, float dt) {
    }

    @Override
    public void render(GameContainer gc, Renderer r) {
        String s = sorter.tag + "    Array Size:" + sorter.size;
        String credit = "Altay Batuhan";
        r.drawText(s, 10, gc.getHeight() - 35, 0xFFFFFFFF);
        r.drawText(credit, gc.getWidth() - 180, gc.getHeight() - 35, 0xFFFFFFFF);
    }
}
