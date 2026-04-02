package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import bean.SurveyH5Bean;

/* JADX INFO: loaded from: classes2.dex */
class aq implements ai {
    private static String a = "content://com.vivo.vms.IdProvider/IdentifierId/";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f8751b = a + "OAID";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f8752c = a + "VAID_";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f8753d = a + "AAID_";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static String f8754e = a + "OAIDSTATUS";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static String f8755f = "persist.sys.identifierid.supported";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f194a;

    public aq(Context context) {
        this.f194a = context;
    }

    @Override // com.xiaomi.push.ai
    /* JADX INFO: renamed from: a */
    public boolean mo135a() {
        return "1".equals(q.a(f8755f, "0"));
    }

    @Override // com.xiaomi.push.ai
    /* JADX INFO: renamed from: a */
    public String mo134a() {
        return a(f8751b);
    }

    private String a(String str) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        string = null;
        string = null;
        string = null;
        String string = null;
        try {
            cursorQuery = this.f194a.getContentResolver().query(Uri.parse(str), null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToNext()) {
                        string = cursorQuery.getString(cursorQuery.getColumnIndex(SurveyH5Bean.VALUE));
                    }
                } catch (Exception unused) {
                    if (cursorQuery != null) {
                    }
                    return string;
                } catch (Throwable th) {
                    cursor = cursorQuery;
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (Exception unused2) {
            cursorQuery = null;
        } catch (Throwable th2) {
            th = th2;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return string;
    }

    public static boolean a(Context context) {
        try {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(Uri.parse(a).getAuthority(), 128);
            if (providerInfoResolveContentProvider != null) {
                if ((providerInfoResolveContentProvider.applicationInfo.flags & 1) != 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
