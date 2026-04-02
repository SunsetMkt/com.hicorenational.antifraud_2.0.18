package ui.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.PermissionRequest;
import android.webkit.WebView;
import androidx.core.content.FileProvider;
import bean.DownLoadPdfBean;
import bean.FileInfo;
import bean.PolicBean;
import bean.ShareConfigBean;
import bean.SurveyH5Bean;
import bean.SurveyToH5Bean;
import bean.module.ModuelConfig;
import com.xiaomi.mipush.sdk.Constants;
import interfaces.IClickListener;
import interfaces.IVerifyListener;
import interfaces.PermissionsListener;
import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import manager.LoginManager;
import network.APIException;
import network.MiddleSubscriber;
import network.account.APIresult;
import network.gson.ObjectTypeAdapter;
import network.gson.ResponseDataTypeAdaptor;
import network.http.ReportNumHttp;
import ui.activity.CallRecordNewActivity;
import ui.activity.ReportNewActivity;
import ui.activity.SmsRecordSelectActivity;
import ui.callview.WebFullCallView;
import ui.model.OSSModelPresent;
import ui.view.MyWebView;
import util.a2;
import util.e2;
import util.f1;
import util.g2;
import util.h2;
import util.j1;
import util.p1;
import util.s1;
import zxing.android.CaptureActivity;

/* JADX INFO: loaded from: classes2.dex */
public class WebFullPresenter extends OSSModelPresent<WebFullCallView> {
    private String TAG;
    private final String mEventTag;
    private HashMap<Object, String> mHashMap;
    private int mMaxSelNum;
    private ui.f.c mShareDialog;
    private WebView mWebview;
    private a2.b selectFileCallBack;

    class a implements PermissionsListener {
        final /* synthetic */ PermissionRequest a;

        a(PermissionRequest permissionRequest) {
            this.a = permissionRequest;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            if (this.a == null) {
                WebFullPresenter.this.camerPrimssDlg(z);
            } else {
                util.permissionutil.c.a(WebFullPresenter.this.mActivity, list, z, false, this);
                this.a.deny();
            }
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            if ("vivo" != Build.BRAND || Build.VERSION.SDK_INT != 23) {
                PermissionRequest permissionRequest = this.a;
                if (permissionRequest == null) {
                    WebFullPresenter.this.goScan();
                    return;
                } else {
                    permissionRequest.grant(new String[]{"android.webkit.resource.VIDEO_CAPTURE"});
                    return;
                }
            }
            if (!util.permissionutil.c.f()) {
                PermissionRequest permissionRequest2 = this.a;
                if (permissionRequest2 != null) {
                    permissionRequest2.deny();
                }
                p1.j(WebFullPresenter.this.mActivity);
                return;
            }
            PermissionRequest permissionRequest3 = this.a;
            if (permissionRequest3 == null) {
                WebFullPresenter.this.goScan();
            } else {
                permissionRequest3.grant(new String[]{"android.webkit.resource.VIDEO_CAPTURE"});
            }
        }
    }

    class b implements IClickListener {
        final /* synthetic */ boolean a;

        b(boolean z) {
            this.a = z;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            if (this.a) {
                p1.j(WebFullPresenter.this.mActivity);
            } else {
                WebFullPresenter.this.varCamerPrims();
            }
        }
    }

    class c implements PermissionsListener {
        final /* synthetic */ int a;

        c(int i2) {
            this.a = i2;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(WebFullPresenter.this.mActivity, list, z, false, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            Intent intent = new Intent(WebFullPresenter.this.mActivity, (Class<?>) SmsRecordSelectActivity.class);
            intent.putExtra(SmsRecordSelectActivity.f13859h, 1);
            intent.putExtra("extra_select_can", this.a);
            WebFullPresenter.this.mActivity.startActivity(intent);
        }
    }

    class d implements PermissionsListener {
        final /* synthetic */ int a;

        d(int i2) {
            this.a = i2;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(WebFullPresenter.this.mActivity, list, z, false, this);
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            Intent intent = new Intent(WebFullPresenter.this.mActivity, (Class<?>) CallRecordNewActivity.class);
            intent.putExtra("extra_select_can", this.a);
            WebFullPresenter.this.mActivity.startActivity(intent);
        }
    }

