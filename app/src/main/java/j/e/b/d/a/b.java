package j.e.b.d.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* JADX INFO: compiled from: DataBaseOperation.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f12592b = "VMS_SDK_DB";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f12593c = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f12594d = "content://com.vivo.abe.exidentifier/guid";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f12595e = "value";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f12596f = "OAID";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f12597g = "AAID";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f12598h = "VAID";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f12599i = "OAIDBLACK";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f12600j = "OAIDSTATUS";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f12601k = "STATISTICS";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f12602l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f12603m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f12604n = 2;
    private static final int o = 3;
    private static final int p = 4;
    private static final int q = 5;
    private static final int r = 6;
    private static final int s = 7;
    private static final String t = "UDID";
    private Context a;

    b(Context context) {
        this.a = context;
    }

    boolean a(int i2, String str, ContentValues[] contentValuesArr) {
        Uri uri;
        int iBulkInsert;
        if (i2 == 6) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        } else if (i2 != 7) {
            uri = null;
        } else {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/STATISTICS_" + str);
        }
        if (uri == null) {
            return false;
        }
        try {
            iBulkInsert = this.a.getContentResolver().bulkInsert(uri, contentValuesArr);
            String str2 = "insert:" + iBulkInsert;
        } catch (Exception unused) {
        }
        return iBulkInsert != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x006e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    String a(int i2, String str) throws Throwable {
        Uri uri;
        Uri uri2;
        Cursor cursorQuery;
        String string = null;
        if (i2 == 0) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        } else if (i2 == 1) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
        } else if (i2 == 2) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
        } else if (i2 == 3) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/UDID");
        } else if (i2 == 4) {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS_" + str);
        } else {
            if (i2 != 5) {
                uri2 = null;
                if (uri2 != null) {
                    return null;
                }
                try {
                    cursorQuery = this.a.getContentResolver().query(uri2, null, null, null, null);
                    if (cursorQuery != null) {
                        try {
                            if (cursorQuery.moveToNext()) {
                                string = cursorQuery.getString(cursorQuery.getColumnIndex("value"));
                            }
                        } catch (Exception unused) {
                            if (cursorQuery != null) {
                            }
                            return string;
                        } catch (Throwable th) {
                            th = th;
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            throw th;
                        }
                    }
                } catch (Exception unused2) {
                    cursorQuery = null;
                } catch (Throwable th2) {
                    th = th2;
                    cursorQuery = null;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return string;
            }
            uri = Uri.parse(f12594d);
        }
        uri2 = uri;
        if (uri2 != null) {
        }
    }

    boolean a(int i2, String str, String str2, String str3) {
        Uri uri;
        int iDelete;
        if (i2 != 6) {
            uri = null;
        } else {
            uri = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAIDBLACK_" + str);
        }
        if (uri == null) {
            return false;
        }
        try {
            iDelete = this.a.getContentResolver().delete(uri, "packageName=? and uid=?", new String[]{str2, str3});
            String str4 = "delete:" + iDelete;
        } catch (Exception unused) {
        }
        return iDelete != 0;
    }
}
