package p388ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import bean.HandKey;
import bean.TellNumHtyBean;
import com.google.gson.AbstractC2063k;
import com.google.gson.C2051e;
import com.google.gson.C2067o;
import com.google.gson.p152d0.C2049a;
import com.hicorenational.antifraud.C2113R;
import com.openssl.p188md.JniHand;
import interfaces.IOneClickListener;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import network.APIException;
import network.IReportService;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.gson.ResponseDataTypeAdaptor;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p245d.C4440a;
import p247e.C4445b;
import p375l.C5884m;
import p375l.C5885n;
import p375l.InterfaceC5873b;
import p375l.p378r.p379a.C5897a;
import p388ui.Hicore;
import p388ui.basemvp.BaseView;
import p388ui.model.ModelPresent;
import util.C7301n1;
import util.C7328v1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class JNIHandStamp<T> extends ModelPresent {
    public static final String ENCODEKEY = "data";
    private AtomicLong atomicInte;
    private long expireTime;
    private boolean isExpireQurey;
    private long lastLocal;
    private static JNIHandStamp jniPresenter = new JNIHandStamp();
    public static JniHand jni = new JniHand();
    public static String identity = "";

    /* renamed from: ui.presenter.JNIHandStamp$a */
    class C7011a extends MiddleSubscriber<APIresult<HandKey>> {

        /* renamed from: a */
        final /* synthetic */ IOneClickListener f24136a;

        C7011a(IOneClickListener iOneClickListener) {
            this.f24136a = iOneClickListener;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return HandKey.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
            JNIHandStamp.this.isExpireQurey = false;
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<HandKey> aPIresult) {
            JNIHandStamp.this.getHandKey(aPIresult, this.f24136a);
        }
    }

    /* renamed from: ui.presenter.JNIHandStamp$b */
    class C7012b extends C2049a<HashMap<String, String>> {
        C7012b() {
        }
    }

    /* renamed from: ui.presenter.JNIHandStamp$c */
    public interface InterfaceC7013c {
        void onSuccess(HashMap hashMap);
    }

    private JNIHandStamp() {
        super((Activity) null, (BaseView) null);
        this.atomicInte = new AtomicLong(1L);
        this.isExpireQurey = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <V> APIresult<V> analyzeParamResult(APIresult<V> aPIresult, Type type) {
        if (aPIresult == null) {
            aPIresult = new APIresult<>(Hicore.getApp().getResources().getString(C2113R.string.err_timeout));
        }
        if (!(aPIresult instanceof APIresult)) {
            systemError(aPIresult);
            return aPIresult;
        }
        String str = aPIresult.getsData();
        if (TextUtils.isEmpty(str)) {
            return aPIresult;
        }
        String paramJsonDecode = jni.paramJsonDecode(str);
        C7301n1.m26457b("RetrofitLog", "参数解密 " + paramJsonDecode);
        aPIresult.setEncodeStr(paramJsonDecode);
        C2051e buildGson = ResponseDataTypeAdaptor.buildGson();
        TellNumHtyBean tellNumHtyBean = (APIresult<V>) ((APIresult) buildGson.m5569a(paramJsonDecode, (Class) APIresult.class));
        tellNumHtyBean.setEncodeStr(paramJsonDecode);
        if (type != null) {
            try {
                AbstractC2063k abstractC2063k = new C2067o().m5677a(paramJsonDecode).getAsJsonObject().get("data");
                if (abstractC2063k != null) {
                    tellNumHtyBean.setData(buildGson.m5570a(abstractC2063k.toString(), type));
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
                String paramJsonDecode = jni.paramJsonDecode(data.getSeqid());
                if (!TextUtils.isEmpty(paramJsonDecode)) {
                    this.atomicInte.set(Long.parseLong(paramJsonDecode));
                }
                String paramJsonDecode2 = jni.paramJsonDecode(data.getExpire());
                if (!TextUtils.isEmpty(paramJsonDecode2)) {
                    this.expireTime = Long.parseLong(paramJsonDecode2);
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
            C7331w1.m26696e("请求超时");
        }
    }

    public static JNIHandStamp getInstance() {
        return jniPresenter;
    }

    private String operatUrl(String str) {
        if (C4440a.f16881c.contains(str)) {
            return C4440a.f16881c + C4445b.f17071c;
        }
        if (C4440a.f16886h.contains(str)) {
            return C4440a.f16886h + C4445b.f17075d;
        }
        if (!C4440a.f16888j.contains(str)) {
            return "";
        }
        return C4440a.f16888j + C4445b.f17075d;
    }

    private HashMap<String, String> princiHttp(T t) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (t != null) {
            String m5572a = ResponseDataTypeAdaptor.buildGson().m5572a(t);
            C7301n1.m26457b("RetrofitLog", "参数data " + m5572a);
            String paramJsonEncode = jni.paramJsonEncode(m5572a);
            C7301n1.m26457b("RetrofitLog", "参数data加密后 " + paramJsonEncode);
            hashMap.put("data", paramJsonEncode);
        }
        return hashMap;
    }

    private <V> void systemError(APIresult<V> aPIresult) {
        if (aPIresult.getCode() == 999) {
            aPIresult.setMsg(Hicore.getApp().getResources().getString(C2113R.string.err_system));
        } else if (TextUtils.isEmpty(aPIresult.getMsg())) {
            aPIresult.setMsg(Hicore.getApp().getResources().getString(C2113R.string.err_timeout));
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
        return jni.paramJsonEncode(C7328v1.m26674l());
    }

    public synchronized void handshareKeySyn(String str, IOneClickListener iOneClickListener) {
        if (this.isExpireQurey) {
            if (iOneClickListener != null) {
                iOneClickListener.clickOKBtn();
            }
            return;
        }
        String operatUrl = operatUrl(str);
        if (TextUtils.isEmpty(operatUrl)) {
            iOneClickListener.clickOKBtn();
            C7331w1.m26688a("请求数据异常");
        }
        HashMap hashMap = new HashMap();
        hashMap.put("peer", jni.getAppPubKey());
        try {
            InterfaceC5873b<APIresult<HandKey>> jniAppKeySyn = ((IReportService) new C5885n.b().m24814a(C4440a.m16407i()).m24817a(C5897a.m24871a()).m24822a().m24799a(IReportService.class)).jniAppKeySyn(operatUrl, hashMap);
            C7301n1.m26457b("RetrofitLog", "retrofitHeader  " + new C2051e().m5572a(jniAppKeySyn.request().newBuilder()) + "-------------");
            C5884m<APIresult<HandKey>> execute = jniAppKeySyn.execute();
            C7301n1.m26457b("RetrofitLog", "response<-- " + execute.m24792b() + AbstractC1191a.f2568g + jniAppKeySyn.request().url());
            if (execute != null) {
                getHandKey(execute.m24791a(), iOneClickListener);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            C7331w1.m26696e(e2.getMessage());
        }
    }

    public synchronized void handsharkKeyAsyn(IOneClickListener iOneClickListener) {
        String str = C4440a.f16881c + C4445b.f17071c;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("peer", jni.getAppPubKey());
        jniAppKey(hashMap, str, new C7011a(iOneClickListener));
    }

    public boolean isNeedDelay() {
        long currentTimeMillis = (System.currentTimeMillis() - this.lastLocal) / 1000;
        long j2 = this.expireTime;
        if (j2 - currentTimeMillis <= 0 || j2 - currentTimeMillis >= 60) {
            return false;
        }
        this.lastLocal = System.currentTimeMillis();
        return true;
    }

    public HashMap pamramToMap(T t) {
        C2051e buildGson = ResponseDataTypeAdaptor.buildGson();
        return (HashMap) buildGson.m5570a(buildGson.m5572a(t), new C7012b().getType());
    }

    public String pamramToString(T t) {
        return ResponseDataTypeAdaptor.buildGson().m5572a(t);
    }

    public synchronized HashMap<String, String> princEncode(T t) {
        return princiHttp(t);
    }
}
