package sort;

import engine.audio.SoundClip;

public class BogoSorter extends Sorter {
    private int step = 0;

    public BogoSorter(IntObj[] arr, SoundClip sc) {
        this.arr = arr;
        this.tag = "Bogo Sort";
        this.sc = sc;
        this.size = arr.length;
    }

    @Override
    public void sort() {
        while (isSorted() == false)
            shuffle();
    }

    private boolean isSorted() {
        for (int i=1; i<arr.length; i++)
            if (arr[i].getVal() < arr[i-1].getVal())
                return false;
        return true;
    }

    private void shuffle() {
        for (int i=0; i < arr.length; i++)
            swap(i, (int)(Math.random()*i));
    }

    private void swap(int a, int b) {
        arr[a].activate();
        arr[b].activate();
        int temp = arr[a].getVal();
        arr[a].setVal(arr[b].getVal());
        arr[b].setVal(temp);
    }

    @Override
    public boolean sortStep() {
        if (!isSorted() && step < arr.length) {
            swap(step, (int)(Math.random()*step));
            step++;
            return false;
        } else if (step >= arr.length) {
            step = 0;
            return false;
        }
        return true;
    }
}
