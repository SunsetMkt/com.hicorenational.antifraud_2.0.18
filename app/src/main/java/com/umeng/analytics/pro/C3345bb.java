package com.umeng.analytics.pro;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* compiled from: NubiaDeviceIdSupplier.java */
/* renamed from: com.umeng.analytics.pro.bb */
/* loaded from: classes2.dex */
class C3345bb implements InterfaceC3337au {

    /* renamed from: a */
    private static final String f11543a = "content://cn.nubia.provider.deviceid.dataid/oaid";

    C3345bb() {
    }

    @Override // com.umeng.analytics.pro.InterfaceC3337au
    /* renamed from: a */
    public String mo10870a(Context context) {
        if (context == null) {
            return null;
        }
        Cursor query = context.getContentResolver().query(Uri.parse(f11543a), null, null, null, null);
        if (query != null) {
            r0 = query.moveToNext() ? query.getString(query.getColumnIndex("device_ids_grndid")) : null;
            query.close();
        }
        return r0;
    }
}