    class e extends MiddleSubscriber<APIresult<SurveyToH5Bean>> {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ String f14444b;

        e(String str, String str2) {
            this.a = str;
            this.f14444b = str2;
        }

        @Override // network.MiddleSubscriber
        protected Type getType() {
            return SurveyToH5Bean.class;
        }

        @Override // network.MiddleSubscriber
        protected void onErrorMiddle(APIException aPIException) {
            super.onErrorMiddle(aPIException);
            WebFullPresenter.this.appCallH5(this.f14444b, "\"errorMsg\":\"" + aPIException.getMessage() + "\"", false);
        }

        @Override // network.MiddleSubscriber
        protected void onNextMiddle(APIresult<SurveyToH5Bean> aPIresult) {
            super.onNextMiddle(aPIresult);
            if (this.a.contains("getxccasecategorysv2")) {
                WebFullPresenter.this.appCallH5(this.f14444b, "\"response\":" + aPIresult.getEncodeStr(), true);
                return;
            }
            WebFullPresenter.this.appCallH5(this.f14444b, "\"response\":" + aPIresult.getEncodeStr(), false);
        }
    }

    class f implements a2.b {
        f() {
        }

        @Override // util.a2.b
        public void a(List<FileInfo> list) {
            if (list.size() > 0) {
                String strA = new com.google.gson.e().a(list);
                WebFullPresenter.this.appCallH5Map(23, "\"response\":" + strA, false);
                String str = "\"response\":" + strA;
            }
        }
    }

    public WebFullPresenter(WebView webView, Activity activity, WebFullCallView webFullCallView) {
        super(activity, webFullCallView);
        this.TAG = WebFullPresenter.class.getSimpleName();
        this.mEventTag = "event";
        this.mShareDialog = null;
        this.mMaxSelNum = 6;
        this.mHashMap = null;
        this.selectFileCallBack = new f();
        this.mWebview = webView;
    }

