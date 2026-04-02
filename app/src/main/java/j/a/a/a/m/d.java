package j.a.a.a.m;

/* JADX INFO: compiled from: Caverphone.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements j.a.a.a.i {
    private final c a = new c();

    @Override // j.a.a.a.i
    public String a(String str) {
        return b(str);
    }

    public String b(String str) {
        return this.a.a(str);
    }

    @Override // j.a.a.a.f
    public Object encode(Object obj) throws j.a.a.a.g {
        if (obj instanceof String) {
            return b((String) obj);
        }
        throw new j.a.a.a.g("Parameter supplied to Caverphone encode is not of type java.lang.String");
    }

    public boolean a(String str, String str2) {
        return b(str).equals(b(str2));
    }
}
