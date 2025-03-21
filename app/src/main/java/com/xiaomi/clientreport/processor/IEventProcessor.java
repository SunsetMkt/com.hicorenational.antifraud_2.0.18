package com.xiaomi.clientreport.processor;

import com.xiaomi.clientreport.data.C4024a;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes2.dex */
public interface IEventProcessor extends InterfaceC4028c, InterfaceC4029d {
    String bytesToString(byte[] bArr);

    void setEventMap(HashMap<String, ArrayList<C4024a>> hashMap);

    byte[] stringToBytes(String str);
}
