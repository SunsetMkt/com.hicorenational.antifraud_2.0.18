package p388ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import bean.ShareConfigBean;
import bean.SurveyH5Bean;
import bean.WebArticleBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.umeng.socialize.UMShareAPI;
import interfaces.IVerifyListener;
import interfaces.OnWebListener;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import manager.AccountManager;
import manager.LoginManager;
import network.account.APIresult;
import network.gson.ObjectTypeAdapter;
import network.http.ReportNumHttp;
import network.http.StatisticsShareHttp;
import p245d.C4440a;
import p388ui.callview.PromosWebView;
import p388ui.p391f.DialogC6827c;
import p388ui.presenter.PromosWebPresenter;
import p388ui.statusbarcompat.C7161b;
import p388ui.view.MyWebView;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;
import util.C7301n1;
import util.C7340z1;
import util.p396d2.C7269a;

/* loaded from: classes2.dex */
public class PromosWebDetActivity extends BaseActivity implements PromosWebView {
    private boolean isVideo;

    @BindView(C2113R.id.iv_right)
    ImageView mIvRight;

    @BindView(C2113R.id.iv_right2)
    ImageView mIvRight2;

    @BindView(C2113R.id.ll_network_no)
    View mLlNetworkNo;

    @BindView(C2113R.id.ll_to_report)
    LinearLayout mLlToReport;
    private PromosWebPresenter mPresenter;

    @BindView(C2113R.id.progress_bar)
    ProgressBar mProgressBar;

    @BindView(C2113R.id.rl_title)
    View mRlTitle;

    @BindView(C2113R.id.fl_tit_white)
    View mRlTitleWhite;

    @BindView(C2113R.id.tv_help)
    TextView mTvHelp;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    @BindView(C2113R.id.webview)
    MyWebView mWebview;
    private ShareConfigBean shareBean;
    SwipBackLayout swipBackLayout;
    private String mArticleId = "";
    private String mSource = "";
    private String mShareBaseUrl = "";
    Handler mHandler = new HandlerC6443a();

