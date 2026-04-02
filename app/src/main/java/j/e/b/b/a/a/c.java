package j.e.b.b.a.a;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
class c {
    String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Boolean f12566b;

    c() {
    }

    void a(boolean z) {
        this.f12566b = Boolean.valueOf(z);
    }

    boolean a() {
        return this.f12566b != null;
    }

    boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(this.a, str);
    }

    void b(String str) {
        this.a = str;
    }

    boolean b() {
        Boolean bool = this.f12566b;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
