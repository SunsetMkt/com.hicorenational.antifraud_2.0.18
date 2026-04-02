package ui.activity;

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
import com.hicorenational.antifraud.R;
import ui.callview.ReportCommitView;
import ui.presenter.SignCommitPresenter;
import ui.view.swip.SwipBackLayout;
import util.e2;
import util.g2;

/* JADX INFO: compiled from: ReportSignCommitActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\n\u0010\u009a\u0001\u001a\u00030\u009b\u0001H\u0016J\b\u0010\u009c\u0001\u001a\u00030\u009b\u0001J\u0013\u0010\u009d\u0001\u001a\u00030\u009b\u00012\u0007\u0010\u009e\u0001\u001a\u00020&H\u0007J\n\u0010\u009f\u0001\u001a\u00030\u009b\u0001H\u0014J\n\u0010\u00a0\u0001\u001a\u00030\u009b\u0001H\u0016J\t\u0010\u00a1\u0001\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020&8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\u001e\u0010.\u001a\u00020&8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R\u001e\u00101\u001a\u00020&8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R\u001e\u00104\u001a\u00020&8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010(\"\u0004\b6\u0010*R\u001e\u00107\u001a\u00020&8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010(\"\u0004\b9\u0010*R\u001e\u0010:\u001a\u00020&8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010(\"\u0004\b<\u0010*R\u001e\u0010=\u001a\u00020&8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010(\"\u0004\b?\u0010*R\u001e\u0010@\u001a\u00020&8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010(\"\u0004\bB\u0010*R\u001e\u0010C\u001a\u00020&8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010(\"\u0004\bE\u0010*R\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001e\u0010L\u001a\u00020M8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001e\u0010R\u001a\u00020S8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u001e\u0010X\u001a\u00020S8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010U\"\u0004\bZ\u0010WR\u001e\u0010[\u001a\u00020S8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010U\"\u0004\b]\u0010WR\u001e\u0010^\u001a\u00020S8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b_\u0010U\"\u0004\b`\u0010WR\u001e\u0010a\u001a\u00020S8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bb\u0010U\"\u0004\bc\u0010WR\u001e\u0010d\u001a\u00020S8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u0010U\"\u0004\bf\u0010WR\u001e\u0010g\u001a\u00020S8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bh\u0010U\"\u0004\bi\u0010WR\u001e\u0010j\u001a\u00020S8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bk\u0010U\"\u0004\bl\u0010WR\u001e\u0010m\u001a\u00020S8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bn\u0010U\"\u0004\bo\u0010WR\u001e\u0010p\u001a\u00020S8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bq\u0010U\"\u0004\br\u0010WR\u001e\u0010s\u001a\u00020S8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bt\u0010U\"\u0004\bu\u0010WR\u001e\u0010v\u001a\u00020S8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bw\u0010U\"\u0004\bx\u0010WR\u001e\u0010y\u001a\u00020S8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bz\u0010U\"\u0004\b{\u0010WR\u001e\u0010|\u001a\u00020S8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b}\u0010U\"\u0004\b~\u0010WR \u0010\u007f\u001a\u00020S8\u0006@\u0006X\u0087.\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010U\"\u0005\b\u0081\u0001\u0010WR\u001d\u0010\u0082\u0001\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u0007\"\u0005\b\u0084\u0001\u0010\tR\u001d\u0010\u0085\u0001\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010\u0007\"\u0005\b\u0087\u0001\u0010\tR\u001d\u0010\u0088\u0001\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010\u0007\"\u0005\b\u008a\u0001\u0010\tR\"\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u0001X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001d\u0010\u0091\u0001\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010\u0007\"\u0005\b\u0093\u0001\u0010\tR\u001d\u0010\u0094\u0001\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010\u0007\"\u0005\b\u0096\u0001\u0010\tR\u001d\u0010\u0097\u0001\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010\u0007\"\u0005\b\u0099\u0001\u0010\t\u00a8\u0006\u00a2\u0001"}, d2 = {"Lui/activity/ReportSignCommitActivity;", "Lui/activity/BaseActivity;", "Lui/callview/ReportCommitView;", "()V", "appCount", "", "getAppCount", "()I", "setAppCount", "(I)V", "callTelCount", "getCallTelCount", "setCallTelCount", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "chargeTelCount", "getChargeTelCount", "setChargeTelCount", "comitNumBean", "Lbean/SignComitBean;", "getComitNumBean", "()Lbean/SignComitBean;", "setComitNumBean", "(Lbean/SignComitBean;)V", "linkTelCount", "getLinkTelCount", "setLinkTelCount", "mIvBack", "Landroid/widget/ImageView;", "getMIvBack", "()Landroid/widget/ImageView;", "setMIvBack", "(Landroid/widget/ImageView;)V", "mLlApp", "Landroid/view/View;", "getMLlApp", "()Landroid/view/View;", "setMLlApp", "(Landroid/view/View;)V", "mLlCall", "getMLlCall", "setMLlCall", "mLlCriminalCall", "getMLlCriminalCall", "setMLlCriminalCall", "mLlCriminalNet", "getMLlCriminalNet", "setMLlCriminalNet", "mLlDelivery", "getMLlDelivery", "setMLlDelivery", "mLlNet", "getMLlNet", "setMLlNet", "mLlRecharge", "getMLlRecharge", "setMLlRecharge", "mLlRelation", "getMLlRelation", "setMLlRelation", "mLlSms", "getMLlSms", "setMLlSms", "mLlWebsit", "getMLlWebsit", "setMLlWebsit", "mPreenter", "Lui/presenter/SignCommitPresenter;", "getMPreenter", "()Lui/presenter/SignCommitPresenter;", "setMPreenter", "(Lui/presenter/SignCommitPresenter;)V", "mTCbSelect", "Landroid/widget/CheckBox;", "getMTCbSelect", "()Landroid/widget/CheckBox;", "setMTCbSelect", "(Landroid/widget/CheckBox;)V", "mTvCaseAccNum", "Landroid/widget/TextView;", "getMTvCaseAccNum", "()Landroid/widget/TextView;", "setMTvCaseAccNum", "(Landroid/widget/TextView;)V", "mTvCaseName", "getMTvCaseName", "setMTvCaseName", "mTvCaseNum", "getMTvCaseNum", "setMTvCaseNum", "mTvCaseTime", "getMTvCaseTime", "setMTvCaseTime", "mTvCriminalApp", "getMTvCriminalApp", "setMTvCriminalApp", "mTvCriminalCallNum", "getMTvCriminalCallNum", "setMTvCriminalCallNum", "mTvCriminalDelivery", "getMTvCriminalDelivery", "setMTvCriminalDelivery", "mTvCriminalNet", "getMTvCriminalNet", "setMTvCriminalNet", "mTvCriminalRecharge", "getMTvCriminalRecharge", "setMTvCriminalRecharge", "mTvCriminalRelation", "getMTvCriminalRelation", "setMTvCriminalRelation", "mTvCriminalSms", "getMTvCriminalSms", "setMTvCriminalSms", "mTvCriminalWebsit", "getMTvCriminalWebsit", "setMTvCriminalWebsit", "mTvPolicNum", "getMTvPolicNum", "setMTvPolicNum", "mTvSZNum", "getMTvSZNum", "setMTvSZNum", "mTvTitle", "getMTvTitle", "setMTvTitle", "mailingTelCount", "getMailingTelCount", "setMailingTelCount", "netAccountCount", "getNetAccountCount", "setNetAccountCount", "paymentCount", "getPaymentCount", "setPaymentCount", "reportIDBean", "Lbean/ReportIDInfoBean;", "getReportIDBean", "()Lbean/ReportIDInfoBean;", "setReportIDBean", "(Lbean/ReportIDInfoBean;)V", "smsCount", "getSmsCount", "setSmsCount", "urlCount", "getUrlCount", "setUrlCount", "victimCount", "getVictimCount", "setVictimCount", "initPage", "", "initView", "onClick", "view", "onDestroy", "onSuccessHandle", "setLayoutView", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class ReportSignCommitActivity extends BaseActivity implements ReportCommitView {
    private int appCount;
    private int callTelCount;

    @j.c.a.d
    private String caseInfoId = "";
    private int chargeTelCount;

    @j.c.a.e
    private SignComitBean comitNumBean;
    private int linkTelCount;

    @BindView(R.id.iv_back)
    @j.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.ll_app)
    @j.c.a.d
    public View mLlApp;

    @BindView(R.id.ll_call)
    @j.c.a.d
    public View mLlCall;

    @BindView(R.id.ll_criminal_call)
    @j.c.a.d
    public View mLlCriminalCall;

    @BindView(R.id.ll_criminal_net)
    @j.c.a.d
    public View mLlCriminalNet;

    @BindView(R.id.ll_delivery)
    @j.c.a.d
    public View mLlDelivery;

    @BindView(R.id.ll_net)
    @j.c.a.d
    public View mLlNet;

    @BindView(R.id.ll_recharge)
    @j.c.a.d
    public View mLlRecharge;

    @BindView(R.id.ll_relation)
    @j.c.a.d
    public View mLlRelation;

    @BindView(R.id.ll_sms)
    @j.c.a.d
    public View mLlSms;

    @BindView(R.id.ll_websit)
    @j.c.a.d
    public View mLlWebsit;

    @j.c.a.e
    private SignCommitPresenter mPreenter;

    @BindView(R.id.cb_select)
    @j.c.a.d
    public CheckBox mTCbSelect;

    @BindView(R.id.tv_case_account)
    @j.c.a.d
    public TextView mTvCaseAccNum;

    @BindView(R.id.tv_case_name)
    @j.c.a.d
    public TextView mTvCaseName;

    @BindView(R.id.case_num)
    @j.c.a.d
    public TextView mTvCaseNum;

    @BindView(R.id.case_time)
    @j.c.a.d
    public TextView mTvCaseTime;

    @BindView(R.id.tv_criminal_app)
    @j.c.a.d
    public TextView mTvCriminalApp;

    @BindView(R.id.tv_criminal_call)
    @j.c.a.d
    public TextView mTvCriminalCallNum;

    @BindView(R.id.tv_criminal_delivery)
    @j.c.a.d
    public TextView mTvCriminalDelivery;

    @BindView(R.id.tv_criminal_net)
    @j.c.a.d
    public TextView mTvCriminalNet;

    @BindView(R.id.tv_criminal_recharge)
    @j.c.a.d
    public TextView mTvCriminalRecharge;

    @BindView(R.id.tv_criminal_relation)
    @j.c.a.d
    public TextView mTvCriminalRelation;

    @BindView(R.id.tv_criminal_sms)
    @j.c.a.d
    public TextView mTvCriminalSms;

    @BindView(R.id.tv_criminal_websit)
    @j.c.a.d
    public TextView mTvCriminalWebsit;

    @BindView(R.id.polic_num)
    @j.c.a.d
    public TextView mTvPolicNum;

    @BindView(R.id.tv_shizhu_info)
    @j.c.a.d
    public TextView mTvSZNum;

    @BindView(R.id.tv_title)
    @j.c.a.d
    public TextView mTvTitle;
    private int mailingTelCount;
    private int netAccountCount;
    private int paymentCount;

    @j.c.a.e
    private ReportIDInfoBean reportIDBean;
    private int smsCount;
    private int urlCount;
    private int victimCount;

    /* JADX INFO: compiled from: ReportSignCommitActivity.kt */
    static final class a implements CompoundButton.OnCheckedChangeListener {
        a() {
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

    @j.c.a.d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    public final int getChargeTelCount() {
        return this.chargeTelCount;
    }

    @j.c.a.e
    public final SignComitBean getComitNumBean() {
        return this.comitNumBean;
    }

    public final int getLinkTelCount() {
        return this.linkTelCount;
    }

    @j.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            i.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @j.c.a.d
    public final View getMLlApp() {
        View view = this.mLlApp;
        if (view == null) {
            i.q2.t.i0.k("mLlApp");
        }
        return view;
    }

    @j.c.a.d
    public final View getMLlCall() {
        View view = this.mLlCall;
        if (view == null) {
            i.q2.t.i0.k("mLlCall");
        }
        return view;
    }

    @j.c.a.d
    public final View getMLlCriminalCall() {
        View view = this.mLlCriminalCall;
        if (view == null) {
            i.q2.t.i0.k("mLlCriminalCall");
        }
        return view;
    }

    @j.c.a.d
    public final View getMLlCriminalNet() {
        View view = this.mLlCriminalNet;
        if (view == null) {
            i.q2.t.i0.k("mLlCriminalNet");
        }
        return view;
    }

    @j.c.a.d
    public final View getMLlDelivery() {
        View view = this.mLlDelivery;
        if (view == null) {
            i.q2.t.i0.k("mLlDelivery");
        }
        return view;
    }

    @j.c.a.d
    public final View getMLlNet() {
        View view = this.mLlNet;
        if (view == null) {
            i.q2.t.i0.k("mLlNet");
        }
        return view;
    }

    @j.c.a.d
    public final View getMLlRecharge() {
        View view = this.mLlRecharge;
        if (view == null) {
            i.q2.t.i0.k("mLlRecharge");
        }
        return view;
    }

    @j.c.a.d
    public final View getMLlRelation() {
        View view = this.mLlRelation;
        if (view == null) {
            i.q2.t.i0.k("mLlRelation");
        }
        return view;
    }

    @j.c.a.d
    public final View getMLlSms() {
        View view = this.mLlSms;
        if (view == null) {
            i.q2.t.i0.k("mLlSms");
        }
        return view;
    }

    @j.c.a.d
    public final View getMLlWebsit() {
        View view = this.mLlWebsit;
        if (view == null) {
            i.q2.t.i0.k("mLlWebsit");
        }
        return view;
    }

    @j.c.a.e
    public final SignCommitPresenter getMPreenter() {
        return this.mPreenter;
    }

    @j.c.a.d
    public final CheckBox getMTCbSelect() {
        CheckBox checkBox = this.mTCbSelect;
        if (checkBox == null) {
            i.q2.t.i0.k("mTCbSelect");
        }
        return checkBox;
    }

    @j.c.a.d
    public final TextView getMTvCaseAccNum() {
        TextView textView = this.mTvCaseAccNum;
        if (textView == null) {
            i.q2.t.i0.k("mTvCaseAccNum");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvCaseName() {
        TextView textView = this.mTvCaseName;
        if (textView == null) {
            i.q2.t.i0.k("mTvCaseName");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvCaseNum() {
        TextView textView = this.mTvCaseNum;
        if (textView == null) {
            i.q2.t.i0.k("mTvCaseNum");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvCaseTime() {
        TextView textView = this.mTvCaseTime;
        if (textView == null) {
            i.q2.t.i0.k("mTvCaseTime");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvCriminalApp() {
        TextView textView = this.mTvCriminalApp;
        if (textView == null) {
            i.q2.t.i0.k("mTvCriminalApp");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvCriminalCallNum() {
        TextView textView = this.mTvCriminalCallNum;
        if (textView == null) {
            i.q2.t.i0.k("mTvCriminalCallNum");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvCriminalDelivery() {
        TextView textView = this.mTvCriminalDelivery;
        if (textView == null) {
            i.q2.t.i0.k("mTvCriminalDelivery");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvCriminalNet() {
        TextView textView = this.mTvCriminalNet;
        if (textView == null) {
            i.q2.t.i0.k("mTvCriminalNet");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvCriminalRecharge() {
        TextView textView = this.mTvCriminalRecharge;
        if (textView == null) {
            i.q2.t.i0.k("mTvCriminalRecharge");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvCriminalRelation() {
        TextView textView = this.mTvCriminalRelation;
        if (textView == null) {
            i.q2.t.i0.k("mTvCriminalRelation");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvCriminalSms() {
        TextView textView = this.mTvCriminalSms;
        if (textView == null) {
            i.q2.t.i0.k("mTvCriminalSms");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvCriminalWebsit() {
        TextView textView = this.mTvCriminalWebsit;
        if (textView == null) {
            i.q2.t.i0.k("mTvCriminalWebsit");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvPolicNum() {
        TextView textView = this.mTvPolicNum;
        if (textView == null) {
            i.q2.t.i0.k("mTvPolicNum");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvSZNum() {
        TextView textView = this.mTvSZNum;
        if (textView == null) {
            i.q2.t.i0.k("mTvSZNum");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
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

    @j.c.a.e
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

    @Override // ui.activity.BaseActivity
    public void initPage() {
        SwipBackLayout.a(this.mActivity).a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            i.q2.t.i0.f();
        }
        textView.setText("\u786e\u8ba4\u63d0\u4ea4");
        initView();
    }

    public final void initView() {
        String stringExtra = getIntent().getStringExtra(util.p1.C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.reportIDBean = (ReportIDInfoBean) getIntent().getSerializableExtra(util.p1.f15010b);
        this.comitNumBean = (SignComitBean) getIntent().getSerializableExtra(util.p1.f15011c);
        this.mPreenter = new SignCommitPresenter(this.mActivity, this);
        TextView textView = this.mTvCaseName;
        if (textView == null) {
            i.q2.t.i0.k("mTvCaseName");
        }
        ReportIDInfoBean reportIDInfoBean = this.reportIDBean;
        textView.setText(reportIDInfoBean != null ? reportIDInfoBean.getCaseName() : null);
        TextView textView2 = this.mTvCaseTime;
        if (textView2 == null) {
            i.q2.t.i0.k("mTvCaseTime");
        }
        ReportIDInfoBean reportIDInfoBean2 = this.reportIDBean;
        textView2.setText(reportIDInfoBean2 != null ? reportIDInfoBean2.getProcessTime() : null);
        TextView textView3 = this.mTvCaseNum;
        if (textView3 == null) {
            i.q2.t.i0.k("mTvCaseNum");
        }
        ReportIDInfoBean reportIDInfoBean3 = this.reportIDBean;
        textView3.setText(reportIDInfoBean3 != null ? reportIDInfoBean3.getCaseNumber() : null);
        TextView textView4 = this.mTvPolicNum;
        if (textView4 == null) {
            i.q2.t.i0.k("mTvPolicNum");
        }
        ReportIDInfoBean reportIDInfoBean4 = this.reportIDBean;
        textView4.setText(reportIDInfoBean4 != null ? reportIDInfoBean4.getCaseCategoryText() : null);
        SignComitBean signComitBean = this.comitNumBean;
        Integer numValueOf = signComitBean != null ? Integer.valueOf(signComitBean.getVictimCount()) : null;
        if (numValueOf == null) {
            i.q2.t.i0.f();
        }
        this.victimCount = numValueOf.intValue();
        SignComitBean signComitBean2 = this.comitNumBean;
        Integer numValueOf2 = signComitBean2 != null ? Integer.valueOf(signComitBean2.getPaymentCount()) : null;
        if (numValueOf2 == null) {
            i.q2.t.i0.f();
        }
        this.paymentCount = numValueOf2.intValue();
        SignComitBean signComitBean3 = this.comitNumBean;
        Integer numValueOf3 = signComitBean3 != null ? Integer.valueOf(signComitBean3.getCallTelCount()) : null;
        if (numValueOf3 == null) {
            i.q2.t.i0.f();
        }
        this.callTelCount = numValueOf3.intValue();
        SignComitBean signComitBean4 = this.comitNumBean;
        Integer numValueOf4 = signComitBean4 != null ? Integer.valueOf(signComitBean4.getChargeTelCount()) : null;
        if (numValueOf4 == null) {
            i.q2.t.i0.f();
        }
        this.chargeTelCount = numValueOf4.intValue();
        SignComitBean signComitBean5 = this.comitNumBean;
        Integer numValueOf5 = signComitBean5 != null ? Integer.valueOf(signComitBean5.getLinkTelCount()) : null;
        if (numValueOf5 == null) {
            i.q2.t.i0.f();
        }
        this.linkTelCount = numValueOf5.intValue();
        SignComitBean signComitBean6 = this.comitNumBean;
        Integer numValueOf6 = signComitBean6 != null ? Integer.valueOf(signComitBean6.getMailingTelCount()) : null;
        if (numValueOf6 == null) {
            i.q2.t.i0.f();
        }
        this.mailingTelCount = numValueOf6.intValue();
        SignComitBean signComitBean7 = this.comitNumBean;
        Integer numValueOf7 = signComitBean7 != null ? Integer.valueOf(signComitBean7.getSmsCount()) : null;
        if (numValueOf7 == null) {
            i.q2.t.i0.f();
        }
        this.smsCount = numValueOf7.intValue();
        SignComitBean signComitBean8 = this.comitNumBean;
        Integer numValueOf8 = signComitBean8 != null ? Integer.valueOf(signComitBean8.getNetAccountCount()) : null;
        if (numValueOf8 == null) {
            i.q2.t.i0.f();
        }
        this.netAccountCount = numValueOf8.intValue();
        SignComitBean signComitBean9 = this.comitNumBean;
        Integer numValueOf9 = signComitBean9 != null ? Integer.valueOf(signComitBean9.getAppCount()) : null;
        if (numValueOf9 == null) {
            i.q2.t.i0.f();
        }
        this.appCount = numValueOf9.intValue();
        SignComitBean signComitBean10 = this.comitNumBean;
        Integer numValueOf10 = signComitBean10 != null ? Integer.valueOf(signComitBean10.getUrlCount()) : null;
        if (numValueOf10 == null) {
            i.q2.t.i0.f();
        }
        this.urlCount = numValueOf10.intValue();
        TextView textView5 = this.mTvSZNum;
        if (textView5 == null) {
            i.q2.t.i0.k("mTvSZNum");
        }
        textView5.setText("\u4e8b\u4e3b\u4fe1\u606f" + this.victimCount + "\u4e2a");
        TextView textView6 = this.mTvCaseAccNum;
        if (textView6 == null) {
            i.q2.t.i0.k("mTvCaseAccNum");
        }
        textView6.setText("\u6d89\u6848\u8d26\u6237" + this.paymentCount + "\u4e2a");
        TextView textView7 = this.mTvCriminalCallNum;
        if (textView7 == null) {
            i.q2.t.i0.k("mTvCriminalCallNum");
        }
        textView7.setText("\u901a\u8bdd\u7c7b" + this.callTelCount + "\u4e2a");
        TextView textView8 = this.mTvCriminalRecharge;
        if (textView8 == null) {
            i.q2.t.i0.k("mTvCriminalRecharge");
        }
        textView8.setText("\u5145\u503c\u7c7b" + this.chargeTelCount + "\u4e2a");
        TextView textView9 = this.mTvCriminalRelation;
        if (textView9 == null) {
            i.q2.t.i0.k("mTvCriminalRelation");
        }
        textView9.setText("\u5173\u8054\u7c7b" + this.linkTelCount + "\u4e2a");
        TextView textView10 = this.mTvCriminalDelivery;
        if (textView10 == null) {
            i.q2.t.i0.k("mTvCriminalDelivery");
        }
        textView10.setText("\u5bc4\u9012\u7c7b" + this.mailingTelCount + "\u4e2a");
        TextView textView11 = this.mTvCriminalSms;
        if (textView11 == null) {
            i.q2.t.i0.k("mTvCriminalSms");
        }
        textView11.setText("\u6d89\u8bc8\u77ed\u4fe1" + this.smsCount + "\u4e2a");
        TextView textView12 = this.mTvCriminalNet;
        if (textView12 == null) {
            i.q2.t.i0.k("mTvCriminalNet");
        }
        textView12.setText("\u4e92\u8054\u7f51\u8d26\u53f7" + this.netAccountCount + "\u4e2a");
        TextView textView13 = this.mTvCriminalApp;
        if (textView13 == null) {
            i.q2.t.i0.k("mTvCriminalApp");
        }
        textView13.setText("\u8bc8\u9a97APP" + this.appCount + "\u4e2a");
        TextView textView14 = this.mTvCriminalWebsit;
        if (textView14 == null) {
            i.q2.t.i0.k("mTvCriminalWebsit");
        }
        textView14.setText("\u6d89\u8bc8\u7f51\u5740" + this.urlCount + "\u4e2a");
        int i2 = this.callTelCount;
        if (this.chargeTelCount + i2 + this.linkTelCount + this.mailingTelCount == 0) {
            View view = this.mLlCriminalCall;
            if (view == null) {
                i.q2.t.i0.k("mLlCriminalCall");
            }
            view.setVisibility(8);
        } else {
            if (i2 == 0) {
                View view2 = this.mLlCall;
                if (view2 == null) {
                    i.q2.t.i0.k("mLlCall");
                }
                view2.setVisibility(8);
            }
            if (this.chargeTelCount == 0) {
                View view3 = this.mLlRecharge;
                if (view3 == null) {
                    i.q2.t.i0.k("mLlRecharge");
                }
                view3.setVisibility(8);
            }
            if (this.linkTelCount == 0) {
                View view4 = this.mLlRelation;
                if (view4 == null) {
                    i.q2.t.i0.k("mLlRelation");
                }
                view4.setVisibility(8);
            }
            if (this.mailingTelCount == 0) {
                View view5 = this.mLlDelivery;
                if (view5 == null) {
                    i.q2.t.i0.k("mLlDelivery");
                }
                view5.setVisibility(8);
            }
        }
        if (this.smsCount == 0) {
            View view6 = this.mLlSms;
            if (view6 == null) {
                i.q2.t.i0.k("mLlSms");
            }
            view6.setVisibility(8);
        }
        int i3 = this.netAccountCount;
        if (this.appCount + i3 + this.urlCount == 0) {
            View view7 = this.mLlCriminalNet;
            if (view7 == null) {
                i.q2.t.i0.k("mLlCriminalNet");
            }
            view7.setVisibility(8);
        } else {
            if (i3 == 0) {
                View view8 = this.mLlNet;
                if (view8 == null) {
                    i.q2.t.i0.k("mLlNet");
                }
                view8.setVisibility(8);
            }
            if (this.appCount == 0) {
                View view9 = this.mLlApp;
                if (view9 == null) {
                    i.q2.t.i0.k("mLlApp");
                }
                view9.setVisibility(8);
            }
            if (this.urlCount == 0) {
                View view10 = this.mLlWebsit;
                if (view10 == null) {
                    i.q2.t.i0.k("mLlWebsit");
                }
                view10.setVisibility(8);
            }
        }
        CheckBox checkBox = this.mTCbSelect;
        if (checkBox == null) {
            i.q2.t.i0.k("mTCbSelect");
        }
        checkBox.setOnCheckedChangeListener(new a());
    }

    @OnClick({R.id.iv_back, R.id.tv_shizhu_detial, R.id.tv_case_account_detial, R.id.tv_criminal_call_detial, R.id.tv_criminal_recharge_detial, R.id.tv_criminal_relation_detial, R.id.tv_criminal_delivery_detial, R.id.tv_criminal_sms_detial, R.id.tv_criminal_net_detial, R.id.tv_criminal_app_detial, R.id.tv_criminal_websit_detial, R.id.btn_commit})
    public final void onClick(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_commit /* 2131296407 */:
                CheckBox checkBox = this.mTCbSelect;
                if (checkBox == null) {
                    i.q2.t.i0.k("mTCbSelect");
                }
                if (!checkBox.isChecked()) {
                    e2.a("\u8bf7\u786e\u8ba4\u4e0a\u4f20\u7684\u6848\u4ef6\u4fe1\u606f\u5168\u90e8\u4e3a\u771f\u5b9e\u4fe1\u606f");
                } else {
                    SignCommitPresenter signCommitPresenter = this.mPreenter;
                    if (signCommitPresenter != null) {
                        signCommitPresenter.comitCaseInfo(this.caseInfoId);
                    }
                }
                break;
            case R.id.iv_back /* 2131296808 */:
                onBackPressed();
                break;
            case R.id.tv_case_account_detial /* 2131297609 */:
                if (this.paymentCount > 0) {
                    Intent intent = new Intent(this.mActivity, (Class<?>) AccountListPreviewActivity.class);
                    intent.putExtra(util.p1.C0, this.caseInfoId);
                    startActivity(intent);
                }
                break;
            case R.id.tv_criminal_app_detial /* 2131297653 */:
                if (this.appCount > 0) {
                    Intent intent2 = new Intent(this.mActivity, (Class<?>) SignCommitAppActivity.class);
                    intent2.putExtra(util.p1.C0, this.caseInfoId);
                    intent2.putExtra(util.p1.f15012d, true);
                    startActivity(intent2);
                }
                break;
            case R.id.tv_criminal_call_detial /* 2131297655 */:
                if (this.callTelCount > 0) {
                    Intent intent3 = new Intent(this.mActivity, (Class<?>) SignCallActivity.class);
                    intent3.putExtra(util.p1.C0, this.caseInfoId);
                    startActivity(intent3);
                }
                break;
            case R.id.tv_criminal_delivery_detial /* 2131297657 */:
                if (this.mailingTelCount > 0) {
                    Intent intent4 = new Intent(this.mActivity, (Class<?>) SignDeliveryActivity.class);
                    intent4.putExtra(util.p1.C0, this.caseInfoId);
                    startActivity(intent4);
                }
                break;
            case R.id.tv_criminal_net_detial /* 2131297659 */:
                if (this.netAccountCount > 0) {
                    Intent intent5 = new Intent(this.mActivity, (Class<?>) CriminalSocialActivity.class);
                    intent5.putExtra(util.p1.C0, this.caseInfoId);
                    intent5.putExtra(util.p1.f15012d, true);
                    startActivity(intent5);
                }
                break;
            case R.id.tv_criminal_recharge_detial /* 2131297661 */:
                if (this.chargeTelCount > 0) {
                    Intent intent6 = new Intent(this.mActivity, (Class<?>) SignReChargeActivity.class);
                    intent6.putExtra(util.p1.C0, this.caseInfoId);
                    startActivity(intent6);
                }
                break;
            case R.id.tv_criminal_relation_detial /* 2131297663 */:
                if (this.linkTelCount > 0) {
                    Intent intent7 = new Intent(this.mActivity, (Class<?>) SignRelationActivity.class);
                    intent7.putExtra(util.p1.C0, this.caseInfoId);
                    startActivity(intent7);
                }
                break;
            case R.id.tv_criminal_sms_detial /* 2131297665 */:
                if (this.smsCount > 0) {
                    Intent intent8 = new Intent(this.mActivity, (Class<?>) CriminalSmsActivity.class);
                    intent8.putExtra(util.p1.C0, this.caseInfoId);
                    intent8.putExtra(util.p1.f15012d, true);
                    startActivity(intent8);
                }
                break;
            case R.id.tv_criminal_websit_detial /* 2131297667 */:
                if (this.urlCount > 0) {
                    Intent intent9 = new Intent(this.mActivity, (Class<?>) SignCommitWebsiteActivity.class);
                    intent9.putExtra(util.p1.C0, this.caseInfoId);
                    startActivity(intent9);
                }
                break;
            case R.id.tv_shizhu_detial /* 2131297868 */:
                if (this.victimCount > 0) {
                    Intent intent10 = new Intent(this.mActivity, (Class<?>) SignCommitVictimActivity.class);
                    intent10.putExtra(util.p1.C0, this.caseInfoId);
                    startActivity(intent10);
                }
                break;
        }
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        g2.c(e.d.t);
    }

    @Override // ui.callview.ReportCommitView
    public void onSuccessHandle() {
        org.greenrobot.eventbus.c.f().d(new util.n2.a(34, null));
        startActivity(new Intent(this.mActivity, (Class<?>) ReportSuccessActivity.class));
        finish();
    }

    public final void setAppCount(int i2) {
        this.appCount = i2;
    }

    public final void setCallTelCount(int i2) {
        this.callTelCount = i2;
    }

    public final void setCaseInfoId(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "<set-?>");
        this.caseInfoId = str;
    }

    public final void setChargeTelCount(int i2) {
        this.chargeTelCount = i2;
    }

    public final void setComitNumBean(@j.c.a.e SignComitBean signComitBean) {
        this.comitNumBean = signComitBean;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_report_sign_comt;
    }

    public final void setLinkTelCount(int i2) {
        this.linkTelCount = i2;
    }

    public final void setMIvBack(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMLlApp(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlApp = view;
    }

    public final void setMLlCall(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlCall = view;
    }

    public final void setMLlCriminalCall(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlCriminalCall = view;
    }

    public final void setMLlCriminalNet(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlCriminalNet = view;
    }

    public final void setMLlDelivery(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlDelivery = view;
    }

    public final void setMLlNet(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlNet = view;
    }

    public final void setMLlRecharge(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlRecharge = view;
    }

    public final void setMLlRelation(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlRelation = view;
    }

    public final void setMLlSms(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlSms = view;
    }

    public final void setMLlWebsit(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlWebsit = view;
    }

    public final void setMPreenter(@j.c.a.e SignCommitPresenter signCommitPresenter) {
        this.mPreenter = signCommitPresenter;
    }

    public final void setMTCbSelect(@j.c.a.d CheckBox checkBox) {
        i.q2.t.i0.f(checkBox, "<set-?>");
        this.mTCbSelect = checkBox;
    }

    public final void setMTvCaseAccNum(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCaseAccNum = textView;
    }

    public final void setMTvCaseName(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCaseName = textView;
    }

    public final void setMTvCaseNum(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCaseNum = textView;
    }

    public final void setMTvCaseTime(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCaseTime = textView;
    }

    public final void setMTvCriminalApp(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCriminalApp = textView;
    }

    public final void setMTvCriminalCallNum(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCriminalCallNum = textView;
    }

    public final void setMTvCriminalDelivery(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCriminalDelivery = textView;
    }

    public final void setMTvCriminalNet(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCriminalNet = textView;
    }

    public final void setMTvCriminalRecharge(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCriminalRecharge = textView;
    }

    public final void setMTvCriminalRelation(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCriminalRelation = textView;
    }

    public final void setMTvCriminalSms(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCriminalSms = textView;
    }

    public final void setMTvCriminalWebsit(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCriminalWebsit = textView;
    }

    public final void setMTvPolicNum(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvPolicNum = textView;
    }

    public final void setMTvSZNum(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvSZNum = textView;
    }

    public final void setMTvTitle(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
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

    public final void setReportIDBean(@j.c.a.e ReportIDInfoBean reportIDInfoBean) {
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
