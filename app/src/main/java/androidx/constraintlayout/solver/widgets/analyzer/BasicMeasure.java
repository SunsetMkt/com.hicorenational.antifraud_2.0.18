package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    public static final int EXACTLY = 1073741824;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private ConstraintWidgetContainer constraintWidgetContainer;
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList<>();
    private Measure mMeasure = new Measure();

    public static class Measure {
        public static int SELF_DIMENSIONS = 0;
        public static int TRY_GIVEN_DIMENSIONS = 1;
        public static int USE_GIVEN_DIMENSIONS = 2;
        public ConstraintWidget.DimensionBehaviour horizontalBehavior;
        public int horizontalDimension;
        public int measureStrategy;
        public int measuredBaseline;
        public boolean measuredHasBaseline;
        public int measuredHeight;
        public boolean measuredNeedsSolverPass;
        public int measuredWidth;
        public ConstraintWidget.DimensionBehaviour verticalBehavior;
        public int verticalDimension;
    }

    public interface Measurer {
        void didMeasures();

        void measure(ConstraintWidget constraintWidget, Measure measure);
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.constraintWidgetContainer = constraintWidgetContainer;
    }

    private boolean measure(Measurer measurer, ConstraintWidget constraintWidget, int i2) {
        this.mMeasure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = constraintWidget.getWidth();
        this.mMeasure.verticalDimension = constraintWidget.getHeight();
        Measure measure = this.mMeasure;
        measure.measuredNeedsSolverPass = false;
        measure.measureStrategy = i2;
        boolean z = measure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z2 = this.mMeasure.verticalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z3 = z && constraintWidget.mDimensionRatio > 0.0f;
        boolean z4 = z2 && constraintWidget.mDimensionRatio > 0.0f;
        if (z3 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
            this.mMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (z4 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
            this.mMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(constraintWidget, this.mMeasure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
        Measure measure2 = this.mMeasure;
        measure2.measureStrategy = Measure.SELF_DIMENSIONS;
        return measure2.measuredNeedsSolverPass;
    }

    private void measureChildren(ConstraintWidgetContainer constraintWidgetContainer) {
        HorizontalWidgetRun horizontalWidgetRun;
        VerticalWidgetRun verticalWidgetRun;
        int size = constraintWidgetContainer.mChildren.size();
        boolean optimizeFor = constraintWidgetContainer.optimizeFor(64);
        Measurer measurer = constraintWidgetContainer.getMeasurer();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i2);
            if (!(constraintWidget instanceof Guideline) && !(constraintWidget instanceof Barrier) && !constraintWidget.isInVirtualLayout() && (!optimizeFor || (horizontalWidgetRun = constraintWidget.horizontalRun) == null || (verticalWidgetRun = constraintWidget.verticalRun) == null || !horizontalWidgetRun.dimension.resolved || !verticalWidgetRun.dimension.resolved)) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(0);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.getDimensionBehaviour(1);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                boolean z = dimensionBehaviour == dimensionBehaviour3 && constraintWidget.mMatchConstraintDefaultWidth != 1 && dimensionBehaviour2 == dimensionBehaviour3 && constraintWidget.mMatchConstraintDefaultHeight != 1;
                if (!z && constraintWidgetContainer.optimizeFor(1) && !(constraintWidget instanceof VirtualLayout)) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour == dimensionBehaviour4 && constraintWidget.mMatchConstraintDefaultWidth == 0 && dimensionBehaviour2 != dimensionBehaviour4 && !constraintWidget.isInHorizontalChain()) {
                        z = true;
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour2 == dimensionBehaviour5 && constraintWidget.mMatchConstraintDefaultHeight == 0 && dimensionBehaviour != dimensionBehaviour5 && !constraintWidget.isInHorizontalChain()) {
                        z = true;
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if ((dimensionBehaviour == dimensionBehaviour6 || dimensionBehaviour2 == dimensionBehaviour6) && constraintWidget.mDimensionRatio > 0.0f) {
                        z = true;
                    }
                }
                if (!z) {
                    measure(measurer, constraintWidget, Measure.SELF_DIMENSIONS);
                    Metrics metrics = constraintWidgetContainer.mMetrics;
                    if (metrics != null) {
                        metrics.measuredWidgets++;
                    }
                }
            }
        }
        measurer.didMeasures();
    }

    private void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer, String str, int i2, int i3) {
        int minWidth = constraintWidgetContainer.getMinWidth();
        int minHeight = constraintWidgetContainer.getMinHeight();
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setWidth(i2);
        constraintWidgetContainer.setHeight(i3);
        constraintWidgetContainer.setMinWidth(minWidth);
        constraintWidgetContainer.setMinHeight(minHeight);
        this.constraintWidgetContainer.layout();
    }

    public long solverMeasure(ConstraintWidgetContainer constraintWidgetContainer, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        boolean z;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z2;
        boolean z3;
        boolean z4;
        int i15;
        Measurer measurer;
        int i16;
        int i17;
        int i18;
        boolean z5;
        Metrics metrics;
        Measurer measurer2 = constraintWidgetContainer.getMeasurer();
        int size = constraintWidgetContainer.mChildren.size();
        int width = constraintWidgetContainer.getWidth();
        int height = constraintWidgetContainer.getHeight();
        boolean enabled = Optimizer.enabled(i2, 128);
        boolean z6 = enabled || Optimizer.enabled(i2, 64);
        if (z6) {
            for (int i19 = 0; i19 < size; i19++) {
                ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i19);
                boolean z7 = (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.getDimensionRatio() > 0.0f;
                if ((constraintWidget.isInHorizontalChain() && z7) || ((constraintWidget.isInVerticalChain() && z7) || (constraintWidget instanceof VirtualLayout) || constraintWidget.isInHorizontalChain() || constraintWidget.isInVerticalChain())) {
                    z6 = false;
                    break;
                }
            }
        }
        if (z6 && (metrics = LinearSystem.sMetrics) != null) {
            metrics.measures++;
        }
        boolean z8 = z6 & ((i5 == 1073741824 && i7 == 1073741824) || enabled);
        if (z8) {
            int min = Math.min(constraintWidgetContainer.getMaxWidth(), i6);
            int min2 = Math.min(constraintWidgetContainer.getMaxHeight(), i8);
            if (i5 == 1073741824 && constraintWidgetContainer.getWidth() != min) {
                constraintWidgetContainer.setWidth(min);
                constraintWidgetContainer.invalidateGraph();
            }
            if (i7 == 1073741824 && constraintWidgetContainer.getHeight() != min2) {
                constraintWidgetContainer.setHeight(min2);
                constraintWidgetContainer.invalidateGraph();
            }
            if (i5 == 1073741824 && i7 == 1073741824) {
                z = constraintWidgetContainer.directMeasure(enabled);
                i11 = 2;
            } else {
                boolean directMeasureSetup = constraintWidgetContainer.directMeasureSetup(enabled);
                if (i5 == 1073741824) {
                    directMeasureSetup &= constraintWidgetContainer.directMeasureWithOrientation(enabled, 0);
                    i11 = 1;
                } else {
                    i11 = 0;
                }
                if (i7 == 1073741824) {
                    z = constraintWidgetContainer.directMeasureWithOrientation(enabled, 1) & directMeasureSetup;
                    i11++;
                } else {
                    z = directMeasureSetup;
                }
            }
            if (z) {
                constraintWidgetContainer.updateFromRuns(i5 == 1073741824, i7 == 1073741824);
            }
        } else {
            z = false;
            i11 = 0;
        }
        if (z && i11 == 2) {
            return 0L;
        }
        int optimizationLevel = constraintWidgetContainer.getOptimizationLevel();
        if (size > 0) {
            measureChildren(constraintWidgetContainer);
        }
        updateHierarchy(constraintWidgetContainer);
        int size2 = this.mVariableDimensionsWidgets.size();
        if (size > 0) {
            solveLinearSystem(constraintWidgetContainer, "First pass", width, height);
        }
        if (size2 > 0) {
            boolean z9 = constraintWidgetContainer.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            boolean z10 = constraintWidgetContainer.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            int max = Math.max(constraintWidgetContainer.getWidth(), this.constraintWidgetContainer.getMinWidth());
            int max2 = Math.max(constraintWidgetContainer.getHeight(), this.constraintWidgetContainer.getMinHeight());
            int i20 = 0;
            boolean z11 = false;
            while (i20 < size2) {
                ConstraintWidget constraintWidget2 = this.mVariableDimensionsWidgets.get(i20);
                if (constraintWidget2 instanceof VirtualLayout) {
                    int width2 = constraintWidget2.getWidth();
                    i16 = optimizationLevel;
                    int height2 = constraintWidget2.getHeight();
                    i17 = width;
                    boolean measure = measure(measurer2, constraintWidget2, Measure.TRY_GIVEN_DIMENSIONS) | z11;
                    Metrics metrics2 = constraintWidgetContainer.mMetrics;
                    i18 = height;
                    if (metrics2 != null) {
                        metrics2.measuredMatchWidgets++;
                    }
                    int width3 = constraintWidget2.getWidth();
                    int height3 = constraintWidget2.getHeight();
                    if (width3 != width2) {
                        constraintWidget2.setWidth(width3);
                        if (z9 && constraintWidget2.getRight() > max) {
                            max = Math.max(max, constraintWidget2.getRight() + constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                        }
                        z5 = true;
                    } else {
                        z5 = measure;
                    }
                    if (height3 != height2) {
                        constraintWidget2.setHeight(height3);
                        if (z10 && constraintWidget2.getBottom() > max2) {
                            max2 = Math.max(max2, constraintWidget2.getBottom() + constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                        }
                        z5 = true;
                    }
                    z11 = ((VirtualLayout) constraintWidget2).needSolverPass() | z5;
                } else {
                    i16 = optimizationLevel;
                    i17 = width;
                    i18 = height;
                }
                i20++;
                optimizationLevel = i16;
                width = i17;
                height = i18;
            }
            int i21 = optimizationLevel;
            int i22 = width;
            int i23 = height;
            int i24 = 0;
            int i25 = 2;
            while (true) {
                if (i24 >= i25) {
                    i13 = i22;
                    i14 = i23;
                    z2 = z11;
                    break;
                }
                z2 = z11;
                int i26 = 0;
                while (i26 < size2) {
                    ConstraintWidget constraintWidget3 = this.mVariableDimensionsWidgets.get(i26);
                    if (((constraintWidget3 instanceof Helper) && !(constraintWidget3 instanceof VirtualLayout)) || (constraintWidget3 instanceof Guideline) || constraintWidget3.getVisibility() == 8 || ((z8 && constraintWidget3.horizontalRun.dimension.resolved && constraintWidget3.verticalRun.dimension.resolved) || (constraintWidget3 instanceof VirtualLayout))) {
                        z4 = z8;
                        i15 = size2;
                        measurer = measurer2;
                    } else {
                        int width4 = constraintWidget3.getWidth();
                        int height4 = constraintWidget3.getHeight();
                        int baselineDistance = constraintWidget3.getBaselineDistance();
                        int i27 = Measure.TRY_GIVEN_DIMENSIONS;
                        z4 = z8;
                        if (i24 == 1) {
                            i27 = Measure.USE_GIVEN_DIMENSIONS;
                        }
                        z2 |= measure(measurer2, constraintWidget3, i27);
                        Metrics metrics3 = constraintWidgetContainer.mMetrics;
                        i15 = size2;
                        measurer = measurer2;
                        if (metrics3 != null) {
                            metrics3.measuredMatchWidgets++;
                        }
                        int width5 = constraintWidget3.getWidth();
                        int height5 = constraintWidget3.getHeight();
                        if (width5 != width4) {
                            constraintWidget3.setWidth(width5);
                            if (z9 && constraintWidget3.getRight() > max) {
                                max = Math.max(max, constraintWidget3.getRight() + constraintWidget3.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                            }
                            z2 = true;
                        }
                        if (height5 != height4) {
                            constraintWidget3.setHeight(height5);
                            if (z10 && constraintWidget3.getBottom() > max2) {
                                max2 = Math.max(max2, constraintWidget3.getBottom() + constraintWidget3.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                            }
                            z2 = true;
                        }
                        if (constraintWidget3.hasBaseline() && baselineDistance != constraintWidget3.getBaselineDistance()) {
                            z2 = true;
                        }
                    }
                    i26++;
                    size2 = i15;
                    measurer2 = measurer;
                    z8 = z4;
                }
                boolean z12 = z8;
                int i28 = size2;
                Measurer measurer3 = measurer2;
                if (!z2) {
                    i13 = i22;
                    i14 = i23;
                    break;
                }
                solveLinearSystem(constraintWidgetContainer, "intermediate pass", i22, i23);
                i24++;
                measurer2 = measurer3;
                z8 = z12;
                i25 = 2;
                z11 = false;
                size2 = i28;
            }
            if (z2) {
                solveLinearSystem(constraintWidgetContainer, "2nd pass", i13, i14);
                if (constraintWidgetContainer.getWidth() < max) {
                    constraintWidgetContainer.setWidth(max);
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (constraintWidgetContainer.getHeight() < max2) {
                    constraintWidgetContainer.setHeight(max2);
                    z3 = true;
                }
                if (z3) {
                    solveLinearSystem(constraintWidgetContainer, "3rd pass", i13, i14);
                }
            }
            i12 = i21;
        } else {
            i12 = optimizationLevel;
        }
        constraintWidgetContainer.setOptimizationLevel(i12);
        return 0L;
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer) {
        this.mVariableDimensionsWidgets.clear();
        int size = constraintWidgetContainer.mChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = constraintWidgetContainer.mChildren.get(i2);
            if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                this.mVariableDimensionsWidgets.add(constraintWidget);
            }
        }
        constraintWidgetContainer.invalidateGraph();
    }
}
