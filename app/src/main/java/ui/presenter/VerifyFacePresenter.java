package ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
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
import util.c2;
import util.e2;
import util.h2;
import util.p1;

/* JADX INFO: loaded from: classes2.dex */
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
            e2.e(aPIException.getMessage());
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
        final /* synthetic */ HashMap a;

        d(HashMap map) {
            this.a = map;
        }

        @Override // network.http.ReportNumHttp.Callback
        public void onNumSuccess() {
            if (VerifyFacePresenter.this.toolUrl(ModuelConfig.MODEL_REPORT)) {
                Intent intent = new Intent();
                HashMap map = this.a;
                if (map != null && !map.isEmpty()) {
                    intent = p1.a(intent, (HashMap<String, Object>) this.a);
                }
                intent.addFlags(d.c.a.b.a.a.B1);
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
            e2.e(aPIException.getMessage());
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult aPIresult) {
            if (aPIresult.getCode() == 0) {
                ((VerifyFaceCallview) VerifyFacePresenter.this.mvpView).onSuccessUnbind();
                e2.a(aPIresult.getMsg());
            } else if (aPIresult.getCode() != 4) {
                onErrorMiddle(APIException.getApiExcept(aPIresult));
            } else {
                ((VerifyFaceCallview) VerifyFacePresenter.this.mvpView).onSuccessUnbindOverrun();
                e2.a(aPIresult.getMsg());
            }
        }
    }

    public VerifyFacePresenter(Activity activity, VerifyFaceCallview verifyFaceCallview) {
        super(activity, verifyFaceCallview);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean toolUrl(String str) {
        return true;
    }

    public void redName(String str, String str2, String str3) {
        HashMap<String, String> map = new HashMap<>();
        map.put(CommonNetImpl.NAME, str);
        map.put("documentType", str3);
        map.put("idNumber", str2);
        redName(e.a.b("", 8, f.b.R), map, new a());
    }

    public void resultSuccess(String str, String str2) {
        AccountManager.setVerified(true, str, str2);
        int iA = c2.a(c2.x0, -1);
        HashMap<String, Object> map = h2.v;
        if (iA == 4) {
            org.greenrobot.eventbus.c.f().d(new util.n2.a(20));
        } else if (iA == 13) {
            Intent intent = new Intent();
            intent.setClass(this.mActivity, PoliceLoginActivity.class);
            this.mActivity.startActivity(intent);
        } else if (iA == 6) {
            RegionMudelBean regionMudelBeanJ = e.a.j();
            if (regionMudelBeanJ == null || TextUtils.isEmpty(regionMudelBeanJ.getRiskCheck())) {
                this.mActivity.startActivity(new Intent(this.mActivity, (Class<?>) CheckFraudActivity.class));
            } else {
                p1.a(this.mActivity, regionMudelBeanJ.getH5Url() + regionMudelBeanJ.getRiskCheck());
            }
        } else if (iA == 7) {
            Intent intent2 = new Intent();
            intent2.setClass(this.mActivity, AppUploadActivity.class);
            this.mActivity.startActivity(intent2);
        } else if (iA != 8) {
            if (iA == 10) {
                org.greenrobot.eventbus.c.f().d(new util.n2.a(21));
            } else if (iA != 11) {
                switch (iA) {
                    case 15:
                        this.mActivity.startActivity(new Intent(this.mActivity, (Class<?>) IDVarfyAceptListActivity.class));
                        break;
                    case 16:
                        org.greenrobot.eventbus.c.f().d(new util.n2.a(util.n2.a.y0));
                        break;
                    case 17:
                        org.greenrobot.eventbus.c.f().d(new util.n2.a(util.n2.a.z0));
                        break;
                    case 18:
                        Intent intent3 = new Intent(this.mActivity, (Class<?>) WebActivity.class);
                        if (map != null && !map.isEmpty()) {
                            intent3 = p1.a(intent3, map);
                            intent3.setClass(this.mActivity, WebActivity.class);
                        }
                        this.mActivity.startActivity(intent3);
                        break;
                    case 19:
                        if (map != null && !map.isEmpty()) {
                            p1.a((Context) this.mActivity, map.get(p1.Q).toString());
                        }
                        break;
                    case 20:
                        Intent intent4 = new Intent(this.mActivity, (Class<?>) WebFullActivity.class);
                        if (map != null && !map.isEmpty()) {
                            intent4 = p1.a(intent4, map);
                            intent4.setClass(this.mActivity, WebFullActivity.class);
                        }
                        this.mActivity.startActivity(intent4);
                        break;
                    default:
                        switch (iA) {
                            case 1011:
                                ReportNumHttp.getInstance().principalHttp(new d(map));
                                break;
                            case 1012:
                                if (toolUrl(ModuelConfig.MODEL_CASEXC)) {
                                    Intent intent5 = new Intent();
                                    intent5.setClass(this.mActivity, ReporterAidActivity.class);
                                    this.mActivity.startActivity(intent5);
                                }
                                break;
                            case 1013:
                                Activity activity = this.mActivity;
                                activity.startActivity(new Intent(activity, (Class<?>) WarnSettingActivity.class));
                                break;
                            case 1014:
                                if (toolUrl(ModuelConfig.MODEL_IDVERIFY)) {
                                    this.mActivity.startActivity(new Intent(this.mActivity, (Class<?>) CheckIDActivity.class));
                                }
                                break;
                        }
                        break;
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
        String strB = e.a.f10138b + f.b.P;
        if (e.a.j() != null) {
            strB = e.a.b("", 3, f.b.Q);
        }
        postOperation(strB, JNIHandStamp.getInstance().pamramToMap(verifyBody), new e());
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
