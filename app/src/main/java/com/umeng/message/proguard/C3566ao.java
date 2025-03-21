package com.umeng.message.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.umeng.message.common.UPLog;

/* renamed from: com.umeng.message.proguard.ao */
/* loaded from: classes2.dex */
public final class C3566ao {

    /* renamed from: b */
    private static C3566ao f13219b;

    /* renamed from: a */
    public final Context f13220a;

    private C3566ao(Context context) {
        this.f13220a = context.getApplicationContext();
    }

    /* renamed from: a */
    public static C3566ao m12272a(Context context) {
        if (f13219b == null) {
            f13219b = new C3566ao(context);
        }
        return f13219b;
    }

    /* renamed from: com.umeng.message.proguard.ao$a */
    public static class a {

        /* renamed from: a */
        public String f13221a;

        /* renamed from: b */
        public long f13222b;

        /* renamed from: c */
        public int f13223c;

        public a(String str, int i2, long j2) {
            this.f13221a = str;
            this.f13223c = i2;
            this.f13222b = j2;
        }

        /* renamed from: a */
        public final ContentValues m12274a() {
            ContentValues contentValues = new ContentValues();
            contentValues.put("MsgId", this.f13221a);
            contentValues.put("Time", Long.valueOf(this.f13222b));
            contentValues.put("ActionType", Integer.valueOf(this.f13223c));
            return contentValues;
        }

        public a(Cursor cursor) {
            this.f13221a = cursor.getString(cursor.getColumnIndex("MsgId"));
            this.f13222b = cursor.getLong(cursor.getColumnIndex("Time"));
            this.f13223c = cursor.getInt(cursor.getColumnIndex("ActionType"));
        }
    }

    /* renamed from: a */
    public final void m12273a(String str, int i2, long j2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.f13220a.getContentResolver().insert(C3588h.m12405d(this.f13220a), new a(str, i2, j2).m12274a());
        } catch (Exception e2) {
            UPLog.m12143e("MsgLog", e2);
        }
    }
}
