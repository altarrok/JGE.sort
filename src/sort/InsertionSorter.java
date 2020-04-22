package sort;

import engine.audio.SoundClip;

public class InsertionSorter extends Sorter {
    private int step = 0;

    public InsertionSorter(IntObj[] arr, SoundClip sc) {
        this.arr = arr;
        this.tag = "Insertion Sort";
        this.sc = sc;
        this.size = arr.length;
    }

    @Override
    public void sort() {
        for (int i = 1; i < arr.length; i++) {
            slide(arr, i);
        }
    }

    @Override
    public boolean sortStep() {
        if (step < arr.length) {
            slide(arr, step);
            step++;
            return false;
        } else {
            return true;
        }
    }

    private void slide(IntObj[] arr, int i) {
        arr[i].activate();
        int temp = arr[i].getVal();
        int j = i;
        while (j > 0 && arr[j-1].getVal() > temp) {
            arr[j].setVal(arr[j-1].getVal());
            j--;
        }
        arr[j].activate();
        arr[j].setVal(temp);
    }
}
