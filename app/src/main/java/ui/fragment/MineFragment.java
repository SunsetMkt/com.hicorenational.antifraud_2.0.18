package ui.fragment;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import bean.RecordCountBean;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import manager.AccountManager;
import manager.LoginManager;
import network.CoinListInfo;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.ThreadMode;
import ui.activity.AboutUsActivity;
import ui.activity.FeedbackHelpActivity;
import ui.activity.HistoryReportEvdListActivity;
import ui.activity.MinePersonalActivity;
import ui.activity.ReportRecordsActivity;
import ui.activity.SettingActivity;
import ui.activity.WebActivity;
import ui.activity.WebFullActivity;
import ui.callview.DetailCoinListView;
import ui.callview.MineFagCallView;
import ui.presenter.MineFagPresenter;
import util.g2;
import util.p1;

/* JADX INFO: loaded from: classes2.dex */
public class MineFragment extends BaseFragment implements MineFagCallView, DetailCoinListView {

    @BindView(R.id.case_red_tip)
    TextView caseRedTip;

    @BindView(R.id.cl_head)
    View mClHead;

    @BindView(R.id.ll_ablout_app)
    View mLlAboutUs;

    @BindView(R.id.ll_datile)
    View mLlDetalHis;

    @BindView(R.id.ll_evidence_list)
    View mLlEvide;

    @BindView(R.id.ll_feedback)
    View mLlFeedBack;

    @BindView(R.id.ll_report_list)
    View mLlReport;

    @BindView(R.id.ll_setting)
    View mLlSetting;
    private MineFagPresenter mPresenter;

    @BindView(R.id.tv_evidNum)
    TextView mTvEvidNum;

    @BindView(R.id.tv_explain)
    TextView mTvExplain;

    @BindView(R.id.tv_Level_lb)
    TextView mTvLevelLb;

    @BindView(R.id.tv_phone)
    TextView mTvPhone;

    @BindView(R.id.tv_repNum)
    TextView mTvRepNum;

    @BindView(R.id.report_red_tip)
    TextView reportRedTip;

    private void readCasePot() {
        this.caseRedTip.setVisibility(4);
        if (this.reportRedTip.isShown()) {
            return;
        }
        org.greenrobot.eventbus.c.f().d(new util.n2.a(util.n2.a.C0, false));
    }

    private void readReportPot() {
        this.reportRedTip.setVisibility(4);
        if (this.caseRedTip.isShown()) {
            return;
        }
        org.greenrobot.eventbus.c.f().d(new util.n2.a(util.n2.a.C0, false));
    }

    private boolean toH5CaseRecord() {
        RegionMudelBean regionMudelBean = BaseFragment.mRegionBean;
        if (regionMudelBean == null || TextUtils.isEmpty(regionMudelBean.getCaseRecord())) {
            return false;
        }
        Intent intent = new Intent(getActivity(), (Class<?>) WebFullActivity.class);
        intent.putExtra(p1.Q, BaseFragment.mRegionBean.getH5Url() + BaseFragment.mRegionBean.getCaseRecord());
        startActivity(intent);
        return true;
    }

    private boolean toH5Feedback() {
        RegionMudelBean regionMudelBean = BaseFragment.mRegionBean;
        if (regionMudelBean == null || TextUtils.isEmpty(regionMudelBean.getFeedback())) {
            return false;
        }
        Intent intent = new Intent(getActivity(), (Class<?>) WebFullActivity.class);
        intent.putExtra(p1.Q, BaseFragment.mRegionBean.getH5Url() + BaseFragment.mRegionBean.getFeedback());
        startActivity(intent);
        return true;
    }

    private boolean toH5ReportRecord() {
        RegionMudelBean regionMudelBean = BaseFragment.mRegionBean;
        if (regionMudelBean == null || TextUtils.isEmpty(regionMudelBean.getReportRecord())) {
            return false;
        }
        Intent intent = new Intent(getActivity(), (Class<?>) WebFullActivity.class);
        intent.putExtra(p1.Q, BaseFragment.mRegionBean.getH5Url() + BaseFragment.mRegionBean.getReportRecord());
        startActivity(intent);
        return true;
    }

