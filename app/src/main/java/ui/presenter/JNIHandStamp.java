package ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import bean.HandKey;
import bean.TellNumHtyBean;
import com.hicorenational.antifraud.R;
import com.openssl.md.JniHand;
import interfaces.IOneClickListener;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import m.n;
import network.APIException;
import network.IReportService;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.gson.ResponseDataTypeAdaptor;
import ui.Hicore;
import ui.basemvp.BaseView;
import ui.model.ModelPresent;
import util.d2;
import util.e2;
import util.s1;

/* JADX INFO: loaded from: classes2.dex */
public class JNIHandStamp<T> extends ModelPresent {
    public static final String ENCODEKEY = "data";
    private AtomicLong atomicInte;
    private long expireTime;
    private boolean isExpireQurey;
    private long lastLocal;
    private static JNIHandStamp jniPresenter = new JNIHandStamp();
    public static JniHand jni = new JniHand();
    public static String identity = "";

    class a extends MiddleSubscriber<APIresult<HandKey>> {
        final /* synthetic */ IOneClickListener a;

        a(IOneClickListener iOneClickListener) {
            this.a = iOneClickListener;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return HandKey.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            e2.e(aPIException.getMessage());
            JNIHandStamp.this.isExpireQurey = false;
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<HandKey> aPIresult) {
            JNIHandStamp.this.getHandKey(aPIresult, this.a);
        }
    }

    class b extends com.google.gson.d0.a<HashMap<String, String>> {
        b() {
        }
    }

    public interface c {
        void onSuccess(HashMap map);
    }

