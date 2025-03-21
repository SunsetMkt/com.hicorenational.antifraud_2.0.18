package com.xiaomi.clientreport.data;

import com.heytap.mcssdk.constant.C2085b;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class EventClientReport extends C4024a {
    public String eventContent;
    public String eventId;
    public long eventTime;
    public int eventType;

    public static EventClientReport getBlankInstance() {
        return new EventClientReport();
    }

    @Override // com.xiaomi.clientreport.data.C4024a
    public JSONObject toJson() {
        try {
            JSONObject json = super.toJson();
            if (json == null) {
                return null;
            }
            json.put(C2085b.f6170k, this.eventId);
            json.put("eventType", this.eventType);
            json.put("eventTime", this.eventTime);
            json.put("eventContent", this.eventContent == null ? "" : this.eventContent);
            return json;
        } catch (JSONException e2) {
            AbstractC4022b.m13351a(e2);
            return null;
        }
    }

    @Override // com.xiaomi.clientreport.data.C4024a
    public String toJsonString() {
        return super.toJsonString();
    }
}
