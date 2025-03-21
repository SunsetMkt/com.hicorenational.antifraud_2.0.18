package p388ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import bean.ReportIDInfoBean;
import bean.SignComitBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import org.greenrobot.eventbus.C6049c;
import p245d.C4443d;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.ReportCommitView;
import p388ui.presenter.SignCommitPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7292k1;
import util.C7331w1;
import util.C7337y1;
import util.p395c2.C7265a;

/* compiled from: ReportSignCommitActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0016J\b\u0010\u009c\u0001\u001a\u00030\u009b\u0001J\u0013\u0010\u009d\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009e\u0001\u001a\u00020&H\u0007J\n\u0010\u009f\u0001\u001a\u00030\u009b\u0001H\u0014J\n\u0010 \u0001\u001a\u00030\u009b\u0001H\u0016J\t\u0010¡\u0001\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\u001e\u0010.\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R\u001e\u00101\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R\u001e\u00104\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010(\"\u0004\b6\u0010*R\u001e\u00107\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010(\"\u0004\b9\u0010*R\u001e\u0010:\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010(\"\u0004\b<\u0010*R\u001e\u0010=\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010(\"\u0004\b?\u0010*R\u001e\u0010@\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010(\"\u0004\bB\u0010*R\u001e\u0010C\u001a\u00020&8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010(\"\u0004\bE\u0010*R\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001e\u0010L\u001a\u00020M8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001e\u0010R\u001a\u00020S8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001e\u0010X\u001a\u00020S8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010U\"\u0004\bZ\u0010WR\u001e\u0010[\u001a\u00020S8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010U\"\u0004\b]\u0010WR\u001e\u0010^\u001a\u00020S8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010U\"\u0004\b`\u0010WR\u001e\u0010a\u001a\u00020S8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010U\"\u0004\bc\u0010WR\u001e\u0010d\u001a\u00020S8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010U\"\u0004\bf\u0010WR\u001e\u0010g\u001a\u00020S8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010U\"\u0004\bi\u0010WR\u001e\u0010j\u001a\u00020S8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010U\"\u0004\bl\u0010WR\u001e\u0010m\u001a\u00020S8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010U\"\u0004\bo\u0010WR\u001e\u0010p\u001a\u00020S8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010U\"\u0004\br\u0010WR\u001e\u0010s\u001a\u00020S8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010U\"\u0004\bu\u0010WR\u001e\u0010v\u001a\u00020S8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010U\"\u0004\bx\u0010WR\u001e\u0010y\u001a\u00020S8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010U\"\u0004\b{\u0010WR\u001e\u0010|\u001a\u00020S8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010U\"\u0004\b~\u0010WR \u0010\u007f\u001a\u00020S8\u0006@\u0006X\u0087.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010U\"\u0005\b\u0081\u0001\u0010WR\u001d\u0010\u0082\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u0007\"\u0005\b\u0084\u0001\u0010\tR\u001d\u0010\u0085\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010\u0007\"\u0005\b\u0087\u0001\u0010\tR\u001d\u0010\u0088\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010\u0007\"\u0005\b\u008a\u0001\u0010\tR\"\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001d\u0010\u0091\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010\u0007\"\u0005\b\u0093\u0001\u0010\tR\u001d\u0010\u0094\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010\u0007\"\u0005\b\u0096\u0001\u0010\tR\u001d\u0010\u0097\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010\u0007\"\u0005\b\u0099\u0001\u0010\t¨\u0006¢\u0001"}, m23546d2 = {"Lui/activity/ReportSignCommitActivity;", "Lui/activity/BaseActivity;", "Lui/callview/ReportCommitView;", "()V", "appCount", "", "getAppCount", "()I", "setAppCount", "(I)V", "callTelCount", "getCallTelCount", "setCallTelCount", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "chargeTelCount", "getChargeTelCount", "setChargeTelCount", "comitNumBean", "Lbean/SignComitBean;", "getComitNumBean", "()Lbean/SignComitBean;", "setComitNumBean", "(Lbean/SignComitBean;)V", "linkTelCount", "getLinkTelCount", "setLinkTelCount", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mLlApp", "Landroid/view/View;", "getMLlApp", "()Landroid/view/View;", "setMLlApp", "(Landroid/view/View;)V", "mLlCall", "getMLlCall", "setMLlCall", "mLlCriminalCall", "getMLlCriminalCall", "setMLlCriminalCall", "mLlCriminalNet", "getMLlCriminalNet", "setMLlCriminalNet", "mLlDelivery", "getMLlDelivery", "setMLlDelivery", "mLlNet", "getMLlNet", "setMLlNet", "mLlRecharge", "getMLlRecharge", "setMLlRecharge", "mLlRelation", "getMLlRelation", "setMLlRelation", "mLlSms", "getMLlSms", "setMLlSms", "mLlWebsit", "getMLlWebsit", "setMLlWebsit", "mPreenter", "Lui/presenter/SignCommitPresenter;", "getMPreenter", "()Lui/presenter/SignCommitPresenter;", "setMPreenter", "(Lui/presenter/SignCommitPresenter;)V", "mTCbSelect", "Landroid/widget/CheckBox;", "getMTCbSelect", "()Landroid/widget/CheckBox;", "setMTCbSelect", "(Landroid/widget/CheckBox;)V", "mTvCaseAccNum", "Landroid/widget/TextView;", "getMTvCaseAccNum", "()Landroid/widget/TextView;", "setMTvCaseAccNum", "(Landroid/widget/TextView;)V", "mTvCaseName", "getMTvCaseName", "setMTvCaseName", "mTvCaseNum", "getMTvCaseNum", "setMTvCaseNum", "mTvCaseTime", "getMTvCaseTime", "setMTvCaseTime", "mTvCriminalApp", "getMTvCriminalApp", "setMTvCriminalApp", "mTvCriminalCallNum", "getMTvCriminalCallNum", "setMTvCriminalCallNum", "mTvCriminalDelivery", "getMTvCriminalDelivery", "setMTvCriminalDelivery", "mTvCriminalNet", "getMTvCriminalNet", "setMTvCriminalNet", "mTvCriminalRecharge", "getMTvCriminalRecharge", "setMTvCriminalRecharge", "mTvCriminalRelation", "getMTvCriminalRelation", "setMTvCriminalRelation", "mTvCriminalSms", "getMTvCriminalSms", "setMTvCriminalSms", "mTvCriminalWebsit", "getMTvCriminalWebsit", "setMTvCriminalWebsit", "mTvPolicNum", "getMTvPolicNum", "setMTvPolicNum", "mTvSZNum", "getMTvSZNum", "setMTvSZNum", "mTvTitle", "getMTvTitle", "setMTvTitle", "mailingTelCount", "getMailingTelCount", "setMailingTelCount", "netAccountCount", "getNetAccountCount", "setNetAccountCount", "paymentCount", "getPaymentCount", "setPaymentCount", "reportIDBean", "Lbean/ReportIDInfoBean;", "getReportIDBean", "()Lbean/ReportIDInfoBean;", "setReportIDBean", "(Lbean/ReportIDInfoBean;)V", "smsCount", "getSmsCount", "setSmsCount", "urlCount", "getUrlCount", "setUrlCount", "victimCount", "getVictimCount", "setVictimCount", "initPage", "", "initView", "onClick", "view", "onDestroy", "onSuccessHandle", "setLayoutView", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class ReportSignCommitActivity extends BaseActivity implements ReportCommitView {
    private int appCount;
    private int callTelCount;

    @InterfaceC5816d
    private String caseInfoId = "";
    private int chargeTelCount;

    @InterfaceC5817e
    private SignComitBean comitNumBean;
    private int linkTelCount;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.ll_app)
    @InterfaceC5816d
    public View mLlApp;

    @BindView(C2113R.id.ll_call)
    @InterfaceC5816d
    public View mLlCall;

    @BindView(C2113R.id.ll_criminal_call)
    @InterfaceC5816d
    public View mLlCriminalCall;

    @BindView(C2113R.id.ll_criminal_net)
    @InterfaceC5816d
    public View mLlCriminalNet;

    @BindView(C2113R.id.ll_delivery)
    @InterfaceC5816d
    public View mLlDelivery;

    @BindView(C2113R.id.ll_net)
    @InterfaceC5816d
    public View mLlNet;

    @BindView(C2113R.id.ll_recharge)
    @InterfaceC5816d
    public View mLlRecharge;

    @BindView(C2113R.id.ll_relation)
    @InterfaceC5816d
    public View mLlRelation;

    @BindView(C2113R.id.ll_sms)
    @InterfaceC5816d
    public View mLlSms;

    @BindView(C2113R.id.ll_websit)
    @InterfaceC5816d
    public View mLlWebsit;

    @InterfaceC5817e
    private SignCommitPresenter mPreenter;

    @BindView(C2113R.id.cb_select)
    @InterfaceC5816d
    public CheckBox mTCbSelect;

    @BindView(C2113R.id.tv_case_account)
    @InterfaceC5816d
    public TextView mTvCaseAccNum;

    @BindView(C2113R.id.tv_case_name)
    @InterfaceC5816d
    public TextView mTvCaseName;

    @BindView(C2113R.id.case_num)
    @InterfaceC5816d
    public TextView mTvCaseNum;

    @BindView(C2113R.id.case_time)
    @InterfaceC5816d
    public TextView mTvCaseTime;

    @BindView(C2113R.id.tv_criminal_app)
    @InterfaceC5816d
    public TextView mTvCriminalApp;

    @BindView(C2113R.id.tv_criminal_call)
    @InterfaceC5816d
    public TextView mTvCriminalCallNum;

    @BindView(C2113R.id.tv_criminal_delivery)
    @InterfaceC5816d
    public TextView mTvCriminalDelivery;

    @BindView(C2113R.id.tv_criminal_net)
    @InterfaceC5816d
    public TextView mTvCriminalNet;

    @BindView(C2113R.id.tv_criminal_recharge)
    @InterfaceC5816d
    public TextView mTvCriminalRecharge;

    @BindView(C2113R.id.tv_criminal_relation)
    @InterfaceC5816d
    public TextView mTvCriminalRelation;

    @BindView(C2113R.id.tv_criminal_sms)
    @InterfaceC5816d
    public TextView mTvCriminalSms;

    @BindView(C2113R.id.tv_criminal_websit)
    @InterfaceC5816d
    public TextView mTvCriminalWebsit;

    @BindView(C2113R.id.polic_num)
    @InterfaceC5816d
    public TextView mTvPolicNum;

    @BindView(C2113R.id.tv_shizhu_info)
    @InterfaceC5816d
    public TextView mTvSZNum;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;
    private int mailingTelCount;
    private int netAccountCount;
    private int paymentCount;

    @InterfaceC5817e
    private ReportIDInfoBean reportIDBean;
    private int smsCount;
    private int urlCount;
    private int victimCount;

    /* compiled from: ReportSignCommitActivity.kt */
    /* renamed from: ui.activity.ReportSignCommitActivity$a */
    static final class C6524a implements CompoundButton.OnCheckedChangeListener {
        C6524a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ReportSignCommitActivity.this.getMTCbSelect().setChecked(z);
        }
    }

    public final int getAppCount() {
        return this.appCount;
    }

    public final int getCallTelCount() {
        return this.callTelCount;
    }

    @InterfaceC5816d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    public final int getChargeTelCount() {
        return this.chargeTelCount;
    }

    @InterfaceC5817e
    public final SignComitBean getComitNumBean() {
        return this.comitNumBean;
    }

    public final int getLinkTelCount() {
        return this.linkTelCount;
    }

    @InterfaceC5816d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            C5544i0.m22554k("mIvBack");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final View getMLlApp() {
        View view = this.mLlApp;
        if (view == null) {
            C5544i0.m22554k("mLlApp");
        }
        return view;
    }

    @InterfaceC5816d
    public final View getMLlCall() {
        View view = this.mLlCall;
        if (view == null) {
            C5544i0.m22554k("mLlCall");
        }
        return view;
    }

    @InterfaceC5816d
    public final View getMLlCriminalCall() {
        View view = this.mLlCriminalCall;
        if (view == null) {
            C5544i0.m22554k("mLlCriminalCall");
        }
        return view;
    }

    @InterfaceC5816d
    public final View getMLlCriminalNet() {
        View view = this.mLlCriminalNet;
        if (view == null) {
            C5544i0.m22554k("mLlCriminalNet");
        }
        return view;
    }

    @InterfaceC5816d
    public final View getMLlDelivery() {
        View view = this.mLlDelivery;
        if (view == null) {
            C5544i0.m22554k("mLlDelivery");
        }
        return view;
    }

    @InterfaceC5816d
    public final View getMLlNet() {
        View view = this.mLlNet;
        if (view == null) {
            C5544i0.m22554k("mLlNet");
        }
        return view;
    }

    @InterfaceC5816d
    public final View getMLlRecharge() {
        View view = this.mLlRecharge;
        if (view == null) {
            C5544i0.m22554k("mLlRecharge");
        }
        return view;
    }

    @InterfaceC5816d
    public final View getMLlRelation() {
        View view = this.mLlRelation;
        if (view == null) {
            C5544i0.m22554k("mLlRelation");
        }
        return view;
    }

    @InterfaceC5816d
    public final View getMLlSms() {
        View view = this.mLlSms;
        if (view == null) {
            C5544i0.m22554k("mLlSms");
        }
        return view;
    }

    @InterfaceC5816d
    public final View getMLlWebsit() {
        View view = this.mLlWebsit;
        if (view == null) {
            C5544i0.m22554k("mLlWebsit");
        }
        return view;
    }

    @InterfaceC5817e
    public final SignCommitPresenter getMPreenter() {
        return this.mPreenter;
    }

    @InterfaceC5816d
    public final CheckBox getMTCbSelect() {
        CheckBox checkBox = this.mTCbSelect;
        if (checkBox == null) {
            C5544i0.m22554k("mTCbSelect");
        }
        return checkBox;
    }

    @InterfaceC5816d
    public final TextView getMTvCaseAccNum() {
        TextView textView = this.mTvCaseAccNum;
        if (textView == null) {
            C5544i0.m22554k("mTvCaseAccNum");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvCaseName() {
        TextView textView = this.mTvCaseName;
        if (textView == null) {
            C5544i0.m22554k("mTvCaseName");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvCaseNum() {
        TextView textView = this.mTvCaseNum;
        if (textView == null) {
            C5544i0.m22554k("mTvCaseNum");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvCaseTime() {
        TextView textView = this.mTvCaseTime;
        if (textView == null) {
            C5544i0.m22554k("mTvCaseTime");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvCriminalApp() {
        TextView textView = this.mTvCriminalApp;
        if (textView == null) {
            C5544i0.m22554k("mTvCriminalApp");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvCriminalCallNum() {
        TextView textView = this.mTvCriminalCallNum;
        if (textView == null) {
            C5544i0.m22554k("mTvCriminalCallNum");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvCriminalDelivery() {
        TextView textView = this.mTvCriminalDelivery;
        if (textView == null) {
            C5544i0.m22554k("mTvCriminalDelivery");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvCriminalNet() {
        TextView textView = this.mTvCriminalNet;
        if (textView == null) {
            C5544i0.m22554k("mTvCriminalNet");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvCriminalRecharge() {
        TextView textView = this.mTvCriminalRecharge;
        if (textView == null) {
            C5544i0.m22554k("mTvCriminalRecharge");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvCriminalRelation() {
        TextView textView = this.mTvCriminalRelation;
        if (textView == null) {
            C5544i0.m22554k("mTvCriminalRelation");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvCriminalSms() {
        TextView textView = this.mTvCriminalSms;
        if (textView == null) {
            C5544i0.m22554k("mTvCriminalSms");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvCriminalWebsit() {
        TextView textView = this.mTvCriminalWebsit;
        if (textView == null) {
            C5544i0.m22554k("mTvCriminalWebsit");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvPolicNum() {
        TextView textView = this.mTvPolicNum;
        if (textView == null) {
            C5544i0.m22554k("mTvPolicNum");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvSZNum() {
        TextView textView = this.mTvSZNum;
        if (textView == null) {
            C5544i0.m22554k("mTvSZNum");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        return textView;
    }

    public final int getMailingTelCount() {
        return this.mailingTelCount;
    }

    public final int getNetAccountCount() {
        return this.netAccountCount;
    }

    public final int getPaymentCount() {
        return this.paymentCount;
    }

    @InterfaceC5817e
    public final ReportIDInfoBean getReportIDBean() {
        return this.reportIDBean;
    }

    public final int getSmsCount() {
        return this.smsCount;
    }

    public final int getUrlCount() {
        return this.urlCount;
    }

    public final int getVictimCount() {
        return this.victimCount;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("确认提交");
        initView();
    }

    public final void initView() {
        String stringExtra = getIntent().getStringExtra(C7292k1.f25338C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.reportIDBean = (ReportIDInfoBean) getIntent().getSerializableExtra(C7292k1.f25388b);
        this.comitNumBean = (SignComitBean) getIntent().getSerializableExtra(C7292k1.f25391c);
        this.mPreenter = new SignCommitPresenter(this.mActivity, this);
        TextView textView = this.mTvCaseName;
        if (textView == null) {
            C5544i0.m22554k("mTvCaseName");
        }
        ReportIDInfoBean reportIDInfoBean = this.reportIDBean;
        textView.setText(reportIDInfoBean != null ? reportIDInfoBean.getCaseName() : null);
        TextView textView2 = this.mTvCaseTime;
        if (textView2 == null) {
            C5544i0.m22554k("mTvCaseTime");
        }
        ReportIDInfoBean reportIDInfoBean2 = this.reportIDBean;
        textView2.setText(reportIDInfoBean2 != null ? reportIDInfoBean2.getProcessTime() : null);
        TextView textView3 = this.mTvCaseNum;
        if (textView3 == null) {
            C5544i0.m22554k("mTvCaseNum");
        }
        ReportIDInfoBean reportIDInfoBean3 = this.reportIDBean;
        textView3.setText(reportIDInfoBean3 != null ? reportIDInfoBean3.getCaseNumber() : null);
        TextView textView4 = this.mTvPolicNum;
        if (textView4 == null) {
            C5544i0.m22554k("mTvPolicNum");
        }
        ReportIDInfoBean reportIDInfoBean4 = this.reportIDBean;
        textView4.setText(reportIDInfoBean4 != null ? reportIDInfoBean4.getCaseCategoryText() : null);
        SignComitBean signComitBean = this.comitNumBean;
        Integer valueOf = signComitBean != null ? Integer.valueOf(signComitBean.getVictimCount()) : null;
        if (valueOf == null) {
            C5544i0.m22545f();
        }
        this.victimCount = valueOf.intValue();
        SignComitBean signComitBean2 = this.comitNumBean;
        Integer valueOf2 = signComitBean2 != null ? Integer.valueOf(signComitBean2.getPaymentCount()) : null;
        if (valueOf2 == null) {
            C5544i0.m22545f();
        }
        this.paymentCount = valueOf2.intValue();
        SignComitBean signComitBean3 = this.comitNumBean;
        Integer valueOf3 = signComitBean3 != null ? Integer.valueOf(signComitBean3.getCallTelCount()) : null;
        if (valueOf3 == null) {
            C5544i0.m22545f();
        }
        this.callTelCount = valueOf3.intValue();
        SignComitBean signComitBean4 = this.comitNumBean;
        Integer valueOf4 = signComitBean4 != null ? Integer.valueOf(signComitBean4.getChargeTelCount()) : null;
        if (valueOf4 == null) {
            C5544i0.m22545f();
        }
        this.chargeTelCount = valueOf4.intValue();
        SignComitBean signComitBean5 = this.comitNumBean;
        Integer valueOf5 = signComitBean5 != null ? Integer.valueOf(signComitBean5.getLinkTelCount()) : null;
        if (valueOf5 == null) {
            C5544i0.m22545f();
        }
        this.linkTelCount = valueOf5.intValue();
        SignComitBean signComitBean6 = this.comitNumBean;
        Integer valueOf6 = signComitBean6 != null ? Integer.valueOf(signComitBean6.getMailingTelCount()) : null;
        if (valueOf6 == null) {
            C5544i0.m22545f();
        }
        this.mailingTelCount = valueOf6.intValue();
        SignComitBean signComitBean7 = this.comitNumBean;
        Integer valueOf7 = signComitBean7 != null ? Integer.valueOf(signComitBean7.getSmsCount()) : null;
        if (valueOf7 == null) {
            C5544i0.m22545f();
        }
        this.smsCount = valueOf7.intValue();
        SignComitBean signComitBean8 = this.comitNumBean;
        Integer valueOf8 = signComitBean8 != null ? Integer.valueOf(signComitBean8.getNetAccountCount()) : null;
        if (valueOf8 == null) {
            C5544i0.m22545f();
        }
        this.netAccountCount = valueOf8.intValue();
        SignComitBean signComitBean9 = this.comitNumBean;
        Integer valueOf9 = signComitBean9 != null ? Integer.valueOf(signComitBean9.getAppCount()) : null;
        if (valueOf9 == null) {
            C5544i0.m22545f();
        }
        this.appCount = valueOf9.intValue();
        SignComitBean signComitBean10 = this.comitNumBean;
        Integer valueOf10 = signComitBean10 != null ? Integer.valueOf(signComitBean10.getUrlCount()) : null;
        if (valueOf10 == null) {
            C5544i0.m22545f();
        }
        this.urlCount = valueOf10.intValue();
        TextView textView5 = this.mTvSZNum;
        if (textView5 == null) {
            C5544i0.m22554k("mTvSZNum");
        }
        textView5.setText("事主信息" + this.victimCount + "个");
        TextView textView6 = this.mTvCaseAccNum;
        if (textView6 == null) {
            C5544i0.m22554k("mTvCaseAccNum");
        }
        textView6.setText("涉案账户" + this.paymentCount + "个");
        TextView textView7 = this.mTvCriminalCallNum;
        if (textView7 == null) {
            C5544i0.m22554k("mTvCriminalCallNum");
        }
        textView7.setText("通话类" + this.callTelCount + "个");
        TextView textView8 = this.mTvCriminalRecharge;
        if (textView8 == null) {
            C5544i0.m22554k("mTvCriminalRecharge");
        }
        textView8.setText("充值类" + this.chargeTelCount + "个");
        TextView textView9 = this.mTvCriminalRelation;
        if (textView9 == null) {
            C5544i0.m22554k("mTvCriminalRelation");
        }
        textView9.setText("关联类" + this.linkTelCount + "个");
        TextView textView10 = this.mTvCriminalDelivery;
        if (textView10 == null) {
            C5544i0.m22554k("mTvCriminalDelivery");
        }
        textView10.setText("寄递类" + this.mailingTelCount + "个");
        TextView textView11 = this.mTvCriminalSms;
        if (textView11 == null) {
            C5544i0.m22554k("mTvCriminalSms");
        }
        textView11.setText("涉诈短信" + this.smsCount + "个");
        TextView textView12 = this.mTvCriminalNet;
        if (textView12 == null) {
            C5544i0.m22554k("mTvCriminalNet");
        }
        textView12.setText("互联网账号" + this.netAccountCount + "个");
        TextView textView13 = this.mTvCriminalApp;
        if (textView13 == null) {
            C5544i0.m22554k("mTvCriminalApp");
        }
        textView13.setText("诈骗APP" + this.appCount + "个");
        TextView textView14 = this.mTvCriminalWebsit;
        if (textView14 == null) {
            C5544i0.m22554k("mTvCriminalWebsit");
        }
        textView14.setText("涉诈网址" + this.urlCount + "个");
        int i2 = this.callTelCount;
        if (this.chargeTelCount + i2 + this.linkTelCount + this.mailingTelCount == 0) {
            View view = this.mLlCriminalCall;
            if (view == null) {
                C5544i0.m22554k("mLlCriminalCall");
            }
            view.setVisibility(8);
        } else {
            if (i2 == 0) {
                View view2 = this.mLlCall;
                if (view2 == null) {
                    C5544i0.m22554k("mLlCall");
                }
                view2.setVisibility(8);
            }
            if (this.chargeTelCount == 0) {
                View view3 = this.mLlRecharge;
                if (view3 == null) {
                    C5544i0.m22554k("mLlRecharge");
                }
                view3.setVisibility(8);
            }
            if (this.linkTelCount == 0) {
                View view4 = this.mLlRelation;
                if (view4 == null) {
                    C5544i0.m22554k("mLlRelation");
                }
                view4.setVisibility(8);
            }
            if (this.mailingTelCount == 0) {
                View view5 = this.mLlDelivery;
                if (view5 == null) {
                    C5544i0.m22554k("mLlDelivery");
                }
                view5.setVisibility(8);
            }
        }
        if (this.smsCount == 0) {
            View view6 = this.mLlSms;
            if (view6 == null) {
                C5544i0.m22554k("mLlSms");
            }
            view6.setVisibility(8);
        }
        int i3 = this.netAccountCount;
        if (this.appCount + i3 + this.urlCount == 0) {
            View view7 = this.mLlCriminalNet;
            if (view7 == null) {
                C5544i0.m22554k("mLlCriminalNet");
            }
            view7.setVisibility(8);
        } else {
            if (i3 == 0) {
                View view8 = this.mLlNet;
                if (view8 == null) {
                    C5544i0.m22554k("mLlNet");
                }
                view8.setVisibility(8);
            }
            if (this.appCount == 0) {
                View view9 = this.mLlApp;
                if (view9 == null) {
                    C5544i0.m22554k("mLlApp");
                }
                view9.setVisibility(8);
            }
            if (this.urlCount == 0) {
                View view10 = this.mLlWebsit;
                if (view10 == null) {
                    C5544i0.m22554k("mLlWebsit");
                }
                view10.setVisibility(8);
            }
        }
        CheckBox checkBox = this.mTCbSelect;
        if (checkBox == null) {
            C5544i0.m22554k("mTCbSelect");
        }
        checkBox.setOnCheckedChangeListener(new C6524a());
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_shizhu_detial, C2113R.id.tv_case_account_detial, C2113R.id.tv_criminal_call_detial, C2113R.id.tv_criminal_recharge_detial, C2113R.id.tv_criminal_relation_detial, C2113R.id.tv_criminal_delivery_detial, C2113R.id.tv_criminal_sms_detial, C2113R.id.tv_criminal_net_detial, C2113R.id.tv_criminal_app_detial, C2113R.id.tv_criminal_websit_detial, C2113R.id.btn_commit})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.btn_commit /* 2131296395 */:
                CheckBox checkBox = this.mTCbSelect;
                if (checkBox == null) {
                    C5544i0.m22554k("mTCbSelect");
                }
                if (!checkBox.isChecked()) {
                    C7331w1.m26688a("请确认上传的案件信息全部为真实信息");
                    break;
                } else {
                    SignCommitPresenter signCommitPresenter = this.mPreenter;
                    if (signCommitPresenter != null) {
                        signCommitPresenter.comitCaseInfo(this.caseInfoId);
                        break;
                    }
                }
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                onBackPressed();
                break;
            case C2113R.id.tv_case_account_detial /* 2131297451 */:
                if (this.paymentCount > 0) {
                    Intent intent = new Intent(this.mActivity, (Class<?>) AccountListPreviewActivity.class);
                    intent.putExtra(C7292k1.f25338C0, this.caseInfoId);
                    startActivity(intent);
                    break;
                }
                break;
            case C2113R.id.tv_criminal_app_detial /* 2131297495 */:
                if (this.appCount > 0) {
                    Intent intent2 = new Intent(this.mActivity, (Class<?>) SignCommitAppActivity.class);
                    intent2.putExtra(C7292k1.f25338C0, this.caseInfoId);
                    intent2.putExtra(C7292k1.f25394d, true);
                    startActivity(intent2);
                    break;
                }
                break;
            case C2113R.id.tv_criminal_call_detial /* 2131297497 */:
                if (this.callTelCount > 0) {
                    Intent intent3 = new Intent(this.mActivity, (Class<?>) SignCallActivity.class);
                    intent3.putExtra(C7292k1.f25338C0, this.caseInfoId);
                    startActivity(intent3);
                    break;
                }
                break;
            case C2113R.id.tv_criminal_delivery_detial /* 2131297499 */:
                if (this.mailingTelCount > 0) {
                    Intent intent4 = new Intent(this.mActivity, (Class<?>) SignDeliveryActivity.class);
                    intent4.putExtra(C7292k1.f25338C0, this.caseInfoId);
                    startActivity(intent4);
                    break;
                }
                break;
            case C2113R.id.tv_criminal_net_detial /* 2131297501 */:
                if (this.netAccountCount > 0) {
                    Intent intent5 = new Intent(this.mActivity, (Class<?>) CriminalSocialActivity.class);
                    intent5.putExtra(C7292k1.f25338C0, this.caseInfoId);
                    intent5.putExtra(C7292k1.f25394d, true);
                    startActivity(intent5);
                    break;
                }
                break;
            case C2113R.id.tv_criminal_recharge_detial /* 2131297503 */:
                if (this.chargeTelCount > 0) {
                    Intent intent6 = new Intent(this.mActivity, (Class<?>) SignReChargeActivity.class);
                    intent6.putExtra(C7292k1.f25338C0, this.caseInfoId);
                    startActivity(intent6);
                    break;
                }
                break;
            case C2113R.id.tv_criminal_relation_detial /* 2131297505 */:
                if (this.linkTelCount > 0) {
                    Intent intent7 = new Intent(this.mActivity, (Class<?>) SignRelationActivity.class);
                    intent7.putExtra(C7292k1.f25338C0, this.caseInfoId);
                    startActivity(intent7);
                    break;
                }
                break;
            case C2113R.id.tv_criminal_sms_detial /* 2131297507 */:
                if (this.smsCount > 0) {
                    Intent intent8 = new Intent(this.mActivity, (Class<?>) CriminalSmsActivity.class);
                    intent8.putExtra(C7292k1.f25338C0, this.caseInfoId);
                    intent8.putExtra(C7292k1.f25394d, true);
                    startActivity(intent8);
                    break;
                }
                break;
            case C2113R.id.tv_criminal_websit_detial /* 2131297509 */:
                if (this.urlCount > 0) {
                    Intent intent9 = new Intent(this.mActivity, (Class<?>) SignCommitWebsiteActivity.class);
                    intent9.putExtra(C7292k1.f25338C0, this.caseInfoId);
                    startActivity(intent9);
                    break;
                }
                break;
            case C2113R.id.tv_shizhu_detial /* 2131297707 */:
                if (this.victimCount > 0) {
                    Intent intent10 = new Intent(this.mActivity, (Class<?>) SignCommitVictimActivity.class);
                    intent10.putExtra(C7292k1.f25338C0, this.caseInfoId);
                    startActivity(intent10);
                    break;
                }
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C7337y1.m26772c(C4443d.f16973t);
    }

    @Override // p388ui.callview.ReportCommitView
    public void onSuccessHandle() {
        C6049c.m24987f().m25000d(new C7265a(34, null));
        startActivity(new Intent(this.mActivity, (Class<?>) ReportSuccessActivity.class));
        finish();
    }

    public final void setAppCount(int i2) {
        this.appCount = i2;
    }

    public final void setCallTelCount(int i2) {
        this.callTelCount = i2;
    }

    public final void setCaseInfoId(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.caseInfoId = str;
    }

    public final void setChargeTelCount(int i2) {
        this.chargeTelCount = i2;
    }

    public final void setComitNumBean(@InterfaceC5817e SignComitBean signComitBean) {
        this.comitNumBean = signComitBean;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_report_sign_comt;
    }

    public final void setLinkTelCount(int i2) {
        this.linkTelCount = i2;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMLlApp(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlApp = view;
    }

    public final void setMLlCall(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlCall = view;
    }

    public final void setMLlCriminalCall(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlCriminalCall = view;
    }

    public final void setMLlCriminalNet(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlCriminalNet = view;
    }

    public final void setMLlDelivery(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlDelivery = view;
    }

    public final void setMLlNet(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlNet = view;
    }

    public final void setMLlRecharge(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlRecharge = view;
    }

    public final void setMLlRelation(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlRelation = view;
    }

    public final void setMLlSms(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlSms = view;
    }

    public final void setMLlWebsit(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlWebsit = view;
    }

    public final void setMPreenter(@InterfaceC5817e SignCommitPresenter signCommitPresenter) {
        this.mPreenter = signCommitPresenter;
    }

    public final void setMTCbSelect(@InterfaceC5816d CheckBox checkBox) {
        C5544i0.m22546f(checkBox, "<set-?>");
        this.mTCbSelect = checkBox;
    }

    public final void setMTvCaseAccNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCaseAccNum = textView;
    }

    public final void setMTvCaseName(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCaseName = textView;
    }

    public final void setMTvCaseNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCaseNum = textView;
    }

    public final void setMTvCaseTime(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCaseTime = textView;
    }

    public final void setMTvCriminalApp(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCriminalApp = textView;
    }

    public final void setMTvCriminalCallNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCriminalCallNum = textView;
    }

    public final void setMTvCriminalDelivery(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCriminalDelivery = textView;
    }

    public final void setMTvCriminalNet(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCriminalNet = textView;
    }

    public final void setMTvCriminalRecharge(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCriminalRecharge = textView;
    }

    public final void setMTvCriminalRelation(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCriminalRelation = textView;
    }

    public final void setMTvCriminalSms(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCriminalSms = textView;
    }

    public final void setMTvCriminalWebsit(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCriminalWebsit = textView;
    }

    public final void setMTvPolicNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvPolicNum = textView;
    }

    public final void setMTvSZNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvSZNum = textView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setMailingTelCount(int i2) {
        this.mailingTelCount = i2;
    }

    public final void setNetAccountCount(int i2) {
        this.netAccountCount = i2;
    }

    public final void setPaymentCount(int i2) {
        this.paymentCount = i2;
    }

    public final void setReportIDBean(@InterfaceC5817e ReportIDInfoBean reportIDInfoBean) {
        this.reportIDBean = reportIDInfoBean;
    }

    public final void setSmsCount(int i2) {
        this.smsCount = i2;
    }

    public final void setUrlCount(int i2) {
        this.urlCount = i2;
    }

    public final void setVictimCount(int i2) {
        this.victimCount = i2;
    }
}
