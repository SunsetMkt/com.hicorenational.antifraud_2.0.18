package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes.dex */
public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mDisplayedWidgets;
    private int mHorizontalStyle = -1;
    private int mVerticalStyle = -1;
    private int mFirstHorizontalStyle = -1;
    private int mFirstVerticalStyle = -1;
    private int mLastHorizontalStyle = -1;
    private int mLastVerticalStyle = -1;
    private float mHorizontalBias = 0.5f;
    private float mVerticalBias = 0.5f;
    private float mFirstHorizontalBias = 0.5f;
    private float mFirstVerticalBias = 0.5f;
    private float mLastHorizontalBias = 0.5f;
    private float mLastVerticalBias = 0.5f;
    private int mHorizontalGap = 0;
    private int mVerticalGap = 0;
    private int mHorizontalAlign = 2;
    private int mVerticalAlign = 2;
    private int mWrapMode = 0;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    private ArrayList<WidgetsList> mChainList = new ArrayList<>();
    private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private int[] mAlignedDimensions = null;
    private int mDisplayedWidgetsCount = 0;

    private class WidgetsList {
        private ConstraintAnchor mBottom;
        private ConstraintAnchor mLeft;
        private int mMax;
        private int mOrientation;
        private int mPaddingBottom;
        private int mPaddingLeft;
        private int mPaddingRight;
        private int mPaddingTop;
        private ConstraintAnchor mRight;
        private ConstraintAnchor mTop;
        private ConstraintWidget biggest = null;
        int biggestDimension = 0;
        private int mWidth = 0;
        private int mHeight = 0;
        private int mStartIndex = 0;
        private int mCount = 0;
        private int mNbMatchConstraintsWidgets = 0;

        public WidgetsList(int i2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i3) {
            this.mOrientation = 0;
            this.mPaddingLeft = 0;
            this.mPaddingTop = 0;
            this.mPaddingRight = 0;
            this.mPaddingBottom = 0;
            this.mMax = 0;
            this.mOrientation = i2;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = Flow.this.getPaddingLeft();
            this.mPaddingTop = Flow.this.getPaddingTop();
            this.mPaddingRight = Flow.this.getPaddingRight();
            this.mPaddingBottom = Flow.this.getPaddingBottom();
            this.mMax = i3;
        }

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.biggest = null;
            this.biggestDimension = 0;
            int i2 = this.mCount;
            for (int i3 = 0; i3 < i2 && this.mStartIndex + i3 < Flow.this.mDisplayedWidgetsCount; i3++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i3];
                if (this.mOrientation == 0) {
                    int width = constraintWidget.getWidth();
                    int i4 = Flow.this.mHorizontalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i4 = 0;
                    }
                    this.mWidth += width + i4;
                    int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    if (this.biggest == null || this.biggestDimension < widgetHeight) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetHeight;
                        this.mHeight = widgetHeight;
                    }
                } else {
                    int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                    int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    int i5 = Flow.this.mVerticalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i5 = 0;
                    }
                    this.mHeight += widgetHeight2 + i5;
                    if (this.biggest == null || this.biggestDimension < widgetWidth) {
                        this.biggest = constraintWidget;
                        this.biggestDimension = widgetWidth;
                        this.mWidth = widgetWidth;
                    }
                }
            }
        }

        public void add(ConstraintWidget constraintWidget) {
            if (this.mOrientation == 0) {
                int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetWidth = 0;
                }
                this.mWidth += widgetWidth + (constraintWidget.getVisibility() != 8 ? Flow.this.mHorizontalGap : 0);
                int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (this.biggest == null || this.biggestDimension < widgetHeight) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetHeight;
                    this.mHeight = widgetHeight;
                }
            } else {
                int widgetWidth2 = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetHeight2 = 0;
                }
                this.mHeight += widgetHeight2 + (constraintWidget.getVisibility() != 8 ? Flow.this.mVerticalGap : 0);
                if (this.biggest == null || this.biggestDimension < widgetWidth2) {
                    this.biggest = constraintWidget;
                    this.biggestDimension = widgetWidth2;
                    this.mWidth = widgetWidth2;
                }
            }
            this.mCount++;
        }

        public void clear() {
            this.biggestDimension = 0;
            this.biggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        public void createConstraints(boolean z, int i2, boolean z2) {
            ConstraintWidget constraintWidget;
            int i3 = this.mCount;
            for (int i4 = 0; i4 < i3 && this.mStartIndex + i4 < Flow.this.mDisplayedWidgetsCount; i4++) {
                ConstraintWidget constraintWidget2 = Flow.this.mDisplayedWidgets[this.mStartIndex + i4];
                if (constraintWidget2 != null) {
                    constraintWidget2.resetAnchors();
                }
            }
            if (i3 == 0 || this.biggest == null) {
                return;
            }
            boolean z3 = z2 && i2 == 0;
            int i5 = -1;
            int i6 = -1;
            for (int i7 = 0; i7 < i3; i7++) {
                int i8 = z ? (i3 - 1) - i7 : i7;
                if (this.mStartIndex + i8 >= Flow.this.mDisplayedWidgetsCount) {
                    break;
                }
                if (Flow.this.mDisplayedWidgets[this.mStartIndex + i8].getVisibility() == 0) {
                    if (i5 == -1) {
                        i5 = i7;
                    }
                    i6 = i7;
                }
            }
            if (this.mOrientation != 0) {
                ConstraintWidget constraintWidget3 = this.biggest;
                constraintWidget3.setHorizontalChainStyle(Flow.this.mHorizontalStyle);
                int i9 = this.mPaddingLeft;
                if (i2 > 0) {
                    i9 += Flow.this.mHorizontalGap;
                }
                if (z) {
                    constraintWidget3.mRight.connect(this.mRight, i9);
                    if (z2) {
                        constraintWidget3.mLeft.connect(this.mLeft, this.mPaddingRight);
                    }
                    if (i2 > 0) {
                        this.mRight.mOwner.mLeft.connect(constraintWidget3.mRight, 0);
                    }
                } else {
                    constraintWidget3.mLeft.connect(this.mLeft, i9);
                    if (z2) {
                        constraintWidget3.mRight.connect(this.mRight, this.mPaddingRight);
                    }
                    if (i2 > 0) {
                        this.mLeft.mOwner.mRight.connect(constraintWidget3.mLeft, 0);
                    }
                }
                ConstraintWidget constraintWidget4 = null;
                int i10 = 0;
                while (i10 < i3 && this.mStartIndex + i10 < Flow.this.mDisplayedWidgetsCount) {
                    ConstraintWidget constraintWidget5 = Flow.this.mDisplayedWidgets[this.mStartIndex + i10];
                    if (i10 == 0) {
                        constraintWidget5.connect(constraintWidget5.mTop, this.mTop, this.mPaddingTop);
                        int i11 = Flow.this.mVerticalStyle;
                        float f2 = Flow.this.mVerticalBias;
                        if (this.mStartIndex == 0 && Flow.this.mFirstVerticalStyle != -1) {
                            i11 = Flow.this.mFirstVerticalStyle;
                            f2 = Flow.this.mFirstVerticalBias;
                        } else if (z2 && Flow.this.mLastVerticalStyle != -1) {
                            i11 = Flow.this.mLastVerticalStyle;
                            f2 = Flow.this.mLastVerticalBias;
                        }
                        constraintWidget5.setVerticalChainStyle(i11);
                        constraintWidget5.setVerticalBiasPercent(f2);
                    }
                    if (i10 == i3 - 1) {
                        constraintWidget5.connect(constraintWidget5.mBottom, this.mBottom, this.mPaddingBottom);
                    }
                    if (constraintWidget4 != null) {
                        constraintWidget5.mTop.connect(constraintWidget4.mBottom, Flow.this.mVerticalGap);
                        if (i10 == i5) {
                            constraintWidget5.mTop.setGoneMargin(this.mPaddingTop);
                        }
                        constraintWidget4.mBottom.connect(constraintWidget5.mTop, 0);
                        if (i10 == i6 + 1) {
                            constraintWidget4.mBottom.setGoneMargin(this.mPaddingBottom);
                        }
                    }
                    if (constraintWidget5 != constraintWidget3) {
                        if (z) {
                            int i12 = Flow.this.mHorizontalAlign;
                            if (i12 == 0) {
                                constraintWidget5.mRight.connect(constraintWidget3.mRight, 0);
                            } else if (i12 == 1) {
                                constraintWidget5.mLeft.connect(constraintWidget3.mLeft, 0);
                            } else if (i12 == 2) {
                                constraintWidget5.mLeft.connect(constraintWidget3.mLeft, 0);
                                constraintWidget5.mRight.connect(constraintWidget3.mRight, 0);
                            }
                        } else {
                            int i13 = Flow.this.mHorizontalAlign;
                            if (i13 == 0) {
                                constraintWidget5.mLeft.connect(constraintWidget3.mLeft, 0);
                            } else if (i13 == 1) {
                                constraintWidget5.mRight.connect(constraintWidget3.mRight, 0);
                            } else if (i13 == 2) {
                                if (z3) {
                                    constraintWidget5.mLeft.connect(this.mLeft, this.mPaddingLeft);
                                    constraintWidget5.mRight.connect(this.mRight, this.mPaddingRight);
                                } else {
                                    constraintWidget5.mLeft.connect(constraintWidget3.mLeft, 0);
                                    constraintWidget5.mRight.connect(constraintWidget3.mRight, 0);
                                }
                            }
                            i10++;
                            constraintWidget4 = constraintWidget5;
                        }
                    }
                    i10++;
                    constraintWidget4 = constraintWidget5;
                }
                return;
            }
            ConstraintWidget constraintWidget6 = this.biggest;
            constraintWidget6.setVerticalChainStyle(Flow.this.mVerticalStyle);
            int i14 = this.mPaddingTop;
            if (i2 > 0) {
                i14 += Flow.this.mVerticalGap;
            }
            constraintWidget6.mTop.connect(this.mTop, i14);
            if (z2) {
                constraintWidget6.mBottom.connect(this.mBottom, this.mPaddingBottom);
            }
            if (i2 > 0) {
                this.mTop.mOwner.mBottom.connect(constraintWidget6.mTop, 0);
            }
            if (Flow.this.mVerticalAlign == 3 && !constraintWidget6.hasBaseline()) {
                for (int i15 = 0; i15 < i3; i15++) {
                    int i16 = z ? (i3 - 1) - i15 : i15;
                    if (this.mStartIndex + i16 >= Flow.this.mDisplayedWidgetsCount) {
                        break;
                    }
                    constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i16];
                    if (constraintWidget.hasBaseline()) {
                        break;
                    }
                }
            }
            constraintWidget = constraintWidget6;
            ConstraintWidget constraintWidget7 = null;
            int i17 = 0;
            while (i17 < i3) {
                int i18 = z ? (i3 - 1) - i17 : i17;
                if (this.mStartIndex + i18 >= Flow.this.mDisplayedWidgetsCount) {
                    return;
                }
                ConstraintWidget constraintWidget8 = Flow.this.mDisplayedWidgets[this.mStartIndex + i18];
                if (i17 == 0) {
                    constraintWidget8.connect(constraintWidget8.mLeft, this.mLeft, this.mPaddingLeft);
                }
                if (i18 == 0) {
                    int i19 = Flow.this.mHorizontalStyle;
                    float f3 = Flow.this.mHorizontalBias;
                    if (this.mStartIndex == 0 && Flow.this.mFirstHorizontalStyle != -1) {
                        i19 = Flow.this.mFirstHorizontalStyle;
                        f3 = Flow.this.mFirstHorizontalBias;
                    } else if (z2 && Flow.this.mLastHorizontalStyle != -1) {
                        i19 = Flow.this.mLastHorizontalStyle;
                        f3 = Flow.this.mLastHorizontalBias;
                    }
                    constraintWidget8.setHorizontalChainStyle(i19);
                    constraintWidget8.setHorizontalBiasPercent(f3);
                }
                if (i17 == i3 - 1) {
                    constraintWidget8.connect(constraintWidget8.mRight, this.mRight, this.mPaddingRight);
                }
                if (constraintWidget7 != null) {
                    constraintWidget8.mLeft.connect(constraintWidget7.mRight, Flow.this.mHorizontalGap);
                    if (i17 == i5) {
                        constraintWidget8.mLeft.setGoneMargin(this.mPaddingLeft);
                    }
                    constraintWidget7.mRight.connect(constraintWidget8.mLeft, 0);
                    if (i17 == i6 + 1) {
                        constraintWidget7.mRight.setGoneMargin(this.mPaddingRight);
                    }
                }
                if (constraintWidget8 != constraintWidget6) {
                    if (Flow.this.mVerticalAlign == 3 && constraintWidget.hasBaseline() && constraintWidget8 != constraintWidget && constraintWidget8.hasBaseline()) {
                        constraintWidget8.mBaseline.connect(constraintWidget.mBaseline, 0);
                    } else {
                        int i20 = Flow.this.mVerticalAlign;
                        if (i20 == 0) {
                            constraintWidget8.mTop.connect(constraintWidget6.mTop, 0);
                        } else if (i20 == 1) {
                            constraintWidget8.mBottom.connect(constraintWidget6.mBottom, 0);
                        } else if (z3) {
                            constraintWidget8.mTop.connect(this.mTop, this.mPaddingTop);
                            constraintWidget8.mBottom.connect(this.mBottom, this.mPaddingBottom);
                        } else {
                            constraintWidget8.mTop.connect(constraintWidget6.mTop, 0);
                            constraintWidget8.mBottom.connect(constraintWidget6.mBottom, 0);
                        }
                    }
                }
                i17++;
                constraintWidget7 = constraintWidget8;
            }
        }

        public int getHeight() {
            return this.mOrientation == 1 ? this.mHeight - Flow.this.mVerticalGap : this.mHeight;
        }

        public int getWidth() {
            return this.mOrientation == 0 ? this.mWidth - Flow.this.mHorizontalGap : this.mWidth;
        }

        public void measureMatchConstraints(int i2) {
            int i3 = this.mNbMatchConstraintsWidgets;
            if (i3 == 0) {
                return;
            }
            int i4 = this.mCount;
            int i5 = i2 / i3;
            for (int i6 = 0; i6 < i4 && this.mStartIndex + i6 < Flow.this.mDisplayedWidgetsCount; i6++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i6];
                if (this.mOrientation == 0) {
                    if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                        Flow.this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i5, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                    }
                } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    Flow.this.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i5);
                }
            }
            recomputeDimensions();
        }

        public void setStartIndex(int i2) {
            this.mStartIndex = i2;
        }

        public void setup(int i2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i3, int i4, int i5, int i6, int i7) {
            this.mOrientation = i2;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = i3;
            this.mPaddingTop = i4;
            this.mPaddingRight = i5;
            this.mPaddingBottom = i6;
            this.mMax = i7;
        }
    }

    private void createAlignedConstraints(boolean z) {
        ConstraintWidget constraintWidget;
        if (this.mAlignedDimensions == null || this.mAlignedBiggestElementsInCols == null || this.mAlignedBiggestElementsInRows == null) {
            return;
        }
        for (int i2 = 0; i2 < this.mDisplayedWidgetsCount; i2++) {
            this.mDisplayedWidgets[i2].resetAnchors();
        }
        int[] iArr = this.mAlignedDimensions;
        int i3 = iArr[0];
        int i4 = iArr[1];
        ConstraintWidget constraintWidget2 = null;
        for (int i5 = 0; i5 < i3; i5++) {
            ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[z ? (i3 - i5) - 1 : i5];
            if (constraintWidget3 != null && constraintWidget3.getVisibility() != 8) {
                if (i5 == 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                    constraintWidget3.setHorizontalChainStyle(this.mHorizontalStyle);
                    constraintWidget3.setHorizontalBiasPercent(this.mHorizontalBias);
                }
                if (i5 == i3 - 1) {
                    constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                }
                if (i5 > 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                    constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                }
                constraintWidget2 = constraintWidget3;
            }
        }
        for (int i6 = 0; i6 < i4; i6++) {
            ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i6];
            if (constraintWidget4 != null && constraintWidget4.getVisibility() != 8) {
                if (i6 == 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                    constraintWidget4.setVerticalChainStyle(this.mVerticalStyle);
                    constraintWidget4.setVerticalBiasPercent(this.mVerticalBias);
                }
                if (i6 == i4 - 1) {
                    constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                }
                if (i6 > 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                    constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                }
                constraintWidget2 = constraintWidget4;
            }
        }
        for (int i7 = 0; i7 < i3; i7++) {
            for (int i8 = 0; i8 < i4; i8++) {
                int i9 = (i8 * i3) + i7;
                if (this.mOrientation == 1) {
                    i9 = (i7 * i4) + i8;
                }
                ConstraintWidget[] constraintWidgetArr = this.mDisplayedWidgets;
                if (i9 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i9]) != null && constraintWidget.getVisibility() != 8) {
                    ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInCols[i7];
                    ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInRows[i8];
                    if (constraintWidget != constraintWidget5) {
                        constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                        constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                    }
                    if (constraintWidget != constraintWidget6) {
                        constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                        constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWidgetHeight(ConstraintWidget constraintWidget, int i2) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i3 = constraintWidget.mMatchConstraintDefaultHeight;
            if (i3 == 0) {
                return 0;
            }
            if (i3 == 2) {
                int i4 = (int) (constraintWidget.mMatchConstraintPercentHeight * i2);
                if (i4 != constraintWidget.getHeight()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i4);
                }
                return i4;
            }
            if (i3 == 1) {
                return constraintWidget.getHeight();
            }
            if (i3 == 3) {
                return (int) ((constraintWidget.getWidth() * constraintWidget.mDimensionRatio) + 0.5f);
            }
        }
        return constraintWidget.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWidgetWidth(ConstraintWidget constraintWidget, int i2) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i3 = constraintWidget.mMatchConstraintDefaultWidth;
            if (i3 == 0) {
                return 0;
            }
            if (i3 == 2) {
                int i4 = (int) (constraintWidget.mMatchConstraintPercentWidth * i2);
                if (i4 != constraintWidget.getWidth()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i4, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i4;
            }
            if (i3 == 1) {
                return constraintWidget.getWidth();
            }
            if (i3 == 3) {
                return (int) ((constraintWidget.getHeight() * constraintWidget.mDimensionRatio) + 0.5f);
            }
        }
        return constraintWidget.getWidth();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x011e -> B:23:0x0065). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x0120 -> B:23:0x0065). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0126 -> B:23:0x0065). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x0128 -> B:23:0x0065). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void measureAligned(androidx.constraintlayout.solver.widgets.ConstraintWidget[] r17, int r18, int r19, int r20, int[] r21) {
        /*
            Method dump skipped, instructions count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Flow.measureAligned(androidx.constraintlayout.solver.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    private void measureChainWrap(ConstraintWidget[] constraintWidgetArr, int i2, int i3, int i4, int[] iArr) {
        int i5;
        int i6;
        int i7;
        if (i2 == 0) {
            return;
        }
        this.mChainList.clear();
        WidgetsList widgetsList = new WidgetsList(i3, this.mLeft, this.mTop, this.mRight, this.mBottom, i4);
        this.mChainList.add(widgetsList);
        if (i3 == 0) {
            WidgetsList widgetsList2 = widgetsList;
            i5 = 0;
            int i8 = 0;
            int i9 = 0;
            while (i9 < i2) {
                ConstraintWidget constraintWidget = constraintWidgetArr[i9];
                int widgetWidth = getWidgetWidth(constraintWidget, i4);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i5++;
                }
                int i10 = i5;
                boolean z = (i8 == i4 || (this.mHorizontalGap + i8) + widgetWidth > i4) && widgetsList2.biggest != null;
                if (!z && i9 > 0 && (i7 = this.mMaxElementsWrap) > 0 && i9 % i7 == 0) {
                    z = true;
                }
                if (z) {
                    WidgetsList widgetsList3 = new WidgetsList(i3, this.mLeft, this.mTop, this.mRight, this.mBottom, i4);
                    widgetsList3.setStartIndex(i9);
                    this.mChainList.add(widgetsList3);
                    i8 = widgetWidth;
                    widgetsList2 = widgetsList3;
                } else {
                    i8 = i9 > 0 ? i8 + this.mHorizontalGap + widgetWidth : widgetWidth;
                }
                widgetsList2.add(constraintWidget);
                i9++;
                i5 = i10;
            }
        } else {
            WidgetsList widgetsList4 = widgetsList;
            i5 = 0;
            int i11 = 0;
            int i12 = 0;
            while (i12 < i2) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i12];
                int widgetHeight = getWidgetHeight(constraintWidget2, i4);
                if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i5++;
                }
                int i13 = i5;
                boolean z2 = (i11 == i4 || (this.mVerticalGap + i11) + widgetHeight > i4) && widgetsList4.biggest != null;
                if (!z2 && i12 > 0 && (i6 = this.mMaxElementsWrap) > 0 && i12 % i6 == 0) {
                    z2 = true;
                }
                if (z2) {
                    WidgetsList widgetsList5 = new WidgetsList(i3, this.mLeft, this.mTop, this.mRight, this.mBottom, i4);
                    widgetsList5.setStartIndex(i12);
                    this.mChainList.add(widgetsList5);
                    i11 = widgetHeight;
                    widgetsList4 = widgetsList5;
                } else {
                    i11 = i12 > 0 ? i11 + this.mVerticalGap + widgetHeight : widgetHeight;
                }
                widgetsList4.add(constraintWidget2);
                i12++;
                i5 = i13;
            }
        }
        int size = this.mChainList.size();
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = this.mTop;
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = this.mBottom;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        boolean z3 = getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i5 > 0 && z3) {
            for (int i14 = 0; i14 < size; i14++) {
                WidgetsList widgetsList6 = this.mChainList.get(i14);
                if (i3 == 0) {
                    widgetsList6.measureMatchConstraints(i4 - widgetsList6.getWidth());
                } else {
                    widgetsList6.measureMatchConstraints(i4 - widgetsList6.getHeight());
                }
            }
        }
        ConstraintAnchor constraintAnchor5 = constraintAnchor3;
        int i15 = paddingTop;
        int i16 = paddingRight;
        int i17 = paddingBottom;
        ConstraintAnchor constraintAnchor6 = constraintAnchor;
        int i18 = paddingLeft;
        int i19 = 0;
        ConstraintAnchor constraintAnchor7 = constraintAnchor4;
        ConstraintAnchor constraintAnchor8 = constraintAnchor2;
        int i20 = 0;
        for (int i21 = 0; i21 < size; i21++) {
            WidgetsList widgetsList7 = this.mChainList.get(i21);
            if (i3 == 0) {
                if (i21 < size - 1) {
                    constraintAnchor7 = this.mChainList.get(i21 + 1).biggest.mTop;
                    i17 = 0;
                } else {
                    constraintAnchor7 = this.mBottom;
                    i17 = getPaddingBottom();
                }
                constraintAnchor8 = widgetsList7.biggest.mBottom;
                widgetsList7.setup(i3, constraintAnchor6, constraintAnchor8, constraintAnchor5, constraintAnchor7, i18, i15, i16, i17, i4);
                i19 = Math.max(i19, widgetsList7.getWidth());
                i20 += widgetsList7.getHeight();
                if (i21 > 0) {
                    i20 += this.mVerticalGap;
                }
                i15 = 0;
            } else {
                if (i21 < size - 1) {
                    constraintAnchor5 = this.mChainList.get(i21 + 1).biggest.mLeft;
                    i16 = 0;
                } else {
                    constraintAnchor5 = this.mRight;
                    i16 = getPaddingRight();
                }
                constraintAnchor6 = widgetsList7.biggest.mRight;
                widgetsList7.setup(i3, constraintAnchor6, constraintAnchor8, constraintAnchor5, constraintAnchor7, i18, i15, i16, i17, i4);
                i19 += widgetsList7.getWidth();
                i20 = Math.max(i20, widgetsList7.getHeight());
                if (i21 > 0) {
                    i19 += this.mHorizontalGap;
                }
                i18 = 0;
            }
        }
        iArr[0] = i19;
        iArr[1] = i20;
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArr, int i2, int i3, int i4, int[] iArr) {
        WidgetsList widgetsList;
        if (i2 == 0) {
            return;
        }
        if (this.mChainList.size() == 0) {
            widgetsList = new WidgetsList(i3, this.mLeft, this.mTop, this.mRight, this.mBottom, i4);
            this.mChainList.add(widgetsList);
        } else {
            WidgetsList widgetsList2 = this.mChainList.get(0);
            widgetsList2.clear();
            widgetsList = widgetsList2;
            widgetsList.setup(i3, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), i4);
        }
        for (int i5 = 0; i5 < i2; i5++) {
            widgetsList.add(constraintWidgetArr[i5]);
        }
        iArr[0] = widgetsList.getWidth();
        iArr[1] = widgetsList.getHeight();
    }

    @Override // androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        super.addToSolver(linearSystem, z);
        boolean isRtl = getParent() != null ? ((ConstraintWidgetContainer) getParent()).isRtl() : false;
        int i2 = this.mWrapMode;
        if (i2 != 0) {
            if (i2 == 1) {
                int size = this.mChainList.size();
                int i3 = 0;
                while (i3 < size) {
                    this.mChainList.get(i3).createConstraints(isRtl, i3, i3 == size + (-1));
                    i3++;
                }
            } else if (i2 == 2) {
                createAlignedConstraints(isRtl);
            }
        } else if (this.mChainList.size() > 0) {
            this.mChainList.get(0).createConstraints(isRtl, 0, true);
        }
        needsCallbackFromSolver(false);
    }

    @Override // androidx.constraintlayout.solver.widgets.HelperWidget, androidx.constraintlayout.solver.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Flow flow = (Flow) constraintWidget;
        this.mHorizontalStyle = flow.mHorizontalStyle;
        this.mVerticalStyle = flow.mVerticalStyle;
        this.mFirstHorizontalStyle = flow.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = flow.mFirstVerticalStyle;
        this.mLastHorizontalStyle = flow.mLastHorizontalStyle;
        this.mLastVerticalStyle = flow.mLastVerticalStyle;
        this.mHorizontalBias = flow.mHorizontalBias;
        this.mVerticalBias = flow.mVerticalBias;
        this.mFirstHorizontalBias = flow.mFirstHorizontalBias;
        this.mFirstVerticalBias = flow.mFirstVerticalBias;
        this.mLastHorizontalBias = flow.mLastHorizontalBias;
        this.mLastVerticalBias = flow.mLastVerticalBias;
        this.mHorizontalGap = flow.mHorizontalGap;
        this.mVerticalGap = flow.mVerticalGap;
        this.mHorizontalAlign = flow.mHorizontalAlign;
        this.mVerticalAlign = flow.mVerticalAlign;
        this.mWrapMode = flow.mWrapMode;
        this.mMaxElementsWrap = flow.mMaxElementsWrap;
        this.mOrientation = flow.mOrientation;
    }

    @Override // androidx.constraintlayout.solver.widgets.VirtualLayout
    public void measure(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int[] iArr;
        boolean z;
        if (this.mWidgetsCount > 0 && !measureChildren()) {
            setMeasure(0, 0);
            needsCallbackFromSolver(false);
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int[] iArr2 = new int[2];
        int i8 = (i3 - paddingLeft) - paddingRight;
        if (this.mOrientation == 1) {
            i8 = (i5 - paddingTop) - paddingBottom;
        }
        int i9 = i8;
        if (this.mOrientation == 0) {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        } else {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        }
        ConstraintWidget[] constraintWidgetArr = this.mWidgets;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            i6 = this.mWidgetsCount;
            if (i10 >= i6) {
                break;
            }
            if (this.mWidgets[i10].getVisibility() == 8) {
                i11++;
            }
            i10++;
        }
        if (i11 > 0) {
            constraintWidgetArr = new ConstraintWidget[i6 - i11];
            int i12 = 0;
            for (int i13 = 0; i13 < this.mWidgetsCount; i13++) {
                ConstraintWidget constraintWidget = this.mWidgets[i13];
                if (constraintWidget.getVisibility() != 8) {
                    constraintWidgetArr[i12] = constraintWidget;
                    i12++;
                }
            }
            i7 = i12;
        } else {
            i7 = i6;
        }
        this.mDisplayedWidgets = constraintWidgetArr;
        this.mDisplayedWidgetsCount = i7;
        int i14 = this.mWrapMode;
        if (i14 == 0) {
            iArr = iArr2;
            z = true;
            measureNoWrap(constraintWidgetArr, i7, this.mOrientation, i9, iArr2);
        } else if (i14 == 1) {
            iArr = iArr2;
            z = true;
            measureChainWrap(constraintWidgetArr, i7, this.mOrientation, i9, iArr2);
        } else if (i14 != 2) {
            iArr = iArr2;
            z = true;
        } else {
            z = true;
            iArr = iArr2;
            measureAligned(constraintWidgetArr, i7, this.mOrientation, i9, iArr2);
        }
        int i15 = iArr[0] + paddingLeft + paddingRight;
        int i16 = iArr[z ? 1 : 0] + paddingTop + paddingBottom;
        if (i2 == 1073741824) {
            i15 = i3;
        } else if (i2 == Integer.MIN_VALUE) {
            i15 = Math.min(i15, i3);
        } else if (i2 != 0) {
            i15 = 0;
        }
        if (i4 == 1073741824) {
            i16 = i5;
        } else if (i4 == Integer.MIN_VALUE) {
            i16 = Math.min(i16, i5);
        } else if (i4 != 0) {
            i16 = 0;
        }
        setMeasure(i15, i16);
        setWidth(i15);
        setHeight(i16);
        if (this.mWidgetsCount <= 0) {
            z = false;
        }
        needsCallbackFromSolver(z);
    }

    public void setFirstHorizontalBias(float f2) {
        this.mFirstHorizontalBias = f2;
    }

    public void setFirstHorizontalStyle(int i2) {
        this.mFirstHorizontalStyle = i2;
    }

    public void setFirstVerticalBias(float f2) {
        this.mFirstVerticalBias = f2;
    }

    public void setFirstVerticalStyle(int i2) {
        this.mFirstVerticalStyle = i2;
    }

    public void setHorizontalAlign(int i2) {
        this.mHorizontalAlign = i2;
    }

    public void setHorizontalBias(float f2) {
        this.mHorizontalBias = f2;
    }

    public void setHorizontalGap(int i2) {
        this.mHorizontalGap = i2;
    }

    public void setHorizontalStyle(int i2) {
        this.mHorizontalStyle = i2;
    }

    public void setLastHorizontalBias(float f2) {
        this.mLastHorizontalBias = f2;
    }

    public void setLastHorizontalStyle(int i2) {
        this.mLastHorizontalStyle = i2;
    }

    public void setLastVerticalBias(float f2) {
        this.mLastVerticalBias = f2;
    }

    public void setLastVerticalStyle(int i2) {
        this.mLastVerticalStyle = i2;
    }

    public void setMaxElementsWrap(int i2) {
        this.mMaxElementsWrap = i2;
    }

    public void setOrientation(int i2) {
        this.mOrientation = i2;
    }

    public void setVerticalAlign(int i2) {
        this.mVerticalAlign = i2;
    }

    public void setVerticalBias(float f2) {
        this.mVerticalBias = f2;
    }

    public void setVerticalGap(int i2) {
        this.mVerticalGap = i2;
    }

    public void setVerticalStyle(int i2) {
        this.mVerticalStyle = i2;
    }

    public void setWrapMode(int i2) {
        this.mWrapMode = i2;
    }
}
