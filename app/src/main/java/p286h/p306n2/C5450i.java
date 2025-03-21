package p286h.p306n2;

import java.io.File;
import java.util.List;
import p286h.p289g2.C5262g0;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: FilePathComponents.kt */
/* renamed from: h.n2.i */
/* loaded from: classes2.dex */
public final class C5450i {

    /* renamed from: a */
    @InterfaceC5816d
    private final File f20317a;

    /* renamed from: b */
    @InterfaceC5816d
    private final List<File> f20318b;

    /* JADX WARN: Multi-variable type inference failed */
    public C5450i(@InterfaceC5816d File file, @InterfaceC5816d List<? extends File> list) {
        C5544i0.m22546f(file, "root");
        C5544i0.m22546f(list, "segments");
        this.f20317a = file;
        this.f20318b = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static /* synthetic */ C5450i m22306a(C5450i c5450i, File file, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            file = c5450i.f20317a;
        }
        if ((i2 & 2) != 0) {
            list = c5450i.f20318b;
        }
        return c5450i.m22307a(file, (List<? extends File>) list);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final C5450i m22307a(@InterfaceC5816d File file, @InterfaceC5816d List<? extends File> list) {
        C5544i0.m22546f(file, "root");
        C5544i0.m22546f(list, "segments");
        return new C5450i(file, list);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final File m22308a() {
        return this.f20317a;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final File m22309a(int i2, int i3) {
        if (i2 < 0 || i2 > i3 || i3 > m22314f()) {
            throw new IllegalArgumentException();
        }
        List<File> subList = this.f20318b.subList(i2, i3);
        String str = File.separator;
        C5544i0.m22521a((Object) str, "File.separator");
        return new File(C5262g0.m19786a(subList, str, null, null, 0, null, null, 62, null));
    }

    @InterfaceC5816d
    /* renamed from: b */
    public final List<File> m22310b() {
        return this.f20318b;
    }

    @InterfaceC5816d
    /* renamed from: c */
    public final File m22311c() {
        return this.f20317a;
    }

    @InterfaceC5816d
    /* renamed from: d */
    public final String m22312d() {
        String path = this.f20317a.getPath();
        C5544i0.m22521a((Object) path, "root.path");
        return path;
    }

    @InterfaceC5816d
    /* renamed from: e */
    public final List<File> m22313e() {
        return this.f20318b;
    }

    public boolean equals(@InterfaceC5817e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5450i)) {
            return false;
        }
        C5450i c5450i = (C5450i) obj;
        return C5544i0.m22531a(this.f20317a, c5450i.f20317a) && C5544i0.m22531a(this.f20318b, c5450i.f20318b);
    }

    /* renamed from: f */
    public final int m22314f() {
        return this.f20318b.size();
    }

    /* renamed from: g */
    public final boolean m22315g() {
        String path = this.f20317a.getPath();
        C5544i0.m22521a((Object) path, "root.path");
        return path.length() > 0;
    }

    public int hashCode() {
        File file = this.f20317a;
        int hashCode = (file != null ? file.hashCode() : 0) * 31;
        List<File> list = this.f20318b;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    @InterfaceC5816d
    public String toString() {
        return "FilePathComponents(root=" + this.f20317a + ", segments=" + this.f20318b + ")";
    }
}
