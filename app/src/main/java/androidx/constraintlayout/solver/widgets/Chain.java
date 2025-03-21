package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import java.util.ArrayList;

/* loaded from: classes.dex */
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

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0035, code lost:
    
        if (r2.mHorizontalChainStyle == 2) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
    
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:317:0x004a, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:327:0x0048, code lost:
    
        if (r2.mVerticalChainStyle == 2) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0265 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x04d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x04f6  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x050d  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x051a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:164:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x04f0  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02ba A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03a4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03ac A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r37, androidx.constraintlayout.solver.LinearSystem r38, int r39, int r40, androidx.constraintlayout.solver.widgets.ChainHead r41) {
        /*
            Method dump skipped, instructions count: 1342
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Chain.applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):void");
    }
}
