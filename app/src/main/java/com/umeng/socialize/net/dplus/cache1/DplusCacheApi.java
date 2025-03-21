package com.umeng.socialize.net.dplus.cache1;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.dplus.p220db.DBConfig;
import com.umeng.socialize.net.dplus.p220db.DBManager;
import com.umeng.socialize.p217c.p219b.C3634a;
import com.umeng.socialize.utils.ContextUtil;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class DplusCacheApi {

    /* renamed from: a */
    private static final String f13733a = "DplusCacheApi";

    /* renamed from: b */
    private HandlerThread f13734b;

    /* renamed from: c */
    private Handler f13735c;

    /* renamed from: d */
    private final int f13736d;

    /* renamed from: e */
    private ArrayList<Integer> f13737e;

    /* renamed from: f */
    private ArrayList<Integer> f13738f;

    /* renamed from: g */
    private ArrayList<Integer> f13739g;

    /* renamed from: h */
    private ArrayList<Integer> f13740h;

    /* renamed from: i */
    private ArrayList<Integer> f13741i;

    private static class SingletonHolder {

        /* renamed from: a */
        private static final DplusCacheApi f13758a = new DplusCacheApi();

        private SingletonHolder() {
        }
    }

    public static double checkFile() {
        File dataFile = ContextUtil.getDataFile(DBConfig.DB_NAME);
        if (dataFile == null || !dataFile.exists()) {
            return 0.0d;
        }
        return dataFile.length();
    }

    public static final DplusCacheApi getInstance() {
        return SingletonHolder.f13758a;
    }

    public void cleanCache(final Context context) {
        this.f13735c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.2
            @Override // java.lang.Runnable
            public void run() {
                C3634a.m12629a(context);
            }
        });
    }

    public void closeDBConnection(final Context context) {
        this.f13735c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.1
            @Override // java.lang.Runnable
            public void run() {
                DBManager.get(context).closeDatabase();
            }
        });
    }

    public void deleteAll(Context context) {
        this.f13735c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.6
            @Override // java.lang.Runnable
            public void run() {
                DBManager.get(ContextUtil.getContext()).deleteTable("stats");
            }
        });
    }

    public void deleteAllAsnc(Context context) {
        DBManager.get(ContextUtil.getContext()).deleteTable("stats");
    }

    public void deleteFile(final Context context) {
        this.f13735c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.5
            @Override // java.lang.Runnable
            public void run() {
                if (DplusCacheApi.this.f13737e.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f13737e, "s_e");
                    DplusCacheApi.this.f13737e.clear();
                }
                if (DplusCacheApi.this.f13738f.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f13738f, "auth");
                    DplusCacheApi.this.f13738f.clear();
                }
                if (DplusCacheApi.this.f13740h.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f13740h, "dau");
                    DplusCacheApi.this.f13740h.clear();
                }
                if (DplusCacheApi.this.f13739g.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f13739g, "userinfo");
                    DplusCacheApi.this.f13739g.clear();
                }
                if (DplusCacheApi.this.f13741i.size() > 0) {
                    DBManager.get(context).delete(DplusCacheApi.this.f13741i, "stats");
                    DplusCacheApi.this.f13741i.clear();
                }
            }
        });
    }

    public void deleteFileAsnc(Context context) {
        if (this.f13737e.size() > 0) {
            DBManager.get(context).delete(this.f13737e, "s_e");
            this.f13737e.clear();
        }
        if (this.f13738f.size() > 0) {
            DBManager.get(context).delete(this.f13738f, "auth");
            this.f13738f.clear();
        }
        if (this.f13740h.size() > 0) {
            DBManager.get(context).delete(this.f13740h, "dau");
            this.f13740h.clear();
        }
        if (this.f13739g.size() > 0) {
            DBManager.get(context).delete(this.f13739g, "userinfo");
            this.f13739g.clear();
        }
        if (this.f13741i.size() > 0) {
            DBManager.get(context).delete(this.f13741i, "stats");
            this.f13741i.clear();
        }
    }

    public void readFile(final Context context, final int i2, final DplusCacheListener dplusCacheListener) {
        this.f13735c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.4
            /* JADX WARN: Removed duplicated region for block: B:39:0x015e  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 386
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.RunnableC37464.run():void");
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0141  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.json.JSONObject readFileAsnc(android.content.Context r21, int r22) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.readFileAsnc(android.content.Context, int):org.json.JSONObject");
    }

    public void saveFile(final Context context, final JSONObject jSONObject, final int i2, final DplusCacheListener dplusCacheListener) {
        this.f13735c.post(new Runnable() { // from class: com.umeng.socialize.net.dplus.cache1.DplusCacheApi.3
            @Override // java.lang.Runnable
            public void run() {
                switch (i2) {
                    case SocializeConstants.DAU_EVENT /* 24577 */:
                        DBManager.get(context).insertDau(jSONObject);
                        break;
                    case SocializeConstants.SHARE_EVENT /* 24578 */:
                        DBManager.get(context).insertS_E(jSONObject);
                        break;
                    case SocializeConstants.AUTH_EVENT /* 24579 */:
                        DBManager.get(context).insertAuth(jSONObject);
                        break;
                    case SocializeConstants.GET_EVENT /* 24580 */:
                        DBManager.get(context).insertUserInfo(jSONObject);
                        break;
                    case SocializeConstants.SAVE_STATS_EVENT /* 24581 */:
                    case SocializeConstants.SEND_DAU_STATS_EVENT /* 24583 */:
                        DBManager.get(context).insertStats(jSONObject);
                        break;
                    case SocializeConstants.CHECK_STATS_EVENT /* 24582 */:
                    default:
                        DBManager.get(context).insertStats(jSONObject);
                        break;
                }
                dplusCacheListener.onResult(null);
            }
        });
    }

    private DplusCacheApi() {
        this.f13736d = 1048576;
        this.f13737e = new ArrayList<>();
        this.f13738f = new ArrayList<>();
        this.f13739g = new ArrayList<>();
        this.f13740h = new ArrayList<>();
        this.f13741i = new ArrayList<>();
        this.f13734b = new HandlerThread(f13733a, 10);
        this.f13734b.start();
        this.f13735c = new Handler(this.f13734b.getLooper());
    }

    /* renamed from: a */
    private static JSONObject m12688a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("s_sdk_v", "7.3.2");
        jSONObject.put(CommonNetImpl.PCV, SocializeConstants.PROTOCOL_VERSON);
        return jSONObject;
    }
}
