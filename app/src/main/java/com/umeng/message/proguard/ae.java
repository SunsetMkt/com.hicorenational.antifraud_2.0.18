package com.umeng.message.proguard;

import android.content.ContentValues;
import android.database.Cursor;

/* JADX INFO: loaded from: classes2.dex */
public final class ae {
    long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    String f7947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f7948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7949d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7950e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7952g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f7953h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f7954i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f7955j;

    public ae(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.a = System.currentTimeMillis();
        this.f7947b = str;
        this.f7948c = i2;
        this.f7949d = i3;
        this.f7950e = i4;
        this.f7951f = i5;
        this.f7952g = i6;
        this.f7953h = i7;
        this.f7954i = i8;
        this.f7955j = i9;
    }

    public final ContentValues a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Time", Long.valueOf(this.a));
        contentValues.put("MsgId", this.f7947b);
        contentValues.put("MsgType", Integer.valueOf(this.f7948c));
        contentValues.put("NumDisplay", Integer.valueOf(this.f7949d));
        contentValues.put("NumOpenFull", Integer.valueOf(this.f7950e));
        contentValues.put("NumOpenTop", Integer.valueOf(this.f7951f));
        contentValues.put("NumOpenBottom", Integer.valueOf(this.f7952g));
        contentValues.put("NumClose", Integer.valueOf(this.f7953h));
        contentValues.put("NumDuration", Integer.valueOf(this.f7954i));
        contentValues.put("NumCustom", Integer.valueOf(this.f7955j));
        return contentValues;
    }

    public ae(Cursor cursor) {
        this.f7947b = cursor.getString(cursor.getColumnIndex("MsgId"));
        this.f7948c = cursor.getInt(cursor.getColumnIndex("MsgType"));
        this.f7949d = cursor.getInt(cursor.getColumnIndex("NumDisplay"));
        this.f7950e = cursor.getInt(cursor.getColumnIndex("NumOpenFull"));
        this.f7951f = cursor.getInt(cursor.getColumnIndex("NumOpenTop"));
        this.f7952g = cursor.getInt(cursor.getColumnIndex("NumOpenBottom"));
        this.f7953h = cursor.getInt(cursor.getColumnIndex("NumClose"));
        this.f7954i = cursor.getInt(cursor.getColumnIndex("NumDuration"));
        this.f7955j = cursor.getInt(cursor.getColumnIndex("NumCustom"));
    }
}
