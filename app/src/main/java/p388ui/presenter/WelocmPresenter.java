package p388ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import bean.APIH5Bean;
import bean.AdBean;
import bean.WhiteTelBean;
import com.google.gson.p152d0.C2049a;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.gson.ResponseDataTypeAdaptor;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.callview.WelcomeCallView;
import p388ui.model.ModelPresent;
import p388ui.view.MyWebView;
import util.C7301n1;
import util.C7307p1;
import util.C7325u1;

/* loaded from: classes2.dex */
public class WelocmPresenter extends ModelPresent<WelcomeCallView> {
    public static String DKPropagandaCon;
    public static String XY_conceal;
    public static String XY_service;
    public static String mConnectionTel;
    public static String mVirusUpdateIntervalHours;
    public static List<WhiteTelBean> whiteTelList;
    public static List<WhiteTelBean> whiteList = new ArrayList();
    public static int mFailureNumStartValidate = 2;
    public static String SKIN = "0";
    public static String VIRAPPCHECK = "0";
    public static String VIRAPWARN = "0";
    public static String VIRSTMSG = "";

    /* renamed from: ui.presenter.WelocmPresenter$a */
    class C7121a extends MiddleSubscriber<APIresult<List<APIH5Bean>>> {

        /* renamed from: ui.presenter.WelocmPresenter$a$a */
        class a extends C2049a<List<APIH5Bean>> {
            a() {
            }
        }

