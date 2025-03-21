package cn.jzvd;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;

/* loaded from: classes.dex */
public class JZTextureView extends TextureView {

    /* renamed from: c, reason: collision with root package name */
    protected static final String f3185c = "JZResizeTextureView";

    /* renamed from: a, reason: collision with root package name */
    public int f3186a;

    /* renamed from: b, reason: collision with root package name */
    public int f3187b;

    public JZTextureView(Context context) {
        super(context);
        this.f3186a = 0;
        this.f3187b = 0;
        this.f3186a = 0;
        this.f3187b = 0;
    }

    public void a(int i2, int i3) {
        if (this.f3186a == i2 && this.f3187b == i3) {
            return;
        }
        this.f3186a = i2;
        this.f3187b = i3;
        requestLayout();
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        String str = "onMeasure  [" + hashCode() + "] ";
        int rotation = (int) getRotation();
        int i10 = this.f3186a;
        int i11 = this.f3187b;
        int measuredHeight = ((View) getParent()).getMeasuredHeight();
        int measuredWidth = ((View) getParent()).getMeasuredWidth();
        if (measuredWidth != 0 && measuredHeight != 0 && i10 != 0 && i11 != 0 && Jzvd.v0 == 1) {
            if (rotation == 90 || rotation == 270) {
                measuredWidth = measuredHeight;
                measuredHeight = measuredWidth;
            }
            i11 = (i10 * measuredHeight) / measuredWidth;
        }
        if (rotation == 90 || rotation == 270) {
            i4 = i2;
            i5 = i3;
        } else {
            i5 = i2;
            i4 = i3;
        }
        int defaultSize = TextureView.getDefaultSize(i10, i5);
        int defaultSize2 = TextureView.getDefaultSize(i11, i4);
        if (i10 <= 0 || i11 <= 0) {
            i6 = defaultSize2;
            i7 = defaultSize;
        } else {
            int mode = View.MeasureSpec.getMode(i5);
            i7 = View.MeasureSpec.getSize(i5);
            int mode2 = View.MeasureSpec.getMode(i4);
            i6 = View.MeasureSpec.getSize(i4);
            String str2 = "widthMeasureSpec  [" + View.MeasureSpec.toString(i5) + "]";
            String str3 = "heightMeasureSpec [" + View.MeasureSpec.toString(i4) + "]";
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i12 = i10 * i6;
                int i13 = i7 * i11;
                if (i12 < i13) {
                    i8 = i12 / i11;
                    i7 = i8;
                } else if (i12 > i13) {
                    i6 = i13 / i10;
                }
            } else if (mode == 1073741824) {
                i9 = (i7 * i11) / i10;
                if (mode2 == Integer.MIN_VALUE && i9 > i6) {
                    i8 = (i6 * i10) / i11;
                    i7 = i8;
                }
                i6 = i9;
            } else if (mode2 == 1073741824) {
                i8 = (i6 * i10) / i11;
                if (mode == Integer.MIN_VALUE && i8 > i7) {
                    i9 = (i7 * i11) / i10;
                    i6 = i9;
                }
                i7 = i8;
            } else {
                if (mode2 != Integer.MIN_VALUE || i11 <= i6) {
                    i8 = i10;
                    i6 = i11;
                } else {
                    i8 = (i6 * i10) / i11;
                }
                if (mode == Integer.MIN_VALUE && i8 > i7) {
                    i9 = (i7 * i11) / i10;
                    i6 = i9;
                }
                i7 = i8;
            }
        }
        if (measuredWidth != 0 && measuredHeight != 0 && i10 != 0 && i11 != 0) {
            int i14 = Jzvd.v0;
            if (i14 != 3) {
                if (i14 == 2) {
                    if (rotation == 90 || rotation == 270) {
                        int i15 = measuredWidth;
                        measuredWidth = measuredHeight;
                        measuredHeight = i15;
                    }
                    double d2 = i11 / i10;
                    double d3 = measuredHeight;
                    double d4 = measuredWidth;
                    double d5 = d3 / d4;
                    if (d2 > d5) {
                        i11 = (int) ((d4 / i7) * i6);
                        i10 = measuredWidth;
                    } else if (d2 < d5) {
                        i10 = (int) ((d3 / i6) * i7);
                        i11 = measuredHeight;
                    }
                }
            }
            setMeasuredDimension(i10, i11);
        }
        i10 = i7;
        i11 = i6;
        setMeasuredDimension(i10, i11);
    }

    @Override // android.view.View
    public void setRotation(float f2) {
        if (f2 != getRotation()) {
            super.setRotation(f2);
            requestLayout();
        }
    }

    public JZTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3186a = 0;
        this.f3187b = 0;
        this.f3186a = 0;
        this.f3187b = 0;
    }
}
