package com.heytap.mcssdk.p157h;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2085b;
import com.heytap.mcssdk.constant.C2086c;
import com.heytap.mcssdk.p159j.C2100a;
import com.heytap.mcssdk.p160k.C2105e;
import com.heytap.mcssdk.p160k.C2107g;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.DataMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.heytap.mcssdk.h.b */
/* loaded from: classes.dex */
public class C2094b extends AbstractC2095c {
    @Override // com.heytap.mcssdk.p157h.InterfaceC2096d
    /* renamed from: a */
    public BaseMode mo5841a(Context context, int i2, Intent intent) {
        if (4103 != i2 && 4098 != i2 && 4108 != i2) {
            return null;
        }
        BaseMode mo5842a = mo5842a(intent, i2);
        C2100a.m5852a(context, C2086c.a.f6187e, (DataMessage) mo5842a);
        return mo5842a;
    }

    @Override // com.heytap.mcssdk.p157h.AbstractC2095c
    /* renamed from: a */
    public BaseMode mo5842a(Intent intent, int i2) {
        try {
            DataMessage dataMessage = new DataMessage();
            dataMessage.setMessageID(C2105e.m5875d(intent.getStringExtra(C2085b.f6162c)));
            dataMessage.setTaskID(C2105e.m5875d(intent.getStringExtra(C2085b.f6163d)));
            dataMessage.setGlobalId(C2105e.m5875d(intent.getStringExtra(C2085b.f6167h)));
            dataMessage.setAppPackage(C2105e.m5875d(intent.getStringExtra(C2085b.f6164e)));
            dataMessage.setTitle(C2105e.m5875d(intent.getStringExtra("title")));
            dataMessage.setContent(C2105e.m5875d(intent.getStringExtra("content")));
            dataMessage.setDescription(C2105e.m5875d(intent.getStringExtra("description")));
            String m5875d = C2105e.m5875d(intent.getStringExtra(C2085b.f6169j));
            int i3 = 0;
            dataMessage.setNotifyID(TextUtils.isEmpty(m5875d) ? 0 : Integer.parseInt(m5875d));
            dataMessage.setMiniProgramPkg(C2105e.m5875d(intent.getStringExtra("miniProgramPkg")));
            dataMessage.setMessageType(i2);
            dataMessage.setEventId(C2105e.m5875d(intent.getStringExtra(C2085b.f6170k)));
            dataMessage.setStatisticsExtra(C2105e.m5875d(intent.getStringExtra(C2085b.f6171l)));
            String m5875d2 = C2105e.m5875d(intent.getStringExtra(C2085b.f6172m));
            dataMessage.setDataExtra(m5875d2);
            String m5843a = m5843a(m5875d2);
            if (!TextUtils.isEmpty(m5843a)) {
                i3 = Integer.parseInt(m5843a);
            }
            dataMessage.setMsgCommand(i3);
            dataMessage.setBalanceTime(C2105e.m5875d(intent.getStringExtra(C2085b.f6173n)));
            dataMessage.setStartDate(C2105e.m5875d(intent.getStringExtra(C2085b.f6178s)));
            dataMessage.setEndDate(C2105e.m5875d(intent.getStringExtra(C2085b.f6179t)));
            dataMessage.setTimeRanges(C2105e.m5875d(intent.getStringExtra(C2085b.f6174o)));
            dataMessage.setRule(C2105e.m5875d(intent.getStringExtra(C2085b.f6175p)));
            dataMessage.setForcedDelivery(C2105e.m5875d(intent.getStringExtra(C2085b.f6176q)));
            dataMessage.setDistinctContent(C2105e.m5875d(intent.getStringExtra(C2085b.f6177r)));
            dataMessage.setAppId(C2105e.m5875d(intent.getStringExtra(C2085b.f6180u)));
            return dataMessage;
        } catch (Exception e2) {
            C2107g.m5884b("OnHandleIntent--" + e2.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public String m5843a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString(C2085b.f6181v);
        } catch (JSONException e2) {
            C2107g.m5884b(e2.getMessage());
            return "";
        }
    }
}
