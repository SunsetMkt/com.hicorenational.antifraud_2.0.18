package com.umeng.socialize.net.dplus;

import android.content.Context;
import android.util.Base64;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.dplus.p220db.DBConfig;
import com.umeng.socialize.net.dplus.p220db.DBManager;
import com.umeng.socialize.p215a.C3622h;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class CommonNetImpl implements UMLogDataProtocol {
    public static final String AID = "aid";

    /* renamed from: AM */
    public static final String f13711AM = "am";

    /* renamed from: AS */
    public static final String f13712AS = "as";

    /* renamed from: AT */
    public static final String f13713AT = "at";
    public static final String AUTH = "auth";
    public static final String A_B = "a_b";
    public static final String CANCEL = "cancel";
    public static final String CONTENT = "content";

    /* renamed from: CT */
    public static final String f13714CT = "ct";
    public static final String DAU = "dau";
    public static final String DURL = "durl";
    public static final String E_M = "e_m";
    public static final String FAIL = "fail";
    public static final int FLAG_AUTH = 268435456;
    public static final int FLAG_SHARE = 536870912;
    public static final int FLAG_SHARE_EDIT = 16777216;
    public static final int FLAG_SHARE_JUMP = 33554432;
    public static final String HEADER = "header";
    public static final String IMEI = "imei";
    public static final int MAX_FILE_SIZE_IN_KB = 65536;
    public static final int MAX_SEND_SIZE_IN_KB = 524288;
    public static final int MAX_SIZE_IN_KB = 5242880;
    public static final String MENUBG = "menubg";
    public static final String MOB_NUM = "pn";
    public static final String M_P = "m_p";
    public static final String M_U = "m_u";
    public static final String NAME = "name";
    public static final String PCV = "s_pcv";

    /* renamed from: PF */
    public static final String f13715PF = "pf";
    public static final String PIC = "pic";
    public static final String PICURL = "picurl";
    public static final String POSITION = "position";
    public static final String REGION = "regn";
    public static final String RESULT = "result";
    public static final String SDKT = "sdkt";
    public static final String SDKVERSON = "s_sdk_v";
    public static final String SEX = "sex";
    public static final String SHARE = "share";
    public static final String SHARETYPE = "s_t";

    /* renamed from: SM */
    public static final String f13716SM = "sm";
    public static final String STATS = "stats";
    public static final String STATS_TAG = "stats";
    public static final String STYPE = "stype";
    public static final String SUCCESS = "success";
    public static final String S_A_E = "s_a_e";
    public static final String S_A_S = "s_a_s";
    public static final String S_DAU = "s_dau";
    public static final String S_E = "s_e";
    public static final String S_I = "s_i";
    public static final String S_I_E = "s_i_e";
    public static final String S_I_S = "s_i_s";
    public static final String S_S_E = "s_s_e";
    public static final String S_S_S = "s_s_s";
    public static final String TAG = "tag";
    public static final String TITLE = "title";

    /* renamed from: TS */
    public static final String f13717TS = "ts";
    public static final String UID = "uid";
    public static final String UMID = "umid";

    /* renamed from: UN */
    public static final String f13718UN = "un";
    public static final String UNIONID = "unionid";

    /* renamed from: UP */
    public static final String f13719UP = "up";
    public static final String URL = "url";
    public static final String USERINFO = "userinfo";
    public static final String U_C = "u_c";
    public static final String click_key = "at";
    private static boolean isSendStats = false;
    private static CommonNetImpl singleton;
    private Context mConetxt;
    private final int MAX_SIZE = 1048576;
    private ArrayList<Integer> shareList = new ArrayList<>();
    private ArrayList<Integer> authList = new ArrayList<>();
    private ArrayList<Integer> infoList = new ArrayList<>();
    private ArrayList<Integer> dauList = new ArrayList<>();
    private ArrayList<Integer> statsList = new ArrayList<>();

    private CommonNetImpl(Context context) {
        this.mConetxt = context;
    }

    private static double checkFile() {
        File dataFile = ContextUtil.getDataFile(DBConfig.DB_NAME);
        if (dataFile == null || !dataFile.exists()) {
            return 0.0d;
        }
        return dataFile.length();
    }

    private void clearAllList() {
        this.shareList.clear();
        this.authList.clear();
        this.infoList.clear();
        this.dauList.clear();
        this.statsList.clear();
    }

    private JSONObject constructHeader() {
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("s_sdk_v", "7.3.2");
                jSONObject.put(PCV, SocializeConstants.PROTOCOL_VERSON);
                return jSONObject;
            } catch (Throwable unused) {
                return jSONObject;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static CommonNetImpl get(Context context) {
        if (singleton == null) {
            singleton = new CommonNetImpl(context);
        }
        return singleton;
    }

    private void saveFile(Object obj, int i2) {
        if (obj != null && (obj instanceof JSONObject)) {
            JSONObject jSONObject = (JSONObject) obj;
            switch (i2) {
                case SocializeConstants.DAU_EVENT /* 24577 */:
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> Share: DAU_EVENT");
                    DBManager.get(this.mConetxt).insertDau(jSONObject);
                    break;
                case SocializeConstants.SHARE_EVENT /* 24578 */:
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> Share: SHARE_EVENT");
                    DBManager.get(this.mConetxt).insertS_E(jSONObject);
                    break;
                case SocializeConstants.AUTH_EVENT /* 24579 */:
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> Share: AUTH_EVENT");
                    DBManager.get(this.mConetxt).insertAuth(jSONObject);
                    break;
                case SocializeConstants.GET_EVENT /* 24580 */:
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> Share: GET_EVENT");
                    DBManager.get(this.mConetxt).insertUserInfo(jSONObject);
                    break;
                case SocializeConstants.SAVE_STATS_EVENT /* 24581 */:
                case SocializeConstants.SEND_DAU_STATS_EVENT /* 24583 */:
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> Share: SAVE_STATS_EVENT");
                    DBManager.get(this.mConetxt).insertStats(jSONObject);
                    break;
                case SocializeConstants.CHECK_STATS_EVENT /* 24582 */:
                default:
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> Share: default case.");
                    DBManager.get(this.mConetxt).insertStats(jSONObject);
                    break;
            }
            if (UMWorkDispatch.eventHasExist(SocializeConstants.BUILD_ENVELOPE)) {
                return;
            }
            UMWorkDispatch.sendEvent(this.mConetxt, SocializeConstants.BUILD_ENVELOPE, this, null);
        }
    }

    public void deleteData(Context context) {
        if (this.shareList.size() > 0) {
            DBManager.get(context).delete(this.shareList, "s_e");
            this.shareList.clear();
        }
        if (this.authList.size() > 0) {
            DBManager.get(context).delete(this.authList, "auth");
            this.authList.clear();
        }
        if (this.dauList.size() > 0) {
            DBManager.get(context).delete(this.dauList, "dau");
            this.dauList.clear();
        }
        if (this.infoList.size() > 0) {
            DBManager.get(context).delete(this.infoList, "userinfo");
            this.infoList.clear();
        }
        if (this.statsList.size() > 0) {
            DBManager.get(context).delete(this.statsList, "stats");
            this.statsList.clear();
        }
    }

    public JSONObject readData(Context context, int i2) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        JSONArray jSONArray3;
        JSONArray jSONArray4;
        String optString;
        double checkFile = checkFile();
        if (checkFile >= 5242880.0d) {
            DBManager.get(ContextUtil.getContext()).deleteTable("stats");
            return null;
        }
        boolean z = 1048576.0d <= checkFile + 24576.0d;
        JSONObject jSONObject = new JSONObject();
        try {
            new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONArray select = DBManager.get(context).select("s_e", this.shareList, 1047552.0d, z);
            double length = select.toString().getBytes().length + 1024.0d;
            JSONArray select2 = DBManager.get(context).select("auth", this.authList, 1048576.0d - length, z);
            double length2 = length + select2.toString().getBytes().length;
            JSONArray select3 = DBManager.get(context).select("userinfo", this.infoList, 1048576.0d - length2, z);
            double length3 = length2 + select3.toString().getBytes().length;
            JSONArray jSONArray5 = select3;
            JSONArray select4 = DBManager.get(context).select("dau", this.dauList, 1048576.0d - length3, z);
            JSONArray select5 = DBManager.get(context).select("stats", this.statsList, 1048576.0d - (length3 + select4.toString().getBytes().length), z);
            int length4 = select5.toString().getBytes().length;
            checkFile();
            if (select4.length() != 0) {
                jSONArray = select4;
                jSONObject2.put("dau", jSONArray);
            } else {
                jSONArray = select4;
            }
            if (select.length() != 0) {
                jSONArray2 = select;
                jSONObject2.put("s_e", jSONArray2);
            } else {
                jSONArray2 = select;
            }
            if (select2.length() != 0) {
                jSONArray3 = select2;
                jSONObject2.put("auth", jSONArray3);
            } else {
                jSONArray3 = select2;
            }
            if (jSONArray5.length() != 0) {
                int i3 = 0;
                while (i3 < jSONArray5.length()) {
                    JSONArray jSONArray6 = jSONArray5;
                    JSONObject optJSONObject = jSONArray6.optJSONObject(i3);
                    if (optJSONObject != null && (optString = optJSONObject.optString("pn", null)) != null) {
                        optJSONObject.put("pn", new String(Base64.decode(optString, 0)));
                    }
                    i3++;
                    jSONArray5 = jSONArray6;
                }
                jSONArray4 = jSONArray5;
                jSONObject2.put("userinfo", jSONArray4);
            } else {
                jSONArray4 = jSONArray5;
            }
            if (select5.length() != 0) {
                jSONObject2.put("stats", select5);
            }
            jSONObject.put("share", jSONObject2);
            if (jSONArray2.length() == 0 && jSONArray3.length() == 0 && jSONArray4.length() == 0 && jSONArray.length() == 0) {
                if (select5.length() == 0) {
                    jSONObject = null;
                }
            }
        } catch (JSONException e2) {
            SLog.error(UmengText.CACHE.CACHEFILE, e2);
        }
        if (jSONObject == null || jSONObject.toString().getBytes().length <= 1048576.0d) {
            return jSONObject;
        }
        return null;
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j2) {
        return null;
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void workEvent(Object obj, int i2) {
        switch (i2) {
            case SocializeConstants.REGIST_TO_WORK_QUEUE /* 24592 */:
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> Share: REGIST_TO_WORK_QUEUE");
                break;
            case SocializeConstants.BUILD_ENVELOPE /* 24593 */:
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> Share: BUILD_ENVELOPE");
                JSONObject constructHeader = constructHeader();
                if (constructHeader != null) {
                    JSONObject readData = readData(this.mConetxt, i2);
                    if (readData != null) {
                        JSONObject buildEnvelopeWithExtHeader = UMEnvelopeBuild.buildEnvelopeWithExtHeader(this.mConetxt, constructHeader, readData, "umpx_share", C3351bh.f11580aE, "7.3.2");
                        if (buildEnvelopeWithExtHeader != null) {
                            if (buildEnvelopeWithExtHeader.has("exception")) {
                                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> Share: 构建信封失败!");
                                if (readData.optInt("exception") != 101) {
                                    deleteData(this.mConetxt);
                                }
                            } else {
                                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> Share: 构建信封成功，删除本地数据!");
                                deleteData(this.mConetxt);
                            }
                        }
                    } else {
                        SLog.m12716E(UmengText.NET.BODYNULL);
                    }
                    clearAllList();
                    break;
                }
                break;
            case SocializeConstants.AZX_TRIGGER /* 24594 */:
                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> Share: AZX_TRIGGER");
                try {
                    C3622h.m12538a();
                    break;
                } catch (Throwable th) {
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> Share: AZX_TASK invoke exception!");
                    th.printStackTrace();
                    return;
                }
            default:
                saveFile(obj, i2);
                break;
        }
    }
}
