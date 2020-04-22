package sort;

import engine.audio.SoundClip;

public class BubbleSorter extends Sorter {
    private int step = 0;
    private int stepJ = 0;

    public BubbleSorter(IntObj[] arr, SoundClip sc) {
        this.arr = arr;
        this.tag = "Bubble Sort";
        this.sc = sc;
        this.size = arr.length;
    }

    @Override
    public void sort() {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j].getVal() > arr[j+1].getVal())
                {
                    // swap arr[j+1] and arr[i]
                    int temp = arr[j].getVal();
                    arr[j].setVal(arr[j+1].getVal());
                    arr[j+1].setVal(temp);
                }
    }

    @Override
    public boolean sortStep() {
//        if (stepJ < arr.length - step - 1) {
//            if (arr[stepJ].getVal() > arr[stepJ+1].getVal())
//            {
//                // swap arr[j+1] and arr[i]
//                int temp = arr[stepJ].getVal();
//                arr[stepJ].setVal(arr[stepJ+1].getVal());
//                arr[stepJ+1].setVal(temp);
//            }
//            stepJ++;
//        } else {
//            if (step < arr.length - 2) {
//                step++;
//                stepJ = 0;
//            }
//        }
        if (step < arr.length - 1) {
            for (int j = 0; j < arr.length - step - 1; j++) {
                if (arr[j].getVal() > arr[j + 1].getVal()) {
                    // swap arr[j+1] and arr[i]
                    arr[j].activate();
                    int temp = arr[j].getVal();
                    arr[j].setVal(arr[j + 1].getVal());
                    arr[j + 1].setVal(temp);
                }
            }
            step++;
            return false;
        } else {
            return true;
        }
    }
}
