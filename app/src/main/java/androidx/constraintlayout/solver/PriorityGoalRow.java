package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* loaded from: classes.dex */
public class PriorityGoalRow extends ArrayRow {
    private static final boolean DEBUG = false;
    static final int NOT_FOUND = -1;
    private static final float epsilon = 1.0E-4f;
    private int TABLE_SIZE;
    GoalVariableAccessor accessor;
    private SolverVariable[] arrayGoals;
    Cache mCache;
    private int numGoals;
    private SolverVariable[] sortArray;

    class GoalVariableAccessor implements Comparable {
        PriorityGoalRow row;
        SolverVariable variable;

        public GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
            this.row = priorityGoalRow;
        }

        public void add(SolverVariable solverVariable) {
            for (int i2 = 0; i2 < 9; i2++) {
                float[] fArr = this.variable.goalStrengthVector;
                fArr[i2] = fArr[i2] + solverVariable.goalStrengthVector[i2];
                if (Math.abs(fArr[i2]) < 1.0E-4f) {
                    this.variable.goalStrengthVector[i2] = 0.0f;
                }
            }
        }

        public boolean addToGoal(SolverVariable solverVariable, float f2) {
            boolean z = true;
            if (!this.variable.inGoal) {
                for (int i2 = 0; i2 < 9; i2++) {
                    float f3 = solverVariable.goalStrengthVector[i2];
                    if (f3 != 0.0f) {
                        float f4 = f3 * f2;
                        if (Math.abs(f4) < 1.0E-4f) {
                            f4 = 0.0f;
                        }
                        this.variable.goalStrengthVector[i2] = f4;
                    } else {
                        this.variable.goalStrengthVector[i2] = 0.0f;
                    }
                }
                return true;
            }
            for (int i3 = 0; i3 < 9; i3++) {
                float[] fArr = this.variable.goalStrengthVector;
                fArr[i3] = fArr[i3] + (solverVariable.goalStrengthVector[i3] * f2);
                if (Math.abs(fArr[i3]) < 1.0E-4f) {
                    this.variable.goalStrengthVector[i3] = 0.0f;
                } else {
                    z = false;
                }
            }
            if (z) {
                PriorityGoalRow.this.removeGoal(this.variable);
            }
            return false;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.variable.f594id - ((SolverVariable) obj).f594id;
        }

        public void init(SolverVariable solverVariable) {
            this.variable = solverVariable;
        }

        public final boolean isNegative() {
            for (int i2 = 8; i2 >= 0; i2--) {
                float f2 = this.variable.goalStrengthVector[i2];
                if (f2 > 0.0f) {
                    return false;
                }
                if (f2 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isNull() {
            for (int i2 = 0; i2 < 9; i2++) {
                if (this.variable.goalStrengthVector[i2] != 0.0f) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isSmallerThan(SolverVariable solverVariable) {
            int i2 = 8;
            while (true) {
                if (i2 < 0) {
                    break;
                }
                float f2 = solverVariable.goalStrengthVector[i2];
                float f3 = this.variable.goalStrengthVector[i2];
                if (f3 == f2) {
                    i2--;
                } else if (f3 < f2) {
                    return true;
                }
            }
            return false;
        }

        public void reset() {
            Arrays.fill(this.variable.goalStrengthVector, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.variable != null) {
                for (int i2 = 0; i2 < 9; i2++) {
                    str = str + this.variable.goalStrengthVector[i2] + AbstractC1191a.f2568g;
                }
            }
            return str + "] " + this.variable;
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.TABLE_SIZE = 128;
        int i2 = this.TABLE_SIZE;
        this.arrayGoals = new SolverVariable[i2];
        this.sortArray = new SolverVariable[i2];
        this.numGoals = 0;
        this.accessor = new GoalVariableAccessor(this);
        this.mCache = cache;
    }

    private final void addToGoal(SolverVariable solverVariable) {
        int i2;
        int i3 = this.numGoals + 1;
        SolverVariable[] solverVariableArr = this.arrayGoals;
        if (i3 > solverVariableArr.length) {
            this.arrayGoals = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            SolverVariable[] solverVariableArr2 = this.arrayGoals;
            this.sortArray = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.arrayGoals;
        int i4 = this.numGoals;
        solverVariableArr3[i4] = solverVariable;
        this.numGoals = i4 + 1;
        int i5 = this.numGoals;
        if (i5 > 1 && solverVariableArr3[i5 - 1].f594id > solverVariable.f594id) {
            int i6 = 0;
            while (true) {
                i2 = this.numGoals;
                if (i6 >= i2) {
                    break;
                }
                this.sortArray[i6] = this.arrayGoals[i6];
                i6++;
            }
            Arrays.sort(this.sortArray, 0, i2, new Comparator<SolverVariable>() { // from class: androidx.constraintlayout.solver.PriorityGoalRow.1
                @Override // java.util.Comparator
                public int compare(SolverVariable solverVariable2, SolverVariable solverVariable3) {
                    return solverVariable2.f594id - solverVariable3.f594id;
                }
            });
            for (int i7 = 0; i7 < this.numGoals; i7++) {
                this.arrayGoals[i7] = this.sortArray[i7];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeGoal(SolverVariable solverVariable) {
        int i2 = 0;
        while (i2 < this.numGoals) {
            if (this.arrayGoals[i2] == solverVariable) {
                while (true) {
                    int i3 = this.numGoals;
                    if (i2 >= i3 - 1) {
                        this.numGoals = i3 - 1;
                        solverVariable.inGoal = false;
                        return;
                    } else {
                        SolverVariable[] solverVariableArr = this.arrayGoals;
                        int i4 = i2 + 1;
                        solverVariableArr[i2] = solverVariableArr[i4];
                        i2 = i4;
                    }
                }
            } else {
                i2++;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        this.accessor.init(solverVariable);
        this.accessor.reset();
        solverVariable.goalStrengthVector[solverVariable.strength] = 1.0f;
        addToGoal(solverVariable);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void clear() {
        this.numGoals = 0;
        this.constantValue = 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        int i2 = -1;
        for (int i3 = 0; i3 < this.numGoals; i3++) {
            SolverVariable solverVariable = this.arrayGoals[i3];
            if (!zArr[solverVariable.f594id]) {
                this.accessor.init(solverVariable);
                if (i2 == -1) {
                    if (!this.accessor.isNegative()) {
                    }
                    i2 = i3;
                } else {
                    if (!this.accessor.isSmallerThan(this.arrayGoals[i2])) {
                    }
                    i2 = i3;
                }
            }
        }
        if (i2 == -1) {
            return null;
        }
        return this.arrayGoals[i2];
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public boolean isEmpty() {
        return this.numGoals == 0;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow
    public String toString() {
        String str = " goal -> (" + this.constantValue + ") : ";
        for (int i2 = 0; i2 < this.numGoals; i2++) {
            this.accessor.init(this.arrayGoals[i2]);
            str = str + this.accessor + AbstractC1191a.f2568g;
        }
        return str;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow, androidx.constraintlayout.solver.LinearSystem.Row
    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z) {
        SolverVariable solverVariable = arrayRow.variable;
        if (solverVariable == null) {
            return;
        }
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i2 = 0; i2 < currentSize; i2++) {
            SolverVariable variable = arrayRowVariables.getVariable(i2);
            float variableValue = arrayRowVariables.getVariableValue(i2);
            this.accessor.init(variable);
            if (this.accessor.addToGoal(solverVariable, variableValue)) {
                addToGoal(variable);
            }
            this.constantValue += arrayRow.constantValue * variableValue;
        }
        removeGoal(solverVariable);
    }
}
