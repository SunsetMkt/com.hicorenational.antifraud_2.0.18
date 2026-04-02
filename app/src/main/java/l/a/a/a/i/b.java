package l.a.a.a.i;

import android.content.Context;
import l.a.a.a.j.e;

/* JADX INFO: compiled from: PropertiesGrade.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements a {
    private void a(Context context, int i2) {
    }

    @Override // l.a.a.a.i.a
    public void a(Context context, int i2, int i3) {
        if (i2 >= i3) {
            e.a("PropertiesGrade", "newVersion is less then oldVersion, onUpgrade error", true);
        } else {
            e.b("PropertiesGrade", "update settings.properties when version update", true);
            a(context, i2);
        }
    }
}
