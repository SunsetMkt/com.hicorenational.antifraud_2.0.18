package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i2) {
        int i3;
        ChainHead[] chainHeadArr;
        int i4;
        if (i2 == 0) {
            i3 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i4 = 0;
        } else {
            i3 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
            i4 = 2;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            ChainHead chainHead = chainHeadArr[i5];
            chainHead.define();
            if (arrayList == null || (arrayList != null && arrayList.contains(chainHead.mFirst))) {
                applyChainConstraints(constraintWidgetContainer, linearSystem, i2, i4, chainHead);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:365:0x004a A[PHI: r8 r14
  0x004a: PHI (r8v4 boolean) = (r8v2 boolean), (r8v48 boolean) binds: [B:364:0x0048, B:353:0x0035] A[DONT_GENERATE, DONT_INLINE]
  0x004a: PHI (r14v4 boolean) = (r14v2 boolean), (r14v19 boolean) binds: [B:364:0x0048, B:353:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x004c A[PHI: r8 r14
  0x004c: PHI (r8v45 boolean) = (r8v2 boolean), (r8v48 boolean) binds: [B:364:0x0048, B:353:0x0035] A[DONT_GENERATE, DONT_INLINE]
  0x004c: PHI (r14v16 boolean) = (r14v2 boolean), (r14v19 boolean) binds: [B:364:0x0048, B:353:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:436:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:511:0x02e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i2, int i3, ChainHead chainHead) {
        boolean z;
        boolean z2;
        boolean z3;
        int i4;
        ConstraintWidget constraintWidget;
        int i5;
        ConstraintAnchor constraintAnchor;
        SolverVariable solverVariable;
        SolverVariable solverVariable2;
        ConstraintWidget constraintWidget2;
        ConstraintAnchor constraintAnchor2;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        ConstraintWidget constraintWidget3;
        float f2;
        int size;
        ArrayList<ConstraintWidget> arrayList;
        int i6;
        boolean z4;
        ConstraintWidget constraintWidget4;
        boolean z5;
        int i7;
        ConstraintWidget constraintWidget5 = chainHead.mFirst;
        ConstraintWidget constraintWidget6 = chainHead.mLast;
        ConstraintWidget constraintWidget7 = chainHead.mFirstVisibleWidget;
        ConstraintWidget constraintWidget8 = chainHead.mLastVisibleWidget;
        ConstraintWidget constraintWidget9 = chainHead.mHead;
        float f3 = chainHead.mTotalWeight;
        ConstraintWidget constraintWidget10 = chainHead.mFirstMatchConstraintWidget;
        ConstraintWidget constraintWidget11 = chainHead.mLastMatchConstraintWidget;
        boolean z6 = constraintWidgetContainer.mListDimensionBehaviors[i2] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i2 == 0) {
            z = constraintWidget9.mHorizontalChainStyle == 0;
            z2 = constraintWidget9.mHorizontalChainStyle == 1;
            z3 = constraintWidget9.mHorizontalChainStyle == 2;
        } else {
            z = constraintWidget9.mVerticalChainStyle == 0;
            z2 = constraintWidget9.mVerticalChainStyle == 1;
            if (constraintWidget9.mVerticalChainStyle == 2) {
            }
        }
        boolean z7 = z;
        ConstraintWidget constraintWidget12 = constraintWidget5;
        boolean z8 = z2;
        boolean z9 = z3;
        boolean z10 = false;
        while (true) {
            ConstraintWidget constraintWidget13 = null;
            if (z10) {
                break;
            }
            ConstraintAnchor constraintAnchor3 = constraintWidget12.mListAnchors[i3];
            int i8 = z9 ? 1 : 4;
            int margin = constraintAnchor3.getMargin();
            float f4 = f3;
            boolean z11 = constraintWidget12.mListDimensionBehaviors[i2] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget12.mResolvedMatchConstraintDefault[i2] == 0;
            ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
            if (constraintAnchor4 != null && constraintWidget12 != constraintWidget5) {
                margin += constraintAnchor4.getMargin();
            }
            int i9 = margin;
            if (!z9 || constraintWidget12 == constraintWidget5 || constraintWidget12 == constraintWidget7) {
                z4 = z10;
            } else {
                z4 = z10;
                i8 = 8;
            }
            ConstraintAnchor constraintAnchor5 = constraintAnchor3.mTarget;
            if (constraintAnchor5 != null) {
                if (constraintWidget12 == constraintWidget7) {
                    z5 = z7;
                    constraintWidget4 = constraintWidget9;
                    linearSystem.addGreaterThan(constraintAnchor3.mSolverVariable, constraintAnchor5.mSolverVariable, i9, 6);
                } else {
                    constraintWidget4 = constraintWidget9;
                    z5 = z7;
                    linearSystem.addGreaterThan(constraintAnchor3.mSolverVariable, constraintAnchor5.mSolverVariable, i9, 8);
                }
                linearSystem.addEquality(constraintAnchor3.mSolverVariable, constraintAnchor3.mTarget.mSolverVariable, i9, (!z11 || z9) ? i8 : 5);
            } else {
                constraintWidget4 = constraintWidget9;
                z5 = z7;
            }
            if (z6) {
                if (constraintWidget12.getVisibility() == 8 || constraintWidget12.mListDimensionBehaviors[i2] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i7 = 0;
                } else {
                    ConstraintAnchor[] constraintAnchorArr = constraintWidget12.mListAnchors;
                    i7 = 0;
                    linearSystem.addGreaterThan(constraintAnchorArr[i3 + 1].mSolverVariable, constraintAnchorArr[i3].mSolverVariable, 0, 5);
                }
                linearSystem.addGreaterThan(constraintWidget12.mListAnchors[i3].mSolverVariable, constraintWidgetContainer.mListAnchors[i3].mSolverVariable, i7, 8);
            }
            ConstraintAnchor constraintAnchor6 = constraintWidget12.mListAnchors[i3 + 1].mTarget;
            if (constraintAnchor6 != null) {
                ConstraintWidget constraintWidget14 = constraintAnchor6.mOwner;
                ConstraintAnchor[] constraintAnchorArr2 = constraintWidget14.mListAnchors;
                if (constraintAnchorArr2[i3].mTarget != null && constraintAnchorArr2[i3].mTarget.mOwner == constraintWidget12) {
                    constraintWidget13 = constraintWidget14;
                }
            }
            if (constraintWidget13 != null) {
                constraintWidget12 = constraintWidget13;
                z10 = z4;
            } else {
                z10 = true;
            }
            f3 = f4;
            z7 = z5;
            constraintWidget9 = constraintWidget4;
        }
        ConstraintWidget constraintWidget15 = constraintWidget9;
        float f5 = f3;
        boolean z12 = z7;
        if (constraintWidget8 != null) {
            int i10 = i3 + 1;
            if (constraintWidget6.mListAnchors[i10].mTarget != null) {
                ConstraintAnchor constraintAnchor7 = constraintWidget8.mListAnchors[i10];
                if ((constraintWidget8.mListDimensionBehaviors[i2] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget8.mResolvedMatchConstraintDefault[i2] == 0) && !z9) {
                    ConstraintAnchor constraintAnchor8 = constraintAnchor7.mTarget;
                    if (constraintAnchor8.mOwner == constraintWidgetContainer) {
                        linearSystem.addEquality(constraintAnchor7.mSolverVariable, constraintAnchor8.mSolverVariable, -constraintAnchor7.getMargin(), 5);
                    }
                    linearSystem.addLowerThan(constraintAnchor7.mSolverVariable, constraintWidget6.mListAnchors[i10].mTarget.mSolverVariable, -constraintAnchor7.getMargin(), 6);
                } else {
                    if (z9) {
                        ConstraintAnchor constraintAnchor9 = constraintAnchor7.mTarget;
                        if (constraintAnchor9.mOwner == constraintWidgetContainer) {
                            linearSystem.addEquality(constraintAnchor7.mSolverVariable, constraintAnchor9.mSolverVariable, -constraintAnchor7.getMargin(), 4);
                        }
                    }
                    linearSystem.addLowerThan(constraintAnchor7.mSolverVariable, constraintWidget6.mListAnchors[i10].mTarget.mSolverVariable, -constraintAnchor7.getMargin(), 6);
                }
            }
        }
        if (z6) {
            int i11 = i3 + 1;
            SolverVariable solverVariable5 = constraintWidgetContainer.mListAnchors[i11].mSolverVariable;
            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget6.mListAnchors;
            linearSystem.addGreaterThan(solverVariable5, constraintAnchorArr3[i11].mSolverVariable, constraintAnchorArr3[i11].getMargin(), 8);
        }
        ArrayList<ConstraintWidget> arrayList2 = chainHead.mWeightedMatchConstraintsWidgets;
        if (arrayList2 != null && (size = arrayList2.size()) > 1) {
            float f6 = (!chainHead.mHasUndefinedWeights || chainHead.mHasComplexMatchWeights) ? f5 : chainHead.mWidgetsMatchCount;
            float f7 = 0.0f;
            ConstraintWidget constraintWidget16 = null;
            int i12 = 0;
            float f8 = 0.0f;
            while (i12 < size) {
                ConstraintWidget constraintWidget17 = arrayList2.get(i12);
                float f9 = constraintWidget17.mWeight[i2];
                if (f9 < f7) {
                    if (chainHead.mHasComplexMatchWeights) {
                        ConstraintAnchor[] constraintAnchorArr4 = constraintWidget17.mListAnchors;
                        linearSystem.addEquality(constraintAnchorArr4[i3 + 1].mSolverVariable, constraintAnchorArr4[i3].mSolverVariable, 0, 4);
                        arrayList = arrayList2;
                        i6 = size;
                        i12++;
                        size = i6;
                        arrayList2 = arrayList;
                        f7 = 0.0f;
                    } else {
                        f9 = 1.0f;
                        f7 = 0.0f;
                    }
                }
                if (f9 == f7) {
                    ConstraintAnchor[] constraintAnchorArr5 = constraintWidget17.mListAnchors;
                    linearSystem.addEquality(constraintAnchorArr5[i3 + 1].mSolverVariable, constraintAnchorArr5[i3].mSolverVariable, 0, 8);
                    arrayList = arrayList2;
                    i6 = size;
                    i12++;
                    size = i6;
                    arrayList2 = arrayList;
                    f7 = 0.0f;
                } else {
                    if (constraintWidget16 != null) {
                        ConstraintAnchor[] constraintAnchorArr6 = constraintWidget16.mListAnchors;
                        SolverVariable solverVariable6 = constraintAnchorArr6[i3].mSolverVariable;
                        int i13 = i3 + 1;
                        SolverVariable solverVariable7 = constraintAnchorArr6[i13].mSolverVariable;
                        ConstraintAnchor[] constraintAnchorArr7 = constraintWidget17.mListAnchors;
                        arrayList = arrayList2;
                        SolverVariable solverVariable8 = constraintAnchorArr7[i3].mSolverVariable;
                        SolverVariable solverVariable9 = constraintAnchorArr7[i13].mSolverVariable;
                        i6 = size;
                        ArrayRow arrayRowCreateRow = linearSystem.createRow();
                        arrayRowCreateRow.createRowEqualMatchDimensions(f8, f6, f9, solverVariable6, solverVariable7, solverVariable8, solverVariable9);
                        linearSystem.addConstraint(arrayRowCreateRow);
                    } else {
                        arrayList = arrayList2;
                        i6 = size;
                    }
                    f8 = f9;
                    constraintWidget16 = constraintWidget17;
                    i12++;
                    size = i6;
                    arrayList2 = arrayList;
                    f7 = 0.0f;
                }
            }
        }
        if (constraintWidget7 != null && (constraintWidget7 == constraintWidget8 || z9)) {
            ConstraintAnchor constraintAnchor10 = constraintWidget5.mListAnchors[i3];
            int i14 = i3 + 1;
            ConstraintAnchor constraintAnchor11 = constraintWidget6.mListAnchors[i14];
            ConstraintAnchor constraintAnchor12 = constraintAnchor10.mTarget;
            SolverVariable solverVariable10 = constraintAnchor12 != null ? constraintAnchor12.mSolverVariable : null;
            ConstraintAnchor constraintAnchor13 = constraintAnchor11.mTarget;
            SolverVariable solverVariable11 = constraintAnchor13 != null ? constraintAnchor13.mSolverVariable : null;
            ConstraintAnchor constraintAnchor14 = constraintWidget7.mListAnchors[i3];
            ConstraintAnchor constraintAnchor15 = constraintWidget8.mListAnchors[i14];
            if (solverVariable10 != null && solverVariable11 != null) {
                if (i2 == 0) {
                    f2 = constraintWidget15.mHorizontalBiasPercent;
                } else {
                    f2 = constraintWidget15.mVerticalBiasPercent;
                }
                linearSystem.addCentering(constraintAnchor14.mSolverVariable, solverVariable10, constraintAnchor14.getMargin(), f2, solverVariable11, constraintAnchor15.mSolverVariable, constraintAnchor15.getMargin(), 7);
            }
        } else if (!z12 || constraintWidget7 == null) {
            int i15 = 8;
            if (z8 && constraintWidget7 != null) {
                int i16 = chainHead.mWidgetsMatchCount;
                boolean z13 = i16 > 0 && chainHead.mWidgetsCount == i16;
                ConstraintWidget constraintWidget18 = constraintWidget7;
                ConstraintWidget constraintWidget19 = constraintWidget18;
                while (constraintWidget18 != null) {
                    ConstraintWidget constraintWidget20 = constraintWidget18.mNextChainWidget[i2];
                    while (constraintWidget20 != null && constraintWidget20.getVisibility() == i15) {
                        constraintWidget20 = constraintWidget20.mNextChainWidget[i2];
                    }
                    if (constraintWidget18 == constraintWidget7 || constraintWidget18 == constraintWidget8 || constraintWidget20 == null) {
                        constraintWidget = constraintWidget19;
                        i5 = 8;
                    } else {
                        ConstraintWidget constraintWidget21 = constraintWidget20 == constraintWidget8 ? null : constraintWidget20;
                        ConstraintAnchor constraintAnchor16 = constraintWidget18.mListAnchors[i3];
                        SolverVariable solverVariable12 = constraintAnchor16.mSolverVariable;
                        ConstraintAnchor constraintAnchor17 = constraintAnchor16.mTarget;
                        if (constraintAnchor17 != null) {
                            SolverVariable solverVariable13 = constraintAnchor17.mSolverVariable;
                        }
                        int i17 = i3 + 1;
                        SolverVariable solverVariable14 = constraintWidget19.mListAnchors[i17].mSolverVariable;
                        int margin2 = constraintAnchor16.getMargin();
                        int margin3 = constraintWidget18.mListAnchors[i17].getMargin();
                        if (constraintWidget21 != null) {
                            constraintAnchor = constraintWidget21.mListAnchors[i3];
                            solverVariable = constraintAnchor.mSolverVariable;
                            ConstraintAnchor constraintAnchor18 = constraintAnchor.mTarget;
                            solverVariable2 = constraintAnchor18 != null ? constraintAnchor18.mSolverVariable : null;
                        } else {
                            constraintAnchor = constraintWidget8.mListAnchors[i3];
                            solverVariable = constraintAnchor != null ? constraintAnchor.mSolverVariable : null;
                            solverVariable2 = constraintWidget18.mListAnchors[i17].mSolverVariable;
                        }
                        if (constraintAnchor != null) {
                            margin3 += constraintAnchor.getMargin();
                        }
                        int i18 = margin3;
                        if (constraintWidget19 != null) {
                            margin2 += constraintWidget19.mListAnchors[i17].getMargin();
                        }
                        int i19 = margin2;
                        int i20 = z13 ? 8 : 4;
                        if (solverVariable12 == null || solverVariable14 == null || solverVariable == null || solverVariable2 == null) {
                            constraintWidget2 = constraintWidget21;
                            constraintWidget = constraintWidget19;
                            i5 = 8;
                        } else {
                            constraintWidget2 = constraintWidget21;
                            constraintWidget = constraintWidget19;
                            i5 = 8;
                            linearSystem.addCentering(solverVariable12, solverVariable14, i19, 0.5f, solverVariable, solverVariable2, i18, i20);
                        }
                        constraintWidget20 = constraintWidget2;
                    }
                    if (constraintWidget18.getVisibility() == i5) {
                        constraintWidget18 = constraintWidget;
                    }
                    constraintWidget19 = constraintWidget18;
                    i15 = 8;
                    constraintWidget18 = constraintWidget20;
                }
                ConstraintAnchor constraintAnchor19 = constraintWidget7.mListAnchors[i3];
                ConstraintAnchor constraintAnchor20 = constraintWidget5.mListAnchors[i3].mTarget;
                int i21 = i3 + 1;
                ConstraintAnchor constraintAnchor21 = constraintWidget8.mListAnchors[i21];
                ConstraintAnchor constraintAnchor22 = constraintWidget6.mListAnchors[i21].mTarget;
                if (constraintAnchor20 == null) {
                    i4 = 5;
                } else if (constraintWidget7 != constraintWidget8) {
                    i4 = 5;
                    linearSystem.addEquality(constraintAnchor19.mSolverVariable, constraintAnchor20.mSolverVariable, constraintAnchor19.getMargin(), 5);
                } else {
                    i4 = 5;
                    if (constraintAnchor22 != null) {
                        linearSystem.addCentering(constraintAnchor19.mSolverVariable, constraintAnchor20.mSolverVariable, constraintAnchor19.getMargin(), 0.5f, constraintAnchor21.mSolverVariable, constraintAnchor22.mSolverVariable, constraintAnchor21.getMargin(), 5);
                    }
                }
                if (constraintAnchor22 != null && constraintWidget7 != constraintWidget8) {
                    linearSystem.addEquality(constraintAnchor21.mSolverVariable, constraintAnchor22.mSolverVariable, -constraintAnchor21.getMargin(), i4);
                }
            }
        } else {
            int i22 = chainHead.mWidgetsMatchCount;
            boolean z14 = i22 > 0 && chainHead.mWidgetsCount == i22;
            ConstraintWidget constraintWidget22 = constraintWidget7;
            ConstraintWidget constraintWidget23 = constraintWidget22;
            while (constraintWidget22 != null) {
                ConstraintWidget constraintWidget24 = constraintWidget22.mNextChainWidget[i2];
                while (constraintWidget24 != null && constraintWidget24.getVisibility() == 8) {
                    constraintWidget24 = constraintWidget24.mNextChainWidget[i2];
                }
                if (constraintWidget24 != null || constraintWidget22 == constraintWidget8) {
                    ConstraintAnchor constraintAnchor23 = constraintWidget22.mListAnchors[i3];
                    SolverVariable solverVariable15 = constraintAnchor23.mSolverVariable;
                    ConstraintAnchor constraintAnchor24 = constraintAnchor23.mTarget;
                    SolverVariable solverVariable16 = constraintAnchor24 != null ? constraintAnchor24.mSolverVariable : null;
                    if (constraintWidget23 != constraintWidget22) {
                        solverVariable16 = constraintWidget23.mListAnchors[i3 + 1].mSolverVariable;
                    } else if (constraintWidget22 == constraintWidget7 && constraintWidget23 == constraintWidget22) {
                        ConstraintAnchor[] constraintAnchorArr8 = constraintWidget5.mListAnchors;
                        solverVariable16 = constraintAnchorArr8[i3].mTarget != null ? constraintAnchorArr8[i3].mTarget.mSolverVariable : null;
                    }
                    int margin4 = constraintAnchor23.getMargin();
                    int i23 = i3 + 1;
                    int margin5 = constraintWidget22.mListAnchors[i23].getMargin();
                    if (constraintWidget24 != null) {
                        constraintAnchor2 = constraintWidget24.mListAnchors[i3];
                        SolverVariable solverVariable17 = constraintAnchor2.mSolverVariable;
                        solverVariable4 = constraintWidget22.mListAnchors[i23].mSolverVariable;
                        solverVariable3 = solverVariable17;
                    } else {
                        constraintAnchor2 = constraintWidget6.mListAnchors[i23].mTarget;
                        solverVariable3 = constraintAnchor2 != null ? constraintAnchor2.mSolverVariable : null;
                        solverVariable4 = constraintWidget22.mListAnchors[i23].mSolverVariable;
                    }
                    if (constraintAnchor2 != null) {
                        margin5 += constraintAnchor2.getMargin();
                    }
                    if (constraintWidget23 != null) {
                        margin4 += constraintWidget23.mListAnchors[i23].getMargin();
                    }
                    if (solverVariable15 == null || solverVariable16 == null || solverVariable3 == null || solverVariable4 == null) {
                        constraintWidget3 = constraintWidget24;
                    } else {
                        if (constraintWidget22 == constraintWidget7) {
                            margin4 = constraintWidget7.mListAnchors[i3].getMargin();
                        }
                        int i24 = margin4;
                        constraintWidget3 = constraintWidget24;
                        linearSystem.addCentering(solverVariable15, solverVariable16, i24, 0.5f, solverVariable3, solverVariable4, constraintWidget22 == constraintWidget8 ? constraintWidget8.mListAnchors[i23].getMargin() : margin5, z14 ? 8 : 5);
                    }
                }
                if (constraintWidget22.getVisibility() != 8) {
                    constraintWidget23 = constraintWidget22;
                }
                constraintWidget22 = constraintWidget3;
            }
        }
        if ((!z12 && !z8) || constraintWidget7 == null || constraintWidget7 == constraintWidget8) {
            return;
        }
        ConstraintAnchor constraintAnchor25 = constraintWidget7.mListAnchors[i3];
        int i25 = i3 + 1;
        ConstraintAnchor constraintAnchor26 = constraintWidget8.mListAnchors[i25];
        ConstraintAnchor constraintAnchor27 = constraintAnchor25.mTarget;
        SolverVariable solverVariable18 = constraintAnchor27 != null ? constraintAnchor27.mSolverVariable : null;
        ConstraintAnchor constraintAnchor28 = constraintAnchor26.mTarget;
        SolverVariable solverVariable19 = constraintAnchor28 != null ? constraintAnchor28.mSolverVariable : null;
        if (constraintWidget6 != constraintWidget8) {
            ConstraintAnchor constraintAnchor29 = constraintWidget6.mListAnchors[i25].mTarget;
            solverVariable19 = constraintAnchor29 != null ? constraintAnchor29.mSolverVariable : null;
        }
        SolverVariable solverVariable20 = solverVariable19;
        if (constraintWidget7 == constraintWidget8) {
            ConstraintAnchor[] constraintAnchorArr9 = constraintWidget7.mListAnchors;
            ConstraintAnchor constraintAnchor30 = constraintAnchorArr9[i3];
            constraintAnchor26 = constraintAnchorArr9[i25];
            constraintAnchor25 = constraintAnchor30;
        }
        if (solverVariable18 == null || solverVariable20 == null) {
            return;
        }
        int margin6 = constraintAnchor25.getMargin();
        if (constraintWidget8 != null) {
            constraintWidget6 = constraintWidget8;
        }
        linearSystem.addCentering(constraintAnchor25.mSolverVariable, solverVariable18, margin6, 0.5f, solverVariable20, constraintAnchor26.mSolverVariable, constraintWidget6.mListAnchors[i25].getMargin(), 5);
    }
}
