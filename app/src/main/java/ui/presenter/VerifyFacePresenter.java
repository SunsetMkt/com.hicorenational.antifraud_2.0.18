package ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import bean.module.HomeToolBean;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import interfaces.IFaceLiveCallBack;
import interfaces.IFaceResultView;
import java.lang.reflect.Type;
import java.util.HashMap;
import manager.AccountManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.account.VerifyBody;
import network.http.RegionConfigHttp;
import network.http.ReportNumHttp;
import ui.activity.AppUploadActivity;
import ui.activity.CheckFraudActivity;
import ui.activity.CheckIDActivity;
import ui.activity.IDVarfyAceptListActivity;
import ui.activity.ManualActivity;
import ui.activity.PoliceLoginActivity;
import ui.activity.ReportNewActivity;
import ui.activity.ReporterAidActivity;
import ui.activity.VerifyFaceActivity;
import ui.activity.WarnSettingActivity;
import ui.activity.WebActivity;
import ui.activity.WebFullActivity;
import ui.callview.VerifyFaceCallview;
import util.k1;
import util.u1;
import util.w1;
import util.z1;

/* loaded from: classes2.dex */
public class VerifyFacePresenter extends YCLicencePresenter<VerifyFaceCallview> {

    class a extends MiddleSubscriber<APIresult<Boolean>> {
        a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return Boolean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<Boolean> aPIresult) {
            if (aPIresult.getCode() == 0) {
                ((VerifyFaceCallview) VerifyFacePresenter.this.mvpView).onSuccessRedName(aPIresult.getData().booleanValue());
            } else {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            }
        }
    }

    class b implements IFaceLiveCallBack {
        b() {
        }

        @Override // interfaces.IFaceLiveCallBack
        public void onLivenessFail(int i2) {
        }

        @Override // interfaces.IFaceLiveCallBack
        public void onLivenessSuccess(byte[] bArr) {
            ((VerifyFaceCallview) VerifyFacePresenter.this.mvpView).onSuccImaggRequest(bArr);
        }
    }

    class c implements IFaceResultView {
        c() {
        }

        @Override // interfaces.IFaceResultView
        public void onSuccRequest(Message message) {
            ((VerifyFaceCallview) VerifyFacePresenter.this.mvpView).onSuccRequest(message);
        }
    }

    class d implements ReportNumHttp.Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ HashMap f20171a;

        d(HashMap hashMap) {
            this.f20171a = hashMap;
        }

        @Override // network.http.ReportNumHttp.Callback
        public void onNumSuccess() {
            if (VerifyFacePresenter.this.toolUrl(ModuelConfig.MODEL_REPORT)) {
                Intent intent = new Intent();
                HashMap hashMap = this.f20171a;
                if (hashMap != null && !hashMap.isEmpty()) {
                    intent = k1.a(intent, (HashMap<String, Object>) this.f20171a);
                }
                intent.addFlags(c.c.a.b.a.a.B1);
                intent.addFlags(CommonNetImpl.FLAG_SHARE);
                intent.setClass(VerifyFacePresenter.this.mActivity, ReportNewActivity.class);
                VerifyFacePresenter.this.mActivity.startActivity(intent);
            }
        }
    }

    class e extends MiddleSubscriber<APIresult> {
        e() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            w1.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult.getCode() == 0) {
                ((VerifyFaceCallview) VerifyFacePresenter.this.mvpView).onSuccessUnbind();
                w1.a(aPIresult.getMsg());
            } else if (aPIresult.getCode() != 4) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((VerifyFaceCallview) VerifyFacePresenter.this.mvpView).onSuccessUnbindOverrun();
                w1.a(aPIresult.getMsg());
            }
        }
    }

    public VerifyFacePresenter(Activity activity, VerifyFaceCallview verifyFaceCallview) {
        super(activity, verifyFaceCallview);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean toolUrl(String str) {
        RegionMudelBean j2 = d.a.j();
        if (j2 == null) {
            return true;
        }
        if (j2.getTool() == null || j2.getTool().size() <= 0) {
            return false;
        }
        for (HomeToolBean homeToolBean : j2.getTool()) {
            if (TextUtils.equals(homeToolBean.getId(), str) && !TextUtils.isEmpty(homeToolBean.getModule())) {
                k1.a(this.mActivity, homeToolBean.getModule());
                return false;
            }
            if (TextUtils.equals(homeToolBean.getModule(), str)) {
                return true;
            }
        }
        return false;
    }

    public void redName(String str, String str2, String str3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(CommonNetImpl.NAME, str);
        hashMap.put("documentType", str3);
        hashMap.put("idNumber", str2);
        redName(d.a.a("", 8, e.b.Q), hashMap, new a());
    }

    public void resultSuccess(String str, String str2) {
        AccountManager.setVerified(true, str, str2);
        int a2 = u1.a(u1.x0, -1);
        HashMap<String, Object> hashMap = z1.v;
        if (a2 == 4) {
            org.greenrobot.eventbus.c.f().d(new util.c2.a(20));
        } else if (a2 == 13) {
            Intent intent = new Intent();
            intent.setClass(this.mActivity, PoliceLoginActivity.class);
            this.mActivity.startActivity(intent);
        } else if (a2 == 6) {
            RegionMudelBean j2 = d.a.j();
            if (j2 == null || TextUtils.isEmpty(j2.getRiskCheck())) {
                this.mActivity.startActivity(new Intent(this.mActivity, (Class<?>) CheckFraudActivity.class));
            } else {
                k1.a(this.mActivity, j2.getH5Url() + j2.getRiskCheck());
            }
        } else if (a2 == 7) {
            Intent intent2 = new Intent();
            intent2.setClass(this.mActivity, AppUploadActivity.class);
            this.mActivity.startActivity(intent2);
        } else if (a2 != 8) {
            if (a2 == 10) {
                org.greenrobot.eventbus.c.f().d(new util.c2.a(21));
            } else if (a2 != 11) {
                switch (a2) {
                    case 15:
                        this.mActivity.startActivity(new Intent(this.mActivity, (Class<?>) IDVarfyAceptListActivity.class));
                        break;
                    case 16:
                        org.greenrobot.eventbus.c.f().d(new util.c2.a(util.c2.a.y0));
                        break;
                    case 17:
                        org.greenrobot.eventbus.c.f().d(new util.c2.a(util.c2.a.z0));
                        break;
                    case 18:
                        Intent intent3 = new Intent(this.mActivity, (Class<?>) WebActivity.class);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            intent3 = k1.a(intent3, hashMap);
                            intent3.setClass(this.mActivity, WebActivity.class);
                        }
                        this.mActivity.startActivity(intent3);
                        break;
                    case 19:
                        if (hashMap != null && !hashMap.isEmpty()) {
                            k1.a((Context) this.mActivity, hashMap.get(k1.Q).toString());
                            break;
                        }
                        break;
                    case 20:
                        Intent intent4 = new Intent(this.mActivity, (Class<?>) WebFullActivity.class);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            intent4 = k1.a(intent4, hashMap);
                            intent4.setClass(this.mActivity, WebFullActivity.class);
                        }
                        this.mActivity.startActivity(intent4);
                        break;
                    default:
                        switch (a2) {
                            case 1011:
                                ReportNumHttp.getInstance().principalHttp(new d(hashMap));
                                break;
                            case 1012:
                                if (toolUrl(ModuelConfig.MODEL_CASEXC)) {
                                    Intent intent5 = new Intent();
                                    intent5.setClass(this.mActivity, ReporterAidActivity.class);
                                    this.mActivity.startActivity(intent5);
                                    break;
                                }
                                break;
                            case 1013:
                                Activity activity = this.mActivity;
                                activity.startActivity(new Intent(activity, (Class<?>) WarnSettingActivity.class));
                                break;
                            case 1014:
                                if (toolUrl(ModuelConfig.MODEL_IDVERIFY)) {
                                    this.mActivity.startActivity(new Intent(this.mActivity, (Class<?>) CheckIDActivity.class));
                                    break;
                                }
                                break;
                        }
                }
            } else {
                this.mActivity.startActivity(new Intent(this.mActivity, (Class<?>) ManualActivity.class));
            }
        }
        ui.c.i().a(VerifyFaceActivity.class);
    }

    public void startLive() {
        startLiveFace(new b());
    }

    public void unbind(String str, String str2, String str3, String str4) {
        VerifyBody verifyBody = new VerifyBody();
        verifyBody.setVerificationLogID(str3);
        verifyBody.setName(str);
        verifyBody.setIdentityCardNum(str2);
        verifyBody.setAreaCode(RegionConfigHttp.getNodeRegionId());
        verifyBody.setApiAddress(str4);
        String str5 = d.a.f13516b + e.b.O;
        if (d.a.j() != null) {
            str5 = d.a.a("", 3, e.b.P);
        }
        postOperation(str5, JNIHandStamp.getInstance().pamramToMap(verifyBody), new e());
    }

    public void verify(String str, String str2, String str3, String str4, String str5) {
        VerifyBody verifyBody = new VerifyBody();
        verifyBody.setVerificationLogID(str4);
        verifyBody.setName(str2);
        verifyBody.setIdentityCardNum(str3);
        verifyBody.setImage(str);
        verifyBody.setAreaCode(RegionConfigHttp.getNodeRegionId());
        verifyBody.setApiAddress(str5);
        verifyHttp(JNIHandStamp.getInstance().pamramToMap(verifyBody), false, new c());
    }
}
