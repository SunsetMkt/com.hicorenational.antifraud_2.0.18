package p388ui.presenter;

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
import org.greenrobot.eventbus.C6049c;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p245d.C4440a;
import p247e.C4445b;
import p388ui.C6813c;
import p388ui.activity.AppUploadActivity;
import p388ui.activity.CheckFraudActivity;
import p388ui.activity.CheckIDActivity;
import p388ui.activity.IDVarfyAceptListActivity;
import p388ui.activity.ManualActivity;
import p388ui.activity.PoliceLoginActivity;
import p388ui.activity.ReportNewActivity;
import p388ui.activity.ReporterAidActivity;
import p388ui.activity.VerifyFaceActivity;
import p388ui.activity.WarnSettingActivity;
import p388ui.activity.WebActivity;
import p388ui.activity.WebFullActivity;
import p388ui.callview.VerifyFaceCallview;
import util.C7292k1;
import util.C7325u1;
import util.C7331w1;
import util.C7340z1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class VerifyFacePresenter extends YCLicencePresenter<VerifyFaceCallview> {

    /* renamed from: ui.presenter.VerifyFacePresenter$a */
    class C7104a extends MiddleSubscriber<APIresult<Boolean>> {
        C7104a() {
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return Boolean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            C7331w1.m26696e(aPIException.getMessage());
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

    /* renamed from: ui.presenter.VerifyFacePresenter$b */
    class C7105b implements IFaceLiveCallBack {
        C7105b() {
        }

        @Override // interfaces.IFaceLiveCallBack
        public void onLivenessFail(int i2) {
        }

        @Override // interfaces.IFaceLiveCallBack
        public void onLivenessSuccess(byte[] bArr) {
            ((VerifyFaceCallview) VerifyFacePresenter.this.mvpView).onSuccImaggRequest(bArr);
        }
    }

    /* renamed from: ui.presenter.VerifyFacePresenter$c */
    class C7106c implements IFaceResultView {
        C7106c() {
        }

        @Override // interfaces.IFaceResultView
        public void onSuccRequest(Message message) {
            ((VerifyFaceCallview) VerifyFacePresenter.this.mvpView).onSuccRequest(message);
        }
    }

    /* renamed from: ui.presenter.VerifyFacePresenter$d */
    class C7107d implements ReportNumHttp.Callback {

        /* renamed from: a */
        final /* synthetic */ HashMap f24357a;

        C7107d(HashMap hashMap) {
            this.f24357a = hashMap;
        }

        @Override // network.http.ReportNumHttp.Callback
        public void onNumSuccess() {
            if (VerifyFacePresenter.this.toolUrl(ModuelConfig.MODEL_REPORT)) {
                Intent intent = new Intent();
                HashMap hashMap = this.f24357a;
                if (hashMap != null && !hashMap.isEmpty()) {
                    intent = C7292k1.m26390a(intent, (HashMap<String, Object>) this.f24357a);
                }
                intent.addFlags(AbstractC1191a.f2487B1);
                intent.addFlags(CommonNetImpl.FLAG_SHARE);
                intent.setClass(VerifyFacePresenter.this.mActivity, ReportNewActivity.class);
                VerifyFacePresenter.this.mActivity.startActivity(intent);
            }
        }
    }

    /* renamed from: ui.presenter.VerifyFacePresenter$e */
    class C7108e extends MiddleSubscriber<APIresult> {
        C7108e() {
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            if (super.dealPoliceExit(aPIException)) {
                return;
            }
            C7331w1.m26696e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult.getCode() == 0) {
                ((VerifyFaceCallview) VerifyFacePresenter.this.mvpView).onSuccessUnbind();
                C7331w1.m26688a(aPIresult.getMsg());
            } else if (aPIresult.getCode() != 4) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((VerifyFaceCallview) VerifyFacePresenter.this.mvpView).onSuccessUnbindOverrun();
                C7331w1.m26688a(aPIresult.getMsg());
            }
        }
    }

    public VerifyFacePresenter(Activity activity, VerifyFaceCallview verifyFaceCallview) {
        super(activity, verifyFaceCallview);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean toolUrl(String str) {
        RegionMudelBean m16408j = C4440a.m16408j();
        if (m16408j == null) {
            return true;
        }
        if (m16408j.getTool() == null || m16408j.getTool().size() <= 0) {
            return false;
        }
        for (HomeToolBean homeToolBean : m16408j.getTool()) {
            if (TextUtils.equals(homeToolBean.getId(), str) && !TextUtils.isEmpty(homeToolBean.getModule())) {
                C7292k1.m26393a(this.mActivity, homeToolBean.getModule());
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
        redName(C4440a.m16395a("", 8, C4445b.f17033Q), hashMap, new C7104a());
    }

    public void resultSuccess(String str, String str2) {
        AccountManager.setVerified(true, str, str2);
        int m26613a = C7325u1.m26613a(C7325u1.f25707x0, -1);
        HashMap<String, Object> hashMap = C7340z1.f25774v;
        if (m26613a == 4) {
            C6049c.m24987f().m25000d(new C7265a(20));
        } else if (m26613a == 13) {
            Intent intent = new Intent();
            intent.setClass(this.mActivity, PoliceLoginActivity.class);
            this.mActivity.startActivity(intent);
        } else if (m26613a == 6) {
            RegionMudelBean m16408j = C4440a.m16408j();
            if (m16408j == null || TextUtils.isEmpty(m16408j.getRiskCheck())) {
                this.mActivity.startActivity(new Intent(this.mActivity, (Class<?>) CheckFraudActivity.class));
            } else {
                C7292k1.m26393a(this.mActivity, m16408j.getH5Url() + m16408j.getRiskCheck());
            }
        } else if (m26613a == 7) {
            Intent intent2 = new Intent();
            intent2.setClass(this.mActivity, AppUploadActivity.class);
            this.mActivity.startActivity(intent2);
        } else if (m26613a != 8) {
            if (m26613a == 10) {
                C6049c.m24987f().m25000d(new C7265a(21));
            } else if (m26613a != 11) {
                switch (m26613a) {
                    case 15:
                        this.mActivity.startActivity(new Intent(this.mActivity, (Class<?>) IDVarfyAceptListActivity.class));
                        break;
                    case 16:
                        C6049c.m24987f().m25000d(new C7265a(C7265a.f25273y0));
                        break;
                    case 17:
                        C6049c.m24987f().m25000d(new C7265a(C7265a.f25275z0));
                        break;
                    case 18:
                        Intent intent3 = new Intent(this.mActivity, (Class<?>) WebActivity.class);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            intent3 = C7292k1.m26390a(intent3, hashMap);
                            intent3.setClass(this.mActivity, WebActivity.class);
                        }
                        this.mActivity.startActivity(intent3);
                        break;
                    case 19:
                        if (hashMap != null && !hashMap.isEmpty()) {
                            C7292k1.m26394a((Context) this.mActivity, hashMap.get(C7292k1.f25365Q).toString());
                            break;
                        }
                        break;
                    case 20:
                        Intent intent4 = new Intent(this.mActivity, (Class<?>) WebFullActivity.class);
                        if (hashMap != null && !hashMap.isEmpty()) {
                            intent4 = C7292k1.m26390a(intent4, hashMap);
                            intent4.setClass(this.mActivity, WebFullActivity.class);
                        }
                        this.mActivity.startActivity(intent4);
                        break;
                    default:
                        switch (m26613a) {
                            case 1011:
                                ReportNumHttp.getInstance().principalHttp(new C7107d(hashMap));
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
        C6813c.m25437i().m25442a(VerifyFaceActivity.class);
    }

    public void startLive() {
        startLiveFace(new C7105b());
    }

    public void unbind(String str, String str2, String str3, String str4) {
        VerifyBody verifyBody = new VerifyBody();
        verifyBody.setVerificationLogID(str3);
        verifyBody.setName(str);
        verifyBody.setIdentityCardNum(str2);
        verifyBody.setAreaCode(RegionConfigHttp.getNodeRegionId());
        verifyBody.setApiAddress(str4);
        String str5 = C4440a.f16880b + C4445b.f17027O;
        if (C4440a.m16408j() != null) {
            str5 = C4440a.m16395a("", 3, C4445b.f17030P);
        }
        postOperation(str5, JNIHandStamp.getInstance().pamramToMap(verifyBody), new C7108e());
    }

    public void verify(String str, String str2, String str3, String str4, String str5) {
        VerifyBody verifyBody = new VerifyBody();
        verifyBody.setVerificationLogID(str4);
        verifyBody.setName(str2);
        verifyBody.setIdentityCardNum(str3);
        verifyBody.setImage(str);
        verifyBody.setAreaCode(RegionConfigHttp.getNodeRegionId());
        verifyBody.setApiAddress(str5);
        verifyHttp(JNIHandStamp.getInstance().pamramToMap(verifyBody), false, new C7106c());
    }
}