    /* renamed from: ui.activity.PromosWebDetActivity$a */
    class HandlerC6443a extends Handler {
        HandlerC6443a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Activity activity = PromosWebDetActivity.this.mActivity;
            if (activity == null || activity.isFinishing()) {
                return;
            }
            int i2 = message.what;
            if (i2 == 6) {
                PromosWebDetActivity.this.mRlTitle.setVisibility(8);
                PromosWebDetActivity.this.mLlToReport.setVisibility(8);
                if (!PromosWebDetActivity.this.isVideo) {
                    C7161b.m25698a(PromosWebDetActivity.this.mActivity, true, false);
                    return;
                }
                PromosWebDetActivity.this.mRlTitleWhite.setVisibility(8);
                PromosWebDetActivity.this.mTvHelp.setVisibility(0);
                C7161b.m25698a(PromosWebDetActivity.this.mActivity, true, false);
                return;
            }
            if (i2 != 7) {
                return;
            }
            PromosWebDetActivity.this.mLlToReport.setVisibility(0);
            if (!PromosWebDetActivity.this.isVideo) {
                PromosWebDetActivity.this.mRlTitle.setVisibility(0);
                C7161b.m25698a(PromosWebDetActivity.this.mActivity, true, true);
            } else {
                PromosWebDetActivity.this.mRlTitle.setVisibility(8);
                PromosWebDetActivity.this.mRlTitleWhite.setVisibility(0);
                PromosWebDetActivity.this.mTvHelp.setVisibility(0);
                C7161b.m25698a(PromosWebDetActivity.this.mActivity, true, false);
            }
        }
    }

    /* renamed from: ui.activity.PromosWebDetActivity$b */
    class C6444b implements OnWebListener {
        C6444b() {
        }

        @Override // interfaces.OnWebListener
        public void shouldIntercept(C7269a c7269a) {
            PromosWebDetActivity.this.sendWebMsg(c7269a);
        }

        @Override // interfaces.OnWebListener
        public void webJsFinish() {
        }

        @Override // interfaces.OnWebListener
        public void webJsParame(String str) {
            SurveyH5Bean surveyH5Bean;
            String str2;
            if (TextUtils.isEmpty(str) || (surveyH5Bean = (SurveyH5Bean) ObjectTypeAdapter.buildNewGson().m5569a(str, SurveyH5Bean.class)) == null || surveyH5Bean.getParams() == null) {
                return;
            }
            try {
                Map<String, Object> params = surveyH5Bean.getParams();
                int parseInt = Integer.parseInt(params.get("action").toString());
                if (parseInt != 17) {
                    if (parseInt == 16) {
                        MyWebView.cleanCache();
                        return;
                    }
                    return;
                }
                String obj = params.get(SurveyH5Bean.VALUE).toString();
                PromosWebDetActivity promosWebDetActivity = PromosWebDetActivity.this;
                if (TextUtils.equals(obj, "0")) {
                    str2 = C4440a.f16886h + C4440a.m16392a(8);
                } else {
                    str2 = C4440a.f16881c;
                }
                promosWebDetActivity.mShareBaseUrl = str2;
                PromosWebDetActivity.this.mPresenter.requestAticleInfo(PromosWebDetActivity.this.mShareBaseUrl, PromosWebDetActivity.this.mArticleId);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: ui.activity.PromosWebDetActivity$c */
    class C6445c extends WebChromeClient {
        C6445c() {
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(WebView webView, int i2) {
            ProgressBar progressBar = PromosWebDetActivity.this.mProgressBar;
            if (progressBar == null) {
                return;
            }
            if (i2 == 100) {
                progressBar.setVisibility(8);
            } else {
                progressBar.setVisibility(0);
                PromosWebDetActivity.this.mProgressBar.setProgress(i2);
            }
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
        }
    }

    private void deleteChildWebview() {
        try {
            this.mWebview.clearHistory();
            this.mWebview.removeAllViews();
            this.mWebview.destroy();
            this.mWebview = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendWebMsg(C7269a c7269a) {
        if (c7269a.m26325c()) {
            return;
        }
        try {
            String m26323b = c7269a.m26323b("id");
            String m26323b2 = c7269a.m26323b("url");
            String charSequence = this.mTvTitle.getText().toString();
            if (!TextUtils.isEmpty(m26323b2)) {
                Intent intent = new Intent(this.mActivity, (Class<?>) PromosWebDetActivity.class);
                intent.putExtra(C7292k1.f25363P, charSequence);
                intent.putExtra(C7292k1.f25365Q, m26323b2);
                intent.putExtra(C7292k1.f25371T, m26323b);
                intent.putExtra(C7292k1.f25373U, 3);
                startActivity(intent);
            }
            String m26323b3 = c7269a.m26323b("isOnlyFullScreen");
            String m26323b4 = c7269a.m26323b("isfullScreen");
            if (TextUtils.equals("yes", m26323b4)) {
                this.mHandler.sendEmptyMessage(6);
                return;
            }
            if (TextUtils.equals("no", m26323b4)) {
                this.mHandler.sendEmptyMessage(7);
            } else if (TextUtils.equals("yes", m26323b3)) {
                this.mHandler.sendEmptyMessage(6);
            } else if (TextUtils.equals("no", m26323b3)) {
                this.mHandler.sendEmptyMessage(7);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public /* synthetic */ void m25308a() {
        StatisticsShareHttp.getInstance().shareArticleHttp(this.mArticleId);
    }

    /* renamed from: b */
    public /* synthetic */ void m25309b() {
        ReportNumHttp.getInstance().principalHttp(new C6805w1(this));
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        this.swipBackLayout = SwipBackLayout.m26045a(this.mActivity);
        this.swipBackLayout.m26049a();
        this.mWebview.setSwipLayout(this.mActivity, this.swipBackLayout);
        this.mIvRight.setBackgroundResource(C2113R.drawable.iv_share_dot);
        this.mArticleId = getIntent().getStringExtra(C7292k1.f25371T);
        String stringExtra = getIntent().getStringExtra(C7292k1.f25365Q);
        String stringExtra2 = getIntent().getStringExtra(C7292k1.f25363P);
        this.mSource = getIntent().getStringExtra(C7292k1.f25369S);
        int intExtra = getIntent().getIntExtra(C7292k1.f25373U, 0);
        this.mPresenter = new PromosWebPresenter(this, this);
        this.mTvTitle.setText(stringExtra2);
        this.shareBean = new ShareConfigBean();
        initWebView(this.mWebview);
        this.mWebview.loadUrl(stringExtra + "#app=1");
        C7301n1.m26453a("PromosWeb--------url+-->>" + stringExtra);
        if (stringExtra.contains("shareVideo")) {
            this.isVideo = true;
            this.mRlTitle.setVisibility(8);
            this.mRlTitleWhite.setVisibility(0);
            this.mTvHelp.setVisibility(0);
            C7161b.m25698a((Activity) this, true, false);
        } else {
            this.mRlTitle.setVisibility(0);
            this.mRlTitleWhite.setVisibility(8);
            C7161b.m25698a((Activity) this, true, true);
        }
        if (intExtra == 3) {
            this.mIvRight.setVisibility(8);
            this.mLlToReport.setVisibility(8);
        }
    }

    protected void initWebView(MyWebView myWebView) {
        myWebView.setListener(this.mActivity, new C6444b());
        myWebView.setWebChromeClient(new C6445c());
        myWebView.setWebViewClient(new C6446d());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        UMShareAPI.get(this).onActivityResult(i2, i3, intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        MyWebView myWebView = this.mWebview;
        if (myWebView != null && myWebView.canGoBack()) {
            this.mWebview.goBack();
        } else {
            super.onBackPressed();
            deleteChildWebview();
        }
    }

    @Override // p388ui.callview.PromosWebView
    public void onSuccRequest(APIresult<WebArticleBean> aPIresult) {
        WebArticleBean data = aPIresult.getData();
        if (data != null) {
            this.shareBean.downloadUrl = data.getContent();
            this.shareBean.title = data.getTitle();
            this.shareBean.iconUrl = data.getIcon();
            this.shareBean.description = data.getDescription();
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.iv_back2, C2113R.id.ll_to_report, C2113R.id.iv_right, C2113R.id.iv_right2, C2113R.id.ll_network_no})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.iv_back /* 2131296762 */:
            case C2113R.id.iv_back2 /* 2131296763 */:
                onBackPressed();
                break;
            case C2113R.id.iv_right /* 2131296826 */:
            case C2113R.id.iv_right2 /* 2131296827 */:
                new DialogC6827c(this.mActivity, this.shareBean, 2, new DialogC6827c.b() { // from class: ui.activity.s0
                    @Override // p388ui.p391f.DialogC6827c.b
                    /* renamed from: a */
                    public final void mo25436a() {
                        PromosWebDetActivity.this.m25308a();
                    }
                }).show();
                break;
            case C2113R.id.ll_network_no /* 2131296957 */:
                this.mWebview.reload();
                this.mWebview.setVisibility(0);
                this.mLlNetworkNo.setVisibility(8);
                break;
            case C2113R.id.ll_to_report /* 2131296994 */:
                if (!AccountManager.isLogin()) {
                    LoginManager.getInstance().exitToLogin();
                    break;
                } else {
                    C7340z1.m26805a(this.mActivity).m26811a(1011, new IVerifyListener() { // from class: ui.activity.r0
                        @Override // interfaces.IVerifyListener
                        public final void onSuccessVerify() {
                            PromosWebDetActivity.this.m25309b();
                        }
                    });
                    break;
                }
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_prom_web_det;
    }

    /* renamed from: ui.activity.PromosWebDetActivity$d */
    class C6446d extends WebViewClient {
        C6446d() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            super.onReceivedError(webView, i2, str, str2);
            View view = PromosWebDetActivity.this.mLlNetworkNo;
            if (view != null) {
                view.setVisibility(0);
            }
            MyWebView myWebView = PromosWebDetActivity.this.mWebview;
            if (myWebView != null) {
                myWebView.setVisibility(8);
            }
        }

        @Override // android.webkit.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            webResourceRequest.getUrl().toString();
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            AtomicReference atomicReference = new AtomicReference();
            if (Build.VERSION.SDK_INT >= 21) {
                atomicReference.set(webResourceRequest.getUrl().getPath());
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }
}
