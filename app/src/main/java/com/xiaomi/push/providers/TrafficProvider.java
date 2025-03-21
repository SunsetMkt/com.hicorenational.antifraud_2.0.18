package com.xiaomi.push.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.C3397d;
import com.xiaomi.push.C4232fz;

/* loaded from: classes2.dex */
public class TrafficProvider extends ContentProvider {

    /* renamed from: a */
    private SQLiteOpenHelper f16391a;

    /* renamed from: a */
    public static final Uri f16390a = Uri.parse("content://com.xiaomi.push.providers.TrafficProvider/traffic");

    /* renamed from: a */
    private static final UriMatcher f16389a = new UriMatcher(-1);

    static {
        f16389a.addURI("com.xiaomi.push.providers.TrafficProvider", C3397d.f11880F, 1);
        f16389a.addURI("com.xiaomi.push.providers.TrafficProvider", "update_imsi", 2);
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        if (f16389a.match(uri) == 1) {
            return "vnd.android.cursor.dir/vnd.xiaomi.push.traffic";
        }
        throw new IllegalArgumentException("Unknown URI " + uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f16391a = new C4307a(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor query;
        synchronized (C4307a.f16393a) {
            if (f16389a.match(uri) != 1) {
                throw new IllegalArgumentException("Unknown URI " + uri);
            }
            query = this.f16391a.getReadableDatabase().query(C3397d.f11880F, strArr, str, strArr2, null, null, str2);
        }
        return query;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (f16389a.match(uri) != 2 || contentValues == null || !contentValues.containsKey(Constants.KEY_IMSI)) {
            return 0;
        }
        C4232fz.m14920a(contentValues.getAsString(Constants.KEY_IMSI));
        return 0;
    }
}
