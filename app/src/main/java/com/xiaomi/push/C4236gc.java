package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.service.C4374az;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.xiaomi.push.gc */
/* loaded from: classes2.dex */
public class C4236gc {
    /* renamed from: a */
    public static void m14959a(Context context, InterfaceC4238ge interfaceC4238ge, List<C4243gj> list) {
        HashMap<String, ArrayList<C4243gj>> m14957a = m14957a(context, list);
        if (m14957a != null && m14957a.size() != 0) {
            m14958a(context, interfaceC4238ge, m14957a);
            return;
        }
        AbstractC4022b.m13347a("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
    }

    /* renamed from: a */
    private static HashMap<String, ArrayList<C4243gj>> m14957a(Context context, List<C4243gj> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap<String, ArrayList<C4243gj>> hashMap = new HashMap<>();
        for (C4243gj c4243gj : list) {
            m14960a(context, c4243gj);
            ArrayList<C4243gj> arrayList = hashMap.get(c4243gj.m14997c());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                hashMap.put(c4243gj.m14997c(), arrayList);
            }
            arrayList.add(c4243gj);
        }
        return hashMap;
    }

    /* renamed from: a */
    private static void m14960a(Context context, C4243gj c4243gj) {
        if (c4243gj.f15541a) {
            c4243gj.m14981a("push_sdk_channel");
        }
        if (TextUtils.isEmpty(c4243gj.m15001d())) {
            c4243gj.m15006f(C4374az.m16040a());
        }
        c4243gj.m14991b(System.currentTimeMillis());
        if (TextUtils.isEmpty(c4243gj.m15004e())) {
            c4243gj.m15003e(context.getPackageName());
        }
        if (TextUtils.isEmpty(c4243gj.m14997c())) {
            c4243gj.m15003e(c4243gj.m15004e());
        }
    }

    /* renamed from: a */
    private static void m14958a(Context context, InterfaceC4238ge interfaceC4238ge, HashMap<String, ArrayList<C4243gj>> hashMap) {
        for (Map.Entry<String, ArrayList<C4243gj>> entry : hashMap.entrySet()) {
            try {
                ArrayList<C4243gj> value = entry.getValue();
                if (value != null && value.size() != 0) {
                    interfaceC4238ge.mo14966a(value, value.get(0).m15004e(), entry.getKey());
                }
            } catch (Exception unused) {
            }
        }
    }
}
