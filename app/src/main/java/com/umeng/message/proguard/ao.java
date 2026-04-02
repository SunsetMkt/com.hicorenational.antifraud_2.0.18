package com.umeng.message.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.umeng.message.common.UPLog;

/* JADX INFO: loaded from: classes2.dex */
public final class ao {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ao f7995b;
    public final Context a;

    private ao(Context context) {
        this.a = context.getApplicationContext();
    }

    public static ao a(Context context) {
        if (f7995b == null) {
            f7995b = new ao(context);
        }
        return f7995b;
    }

    public static class a {
        public String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f7996b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7997c;

        public a(String str, int i2, long j2) {
            this.a = str;
            this.f7997c = i2;
            this.f7996b = j2;
        }

        public final ContentValues a() {
            ContentValues contentValues = new ContentValues();
            contentValues.put("MsgId", this.a);
            contentValues.put("Time", Long.valueOf(this.f7996b));
            contentValues.put("ActionType", Integer.valueOf(this.f7997c));
            return contentValues;
        }

        public a(Cursor cursor) {
            this.a = cursor.getString(cursor.getColumnIndex("MsgId"));
            this.f7996b = cursor.getLong(cursor.getColumnIndex("Time"));
            this.f7997c = cursor.getInt(cursor.getColumnIndex("ActionType"));
        }
    }

    public final void a(String str, int i2, long j2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.a.getContentResolver().insert(h.d(this.a), new a(str, i2, j2).a());
        } catch (Exception e2) {
            UPLog.e("MsgLog", e2);
        }
    }
}