    public void forceFreshListSize() {
        if (getUserVisibleHint()) {
            if (e.a.j() == null) {
                this.mPresenter.getReportListSize("");
            } else if (e.a.j().getModles().get(ModuelConfig.MODEL_REPORT).equals(e.a.j().getModles().get(ModuelConfig.MODEL_CASEXC))) {
                this.mPresenter.getReportListSize("10111012");
            } else {
                this.mPresenter.getReportListSize(ModuelConfig.MODEL_REPORT);
                this.mPresenter.getReportListSize(ModuelConfig.MODEL_CASEXC);
            }
        }
    }

    @Override // ui.fragment.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override // ui.fragment.BaseFragment
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        this.mPresenter = new MineFagPresenter(this.mActivity, this);
        this.mTvPhone.setTypeface(this.typ_ME);
        this.mTvRepNum.setTypeface(this.typ_ME);
        this.mTvEvidNum.setTypeface(this.typ_ME);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventWornThread(util.n2.a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // ui.callview.MineFagCallView
    public void onFailRequestReport() {
        this.mPresenter.showComInfo();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (AccountManager.isLogin()) {
            this.mTvPhone.setText("\u60a8\u597d\uff0c" + g2.l(AccountManager.getAccountPhone()));
        } else {
            this.mTvPhone.setText("\u8bf7\u767b\u5f55");
        }
        forceFreshListSize();
    }

    @Override // ui.callview.DetailCoinListView
    public void onSuccessRequest(@j.c.a.d CoinListInfo coinListInfo) {
    }

    @Override // ui.callview.MineFagCallView
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
                org.greenrobot.eventbus.c.f().d(new util.n2.a(util.n2.a.C0, true));
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
                org.greenrobot.eventbus.c.f().d(new util.n2.a(util.n2.a.C0, true));
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
                org.greenrobot.eventbus.c.f().d(new util.n2.a(util.n2.a.C0, true));
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
                org.greenrobot.eventbus.c.f().d(new util.n2.a(util.n2.a.C0, true));
            } else {
                readCasePot();
            }
        } else {
            this.reportRedTip.setVisibility(4);
            this.caseRedTip.setVisibility(4);
            org.greenrobot.eventbus.c.f().d(new util.n2.a(util.n2.a.C0, false));
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

    @OnClick({R.id.tv_phone, R.id.ll_report_list, R.id.ll_evidence_list, R.id.cl_head, R.id.ll_user_note, R.id.ll_feedback, R.id.ll_ablout_app, R.id.ll_setting})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.cl_head /* 2131296480 */:
            case R.id.tv_phone /* 2131297803 */:
                if (!AccountManager.isLogin()) {
                    LoginManager.getInstance().exitToLogin();
                } else {
                    startActivity(MinePersonalActivity.class);
                }
                break;
            case R.id.ll_ablout_app /* 2131296960 */:
                startActivity(AboutUsActivity.class);
                break;
            case R.id.ll_evidence_list /* 2131296995 */:
                String string = this.mTvEvidNum.getText().toString();
                if (!TextUtils.isEmpty(string) && !TextUtils.equals("0", string) && !toH5CaseRecord()) {
                    startActivity(ReportRecordsActivity.class);
                    break;
                }
                break;
            case R.id.ll_feedback /* 2131296997 */:
                if (!toH5Feedback()) {
                    startActivity(FeedbackHelpActivity.class);
                }
                break;
            case R.id.ll_report_list /* 2131297028 */:
                String string2 = this.mTvRepNum.getText().toString();
                if (!TextUtils.isEmpty(string2) && !TextUtils.equals("0", string2) && !toH5ReportRecord()) {
                    startActivity(HistoryReportEvdListActivity.class);
                    break;
                }
                break;
            case R.id.ll_setting /* 2131297035 */:
                startActivity(SettingActivity.class);
                break;
            case R.id.ll_user_note /* 2131297048 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) WebActivity.class);
                intent.putExtra(p1.P, "\u7528\u6237\u624b\u518c");
                RegionMudelBean regionMudelBean = BaseFragment.mRegionBean;
                intent.putExtra(p1.Q, (regionMudelBean == null || TextUtils.isEmpty(regionMudelBean.getAndroidhandbook())) ? e.a.f10143g + f.b.z : BaseFragment.mRegionBean.getH5Url() + BaseFragment.mRegionBean.getAndroidhandbook());
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
        StatisticsHttp.getInstance().pageOpenHttp(f.d.s);
        onResume();
    }
}
