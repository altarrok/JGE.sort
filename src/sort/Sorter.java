package sort;

import engine.audio.SoundClip;

public abstract class Sorter {
    protected String tag;
    protected IntObj[] arr;
    protected SoundClip sc;
    protected int size;

    abstract public void sort();

    // return true if done.
    abstract public boolean sortStep();

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public IntObj[] getArr() {
        return arr;
    }

    public void setArr(IntObj[] arr) {
        this.arr = arr;
    }
}
