package com.umeng.message.proguard;

import android.content.ContentValues;
import android.database.Cursor;

/* renamed from: com.umeng.message.proguard.ae */
/* loaded from: classes2.dex */
public final class C3556ae {

    /* renamed from: a */
    long f13154a;

    /* renamed from: b */
    String f13155b;

    /* renamed from: c */
    int f13156c;

    /* renamed from: d */
    public int f13157d;

    /* renamed from: e */
    public int f13158e;

    /* renamed from: f */
    public int f13159f;

    /* renamed from: g */
    public int f13160g;

    /* renamed from: h */
    public int f13161h;

    /* renamed from: i */
    public int f13162i;

    /* renamed from: j */
    public int f13163j;

    public C3556ae(String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        this.f13154a = System.currentTimeMillis();
        this.f13155b = str;
        this.f13156c = i2;
        this.f13157d = i3;
        this.f13158e = i4;
        this.f13159f = i5;
        this.f13160g = i6;
        this.f13161h = i7;
        this.f13162i = i8;
        this.f13163j = i9;
    }

    /* renamed from: a */
    public final ContentValues m12230a() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("Time", Long.valueOf(this.f13154a));
        contentValues.put("MsgId", this.f13155b);
        contentValues.put("MsgType", Integer.valueOf(this.f13156c));
        contentValues.put("NumDisplay", Integer.valueOf(this.f13157d));
        contentValues.put("NumOpenFull", Integer.valueOf(this.f13158e));
        contentValues.put("NumOpenTop", Integer.valueOf(this.f13159f));
        contentValues.put("NumOpenBottom", Integer.valueOf(this.f13160g));
        contentValues.put("NumClose", Integer.valueOf(this.f13161h));
        contentValues.put("NumDuration", Integer.valueOf(this.f13162i));
        contentValues.put("NumCustom", Integer.valueOf(this.f13163j));
        return contentValues;
    }

    public C3556ae(Cursor cursor) {
        this.f13155b = cursor.getString(cursor.getColumnIndex("MsgId"));
        this.f13156c = cursor.getInt(cursor.getColumnIndex("MsgType"));
        this.f13157d = cursor.getInt(cursor.getColumnIndex("NumDisplay"));
        this.f13158e = cursor.getInt(cursor.getColumnIndex("NumOpenFull"));
        this.f13159f = cursor.getInt(cursor.getColumnIndex("NumOpenTop"));
        this.f13160g = cursor.getInt(cursor.getColumnIndex("NumOpenBottom"));
        this.f13161h = cursor.getInt(cursor.getColumnIndex("NumClose"));
        this.f13162i = cursor.getInt(cursor.getColumnIndex("NumDuration"));
        this.f13163j = cursor.getInt(cursor.getColumnIndex("NumCustom"));
    }
}
