package sort;

import engine.audio.SoundClip;

public class SelectionSorter extends Sorter{
    private int step = 0;

    public SelectionSorter(IntObj[] arr, SoundClip sc) {
        this.arr = arr;
        this.tag = "Selection Sort";
        this.sc = sc;
        this.size = arr.length;
    }

    @Override
    public void sort() {
        for (int i = 0; i < arr.length; i++) {
            int min = findMin(arr, i);
            int temp = arr[i].getVal();
            arr[i].setVal(arr[min].getVal());;
            arr[min].setVal(temp);
        }
    }

    public boolean sortStep() {
        int min = findMin(arr, step);
        arr[step].activate();
        arr[min].activate();
        int temp = arr[step].getVal();
        arr[step].setVal(arr[min].getVal());
        arr[min].setVal(temp);
        if (step < arr.length - 1) step++;
        else {
            return true;
        }
        return false;
    }

    /**
     * @param a starting position
     * @return position of minimum integer from arr[a] to end of the array.
     */
    private int findMin(IntObj[] arr, int a) {
        int mpos = a;
        int mval = arr[a].getVal();
        for (int i = a; i < arr.length; i++) {
            if (arr[i].getVal() < mval) {
                mpos = i;
                mval = arr[i].getVal();
            }
        }
        return mpos;
    }
}
