package j.e.b.d.a;

import android.database.ContentObserver;

/* JADX INFO: compiled from: IdentifierIdObserver.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends ContentObserver {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f12618d = "VMS_SDK_Observer";
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f12620c;

    d(c cVar, int i2, String str) {
        super(null);
        this.f12620c = cVar;
        this.f12619b = i2;
        this.a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        c cVar = this.f12620c;
        if (cVar != null) {
            cVar.a(this.f12619b, this.a);
        }
    }
}
