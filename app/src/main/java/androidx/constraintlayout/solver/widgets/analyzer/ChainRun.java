package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ChainRun extends WidgetRun {
    private int chainStyle;
    ArrayList<WidgetRun> widgets;

    public ChainRun(ConstraintWidget constraintWidget, int i2) {
        super(constraintWidget);
        this.widgets = new ArrayList<>();
        this.orientation = i2;
        build();
    }

    private void build() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2 = this.widget;
        ConstraintWidget previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
        while (true) {
            ConstraintWidget constraintWidget3 = previousChainMember;
            constraintWidget = constraintWidget2;
            constraintWidget2 = constraintWidget3;
            if (constraintWidget2 == null) {
                break;
            } else {
                previousChainMember = constraintWidget2.getPreviousChainMember(this.orientation);
            }
        }
        this.widget = constraintWidget;
        this.widgets.add(constraintWidget.getRun(this.orientation));
        ConstraintWidget nextChainMember = constraintWidget.getNextChainMember(this.orientation);
        while (nextChainMember != null) {
            this.widgets.add(nextChainMember.getRun(this.orientation));
            nextChainMember = nextChainMember.getNextChainMember(this.orientation);
        }
        for (WidgetRun widgetRun : this.widgets) {
            int i2 = this.orientation;
            if (i2 == 0) {
                widgetRun.widget.horizontalChainRun = this;
            } else if (i2 == 1) {
                widgetRun.widget.verticalChainRun = this;
            }
        }
        if ((this.orientation == 0 && ((ConstraintWidgetContainer) this.widget.getParent()).isRtl()) && this.widgets.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.widgets;
            this.widget = arrayList.get(arrayList.size() - 1).widget;
        }
        this.chainStyle = this.orientation == 0 ? this.widget.getHorizontalChainStyle() : this.widget.getVerticalChainStyle();
    }

    private ConstraintWidget getFirstVisibleWidget() {
        for (int i2 = 0; i2 < this.widgets.size(); i2++) {
            WidgetRun widgetRun = this.widgets.get(i2);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        for (int size = this.widgets.size() - 1; size >= 0; size--) {
            WidgetRun widgetRun = this.widgets.get(size);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    void apply() {
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().apply();
        }
        int size = this.widgets.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = this.widgets.get(0).widget;
        ConstraintWidget constraintWidget2 = this.widgets.get(size - 1).widget;
        if (this.orientation == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.mLeft;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.mRight;
            DependencyNode target = getTarget(constraintAnchor, 0);
            int margin = constraintAnchor.getMargin();
            ConstraintWidget firstVisibleWidget = getFirstVisibleWidget();
            if (firstVisibleWidget != null) {
                margin = firstVisibleWidget.mLeft.getMargin();
            }
            if (target != null) {
                addTarget(this.start, target, margin);
            }
            DependencyNode target2 = getTarget(constraintAnchor2, 0);
            int margin2 = constraintAnchor2.getMargin();
            ConstraintWidget lastVisibleWidget = getLastVisibleWidget();
            if (lastVisibleWidget != null) {
                margin2 = lastVisibleWidget.mRight.getMargin();
            }
            if (target2 != null) {
                addTarget(this.end, target2, -margin2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.mTop;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.mBottom;
            DependencyNode target3 = getTarget(constraintAnchor3, 1);
            int margin3 = constraintAnchor3.getMargin();
            ConstraintWidget firstVisibleWidget2 = getFirstVisibleWidget();
            if (firstVisibleWidget2 != null) {
                margin3 = firstVisibleWidget2.mTop.getMargin();
            }
            if (target3 != null) {
                addTarget(this.start, target3, margin3);
            }
            DependencyNode target4 = getTarget(constraintAnchor4, 1);
            int margin4 = constraintAnchor4.getMargin();
            ConstraintWidget lastVisibleWidget2 = getLastVisibleWidget();
            if (lastVisibleWidget2 != null) {
                margin4 = lastVisibleWidget2.mBottom.getMargin();
            }
            if (target4 != null) {
                addTarget(this.end, target4, -margin4);
            }
        }
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public void applyToWidget() {
        for (int i2 = 0; i2 < this.widgets.size(); i2++) {
            this.widgets.get(i2).applyToWidget();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    public long getWrapDimension() {
        int size = this.widgets.size();
        long wrapDimension = 0;
        for (int i2 = 0; i2 < size; i2++) {
            WidgetRun widgetRun = this.widgets.get(i2);
            wrapDimension = wrapDimension + ((long) widgetRun.start.margin) + widgetRun.getWrapDimension() + ((long) widgetRun.end.margin);
        }
        return wrapDimension;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
    boolean supportsWrapComputation() {
        int size = this.widgets.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.widgets.get(i2).supportsWrapComputation()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChainRun ");
        sb.append(this.orientation == 0 ? "horizontal : " : "vertical : ");
        String string = sb.toString();
        Iterator<WidgetRun> it = this.widgets.iterator();
        while (it.hasNext()) {
            String str = string + "<";
            string = (str + it.next()) + "> ";
        }
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x01c8 A[PHI: r7 r19 r20 r21
  0x01c8: PHI (r7v27 int) = (r7v25 int), (r7v33 int) binds: [B:116:0x01c6, B:107:0x019e] A[DONT_GENERATE, DONT_INLINE]
  0x01c8: PHI (r19v3 float) = (r19v2 float), (r19v5 float) binds: [B:116:0x01c6, B:107:0x019e] A[DONT_GENERATE, DONT_INLINE]
  0x01c8: PHI (r20v5 int) = (r20v4 int), (r20v7 int) binds: [B:116:0x01c6, B:107:0x019e] A[DONT_GENERATE, DONT_INLINE]
  0x01c8: PHI (r21v6 int) = (r21v5 int), (r21v8 int) binds: [B:116:0x01c6, B:107:0x019e] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.constraintlayout.solver.widgets.analyzer.WidgetRun, androidx.constraintlayout.solver.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void update(Dependency dependency) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        float f2;
        int i7;
        int i8;
        int i9;
        int i10;
        float f3;
        int i11;
        int iMax;
        if (this.start.resolved && this.end.resolved) {
            ConstraintWidget parent = this.widget.getParent();
            boolean zIsRtl = (parent == null || !(parent instanceof ConstraintWidgetContainer)) ? false : ((ConstraintWidgetContainer) parent).isRtl();
            int i12 = this.end.value - this.start.value;
            int size = this.widgets.size();
            int i13 = 0;
            while (true) {
                i2 = -1;
                i3 = 8;
                if (i13 >= size) {
                    i13 = -1;
                    break;
                } else if (this.widgets.get(i13).widget.getVisibility() != 8) {
                    break;
                } else {
                    i13++;
                }
            }
            int i14 = size - 1;
            int i15 = i14;
            while (true) {
                if (i15 < 0) {
                    break;
                }
                if (this.widgets.get(i15).widget.getVisibility() != 8) {
                    i2 = i15;
                    break;
                }
                i15--;
            }
            int i16 = 0;
            while (i16 < 2) {
                int i17 = 0;
                i5 = 0;
                i6 = 0;
                int i18 = 0;
                f2 = 0.0f;
                while (i17 < size) {
                    WidgetRun widgetRun = this.widgets.get(i17);
                    if (widgetRun.widget.getVisibility() != i3) {
                        i18++;
                        if (i17 > 0 && i17 >= i13) {
                            i5 += widgetRun.start.margin;
                        }
                        int i19 = widgetRun.dimension.value;
                        boolean z = widgetRun.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (!z) {
                            if (widgetRun.matchConstraintsType == 1 && i16 == 0) {
                                i19 = widgetRun.dimension.wrapValue;
                                i6++;
                            } else if (widgetRun.dimension.resolved) {
                            }
                            z = true;
                        } else {
                            if (this.orientation == 0 && !widgetRun.widget.horizontalRun.dimension.resolved) {
                                return;
                            }
                            if (this.orientation == 1 && !widgetRun.widget.verticalRun.dimension.resolved) {
                                return;
                            }
                        }
                        if (z) {
                            i5 += i19;
                        } else {
                            i6++;
                            float f4 = widgetRun.widget.mWeight[this.orientation];
                            if (f4 >= 0.0f) {
                                f2 += f4;
                            }
                        }
                        if (i17 < i14 && i17 < i2) {
                            i5 += -widgetRun.end.margin;
                        }
                    }
                    i17++;
                    i3 = 8;
                }
                if (i5 < i12 || i6 == 0) {
                    i4 = i18;
                    break;
                } else {
                    i16++;
                    i3 = 8;
                }
            }
            i4 = 0;
            i5 = 0;
            i6 = 0;
            f2 = 0.0f;
            int i20 = this.start.value;
            if (zIsRtl) {
                i20 = this.end.value;
            }
            if (i5 > i12) {
                i20 = zIsRtl ? i20 + ((int) (((i5 - i12) / 2.0f) + 0.5f)) : i20 - ((int) (((i5 - i12) / 2.0f) + 0.5f));
            }
            if (i6 > 0) {
                float f5 = i12 - i5;
                int i21 = (int) ((f5 / i6) + 0.5f);
                int i22 = 0;
                int i23 = 0;
                while (i22 < size) {
                    WidgetRun widgetRun2 = this.widgets.get(i22);
                    int i24 = i21;
                    if (widgetRun2.widget.getVisibility() == 8 || widgetRun2.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || widgetRun2.dimension.resolved) {
                        i10 = i20;
                        f3 = f5;
                        i11 = i5;
                    } else {
                        int i25 = f2 > 0.0f ? (int) (((widgetRun2.widget.mWeight[this.orientation] * f5) / f2) + 0.5f) : i24;
                        if (this.orientation == 0) {
                            ConstraintWidget constraintWidget = widgetRun2.widget;
                            f3 = f5;
                            int i26 = constraintWidget.mMatchConstraintMaxWidth;
                            i11 = i5;
                            i10 = i20;
                            iMax = Math.max(constraintWidget.mMatchConstraintMinWidth, widgetRun2.matchConstraintsType == 1 ? Math.min(i25, widgetRun2.dimension.wrapValue) : i25);
                            if (i26 > 0) {
                                iMax = Math.min(i26, iMax);
                            }
                            if (iMax != i25) {
                                i23++;
                                i25 = iMax;
                            }
                            widgetRun2.dimension.resolve(i25);
                        } else {
                            i10 = i20;
                            f3 = f5;
                            i11 = i5;
                            ConstraintWidget constraintWidget2 = widgetRun2.widget;
                            int i27 = constraintWidget2.mMatchConstraintMaxHeight;
                            iMax = Math.max(constraintWidget2.mMatchConstraintMinHeight, widgetRun2.matchConstraintsType == 1 ? Math.min(i25, widgetRun2.dimension.wrapValue) : i25);
                            if (i27 > 0) {
                                iMax = Math.min(i27, iMax);
                            }
                            if (iMax != i25) {
                            }
                            widgetRun2.dimension.resolve(i25);
                        }
                    }
                    i22++;
                    i21 = i24;
                    f5 = f3;
                    i5 = i11;
                    i20 = i10;
                }
                i7 = i20;
                int i28 = i5;
                if (i23 > 0) {
                    i6 -= i23;
                    int i29 = 0;
                    for (int i30 = 0; i30 < size; i30++) {
                        WidgetRun widgetRun3 = this.widgets.get(i30);
                        if (widgetRun3.widget.getVisibility() != 8) {
                            if (i30 > 0 && i30 >= i13) {
                                i29 += widgetRun3.start.margin;
                            }
                            i29 += widgetRun3.dimension.value;
                            if (i30 < i14 && i30 < i2) {
                                i29 += -widgetRun3.end.margin;
                            }
                        }
                    }
                    i5 = i29;
                } else {
                    i5 = i28;
                }
                i9 = 2;
                if (this.chainStyle == 2 && i23 == 0) {
                    i8 = 0;
                    this.chainStyle = 0;
                } else {
                    i8 = 0;
                }
            } else {
                i7 = i20;
                i8 = 0;
                i9 = 2;
            }
            if (i5 > i12) {
                this.chainStyle = i9;
            }
            if (i4 > 0 && i6 == 0 && i13 == i2) {
                this.chainStyle = i9;
            }
            int i31 = this.chainStyle;
            if (i31 == 1) {
                int i32 = i4 > 1 ? (i12 - i5) / (i4 - 1) : i4 == 1 ? (i12 - i5) / 2 : 0;
                if (i6 > 0) {
                    i32 = 0;
                }
                int i33 = i7;
                while (i8 < size) {
                    WidgetRun widgetRun4 = this.widgets.get(zIsRtl ? size - (i8 + 1) : i8);
                    if (widgetRun4.widget.getVisibility() == 8) {
                        widgetRun4.start.resolve(i33);
                        widgetRun4.end.resolve(i33);
                    } else {
                        if (i8 > 0) {
                            i33 = zIsRtl ? i33 - i32 : i33 + i32;
                        }
                        if (i8 > 0 && i8 >= i13) {
                            i33 = zIsRtl ? i33 - widgetRun4.start.margin : i33 + widgetRun4.start.margin;
                        }
                        if (zIsRtl) {
                            widgetRun4.end.resolve(i33);
                        } else {
                            widgetRun4.start.resolve(i33);
                        }
                        DimensionDependency dimensionDependency = widgetRun4.dimension;
                        int i34 = dimensionDependency.value;
                        if (widgetRun4.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun4.matchConstraintsType == 1) {
                            i34 = dimensionDependency.wrapValue;
                        }
                        i33 = zIsRtl ? i33 - i34 : i33 + i34;
                        if (zIsRtl) {
                            widgetRun4.start.resolve(i33);
                        } else {
                            widgetRun4.end.resolve(i33);
                        }
                        widgetRun4.resolved = true;
                        if (i8 < i14 && i8 < i2) {
                            i33 = zIsRtl ? i33 - (-widgetRun4.end.margin) : i33 + (-widgetRun4.end.margin);
                        }
                    }
                    i8++;
                }
                return;
            }
            if (i31 == 0) {
                int i35 = (i12 - i5) / (i4 + 1);
                if (i6 > 0) {
                    i35 = 0;
                }
                int i36 = i7;
                while (i8 < size) {
                    WidgetRun widgetRun5 = this.widgets.get(zIsRtl ? size - (i8 + 1) : i8);
                    if (widgetRun5.widget.getVisibility() == 8) {
                        widgetRun5.start.resolve(i36);
                        widgetRun5.end.resolve(i36);
                    } else {
                        int i37 = zIsRtl ? i36 - i35 : i36 + i35;
                        if (i8 > 0 && i8 >= i13) {
                            i37 = zIsRtl ? i37 - widgetRun5.start.margin : i37 + widgetRun5.start.margin;
                        }
                        if (zIsRtl) {
                            widgetRun5.end.resolve(i37);
                        } else {
                            widgetRun5.start.resolve(i37);
                        }
                        DimensionDependency dimensionDependency2 = widgetRun5.dimension;
                        int iMin = dimensionDependency2.value;
                        if (widgetRun5.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun5.matchConstraintsType == 1) {
                            iMin = Math.min(iMin, dimensionDependency2.wrapValue);
                        }
                        i36 = zIsRtl ? i37 - iMin : i37 + iMin;
                        if (zIsRtl) {
                            widgetRun5.start.resolve(i36);
                        } else {
                            widgetRun5.end.resolve(i36);
                        }
                        if (i8 < i14 && i8 < i2) {
                            i36 = zIsRtl ? i36 - (-widgetRun5.end.margin) : i36 + (-widgetRun5.end.margin);
                        }
                    }
                    i8++;
                }
                return;
            }
            if (i31 == 2) {
                float horizontalBiasPercent = this.orientation == 0 ? this.widget.getHorizontalBiasPercent() : this.widget.getVerticalBiasPercent();
                if (zIsRtl) {
                    horizontalBiasPercent = 1.0f - horizontalBiasPercent;
                }
                int i38 = (int) (((i12 - i5) * horizontalBiasPercent) + 0.5f);
                if (i38 < 0 || i6 > 0) {
                    i38 = 0;
                }
                int i39 = zIsRtl ? i7 - i38 : i7 + i38;
                while (i8 < size) {
                    WidgetRun widgetRun6 = this.widgets.get(zIsRtl ? size - (i8 + 1) : i8);
                    if (widgetRun6.widget.getVisibility() == 8) {
                        widgetRun6.start.resolve(i39);
                        widgetRun6.end.resolve(i39);
                    } else {
                        if (i8 > 0 && i8 >= i13) {
                            i39 = zIsRtl ? i39 - widgetRun6.start.margin : i39 + widgetRun6.start.margin;
                        }
                        if (zIsRtl) {
                            widgetRun6.end.resolve(i39);
                        } else {
                            widgetRun6.start.resolve(i39);
                        }
                        DimensionDependency dimensionDependency3 = widgetRun6.dimension;
                        int i40 = dimensionDependency3.value;
                        if (widgetRun6.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && widgetRun6.matchConstraintsType == 1) {
                            i40 = dimensionDependency3.wrapValue;
                        }
                        i39 = zIsRtl ? i39 - i40 : i39 + i40;
                        if (zIsRtl) {
                            widgetRun6.start.resolve(i39);
                        } else {
                            widgetRun6.end.resolve(i39);
                        }
                        if (i8 < i14 && i8 < i2) {
                            i39 = zIsRtl ? i39 - (-widgetRun6.end.margin) : i39 + (-widgetRun6.end.margin);
                        }
                    }
                    i8++;
                }
            }
        }
    }
}
