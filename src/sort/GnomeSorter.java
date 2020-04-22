package sort;

import engine.audio.SoundClip;

public class GnomeSorter extends Sorter {
    private int step = 0;

    public GnomeSorter(IntObj[] arr, SoundClip sc) {
        this.arr = arr;
        this.tag = "Gnome Sort";
        this.sc = sc;
        this.size = arr.length;
    }

    @Override
    public void sort() {

    }

    @Override
    public boolean sortStep() {
        if (step < arr.length) {
            if (step == 0)
                step++;
            arr[step].activate();
            if (arr[step].getVal() >= arr[step - 1].getVal())
                step++;
            else {
                arr[step - 1].activate();
                int temp = 0;
                temp = arr[step].getVal();
                arr[step].setVal(arr[step - 1].getVal());
                arr[step - 1].setVal(temp);
                step--;
            }
            return false;
        }
        return true;
    }
}
