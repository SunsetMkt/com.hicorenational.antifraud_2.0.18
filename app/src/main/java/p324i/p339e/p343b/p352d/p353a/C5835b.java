package p324i.p339e.p343b.p352d.p353a;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;

/* compiled from: DataBaseOperation.java */
/* renamed from: i.e.b.d.a.b */
/* loaded from: classes2.dex */
public class C5835b {

    /* renamed from: b */
    private static final String f20997b = "VMS_SDK_DB";

    /* renamed from: c */
    private static final String f20998c = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* renamed from: d */
    private static final String f20999d = "content://com.vivo.abe.exidentifier/guid";

    /* renamed from: e */
    private static final String f21000e = "value";

    /* renamed from: f */
    private static final String f21001f = "OAID";

    /* renamed from: g */
    private static final String f21002g = "AAID";

    /* renamed from: h */
    private static final String f21003h = "VAID";

    /* renamed from: i */
    private static final String f21004i = "OAIDBLACK";

    /* renamed from: j */
    private static final String f21005j = "OAIDSTATUS";

    /* renamed from: k */
    private static final String f21006k = "STATISTICS";

    /* renamed from: l */
    private static final int f21007l = 0;

    /* renamed from: m */
    private static final int f21008m = 1;

    /* renamed from: n */
    private static final int f21009n = 2;

    /* renamed from: o */
    private static final int f21010o = 3;

    /* renamed from: p */
    private static final int f21011p = 4;

    /* renamed from: q */
    private static final int f21012q = 5;

    /* renamed from: r */
    private static final int f21013r = 6;

    /* renamed from: s */
    private static final int f21014s = 7;

    /* renamed from: t */
    private static final String f21015t = "UDID";

    /* renamed from: a */
    private Context f21016a;

    C5835b(Context context) {
        this.f21016a = context;
    }

    /* renamed from: a */
    boolean m24486a(int i2, String str, ContentValues[] contentValuesArr) {
        Uri parse;
        int bulkInsert;
        if (i2 == 6) {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        } else if (i2 != 7) {
            parse = null;
        } else {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/STATISTICS_" + str);
        }
        if (parse == null) {
            return false;
        }
        try {
            bulkInsert = this.f21016a.getContentResolver().bulkInsert(parse, contentValuesArr);
            String str2 = "insert:" + bulkInsert;
        } catch (Exception unused) {
        }
        return bulkInsert != 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0092, code lost:
    
        if (r8 != null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0094, code lost:
    
        r8.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a4, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a1, code lost:
    
        if (r8 == null) goto L42;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String m24484a(int r8, java.lang.String r9) {
        /*
            r7 = this;
            r0 = 0
            if (r8 == 0) goto L64
            r1 = 1
            if (r8 == r1) goto L4e
            r1 = 2
            if (r8 == r1) goto L38
            r1 = 3
            if (r8 == r1) goto L31
            r1 = 4
            if (r8 == r1) goto L1b
            r9 = 5
            if (r8 == r9) goto L14
            r2 = r0
            goto L6b
        L14:
            java.lang.String r8 = "content://com.vivo.abe.exidentifier/guid"
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L6a
        L1b:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS_"
            r8.append(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L6a
        L31:
            java.lang.String r8 = "content://com.vivo.vms.IdProvider/IdentifierId/UDID"
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L6a
        L38:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            r8.append(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L6a
        L4e:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
            r8.append(r1)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            android.net.Uri r8 = android.net.Uri.parse(r8)
            goto L6a
        L64:
            java.lang.String r8 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
            android.net.Uri r8 = android.net.Uri.parse(r8)
        L6a:
            r2 = r8
        L6b:
            if (r2 != 0) goto L6e
            return r0
        L6e:
            android.content.Context r8 = r7.f21016a     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L98 java.lang.Exception -> La0
            if (r8 == 0) goto L92
            boolean r9 = r8.moveToNext()     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> La1
            if (r9 == 0) goto L92
            java.lang.String r9 = "value"
            int r9 = r8.getColumnIndex(r9)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> La1
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.Throwable -> L90 java.lang.Exception -> La1
            r0 = r9
            goto L92
        L90:
            r9 = move-exception
            goto L9a
        L92:
            if (r8 == 0) goto La4
        L94:
            r8.close()
            goto La4
        L98:
            r9 = move-exception
            r8 = r0
        L9a:
            if (r8 == 0) goto L9f
            r8.close()
        L9f:
            throw r9
        La0:
            r8 = r0
        La1:
            if (r8 == 0) goto La4
            goto L94
        La4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p324i.p339e.p343b.p352d.p353a.C5835b.m24484a(int, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    boolean m24485a(int i2, String str, String str2, String str3) {
        Uri parse;
        int delete;
        if (i2 != 6) {
            parse = null;
        } else {
            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        }
        if (parse == null) {
            return false;
        }
        try {
            delete = this.f21016a.getContentResolver().delete(parse, "packageName=? and uid=?", new String[]{str2, str3});
            String str4 = "delete:" + delete;
        } catch (Exception unused) {
        }
        return delete != 0;
    }
}
