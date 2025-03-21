package com.vivo.push.model;

import android.text.TextUtils;
import com.vivo.push.util.C4007r;
import com.vivo.push.util.C4010u;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class UnvarnishedMessage {
    private static final String TAG = "UnvarnishedMessage";
    private String mMessage;
    private long mMsgId;
    private Map<String, String> mParams = new HashMap();
    private int mTargetType;
    private String mTragetContent;

    public UnvarnishedMessage() {
    }

    private void packToObj(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                C4010u.m13292a(TAG, "unvarnishedMsg pack to obj is null");
                return;
            }
            JSONArray jSONArray = new JSONArray(str);
            this.mTargetType = jSONArray.optInt(0);
            this.mTragetContent = jSONArray.getString(1);
            this.mMessage = jSONArray.getString(2);
            this.mParams = C4007r.m13277a(new JSONObject(jSONArray.getString(3)));
        } catch (JSONException e2) {
            e2.printStackTrace();
            C4010u.m13293a(TAG, "unvarnishedMsg pack to obj error", e2);
        }
    }

    public String getMessage() {
        return this.mMessage;
    }

    public long getMsgId() {
        return this.mMsgId;
    }

    public Map<String, String> getParams() {
        return this.mParams;
    }

    public int getTargetType() {
        return this.mTargetType;
    }

    public String getTragetContent() {
        return this.mTragetContent;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public void setMsgId(long j2) {
        this.mMsgId = j2;
    }

    public void setParams(Map<String, String> map) {
        this.mParams = map;
    }

    public void setTargetType(int i2) {
        this.mTargetType = i2;
    }

    public void setTragetContent(String str) {
        this.mTragetContent = str;
    }

    public String unpackToJson() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.mTargetType);
        jSONArray.put(this.mTragetContent);
        jSONArray.put(this.mMessage);
        Object obj = this.mParams;
        if (obj == null) {
            obj = new HashMap();
        }
        jSONArray.put(obj);
        return jSONArray.toString();
    }

    public UnvarnishedMessage(String str) {
        packToObj(str);
    }
}
