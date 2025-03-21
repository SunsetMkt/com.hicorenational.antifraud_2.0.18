package com.xiaomi.push;

import android.content.Context;
import android.database.Cursor;
import com.xiaomi.push.C4121bw;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.xiaomi.push.br */
/* loaded from: classes2.dex */
public class C4116br extends C4121bw.b<Long> {

    /* renamed from: a */
    private long f14658a;

    /* renamed from: a */
    private String f14659a;

    public C4116br(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i2, String str6) {
        super(str, list, str2, strArr, str3, str4, str5, i2);
        this.f14658a = 0L;
        this.f14659a = str6;
    }

    /* renamed from: a */
    public static C4116br m13948a(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("count(*)");
        return new C4116br(str, arrayList, null, null, null, null, null, 0, "job to get count of all message");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.xiaomi.push.C4121bw.b
    /* renamed from: a */
    public Long mo13949a(Context context, Cursor cursor) {
        return Long.valueOf(cursor.getLong(0));
    }

    @Override // com.xiaomi.push.C4121bw.b
    /* renamed from: a */
    public void mo13951a(Context context, List<Long> list) {
        if (context == null || list == null || list.size() <= 0) {
            return;
        }
        this.f14658a = list.get(0).longValue();
    }

    @Override // com.xiaomi.push.C4121bw.a
    /* renamed from: a */
    public Object mo13950a() {
        return Long.valueOf(this.f14658a);
    }
}
