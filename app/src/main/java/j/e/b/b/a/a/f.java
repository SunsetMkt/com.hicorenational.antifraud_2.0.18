package j.e.b.b.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import bean.SurveyH5Bean;

/* JADX INFO: loaded from: classes2.dex */
class f {

    /* JADX INFO: renamed from: g */
    private static volatile f f12569g = null;

    /* JADX INFO: renamed from: h */
    private static boolean f12570h = false;

    /* JADX INFO: renamed from: f */
    private BroadcastReceiver f12575f;
    a a = new a("udid");

    /* JADX INFO: renamed from: b */
    a f12571b = new a("oaid");

    /* JADX INFO: renamed from: d */
    a f12573d = new a("vaid");

    /* JADX INFO: renamed from: c */
    a f12572c = new a("aaid");

    /* JADX INFO: renamed from: e */
    private c f12574e = new c();

    private f() {
    }

    private static d a(Cursor cursor) {
        String str;
        d dVar = new d(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(SurveyH5Bean.VALUE);
                if (columnIndex >= 0) {
                    dVar.a = cursor.getString(columnIndex);
                } else {
                    a("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    dVar.f12567b = cursor.getInt(columnIndex2);
                } else {
                    a("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    dVar.f12568c = cursor.getLong(columnIndex3);
                } else {
                    a("parseExpired fail, index < 0.");
                }
                return dVar;
            }
            str = "parseValue fail, cursor is closed.";
        }
        a(str);
        return dVar;
    }

    public static final f a() {
        if (f12569g == null) {
            synchronized (f.class) {
                if (f12569g == null) {
                    f12569g = new f();
                }
            }
        }
        return f12569g;
    }

    private static String a(PackageManager packageManager, String str) {
        ProviderInfo providerInfoResolveContentProvider;
        if (packageManager == null || (providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (providerInfoResolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return providerInfoResolveContentProvider.packageName;
    }

    static void a(String str) {
        boolean z = f12570h;
    }

    public static void a(boolean z) {
        f12570h = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(Context context) {
        boolean z;
        a("querySupport version : 1.0.8");
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"supported"}, null);
            } catch (Exception e2) {
                a("querySupport, Exception : " + e2.getMessage());
                if (cursorQuery != null) {
                }
            }
            if (cursorQuery == null) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return false;
            }
            d dVarA = a(cursorQuery);
            if (1000 == dVarA.f12567b) {
                z = "0".equals(dVarA.a);
            }
            return z;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0095  */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v6, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String b(Context context, a aVar) throws Throwable {
        String str;
        ?? Query;
        String str2;
        String strConcat;
        a("queryId : " + aVar.f12563c);
        ?? r0 = 0;
        str = null;
        String str3 = null;
        String str4 = null;
        ?? r02 = 0;
        try {
            try {
                Query = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{aVar.f12563c}, null);
                try {
                    if (Query != 0) {
                        d dVarA = a((Cursor) Query);
                        String str5 = dVarA.a;
                        aVar.a(str5);
                        aVar.a(dVarA.f12568c);
                        aVar.a(dVarA.f12567b);
                        a(aVar.f12563c + " errorCode : " + aVar.f12564d);
                        str3 = str5;
                        if (dVarA.f12567b != 1000) {
                            b(context);
                            str3 = str5;
                            if (!a(context, false)) {
                                strConcat = "not support, forceQuery isSupported: ".concat(String.valueOf(a(context, true)));
                                str4 = str5;
                                a(strConcat);
                                str3 = str4;
                            }
                        }
                        if (Query != 0) {
                            Query.close();
                        }
                        str2 = str3;
                        r0 = str3;
                    } else {
                        if (a(context, false)) {
                            strConcat = "forceQuery isSupported : ".concat(String.valueOf(a(context, true)));
                            a(strConcat);
                            str3 = str4;
                        }
                        if (Query != 0) {
                        }
                        str2 = str3;
                        r0 = str3;
                    }
                } catch (Exception e2) {
                    e = e2;
                    str = str4;
                    r02 = Query;
                    a("queryId, Exception : " + e.getMessage());
                    r0 = r02;
                    str2 = str;
                    if (r02 != 0) {
                        r02.close();
                        r0 = r02;
                        str2 = str;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (Query != 0) {
                        Query.close();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                str = null;
            }
            return str2;
        } catch (Throwable th2) {
            th = th2;
            Query = r0;
        }
    }

    private static String b(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            a("getAppVersion, Exception : " + e2.getMessage());
            return null;
        }
    }

    private synchronized void b(Context context) {
        if (this.f12575f != null) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
        this.f12575f = new e();
        context.registerReceiver(this.f12575f, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
    }

    final String a(Context context, a aVar) {
        String str;
        if (aVar == null) {
            str = "getId, openId = null.";
        } else {
            if (aVar.a()) {
                return aVar.f12562b;
            }
            if (a(context, true)) {
                return b(context, aVar);
            }
            str = "getId, isSupported = false.";
        }
        a(str);
        return null;
    }

    final boolean a(Context context, boolean z) {
        if (this.f12574e.a() && !z) {
            return this.f12574e.b();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        String strA = a(packageManager, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        String strB = b(packageManager, strA);
        if (this.f12574e.a() && this.f12574e.a(strB)) {
            a("use same version cache, safeVersion : ".concat(String.valueOf(strB)));
            return this.f12574e.b();
        }
        this.f12574e.b(strB);
        boolean zA = a(context);
        a("query support, result : ".concat(String.valueOf(zA)));
        this.f12574e.a(zA);
        return zA;
    }
}
