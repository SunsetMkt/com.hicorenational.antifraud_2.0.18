package p388ui.fragment;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import bean.RecordCountBean;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import manager.AccountManager;
import manager.LoginManager;
import network.CoinListInfo;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p245d.C4440a;
import p247e.C4445b;
import p247e.C4447d;
import p324i.p336c.p337a.InterfaceC5816d;
import p388ui.activity.AboutUsActivity;
import p388ui.activity.FeedbackHelpActivity;
import p388ui.activity.HistoryReportEvdListActivity;
import p388ui.activity.MinePersonalActivity;
import p388ui.activity.ReportRecordsActivity;
import p388ui.activity.SettingActivity;
import p388ui.activity.WebActivity;
import p388ui.activity.WebFullActivity;
import p388ui.callview.DetailCoinListView;
import p388ui.callview.MineFagCallView;
import p388ui.presenter.MineFagPresenter;
import util.C7292k1;
import util.C7337y1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class MineFragment extends BaseFragment implements MineFagCallView, DetailCoinListView {

    @BindView(C2113R.id.case_red_tip)
    TextView caseRedTip;

    @BindView(C2113R.id.cl_head)
    View mClHead;

    @BindView(C2113R.id.ll_ablout_app)
    View mLlAboutUs;

    @BindView(C2113R.id.ll_datile)
    View mLlDetalHis;

    @BindView(C2113R.id.ll_evidence_list)
    View mLlEvide;

    @BindView(C2113R.id.ll_feedback)
    View mLlFeedBack;

    @BindView(C2113R.id.ll_report_list)
    View mLlReport;

    @BindView(C2113R.id.ll_setting)
    View mLlSetting;
    private MineFagPresenter mPresenter;

    @BindView(C2113R.id.tv_evidNum)
    TextView mTvEvidNum;

    @BindView(C2113R.id.tv_explain)
    TextView mTvExplain;

    @BindView(C2113R.id.tv_Level_lb)
    TextView mTvLevelLb;

    @BindView(C2113R.id.tv_phone)
    TextView mTvPhone;

    @BindView(C2113R.id.tv_repNum)
    TextView mTvRepNum;

    @BindView(C2113R.id.report_red_tip)
    TextView reportRedTip;

    private void readCasePot() {
        this.caseRedTip.setVisibility(4);
        if (this.reportRedTip.isShown()) {
            return;
        }
        C6049c.m24987f().m25000d(new C7265a(C7265a.f25196C0, false));
    }

    private void readReportPot() {
        this.reportRedTip.setVisibility(4);
        if (this.caseRedTip.isShown()) {
            return;
        }
        C6049c.m24987f().m25000d(new C7265a(C7265a.f25196C0, false));
    }

    private boolean toH5CaseRecord() {
        RegionMudelBean regionMudelBean = BaseFragment.mRegionBean;
        if (regionMudelBean == null || TextUtils.isEmpty(regionMudelBean.getCaseRecord())) {
            return false;
        }
        Intent intent = new Intent(getActivity(), (Class<?>) WebFullActivity.class);
        intent.putExtra(C7292k1.f25365Q, BaseFragment.mRegionBean.getH5Url() + BaseFragment.mRegionBean.getCaseRecord());
        startActivity(intent);
        return true;
    }

    private boolean toH5Feedback() {
        RegionMudelBean regionMudelBean = BaseFragment.mRegionBean;
        if (regionMudelBean == null || TextUtils.isEmpty(regionMudelBean.getFeedback())) {
            return false;
        }
        Intent intent = new Intent(getActivity(), (Class<?>) WebFullActivity.class);
        intent.putExtra(C7292k1.f25365Q, BaseFragment.mRegionBean.getH5Url() + BaseFragment.mRegionBean.getFeedback());
        startActivity(intent);
        return true;
    }

    private boolean toH5ReportRecord() {
        RegionMudelBean regionMudelBean = BaseFragment.mRegionBean;
        if (regionMudelBean == null || TextUtils.isEmpty(regionMudelBean.getReportRecord())) {
            return false;
        }
        Intent intent = new Intent(getActivity(), (Class<?>) WebFullActivity.class);
        intent.putExtra(C7292k1.f25365Q, BaseFragment.mRegionBean.getH5Url() + BaseFragment.mRegionBean.getReportRecord());
        startActivity(intent);
        return true;
    }

    public void forceFreshListSize() {
        if (getUserVisibleHint()) {
            if (C4440a.m16408j() == null) {
                this.mPresenter.getReportListSize("");
            } else if (C4440a.m16408j().getModles().get(ModuelConfig.MODEL_REPORT).equals(C4440a.m16408j().getModles().get(ModuelConfig.MODEL_CASEXC))) {
                this.mPresenter.getReportListSize("10111012");
            } else {
                this.mPresenter.getReportListSize(ModuelConfig.MODEL_REPORT);
                this.mPresenter.getReportListSize(ModuelConfig.MODEL_CASEXC);
            }
        }
    }

    @Override // p388ui.fragment.BaseFragment
    protected int getLayoutId() {
        return C2113R.layout.fragment_mine;
    }

    @Override // p388ui.fragment.BaseFragment
    public void initPage() {
        C6049c.m24987f().m25001e(this);
        this.mPresenter = new MineFagPresenter(this.mActivity, this);
        this.mTvPhone.setTypeface(this.typ_ME);
        this.mTvRepNum.setTypeface(this.typ_ME);
        this.mTvEvidNum.setTypeface(this.typ_ME);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEventWornThread(C7265a c7265a) {
        if (c7265a != null) {
            c7265a.m26297a();
        }
    }

    @Override // p388ui.callview.MineFagCallView
    public void onFailRequestReport() {
        this.mPresenter.showComInfo();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (AccountManager.isLogin()) {
            this.mTvPhone.setText("您好，" + C7337y1.m26787l(AccountManager.getAccountPhone()));
        } else {
            this.mTvPhone.setText("请登录");
        }
        forceFreshListSize();
    }

    @Override // p388ui.callview.DetailCoinListView
    public void onSuccessRequest(@InterfaceC5816d CoinListInfo coinListInfo) {
    }

    @Override // p388ui.callview.MineFagCallView
    public void onSuccessRequestReport(String str, RecordCountBean recordCountBean) {
        int caseReportCount = recordCountBean.getCaseReportCount();
        int xcReportCount = recordCountBean.getXcReportCount();
        if (TextUtils.equals(str, ModuelConfig.MODEL_REPORT)) {
            if (caseReportCount > 0) {
                this.mTvRepNum.setText(caseReportCount + "");
            } else {
                this.mTvRepNum.setText("0");
            }
            if (recordCountBean.getCaseReportRedPoint() > 0) {
                this.reportRedTip.setVisibility(0);
                C6049c.m24987f().m25000d(new C7265a(C7265a.f25196C0, true));
            } else {
                readReportPot();
            }
        } else if (TextUtils.equals(str, ModuelConfig.MODEL_CASEXC)) {
            if (xcReportCount > 0) {
                this.mTvEvidNum.setText(xcReportCount + "");
            } else {
                this.mTvEvidNum.setText("0");
            }
            if (recordCountBean.getXcRedPoint() > 0) {
                this.caseRedTip.setVisibility(0);
                C6049c.m24987f().m25000d(new C7265a(C7265a.f25196C0, true));
            } else {
                readCasePot();
            }
        } else if (TextUtils.equals(str, "10111012")) {
            if (caseReportCount > 0) {
                this.mTvRepNum.setText(caseReportCount + "");
            } else {
                this.mTvRepNum.setText("0");
            }
            if (recordCountBean.getCaseReportRedPoint() > 0) {
                this.reportRedTip.setVisibility(0);
                C6049c.m24987f().m25000d(new C7265a(C7265a.f25196C0, true));
            } else {
                readReportPot();
            }
            if (xcReportCount > 0) {
                this.mTvEvidNum.setText(xcReportCount + "");
            } else {
                this.mTvEvidNum.setText("0");
            }
            if (recordCountBean.getXcRedPoint() > 0) {
                this.caseRedTip.setVisibility(0);
                C6049c.m24987f().m25000d(new C7265a(C7265a.f25196C0, true));
            } else {
                readCasePot();
            }
        } else {
            this.reportRedTip.setVisibility(4);
            this.caseRedTip.setVisibility(4);
            C6049c.m24987f().m25000d(new C7265a(C7265a.f25196C0, false));
            if (caseReportCount > 0) {
                this.mTvRepNum.setText(caseReportCount + "");
            } else {
                this.mTvRepNum.setText("0");
            }
            if (xcReportCount > 0) {
                this.mTvEvidNum.setText(xcReportCount + "");
            } else {
                this.mTvEvidNum.setText("0");
            }
        }
        this.mPresenter.showComInfo();
    }

    @OnClick({C2113R.id.tv_phone, C2113R.id.ll_report_list, C2113R.id.ll_evidence_list, C2113R.id.cl_head, C2113R.id.ll_user_note, C2113R.id.ll_feedback, C2113R.id.ll_ablout_app, C2113R.id.ll_setting})
    public void onViewClicked(View view) {
        String str;
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.cl_head /* 2131296458 */:
            case C2113R.id.tv_phone /* 2131297642 */:
                if (!AccountManager.isLogin()) {
                    LoginManager.getInstance().exitToLogin();
                    break;
                } else {
                    startActivity(MinePersonalActivity.class);
                    break;
                }
            case C2113R.id.ll_ablout_app /* 2131296910 */:
                startActivity(AboutUsActivity.class);
                break;
            case C2113R.id.ll_evidence_list /* 2131296945 */:
                String charSequence = this.mTvEvidNum.getText().toString();
                if (!TextUtils.isEmpty(charSequence) && !TextUtils.equals("0", charSequence) && !toH5CaseRecord()) {
                    startActivity(ReportRecordsActivity.class);
                    break;
                }
                break;
            case C2113R.id.ll_feedback /* 2131296947 */:
                if (!toH5Feedback()) {
                    startActivity(FeedbackHelpActivity.class);
                    break;
                }
                break;
            case C2113R.id.ll_report_list /* 2131296978 */:
                String charSequence2 = this.mTvRepNum.getText().toString();
                if (!TextUtils.isEmpty(charSequence2) && !TextUtils.equals("0", charSequence2) && !toH5ReportRecord()) {
                    startActivity(HistoryReportEvdListActivity.class);
                    break;
                }
                break;
            case C2113R.id.ll_setting /* 2131296985 */:
                startActivity(SettingActivity.class);
                break;
            case C2113R.id.ll_user_note /* 2131296998 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) WebActivity.class);
                intent.putExtra(C7292k1.f25363P, "用户手册");
                RegionMudelBean regionMudelBean = BaseFragment.mRegionBean;
                if (regionMudelBean == null || TextUtils.isEmpty(regionMudelBean.getAndroidhandbook())) {
                    str = C4440a.f16885g + C4445b.f17141y;
                } else {
                    str = BaseFragment.mRegionBean.getH5Url() + BaseFragment.mRegionBean.getAndroidhandbook();
                }
                intent.putExtra(C7292k1.f25365Q, str);
                startActivity(intent);
                break;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (!z || getActivity() == null) {
            return;
        }
        StatisticsHttp.getInstance().pageOpenHttp(C4447d.f17172s);
        onResume();
    }
}
