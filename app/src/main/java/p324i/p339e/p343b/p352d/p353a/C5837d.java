package p324i.p339e.p343b.p352d.p353a;

import android.database.ContentObserver;

/* compiled from: IdentifierIdObserver.java */
/* renamed from: i.e.b.d.a.d */
/* loaded from: classes2.dex */
public class C5837d extends ContentObserver {

    /* renamed from: d */
    private static final String f21073d = "VMS_SDK_Observer";

    /* renamed from: a */
    private String f21074a;

    /* renamed from: b */
    private int f21075b;

    /* renamed from: c */
    private C5836c f21076c;

    C5837d(C5836c c5836c, int i2, String str) {
        super(null);
        this.f21076c = c5836c;
        this.f21075b = i2;
        this.f21074a = str;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C5836c c5836c = this.f21076c;
        if (c5836c != null) {
            c5836c.m24538a(this.f21075b, this.f21074a);
        }
    }
}