        C7121a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            V v = WelocmPresenter.this.mvpView;
            if (v != 0) {
                ((WelcomeCallView) v).onfailRequest();
            }
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<APIH5Bean>> aPIresult) {
            List<APIH5Bean> data;
            super.onNextMiddle(aPIresult);
            if (aPIresult != null && aPIresult.getData() != null && (data = aPIresult.getData()) != null && data.size() > 0) {
                HashMap hashMap = new HashMap();
                for (APIH5Bean aPIH5Bean : data) {
                    if (aPIH5Bean != null) {
                        hashMap.put(aPIH5Bean.getKey(), aPIH5Bean.getValue());
                    }
                }
                C7301n1.m26454a("allDictionary", hashMap.toString());
                String str = (String) hashMap.get("androidh5host");
                if (!TextUtils.isEmpty(str)) {
                    C4440a.f16884f = str;
                }
                String str2 = (String) hashMap.get("androidhandbook");
                if (!TextUtils.isEmpty(str2)) {
                    C4440a.f16885g = str2;
                }
                WelocmPresenter.SKIN = (String) hashMap.get("SkinMode");
                WelocmPresenter.VIRAPPCHECK = (String) hashMap.get("virappcheck");
                WelocmPresenter.VIRAPWARN = (String) hashMap.get("virapwarn");
                WelocmPresenter.VIRSTMSG = (String) hashMap.get("virstmsg");
                String str3 = (String) hashMap.get("failureNumStartValidate");
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        WelocmPresenter.mFailureNumStartValidate = Integer.parseInt(str3);
                    } catch (Exception unused) {
                    }
                }
                String m26625b = C7325u1.m26625b(C7325u1.f25698t);
                String m26625b2 = C7325u1.m26625b(C7325u1.f25700u);
                String str4 = (String) hashMap.get("ProtorolVersion");
                String str5 = (String) hashMap.get("SecretVersion");
                String str6 = (String) hashMap.get("AnServiceAgreement");
                if (!TextUtils.isEmpty(str6)) {
                    WelocmPresenter.XY_service = str6;
                }
                String str7 = (String) hashMap.get("AnConcealAgreement");
                if (!TextUtils.isEmpty(str7)) {
                    WelocmPresenter.XY_conceal = str7;
                }
                if (!TextUtils.equals(m26625b, str4) || !TextUtils.equals(m26625b2, str5)) {
                    C7325u1.m26630b(C7325u1.f25698t, str4);
                    C7325u1.m26630b(C7325u1.f25700u, str5);
                    V v = WelocmPresenter.this.mvpView;
                    if (v != 0) {
                        ((WelcomeCallView) v).onSuccessRequest();
                        return;
                    }
                    return;
                }
                String str8 = (String) hashMap.get("cdnVersion");
                if (!TextUtils.equals(str8, C7307p1.m26477a(C7307p1.f25491A))) {
                    MyWebView.cleanCache();
                    C7307p1.m26479a(C7307p1.f25491A, str8);
                }
            }
            V v2 = WelocmPresenter.this.mvpView;
            if (v2 != 0) {
                ((WelcomeCallView) v2).onfailRequest();
            }
        }
    }

    /* renamed from: ui.presenter.WelocmPresenter$b */
    class C7122b extends MiddleSubscriber<APIresult<List<APIH5Bean>>> {

        /* renamed from: ui.presenter.WelocmPresenter$b$a */
        class a extends C2049a<List<APIH5Bean>> {
            a() {
            }
        }

        C7122b() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new a().getType();
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            WelocmPresenter.mConnectionTel = "";
            WelocmPresenter.mVirusUpdateIntervalHours = "";
            WelocmPresenter.whiteTelData("");
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<List<APIH5Bean>> aPIresult) {
            List<APIH5Bean> data;
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || aPIresult.getData() == null || (data = aPIresult.getData()) == null || data.size() <= 0) {
                onErrorMiddle(APIException.getApiExcept());
                return;
            }
            HashMap hashMap = new HashMap();
            for (APIH5Bean aPIH5Bean : data) {
                if (aPIH5Bean != null) {
                    hashMap.put(aPIH5Bean.getKey(), aPIH5Bean.getValue());
                }
            }
            C7301n1.m26454a("allDictionary", hashMap.toString());
            WelocmPresenter.mConnectionTel = (String) hashMap.get("connectionTel");
            WelocmPresenter.mVirusUpdateIntervalHours = (String) hashMap.get("virusUpdateIntervalHours");
            WelocmPresenter.whiteTelData((String) hashMap.get("whiteTelList"));
        }
    }

    /* renamed from: ui.presenter.WelocmPresenter$c */
    static class C7123c extends C2049a<List<WhiteTelBean>> {
        C7123c() {
        }
    }

    /* renamed from: ui.presenter.WelocmPresenter$d */
    class C7124d extends MiddleSubscriber<APIresult<AdBean>> {

        /* renamed from: a */
        final /* synthetic */ long f24381a;

        C7124d(long j2) {
            this.f24381a = j2;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return AdBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((WelcomeCallView) WelocmPresenter.this.mvpView).onAdRequest(null, this.f24381a);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AdBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() == 0) {
                ((WelcomeCallView) WelocmPresenter.this.mvpView).onAdRequest(aPIresult.getData(), this.f24381a);
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            }
        }
    }

    public WelocmPresenter(Activity activity, WelcomeCallView welcomeCallView) {
        super(activity, welcomeCallView);
    }

    public static void whiteTelData(String str) {
        if (TextUtils.isEmpty(str)) {
            str = C7307p1.m26477a(C7307p1.f25507p);
            if (TextUtils.isEmpty(str)) {
                str = "[{\"areaName\": \"北京市反诈中心来电\",\"list\": [\"010-67825260\",\"010-67825259\",\"010-67825257\",\"010-67825277\",\"010-67825191\",\"010-67825190\",\"010-67825189\",\"010-67825187\",\"010-67825171\",\"010-67825170\",\"010-67825169\",\"010-67825067\",\"010-67825152\",\"010-67825278\",\"010-67825151\",\"010-67825150\",\"010-67825126\",\"010-67825125\",\"010-67825123\",\"010-67825153\",\"010-67825107\",\"010-67825106\",\"010-67825105\",\"010-67825127\",\"010-67825087\",\"010-67825086\",\"010-67825085\",\"010-67825070\",\"010-67825108\",\"010-67825069\",\"010-67825068\",\"010-67825089\"]}]";
            }
        } else {
            C7307p1.m26479a(C7307p1.f25507p, str);
        }
        try {
            whiteTelList = (List) ResponseDataTypeAdaptor.buildGson().m5570a(str, new C7123c().getType());
            whiteList.addAll(whiteTelList);
        } catch (Exception e2) {
            e2.printStackTrace();
            whiteTelList = null;
            whiteList.clear();
        }
    }

    public void getAd(long j2) {
        getAd(C4440a.f16881c + C4445b.f17063a, new C7124d(j2));
    }

    public void otherPartDictionary() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("dictionarykeys", "whiteTelList,connectionTel,virusUpdateIntervalHours");
        allDictionary(hashMap, C4440a.f16881c + C4445b.f17096j, new C7122b());
    }

    public void requestPartDircly() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("dictionarykeys", "ProtorolVersion,SecretVersion,AnServiceAgreement,AnConcealAgreement,androidh5host,androidhandbook,failureNumStartValidate,SkinMode,cdnVersion,virappcheck,virapwarn,virstmsg");
        allDictionary(hashMap, C4440a.f16881c + C4445b.f17096j, new C7121a());
    }
}