    private void callPermission(int i2) {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.f15035l}, new d(i2));
    }

    public void camerPrimssDlg(boolean z) {
        f1.f(this.mActivity, "\u6743\u9650\u5f00\u542f", "\u56fd\u5bb6\u53cd\u8bc8\u4e2d\u5fc3\u672a\u53d6\u5f97\u6743\u9650\uff0c\u8fd9\u6837\u4f1a\u5bfc\u81f4\u6b64\u529f\u80fd\u65e0\u6cd5\u4f7f\u7528\u3002", "\u53d6\u6d88", "\u53bb\u6388\u6743", new b(z));
    }

    public void goScan() {
        this.mActivity.startActivityForResult(new Intent(this.mActivity, (Class<?>) CaptureActivity.class), 0);
    }

    private void savePdfWx(Map<String, Object> map) {
        DownLoadPdfBean downLoadPdfBean = (DownLoadPdfBean) ResponseDataTypeAdaptor.buildGson().a(String.valueOf(map.get(SurveyH5Bean.VALUE)), DownLoadPdfBean.class);
        if (downLoadPdfBean != null) {
            String path = this.mActivity.getFilesDir().getPath();
            if (!a2.a(downLoadPdfBean.fileName, downLoadPdfBean.fileData, path)) {
                e2.a("\u6587\u4ef6\u4fdd\u5b58\u5f02\u5e38");
                return;
            }
            e2.a("\u6587\u4ef6\u4fdd\u5b58\u6210\u529f");
            File file = new File(j1.b(this.mContext, Uri.parse(path + "/" + downLoadPdfBean.fileName)));
            if (file.exists()) {
                Uri uriForFile = FileProvider.getUriForFile(this.mContext, this.mActivity.getPackageName() + ".provider", file);
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("application/pdf");
                intent.putExtra("android.intent.extra.STREAM", uriForFile);
                intent.addFlags(1);
                intent.putExtra("android.intent.extra.SUBJECT", "\u5206\u4eabPDF\u6587\u4ef6");
                intent.putExtra("android.intent.extra.TEXT", "\u67e5\u770b\u6b64PDF\u6587\u6863");
                intent.setPackage("com.tencent.mm");
                this.mActivity.startActivity(Intent.createChooser(intent, "\u5206\u4eab\u5230\u5fae\u4fe1"));
            }
        }
    }

    private void smsPermission(int i2) {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.w, util.permissionutil.a.v}, new c(i2));
    }

    public void SurveyH5Http(String str, Map<String, Object> map, String str2) {
        s1.b(this.TAG, "url==" + str2);
        SurveyH5Param(map, str2, new e(str2, str));
    }

    public void SurveyH5Param(String str) {
        s1.b(this.TAG, "prodet js param==" + str);
        SurveyH5Bean surveyH5Bean = (SurveyH5Bean) ObjectTypeAdapter.buildNewGson().a(str, SurveyH5Bean.class);
        if (surveyH5Bean != null) {
            Map<String, Object> map = new HashMap<>();
            if (surveyH5Bean.getParams() != null) {
                map = surveyH5Bean.getParams();
            }
            if (TextUtils.equals(SurveyH5Bean.POST, surveyH5Bean.getType())) {
                SurveyH5Http(str, map, e.a.c(surveyH5Bean.getTransChannel()) + surveyH5Bean.getApiUrl());
                return;
            }
            if (TextUtils.equals("audio", surveyH5Bean.getType())) {
                return;
            }
            if (TextUtils.equals("event", surveyH5Bean.getType())) {
                eventH5Action(str, map);
                return;
            }
            if (TextUtils.equals("call", surveyH5Bean.getType())) {
                if (map.containsKey(SurveyH5Bean.SELECTNUM)) {
                    callPermission(Integer.parseInt(map.get(SurveyH5Bean.SELECTNUM).toString()));
                }
            } else if (!TextUtils.equals(SurveyH5Bean.SMS, surveyH5Bean.getType())) {
                eventH5Action(str, map);
            } else if (map.containsKey(SurveyH5Bean.SELECTNUM)) {
                smsPermission(Integer.parseInt(map.get(SurveyH5Bean.SELECTNUM).toString()));
            }
        }
    }

    public /* synthetic */ void a() {
        ReportNumHttp.getInstance().principalHttp(new ReportNumHttp.Callback() { // from class: ui.presenter.g0
            @Override // network.http.ReportNumHttp.Callback
            public final void onNumSuccess() {
                this.a.b();
            }
        });
    }

    public void appCallH5(String str, String str2, boolean z) {
        String str3 = str.substring(0, str.lastIndexOf(125)) + Constants.ACCEPT_TIME_SEPARATOR_SP + str2 + "}";
        if (this.mWebview != null) {
            if (!z) {
                final String str4 = "javascript:appCallH5(" + str3 + ")";
                s1.a(this.TAG, "js===" + str4);
                this.mWebview.postDelayed(new Runnable() { // from class: ui.presenter.e0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b(str4);
                    }
                }, 0L);
                return;
            }
            final String str5 = "javascript:appCallH5('" + str3 + "')";
            s1.a(this.TAG, "js===" + str5);
            this.mWebview.postDelayed(new Runnable() { // from class: ui.presenter.d0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a(str5);
                }
            }, 0L);
        }
    }

    public void appCallH5Map(int i2, String str, boolean z) {
        appCallH5(this.mHashMap.get("event" + i2), str, z);
        this.mHashMap.remove("event" + i2);
    }

    public void appCallH5Other(String str, String str2) {
        if (this.mWebview != null) {
            final String str3 = "javascript:" + str + "(" + str2 + ")";
            s1.a(str + " appCallH5Other-->", str3);
            this.mWebview.postDelayed(new Runnable() { // from class: ui.presenter.f0
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.c(str3);
                }
            }, 0L);
        }
    }

    public /* synthetic */ void b() {
        g2.a((Context) this.mActivity, (Class<?>) ReportNewActivity.class);
    }

    public /* synthetic */ void c(String str) {
        this.mWebview.evaluateJavascript(str, null);
    }

    public /* synthetic */ void d(String str) {
        appCallH5(str, "\"response\":{\"verifiedStatus\":\"1\"}", false);
    }

    public void eventH5Action(final String str, Map<String, Object> map) {
        if (!map.containsKey("action") || map.get("action") == null) {
            return;
        }
        int i2 = Integer.parseInt(map.get("action").toString());
        switch (i2) {
            case 1:
            case 6:
                break;
            case 2:
                if (map.containsKey(SurveyH5Bean.VALUE)) {
                    if (!TextUtils.equals("0", String.valueOf(map.get(SurveyH5Bean.VALUE)))) {
                        ui.statusbarcompat.b.a(this.mActivity, true, false);
                    } else {
                        ui.statusbarcompat.b.a(this.mActivity, true, true);
                    }
                }
                break;
            case 3:
                putActionMap("event3", str);
                varCamerPrims();
                break;
            case 4:
                appCallH5(str, "\"response\":" + ui.view.z.b(), false);
                break;
            case 5:
                putActionMap("event5", str);
                h2.a(this.mActivity).a(17, new IVerifyListener() { // from class: ui.presenter.i0
                    @Override // interfaces.IVerifyListener
                    public final void onSuccessVerify() {
                        this.a.d(str);
                    }
                });
                break;
            case 7:
                LoginManager.getInstance().exitToLogin();
                break;
            case 8:
                String strValueOf = String.valueOf(map.get(SurveyH5Bean.VALUE));
                PolicBean policBean = new PolicBean();
                policBean.setPoliceToken(strValueOf);
                e.b.a(policBean);
                break;
            case 9:
                e.b.e();
                break;
            case 10:
                this.mMaxSelNum = Integer.parseInt(map.get(SurveyH5Bean.VALUE).toString());
                break;
            case 11:
                ShareConfigBean shareConfigBean = (ShareConfigBean) ResponseDataTypeAdaptor.buildGson().a(map.get(SurveyH5Bean.VALUE).toString(), ShareConfigBean.class);
                if (shareConfigBean != null) {
                    if (!TextUtils.isEmpty(shareConfigBean.downloadUrl)) {
                        shareConfigBean.downloadUrl = shareConfigBean.downloadUrl.replace("{0}", e.a.m() + "");
                    }
                    this.mShareDialog = new ui.f.c(this.mActivity, shareConfigBean, 2, null);
                    this.mShareDialog.show();
                }
                break;
            case 12:
                appCallH5(str, "\"response\":{\"result\":\"" + (TextUtils.equals(String.valueOf(map.get(SurveyH5Bean.VALUE)), e.b.c()) ? "1" : "0") + "\"}", false);
                break;
            case 13:
                appCallH5(str, "\"response\":{\"result\":\"" + (TextUtils.equals(String.valueOf(map.get(SurveyH5Bean.VALUE)), e.b.b()) ? "1" : "0") + "\"}", false);
                break;
            case 14:
            case 15:
            case 17:
            case 18:
            default:
                ((WebFullCallView) ((OSSModelPresent) this).mvpView).eventH5Action(i2, str, map);
                break;
            case 16:
                MyWebView.cleanCache();
                break;
            case 19:
                h2.a(this.mActivity).a(Integer.parseInt(ModuelConfig.MODEL_REPORT), new IVerifyListener() { // from class: ui.presenter.h0
                    @Override // interfaces.IVerifyListener
                    public final void onSuccessVerify() {
                        this.a.a();
                    }
                });
                break;
            case 20:
                org.greenrobot.eventbus.c.f().d(new util.n2.a(104, null));
                break;
            case 21:
                org.greenrobot.eventbus.c.f().d(new util.n2.a(354, true));
                break;
            case 22:
                org.greenrobot.eventbus.c.f().d(new util.n2.a(354, false));
                break;
            case 23:
                if (map.containsKey(SurveyH5Bean.VALUE)) {
                    putActionMap("event23", str);
                    a2.a(this.mActivity, Integer.parseInt(String.valueOf(map.get(SurveyH5Bean.VALUE))), this.selectFileCallBack);
                }
                break;
            case 24:
                savePdfWx(map);
                break;
        }
    }

    public void jsShowPage() {
        WebView webView = this.mWebview;
        if (webView != null) {
            webView.loadUrl("javascript:showpage()");
        }
    }

    public void putActionMap(Object obj, String str) {
        if (this.mHashMap == null) {
            this.mHashMap = new HashMap<>();
        }
        this.mHashMap.put(obj, str);
    }

    public void varCamerPrims() {
        varCamerPrims(null);
    }

    public /* synthetic */ void a(String str) {
        this.mWebview.evaluateJavascript(str, null);
    }

    public /* synthetic */ void b(String str) {
        this.mWebview.evaluateJavascript(str, null);
    }

    public void varCamerPrims(PermissionRequest permissionRequest) {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.f15026c}, new a(permissionRequest));
    }
}
