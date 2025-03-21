package com.xiaomi.clientreport.data;

import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class PerfClientReport extends C4024a {
    private static final long DEFAULT_VALUE = -1;
    public int code;
    public long perfCounts = -1;
    public long perfLatencies = -1;

    public static PerfClientReport getBlankInstance() {
        return new PerfClientReport();
    }

    @Override // com.xiaomi.clientreport.data.C4024a
    public JSONObject toJson() {
        try {
            JSONObject json = super.toJson();
            if (json == null) {
                return null;
            }
            json.put("code", this.code);
            json.put("perfCounts", this.perfCounts);
            json.put("perfLatencies", this.perfLatencies);
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
