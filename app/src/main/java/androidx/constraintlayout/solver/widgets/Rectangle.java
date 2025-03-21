package androidx.constraintlayout.solver.widgets;

/* loaded from: classes.dex */
public class Rectangle {
    public int height;
    public int width;

    /* renamed from: x */
    public int f603x;

    /* renamed from: y */
    public int f604y;

    public boolean contains(int i2, int i3) {
        int i4;
        int i5 = this.f603x;
        return i2 >= i5 && i2 < i5 + this.width && i3 >= (i4 = this.f604y) && i3 < i4 + this.height;
    }

    public int getCenterX() {
        return (this.f603x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.f604y + this.height) / 2;
    }

    void grow(int i2, int i3) {
        this.f603x -= i2;
        this.f604y -= i3;
        this.width += i2 * 2;
        this.height += i3 * 2;
    }

    boolean intersects(Rectangle rectangle) {
        int i2;
        int i3;
        int i4 = this.f603x;
        int i5 = rectangle.f603x;
        return i4 >= i5 && i4 < i5 + rectangle.width && (i2 = this.f604y) >= (i3 = rectangle.f604y) && i2 < i3 + rectangle.height;
    }

    public void setBounds(int i2, int i3, int i4, int i5) {
        this.f603x = i2;
        this.f604y = i3;
        this.width = i4;
        this.height = i5;
    }
}