    private JNIHandStamp() {
        super((Activity) null, (BaseView) null);
        this.atomicInte = new AtomicLong(1L);
        this.isExpireQurey = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <V> APIresult<V> analyzeParamResult(APIresult<V> aPIresult, Type type) {
        if (aPIresult == null) {
            aPIresult = new APIresult<>(Hicore.getApp().getResources().getString(R.string.err_timeout));
        }
        if (!(aPIresult instanceof APIresult)) {
            systemError(aPIresult);
            return aPIresult;
        }
        String str = aPIresult.getsData();
        if (TextUtils.isEmpty(str)) {
            return aPIresult;
        }
        String strParamJsonDecode = jni.paramJsonDecode(str);
        s1.b("RetrofitLog", "\u53c2\u6570\u89e3\u5bc6 " + strParamJsonDecode);
        aPIresult.setEncodeStr(strParamJsonDecode);
        com.google.gson.e eVarBuildGson = ResponseDataTypeAdaptor.buildGson();
        TellNumHtyBean tellNumHtyBean = (APIresult<V>) ((APIresult) eVarBuildGson.a(strParamJsonDecode, (Class) APIresult.class));
        tellNumHtyBean.setEncodeStr(strParamJsonDecode);
        if (type != null) {
            try {
                com.google.gson.k kVar = new com.google.gson.o().a(strParamJsonDecode).getAsJsonObject().get("data");
                if (kVar != null) {
                    tellNumHtyBean.setData(eVarBuildGson.a(kVar.toString(), type));
                } else {
                    tellNumHtyBean.setData(null);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                tellNumHtyBean.setData(null);
            }
        }
        systemError(tellNumHtyBean);
        return tellNumHtyBean;
    }

    public synchronized void getHandKey(APIresult<HandKey> aPIresult, IOneClickListener iOneClickListener) {
        if (aPIresult.getCode() == 0) {
            try {
                HandKey data = aPIresult.getData();
                jni.setApiPubKey(data.getPeer().replaceAll("(.{64})", "$1\n").trim());
                identity = jni.paramJsonDecode(data.getIdentity());
                String strParamJsonDecode = jni.paramJsonDecode(data.getSeqid());
                if (!TextUtils.isEmpty(strParamJsonDecode)) {
                    this.atomicInte.set(Long.parseLong(strParamJsonDecode));
                }
                String strParamJsonDecode2 = jni.paramJsonDecode(data.getExpire());
                if (!TextUtils.isEmpty(strParamJsonDecode2)) {
                    this.expireTime = Long.parseLong(strParamJsonDecode2);
                }
                this.lastLocal = System.currentTimeMillis();
                this.isExpireQurey = true;
                if (iOneClickListener != null) {
                    iOneClickListener.clickOKBtn();
                }
            } catch (Exception unused) {
                if (iOneClickListener != null) {
                    iOneClickListener.clickOKBtn();
                }
            }
        } else {
            e2.e("\u8bf7\u6c42\u8d85\u65f6");
        }
    }

    public static JNIHandStamp getInstance() {
        return jniPresenter;
    }

    private String operatUrl(String str) {
        if (e.a.f10139c.contains(str)) {
            return e.a.f10139c + f.b.f10184c;
        }
        if (e.a.f10144h.contains(str)) {
            return e.a.f10144h + f.b.f10185d;
        }
        if (!e.a.f10146j.contains(str)) {
            return "";
        }
        return e.a.f10146j + f.b.f10185d;
    }

    private HashMap<String, String> princiHttp(T t) {
        HashMap<String, String> map = new HashMap<>();
        if (t != null) {
            String strA = ResponseDataTypeAdaptor.buildGson().a(t);
            s1.b("RetrofitLog", "\u53c2\u6570data " + strA);
            String strParamJsonEncode = jni.paramJsonEncode(strA);
            s1.b("RetrofitLog", "\u53c2\u6570data\u52a0\u5bc6\u540e " + strParamJsonEncode);
            map.put("data", strParamJsonEncode);
        }
        return map;
    }

    private <V> void systemError(APIresult<V> aPIresult) {
        if (aPIresult.getCode() == 999) {
            aPIresult.setMsg(Hicore.getApp().getResources().getString(R.string.err_system));
        } else if (TextUtils.isEmpty(aPIresult.getMsg())) {
            aPIresult.setMsg(Hicore.getApp().getResources().getString(R.string.err_timeout));
        }
    }

    public <V> APIresult<V> analyzeParam(APIresult<V> aPIresult, Type type) {
        return analyzeParamResult(aPIresult, type);
    }

    public void cleanJNIData() {
        identity = "";
        this.isExpireQurey = true;
        this.atomicInte.set(1L);
    }

    public synchronized boolean expireFail(boolean z) {
        if (z) {
            this.isExpireQurey = false;
            return true;
        }
        if (isNeedDelay()) {
            return false;
        }
        if (this.expireTime - ((System.currentTimeMillis() - this.lastLocal) / 1000) > 0) {
            return false;
        }
        this.isExpireQurey = false;
        return true;
    }

    public String getSeqid() {
        return jni.paramJsonEncode(String.valueOf(this.atomicInte.incrementAndGet()));
    }

    public String getUUID() {
        return jni.paramJsonEncode(d2.l());
    }

    public synchronized void handshareKeySyn(String str, IOneClickListener iOneClickListener) {
        if (this.isExpireQurey) {
            if (iOneClickListener != null) {
                iOneClickListener.clickOKBtn();
            }
            return;
        }
        String strOperatUrl = operatUrl(str);
        if (TextUtils.isEmpty(strOperatUrl)) {
            iOneClickListener.clickOKBtn();
            e2.a("\u8bf7\u6c42\u6570\u636e\u5f02\u5e38");
        }
        HashMap map = new HashMap();
        map.put("peer", jni.getAppPubKey());
        try {
            m.b<APIresult<HandKey>> bVarJniAppKeySyn = ((IReportService) new n.b().a(e.a.i()).a(m.r.a.a.a()).a().a(IReportService.class)).jniAppKeySyn(strOperatUrl, map);
            s1.b("RetrofitLog", "retrofitHeader  " + new com.google.gson.e().a(bVarJniAppKeySyn.request().newBuilder()) + "-------------");
            m.m<APIresult<HandKey>> mVarExecute = bVarJniAppKeySyn.execute();
            s1.b("RetrofitLog", "response<-- " + mVarExecute.b() + d.c.a.b.a.a.f10074g + bVarJniAppKeySyn.request().url());
            if (mVarExecute != null) {
                getHandKey(mVarExecute.a(), iOneClickListener);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            e2.e(e2.getMessage());
        }
    }

    public synchronized void handsharkKeyAsyn(IOneClickListener iOneClickListener) {
        String str = e.a.f10139c + f.b.f10184c;
        HashMap<String, String> map = new HashMap<>();
        map.put("peer", jni.getAppPubKey());
        jniAppKey(map, str, new a(iOneClickListener));
    }

    public boolean isNeedDelay() {
        long jCurrentTimeMillis = (System.currentTimeMillis() - this.lastLocal) / 1000;
        long j2 = this.expireTime;
        if (j2 - jCurrentTimeMillis <= 0 || j2 - jCurrentTimeMillis >= 60) {
            return false;
        }
        this.lastLocal = System.currentTimeMillis();
        return true;
    }

    public HashMap pamramToMap(T t) {
        com.google.gson.e eVarBuildGson = ResponseDataTypeAdaptor.buildGson();
        return (HashMap) eVarBuildGson.a(eVarBuildGson.a(t), new b().getType());
    }

    public String pamramToString(T t) {
        return ResponseDataTypeAdaptor.buildGson().a(t);
    }

    public synchronized HashMap<String, String> princEncode(T t) {
        return princiHttp(t);
    }
}
