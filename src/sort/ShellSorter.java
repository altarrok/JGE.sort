package sort;

import engine.audio.SoundClip;

public class ShellSorter extends Sorter {
    private int step = 0;
    private int step2 = 0;

    public ShellSorter(IntObj[] arr, SoundClip sc) {
        this.arr = arr;
        this.tag = "Shell Sort";
        this.sc = sc;
        this.size = arr.length;
        step = arr.length/2;
        step2 = step;
    }

    @Override
    public void sort() {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2)
        {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1)
            {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = arr[i].getVal();

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap].getVal() > temp; j -= gap)
                    arr[j].setVal(arr[j - gap].getVal());

                // put temp (the original a[i]) in its correct
                // location
                arr[j].setVal(temp);
            }
        }
    }

    @Override
    public boolean sortStep() {
        if (step > 0) {
            if (step2 < arr.length) {
                arr[step2].activate();
                int temp = arr[step2].getVal();

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = step2; j >= step && arr[j - step].getVal() > temp; j -= step) {
                    arr[j].activate();
                    arr[j - step].activate();
                    arr[j].setVal(arr[j - step].getVal());
                }

                // put temp (the original a[i]) in its correct
                // location
                arr[j].activate();
                arr[j].setVal(temp);
                step2++;
                return false;
            }
            step /= 2;
            step2 = step;
            return false;
        }
        return true;
    }
}
