package j.a.a.a.m;

/* JADX INFO: compiled from: AbstractCaverphone.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements j.a.a.a.i {
    public boolean a(String str, String str2) throws j.a.a.a.g {
        return a(str).equals(a(str2));
    }

    @Override // j.a.a.a.f
    public Object encode(Object obj) throws j.a.a.a.g {
        if (obj instanceof String) {
            return a((String) obj);
        }
        throw new j.a.a.a.g("Parameter supplied to Caverphone encode is not of type java.lang.String");
    }
}
