package com.airbnb.lottie.p106y;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: KeyPath.java */
/* renamed from: com.airbnb.lottie.y.e */
/* loaded from: classes.dex */
public class C1439e {

    /* renamed from: c */
    public static final C1439e f3603c = new C1439e("COMPOSITION");

    /* renamed from: a */
    private final List<String> f3604a;

    /* renamed from: b */
    @Nullable
    private InterfaceC1440f f3605b;

    public C1439e(String... strArr) {
        this.f3604a = Arrays.asList(strArr);
    }

    @CheckResult
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public C1439e m3205a(String str) {
        C1439e c1439e = new C1439e(this);
        c1439e.f3604a.add(str);
        return c1439e;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: b */
    public int m3208b(String str, int i2) {
        if (m3202b(str)) {
            return 0;
        }
        if (this.f3604a.get(i2).equals("**")) {
            return (i2 != this.f3604a.size() - 1 && this.f3604a.get(i2 + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: c */
    public boolean m3210c(String str, int i2) {
        if (m3202b(str)) {
            return true;
        }
        if (i2 >= this.f3604a.size()) {
            return false;
        }
        return this.f3604a.get(i2).equals(str) || this.f3604a.get(i2).equals("**") || this.f3604a.get(i2).equals("*");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: d */
    public boolean m3211d(String str, int i2) {
        return "__container".equals(str) || i2 < this.f3604a.size() - 1 || this.f3604a.get(i2).equals("**");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f3604a);
        sb.append(",resolved=");
        sb.append(this.f3605b != null);
        sb.append('}');
        return sb.toString();
    }

    private C1439e(C1439e c1439e) {
        this.f3604a = new ArrayList(c1439e.f3604a);
        this.f3605b = c1439e.f3605b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public C1439e m3204a(InterfaceC1440f interfaceC1440f) {
        C1439e c1439e = new C1439e(this);
        c1439e.f3605b = interfaceC1440f;
        return c1439e;
    }

    /* renamed from: b */
    private boolean m3202b(String str) {
        return "__container".equals(str);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public InterfaceC1440f m3206a() {
        return this.f3605b;
    }

    /* renamed from: c */
    private boolean m3203c() {
        return this.f3604a.get(r0.size() - 1).equals("**");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public boolean m3207a(String str, int i2) {
        if (i2 >= this.f3604a.size()) {
            return false;
        }
        boolean z = i2 == this.f3604a.size() - 1;
        String str2 = this.f3604a.get(i2);
        if (!str2.equals("**")) {
            return (z || (i2 == this.f3604a.size() + (-2) && m3203c())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z && this.f3604a.get(i2 + 1).equals(str)) {
            return i2 == this.f3604a.size() + (-2) || (i2 == this.f3604a.size() + (-3) && m3203c());
        }
        if (z) {
            return true;
        }
        int i3 = i2 + 1;
        if (i3 < this.f3604a.size() - 1) {
            return false;
        }
        return this.f3604a.get(i3).equals(str);
    }

    /* renamed from: b */
    public String m3209b() {
        return this.f3604a.toString();
    }
}
