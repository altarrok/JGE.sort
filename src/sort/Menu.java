package sort;

import engine.GameContainer;
import engine.Renderer;

public class Menu {
    public boolean isActive = true;
    private Button[] butts = {
            new Button(" Insertion Sort", 175, 50),
            new Button(" Selection Sort", 175, 50),
            new Button(" Bubble Sort", 150, 50),
            new Button(" Bogo Sort", 135,50),
            new Button(" Shell Sort", 140, 50),
            new Button(" Comb Sort", 135, 50),
            new Button(" Odd/Even Sort", 175, 50),
            new Button(" Gnome Sort", 145, 50),
    };

    private Class<? extends Sorter>[] sorters = (new Class[]{
            InsertionSorter.class,
            SelectionSorter.class,
            BubbleSorter.class,
            BogoSorter.class,
            ShellSorter.class,
            CombSorter.class,
            OddEvenSorter.class,
            GnomeSorter.class,
    });

    public void render(GameContainer gc, Renderer r) {
        r.setAmbientColor(0xFFFFFFFF);
        for (int i = 0; i < butts.length; i++) {
            r.drawText(butts[i].getText(), gc.getWidth() / 2 + (i % 2 == 0 ? 120 : -300), gc.getHeight() / 2 -300 + (i / 2) * 120, 0xFF000000);
            r.drawRect(gc.getWidth() / 2 + (i % 2 == 0 ? 120 : -300), gc.getHeight() / 2 -315 + (i / 2) * 120, butts[i].getWidth(), butts[i].getHeight(), 0xFF000000);
        }
    }

    public Class<? extends Sorter> update(GameContainer gc, float dt) {
        int mouseX = gc.getInput().getMouseX();
        int mouseY = gc.getInput().getMouseY();
        if (gc.getInput().isButton(1)) {
            for (int i = 0; i < butts.length; i++) {
                if (mouseX > gc.getWidth() / 2 + (i % 2 == 0 ? 120 : -300) && mouseX < gc.getWidth() / 2 + (i % 2 == 0 ? 120 : -300) + butts[i].getWidth()) {
                    if (mouseY > gc.getHeight() / 2 -315 + (i / 2) * 120 && mouseY < gc.getHeight() / 2 -315 + (i / 2) * 120 + butts[i].getHeight()) {
                        // CLICKED ON INSERTION SORT
                        isActive = false;
                        return sorters[i];
                    }
                }
            }
        }

        return null;
    }

    public void setActive() {
        this.isActive = true;
    }
}
