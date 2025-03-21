package p324i.p339e.p343b.p347b.p348a.p349a;

import android.text.TextUtils;

/* renamed from: i.e.b.b.a.a.c */
/* loaded from: classes2.dex */
class C5828c {

    /* renamed from: a */
    String f20965a;

    /* renamed from: b */
    Boolean f20966b;

    C5828c() {
    }

    /* renamed from: a */
    void m24462a(boolean z) {
        this.f20966b = Boolean.valueOf(z);
    }

    /* renamed from: a */
    boolean m24463a() {
        return this.f20966b != null;
    }

    /* renamed from: a */
    boolean m24464a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.f20965a, str);
    }

    /* renamed from: b */
    void m24465b(String str) {
        this.f20965a = str;
    }

    /* renamed from: b */
    boolean m24466b() {
        Boolean bool = this.f20966b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
