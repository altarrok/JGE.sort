package sort;

public class Button {
    private String text;
    private int width;
    private int height;

    public Button(String txt, int w, int h) {
        this.text = txt;
        this.width = w;
        this.height = h;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
