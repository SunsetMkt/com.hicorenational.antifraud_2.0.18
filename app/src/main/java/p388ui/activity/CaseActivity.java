package p388ui.activity;

import adapter.CaseAdapter;
import adapter.CaseOverAdapter;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CaseHistoryBean;
import bean.ReportZPEleBean;
import bean.module.RegionMudelBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2873g;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2876j;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2882b;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2884d;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p245d.C4440a;
import p247e.C4447d;
import p388ui.callview.CaseCallView;
import p388ui.presenter.CasePresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7264c1;
import util.C7274e1;
import util.C7292k1;
import util.C7328v1;
import util.C7331w1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class CaseActivity extends BaseActivity implements CaseCallView, BaseQuickAdapter.InterfaceC1897k, BaseQuickAdapter.InterfaceC1895i {
    private ReportZPEleBean info;

    @BindView(C2113R.id.et_case_code)
    EditText mEtCaseCode;

    @BindView(C2113R.id.et_name)
    EditText mEtName;

    @BindView(C2113R.id.iv_qrcode)
    ImageView mIvQrcode;

    @BindView(C2113R.id.iv_tab_create)
    ImageView mIvTabCreate;

    @BindView(C2113R.id.iv_tab_history)
    ImageView mIvTabHistory;

    @BindView(C2113R.id.ll_case)
    LinearLayout mLlCase;

    @BindView(C2113R.id.ll_case_create)
    LinearLayout mLlCaseCreate;

    @BindView(C2113R.id.ll_case_history)
    LinearLayout mLlCaseHistory;

    @BindView(C2113R.id.ll_case_qrcode)
    LinearLayout mLlCaseQRcode;

    @BindView(C2113R.id.include_over)
    View mNoDataOver;

    @BindView(C2113R.id.include_wait)
    View mNoDataWait;

    @BindView(C2113R.id.recyclerview_over)
    RecyclerView mRecyclerviewOver;

    @BindView(C2113R.id.recyclerview_wait)
    RecyclerView mRecyclerviewWait;

    @BindView(C2113R.id.sm_refresh_over)
    SmartRefreshLayout mSmRefreshOver;

    @BindView(C2113R.id.sm_refresh_wait)
    SmartRefreshLayout mSmRefreshWait;

    @BindView(C2113R.id.tv_case_code)
    TextView mTvCaseCode;

    @BindView(C2113R.id.tv_case_name)
    TextView mTvCaseName;

    @BindView(C2113R.id.tv_child_tab_over)
    TextView mTvChildTabOver;

    @BindView(C2113R.id.tv_child_tab_wait)
    TextView mTvChildTabWait;

    @BindView(C2113R.id.tv_date)
    TextView mTvDate;

    @BindView(C2113R.id.tv_history_dot)
    TextView mTvHistoryDot;

    @BindView(C2113R.id.tv_number)
    TextView mTvNumber;

    @BindView(C2113R.id.tv_tab_create)
    TextView mTvTabCreate;

    @BindView(C2113R.id.tv_tab_history)
    TextView mTvTabHistory;

    @BindView(C2113R.id.tv_type)
    TextView mTvType;
    private final int HISTORY_STATUS_OVER = 0;
    private final int HISTORY_STATUS_WAIT = 1;
    private long mTypeId = -1;
    private List<CaseHistoryBean.Rows> mWaitList = new ArrayList();
    private List<CaseHistoryBean.Rows> mOverList = new ArrayList();
    private CaseAdapter mWaitAdapter = null;
    private CaseOverAdapter mOverAdapter = null;
    private CasePresenter mPresenter = null;
    public boolean isLoadmoreWait = false;
    public boolean isLoadmoreOver = false;
    public int mPageIndexWait = 1;
    public int mPageIndexOver = 1;
    public int mPageSize = 6;
    private boolean isFirst = true;

    /* renamed from: ui.activity.CaseActivity$a */
    class RunnableC6181a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f21993a;

        /* renamed from: ui.activity.CaseActivity$a$a */
        class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ Bitmap f21995a;

            a(Bitmap bitmap) {
                this.f21995a = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                CaseActivity.this.mIvQrcode.setImageBitmap(this.f21995a);
            }
        }

        RunnableC6181a(String str) {
            this.f21993a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap decodeResource = BitmapFactory.decodeResource(CaseActivity.this.getResources(), C2113R.mipmap.ic_police_logo);
            int m26285a = C7264c1.m26285a(CaseActivity.this, 240.0f);
            Bitmap m26333a = C7274e1.m26333a(this.f21993a, m26285a, m26285a, decodeResource);
            ImageView imageView = CaseActivity.this.mIvQrcode;
            if (imageView != null) {
                imageView.post(new a(m26333a));
            }
        }
    }

    /* renamed from: ui.activity.CaseActivity$b */
    class C6182b implements IClickListener {

        /* renamed from: a */
        final /* synthetic */ int f21997a;

        C6182b(int i2) {
            this.f21997a = i2;
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            CaseActivity.this.mPresenter.deleteCase((CaseHistoryBean.Rows) CaseActivity.this.mWaitList.get(this.f21997a));
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
        }
    }

    private void changeChildTab(boolean z) {
        if (z) {
            if (this.mTvChildTabWait.isEnabled()) {
                this.mNoDataWait.setVisibility(8);
                changeTextBold(this.mTvChildTabWait, this.mTvChildTabOver);
                this.mTvChildTabWait.setBackgroundResource(C2113R.drawable.shape_sed_tab_type);
                this.mTvChildTabOver.setBackgroundColor(getResources().getColor(C2113R.color.white));
                this.mSmRefreshWait.setVisibility(0);
                this.mSmRefreshOver.setVisibility(8);
                this.mSmRefreshWait.mo8653e();
                return;
            }
            return;
        }
        if (this.mTvChildTabOver.isEnabled()) {
            this.mNoDataOver.setVisibility(8);
            changeTextBold(this.mTvChildTabOver, this.mTvChildTabWait);
            this.mTvChildTabWait.setBackgroundColor(getResources().getColor(C2113R.color.white));
            this.mTvChildTabOver.setBackgroundResource(C2113R.drawable.shape_sed_tab_type);
            this.mSmRefreshWait.setVisibility(8);
            this.mSmRefreshOver.setVisibility(0);
            this.mSmRefreshOver.mo8653e();
        }
    }

    private void changeTab(boolean z) {
        if (z) {
            if (this.mIvTabCreate.getVisibility() != 0) {
                changeTextBold(this.mTvTabCreate, this.mTvTabHistory);
                this.mIvTabCreate.setVisibility(0);
                this.mIvTabHistory.setVisibility(4);
                this.mLlCase.setVisibility(0);
                this.mLlCaseHistory.setVisibility(8);
                return;
            }
            return;
        }
        if (this.mIvTabHistory.getVisibility() != 0) {
            changeTextBold(this.mTvTabHistory, this.mTvTabCreate);
            this.mIvTabCreate.setVisibility(4);
            this.mIvTabHistory.setVisibility(0);
            this.mLlCase.setVisibility(8);
            this.mLlCaseHistory.setVisibility(0);
        }
    }

    private void changeTextBold(TextView textView, TextView textView2) {
        textView.setTypeface(Typeface.defaultFromStyle(1));
        textView2.setTypeface(Typeface.defaultFromStyle(0));
        textView.setTextColor(getResources().getColor(C2113R.color._2B48E7));
        textView2.setTextColor(getResources().getColor(C2113R.color.black_dark));
    }

    private void createQRcode(String str) {
        new Thread(new RunnableC6181a(str)).start();
    }

    private void initListener() {
        this.mTvChildTabWait.setEnabled(false);
        this.mSmRefreshWait.mo8622a((InterfaceC2873g) new ClassicsHeader(this));
        this.mSmRefreshWait.mo8682s(false);
        this.mSmRefreshWait.mo8627a(new InterfaceC2884d() { // from class: ui.activity.l
            @Override // com.scwang.smartrefresh.layout.p191d.InterfaceC2884d
            /* renamed from: a */
            public final void mo8732a(InterfaceC2876j interfaceC2876j) {
                CaseActivity.this.m25233a(interfaceC2876j);
            }
        });
        this.mSmRefreshWait.mo8625a(new InterfaceC2882b() { // from class: ui.activity.j
            @Override // com.scwang.smartrefresh.layout.p191d.InterfaceC2882b
            /* renamed from: b */
            public final void mo8723b(InterfaceC2876j interfaceC2876j) {
                CaseActivity.this.m25234b(interfaceC2876j);
            }
        });
        this.mSmRefreshWait.mo8653e();
        this.mSmRefreshOver.mo8622a((InterfaceC2873g) new ClassicsHeader(this));
        this.mSmRefreshOver.mo8682s(false);
        this.mSmRefreshOver.mo8627a(new InterfaceC2884d() { // from class: ui.activity.k
            @Override // com.scwang.smartrefresh.layout.p191d.InterfaceC2884d
            /* renamed from: a */
            public final void mo8732a(InterfaceC2876j interfaceC2876j) {
                CaseActivity.this.m25235c(interfaceC2876j);
            }
        });
        this.mSmRefreshOver.mo8625a(new InterfaceC2882b() { // from class: ui.activity.i
            @Override // com.scwang.smartrefresh.layout.p191d.InterfaceC2882b
            /* renamed from: b */
            public final void mo8723b(InterfaceC2876j interfaceC2876j) {
                CaseActivity.this.m25236d(interfaceC2876j);
            }
        });
        this.mSmRefreshOver.mo8653e();
    }

    private CaseOverAdapter initRecyclerOver(RecyclerView recyclerView, List<CaseHistoryBean.Rows> list) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        CaseOverAdapter caseOverAdapter = new CaseOverAdapter(list);
        caseOverAdapter.setOnItemChildClickListener(this);
        caseOverAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(caseOverAdapter);
        return caseOverAdapter;
    }

    private CaseAdapter initRecyclerWait(RecyclerView recyclerView, List<CaseHistoryBean.Rows> list) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        CaseAdapter caseAdapter = new CaseAdapter(list);
        caseAdapter.setOnItemChildClickListener(this);
        caseAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(caseAdapter);
        return caseAdapter;
    }

    private void onItemDelet(int i2) {
        C7257b1.m26211b(this.mActivity, "删除当前案件信息？", "", "确定", "取消", new C6182b(i2));
    }

    /* renamed from: a */
    public /* synthetic */ void m25233a(InterfaceC2876j interfaceC2876j) {
        CasePresenter casePresenter;
        if (this.mSmRefreshWait == null || (casePresenter = this.mPresenter) == null) {
            return;
        }
        casePresenter.caseStatus();
        this.mPageIndexWait = 1;
        this.isLoadmoreWait = false;
        this.mPresenter.caseHistory(1, this.mPageIndexWait, this.mPageSize);
    }

    /* renamed from: b */
    public /* synthetic */ void m25234b(InterfaceC2876j interfaceC2876j) {
        if (this.mSmRefreshWait == null || this.mPresenter == null) {
            return;
        }
        this.isLoadmoreWait = true;
        int size = this.mWaitList.size();
        int i2 = this.mPageSize;
        this.mPageIndexWait = (size / i2) + 1;
        this.mPresenter.caseHistory(1, this.mPageIndexWait, i2);
    }

    /* renamed from: c */
    public /* synthetic */ void m25235c(InterfaceC2876j interfaceC2876j) {
        CasePresenter casePresenter;
        if (this.mSmRefreshOver == null || (casePresenter = this.mPresenter) == null) {
            return;
        }
        this.mPageIndexOver = 1;
        this.isLoadmoreOver = false;
        casePresenter.caseHistory(0, this.mPageIndexOver, this.mPageSize);
    }

    /* renamed from: d */
    public /* synthetic */ void m25236d(InterfaceC2876j interfaceC2876j) {
        if (this.mSmRefreshOver == null || this.mPresenter == null) {
            return;
        }
        this.isLoadmoreOver = true;
        int size = this.mOverList.size();
        int i2 = this.mPageSize;
        this.mPageIndexOver = (size / i2) + 1;
        this.mPresenter.caseHistory(0, this.mPageIndexOver, i2);
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        StatisticsHttp.getInstance().pageOpenHttp(C4447d.f17164k);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        this.mPresenter = new CasePresenter(this, this);
        this.mWaitAdapter = initRecyclerWait(this.mRecyclerviewWait, this.mWaitList);
        this.mOverAdapter = initRecyclerOver(this.mRecyclerviewOver, this.mOverList);
        C6049c.m24987f().m25001e(this);
        initListener();
    }

    @Override // p388ui.callview.CaseCallView
    public void onCreateSuccessRequest(String str, String str2, String str3, String str4) {
        this.mLlCaseQRcode.setVisibility(0);
        this.mLlCaseCreate.setVisibility(8);
        if (TextUtils.isEmpty(str3)) {
            this.mTvCaseCode.setText(AbstractC1191a.f2568g);
        } else {
            this.mTvCaseCode.setText("采集编号：" + str3);
        }
        if (TextUtils.isEmpty(str4)) {
            this.mTvNumber.setVisibility(8);
        } else {
            this.mTvNumber.setVisibility(0);
            this.mTvNumber.setText(str4);
        }
        this.mTvCaseName.setText(str2);
        this.mIvQrcode.setImageResource(C2113R.mipmap.ic_placeholder);
        createQRcode(str);
        this.mTvDate.setText("报案日期：" + C7328v1.m26646a(System.currentTimeMillis()));
    }

    @Override // p388ui.callview.CaseCallView
    public void onDeleteSuccessRequest(CaseHistoryBean.Rows rows) {
        this.mWaitList.remove(rows);
        this.mWaitAdapter.notifyDataSetChanged();
        if (this.mWaitAdapter.m5134c().size() <= 0) {
            this.mNoDataWait.setVisibility(0);
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(C7265a c7265a) {
        if (c7265a != null) {
            int m26297a = c7265a.m26297a();
            if (m26297a != 3) {
                if (m26297a == 204 || m26297a == 205) {
                    this.mSmRefreshWait.mo8653e();
                    return;
                }
                return;
            }
            this.info = (ReportZPEleBean) c7265a.m26300b();
            ReportZPEleBean reportZPEleBean = this.info;
            if (reportZPEleBean != null) {
                this.mTvType.setText(reportZPEleBean.getName());
                this.mTypeId = this.info.getId();
            }
        }
    }

    @Override // p388ui.callview.CaseCallView
    public void onHistorySuccessRequest(CaseHistoryBean caseHistoryBean, int i2) {
        if (i2 == 0) {
            if (caseHistoryBean != null) {
                onOverSuccessRequest(caseHistoryBean.getRows());
                return;
            } else {
                this.mSmRefreshOver.mo8658g();
                this.mSmRefreshOver.mo8637b();
                return;
            }
        }
        if (i2 != 1) {
            return;
        }
        if (caseHistoryBean != null) {
            onWaitSuccessRequest(caseHistoryBean.getRows());
        } else {
            this.mSmRefreshWait.mo8658g();
            this.mSmRefreshWait.mo8637b();
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (!isDouble() && view.getId() == C2113R.id.iv_clear) {
            onItemDelet(i2);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1897k
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (isDouble()) {
            return;
        }
        CaseHistoryBean.Rows rows = (CaseHistoryBean.Rows) baseQuickAdapter.m5134c().get(i2);
        if (rows.getIsExpired() == 1) {
            return;
        }
        int status = rows.getStatus();
        if (status == 1 || status == 2) {
            Intent intent = new Intent(this, (Class<?>) QRcodeActivity.class);
            intent.putExtra(C7292k1.f25391c, rows);
            startActivity(intent);
            return;
        }
        if (status == 3) {
            rows.setStatus(5);
            this.mWaitAdapter.notifyItemChanged(i2);
        }
        Intent intent2 = new Intent(this, (Class<?>) CaseDetailActivity.class);
        intent2.putExtra(C7292k1.f25338C0, rows.getId());
        intent2.putExtra(C7292k1.f25394d, rows.getStatus());
        startActivity(intent2);
    }

    public void onOverSuccessRequest(List<CaseHistoryBean.Rows> list) {
        this.mSmRefreshOver.mo8658g();
        this.mSmRefreshOver.mo8637b();
        if (list != null && list.size() > 0) {
            RegionMudelBean m16408j = C4440a.m16408j();
            if (m16408j == null || (m16408j != null && !TextUtils.equals(m16408j.getStopPayment(), "1"))) {
                Iterator<CaseHistoryBean.Rows> it = list.iterator();
                while (it.hasNext()) {
                    it.next().setStopPaymentCount(0);
                }
            }
            if (this.isLoadmoreOver) {
                this.mOverList.addAll(list);
            } else {
                this.mOverList.clear();
                this.mOverList.addAll(list);
                this.mSmRefreshOver.mo8682s(true);
            }
            this.mOverAdapter.notifyDataSetChanged();
            if (list.size() < this.mPageSize) {
                this.mSmRefreshOver.mo8682s(false);
            } else if (list.size() > this.mPageSize) {
                this.mSmRefreshOver.mo8682s(false);
            } else {
                this.mSmRefreshOver.mo8682s(true);
            }
        } else if (this.isLoadmoreOver) {
            this.mSmRefreshOver.mo8682s(false);
        } else {
            this.mOverList.clear();
            this.mWaitAdapter.notifyDataSetChanged();
        }
        if (!this.mTvChildTabOver.isEnabled()) {
            if (this.mOverList.size() > 0) {
                this.mNoDataOver.setVisibility(8);
            } else {
                this.mNoDataOver.setVisibility(0);
            }
        }
        this.isLoadmoreOver = false;
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.isFirst) {
            return;
        }
        this.mPresenter.caseStatus();
        this.isFirst = false;
    }

    @Override // p388ui.callview.CaseCallView
    public void onStatusSuccessRequest(boolean z) {
        if (z) {
            this.mTvHistoryDot.setVisibility(0);
        } else {
            this.mTvHistoryDot.setVisibility(8);
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_tab_create, C2113R.id.tv_tab_history, C2113R.id.tv_type, C2113R.id.confirm, C2113R.id.tv_close, C2113R.id.tv_child_tab_wait, C2113R.id.tv_child_tab_over})
    public void onViewClicked(View view) {
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.confirm /* 2131296476 */:
                String obj = this.mEtName.getText().toString();
                if (!TextUtils.isEmpty(obj)) {
                    String charSequence = this.mTvType.getText().toString();
                    if (this.mTypeId != -1 && !TextUtils.isEmpty(charSequence)) {
                        this.mPresenter.createCase(obj, this.mEtCaseCode.getText().toString(), this.mTypeId, charSequence);
                        hideSoftInput();
                        break;
                    } else {
                        C7331w1.m26688a("请选择诈骗类型");
                        break;
                    }
                } else {
                    C7331w1.m26688a("请输入案件名称");
                    break;
                }
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                finish();
                break;
            case C2113R.id.tv_child_tab_over /* 2131297476 */:
                changeChildTab(false);
                this.mTvChildTabWait.setEnabled(true);
                this.mTvChildTabOver.setEnabled(false);
                break;
            case C2113R.id.tv_child_tab_wait /* 2131297477 */:
                changeChildTab(true);
                this.mTvChildTabWait.setEnabled(false);
                this.mTvChildTabOver.setEnabled(true);
                break;
            case C2113R.id.tv_close /* 2131297479 */:
                this.mLlCaseQRcode.setVisibility(8);
                this.mLlCaseCreate.setVisibility(0);
                this.mEtName.setText("");
                this.mEtCaseCode.setText("");
                this.mTvType.setText("");
                this.info = null;
                this.mTypeId = -1L;
                break;
            case C2113R.id.tv_tab_create /* 2131297746 */:
                changeTab(true);
                break;
            case C2113R.id.tv_tab_history /* 2131297747 */:
                changeTab(false);
                break;
            case C2113R.id.tv_type /* 2131297780 */:
                Intent intent = new Intent(this.mActivity, (Class<?>) TagFlowLaoutActivity.class);
                intent.putExtra(C7292k1.f25394d, 2);
                ReportZPEleBean reportZPEleBean = this.info;
                if (reportZPEleBean != null) {
                    intent.putExtra(C7292k1.f25361O, reportZPEleBean);
                }
                startActivity(intent);
                break;
        }
    }

    public void onWaitSuccessRequest(List<CaseHistoryBean.Rows> list) {
        this.mSmRefreshWait.mo8658g();
        this.mSmRefreshWait.mo8637b();
        if (list != null && list.size() > 0) {
            if (this.isLoadmoreWait) {
                this.mWaitList.addAll(list);
            } else {
                this.mWaitList.clear();
                this.mWaitList.addAll(list);
                this.mSmRefreshWait.mo8682s(true);
            }
            this.mWaitAdapter.notifyDataSetChanged();
            if (list.size() < this.mPageSize) {
                this.mSmRefreshWait.mo8682s(false);
            } else if (list.size() > this.mPageSize) {
                this.mSmRefreshWait.mo8682s(false);
            } else {
                this.mSmRefreshWait.mo8682s(true);
            }
        } else if (this.isLoadmoreWait) {
            this.mSmRefreshWait.mo8682s(false);
        } else {
            this.mWaitList.clear();
            this.mWaitAdapter.notifyDataSetChanged();
        }
        if (!this.mTvChildTabWait.isEnabled()) {
            if (this.mWaitList.size() > 0) {
                this.mNoDataWait.setVisibility(8);
            } else {
                this.mNoDataWait.setVisibility(0);
            }
        }
        this.isLoadmoreWait = false;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_case;
    }
}
