package ui.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import bean.AppInfoBean;
import bean.SurveyH5Bean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.just.agentweb.AbsAgentWebSettings;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.WebViewClient;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.umeng.analytics.pro.bh;
import interfaces.OnWebListener;
import interfaces.PermissionsListener;
import java.util.List;
import java.util.Map;
import network.gson.ResponseDataTypeAdaptor;
import org.greenrobot.eventbus.ThreadMode;
import ui.activity.H5AppSelectedActivity;
import ui.callview.WebFullCallView;
import ui.presenter.WebFullPresenter;
import ui.view.z;
import util.a2;
import util.g2;
import util.s1;
import util.w1;
import zxing.android.CaptureActivity;

/* JADX INFO: loaded from: classes2.dex */
public class LocalWebFragment extends BaseFragment implements WebFullCallView {
    private static WebView mWebview;
    private AgentWeb mAgentWeb;

    @BindView(R.id.web_container)
    LinearLayout mLinearLayout;

    @BindView(R.id.ll_network_no)
    View mLlNetworkNo;
    private WebFullPresenter mPresenter;

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    @BindView(R.id.ll_progress)
    View mProgressLoad;
    private ValueCallback<Uri[]> mUploadMessage5;
    private String orginUrl;
    private z viewFrag;
    private String TAG = LocalWebFragment.class.getSimpleName();
    private int mMaxSelNum = 6;

    class a implements OnWebListener {
        a() {
        }

        @Override // interfaces.OnWebListener
        public void shouldIntercept(util.o2.a aVar) {
        }

        @Override // interfaces.OnWebListener
        public void webJsFinish() {
            LocalWebFragment.this.onErrorView(false);
        }

        @Override // interfaces.OnWebListener
        public void webJsParame(String str) {
            LocalWebFragment.this.mPresenter.SurveyH5Param(str);
        }
    }

    class b implements PermissionsListener {
        final /* synthetic */ WebChromeClient.FileChooserParams a;

        b(WebChromeClient.FileChooserParams fileChooserParams) {
            this.a = fileChooserParams;
        }

        @Override // interfaces.PermissionsListener
        public void onDenied(List<String> list, boolean z) {
            util.permissionutil.c.a(LocalWebFragment.this.mActivity, list, z, true, this);
            LocalWebFragment.this.receiveCleanData();
        }

        @Override // interfaces.PermissionsListener
        public void onGranted() {
            String[] acceptTypes = this.a.getAcceptTypes();
            if (acceptTypes == null || acceptTypes.length <= 0) {
                return;
            }
            if (acceptTypes[0].contains("image")) {
                k.e.a(LocalWebFragment.this.mActivity, 200L, PictureMimeType.ofImage(), LocalWebFragment.this.mMaxSelNum).forResult(1001);
                return;
            }
            if (acceptTypes[0].contains("video")) {
                return;
            }
            if (acceptTypes[0].contains("audio")) {
                k.e.a(LocalWebFragment.this.mActivity, 200L, PictureMimeType.ofAudio(), LocalWebFragment.this.mMaxSelNum).forResult(1002);
            } else if (acceptTypes[0].contains("apk")) {
                Intent intent = new Intent(LocalWebFragment.this.mActivity, (Class<?>) H5AppSelectedActivity.class);
                intent.putExtra("extra_select_limite", LocalWebFragment.this.mMaxSelNum);
                LocalWebFragment.this.startActivityForResult(intent, 1003);
            }
        }
    }

    private class c extends com.just.agentweb.WebChromeClient {
        private c() {
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            if (Build.VERSION.SDK_INT >= 21) {
                for (String str : permissionRequest.getResources()) {
                    if (str.equals("android.webkit.resource.VIDEO_CAPTURE")) {
                        LocalWebFragment.this.mPresenter.varCamerPrims(permissionRequest);
                        return;
                    }
                }
            }
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            LocalWebFragment localWebFragment = LocalWebFragment.this;
            ProgressBar progressBar = localWebFragment.mProgressBar;
            if (progressBar == null || localWebFragment.mProgressLoad == null) {
                return;
            }
            if (i2 == 100) {
                progressBar.setVisibility(8);
                LocalWebFragment.this.mProgressLoad.setVisibility(8);
            } else {
                progressBar.setVisibility(0);
                LocalWebFragment.this.mProgressBar.setProgress(i2);
            }
        }

