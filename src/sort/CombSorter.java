package sort;

import engine.audio.SoundClip;

public class CombSorter extends Sorter {
    private int step = 0;
    private int gap = 0;
    private boolean swapped = true;

    public CombSorter(IntObj[] arr, SoundClip sc) {
        this.arr = arr;
        this.tag = "Comb Sort";
        this.sc = sc;
        this.size = arr.length;
        this.gap = arr.length;
    }

    @Override
    public void sort() {
        int n = arr.length;

        // initialize gap
        int gap = n;

        // Initialize swapped as true to make sure that
        // loop runs
        boolean swapped = true;

        // Keep running while gap is more than 1 and last
        // iteration caused a swap
        while (gap != 1 || swapped == true)
        {
            // Find next gap
            gap = getNextGap(gap);

            // Initialize swapped as false so that we can
            // check if swap happened or not
            swapped = false;

            // Compare all elements with current gap
            for (int i=0; i<n-gap; i++)
            {
                if (arr[i].getVal() > arr[i+gap].getVal())
                {
                    // Swap arr[i] and arr[i+gap]
                    int temp = arr[i].getVal();
                    arr[i].setVal(arr[i+gap].getVal());
                    arr[i+gap].setVal(temp);

                    // Set swapped
                    swapped = true;
                }
            }
        }
    }

    private int getNextGap(int gap)
    {
        // Shrink gap by Shrink factor
        gap = (gap*10)/13;
        if (gap < 1)
            return 1;
        return gap;
    }


    @Override
    public boolean sortStep() {
            if (step < arr.length - gap) {
                arr[step].activate();
                arr[step+gap].activate();
                if (arr[step].getVal() > arr[step+gap].getVal())
                {
                    // Swap arr[i] and arr[i+gap]
                    int temp = arr[step].getVal();
                    arr[step].setVal(arr[step+gap].getVal());
                    arr[step+gap].setVal(temp);

                    // Set swapped
                    swapped = true;
                }
                step++;
            } else {
                if (gap != 1 || swapped == true) {
                    // Find next gap
                    gap = getNextGap(gap);

                    // Initialize swapped as false so that we can
                    // check if swap happened or not
                    swapped = false;
                    step = 0;
                    sortStep();
                } else {
                    return true;
                }
            }
            return false;
    }
}
