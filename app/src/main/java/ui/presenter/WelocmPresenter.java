package ui.presenter;

import android.app.Activity;
import android.text.TextUtils;
import bean.APIH5Bean;
import bean.AdBean;
import bean.WhiteTelBean;
import bean.aimedia.AiMedia;
import bean.aimedia.AudioCheckConfigType;
import bean.aimedia.DataType;
import bean.aimedia.ImageCheckConfigType;
import bean.aimedia.RootData;
import bean.aimedia.VideoCheckConfigType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.gson.ResponseDataTypeAdaptor;
import org.json.JSONObject;
import ui.callview.WelcomeCallView;
import ui.model.ModelPresent;
import ui.view.MyWebView;
import util.c2;
import util.s1;
import util.u1;

/* JADX INFO: loaded from: classes2.dex */
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

    class a extends MiddleSubscriber<APIresult<List<APIH5Bean>>> {

        /* JADX INFO: renamed from: ui.presenter.WelocmPresenter$a$a */
        class C0322a extends com.google.gson.d0.a<List<APIH5Bean>> {
            C0322a() {
            }
        }

        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return new C0322a().getType();
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
                HashMap map = new HashMap();
                for (APIH5Bean aPIH5Bean : data) {
                    if (aPIH5Bean != null) {
                        map.put(aPIH5Bean.getKey(), aPIH5Bean.getValue());
                    }
                }
                s1.a("allDictionary", map.toString());
                String str = (String) map.get("androidh5host");
                if (!TextUtils.isEmpty(str)) {
                    e.a.f10142f = str;
                }
                String str2 = (String) map.get("androidhandbook");
                if (!TextUtils.isEmpty(str2)) {
                    e.a.f10143g = str2;
                }
                WelocmPresenter.SKIN = (String) map.get("SkinMode");
                WelocmPresenter.VIRAPPCHECK = (String) map.get("virappcheck");
                WelocmPresenter.VIRAPWARN = (String) map.get("virapwarn");
                WelocmPresenter.VIRSTMSG = (String) map.get("virstmsg");
                String str3 = (String) map.get("failureNumStartValidate");
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        WelocmPresenter.mFailureNumStartValidate = Integer.parseInt(str3);
                    } catch (Exception unused) {
                    }
                }
                String strB = c2.b(c2.t);
                String strB2 = c2.b(c2.u);
                String str4 = (String) map.get("ProtorolVersion");
                String str5 = (String) map.get("SecretVersion");
                String str6 = (String) map.get("AnServiceAgreement");
                if (!TextUtils.isEmpty(str6)) {
                    WelocmPresenter.XY_service = str6;
                }
                String str7 = (String) map.get("AnConcealAgreement");
                if (!TextUtils.isEmpty(str7)) {
                    WelocmPresenter.XY_conceal = str7;
                }
                if (!TextUtils.equals(strB, str4) || !TextUtils.equals(strB2, str5)) {
                    c2.b(c2.t, str4);
                    c2.b(c2.u, str5);
                    V v = WelocmPresenter.this.mvpView;
                    if (v != 0) {
                        ((WelcomeCallView) v).onSuccessRequest();
                        return;
                    }
                    return;
                }
                String str8 = (String) map.get("cdnVersion");
                if (!TextUtils.equals(str8, u1.a(u1.A))) {
                    MyWebView.cleanCache();
                    u1.a(u1.A, str8);
                }
            }
            V v2 = WelocmPresenter.this.mvpView;
            if (v2 != 0) {
                ((WelcomeCallView) v2).onfailRequest();
            }
        }
    }

    class b extends MiddleSubscriber<APIresult<List<APIH5Bean>>> {

        class a extends com.google.gson.d0.a<List<APIH5Bean>> {
            a() {
            }
        }

        b() {
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
            HashMap map = new HashMap();
            for (APIH5Bean aPIH5Bean : data) {
                if (aPIH5Bean != null) {
                    map.put(aPIH5Bean.getKey(), aPIH5Bean.getValue());
                }
            }
            s1.a("allDictionary", map.toString());
            WelocmPresenter.mConnectionTel = (String) map.get("connectionTel");
            WelocmPresenter.mVirusUpdateIntervalHours = (String) map.get("virusUpdateIntervalHours");
            WelocmPresenter.whiteTelData((String) map.get("whiteTelList"));
        }
    }

    static class c extends com.google.gson.d0.a<List<WhiteTelBean>> {
        c() {
        }
    }

    class d extends MiddleSubscriber<APIresult<AdBean>> {
        final /* synthetic */ long a;

        d(long j2) {
            this.a = j2;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return AdBean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            ((WelcomeCallView) WelocmPresenter.this.mvpView).onAdRequest(null, this.a);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AdBean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() == 0) {
                ((WelcomeCallView) WelocmPresenter.this.mvpView).onAdRequest(aPIresult.getData(), this.a);
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            }
        }
    }

    class e extends MiddleSubscriber<APIresult<AiMedia>> {
        e() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return AiMedia.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<AiMedia> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult == null || TextUtils.isEmpty(aPIresult.getEncodeStr())) {
                AiMedia aiMedia = new AiMedia();
                ImageCheckConfigType imageCheckConfigType = new ImageCheckConfigType();
                VideoCheckConfigType videoCheckConfigType = new VideoCheckConfigType();
                AudioCheckConfigType audioCheckConfigType = new AudioCheckConfigType();
                aiMedia.setimageCheckConfig(imageCheckConfigType);
                aiMedia.setaudioCheckConfig(audioCheckConfigType);
                aiMedia.setvideoCheckConfig(videoCheckConfigType);
                return;
            }
            List<DataType> list = ((RootData) new com.google.gson.e().a(aPIresult.getEncodeStr(), RootData.class)).getdata();
            if (list == null || list.size() <= 0) {
                return;
            }
            String str = list.get(0).getvalue();
            com.google.gson.e eVarA = new com.google.gson.f().a();
            c2.b(c2.L0, eVarA.a((AiMedia) eVarA.a(str, AiMedia.class)));
        }
    }

    class f extends MiddleSubscriber<APIresult<Object>> {
        f() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Object> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (aPIresult.getCode() == 0) {
                try {
                    int iIntValue = ((Integer) new JSONObject(aPIresult.getEncodeStr()).get("data")).intValue();
                    if (iIntValue <= 0) {
                        iIntValue = 0;
                    }
                    c2.b("verifyCount", "" + iIntValue);
                } catch (Exception unused) {
                }
            }
        }
    }

    public WelocmPresenter(Activity activity, WelcomeCallView welcomeCallView) {
        super(activity, welcomeCallView);
    }

    public static void whiteTelData(String str) {
        if (TextUtils.isEmpty(str)) {
            str = u1.a(u1.p);
            if (TextUtils.isEmpty(str)) {
                str = "[{\"areaName\": \"\u5317\u4eac\u5e02\u53cd\u8bc8\u4e2d\u5fc3\u6765\u7535\",\"list\": [\"010-67825260\",\"010-67825259\",\"010-67825257\",\"010-67825277\",\"010-67825191\",\"010-67825190\",\"010-67825189\",\"010-67825187\",\"010-67825171\",\"010-67825170\",\"010-67825169\",\"010-67825067\",\"010-67825152\",\"010-67825278\",\"010-67825151\",\"010-67825150\",\"010-67825126\",\"010-67825125\",\"010-67825123\",\"010-67825153\",\"010-67825107\",\"010-67825106\",\"010-67825105\",\"010-67825127\",\"010-67825087\",\"010-67825086\",\"010-67825085\",\"010-67825070\",\"010-67825108\",\"010-67825069\",\"010-67825068\",\"010-67825089\"]}]";
            }
        } else {
            u1.a(u1.p, str);
        }
        try {
            whiteTelList = (List) ResponseDataTypeAdaptor.buildGson().a(str, new c().getType());
            whiteList.addAll(whiteTelList);
        } catch (Exception e2) {
            e2.printStackTrace();
            whiteTelList = null;
            whiteList.clear();
        }
    }

    public void checkAiVerifyCount() {
        String str = e.a.f10139c + f.b.o2;
        HashMap map = new HashMap();
        map.put("checkType", 0);
        checkVerifyCurrentCount(str, map, new f());
    }

    public void getAd(long j2) {
        getAd(e.a.f10139c + f.b.a, new d(j2));
    }

    public void getAiMediaConfig() {
        String str = e.a.f10139c + f.b.f10193l;
        HashMap<String, String> map = new HashMap<>();
        map.put("dictionarykeys", "zkrjcheckconfig");
        requestMediaConfig(map, str, new e());
    }

    public void otherPartDictionary() {
        HashMap<String, String> map = new HashMap<>();
        map.put("dictionarykeys", "whiteTelList,connectionTel,virusUpdateIntervalHours");
        allDictionary(map, e.a.f10139c + f.b.f10191j, new b());
    }

    public void requestPartDircly() {
        HashMap<String, String> map = new HashMap<>();
        map.put("dictionarykeys", "ProtorolVersion,SecretVersion,AnServiceAgreement,AnConcealAgreement,androidh5host,androidhandbook,failureNumStartValidate,SkinMode,cdnVersion,virappcheck,virapwarn,virstmsg");
        allDictionary(map, e.a.f10139c + f.b.f10191j, new a());
    }
}
