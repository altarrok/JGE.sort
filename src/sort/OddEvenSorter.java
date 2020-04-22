package sort;

import engine.audio.SoundClip;

public class OddEvenSorter extends Sorter {
    private int step = 0;
    private int step2 = 1;
    private boolean sorted = false;

    public OddEvenSorter(IntObj[] arr, SoundClip sc) {
        this.arr = arr;
        this.tag = "Odd/Even Sort";
        this.sc = sc;
        this.size = arr.length;
    }

    @Override
    public void sort() {

    }

    @Override
    public boolean sortStep() {
        if (!sorted) {
            sorted = true;
            for (int i=1; i<=arr.length-2; i=i+2)
            {
                if (arr[i].getVal() > arr[i+1].getVal())
                {
                    arr[i].activate();
                    arr[i+1].activate();
                    int temp = arr[i].getVal();
                    arr[i].setVal(arr[i+1].getVal());
                    arr[i+1].setVal(temp);
                    sorted = false;
                }
            }
            for (int i=0; i<=arr.length-2; i=i+2)
            {
                if (arr[i].getVal() > arr[i+1].getVal())
                {
                    arr[i].activate();
                    arr[i+1].activate();
                    int temp = arr[i].getVal();
                    arr[i].setVal(arr[i+1].getVal());
                    arr[i+1].setVal(temp);
                    sorted = false;
                }
            }
            return false;
        } else {
            return true;
        }
    }

//    @Override
//    public boolean sortStep() {
//        if (step2 <= arr.length - 2) {
//            if (arr[step2].getVal() > arr[step2 + 1].getVal()) {
//                arr[step2].activate();
//                arr[step2 + 1].activate();
//                int temp = arr[step2].getVal();
//                arr[step2].setVal(arr[step2 + 1].getVal());
//                arr[step2 + 1].setVal(temp);
//                sorted = false;
//            }
//            step2 += 2;
//        } else {
//            if (step <= arr.length - 2) {
//                if (arr[step].getVal() >  arr[step+1].getVal()) {
//                    arr[step].activate();
//                    arr[step+1].activate();
//                    int temp = arr[step].getVal();
//                    arr[step].setVal(arr[step+1].getVal());
//                    arr[step+1].setVal(temp);
//                    sorted = false;
//                }
//                step += 2;
//            } else {
//                if (!sorted) {
//                    sorted = true;
//                    step = 0;
//                    step2 = 1;
//                } else {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
