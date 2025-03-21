package p358k.p359a.p360a.p361a.p362i;

import android.content.Context;
import p358k.p359a.p360a.p361a.p363j.C5863e;

/* compiled from: PropertiesGrade.java */
/* renamed from: k.a.a.a.i.b */
/* loaded from: classes2.dex */
public class C5856b implements InterfaceC5855a {
    /* renamed from: a */
    private void m24652a(Context context, int i2) {
    }

    @Override // p358k.p359a.p360a.p361a.p362i.InterfaceC5855a
    /* renamed from: a */
    public void mo24651a(Context context, int i2, int i3) {
        if (i2 >= i3) {
            C5863e.m24691a("PropertiesGrade", "newVersion is less then oldVersion, onUpgrade error", true);
        } else {
            C5863e.m24692b("PropertiesGrade", "update settings.properties when version update", true);
            m24652a(context, i2);
        }
    }
}
