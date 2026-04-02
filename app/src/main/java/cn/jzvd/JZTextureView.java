package cn.jzvd;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class JZTextureView extends TextureView {
    protected static final String TAG = "JZResizeTextureView";
    public int currentVideoHeight;
    public int currentVideoWidth;

    public JZTextureView(Context context) {
        super(context);
        this.currentVideoWidth = 0;
        this.currentVideoHeight = 0;
        this.currentVideoWidth = 0;
        this.currentVideoHeight = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0130  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int size;
        int size2;
        int i6;
        int i7;
        String str = "onMeasure  [" + hashCode() + "] ";
        int rotation = (int) getRotation();
        int i8 = this.currentVideoWidth;
        int i9 = this.currentVideoHeight;
        int measuredHeight = ((View) getParent()).getMeasuredHeight();
        int measuredWidth = ((View) getParent()).getMeasuredWidth();
        if (measuredWidth != 0 && measuredHeight != 0 && i8 != 0 && i9 != 0 && Jzvd.VIDEO_IMAGE_DISPLAY_TYPE == 1) {
            if (rotation == 90 || rotation == 270) {
                measuredWidth = measuredHeight;
                measuredHeight = measuredWidth;
            }
            i9 = (i8 * measuredHeight) / measuredWidth;
        }
        if (rotation == 90 || rotation == 270) {
            i4 = i2;
            i5 = i3;
        } else {
            i5 = i2;
            i4 = i3;
        }
        int defaultSize = TextureView.getDefaultSize(i8, i5);
        int defaultSize2 = TextureView.getDefaultSize(i9, i4);
        if (i8 <= 0 || i9 <= 0) {
            size = defaultSize2;
            size2 = defaultSize;
        } else {
            int mode = View.MeasureSpec.getMode(i5);
            size2 = View.MeasureSpec.getSize(i5);
            int mode2 = View.MeasureSpec.getMode(i4);
            size = View.MeasureSpec.getSize(i4);
            String str2 = "widthMeasureSpec  [" + View.MeasureSpec.toString(i5) + "]";
            String str3 = "heightMeasureSpec [" + View.MeasureSpec.toString(i4) + "]";
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i10 = i8 * size;
                int i11 = size2 * i9;
                if (i10 < i11) {
                    i6 = i10 / i9;
                    size2 = i6;
                } else if (i10 > i11) {
                    size = i11 / i8;
                }
            } else if (mode == 1073741824) {
                i7 = (size2 * i9) / i8;
                if (mode2 == Integer.MIN_VALUE && i7 > size) {
                    i6 = (size * i8) / i9;
                    size2 = i6;
                }
                size = i7;
            } else if (mode2 == 1073741824) {
                i6 = (size * i8) / i9;
                if (mode == Integer.MIN_VALUE && i6 > size2) {
                    i7 = (size2 * i9) / i8;
                    size = i7;
                }
                size2 = i6;
            } else {
                if (mode2 != Integer.MIN_VALUE || i9 <= size) {
                    i6 = i8;
                    size = i9;
                } else {
                    i6 = (size * i8) / i9;
                }
                if (mode == Integer.MIN_VALUE && i6 > size2) {
                    i7 = (size2 * i9) / i8;
                    size = i7;
                }
                size2 = i6;
            }
        }
        if (measuredWidth == 0 || measuredHeight == 0 || i8 == 0 || i9 == 0) {
            i8 = size2;
            i9 = size;
        } else {
            int i12 = Jzvd.VIDEO_IMAGE_DISPLAY_TYPE;
            if (i12 != 3) {
                if (i12 == 2) {
                    if (rotation == 90 || rotation == 270) {
                        int i13 = measuredWidth;
                        measuredWidth = measuredHeight;
                        measuredHeight = i13;
                    }
                    double d2 = ((double) i9) / ((double) i8);
                    double d3 = measuredHeight;
                    double d4 = measuredWidth;
                    double d5 = d3 / d4;
                    if (d2 > d5) {
                        i9 = (int) ((d4 / ((double) size2)) * ((double) size));
                        i8 = measuredWidth;
                    } else if (d2 < d5) {
                        i8 = (int) ((d3 / ((double) size)) * ((double) size2));
                        i9 = measuredHeight;
                    }
                }
            }
        }
        setMeasuredDimension(i8, i9);
    }

    @Override // android.view.View
    public void setRotation(float f2) {
        if (f2 != getRotation()) {
            super.setRotation(f2);
            requestLayout();
        }
    }

    public void setVideoSize(int i2, int i3) {
        if (this.currentVideoWidth == i2 && this.currentVideoHeight == i3) {
            return;
        }
        this.currentVideoWidth = i2;
        this.currentVideoHeight = i3;
        requestLayout();
    }

    public JZTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.currentVideoWidth = 0;
        this.currentVideoHeight = 0;
        this.currentVideoWidth = 0;
        this.currentVideoHeight = 0;
    }
}
