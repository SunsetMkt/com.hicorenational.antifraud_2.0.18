package com.airbnb.lottie.y;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: KeyPath.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: c */
    public static final e f2420c = new e("COMPOSITION");
    private final List<String> a;

    /* JADX INFO: renamed from: b */
    @Nullable
    private f f2421b;

    public e(String... strArr) {
        this.a = Arrays.asList(strArr);
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e a(String str) {
        e eVar = new e(this);
        eVar.a.add(str);
        return eVar;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int b(String str, int i2) {
        if (b(str)) {
            return 0;
        }
        if (this.a.get(i2).equals("**")) {
            return (i2 != this.a.size() - 1 && this.a.get(i2 + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean c(String str, int i2) {
        if (b(str)) {
            return true;
        }
        if (i2 >= this.a.size()) {
            return false;
        }
        return this.a.get(i2).equals(str) || this.a.get(i2).equals("**") || this.a.get(i2).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean d(String str, int i2) {
        return "__container".equals(str) || i2 < this.a.size() - 1 || this.a.get(i2).equals("**");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.a);
        sb.append(",resolved=");
        sb.append(this.f2421b != null);
        sb.append('}');
        return sb.toString();
    }

    private e(e eVar) {
        this.a = new ArrayList(eVar.a);
        this.f2421b = eVar.f2421b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public e a(f fVar) {
        e eVar = new e(this);
        eVar.f2421b = fVar;
        return eVar;
    }

    private boolean b(String str) {
        return "__container".equals(str);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public f a() {
        return this.f2421b;
    }

    private boolean c() {
        return this.a.get(r0.size() - 1).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean a(String str, int i2) {
        if (i2 >= this.a.size()) {
            return false;
        }
        boolean z = i2 == this.a.size() - 1;
        String str2 = this.a.get(i2);
        if (!str2.equals("**")) {
            return (z || (i2 == this.a.size() + (-2) && c())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.a.get(i2 + 1).equals(str)) {
            return i2 == this.a.size() + (-2) || (i2 == this.a.size() + (-3) && c());
        }
        if (z) {
            return true;
        }
        int i3 = i2 + 1;
        if (i3 < this.a.size() - 1) {
            return false;
        }
        return this.a.get(i3).equals(str);
    }

    public String b() {
        return this.a.toString();
    }
}
