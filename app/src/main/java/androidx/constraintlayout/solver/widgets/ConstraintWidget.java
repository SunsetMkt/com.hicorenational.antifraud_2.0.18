package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import androidx.exifinterface.media.ExifInterface;
import d.c.a.b.a.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintWidget {
    public static final int ANCHOR_BASELINE = 4;
    public static final int ANCHOR_BOTTOM = 3;
    public static final int ANCHOR_LEFT = 0;
    public static final int ANCHOR_RIGHT = 1;
    public static final int ANCHOR_TOP = 2;
    private static final boolean AUTOTAG_CENTER = false;
    public static final int BOTH = 2;
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static float DEFAULT_BIAS = 0.5f;
    static final int DIMENSION_HORIZONTAL = 0;
    static final int DIMENSION_VERTICAL = 1;
    protected static final int DIRECT = 2;
    public static final int GONE = 8;
    public static final int HORIZONTAL = 0;
    public static final int INVISIBLE = 4;
    public static final int MATCH_CONSTRAINT_PERCENT = 2;
    public static final int MATCH_CONSTRAINT_RATIO = 3;
    public static final int MATCH_CONSTRAINT_RATIO_RESOLVED = 4;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    protected static final int SOLVER = 1;
    public static final int UNKNOWN = -1;
    private static final boolean USE_WRAP_DIMENSION_FOR_SPREAD = false;
    public static final int VERTICAL = 1;
    public static final int VISIBLE = 0;
    private static final int WRAP = -2;
    private boolean OPTIMIZE_WRAP;
    private boolean OPTIMIZE_WRAP_ON_RESOLVED;
    private boolean hasBaseline;
    public ChainRun horizontalChainRun;
    public int horizontalGroup;
    public HorizontalWidgetRun horizontalRun;
    private boolean inPlaceholder;
    public boolean[] isTerminalWidget;
    protected ArrayList<ConstraintAnchor> mAnchors;
    public ConstraintAnchor mBaseline;
    int mBaselineDistance;
    public ConstraintAnchor mBottom;
    boolean mBottomHasCentered;
    public ConstraintAnchor mCenter;
    ConstraintAnchor mCenterX;
    ConstraintAnchor mCenterY;
    private float mCircleConstraintAngle;
    private Object mCompanionWidget;
    private int mContainerItemSkip;
    private String mDebugName;
    public float mDimensionRatio;
    protected int mDimensionRatioSide;
    int mDistToBottom;
    int mDistToLeft;
    int mDistToRight;
    int mDistToTop;
    boolean mGroupsToSolver;
    int mHeight;
    float mHorizontalBiasPercent;
    boolean mHorizontalChainFixedPosition;
    int mHorizontalChainStyle;
    ConstraintWidget mHorizontalNextWidget;
    public int mHorizontalResolution;
    boolean mHorizontalWrapVisited;
    private boolean mInVirtuaLayout;
    public boolean mIsHeightWrapContent;
    private boolean[] mIsInBarrier;
    public boolean mIsWidthWrapContent;
    private int mLastHorizontalMeasureSpec;
    private int mLastVerticalMeasureSpec;
    public ConstraintAnchor mLeft;
    boolean mLeftHasCentered;
    public ConstraintAnchor[] mListAnchors;
    public DimensionBehaviour[] mListDimensionBehaviors;
    protected ConstraintWidget[] mListNextMatchConstraintsWidget;
    public int mMatchConstraintDefaultHeight;
    public int mMatchConstraintDefaultWidth;
    public int mMatchConstraintMaxHeight;
    public int mMatchConstraintMaxWidth;
    public int mMatchConstraintMinHeight;
    public int mMatchConstraintMinWidth;
    public float mMatchConstraintPercentHeight;
    public float mMatchConstraintPercentWidth;
    private int[] mMaxDimension;
    private boolean mMeasureRequested;
    protected int mMinHeight;
    protected int mMinWidth;
    protected ConstraintWidget[] mNextChainWidget;
    protected int mOffsetX;
    protected int mOffsetY;
    public ConstraintWidget mParent;
    int mRelX;
    int mRelY;
    float mResolvedDimensionRatio;
    int mResolvedDimensionRatioSide;
    boolean mResolvedHasRatio;
    public int[] mResolvedMatchConstraintDefault;
    public ConstraintAnchor mRight;
    boolean mRightHasCentered;
    public ConstraintAnchor mTop;
    boolean mTopHasCentered;
    private String mType;
    float mVerticalBiasPercent;
    boolean mVerticalChainFixedPosition;
    int mVerticalChainStyle;
    ConstraintWidget mVerticalNextWidget;
    public int mVerticalResolution;
    boolean mVerticalWrapVisited;
    private int mVisibility;
    public float[] mWeight;
    int mWidth;
    protected int mX;
    protected int mY;
    public boolean measured;
    private boolean resolvedHorizontal;
    private boolean resolvedVertical;
    public WidgetRun[] run;
    public ChainRun verticalChainRun;
    public int verticalGroup;
    public VerticalWidgetRun verticalRun;

    /* JADX INFO: renamed from: androidx.constraintlayout.solver.widgets.ConstraintWidget$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour = new int[DimensionBehaviour.values().length];

        static {
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type = new int[ConstraintAnchor.Type.values().length];
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public enum DimensionBehaviour {
        FIXED,
        WRAP_CONTENT,
        MATCH_CONSTRAINT,
        MATCH_PARENT
    }

    public ConstraintWidget() {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f2 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f2;
        this.mVerticalBiasPercent = f2;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
    }

    private void addAnchors() {
        this.mAnchors.add(this.mLeft);
        this.mAnchors.add(this.mTop);
        this.mAnchors.add(this.mRight);
        this.mAnchors.add(this.mBottom);
        this.mAnchors.add(this.mCenterX);
        this.mAnchors.add(this.mCenterY);
        this.mAnchors.add(this.mCenter);
        this.mAnchors.add(this.mBaseline);
    }

    /* JADX WARN: Removed duplicated region for block: B:397:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:398:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:407:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:419:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:473:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:582:0x03ba A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:585:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:587:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:595:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:603:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:616:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:624:0x046c  */
    /* JADX WARN: Removed duplicated region for block: B:626:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:658:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:674:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:696:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:698:0x0531 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:717:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:728:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void applyConstraints(LinearSystem linearSystem, boolean z, boolean z2, boolean z3, boolean z4, SolverVariable solverVariable, SolverVariable solverVariable2, DimensionBehaviour dimensionBehaviour, boolean z5, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2, int i3, int i4, int i5, float f2, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, int i6, int i7, int i8, int i9, float f3, boolean z11) {
        int i10;
        boolean z12;
        int iMin;
        SolverVariable solverVariable3;
        int i11;
        int i12;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        int i13;
        SolverVariable solverVariable6;
        int i14;
        boolean z13;
        SolverVariable solverVariableCreateObjectVariable;
        SolverVariable solverVariableCreateObjectVariable2;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        SolverVariable solverVariable9;
        int i15;
        int i16;
        int i17;
        char c2;
        int i18;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        SolverVariable solverVariable10;
        boolean z14;
        boolean z15;
        SolverVariable solverVariable11;
        int margin;
        int i19;
        boolean z16;
        int i20;
        int i21;
        boolean z17;
        SolverVariable solverVariable12;
        SolverVariable solverVariable13;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        SolverVariable solverVariable14;
        int i22;
        boolean z18;
        boolean z19;
        ConstraintWidget constraintWidget3;
        SolverVariable solverVariable15;
        int i23;
        int i24;
        int iMin2;
        ConstraintWidget constraintWidget4;
        int i25;
        int i26;
        boolean z20;
        boolean z21;
        boolean z22;
        int i27;
        int i28;
        ConstraintWidget constraintWidget5;
        SolverVariable solverVariable16;
        int margin2;
        ConstraintWidget constraintWidget6;
        int i29 = i8;
        int i30 = i9;
        SolverVariable solverVariableCreateObjectVariable3 = linearSystem.createObjectVariable(constraintAnchor);
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem.createObjectVariable(constraintAnchor2);
        SolverVariable solverVariableCreateObjectVariable5 = linearSystem.createObjectVariable(constraintAnchor.getTarget());
        SolverVariable solverVariableCreateObjectVariable6 = linearSystem.createObjectVariable(constraintAnchor2.getTarget());
        if (LinearSystem.getMetrics() != null) {
            LinearSystem.getMetrics().nonresolvedWidgets++;
        }
        boolean zIsConnected = constraintAnchor.isConnected();
        boolean zIsConnected2 = constraintAnchor2.isConnected();
        boolean zIsConnected3 = this.mCenter.isConnected();
        int i31 = zIsConnected ? 1 : 0;
        if (zIsConnected2) {
            i31++;
        }
        if (zIsConnected3) {
            i31++;
        }
        int i32 = i31;
        int i33 = z6 ? 3 : i6;
        int i34 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[dimensionBehaviour.ordinal()];
        if (i34 == 1 || i34 == 2 || i34 == 3 || i34 != 4) {
            i10 = i33;
        } else {
            i10 = i33;
            z12 = i10 != 4;
            if (this.mVisibility != 8) {
                iMin = 0;
                z12 = false;
            } else {
                iMin = i3;
            }
            if (z11) {
                if (!zIsConnected && !zIsConnected2 && !zIsConnected3) {
                    linearSystem.addEquality(solverVariableCreateObjectVariable3, i2);
                } else if (zIsConnected && !zIsConnected2) {
                    solverVariable3 = solverVariableCreateObjectVariable6;
                    linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable5, constraintAnchor.getMargin(), 8);
                }
                solverVariable3 = solverVariableCreateObjectVariable6;
            } else {
                solverVariable3 = solverVariableCreateObjectVariable6;
            }
            if (!z12) {
                if (i32 == 2 || z6 || !(i10 == 1 || i10 == 0)) {
                    if (i29 == -2) {
                        i29 = iMin;
                    }
                    int i35 = i30 == -2 ? iMin : i30;
                    if (iMin > 0 && i10 != 1) {
                        iMin = 0;
                    }
                    if (i29 > 0) {
                        linearSystem.addGreaterThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i29, 8);
                        iMin = Math.max(iMin, i29);
                    }
                    if (i35 > 0) {
                        if ((z2 && i10 == 1) ? false : true) {
                            i11 = 8;
                            linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i35, 8);
                        } else {
                            i11 = 8;
                        }
                        iMin = Math.min(iMin, i35);
                    } else {
                        i11 = 8;
                    }
                    if (i10 == 1) {
                        if (z2) {
                            linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, i11);
                        } else if (z8) {
                            linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 5);
                            linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, i11);
                        } else {
                            linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 5);
                            linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, i11);
                        }
                        z13 = z4;
                        i30 = i35;
                        i14 = i29;
                        i12 = i10;
                        solverVariable4 = solverVariableCreateObjectVariable4;
                        solverVariable5 = solverVariable3;
                    } else {
                        if (i10 != 2) {
                            int i36 = i35;
                            i12 = i10;
                            solverVariable4 = solverVariableCreateObjectVariable4;
                            solverVariable5 = solverVariable3;
                            i13 = i32;
                            solverVariable6 = solverVariableCreateObjectVariable5;
                            i30 = i36;
                            i14 = i29;
                            z13 = true;
                            if (z11) {
                                solverVariable7 = solverVariable;
                                solverVariable8 = solverVariable2;
                                solverVariable9 = solverVariableCreateObjectVariable3;
                                i15 = 0;
                                i16 = 2;
                                i17 = 8;
                                c2 = 1;
                                i18 = i13;
                            } else {
                                if (!z8) {
                                    if ((zIsConnected || zIsConnected2 || zIsConnected3) && (!zIsConnected || zIsConnected2)) {
                                        if (!zIsConnected && zIsConnected2) {
                                            linearSystem.addEquality(solverVariable4, solverVariable5, -constraintAnchor2.getMargin(), 8);
                                            if (z2) {
                                                if (this.OPTIMIZE_WRAP && solverVariableCreateObjectVariable3.isFinalValue && (constraintWidget5 = this.mParent) != null) {
                                                    ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget5;
                                                    if (z) {
                                                        constraintWidgetContainer.addHorizontalWrapMinVariable(constraintAnchor);
                                                    } else {
                                                        constraintWidgetContainer.addVerticalWrapMinVariable(constraintAnchor);
                                                    }
                                                } else {
                                                    linearSystem.addGreaterThan(solverVariableCreateObjectVariable3, solverVariable, 0, 5);
                                                }
                                            }
                                        } else if (zIsConnected && zIsConnected2) {
                                            ConstraintWidget constraintWidget7 = constraintAnchor.mTarget.mOwner;
                                            constraintAnchor4 = constraintAnchor2;
                                            ConstraintWidget constraintWidget8 = constraintAnchor4.mTarget.mOwner;
                                            ConstraintWidget parent = getParent();
                                            int i37 = 6;
                                            if (z12) {
                                                if (i12 == 0) {
                                                    if (i30 != 0 || i14 != 0) {
                                                        z20 = true;
                                                        z21 = false;
                                                        z22 = true;
                                                        i27 = 5;
                                                        i28 = 5;
                                                    } else if (solverVariable6.isFinalValue && solverVariable5.isFinalValue) {
                                                        linearSystem.addEquality(solverVariableCreateObjectVariable3, solverVariable6, constraintAnchor.getMargin(), 8);
                                                        linearSystem.addEquality(solverVariable4, solverVariable5, -constraintAnchor2.getMargin(), 8);
                                                        return;
                                                    } else {
                                                        z20 = false;
                                                        z21 = true;
                                                        z22 = false;
                                                        i27 = 8;
                                                        i28 = 8;
                                                    }
                                                    if ((constraintWidget7 instanceof Barrier) || (constraintWidget8 instanceof Barrier)) {
                                                        z16 = z21;
                                                        z14 = z22;
                                                        i21 = i27;
                                                        i19 = 6;
                                                        i20 = 4;
                                                        z15 = z20;
                                                    } else {
                                                        z14 = z22;
                                                        i21 = i27;
                                                        i20 = i28;
                                                        i19 = 6;
                                                        z15 = z20;
                                                        z16 = z21;
                                                    }
                                                } else {
                                                    if (i12 == 1) {
                                                        solverVariable10 = solverVariable2;
                                                        z14 = true;
                                                        z15 = true;
                                                        i19 = 6;
                                                        z16 = false;
                                                        i20 = 4;
                                                    } else if (i12 != 3) {
                                                        solverVariable10 = solverVariable2;
                                                        z14 = false;
                                                        z15 = false;
                                                    } else if (this.mResolvedDimensionRatioSide == -1) {
                                                        if (z9) {
                                                            solverVariable10 = solverVariable2;
                                                            z14 = true;
                                                            z15 = true;
                                                            i19 = z2 ? 5 : 4;
                                                        } else {
                                                            solverVariable10 = solverVariable2;
                                                            z14 = true;
                                                            z15 = true;
                                                            i19 = 8;
                                                        }
                                                        z16 = true;
                                                        i20 = 5;
                                                    } else if (z6) {
                                                        if (i7 == 2 || i7 == 1) {
                                                            i25 = 5;
                                                            i26 = 4;
                                                        } else {
                                                            i25 = 8;
                                                            i26 = 5;
                                                        }
                                                        i21 = i25;
                                                        i20 = i26;
                                                        z14 = true;
                                                        z15 = true;
                                                        i19 = 6;
                                                        z16 = true;
                                                    } else {
                                                        if (i30 > 0) {
                                                            solverVariable10 = solverVariable2;
                                                            z14 = true;
                                                            z15 = true;
                                                            i19 = 6;
                                                            z16 = true;
                                                            i20 = 5;
                                                        } else if (i30 != 0 || i14 != 0) {
                                                            solverVariable10 = solverVariable2;
                                                            z14 = true;
                                                            z15 = true;
                                                            i19 = 6;
                                                            z16 = true;
                                                            i20 = 4;
                                                        } else if (z9) {
                                                            solverVariable10 = solverVariable2;
                                                            i21 = (constraintWidget7 == parent || constraintWidget8 == parent) ? 5 : 4;
                                                            z14 = true;
                                                            z15 = true;
                                                            i19 = 6;
                                                            z16 = true;
                                                            i20 = 4;
                                                            if (z14 && solverVariable6 == solverVariable5 && constraintWidget7 != parent) {
                                                                z14 = false;
                                                                z17 = false;
                                                            } else {
                                                                z17 = true;
                                                            }
                                                            if (z15) {
                                                                solverVariable12 = solverVariable6;
                                                                solverVariable13 = solverVariable5;
                                                                constraintWidget = parent;
                                                                constraintWidget2 = constraintWidget8;
                                                                solverVariable14 = solverVariableCreateObjectVariable3;
                                                                i22 = 8;
                                                                z18 = z2;
                                                            } else {
                                                                if (z12 || z7 || z9 || solverVariable6 != solverVariable || solverVariable5 != solverVariable10) {
                                                                    z18 = z2;
                                                                } else {
                                                                    z18 = false;
                                                                    i19 = 8;
                                                                    i21 = 8;
                                                                    z17 = false;
                                                                }
                                                                solverVariable12 = solverVariable6;
                                                                i22 = 8;
                                                                solverVariable13 = solverVariable5;
                                                                constraintWidget = parent;
                                                                constraintWidget2 = constraintWidget8;
                                                                solverVariable14 = solverVariableCreateObjectVariable3;
                                                                linearSystem.addCentering(solverVariableCreateObjectVariable3, solverVariable12, constraintAnchor.getMargin(), f2, solverVariable13, solverVariable4, constraintAnchor2.getMargin(), i19);
                                                            }
                                                            z19 = z17;
                                                            if (this.mVisibility != i22 && !constraintAnchor2.hasDependents()) {
                                                                return;
                                                            }
                                                            solverVariable5 = solverVariable13;
                                                            SolverVariable solverVariable17 = solverVariable12;
                                                            if (z14) {
                                                                constraintWidget3 = constraintWidget2;
                                                                solverVariable15 = solverVariable14;
                                                                i23 = i21;
                                                            } else {
                                                                if (!z18 || solverVariable17 == solverVariable5 || z12) {
                                                                    constraintWidget3 = constraintWidget2;
                                                                } else {
                                                                    if (constraintWidget7 instanceof Barrier) {
                                                                        constraintWidget3 = constraintWidget2;
                                                                    } else {
                                                                        constraintWidget3 = constraintWidget2;
                                                                        if (constraintWidget3 instanceof Barrier) {
                                                                        }
                                                                        solverVariable15 = solverVariable14;
                                                                        linearSystem.addGreaterThan(solverVariable15, solverVariable17, constraintAnchor.getMargin(), i23);
                                                                        linearSystem.addLowerThan(solverVariable4, solverVariable5, -constraintAnchor2.getMargin(), i23);
                                                                    }
                                                                    i23 = 6;
                                                                    solverVariable15 = solverVariable14;
                                                                    linearSystem.addGreaterThan(solverVariable15, solverVariable17, constraintAnchor.getMargin(), i23);
                                                                    linearSystem.addLowerThan(solverVariable4, solverVariable5, -constraintAnchor2.getMargin(), i23);
                                                                }
                                                                i23 = i21;
                                                                solverVariable15 = solverVariable14;
                                                                linearSystem.addGreaterThan(solverVariable15, solverVariable17, constraintAnchor.getMargin(), i23);
                                                                linearSystem.addLowerThan(solverVariable4, solverVariable5, -constraintAnchor2.getMargin(), i23);
                                                            }
                                                            if (z18 || !z10 || (constraintWidget7 instanceof Barrier) || (constraintWidget3 instanceof Barrier)) {
                                                                i24 = i23;
                                                                iMin2 = i20;
                                                            } else {
                                                                iMin2 = 6;
                                                                z19 = true;
                                                                i24 = 6;
                                                            }
                                                            if (z19) {
                                                                if (!z16 || (z9 && !z3)) {
                                                                    constraintWidget4 = constraintWidget;
                                                                } else {
                                                                    constraintWidget4 = constraintWidget;
                                                                    if (constraintWidget7 != constraintWidget4 && constraintWidget3 != constraintWidget4) {
                                                                        i37 = iMin2;
                                                                    }
                                                                    if ((constraintWidget7 instanceof Guideline) || (constraintWidget3 instanceof Guideline)) {
                                                                        i37 = 5;
                                                                    }
                                                                    if ((constraintWidget7 instanceof Barrier) || (constraintWidget3 instanceof Barrier)) {
                                                                        i37 = 5;
                                                                    }
                                                                    iMin2 = Math.max(z9 ? 5 : i37, iMin2);
                                                                }
                                                                if (z18) {
                                                                    iMin2 = Math.min(i24, iMin2);
                                                                    if (z6 && !z9 && (constraintWidget7 == constraintWidget4 || constraintWidget3 == constraintWidget4)) {
                                                                        iMin2 = 4;
                                                                    }
                                                                }
                                                                linearSystem.addEquality(solverVariable15, solverVariable17, constraintAnchor.getMargin(), iMin2);
                                                                linearSystem.addEquality(solverVariable4, solverVariable5, -constraintAnchor2.getMargin(), iMin2);
                                                            }
                                                            if (z18) {
                                                                int margin3 = solverVariable == solverVariable17 ? constraintAnchor.getMargin() : 0;
                                                                if (solverVariable17 != solverVariable) {
                                                                    linearSystem.addGreaterThan(solverVariable15, solverVariable, margin3, 5);
                                                                }
                                                            }
                                                            if (!z18 && z12) {
                                                                int i38 = i12;
                                                                if (i4 == 0 && i14 == 0) {
                                                                    if (z12 && i38 == 3) {
                                                                        linearSystem.addGreaterThan(solverVariable4, solverVariable15, 0, i22);
                                                                    } else {
                                                                        linearSystem.addGreaterThan(solverVariable4, solverVariable15, 0, 5);
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                            solverVariable10 = solverVariable2;
                                                            z14 = true;
                                                            z15 = true;
                                                            i19 = 6;
                                                            z16 = true;
                                                            i20 = 8;
                                                        }
                                                        i21 = 5;
                                                        if (z14) {
                                                            z17 = true;
                                                            if (z15) {
                                                            }
                                                            z19 = z17;
                                                            if (this.mVisibility != i22) {
                                                            }
                                                            solverVariable5 = solverVariable13;
                                                            SolverVariable solverVariable172 = solverVariable12;
                                                            if (z14) {
                                                            }
                                                            if (z18) {
                                                                i24 = i23;
                                                                iMin2 = i20;
                                                                if (z19) {
                                                                }
                                                                if (z18) {
                                                                }
                                                                if (!z18) {
                                                                }
                                                            }
                                                        }
                                                    }
                                                    i21 = 8;
                                                    if (z14) {
                                                    }
                                                }
                                                solverVariable10 = solverVariable2;
                                                if (z14) {
                                                }
                                            } else {
                                                if (solverVariable6.isFinalValue && solverVariable5.isFinalValue) {
                                                    linearSystem.addCentering(solverVariableCreateObjectVariable3, solverVariable6, constraintAnchor.getMargin(), f2, solverVariable5, solverVariable4, constraintAnchor2.getMargin(), 8);
                                                    if (z2 && z13) {
                                                        if (constraintAnchor4.mTarget != null) {
                                                            margin = constraintAnchor2.getMargin();
                                                            solverVariable11 = solverVariable2;
                                                        } else {
                                                            solverVariable11 = solverVariable2;
                                                            margin = 0;
                                                        }
                                                        if (solverVariable5 != solverVariable11) {
                                                            linearSystem.addGreaterThan(solverVariable11, solverVariable4, margin, 5);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    return;
                                                }
                                                solverVariable10 = solverVariable2;
                                                z14 = true;
                                                z15 = true;
                                            }
                                            i19 = 6;
                                            z16 = false;
                                            i20 = 4;
                                            i21 = 5;
                                            if (z14) {
                                            }
                                        }
                                        constraintAnchor4 = constraintAnchor2;
                                        z18 = z2;
                                    } else {
                                        constraintAnchor4 = constraintAnchor2;
                                        z18 = z2;
                                    }
                                    if (z18 && z13) {
                                        if (constraintAnchor4.mTarget != null) {
                                            margin2 = constraintAnchor2.getMargin();
                                            solverVariable16 = solverVariable2;
                                        } else {
                                            solverVariable16 = solverVariable2;
                                            margin2 = 0;
                                        }
                                        if (solverVariable5 != solverVariable16) {
                                            if (!this.OPTIMIZE_WRAP || !solverVariable4.isFinalValue || (constraintWidget6 = this.mParent) == null) {
                                                linearSystem.addGreaterThan(solverVariable16, solverVariable4, margin2, 5);
                                                return;
                                            }
                                            ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) constraintWidget6;
                                            if (z) {
                                                constraintWidgetContainer2.addHorizontalWrapMaxVariable(constraintAnchor4);
                                                return;
                                            } else {
                                                constraintWidgetContainer2.addVerticalWrapMaxVariable(constraintAnchor4);
                                                return;
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                solverVariable7 = solverVariable;
                                solverVariable8 = solverVariable2;
                                solverVariable9 = solverVariableCreateObjectVariable3;
                                i18 = i13;
                                i15 = 0;
                                i16 = 2;
                                i17 = 8;
                                c2 = 1;
                            }
                            if (i18 >= i16 && z2 && z13) {
                                linearSystem.addGreaterThan(solverVariable9, solverVariable7, i15, i17);
                                boolean z23 = z || this.mBaseline.mTarget == null;
                                if (!z && (constraintAnchor3 = this.mBaseline.mTarget) != null) {
                                    ConstraintWidget constraintWidget9 = constraintAnchor3.mOwner;
                                    if (constraintWidget9.mDimensionRatio != 0.0f) {
                                        DimensionBehaviour[] dimensionBehaviourArr = constraintWidget9.mListDimensionBehaviors;
                                        DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[i15];
                                        DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
                                        z23 = dimensionBehaviour2 == dimensionBehaviour3 && dimensionBehaviourArr[c2] == dimensionBehaviour3;
                                    }
                                }
                                if (z23) {
                                    linearSystem.addGreaterThan(solverVariable8, solverVariable4, i15, i17);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        if (constraintAnchor.getType() == ConstraintAnchor.Type.TOP || constraintAnchor.getType() == ConstraintAnchor.Type.BOTTOM) {
                            solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.TOP));
                            solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.BOTTOM));
                        } else {
                            solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.LEFT));
                            solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(this.mParent.getAnchor(ConstraintAnchor.Type.RIGHT));
                        }
                        int i39 = i35;
                        i12 = i10;
                        solverVariable5 = solverVariable3;
                        i13 = i32;
                        solverVariable6 = solverVariableCreateObjectVariable5;
                        solverVariable4 = solverVariableCreateObjectVariable4;
                        linearSystem.addConstraint(linearSystem.createRow().createRowDimensionRatio(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, solverVariableCreateObjectVariable2, solverVariableCreateObjectVariable, f3));
                        i30 = i39;
                        i14 = i29;
                        z12 = false;
                    }
                } else {
                    int iMax = Math.max(i29, iMin);
                    if (i30 > 0) {
                        iMax = Math.min(i30, iMax);
                    }
                    linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMax, 8);
                    z13 = z4;
                    i14 = i29;
                    i12 = i10;
                    solverVariable4 = solverVariableCreateObjectVariable4;
                    solverVariable5 = solverVariable3;
                    z12 = false;
                }
                i13 = i32;
                solverVariable6 = solverVariableCreateObjectVariable5;
                if (z11) {
                }
                if (i18 >= i16) {
                    return;
                } else {
                    return;
                }
            }
            if (z5) {
                linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, 0, 3);
                if (i4 > 0) {
                    linearSystem.addGreaterThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i4, 8);
                }
                if (i5 < Integer.MAX_VALUE) {
                    linearSystem.addLowerThan(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, i5, 8);
                }
            } else {
                linearSystem.addEquality(solverVariableCreateObjectVariable4, solverVariableCreateObjectVariable3, iMin, 8);
            }
            i14 = i29;
            i12 = i10;
            solverVariable6 = solverVariableCreateObjectVariable5;
            solverVariable4 = solverVariableCreateObjectVariable4;
            solverVariable5 = solverVariable3;
            i13 = i32;
            z13 = z4;
            if (z11) {
            }
            if (i18 >= i16) {
            }
        }
        if (this.mVisibility != 8) {
        }
        if (z11) {
        }
        if (!z12) {
        }
        z13 = z4;
        if (z11) {
        }
        if (i18 >= i16) {
        }
    }

    private boolean isChainHead(int i2) {
        int i3 = i2 * 2;
        ConstraintAnchor[] constraintAnchorArr = this.mListAnchors;
        if (constraintAnchorArr[i3].mTarget != null && constraintAnchorArr[i3].mTarget.mTarget != constraintAnchorArr[i3]) {
            int i4 = i3 + 1;
            if (constraintAnchorArr[i4].mTarget != null && constraintAnchorArr[i4].mTarget.mTarget == constraintAnchorArr[i4]) {
                return true;
            }
        }
        return false;
    }

    public void addChildrenToSolverByDependency(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet<ConstraintWidget> hashSet, int i2, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            Optimizer.checkMatchParent(constraintWidgetContainer, linearSystem, this);
            hashSet.remove(this);
            addToSolver(linearSystem, constraintWidgetContainer.optimizeFor(64));
        }
        if (i2 == 0) {
            HashSet<ConstraintAnchor> dependents = this.mLeft.getDependents();
            if (dependents != null) {
                Iterator<ConstraintAnchor> it = dependents.iterator();
                while (it.hasNext()) {
                    it.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i2, true);
                }
            }
            HashSet<ConstraintAnchor> dependents2 = this.mRight.getDependents();
            if (dependents2 != null) {
                Iterator<ConstraintAnchor> it2 = dependents2.iterator();
                while (it2.hasNext()) {
                    it2.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i2, true);
                }
                return;
            }
            return;
        }
        HashSet<ConstraintAnchor> dependents3 = this.mTop.getDependents();
        if (dependents3 != null) {
            Iterator<ConstraintAnchor> it3 = dependents3.iterator();
            while (it3.hasNext()) {
                it3.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i2, true);
            }
        }
        HashSet<ConstraintAnchor> dependents4 = this.mBottom.getDependents();
        if (dependents4 != null) {
            Iterator<ConstraintAnchor> it4 = dependents4.iterator();
            while (it4.hasNext()) {
                it4.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i2, true);
            }
        }
        HashSet<ConstraintAnchor> dependents5 = this.mBaseline.getDependents();
        if (dependents5 != null) {
            Iterator<ConstraintAnchor> it5 = dependents5.iterator();
            while (it5.hasNext()) {
                it5.next().mOwner.addChildrenToSolverByDependency(constraintWidgetContainer, linearSystem, hashSet, i2, true);
            }
        }
    }

    boolean addFirst() {
        return (this instanceof VirtualLayout) || (this instanceof Guideline);
    }

    /* JADX WARN: Removed duplicated region for block: B:512:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:518:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:520:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:555:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:557:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:574:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:578:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:580:0x04b6  */
    /* JADX WARN: Removed duplicated region for block: B:615:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:616:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:618:0x058a  */
    /* JADX WARN: Removed duplicated region for block: B:620:0x0590  */
    /* JADX WARN: Removed duplicated region for block: B:624:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:627:0x05c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        boolean z2;
        boolean z3;
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        boolean z4;
        boolean z5;
        int i2;
        int i3;
        int i4;
        boolean z6;
        int i5;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        SolverVariable solverVariable5;
        int i6;
        int i7;
        char c2;
        ConstraintWidget constraintWidget3;
        LinearSystem linearSystem2;
        SolverVariable solverVariable6;
        SolverVariable solverVariable7;
        SolverVariable solverVariable8;
        boolean z11;
        SolverVariable solverVariable9;
        SolverVariable solverVariable10;
        ConstraintWidget constraintWidget4;
        boolean z12;
        HorizontalWidgetRun horizontalWidgetRun;
        int i8;
        int i9;
        boolean zIsInHorizontalChain;
        boolean zIsInVerticalChain;
        HorizontalWidgetRun horizontalWidgetRun2;
        VerticalWidgetRun verticalWidgetRun;
        SolverVariable solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable solverVariableCreateObjectVariable3 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        SolverVariable solverVariableCreateObjectVariable5 = linearSystem.createObjectVariable(this.mBaseline);
        ConstraintWidget constraintWidget5 = this.mParent;
        if (constraintWidget5 != null) {
            boolean z13 = constraintWidget5 != null && constraintWidget5.mListDimensionBehaviors[0] == DimensionBehaviour.WRAP_CONTENT;
            ConstraintWidget constraintWidget6 = this.mParent;
            z3 = z13;
            z2 = constraintWidget6 != null && constraintWidget6.mListDimensionBehaviors[1] == DimensionBehaviour.WRAP_CONTENT;
        } else {
            z2 = false;
            z3 = false;
        }
        if (this.mVisibility == 8 && !hasDependencies()) {
            boolean[] zArr = this.mIsInBarrier;
            if (!zArr[0] && !zArr[1]) {
                return;
            }
        }
        if (this.resolvedHorizontal || this.resolvedVertical) {
            if (this.resolvedHorizontal) {
                linearSystem.addEquality(solverVariableCreateObjectVariable, this.mX);
                linearSystem.addEquality(solverVariableCreateObjectVariable2, this.mX + this.mWidth);
                if (z3 && (constraintWidget2 = this.mParent) != null) {
                    if (this.OPTIMIZE_WRAP_ON_RESOLVED) {
                        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget2;
                        constraintWidgetContainer.addVerticalWrapMinVariable(this.mLeft);
                        constraintWidgetContainer.addHorizontalWrapMaxVariable(this.mRight);
                    } else {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget2.mRight), solverVariableCreateObjectVariable2, 0, 5);
                    }
                }
            }
            if (this.resolvedVertical) {
                linearSystem.addEquality(solverVariableCreateObjectVariable3, this.mY);
                linearSystem.addEquality(solverVariableCreateObjectVariable4, this.mY + this.mHeight);
                if (this.mBaseline.hasDependents()) {
                    linearSystem.addEquality(solverVariableCreateObjectVariable5, this.mY + this.mBaselineDistance);
                }
                if (z2 && (constraintWidget = this.mParent) != null) {
                    if (this.OPTIMIZE_WRAP_ON_RESOLVED) {
                        ConstraintWidgetContainer constraintWidgetContainer2 = (ConstraintWidgetContainer) constraintWidget;
                        constraintWidgetContainer2.addVerticalWrapMinVariable(this.mTop);
                        constraintWidgetContainer2.addVerticalWrapMaxVariable(this.mBottom);
                    } else {
                        linearSystem.addGreaterThan(linearSystem.createObjectVariable(constraintWidget.mBottom), solverVariableCreateObjectVariable4, 0, 5);
                    }
                }
            }
            if (this.resolvedHorizontal && this.resolvedVertical) {
                this.resolvedHorizontal = false;
                this.resolvedVertical = false;
                return;
            }
        }
        Metrics metrics = LinearSystem.sMetrics;
        if (metrics != null) {
            metrics.widgets++;
        }
        if (z && (horizontalWidgetRun2 = this.horizontalRun) != null && (verticalWidgetRun = this.verticalRun) != null && horizontalWidgetRun2.start.resolved && horizontalWidgetRun2.end.resolved && verticalWidgetRun.start.resolved && verticalWidgetRun.end.resolved) {
            Metrics metrics2 = LinearSystem.sMetrics;
            if (metrics2 != null) {
                metrics2.graphSolved++;
            }
            linearSystem.addEquality(solverVariableCreateObjectVariable, this.horizontalRun.start.value);
            linearSystem.addEquality(solverVariableCreateObjectVariable2, this.horizontalRun.end.value);
            linearSystem.addEquality(solverVariableCreateObjectVariable3, this.verticalRun.start.value);
            linearSystem.addEquality(solverVariableCreateObjectVariable4, this.verticalRun.end.value);
            linearSystem.addEquality(solverVariableCreateObjectVariable5, this.verticalRun.baseline.value);
            if (this.mParent != null) {
                if (z3 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), solverVariableCreateObjectVariable2, 0, 8);
                }
                if (z2 && this.isTerminalWidget[1] && !isInVerticalChain()) {
                    linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), solverVariableCreateObjectVariable4, 0, 8);
                }
            }
            this.resolvedHorizontal = false;
            this.resolvedVertical = false;
            return;
        }
        Metrics metrics3 = LinearSystem.sMetrics;
        if (metrics3 != null) {
            metrics3.linearSolved++;
        }
        if (this.mParent != null) {
            if (isChainHead(0)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 0);
                zIsInHorizontalChain = true;
            } else {
                zIsInHorizontalChain = isInHorizontalChain();
            }
            if (isChainHead(1)) {
                ((ConstraintWidgetContainer) this.mParent).addChain(this, 1);
                zIsInVerticalChain = true;
            } else {
                zIsInVerticalChain = isInVerticalChain();
            }
            if (!zIsInHorizontalChain && z3 && this.mVisibility != 8 && this.mLeft.mTarget == null && this.mRight.mTarget == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), solverVariableCreateObjectVariable2, 0, 1);
            }
            if (!zIsInVerticalChain && z2 && this.mVisibility != 8 && this.mTop.mTarget == null && this.mBottom.mTarget == null && this.mBaseline == null) {
                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mBottom), solverVariableCreateObjectVariable4, 0, 1);
            }
            z4 = zIsInHorizontalChain;
            z5 = zIsInVerticalChain;
        } else {
            z4 = false;
            z5 = false;
        }
        int i10 = this.mWidth;
        int i11 = this.mMinWidth;
        if (i10 < i11) {
            i10 = i11;
        }
        int i12 = this.mHeight;
        int i13 = this.mMinHeight;
        if (i12 < i13) {
            i12 = i13;
        }
        boolean z14 = this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z15 = this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT;
        this.mResolvedDimensionRatioSide = this.mDimensionRatioSide;
        float f2 = this.mDimensionRatio;
        this.mResolvedDimensionRatio = f2;
        int i14 = this.mMatchConstraintDefaultWidth;
        int i15 = this.mMatchConstraintDefaultHeight;
        int i16 = i10;
        if (f2 <= 0.0f || this.mVisibility == 8) {
            i2 = i15;
            i3 = i14;
            i4 = i12;
            z6 = false;
        } else {
            int i17 = i12;
            if (this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && i14 == 0) {
                i14 = 3;
            }
            if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i15 == 0) {
                i15 = 3;
            }
            DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
            DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
            DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2) {
                i9 = 3;
                if (i14 == 3 && i15 == 3) {
                    setupDimensionRatio(z3, z2, z14, z15);
                }
                i2 = i15;
                i3 = i14;
                i4 = i17;
                z6 = true;
            } else {
                i9 = 3;
            }
            DimensionBehaviour[] dimensionBehaviourArr2 = this.mListDimensionBehaviors;
            DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr2[0];
            DimensionBehaviour dimensionBehaviour4 = DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour3 == dimensionBehaviour4 && i14 == i9) {
                this.mResolvedDimensionRatioSide = 0;
                i16 = (int) (this.mResolvedDimensionRatio * this.mHeight);
                i2 = i15;
                if (dimensionBehaviourArr2[1] != dimensionBehaviour4) {
                    i4 = i17;
                    z6 = false;
                    i3 = 4;
                }
                i3 = i14;
                i4 = i17;
                z6 = true;
            } else {
                if (this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && i15 == 3) {
                    this.mResolvedDimensionRatioSide = 1;
                    if (this.mDimensionRatioSide == -1) {
                        this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                    }
                    i4 = (int) (this.mResolvedDimensionRatio * this.mWidth);
                    if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
                        i3 = i14;
                        z6 = false;
                        i2 = 4;
                    } else {
                        i2 = i15;
                        i3 = i14;
                        z6 = true;
                    }
                }
                i2 = i15;
                i3 = i14;
                i4 = i17;
                z6 = true;
            }
        }
        int[] iArr = this.mResolvedMatchConstraintDefault;
        iArr[0] = i3;
        iArr[1] = i2;
        this.mResolvedHasRatio = z6;
        if (z6) {
            int i18 = this.mResolvedDimensionRatioSide;
            i5 = -1;
            boolean z16 = i18 == 0 || i18 == -1;
            boolean z17 = !z6 && ((i8 = this.mResolvedDimensionRatioSide) == 1 || i8 == i5);
            z7 = this.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT && (this instanceof ConstraintWidgetContainer);
            if (z7) {
                i16 = 0;
            }
            boolean z18 = !this.mCenter.isConnected();
            boolean[] zArr2 = this.mIsInBarrier;
            boolean z19 = zArr2[0];
            boolean z20 = zArr2[1];
            if (this.mHorizontalResolution != 2 || this.resolvedHorizontal) {
                z8 = z2;
                z9 = z3;
                z10 = z6;
                solverVariable = solverVariableCreateObjectVariable5;
                solverVariable2 = solverVariableCreateObjectVariable4;
                solverVariable3 = solverVariableCreateObjectVariable3;
                solverVariable4 = solverVariableCreateObjectVariable2;
                solverVariable5 = solverVariableCreateObjectVariable;
            } else {
                if (z && (horizontalWidgetRun = this.horizontalRun) != null) {
                    DependencyNode dependencyNode = horizontalWidgetRun.start;
                    if (dependencyNode.resolved && horizontalWidgetRun.end.resolved) {
                        if (z) {
                            linearSystem.addEquality(solverVariableCreateObjectVariable, dependencyNode.value);
                            linearSystem.addEquality(solverVariableCreateObjectVariable2, this.horizontalRun.end.value);
                            if (this.mParent != null && z3 && this.isTerminalWidget[0] && !isInHorizontalChain()) {
                                linearSystem.addGreaterThan(linearSystem.createObjectVariable(this.mParent.mRight), solverVariableCreateObjectVariable2, 0, 8);
                            }
                        }
                        z8 = z2;
                        z9 = z3;
                        z10 = z6;
                        solverVariable = solverVariableCreateObjectVariable5;
                        solverVariable2 = solverVariableCreateObjectVariable4;
                        solverVariable3 = solverVariableCreateObjectVariable3;
                        solverVariable4 = solverVariableCreateObjectVariable2;
                        solverVariable5 = solverVariableCreateObjectVariable;
                    }
                }
                ConstraintWidget constraintWidget7 = this.mParent;
                SolverVariable solverVariableCreateObjectVariable6 = constraintWidget7 != null ? linearSystem.createObjectVariable(constraintWidget7.mRight) : null;
                ConstraintWidget constraintWidget8 = this.mParent;
                SolverVariable solverVariableCreateObjectVariable7 = constraintWidget8 != null ? linearSystem.createObjectVariable(constraintWidget8.mLeft) : null;
                boolean z21 = this.isTerminalWidget[0];
                DimensionBehaviour[] dimensionBehaviourArr3 = this.mListDimensionBehaviors;
                z8 = z2;
                z9 = z3;
                z10 = z6;
                solverVariable = solverVariableCreateObjectVariable5;
                solverVariable2 = solverVariableCreateObjectVariable4;
                solverVariable3 = solverVariableCreateObjectVariable3;
                solverVariable4 = solverVariableCreateObjectVariable2;
                solverVariable5 = solverVariableCreateObjectVariable;
                applyConstraints(linearSystem, true, z3, z2, z21, solverVariableCreateObjectVariable7, solverVariableCreateObjectVariable6, dimensionBehaviourArr3[0], z7, this.mLeft, this.mRight, this.mX, i16, this.mMinWidth, this.mMaxDimension[0], this.mHorizontalBiasPercent, z16, dimensionBehaviourArr3[1] == DimensionBehaviour.MATCH_CONSTRAINT, z4, z5, z19, i3, i2, this.mMatchConstraintMinWidth, this.mMatchConstraintMaxWidth, this.mMatchConstraintPercentWidth, z18);
            }
            if (z) {
                i6 = 8;
                i7 = 0;
                c2 = 1;
                constraintWidget3 = this;
                linearSystem2 = linearSystem;
                solverVariable6 = solverVariable;
                solverVariable7 = solverVariable2;
                solverVariable8 = solverVariable3;
            } else {
                constraintWidget3 = this;
                VerticalWidgetRun verticalWidgetRun2 = constraintWidget3.verticalRun;
                if (verticalWidgetRun2 != null) {
                    DependencyNode dependencyNode2 = verticalWidgetRun2.start;
                    if (dependencyNode2.resolved && verticalWidgetRun2.end.resolved) {
                        linearSystem2 = linearSystem;
                        solverVariable8 = solverVariable3;
                        linearSystem2.addEquality(solverVariable8, dependencyNode2.value);
                        solverVariable7 = solverVariable2;
                        linearSystem2.addEquality(solverVariable7, constraintWidget3.verticalRun.end.value);
                        solverVariable6 = solverVariable;
                        linearSystem2.addEquality(solverVariable6, constraintWidget3.verticalRun.baseline.value);
                        ConstraintWidget constraintWidget9 = constraintWidget3.mParent;
                        if (constraintWidget9 == null || z5 || !z8) {
                            i6 = 8;
                            i7 = 0;
                            c2 = 1;
                        } else {
                            c2 = 1;
                            if (constraintWidget3.isTerminalWidget[1]) {
                                i6 = 8;
                                i7 = 0;
                                linearSystem2.addGreaterThan(linearSystem2.createObjectVariable(constraintWidget9.mBottom), solverVariable7, 0, 8);
                            } else {
                                i6 = 8;
                                i7 = 0;
                            }
                        }
                        z11 = false;
                        if (constraintWidget3.mVerticalResolution == 2) {
                            z11 = false;
                        }
                        if (!z11 || constraintWidget3.resolvedVertical) {
                            solverVariable9 = solverVariable7;
                            solverVariable10 = solverVariable8;
                        } else {
                            boolean z22 = constraintWidget3.mListDimensionBehaviors[c2] == DimensionBehaviour.WRAP_CONTENT && (constraintWidget3 instanceof ConstraintWidgetContainer);
                            if (z22) {
                                i4 = 0;
                            }
                            ConstraintWidget constraintWidget10 = constraintWidget3.mParent;
                            SolverVariable solverVariableCreateObjectVariable8 = constraintWidget10 != null ? linearSystem2.createObjectVariable(constraintWidget10.mBottom) : null;
                            ConstraintWidget constraintWidget11 = constraintWidget3.mParent;
                            SolverVariable solverVariableCreateObjectVariable9 = constraintWidget11 != null ? linearSystem2.createObjectVariable(constraintWidget11.mTop) : null;
                            if (constraintWidget3.mBaselineDistance <= 0 && constraintWidget3.mVisibility != i6) {
                                z12 = z18;
                                boolean z23 = constraintWidget3.isTerminalWidget[c2];
                                DimensionBehaviour[] dimensionBehaviourArr4 = constraintWidget3.mListDimensionBehaviors;
                                solverVariable9 = solverVariable7;
                                solverVariable10 = solverVariable8;
                                applyConstraints(linearSystem, false, z8, z9, z23, solverVariableCreateObjectVariable9, solverVariableCreateObjectVariable8, dimensionBehaviourArr4[c2], z22, constraintWidget3.mTop, constraintWidget3.mBottom, constraintWidget3.mY, i4, constraintWidget3.mMinHeight, constraintWidget3.mMaxDimension[c2], constraintWidget3.mVerticalBiasPercent, z17, dimensionBehaviourArr4[0] == DimensionBehaviour.MATCH_CONSTRAINT, z5, z4, z20, i2, i3, constraintWidget3.mMatchConstraintMinHeight, constraintWidget3.mMatchConstraintMaxHeight, constraintWidget3.mMatchConstraintPercentHeight, z12);
                            } else if (constraintWidget3.mBaseline.mTarget != null) {
                                linearSystem2.addEquality(solverVariable6, solverVariable8, getBaselineDistance(), i6);
                                linearSystem2.addEquality(solverVariable6, linearSystem2.createObjectVariable(constraintWidget3.mBaseline.mTarget), i7, i6);
                                if (z8) {
                                    linearSystem2.addGreaterThan(solverVariableCreateObjectVariable8, linearSystem2.createObjectVariable(constraintWidget3.mBottom), i7, 5);
                                }
                                z12 = false;
                                boolean z232 = constraintWidget3.isTerminalWidget[c2];
                                DimensionBehaviour[] dimensionBehaviourArr42 = constraintWidget3.mListDimensionBehaviors;
                                solverVariable9 = solverVariable7;
                                solverVariable10 = solverVariable8;
                                applyConstraints(linearSystem, false, z8, z9, z232, solverVariableCreateObjectVariable9, solverVariableCreateObjectVariable8, dimensionBehaviourArr42[c2], z22, constraintWidget3.mTop, constraintWidget3.mBottom, constraintWidget3.mY, i4, constraintWidget3.mMinHeight, constraintWidget3.mMaxDimension[c2], constraintWidget3.mVerticalBiasPercent, z17, dimensionBehaviourArr42[0] == DimensionBehaviour.MATCH_CONSTRAINT, z5, z4, z20, i2, i3, constraintWidget3.mMatchConstraintMinHeight, constraintWidget3.mMatchConstraintMaxHeight, constraintWidget3.mMatchConstraintPercentHeight, z12);
                            } else {
                                if (constraintWidget3.mVisibility == i6) {
                                    linearSystem2.addEquality(solverVariable6, solverVariable8, i7, i6);
                                } else {
                                    linearSystem2.addEquality(solverVariable6, solverVariable8, getBaselineDistance(), i6);
                                }
                                z12 = z18;
                                boolean z2322 = constraintWidget3.isTerminalWidget[c2];
                                DimensionBehaviour[] dimensionBehaviourArr422 = constraintWidget3.mListDimensionBehaviors;
                                solverVariable9 = solverVariable7;
                                solverVariable10 = solverVariable8;
                                applyConstraints(linearSystem, false, z8, z9, z2322, solverVariableCreateObjectVariable9, solverVariableCreateObjectVariable8, dimensionBehaviourArr422[c2], z22, constraintWidget3.mTop, constraintWidget3.mBottom, constraintWidget3.mY, i4, constraintWidget3.mMinHeight, constraintWidget3.mMaxDimension[c2], constraintWidget3.mVerticalBiasPercent, z17, dimensionBehaviourArr422[0] == DimensionBehaviour.MATCH_CONSTRAINT, z5, z4, z20, i2, i3, constraintWidget3.mMatchConstraintMinHeight, constraintWidget3.mMatchConstraintMaxHeight, constraintWidget3.mMatchConstraintPercentHeight, z12);
                            }
                        }
                        if (z10) {
                            constraintWidget4 = this;
                            if (constraintWidget4.mResolvedDimensionRatioSide == 1) {
                                linearSystem.addRatio(solverVariable9, solverVariable10, solverVariable4, solverVariable5, constraintWidget4.mResolvedDimensionRatio, 8);
                            } else {
                                linearSystem.addRatio(solverVariable4, solverVariable5, solverVariable9, solverVariable10, constraintWidget4.mResolvedDimensionRatio, 8);
                            }
                        } else {
                            constraintWidget4 = this;
                        }
                        if (constraintWidget4.mCenter.isConnected()) {
                            linearSystem.addCenterPoint(constraintWidget4, constraintWidget4.mCenter.getTarget().getOwner(), (float) Math.toRadians(constraintWidget4.mCircleConstraintAngle + 90.0f), constraintWidget4.mCenter.getMargin());
                        }
                        constraintWidget4.resolvedHorizontal = false;
                        constraintWidget4.resolvedVertical = false;
                    }
                }
                linearSystem2 = linearSystem;
                solverVariable6 = solverVariable;
                solverVariable7 = solverVariable2;
                solverVariable8 = solverVariable3;
                i6 = 8;
                i7 = 0;
                c2 = 1;
            }
            z11 = true;
            if (constraintWidget3.mVerticalResolution == 2) {
            }
            if (z11) {
                solverVariable9 = solverVariable7;
                solverVariable10 = solverVariable8;
            }
            if (z10) {
            }
            if (constraintWidget4.mCenter.isConnected()) {
            }
            constraintWidget4.resolvedHorizontal = false;
            constraintWidget4.resolvedVertical = false;
        }
        i5 = -1;
        if (z6) {
        }
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT) {
        }
        if (z7) {
        }
        boolean z182 = !this.mCenter.isConnected();
        boolean[] zArr22 = this.mIsInBarrier;
        boolean z192 = zArr22[0];
        boolean z202 = zArr22[1];
        if (this.mHorizontalResolution != 2) {
            z8 = z2;
            z9 = z3;
            z10 = z6;
            solverVariable = solverVariableCreateObjectVariable5;
            solverVariable2 = solverVariableCreateObjectVariable4;
            solverVariable3 = solverVariableCreateObjectVariable3;
            solverVariable4 = solverVariableCreateObjectVariable2;
            solverVariable5 = solverVariableCreateObjectVariable;
        }
        if (z) {
        }
        z11 = true;
        if (constraintWidget3.mVerticalResolution == 2) {
        }
        if (z11) {
        }
        if (z10) {
        }
        if (constraintWidget4.mCenter.isConnected()) {
        }
        constraintWidget4.resolvedHorizontal = false;
        constraintWidget4.resolvedVertical = false;
    }

    public boolean allowedInBarrier() {
        return this.mVisibility != 8;
    }

    public void connect(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2) {
        if (constraintAnchor.getOwner() == this) {
            connect(constraintAnchor.getType(), constraintAnchor2.getOwner(), constraintAnchor2.getType(), i2);
        }
    }

    public void connectCircularConstraint(ConstraintWidget constraintWidget, float f2, int i2) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.CENTER;
        immediateConnect(type, constraintWidget, type, i2, 0);
        this.mCircleConstraintAngle = f2;
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> map) {
        this.mHorizontalResolution = constraintWidget.mHorizontalResolution;
        this.mVerticalResolution = constraintWidget.mVerticalResolution;
        this.mMatchConstraintDefaultWidth = constraintWidget.mMatchConstraintDefaultWidth;
        this.mMatchConstraintDefaultHeight = constraintWidget.mMatchConstraintDefaultHeight;
        int[] iArr = this.mResolvedMatchConstraintDefault;
        int[] iArr2 = constraintWidget.mResolvedMatchConstraintDefault;
        iArr[0] = iArr2[0];
        iArr[1] = iArr2[1];
        this.mMatchConstraintMinWidth = constraintWidget.mMatchConstraintMinWidth;
        this.mMatchConstraintMaxWidth = constraintWidget.mMatchConstraintMaxWidth;
        this.mMatchConstraintMinHeight = constraintWidget.mMatchConstraintMinHeight;
        this.mMatchConstraintMaxHeight = constraintWidget.mMatchConstraintMaxHeight;
        this.mMatchConstraintPercentHeight = constraintWidget.mMatchConstraintPercentHeight;
        this.mIsWidthWrapContent = constraintWidget.mIsWidthWrapContent;
        this.mIsHeightWrapContent = constraintWidget.mIsHeightWrapContent;
        this.mResolvedDimensionRatioSide = constraintWidget.mResolvedDimensionRatioSide;
        this.mResolvedDimensionRatio = constraintWidget.mResolvedDimensionRatio;
        int[] iArr3 = constraintWidget.mMaxDimension;
        this.mMaxDimension = Arrays.copyOf(iArr3, iArr3.length);
        this.mCircleConstraintAngle = constraintWidget.mCircleConstraintAngle;
        this.hasBaseline = constraintWidget.hasBaseline;
        this.inPlaceholder = constraintWidget.inPlaceholder;
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mListDimensionBehaviors = (DimensionBehaviour[]) Arrays.copyOf(this.mListDimensionBehaviors, 2);
        this.mParent = this.mParent == null ? null : map.get(constraintWidget.mParent);
        this.mWidth = constraintWidget.mWidth;
        this.mHeight = constraintWidget.mHeight;
        this.mDimensionRatio = constraintWidget.mDimensionRatio;
        this.mDimensionRatioSide = constraintWidget.mDimensionRatioSide;
        this.mX = constraintWidget.mX;
        this.mY = constraintWidget.mY;
        this.mRelX = constraintWidget.mRelX;
        this.mRelY = constraintWidget.mRelY;
        this.mOffsetX = constraintWidget.mOffsetX;
        this.mOffsetY = constraintWidget.mOffsetY;
        this.mBaselineDistance = constraintWidget.mBaselineDistance;
        this.mMinWidth = constraintWidget.mMinWidth;
        this.mMinHeight = constraintWidget.mMinHeight;
        this.mHorizontalBiasPercent = constraintWidget.mHorizontalBiasPercent;
        this.mVerticalBiasPercent = constraintWidget.mVerticalBiasPercent;
        this.mCompanionWidget = constraintWidget.mCompanionWidget;
        this.mContainerItemSkip = constraintWidget.mContainerItemSkip;
        this.mVisibility = constraintWidget.mVisibility;
        this.mDebugName = constraintWidget.mDebugName;
        this.mType = constraintWidget.mType;
        this.mDistToTop = constraintWidget.mDistToTop;
        this.mDistToLeft = constraintWidget.mDistToLeft;
        this.mDistToRight = constraintWidget.mDistToRight;
        this.mDistToBottom = constraintWidget.mDistToBottom;
        this.mLeftHasCentered = constraintWidget.mLeftHasCentered;
        this.mRightHasCentered = constraintWidget.mRightHasCentered;
        this.mTopHasCentered = constraintWidget.mTopHasCentered;
        this.mBottomHasCentered = constraintWidget.mBottomHasCentered;
        this.mHorizontalWrapVisited = constraintWidget.mHorizontalWrapVisited;
        this.mVerticalWrapVisited = constraintWidget.mVerticalWrapVisited;
        this.mHorizontalChainStyle = constraintWidget.mHorizontalChainStyle;
        this.mVerticalChainStyle = constraintWidget.mVerticalChainStyle;
        this.mHorizontalChainFixedPosition = constraintWidget.mHorizontalChainFixedPosition;
        this.mVerticalChainFixedPosition = constraintWidget.mVerticalChainFixedPosition;
        float[] fArr = this.mWeight;
        float[] fArr2 = constraintWidget.mWeight;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        ConstraintWidget[] constraintWidgetArr = this.mListNextMatchConstraintsWidget;
        ConstraintWidget[] constraintWidgetArr2 = constraintWidget.mListNextMatchConstraintsWidget;
        constraintWidgetArr[0] = constraintWidgetArr2[0];
        constraintWidgetArr[1] = constraintWidgetArr2[1];
        ConstraintWidget[] constraintWidgetArr3 = this.mNextChainWidget;
        ConstraintWidget[] constraintWidgetArr4 = constraintWidget.mNextChainWidget;
        constraintWidgetArr3[0] = constraintWidgetArr4[0];
        constraintWidgetArr3[1] = constraintWidgetArr4[1];
        ConstraintWidget constraintWidget2 = constraintWidget.mHorizontalNextWidget;
        this.mHorizontalNextWidget = constraintWidget2 == null ? null : map.get(constraintWidget2);
        ConstraintWidget constraintWidget3 = constraintWidget.mVerticalNextWidget;
        this.mVerticalNextWidget = constraintWidget3 != null ? map.get(constraintWidget3) : null;
    }

    public void createObjectVariables(LinearSystem linearSystem) {
        linearSystem.createObjectVariable(this.mLeft);
        linearSystem.createObjectVariable(this.mTop);
        linearSystem.createObjectVariable(this.mRight);
        linearSystem.createObjectVariable(this.mBottom);
        if (this.mBaselineDistance > 0) {
            linearSystem.createObjectVariable(this.mBaseline);
        }
    }

    public void ensureMeasureRequested() {
        this.mMeasureRequested = true;
    }

    public void ensureWidgetRuns() {
        if (this.horizontalRun == null) {
            this.horizontalRun = new HorizontalWidgetRun(this);
        }
        if (this.verticalRun == null) {
            this.verticalRun = new VerticalWidgetRun(this);
        }
    }

    public ConstraintAnchor getAnchor(ConstraintAnchor.Type type) {
        switch (AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()]) {
            case 1:
                return this.mLeft;
            case 2:
                return this.mTop;
            case 3:
                return this.mRight;
            case 4:
                return this.mBottom;
            case 5:
                return this.mBaseline;
            case 6:
                return this.mCenter;
            case 7:
                return this.mCenterX;
            case 8:
                return this.mCenterY;
            case 9:
                return null;
            default:
                throw new AssertionError(type.name());
        }
    }

    public ArrayList<ConstraintAnchor> getAnchors() {
        return this.mAnchors;
    }

    public int getBaselineDistance() {
        return this.mBaselineDistance;
    }

    public float getBiasPercent(int i2) {
        if (i2 == 0) {
            return this.mHorizontalBiasPercent;
        }
        if (i2 == 1) {
            return this.mVerticalBiasPercent;
        }
        return -1.0f;
    }

    public int getBottom() {
        return getY() + this.mHeight;
    }

    public Object getCompanionWidget() {
        return this.mCompanionWidget;
    }

    public int getContainerItemSkip() {
        return this.mContainerItemSkip;
    }

    public String getDebugName() {
        return this.mDebugName;
    }

    public DimensionBehaviour getDimensionBehaviour(int i2) {
        if (i2 == 0) {
            return getHorizontalDimensionBehaviour();
        }
        if (i2 == 1) {
            return getVerticalDimensionBehaviour();
        }
        return null;
    }

    public float getDimensionRatio() {
        return this.mDimensionRatio;
    }

    public int getDimensionRatioSide() {
        return this.mDimensionRatioSide;
    }

    public boolean getHasBaseline() {
        return this.hasBaseline;
    }

    public int getHeight() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mHeight;
    }

    public float getHorizontalBiasPercent() {
        return this.mHorizontalBiasPercent;
    }

    public ConstraintWidget getHorizontalChainControlWidget() {
        if (!isInHorizontalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget;
            }
            ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.RIGHT).getTarget();
            if (target2 == null || target2.getOwner() == constraintWidget) {
                constraintWidget = owner;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public int getHorizontalChainStyle() {
        return this.mHorizontalChainStyle;
    }

    public DimensionBehaviour getHorizontalDimensionBehaviour() {
        return this.mListDimensionBehaviors[0];
    }

    public int getHorizontalMargin() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        int i2 = constraintAnchor != null ? 0 + constraintAnchor.mMargin : 0;
        ConstraintAnchor constraintAnchor2 = this.mRight;
        return constraintAnchor2 != null ? i2 + constraintAnchor2.mMargin : i2;
    }

    public int getLastHorizontalMeasureSpec() {
        return this.mLastHorizontalMeasureSpec;
    }

    public int getLastVerticalMeasureSpec() {
        return this.mLastVerticalMeasureSpec;
    }

    public int getLeft() {
        return getX();
    }

    public int getLength(int i2) {
        if (i2 == 0) {
            return getWidth();
        }
        if (i2 == 1) {
            return getHeight();
        }
        return 0;
    }

    public int getMaxHeight() {
        return this.mMaxDimension[1];
    }

    public int getMaxWidth() {
        return this.mMaxDimension[0];
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public ConstraintWidget getNextChainMember(int i2) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i2 != 0) {
            if (i2 == 1 && (constraintAnchor2 = (constraintAnchor = this.mBottom).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
                return constraintAnchor2.mOwner;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.mOwner;
    }

    public int getOptimizerWrapHeight() {
        int iMax;
        int i2 = this.mHeight;
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.mMatchConstraintDefaultHeight == 1) {
            iMax = Math.max(this.mMatchConstraintMinHeight, i2);
        } else {
            iMax = this.mMatchConstraintMinHeight;
            if (iMax > 0) {
                this.mHeight = iMax;
            } else {
                iMax = 0;
            }
        }
        int i3 = this.mMatchConstraintMaxHeight;
        return (i3 <= 0 || i3 >= iMax) ? iMax : i3;
    }

    public int getOptimizerWrapWidth() {
        int iMax;
        int i2 = this.mWidth;
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.MATCH_CONSTRAINT) {
            return i2;
        }
        if (this.mMatchConstraintDefaultWidth == 1) {
            iMax = Math.max(this.mMatchConstraintMinWidth, i2);
        } else {
            iMax = this.mMatchConstraintMinWidth;
            if (iMax > 0) {
                this.mWidth = iMax;
            } else {
                iMax = 0;
            }
        }
        int i3 = this.mMatchConstraintMaxWidth;
        return (i3 <= 0 || i3 >= iMax) ? iMax : i3;
    }

    public ConstraintWidget getParent() {
        return this.mParent;
    }

    public ConstraintWidget getPreviousChainMember(int i2) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i2 != 0) {
            if (i2 == 1 && (constraintAnchor2 = (constraintAnchor = this.mTop).mTarget) != null && constraintAnchor2.mTarget == constraintAnchor) {
                return constraintAnchor2.mOwner;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.mLeft;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        if (constraintAnchor4 == null || constraintAnchor4.mTarget != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.mOwner;
    }

    int getRelativePositioning(int i2) {
        if (i2 == 0) {
            return this.mRelX;
        }
        if (i2 == 1) {
            return this.mRelY;
        }
        return 0;
    }

    public int getRight() {
        return getX() + this.mWidth;
    }

    protected int getRootX() {
        return this.mX + this.mOffsetX;
    }

    protected int getRootY() {
        return this.mY + this.mOffsetY;
    }

    public WidgetRun getRun(int i2) {
        if (i2 == 0) {
            return this.horizontalRun;
        }
        if (i2 == 1) {
            return this.verticalRun;
        }
        return null;
    }

    public int getTop() {
        return getY();
    }

    public String getType() {
        return this.mType;
    }

    public float getVerticalBiasPercent() {
        return this.mVerticalBiasPercent;
    }

    public ConstraintWidget getVerticalChainControlWidget() {
        if (!isInVerticalChain()) {
            return null;
        }
        ConstraintWidget constraintWidget = this;
        ConstraintWidget constraintWidget2 = null;
        while (constraintWidget2 == null && constraintWidget != null) {
            ConstraintAnchor anchor = constraintWidget.getAnchor(ConstraintAnchor.Type.TOP);
            ConstraintAnchor target = anchor == null ? null : anchor.getTarget();
            ConstraintWidget owner = target == null ? null : target.getOwner();
            if (owner == getParent()) {
                return constraintWidget;
            }
            ConstraintAnchor target2 = owner == null ? null : owner.getAnchor(ConstraintAnchor.Type.BOTTOM).getTarget();
            if (target2 == null || target2.getOwner() == constraintWidget) {
                constraintWidget = owner;
            } else {
                constraintWidget2 = constraintWidget;
            }
        }
        return constraintWidget2;
    }

    public int getVerticalChainStyle() {
        return this.mVerticalChainStyle;
    }

    public DimensionBehaviour getVerticalDimensionBehaviour() {
        return this.mListDimensionBehaviors[1];
    }

    public int getVerticalMargin() {
        int i2 = this.mLeft != null ? 0 + this.mTop.mMargin : 0;
        return this.mRight != null ? i2 + this.mBottom.mMargin : i2;
    }

    public int getVisibility() {
        return this.mVisibility;
    }

    public int getWidth() {
        if (this.mVisibility == 8) {
            return 0;
        }
        return this.mWidth;
    }

    public int getX() {
        ConstraintWidget constraintWidget = this.mParent;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.mX : ((ConstraintWidgetContainer) constraintWidget).mPaddingLeft + this.mX;
    }

    public int getY() {
        ConstraintWidget constraintWidget = this.mParent;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.mY : ((ConstraintWidgetContainer) constraintWidget).mPaddingTop + this.mY;
    }

    public boolean hasBaseline() {
        return this.hasBaseline;
    }

    public boolean hasDanglingDimension(int i2) {
        if (i2 == 0) {
            return (this.mLeft.mTarget != null ? 1 : 0) + (this.mRight.mTarget != null ? 1 : 0) < 2;
        }
        return ((this.mTop.mTarget != null ? 1 : 0) + (this.mBottom.mTarget != null ? 1 : 0)) + (this.mBaseline.mTarget != null ? 1 : 0) < 2;
    }

    public boolean hasDependencies() {
        int size = this.mAnchors.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.mAnchors.get(i2).hasDependents()) {
                return true;
            }
        }
        return false;
    }

    public void immediateConnect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i2, int i3) {
        getAnchor(type).connect(constraintWidget.getAnchor(type2), i2, i3, true);
    }

    public boolean isHeightWrapContent() {
        return this.mIsHeightWrapContent;
    }

    public boolean isInHorizontalChain() {
        ConstraintAnchor constraintAnchor = this.mLeft;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mRight;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
    }

    public boolean isInPlaceholder() {
        return this.inPlaceholder;
    }

    public boolean isInVerticalChain() {
        ConstraintAnchor constraintAnchor = this.mTop;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        if (constraintAnchor2 != null && constraintAnchor2.mTarget == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.mBottom;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
        return constraintAnchor4 != null && constraintAnchor4.mTarget == constraintAnchor3;
    }

    public boolean isInVirtualLayout() {
        return this.mInVirtuaLayout;
    }

    public boolean isMeasureRequested() {
        return this.mMeasureRequested && this.mVisibility != 8;
    }

    public boolean isResolvedHorizontally() {
        return this.resolvedHorizontal || (this.mLeft.hasFinalValue() && this.mRight.hasFinalValue());
    }

    public boolean isResolvedVertically() {
        return this.resolvedVertical || (this.mTop.hasFinalValue() && this.mBottom.hasFinalValue());
    }

    public boolean isRoot() {
        return this.mParent == null;
    }

    public boolean isSpreadHeight() {
        return this.mMatchConstraintDefaultHeight == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinHeight == 0 && this.mMatchConstraintMaxHeight == 0 && this.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isSpreadWidth() {
        return this.mMatchConstraintDefaultWidth == 0 && this.mDimensionRatio == 0.0f && this.mMatchConstraintMinWidth == 0 && this.mMatchConstraintMaxWidth == 0 && this.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT;
    }

    public boolean isWidthWrapContent() {
        return this.mIsWidthWrapContent;
    }

    public boolean oppositeDimensionDependsOn(int i2) {
        char c2 = i2 == 0 ? (char) 1 : (char) 0;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[i2];
        DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[c2];
        DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour3 && dimensionBehaviour2 == dimensionBehaviour3;
    }

    public boolean oppositeDimensionsTied() {
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.MATCH_CONSTRAINT;
        return dimensionBehaviour == dimensionBehaviour2 && dimensionBehaviourArr[1] == dimensionBehaviour2;
    }

    public void reset() {
        this.mLeft.reset();
        this.mTop.reset();
        this.mRight.reset();
        this.mBottom.reset();
        this.mBaseline.reset();
        this.mCenterX.reset();
        this.mCenterY.reset();
        this.mCenter.reset();
        this.mParent = null;
        this.mCircleConstraintAngle = 0.0f;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        float f2 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f2;
        this.mVerticalBiasPercent = f2;
        DimensionBehaviour[] dimensionBehaviourArr = this.mListDimensionBehaviors;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.mCompanionWidget = null;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mType = null;
        this.mHorizontalWrapVisited = false;
        this.mVerticalWrapVisited = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mHorizontalChainFixedPosition = false;
        this.mVerticalChainFixedPosition = false;
        float[] fArr = this.mWeight;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        int[] iArr = this.mMaxDimension;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mMatchConstraintMaxWidth = Integer.MAX_VALUE;
        this.mMatchConstraintMaxHeight = Integer.MAX_VALUE;
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMinHeight = 0;
        this.mResolvedHasRatio = false;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mGroupsToSolver = false;
        boolean[] zArr = this.isTerminalWidget;
        zArr[0] = true;
        zArr[1] = true;
        this.mInVirtuaLayout = false;
        boolean[] zArr2 = this.mIsInBarrier;
        zArr2[0] = false;
        zArr2[1] = false;
        this.mMeasureRequested = true;
    }

    public void resetAllConstraints() {
        resetAnchors();
        setVerticalBiasPercent(DEFAULT_BIAS);
        setHorizontalBiasPercent(DEFAULT_BIAS);
    }

    public void resetAnchor(ConstraintAnchor constraintAnchor) {
        if (getParent() != null && (getParent() instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
        ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
        ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
        ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.CENTER);
        ConstraintAnchor anchor6 = getAnchor(ConstraintAnchor.Type.CENTER_X);
        ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
        if (constraintAnchor == anchor5) {
            if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                anchor.reset();
                anchor2.reset();
            }
            if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
                anchor3.reset();
                anchor4.reset();
            }
            this.mHorizontalBiasPercent = 0.5f;
            this.mVerticalBiasPercent = 0.5f;
        } else if (constraintAnchor == anchor6) {
            if (anchor.isConnected() && anchor2.isConnected() && anchor.getTarget().getOwner() == anchor2.getTarget().getOwner()) {
                anchor.reset();
                anchor2.reset();
            }
            this.mHorizontalBiasPercent = 0.5f;
        } else if (constraintAnchor == anchor7) {
            if (anchor3.isConnected() && anchor4.isConnected() && anchor3.getTarget().getOwner() == anchor4.getTarget().getOwner()) {
                anchor3.reset();
                anchor4.reset();
            }
            this.mVerticalBiasPercent = 0.5f;
        } else if (constraintAnchor == anchor || constraintAnchor == anchor2) {
            if (anchor.isConnected() && anchor.getTarget() == anchor2.getTarget()) {
                anchor5.reset();
            }
        } else if ((constraintAnchor == anchor3 || constraintAnchor == anchor4) && anchor3.isConnected() && anchor3.getTarget() == anchor4.getTarget()) {
            anchor5.reset();
        }
        constraintAnchor.reset();
    }

    public void resetAnchors() {
        ConstraintWidget parent = getParent();
        if (parent != null && (parent instanceof ConstraintWidgetContainer) && ((ConstraintWidgetContainer) getParent()).handlesInternalConstraints()) {
            return;
        }
        int size = this.mAnchors.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mAnchors.get(i2).reset();
        }
    }

    public void resetFinalResolution() {
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        int size = this.mAnchors.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.mAnchors.get(i2).resetFinalResolution();
        }
    }

    public void resetSolverVariables(Cache cache) {
        this.mLeft.resetSolverVariable(cache);
        this.mTop.resetSolverVariable(cache);
        this.mRight.resetSolverVariable(cache);
        this.mBottom.resetSolverVariable(cache);
        this.mBaseline.resetSolverVariable(cache);
        this.mCenter.resetSolverVariable(cache);
        this.mCenterX.resetSolverVariable(cache);
        this.mCenterY.resetSolverVariable(cache);
    }

    public void setBaselineDistance(int i2) {
        this.mBaselineDistance = i2;
        this.hasBaseline = i2 > 0;
    }

    public void setCompanionWidget(Object obj) {
        this.mCompanionWidget = obj;
    }

    public void setContainerItemSkip(int i2) {
        if (i2 >= 0) {
            this.mContainerItemSkip = i2;
        } else {
            this.mContainerItemSkip = 0;
        }
    }

    public void setDebugName(String str) {
        this.mDebugName = str;
    }

    public void setDebugSolverName(LinearSystem linearSystem, String str) {
        this.mDebugName = str;
        SolverVariable solverVariableCreateObjectVariable = linearSystem.createObjectVariable(this.mLeft);
        SolverVariable solverVariableCreateObjectVariable2 = linearSystem.createObjectVariable(this.mTop);
        SolverVariable solverVariableCreateObjectVariable3 = linearSystem.createObjectVariable(this.mRight);
        SolverVariable solverVariableCreateObjectVariable4 = linearSystem.createObjectVariable(this.mBottom);
        solverVariableCreateObjectVariable.setName(str + ".left");
        solverVariableCreateObjectVariable2.setName(str + ".top");
        solverVariableCreateObjectVariable3.setName(str + ".right");
        solverVariableCreateObjectVariable4.setName(str + ".bottom");
        linearSystem.createObjectVariable(this.mBaseline).setName(str + ".baseline");
    }

    public void setDimension(int i2, int i3) {
        this.mWidth = i2;
        int i4 = this.mWidth;
        int i5 = this.mMinWidth;
        if (i4 < i5) {
            this.mWidth = i5;
        }
        this.mHeight = i3;
        int i6 = this.mHeight;
        int i7 = this.mMinHeight;
        if (i6 < i7) {
            this.mHeight = i7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x0084 A[PHI: r0
  0x0084: PHI (r0v2 int) = (r0v1 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int), (r0v0 int) binds: [B:94:0x0084, B:84:0x007d, B:72:0x004f, B:74:0x0055, B:76:0x0061, B:78:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x0084 -> B:88:0x0085). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setDimensionRatio(String str) {
        float fAbs;
        int i2 = 0;
        if (str == null || str.length() == 0) {
            this.mDimensionRatio = 0.0f;
            return;
        }
        int i3 = -1;
        int length = str.length();
        int iIndexOf = str.indexOf(44);
        int i4 = 0;
        if (iIndexOf > 0 && iIndexOf < length - 1) {
            String strSubstring = str.substring(0, iIndexOf);
            if (strSubstring.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST)) {
                i3 = 0;
            } else if (strSubstring.equalsIgnoreCase("H")) {
                i3 = 1;
            }
            i4 = iIndexOf + 1;
        }
        int iIndexOf2 = str.indexOf(58);
        if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
            String strSubstring2 = str.substring(i4);
            fAbs = strSubstring2.length() > 0 ? Float.parseFloat(strSubstring2) : 0.0f;
        } else {
            String strSubstring3 = str.substring(i4, iIndexOf2);
            String strSubstring4 = str.substring(iIndexOf2 + 1);
            if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                float f2 = Float.parseFloat(strSubstring3);
                float f3 = Float.parseFloat(strSubstring4);
                if (f2 > 0.0f && f3 > 0.0f) {
                    fAbs = i3 == 1 ? Math.abs(f3 / f2) : Math.abs(f2 / f3);
                }
            }
        }
        i2 = (fAbs > i2 ? 1 : (fAbs == i2 ? 0 : -1));
        if (i2 > 0) {
            this.mDimensionRatio = fAbs;
            this.mDimensionRatioSide = i3;
        }
    }

    public void setFinalBaseline(int i2) {
        if (this.hasBaseline) {
            int i3 = i2 - this.mBaselineDistance;
            int i4 = this.mHeight + i3;
            this.mY = i3;
            this.mTop.setFinalValue(i3);
            this.mBottom.setFinalValue(i4);
            this.mBaseline.setFinalValue(i2);
            this.resolvedVertical = true;
        }
    }

    public void setFinalFrame(int i2, int i3, int i4, int i5, int i6, int i7) {
        setFrame(i2, i3, i4, i5);
        setBaselineDistance(i6);
        if (i7 == 0) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = false;
        } else if (i7 == 1) {
            this.resolvedHorizontal = false;
            this.resolvedVertical = true;
        } else if (i7 == 2) {
            this.resolvedHorizontal = true;
            this.resolvedVertical = true;
        } else {
            this.resolvedHorizontal = false;
            this.resolvedVertical = false;
        }
    }

    public void setFinalHorizontal(int i2, int i3) {
        this.mLeft.setFinalValue(i2);
        this.mRight.setFinalValue(i3);
        this.mX = i2;
        this.mWidth = i3 - i2;
        this.resolvedHorizontal = true;
    }

    public void setFinalLeft(int i2) {
        this.mLeft.setFinalValue(i2);
        this.mX = i2;
    }

    public void setFinalTop(int i2) {
        this.mTop.setFinalValue(i2);
        this.mY = i2;
    }

    public void setFinalVertical(int i2, int i3) {
        this.mTop.setFinalValue(i2);
        this.mBottom.setFinalValue(i3);
        this.mY = i2;
        this.mHeight = i3 - i2;
        if (this.hasBaseline) {
            this.mBaseline.setFinalValue(i2 + this.mBaselineDistance);
        }
        this.resolvedVertical = true;
    }

    public void setFrame(int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8 = i4 - i2;
        int i9 = i5 - i3;
        this.mX = i2;
        this.mY = i3;
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (this.mListDimensionBehaviors[0] != DimensionBehaviour.FIXED || i8 >= (i6 = this.mWidth)) {
            i6 = i8;
        }
        if (this.mListDimensionBehaviors[1] != DimensionBehaviour.FIXED || i9 >= (i7 = this.mHeight)) {
            i7 = i9;
        }
        this.mWidth = i6;
        this.mHeight = i7;
        int i10 = this.mHeight;
        int i11 = this.mMinHeight;
        if (i10 < i11) {
            this.mHeight = i11;
        }
        int i12 = this.mWidth;
        int i13 = this.mMinWidth;
        if (i12 < i13) {
            this.mWidth = i13;
        }
    }

    public void setGoneMargin(ConstraintAnchor.Type type, int i2) {
        int i3 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[type.ordinal()];
        if (i3 == 1) {
            this.mLeft.mGoneMargin = i2;
            return;
        }
        if (i3 == 2) {
            this.mTop.mGoneMargin = i2;
        } else if (i3 == 3) {
            this.mRight.mGoneMargin = i2;
        } else {
            if (i3 != 4) {
                return;
            }
            this.mBottom.mGoneMargin = i2;
        }
    }

    public void setHasBaseline(boolean z) {
        this.hasBaseline = z;
    }

    public void setHeight(int i2) {
        this.mHeight = i2;
        int i3 = this.mHeight;
        int i4 = this.mMinHeight;
        if (i3 < i4) {
            this.mHeight = i4;
        }
    }

    public void setHeightWrapContent(boolean z) {
        this.mIsHeightWrapContent = z;
    }

    public void setHorizontalBiasPercent(float f2) {
        this.mHorizontalBiasPercent = f2;
    }

    public void setHorizontalChainStyle(int i2) {
        this.mHorizontalChainStyle = i2;
    }

    public void setHorizontalDimension(int i2, int i3) {
        this.mX = i2;
        this.mWidth = i3 - i2;
        int i4 = this.mWidth;
        int i5 = this.mMinWidth;
        if (i4 < i5) {
            this.mWidth = i5;
        }
    }

    public void setHorizontalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[0] = dimensionBehaviour;
    }

    public void setHorizontalMatchStyle(int i2, int i3, int i4, float f2) {
        this.mMatchConstraintDefaultWidth = i2;
        this.mMatchConstraintMinWidth = i3;
        if (i4 == Integer.MAX_VALUE) {
            i4 = 0;
        }
        this.mMatchConstraintMaxWidth = i4;
        this.mMatchConstraintPercentWidth = f2;
        if (f2 <= 0.0f || f2 >= 1.0f || this.mMatchConstraintDefaultWidth != 0) {
            return;
        }
        this.mMatchConstraintDefaultWidth = 2;
    }

    public void setHorizontalWeight(float f2) {
        this.mWeight[0] = f2;
    }

    protected void setInBarrier(int i2, boolean z) {
        this.mIsInBarrier[i2] = z;
    }

    public void setInPlaceholder(boolean z) {
        this.inPlaceholder = z;
    }

    public void setInVirtualLayout(boolean z) {
        this.mInVirtuaLayout = z;
    }

    public void setLastMeasureSpec(int i2, int i3) {
        this.mLastHorizontalMeasureSpec = i2;
        this.mLastVerticalMeasureSpec = i3;
        setMeasureRequested(false);
    }

    public void setLength(int i2, int i3) {
        if (i3 == 0) {
            setWidth(i2);
        } else if (i3 == 1) {
            setHeight(i2);
        }
    }

    public void setMaxHeight(int i2) {
        this.mMaxDimension[1] = i2;
    }

    public void setMaxWidth(int i2) {
        this.mMaxDimension[0] = i2;
    }

    public void setMeasureRequested(boolean z) {
        this.mMeasureRequested = z;
    }

    public void setMinHeight(int i2) {
        if (i2 < 0) {
            this.mMinHeight = 0;
        } else {
            this.mMinHeight = i2;
        }
    }

    public void setMinWidth(int i2) {
        if (i2 < 0) {
            this.mMinWidth = 0;
        } else {
            this.mMinWidth = i2;
        }
    }

    public void setOffset(int i2, int i3) {
        this.mOffsetX = i2;
        this.mOffsetY = i3;
    }

    public void setOrigin(int i2, int i3) {
        this.mX = i2;
        this.mY = i3;
    }

    public void setParent(ConstraintWidget constraintWidget) {
        this.mParent = constraintWidget;
    }

    void setRelativePositioning(int i2, int i3) {
        if (i3 == 0) {
            this.mRelX = i2;
        } else if (i3 == 1) {
            this.mRelY = i2;
        }
    }

    public void setType(String str) {
        this.mType = str;
    }

    public void setVerticalBiasPercent(float f2) {
        this.mVerticalBiasPercent = f2;
    }

    public void setVerticalChainStyle(int i2) {
        this.mVerticalChainStyle = i2;
    }

    public void setVerticalDimension(int i2, int i3) {
        this.mY = i2;
        this.mHeight = i3 - i2;
        int i4 = this.mHeight;
        int i5 = this.mMinHeight;
        if (i4 < i5) {
            this.mHeight = i5;
        }
    }

    public void setVerticalDimensionBehaviour(DimensionBehaviour dimensionBehaviour) {
        this.mListDimensionBehaviors[1] = dimensionBehaviour;
    }

    public void setVerticalMatchStyle(int i2, int i3, int i4, float f2) {
        this.mMatchConstraintDefaultHeight = i2;
        this.mMatchConstraintMinHeight = i3;
        if (i4 == Integer.MAX_VALUE) {
            i4 = 0;
        }
        this.mMatchConstraintMaxHeight = i4;
        this.mMatchConstraintPercentHeight = f2;
        if (f2 <= 0.0f || f2 >= 1.0f || this.mMatchConstraintDefaultHeight != 0) {
            return;
        }
        this.mMatchConstraintDefaultHeight = 2;
    }

    public void setVerticalWeight(float f2) {
        this.mWeight[1] = f2;
    }

    public void setVisibility(int i2) {
        this.mVisibility = i2;
    }

    public void setWidth(int i2) {
        this.mWidth = i2;
        int i3 = this.mWidth;
        int i4 = this.mMinWidth;
        if (i3 < i4) {
            this.mWidth = i4;
        }
    }

    public void setWidthWrapContent(boolean z) {
        this.mIsWidthWrapContent = z;
    }

    public void setX(int i2) {
        this.mX = i2;
    }

    public void setY(int i2) {
        this.mY = i2;
    }

    public void setupDimensionRatio(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.mResolvedDimensionRatioSide == -1) {
            if (z3 && !z4) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (!z3 && z4) {
                this.mResolvedDimensionRatioSide = 1;
                if (this.mDimensionRatioSide == -1) {
                    this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                }
            }
        }
        if (this.mResolvedDimensionRatioSide == 0 && (!this.mTop.isConnected() || !this.mBottom.isConnected())) {
            this.mResolvedDimensionRatioSide = 1;
        } else if (this.mResolvedDimensionRatioSide == 1 && (!this.mLeft.isConnected() || !this.mRight.isConnected())) {
            this.mResolvedDimensionRatioSide = 0;
        }
        if (this.mResolvedDimensionRatioSide == -1 && (!this.mTop.isConnected() || !this.mBottom.isConnected() || !this.mLeft.isConnected() || !this.mRight.isConnected())) {
            if (this.mTop.isConnected() && this.mBottom.isConnected()) {
                this.mResolvedDimensionRatioSide = 0;
            } else if (this.mLeft.isConnected() && this.mRight.isConnected()) {
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
        if (this.mResolvedDimensionRatioSide == -1) {
            if (this.mMatchConstraintMinWidth > 0 && this.mMatchConstraintMinHeight == 0) {
                this.mResolvedDimensionRatioSide = 0;
            } else {
                if (this.mMatchConstraintMinWidth != 0 || this.mMatchConstraintMinHeight <= 0) {
                    return;
                }
                this.mResolvedDimensionRatio = 1.0f / this.mResolvedDimensionRatio;
                this.mResolvedDimensionRatioSide = 1;
            }
        }
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (this.mType != null) {
            str = "type: " + this.mType + a.f10074g;
        } else {
            str = "";
        }
        sb.append(str);
        if (this.mDebugName != null) {
            str2 = "id: " + this.mDebugName + a.f10074g;
        }
        sb.append(str2);
        sb.append("(");
        sb.append(this.mX);
        sb.append(", ");
        sb.append(this.mY);
        sb.append(") - (");
        sb.append(this.mWidth);
        sb.append(" x ");
        sb.append(this.mHeight);
        sb.append(")");
        return sb.toString();
    }

    public void updateFromRuns(boolean z, boolean z2) {
        int i2;
        int i3;
        boolean zIsResolved = z & this.horizontalRun.isResolved();
        boolean zIsResolved2 = z2 & this.verticalRun.isResolved();
        HorizontalWidgetRun horizontalWidgetRun = this.horizontalRun;
        int i4 = horizontalWidgetRun.start.value;
        VerticalWidgetRun verticalWidgetRun = this.verticalRun;
        int i5 = verticalWidgetRun.start.value;
        int i6 = horizontalWidgetRun.end.value;
        int i7 = verticalWidgetRun.end.value;
        int i8 = i7 - i5;
        if (i6 - i4 < 0 || i8 < 0 || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE) {
            i6 = 0;
            i4 = 0;
            i7 = 0;
            i5 = 0;
        }
        int i9 = i6 - i4;
        int i10 = i7 - i5;
        if (zIsResolved) {
            this.mX = i4;
        }
        if (zIsResolved2) {
            this.mY = i5;
        }
        if (this.mVisibility == 8) {
            this.mWidth = 0;
            this.mHeight = 0;
            return;
        }
        if (zIsResolved) {
            if (this.mListDimensionBehaviors[0] != DimensionBehaviour.FIXED || i9 >= (i3 = this.mWidth)) {
                i3 = i9;
            }
            this.mWidth = i3;
            int i11 = this.mWidth;
            int i12 = this.mMinWidth;
            if (i11 < i12) {
                this.mWidth = i12;
            }
        }
        if (zIsResolved2) {
            if (this.mListDimensionBehaviors[1] != DimensionBehaviour.FIXED || i10 >= (i2 = this.mHeight)) {
                i2 = i10;
            }
            this.mHeight = i2;
            int i13 = this.mHeight;
            int i14 = this.mMinHeight;
            if (i13 < i14) {
                this.mHeight = i14;
            }
        }
    }

    public void updateFromSolver(LinearSystem linearSystem, boolean z) {
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        int objectVariableValue = linearSystem.getObjectVariableValue(this.mLeft);
        int objectVariableValue2 = linearSystem.getObjectVariableValue(this.mTop);
        int objectVariableValue3 = linearSystem.getObjectVariableValue(this.mRight);
        int objectVariableValue4 = linearSystem.getObjectVariableValue(this.mBottom);
        if (z && (horizontalWidgetRun = this.horizontalRun) != null) {
            DependencyNode dependencyNode = horizontalWidgetRun.start;
            if (dependencyNode.resolved) {
                DependencyNode dependencyNode2 = horizontalWidgetRun.end;
                if (dependencyNode2.resolved) {
                    objectVariableValue = dependencyNode.value;
                    objectVariableValue3 = dependencyNode2.value;
                }
            }
        }
        if (z && (verticalWidgetRun = this.verticalRun) != null) {
            DependencyNode dependencyNode3 = verticalWidgetRun.start;
            if (dependencyNode3.resolved) {
                DependencyNode dependencyNode4 = verticalWidgetRun.end;
                if (dependencyNode4.resolved) {
                    objectVariableValue2 = dependencyNode3.value;
                    objectVariableValue4 = dependencyNode4.value;
                }
            }
        }
        int i2 = objectVariableValue4 - objectVariableValue2;
        if (objectVariableValue3 - objectVariableValue < 0 || i2 < 0 || objectVariableValue == Integer.MIN_VALUE || objectVariableValue == Integer.MAX_VALUE || objectVariableValue2 == Integer.MIN_VALUE || objectVariableValue2 == Integer.MAX_VALUE || objectVariableValue3 == Integer.MIN_VALUE || objectVariableValue3 == Integer.MAX_VALUE || objectVariableValue4 == Integer.MIN_VALUE || objectVariableValue4 == Integer.MAX_VALUE) {
            objectVariableValue4 = 0;
            objectVariableValue = 0;
            objectVariableValue2 = 0;
            objectVariableValue3 = 0;
        }
        setFrame(objectVariableValue, objectVariableValue2, objectVariableValue3, objectVariableValue4);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2) {
        connect(type, constraintWidget, type2, 0);
    }

    public void connect(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i2) {
        boolean z;
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.CENTER;
        if (type == type3) {
            if (type2 == type3) {
                ConstraintAnchor anchor = getAnchor(ConstraintAnchor.Type.LEFT);
                ConstraintAnchor anchor2 = getAnchor(ConstraintAnchor.Type.RIGHT);
                ConstraintAnchor anchor3 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor anchor4 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                boolean z2 = true;
                if ((anchor == null || !anchor.isConnected()) && (anchor2 == null || !anchor2.isConnected())) {
                    ConstraintAnchor.Type type4 = ConstraintAnchor.Type.LEFT;
                    connect(type4, constraintWidget, type4, 0);
                    ConstraintAnchor.Type type5 = ConstraintAnchor.Type.RIGHT;
                    connect(type5, constraintWidget, type5, 0);
                    z = true;
                } else {
                    z = false;
                }
                if ((anchor3 == null || !anchor3.isConnected()) && (anchor4 == null || !anchor4.isConnected())) {
                    ConstraintAnchor.Type type6 = ConstraintAnchor.Type.TOP;
                    connect(type6, constraintWidget, type6, 0);
                    ConstraintAnchor.Type type7 = ConstraintAnchor.Type.BOTTOM;
                    connect(type7, constraintWidget, type7, 0);
                } else {
                    z2 = false;
                }
                if (z && z2) {
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER), 0);
                    return;
                } else if (z) {
                    getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_X), 0);
                    return;
                } else {
                    if (z2) {
                        getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.CENTER_Y), 0);
                        return;
                    }
                    return;
                }
            }
            if (type2 != ConstraintAnchor.Type.LEFT && type2 != ConstraintAnchor.Type.RIGHT) {
                if (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM) {
                    connect(ConstraintAnchor.Type.TOP, constraintWidget, type2, 0);
                    connect(ConstraintAnchor.Type.BOTTOM, constraintWidget, type2, 0);
                    getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0);
                    return;
                }
                return;
            }
            connect(ConstraintAnchor.Type.LEFT, constraintWidget, type2, 0);
            connect(ConstraintAnchor.Type.RIGHT, constraintWidget, type2, 0);
            getAnchor(ConstraintAnchor.Type.CENTER).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        if (type == ConstraintAnchor.Type.CENTER_X && (type2 == ConstraintAnchor.Type.LEFT || type2 == ConstraintAnchor.Type.RIGHT)) {
            ConstraintAnchor anchor5 = getAnchor(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor anchor6 = constraintWidget.getAnchor(type2);
            ConstraintAnchor anchor7 = getAnchor(ConstraintAnchor.Type.RIGHT);
            anchor5.connect(anchor6, 0);
            anchor7.connect(anchor6, 0);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(anchor6, 0);
            return;
        }
        if (type == ConstraintAnchor.Type.CENTER_Y && (type2 == ConstraintAnchor.Type.TOP || type2 == ConstraintAnchor.Type.BOTTOM)) {
            ConstraintAnchor anchor8 = constraintWidget.getAnchor(type2);
            getAnchor(ConstraintAnchor.Type.TOP).connect(anchor8, 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(anchor8, 0);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(anchor8, 0);
            return;
        }
        ConstraintAnchor.Type type8 = ConstraintAnchor.Type.CENTER_X;
        if (type == type8 && type2 == type8) {
            getAnchor(ConstraintAnchor.Type.LEFT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT), 0);
            getAnchor(ConstraintAnchor.Type.RIGHT).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT), 0);
            getAnchor(ConstraintAnchor.Type.CENTER_X).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        ConstraintAnchor.Type type9 = ConstraintAnchor.Type.CENTER_Y;
        if (type == type9 && type2 == type9) {
            getAnchor(ConstraintAnchor.Type.TOP).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.TOP), 0);
            getAnchor(ConstraintAnchor.Type.BOTTOM).connect(constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM), 0);
            getAnchor(ConstraintAnchor.Type.CENTER_Y).connect(constraintWidget.getAnchor(type2), 0);
            return;
        }
        ConstraintAnchor anchor9 = getAnchor(type);
        ConstraintAnchor anchor10 = constraintWidget.getAnchor(type2);
        if (anchor9.isValidConnection(anchor10)) {
            if (type == ConstraintAnchor.Type.BASELINE) {
                ConstraintAnchor anchor11 = getAnchor(ConstraintAnchor.Type.TOP);
                ConstraintAnchor anchor12 = getAnchor(ConstraintAnchor.Type.BOTTOM);
                if (anchor11 != null) {
                    anchor11.reset();
                }
                if (anchor12 != null) {
                    anchor12.reset();
                }
                i2 = 0;
            } else if (type != ConstraintAnchor.Type.TOP && type != ConstraintAnchor.Type.BOTTOM) {
                if (type == ConstraintAnchor.Type.LEFT || type == ConstraintAnchor.Type.RIGHT) {
                    ConstraintAnchor anchor13 = getAnchor(ConstraintAnchor.Type.CENTER);
                    if (anchor13.getTarget() != anchor10) {
                        anchor13.reset();
                    }
                    ConstraintAnchor opposite = getAnchor(type).getOpposite();
                    ConstraintAnchor anchor14 = getAnchor(ConstraintAnchor.Type.CENTER_X);
                    if (anchor14.isConnected()) {
                        opposite.reset();
                        anchor14.reset();
                    }
                }
            } else {
                ConstraintAnchor anchor15 = getAnchor(ConstraintAnchor.Type.BASELINE);
                if (anchor15 != null) {
                    anchor15.reset();
                }
                ConstraintAnchor anchor16 = getAnchor(ConstraintAnchor.Type.CENTER);
                if (anchor16.getTarget() != anchor10) {
                    anchor16.reset();
                }
                ConstraintAnchor opposite2 = getAnchor(type).getOpposite();
                ConstraintAnchor anchor17 = getAnchor(ConstraintAnchor.Type.CENTER_Y);
                if (anchor17.isConnected()) {
                    opposite2.reset();
                    anchor17.reset();
                }
            }
            anchor9.connect(anchor10, i2);
        }
    }

    public void setFrame(int i2, int i3, int i4) {
        if (i4 == 0) {
            setHorizontalDimension(i2, i3);
        } else if (i4 == 1) {
            setVerticalDimension(i2, i3);
        }
    }

    public void setDimensionRatio(float f2, int i2) {
        this.mDimensionRatio = f2;
        this.mDimensionRatioSide = i2;
    }

    public ConstraintWidget(String str) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f2 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f2;
        this.mVerticalBiasPercent = f2;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        addAnchors();
        setDebugName(str);
    }

    public ConstraintWidget(int i2, int i3, int i4, int i5) {
        this.measured = false;
        this.run = new WidgetRun[2];
        this.horizontalRun = null;
        this.verticalRun = null;
        this.isTerminalWidget = new boolean[]{true, true};
        this.mResolvedHasRatio = false;
        this.mMeasureRequested = true;
        this.OPTIMIZE_WRAP = false;
        this.OPTIMIZE_WRAP_ON_RESOLVED = true;
        this.resolvedHorizontal = false;
        this.resolvedVertical = false;
        this.mHorizontalResolution = -1;
        this.mVerticalResolution = -1;
        this.mMatchConstraintDefaultWidth = 0;
        this.mMatchConstraintDefaultHeight = 0;
        this.mResolvedMatchConstraintDefault = new int[2];
        this.mMatchConstraintMinWidth = 0;
        this.mMatchConstraintMaxWidth = 0;
        this.mMatchConstraintPercentWidth = 1.0f;
        this.mMatchConstraintMinHeight = 0;
        this.mMatchConstraintMaxHeight = 0;
        this.mMatchConstraintPercentHeight = 1.0f;
        this.mResolvedDimensionRatioSide = -1;
        this.mResolvedDimensionRatio = 1.0f;
        this.mMaxDimension = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.mCircleConstraintAngle = 0.0f;
        this.hasBaseline = false;
        this.mInVirtuaLayout = false;
        this.mLastHorizontalMeasureSpec = 0;
        this.mLastVerticalMeasureSpec = 0;
        this.mLeft = new ConstraintAnchor(this, ConstraintAnchor.Type.LEFT);
        this.mTop = new ConstraintAnchor(this, ConstraintAnchor.Type.TOP);
        this.mRight = new ConstraintAnchor(this, ConstraintAnchor.Type.RIGHT);
        this.mBottom = new ConstraintAnchor(this, ConstraintAnchor.Type.BOTTOM);
        this.mBaseline = new ConstraintAnchor(this, ConstraintAnchor.Type.BASELINE);
        this.mCenterX = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_X);
        this.mCenterY = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER_Y);
        this.mCenter = new ConstraintAnchor(this, ConstraintAnchor.Type.CENTER);
        this.mListAnchors = new ConstraintAnchor[]{this.mLeft, this.mRight, this.mTop, this.mBottom, this.mBaseline, this.mCenter};
        this.mAnchors = new ArrayList<>();
        this.mIsInBarrier = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.FIXED;
        this.mListDimensionBehaviors = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.mParent = null;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mDimensionRatio = 0.0f;
        this.mDimensionRatioSide = -1;
        this.mX = 0;
        this.mY = 0;
        this.mRelX = 0;
        this.mRelY = 0;
        this.mOffsetX = 0;
        this.mOffsetY = 0;
        this.mBaselineDistance = 0;
        float f2 = DEFAULT_BIAS;
        this.mHorizontalBiasPercent = f2;
        this.mVerticalBiasPercent = f2;
        this.mContainerItemSkip = 0;
        this.mVisibility = 0;
        this.mDebugName = null;
        this.mType = null;
        this.mGroupsToSolver = false;
        this.mHorizontalChainStyle = 0;
        this.mVerticalChainStyle = 0;
        this.mWeight = new float[]{-1.0f, -1.0f};
        this.mListNextMatchConstraintsWidget = new ConstraintWidget[]{null, null};
        this.mNextChainWidget = new ConstraintWidget[]{null, null};
        this.mHorizontalNextWidget = null;
        this.mVerticalNextWidget = null;
        this.horizontalGroup = -1;
        this.verticalGroup = -1;
        this.mX = i2;
        this.mY = i3;
        this.mWidth = i4;
        this.mHeight = i5;
        addAnchors();
    }

    public ConstraintWidget(String str, int i2, int i3, int i4, int i5) {
        this(i2, i3, i4, i5);
        setDebugName(str);
    }

    public ConstraintWidget(int i2, int i3) {
        this(0, 0, i2, i3);
    }

    public ConstraintWidget(String str, int i2, int i3) {
        this(i2, i3);
        setDebugName(str);
    }
}
