package i.n2;

import i.g2.g0;
import i.q2.t.i0;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: FilePathComponents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    @j.c.a.d
    private final File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @j.c.a.d
    private final List<File> f12171b;

    /* JADX WARN: Multi-variable type inference failed */
    public i(@j.c.a.d File file, @j.c.a.d List<? extends File> list) {
        i0.f(file, "root");
        i0.f(list, "segments");
        this.a = file;
        this.f12171b = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ i a(i iVar, File file, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            file = iVar.a;
        }
        if ((i2 & 2) != 0) {
            list = iVar.f12171b;
        }
        return iVar.a(file, (List<? extends File>) list);
    }

    @j.c.a.d
    public final i a(@j.c.a.d File file, @j.c.a.d List<? extends File> list) {
        i0.f(file, "root");
        i0.f(list, "segments");
        return new i(file, list);
    }

    @j.c.a.d
    public final File a() {
        return this.a;
    }

    @j.c.a.d
    public final File a(int i2, int i3) {
        if (i2 < 0 || i2 > i3 || i3 > f()) {
            throw new IllegalArgumentException();
        }
        List<File> listSubList = this.f12171b.subList(i2, i3);
        String str = File.separator;
        i0.a((Object) str, "File.separator");
        return new File(g0.a(listSubList, str, null, null, 0, null, null, 62, null));
    }

    @j.c.a.d
    public final List<File> b() {
        return this.f12171b;
    }

    @j.c.a.d
    public final File c() {
        return this.a;
    }

    @j.c.a.d
    public final String d() {
        String path = this.a.getPath();
        i0.a((Object) path, "root.path");
        return path;
    }

    @j.c.a.d
    public final List<File> e() {
        return this.f12171b;
    }

    public boolean equals(@j.c.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return i0.a(this.a, iVar.a) && i0.a(this.f12171b, iVar.f12171b);
    }

    public final int f() {
        return this.f12171b.size();
    }

    public final boolean g() {
        String path = this.a.getPath();
        i0.a((Object) path, "root.path");
        return path.length() > 0;
    }

    public int hashCode() {
        File file = this.a;
        int iHashCode = (file != null ? file.hashCode() : 0) * 31;
        List<File> list = this.f12171b;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    @j.c.a.d
    public String toString() {
        return "FilePathComponents(root=" + this.a + ", segments=" + this.f12171b + ")";
    }
}