        @Override // com.just.agentweb.WebChromeClientDelegate, android.webkit.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            LocalWebFragment.this.mUploadMessage5 = valueCallback;
            LocalWebFragment.this.chooseFilePermission(fileChooserParams);
            return true;
        }

        /* synthetic */ c(LocalWebFragment localWebFragment, a aVar) {
            this();
        }
    }

    public class d extends WebViewClient {
        public d() {
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (!LocalWebFragment.this.networkStateDeal()) {
            }
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            LocalWebFragment.this.onErrorView(true);
            if (Build.VERSION.SDK_INT < 23 || !webResourceError.getDescription().toString().contains("ERR_CONNECTION_REFUSED")) {
                return;
            }
            LocalWebFragment.this.refreshPage();
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // com.just.agentweb.WebViewClientDelegate, android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            if (!webResourceRequest.getUrl().toString().startsWith("tel:")) {
                return super.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            g2.e(LocalWebFragment.this.mActivity, webResourceRequest.getUrl().toString());
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chooseFilePermission(WebChromeClient.FileChooserParams fileChooserParams) {
        util.permissionutil.c.a(this.mActivity, new String[]{util.permissionutil.a.A, util.permissionutil.a.z}, new b(fileChooserParams));
    }

    public static LocalWebFragment getInstance(String str) {
        LocalWebFragment localWebFragment = new LocalWebFragment();
        Bundle bundle = new Bundle();
        bundle.putString(bh.f7053e, str);
        localWebFragment.setArguments(bundle);
        return localWebFragment;
    }

    private void initAgentWeb() {
        this.mAgentWeb = AgentWeb.with(this).setAgentWebParent(this.mLinearLayout, new LinearLayout.LayoutParams(-1, -1)).closeIndicator().setWebViewClient(new d()).setWebChromeClient(new c(this, null)).addJavascriptInterface("appjs", this.viewFrag.a()).setAgentWebWebSettings(AbsAgentWebSettings.getInstance()).setMainFrameErrorView(R.layout.web_page_error, -1).createAgentWeb().ready().go(this.orginUrl);
        mWebview = this.mAgentWeb.getWebCreator().getWebView();
        mWebview.setHorizontalScrollBarEnabled(false);
        mWebview.getSettings().setTextZoom(100);
        mWebview.getSettings().setMediaPlaybackRequiresUserGesture(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean networkStateDeal() {
        if (this.mActivity.isFinishing()) {
            return false;
        }
        if (w1.f()) {
            return true;
        }
        onErrorView(true);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onErrorView(boolean z) {
        if (z) {
            View view = this.mLlNetworkNo;
            if (view != null) {
                view.setVisibility(0);
            }
            WebView webView = mWebview;
            if (webView != null) {
                webView.setVisibility(8);
                return;
            }
            return;
        }
        View view2 = this.mLlNetworkNo;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        WebView webView2 = mWebview;
        if (webView2 != null) {
            webView2.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void receiveCleanData() {
        ValueCallback<Uri[]> valueCallback = this.mUploadMessage5;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
            this.mUploadMessage5 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshPage() {
        if (mWebview == null || !networkStateDeal()) {
            return;
        }
        onErrorView(false);
        mWebview.reload();
    }

    public static void setPushUrl(String str) {
        WebView webView = mWebview;
        if (webView != null) {
            webView.loadUrl(str);
        }
    }

    @Override // ui.callview.WebFullCallView
    public void eventH5Action(int i2, String str, Map<String, Object> map) {
        if (i2 == 10) {
            this.mMaxSelNum = Integer.parseInt(map.get(SurveyH5Bean.VALUE).toString());
        } else {
            if (i2 != 15) {
                return;
            }
            onErrorView(false);
        }
    }

    @Override // ui.fragment.BaseFragment
    protected int getLayoutId() {
        return R.layout.activity_web_local;
    }

    @Override // ui.fragment.BaseFragment
    public void initPage() {
        this.orginUrl = getArguments().getString(bh.f7053e);
        this.viewFrag = new z();
        initAgentWeb();
        this.mPresenter = new WebFullPresenter(mWebview, this.mActivity, this);
        initWebViewListener();
    }

    protected void initWebViewListener() {
        this.viewFrag.a(this.mActivity, mWebview, new a());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        int i4 = 0;
        if (i2 != 0) {
            if (i2 != 1005) {
                switch (i2) {
                    case 1001:
                    case 1002:
                        List listObtainMultipleResult = PictureSelector.obtainMultipleResult(intent);
                        if (listObtainMultipleResult != null && listObtainMultipleResult.size() > 0) {
                            Uri[] uriArr = new Uri[listObtainMultipleResult.size()];
                            while (i4 < listObtainMultipleResult.size()) {
                                LocalMedia localMedia = (LocalMedia) listObtainMultipleResult.get(i4);
                                if (Build.VERSION.SDK_INT > 28) {
                                    uriArr[i4] = g2.c(this.mActivity, localMedia.getRealPath());
                                } else {
                                    uriArr[i4] = g2.c(this.mActivity, localMedia.getPath());
                                }
                                i4++;
                            }
                            this.mUploadMessage5.onReceiveValue(uriArr);
                            this.mUploadMessage5 = null;
                        }
                        receiveCleanData();
                        break;
                    case 1003:
                        List listObtainMultipleResult2 = PictureSelector.obtainMultipleResult(intent);
                        if (listObtainMultipleResult2 != null && listObtainMultipleResult2.size() > 0) {
                            Uri[] uriArr2 = new Uri[listObtainMultipleResult2.size()];
                            while (i4 < listObtainMultipleResult2.size()) {
                                AppInfoBean appInfoBean = (AppInfoBean) listObtainMultipleResult2.get(i4);
                                if (!TextUtils.isEmpty(appInfoBean.getUri())) {
                                    uriArr2[i4] = Uri.parse(appInfoBean.getUri());
                                }
                                i4++;
                            }
                            this.mUploadMessage5.onReceiveValue(uriArr2);
                            this.mUploadMessage5 = null;
                            this.mPresenter.appCallH5Other("getAppBackInfo", ResponseDataTypeAdaptor.buildGson().a(listObtainMultipleResult2));
                        }
                        receiveCleanData();
                        break;
                }
            }
        } else if (i3 == -1 && intent != null) {
            String stringExtra = intent.getStringExtra(CaptureActivity.f15121l);
            s1.b("content-->" + stringExtra);
            this.mPresenter.appCallH5Map(3, "\"response\":{\"scanValue\":\"" + stringExtra + "\"}", false);
        }
        a2.a(i2, i3, intent, getActivity());
    }

    public boolean onBackPressed() {
        WebView webView = mWebview;
        if (webView == null || !webView.canGoBack()) {
            return false;
        }
        mWebview.goBack();
        return true;
    }

    @Override // ui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.mAgentWeb.getWebLifeCycle().onDestroy();
        super.onDestroyView();
    }

    @org.greenrobot.eventbus.m(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(util.n2.a aVar) {
        if (aVar != null) {
            int iA = aVar.a();
            if (iA == 223) {
                org.greenrobot.eventbus.c.f().f(aVar);
                this.mPresenter.appCallH5Map(5, "\"response\":{\"verifiedStatus\":\"1\"}", false);
                return;
            }
            if (iA == 300) {
                org.greenrobot.eventbus.c.f().f(aVar);
                if (aVar.b() != null) {
                    this.mPresenter.appCallH5Other("getCallBackInfo", ResponseDataTypeAdaptor.buildGson().a(aVar.b()));
                    return;
                }
                return;
            }
            if (iA != 302) {
                return;
            }
            org.greenrobot.eventbus.c.f().f(aVar);
            if (aVar.b() != null) {
                this.mPresenter.appCallH5Other("getSmsBackInfo", ResponseDataTypeAdaptor.buildGson().a(aVar.b()));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mPresenter.jsShowPage();
    }

    @OnClick({R.id.ll_network_no})
    public void onViewClicked(View view) {
        if (!isDouble() && view.getId() == R.id.ll_network_no) {
            refreshPage();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            this.mPresenter.jsShowPage();
        }
    }
}
