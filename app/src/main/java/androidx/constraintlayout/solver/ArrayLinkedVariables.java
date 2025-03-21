package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import java.util.Arrays;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes.dex */
public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    static final int NONE = -1;
    private static float epsilon = 0.001f;
    private int[] mArrayIndices;
    private int[] mArrayNextIndices;
    private float[] mArrayValues;
    protected final Cache mCache;
    private boolean mDidFillOnce;
    private int mHead;
    private int mLast;
    private final ArrayRow mRow;
    int currentSize = 0;
    private int ROW_SIZE = 8;
    private SolverVariable candidate = null;

    ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        int i2 = this.ROW_SIZE;
        this.mArrayIndices = new int[i2];
        this.mArrayNextIndices = new int[i2];
        this.mArrayValues = new float[i2];
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.mRow = arrayRow;
        this.mCache = cache;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f2, boolean z) {
        float f3 = epsilon;
        if (f2 <= (-f3) || f2 >= f3) {
            int i2 = this.mHead;
            if (i2 == -1) {
                this.mHead = 0;
                float[] fArr = this.mArrayValues;
                int i3 = this.mHead;
                fArr[i3] = f2;
                this.mArrayIndices[i3] = solverVariable.f594id;
                this.mArrayNextIndices[i3] = -1;
                solverVariable.usageInRowCount++;
                solverVariable.addToRow(this.mRow);
                this.currentSize++;
                if (this.mDidFillOnce) {
                    return;
                }
                this.mLast++;
                int i4 = this.mLast;
                int[] iArr = this.mArrayIndices;
                if (i4 >= iArr.length) {
                    this.mDidFillOnce = true;
                    this.mLast = iArr.length - 1;
                    return;
                }
                return;
            }
            int i5 = -1;
            for (int i6 = 0; i2 != -1 && i6 < this.currentSize; i6++) {
                int[] iArr2 = this.mArrayIndices;
                int i7 = iArr2[i2];
                int i8 = solverVariable.f594id;
                if (i7 == i8) {
                    float f4 = this.mArrayValues[i2] + f2;
                    float f5 = epsilon;
                    if (f4 > (-f5) && f4 < f5) {
                        f4 = 0.0f;
                    }
                    this.mArrayValues[i2] = f4;
                    if (f4 == 0.0f) {
                        if (i2 == this.mHead) {
                            this.mHead = this.mArrayNextIndices[i2];
                        } else {
                            int[] iArr3 = this.mArrayNextIndices;
                            iArr3[i5] = iArr3[i2];
                        }
                        if (z) {
                            solverVariable.removeFromRow(this.mRow);
                        }
                        if (this.mDidFillOnce) {
                            this.mLast = i2;
                        }
                        solverVariable.usageInRowCount--;
                        this.currentSize--;
                        return;
                    }
                    return;
                }
                if (iArr2[i2] < i8) {
                    i5 = i2;
                }
                i2 = this.mArrayNextIndices[i2];
            }
            int i9 = this.mLast;
            int i10 = i9 + 1;
            if (this.mDidFillOnce) {
                int[] iArr4 = this.mArrayIndices;
                if (iArr4[i9] != -1) {
                    i9 = iArr4.length;
                }
            } else {
                i9 = i10;
            }
            int[] iArr5 = this.mArrayIndices;
            if (i9 >= iArr5.length && this.currentSize < iArr5.length) {
                int i11 = 0;
                while (true) {
                    int[] iArr6 = this.mArrayIndices;
                    if (i11 >= iArr6.length) {
                        break;
                    }
                    if (iArr6[i11] == -1) {
                        i9 = i11;
                        break;
                    }
                    i11++;
                }
            }
            int[] iArr7 = this.mArrayIndices;
            if (i9 >= iArr7.length) {
                i9 = iArr7.length;
                this.ROW_SIZE *= 2;
                this.mDidFillOnce = false;
                this.mLast = i9 - 1;
                this.mArrayValues = Arrays.copyOf(this.mArrayValues, this.ROW_SIZE);
                this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
                this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
            }
            this.mArrayIndices[i9] = solverVariable.f594id;
            this.mArrayValues[i9] = f2;
            if (i5 != -1) {
                int[] iArr8 = this.mArrayNextIndices;
                iArr8[i9] = iArr8[i5];
                iArr8[i5] = i9;
            } else {
                this.mArrayNextIndices[i9] = this.mHead;
                this.mHead = i9;
            }
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (!this.mDidFillOnce) {
                this.mLast++;
            }
            int i12 = this.mLast;
            int[] iArr9 = this.mArrayIndices;
            if (i12 >= iArr9.length) {
                this.mDidFillOnce = true;
                this.mLast = iArr9.length - 1;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void clear() {
        int i2 = this.mHead;
        for (int i3 = 0; i2 != -1 && i3 < this.currentSize; i3++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i2]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.mRow);
            }
            i2 = this.mArrayNextIndices[i2];
        }
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.currentSize = 0;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        int i2 = this.mHead;
        if (i2 == -1) {
            return false;
        }
        for (int i3 = 0; i2 != -1 && i3 < this.currentSize; i3++) {
            if (this.mArrayIndices[i2] == solverVariable.f594id) {
                return true;
            }
            i2 = this.mArrayNextIndices[i2];
        }
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void display() {
        int i2 = this.currentSize;
        System.out.print("{ ");
        for (int i3 = 0; i3 < i2; i3++) {
            SolverVariable variable = getVariable(i3);
            if (variable != null) {
                System.out.print(variable + " = " + getVariableValue(i3) + AbstractC1191a.f2568g);
            }
        }
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f2) {
        int i2 = this.mHead;
        for (int i3 = 0; i2 != -1 && i3 < this.currentSize; i3++) {
            float[] fArr = this.mArrayValues;
            fArr[i2] = fArr[i2] / f2;
            i2 = this.mArrayNextIndices[i2];
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float get(SolverVariable solverVariable) {
        int i2 = this.mHead;
        for (int i3 = 0; i2 != -1 && i3 < this.currentSize; i3++) {
            if (this.mArrayIndices[i2] == solverVariable.f594id) {
                return this.mArrayValues[i2];
            }
            i2 = this.mArrayNextIndices[i2];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.currentSize;
    }

    public int getHead() {
        return this.mHead;
    }

    public final int getId(int i2) {
        return this.mArrayIndices[i2];
    }

    public final int getNextIndice(int i2) {
        return this.mArrayNextIndices[i2];
    }

    SolverVariable getPivotCandidate() {
        SolverVariable solverVariable = this.candidate;
        if (solverVariable != null) {
            return solverVariable;
        }
        int i2 = this.mHead;
        SolverVariable solverVariable2 = null;
        for (int i3 = 0; i2 != -1 && i3 < this.currentSize; i3++) {
            if (this.mArrayValues[i2] < 0.0f) {
                SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i2]];
                if (solverVariable2 == null || solverVariable2.strength < solverVariable3.strength) {
                    solverVariable2 = solverVariable3;
                }
            }
            i2 = this.mArrayNextIndices[i2];
        }
        return solverVariable2;
    }

    public final float getValue(int i2) {
        return this.mArrayValues[i2];
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i2) {
        int i3 = this.mHead;
        for (int i4 = 0; i3 != -1 && i4 < this.currentSize; i4++) {
            if (i4 == i2) {
                return this.mCache.mIndexedVariables[this.mArrayIndices[i3]];
            }
            i3 = this.mArrayNextIndices[i3];
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i2) {
        int i3 = this.mHead;
        for (int i4 = 0; i3 != -1 && i4 < this.currentSize; i4++) {
            if (i4 == i2) {
                return this.mArrayValues[i3];
            }
            i3 = this.mArrayNextIndices[i3];
        }
        return 0.0f;
    }

    boolean hasAtLeastOnePositiveVariable() {
        int i2 = this.mHead;
        for (int i3 = 0; i2 != -1 && i3 < this.currentSize; i3++) {
            if (this.mArrayValues[i2] > 0.0f) {
                return true;
            }
            i2 = this.mArrayNextIndices[i2];
        }
        return false;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        int i2 = this.mHead;
        if (i2 == -1) {
            return -1;
        }
        for (int i3 = 0; i2 != -1 && i3 < this.currentSize; i3++) {
            if (this.mArrayIndices[i2] == solverVariable.f594id) {
                return i2;
            }
            i2 = this.mArrayNextIndices[i2];
        }
        return -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void invert() {
        int i2 = this.mHead;
        for (int i3 = 0; i2 != -1 && i3 < this.currentSize; i3++) {
            float[] fArr = this.mArrayValues;
            fArr[i2] = fArr[i2] * (-1.0f);
            i2 = this.mArrayNextIndices[i2];
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final void put(SolverVariable solverVariable, float f2) {
        if (f2 == 0.0f) {
            remove(solverVariable, true);
            return;
        }
        int i2 = this.mHead;
        if (i2 == -1) {
            this.mHead = 0;
            float[] fArr = this.mArrayValues;
            int i3 = this.mHead;
            fArr[i3] = f2;
            this.mArrayIndices[i3] = solverVariable.f594id;
            this.mArrayNextIndices[i3] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.currentSize++;
            if (this.mDidFillOnce) {
                return;
            }
            this.mLast++;
            int i4 = this.mLast;
            int[] iArr = this.mArrayIndices;
            if (i4 >= iArr.length) {
                this.mDidFillOnce = true;
                this.mLast = iArr.length - 1;
                return;
            }
            return;
        }
        int i5 = -1;
        for (int i6 = 0; i2 != -1 && i6 < this.currentSize; i6++) {
            int[] iArr2 = this.mArrayIndices;
            int i7 = iArr2[i2];
            int i8 = solverVariable.f594id;
            if (i7 == i8) {
                this.mArrayValues[i2] = f2;
                return;
            }
            if (iArr2[i2] < i8) {
                i5 = i2;
            }
            i2 = this.mArrayNextIndices[i2];
        }
        int i9 = this.mLast;
        int i10 = i9 + 1;
        if (this.mDidFillOnce) {
            int[] iArr3 = this.mArrayIndices;
            if (iArr3[i9] != -1) {
                i9 = iArr3.length;
            }
        } else {
            i9 = i10;
        }
        int[] iArr4 = this.mArrayIndices;
        if (i9 >= iArr4.length && this.currentSize < iArr4.length) {
            int i11 = 0;
            while (true) {
                int[] iArr5 = this.mArrayIndices;
                if (i11 >= iArr5.length) {
                    break;
                }
                if (iArr5[i11] == -1) {
                    i9 = i11;
                    break;
                }
                i11++;
            }
        }
        int[] iArr6 = this.mArrayIndices;
        if (i9 >= iArr6.length) {
            i9 = iArr6.length;
            this.ROW_SIZE *= 2;
            this.mDidFillOnce = false;
            this.mLast = i9 - 1;
            this.mArrayValues = Arrays.copyOf(this.mArrayValues, this.ROW_SIZE);
            this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.ROW_SIZE);
            this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.ROW_SIZE);
        }
        this.mArrayIndices[i9] = solverVariable.f594id;
        this.mArrayValues[i9] = f2;
        if (i5 != -1) {
            int[] iArr7 = this.mArrayNextIndices;
            iArr7[i9] = iArr7[i5];
            iArr7[i5] = i9;
        } else {
            this.mArrayNextIndices[i9] = this.mHead;
            this.mHead = i9;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(this.mRow);
        this.currentSize++;
        if (!this.mDidFillOnce) {
            this.mLast++;
        }
        if (this.currentSize >= this.mArrayIndices.length) {
            this.mDidFillOnce = true;
        }
        int i12 = this.mLast;
        int[] iArr8 = this.mArrayIndices;
        if (i12 >= iArr8.length) {
            this.mDidFillOnce = true;
            this.mLast = iArr8.length - 1;
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public final float remove(SolverVariable solverVariable, boolean z) {
        if (this.candidate == solverVariable) {
            this.candidate = null;
        }
        int i2 = this.mHead;
        if (i2 == -1) {
            return 0.0f;
        }
        int i3 = 0;
        int i4 = -1;
        while (i2 != -1 && i3 < this.currentSize) {
            if (this.mArrayIndices[i2] == solverVariable.f594id) {
                if (i2 == this.mHead) {
                    this.mHead = this.mArrayNextIndices[i2];
                } else {
                    int[] iArr = this.mArrayNextIndices;
                    iArr[i4] = iArr[i2];
                }
                if (z) {
                    solverVariable.removeFromRow(this.mRow);
                }
                solverVariable.usageInRowCount--;
                this.currentSize--;
                this.mArrayIndices[i2] = -1;
                if (this.mDidFillOnce) {
                    this.mLast = i2;
                }
                return this.mArrayValues[i2];
            }
            i3++;
            i4 = i2;
            i2 = this.mArrayNextIndices[i2];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return (this.mArrayIndices.length * 4 * 3) + 0 + 36;
    }

    public String toString() {
        int i2 = this.mHead;
        String str = "";
        for (int i3 = 0; i2 != -1 && i3 < this.currentSize; i3++) {
            str = ((str + " -> ") + this.mArrayValues[i2] + " : ") + this.mCache.mIndexedVariables[this.mArrayIndices[i2]];
            i2 = this.mArrayNextIndices[i2];
        }
        return str;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z) {
        float f2 = get(arrayRow.variable);
        remove(arrayRow.variable, z);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i2 = 0; i2 < currentSize; i2++) {
            SolverVariable variable = arrayRowVariables.getVariable(i2);
            add(variable, arrayRowVariables.get(variable) * f2, z);
        }
        return f2;
    }
}
