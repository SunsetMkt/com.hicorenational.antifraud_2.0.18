package p388ui.fragment;

import adapter.HomeNewCaseAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.HomeNewCaseBean;
import bean.NoteDlgBean;
import bean.module.HomeToolBean;
import bean.module.LocalModuelConfig;
import bean.module.ModuelConfig;
import bean.module.RegionMudelBean;
import butterknife.BindView;
import com.hicorenational.antifraud.C2113R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2873g;
import com.scwang.smartrefresh.layout.p189b.InterfaceC2876j;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2882b;
import com.scwang.smartrefresh.layout.p191d.InterfaceC2884d;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;
import interfaces.IOneClickListener;
import interfaces.IResultCallback;
import interfaces.IVerifyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import manager.AccountManager;
import manager.GrayManager;
import network.BannerInfo;
import network.http.ReportNumHttp;
import network.http.StatisticsHttp;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p245d.C4440a;
import p245d.C4441b;
import p247e.C4447d;
import p357j.C5845d;
import p388ui.activity.CheckIDActivity;
import p388ui.activity.NoteListActivity;
import p388ui.activity.PoliceInfoActivity;
import p388ui.activity.PoliceLoginActivity;
import p388ui.activity.ReportNewActivity;
import p388ui.activity.ReporterAidActivity;
import p388ui.activity.WarnSettingActivity;
import p388ui.activity.WebActivity;
import p388ui.activity.WebFullActivity;
import p388ui.callview.HomeCallView;
import p388ui.fragment.ToolView;
import p388ui.presenter.BasePagePresenter;
import p388ui.presenter.HomePresenter;
import p388ui.view.C7239q;
import p388ui.view.drag.RemovableView;
import util.C7257b1;
import util.C7292k1;
import util.C7301n1;
import util.C7307p1;
import util.C7325u1;
import util.C7337y1;
import util.C7340z1;
import util.p395c2.C7265a;
import util.permissionutil.C7310c;

/* loaded from: classes2.dex */
public class HomeFragment extends BaseFragment implements HomeCallView, View.OnClickListener, ToolView.InterfaceC6878b {
    public static boolean mIsVisibleToUser;
    private boolean isForceFresh;
    public HomeNewCaseAdapter mAdapter;

    @BindView(C2113R.id.banner)
    Banner mBanner;

    @BindView(C2113R.id.cl_banner_view)
    View mClBannerView;
    RemovableView mDragImageView;

    @BindView(C2113R.id.fl_note_view)
    View mFlNoteView;

    @BindView(C2113R.id.home_top_name)
    TextView mHomeTopName;
    ImageView mIvDrag;

    @BindView(C2113R.id.iv_polic_ent)
    ImageView mIvPolicEnt;

    @BindView(C2113R.id.ll_last)
    View mLlLast;
    private HomePresenter mPresenter;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.sm_refresh)
    SmartRefreshLayout mRefreshLayout;
    private StandardView mStandardView;
    private ToolView mToolitemsView;

    @BindView(C2113R.id.tv_more_case)
    TextView mTvMoreCase;

    @BindView(C2113R.id.tv_new_case)
    TextView mTvNewCase;

    @BindView(C2113R.id.tv_num_tip)
    TextView mTvNoteNum;

    @BindView(C2113R.id.tv_region)
    TextView mTvRegion;

    @BindView(C2113R.id.view_stub)
    ViewStub mViewStub;
    private BasePagePresenter presenter;
    private List<HomeNewCaseBean.RowsBean> mNewCaseList = new ArrayList();
    private List<BannerInfo> mBannerList = new ArrayList();
    public boolean isLoadmore = false;
    public int pageIndex = 1;
    public int pageSize = 10;

    /* renamed from: ui.fragment.HomeFragment$a */
    class ViewStubOnInflateListenerC6855a implements ViewStub.OnInflateListener {
        ViewStubOnInflateListenerC6855a() {
        }

        @Override // android.view.ViewStub.OnInflateListener
        public void onInflate(ViewStub viewStub, View view) {
            C7301n1.m26456b("ViewStub加载");
            HomeFragment homeFragment = HomeFragment.this;
            homeFragment.mDragImageView = (RemovableView) view;
            homeFragment.mIvDrag = (ImageView) view.findViewById(C2113R.id.iv_drag);
            HomeFragment homeFragment2 = HomeFragment.this;
            homeFragment2.mDragImageView.setOnClickListener(homeFragment2);
        }
    }

    /* renamed from: ui.fragment.HomeFragment$b */
    class C6856b implements IResultCallback {
        C6856b() {
        }

        @Override // interfaces.IResultCallback
        public void onIRSuccess(RegionMudelBean regionMudelBean) {
            if (regionMudelBean != null) {
                HomeFragment.this.refreshRegionData();
                if (HomeFragment.this.isForceFresh) {
                    C6049c.m24987f().m25000d(new C7265a(C7265a.f25194B0));
                }
            }
            HomeFragment homeFragment = HomeFragment.this;
            homeFragment.pageIndex = 1;
            homeFragment.mPresenter.getBanner();
        }
    }

    /* renamed from: ui.fragment.HomeFragment$c */
    class RunnableC6857c implements Runnable {
        RunnableC6857c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (HomeFragment.this.mStandardView != null) {
                HomeFragment.this.mStandardView.m25588a();
            }
        }
    }

    /* renamed from: ui.fragment.HomeFragment$d */
    class C6858d implements StatisticsHttp.CallbackComplete {

        /* renamed from: a */
        final /* synthetic */ boolean f23806a;

        /* renamed from: ui.fragment.HomeFragment$d$a */
        class a implements StatisticsHttp.CallbackComplete {

            /* renamed from: ui.fragment.HomeFragment$d$a$a, reason: collision with other inner class name */
            class C7438a implements StatisticsHttp.CallbackComplete {
                C7438a() {
                }

                @Override // network.http.StatisticsHttp.CallbackComplete
                public void onComplete() {
                    HomeFragment.this.mPresenter.getVerifyPoint();
                }
            }

            a() {
            }

            @Override // network.http.StatisticsHttp.CallbackComplete
            public void onComplete() {
                StatisticsHttp.getInstance().trackWarnApp((C6858d.this.f23806a && C7325u1.m26623a(C7325u1.f25637H, false)) ? "1" : "0", new C7438a());
            }
        }

        C6858d(boolean z) {
            this.f23806a = z;
        }

        @Override // network.http.StatisticsHttp.CallbackComplete
        public void onComplete() {
            HomeFragment homeFragment = HomeFragment.this;
            StatisticsHttp.getInstance().trackWarnSms((this.f23806a && C7310c.m26520a(homeFragment.mActivity, homeFragment.presenter.checkPermissionSms()) && C7325u1.m26623a(C7325u1.f25635G, false)) ? "1" : "0", new a());
        }
    }

    private void changeCenterView(RegionMudelBean regionMudelBean) {
        this.mToolitemsView.setDataChange(regionMudelBean);
        this.mStandardView.setDataChange(regionMudelBean);
    }

    private void checkPolice() {
        RegionMudelBean regionMudelBean = BaseFragment.mRegionBean;
        if (regionMudelBean == null || TextUtils.isEmpty(regionMudelBean.getLocalApi()) || !TextUtils.equals(BaseFragment.mRegionBean.getUseLocalPolice(), "1")) {
            return;
        }
        this.mPresenter.checkPolice(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: goTools, reason: merged with bridge method [inline-methods] */
    public void m25566a(String str) {
        if (TextUtils.equals(str, ModuelConfig.MODEL_REPORT)) {
            ReportNumHttp.getInstance().principalHttp(new ReportNumHttp.Callback() { // from class: ui.fragment.j
                @Override // network.http.ReportNumHttp.Callback
                public final void onNumSuccess() {
                    HomeFragment.this.m25572d();
                }
            });
            return;
        }
        if (TextUtils.equals(str, ModuelConfig.MODEL_CASEXC)) {
            startActivity(ReporterAidActivity.class);
            return;
        }
        if (TextUtils.equals(str, ModuelConfig.MODEL_WARN)) {
            startActivity(WarnSettingActivity.class);
        } else if (TextUtils.equals(str, ModuelConfig.MODEL_IDVERIFY)) {
            Intent intent = new Intent(this.mActivity, (Class<?>) CheckIDActivity.class);
            intent.putExtra(C7292k1.f25391c, this.mPresenter.getVerifyPointBean());
            startActivity(intent);
        }
    }

    private void initBanner() {
        ArrayList arrayList = new ArrayList();
        this.mBanner.setBannerStyle(1);
        this.mBanner.setImageLoader(C7239q.getImageLoader(this.mActivity));
        this.mBanner.setImages(arrayList);
        this.mBanner.setOnBannerListener(new OnBannerListener() { // from class: ui.fragment.a
            @Override // com.youth.banner.listener.OnBannerListener
            public final void OnBannerClick(int i2) {
                HomeFragment.this.m25564a(i2);
            }
        });
        if (Build.VERSION.SDK_INT >= 23 || !Build.MANUFACTURER.contains("NUBIA")) {
            this.mBanner.start();
        }
        C5845d.m24604a(this.mBanner, 20);
    }

    private void initListener() {
        this.mRefreshLayout.mo8622a((InterfaceC2873g) new ClassicsHeader(this.mActivity));
        this.mRefreshLayout.mo8682s(false);
        this.mRefreshLayout.mo8662h(true);
        this.mRefreshLayout.mo8627a(new InterfaceC2884d() { // from class: ui.fragment.d
            @Override // com.scwang.smartrefresh.layout.p191d.InterfaceC2884d
            /* renamed from: a */
            public final void mo8732a(InterfaceC2876j interfaceC2876j) {
                HomeFragment.this.m25565a(interfaceC2876j);
            }
        });
        this.mRefreshLayout.mo8625a(new InterfaceC2882b() { // from class: ui.fragment.f
            @Override // com.scwang.smartrefresh.layout.p191d.InterfaceC2882b
            /* renamed from: b */
            public final void mo8723b(InterfaceC2876j interfaceC2876j) {
                HomeFragment.this.m25568b(interfaceC2876j);
            }
        });
    }

    private void initRegionView() {
        BaseFragment.mRegionBean = C4440a.m16408j();
        changeCenterView(BaseFragment.mRegionBean);
        this.mPresenter.getBanner();
    }

    private void initViewNewCaseList() {
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this.mActivity, 1, false));
        this.mAdapter = new HomeNewCaseAdapter(this.mActivity, this.mNewCaseList);
        this.mToolitemsView = (ToolView) this.mActivity.findViewById(C2113R.id.view_tool);
        this.mToolitemsView.setItemClick(this);
        this.mStandardView = (StandardView) this.mActivity.findViewById(C2113R.id.view_standard);
        this.mHomeTopName.setTypeface(this.typ_ME);
        this.mStandardView.setTypeface(this.typ_ME);
        this.mTvNewCase.setTypeface(this.typ_ME);
        this.mTvMoreCase.setOnClickListener(new View.OnClickListener() { // from class: ui.fragment.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C6049c.m24987f().m25000d(new C7265a(104, null));
            }
        });
        this.mRecyclerview.setAdapter(this.mAdapter);
        if (AccountManager.getAccountInfo().isPolice()) {
            this.mIvPolicEnt.setVisibility(0);
        }
        this.mFlNoteView.setOnClickListener(this);
        this.mIvPolicEnt.setOnClickListener(this);
        this.mViewStub.setOnInflateListener(new ViewStubOnInflateListenerC6855a());
    }

    private void itemTurnPage(final String str, String str2, String str3, String str4, int i2) {
        if (this.mToolitemsView.m25598a(str)) {
            if (i2 == 1) {
                C7340z1.m26805a(this.mActivity).m26811a(Integer.parseInt(str), new IVerifyListener() { // from class: ui.fragment.g
                    @Override // interfaces.IVerifyListener
                    public final void onSuccessVerify() {
                        HomeFragment.this.m25566a(str);
                    }
                });
                return;
            } else {
                m25566a(str);
                return;
            }
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (i2 == 1) {
            urlOpenVerified(str, str2, str3, str4);
        } else {
            urlOpen(str, str3, str4);
        }
    }

    private void loadNewCaseCache() {
        List<HomeNewCaseBean.RowsBean> m26483b = C7307p1.m26483b(C7307p1.f25506o, HomeNewCaseBean.RowsBean.class);
        if (m26483b != null) {
            this.mAdapter.m249a(m26483b);
            this.mAdapter.notifyDataSetChanged();
            this.mRefreshLayout.mo8682s(false);
            this.pageIndex = 1;
            if (m26483b.size() > 0) {
                showMoreBtn(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshRegionData() {
        BaseFragment.mRegionBean = C4440a.m16408j();
        this.mPresenter.changeBottomView(BaseFragment.mRegionBean);
        changeCenterView(BaseFragment.mRegionBean);
    }

    private void showMoreBtn(boolean z) {
        if (z) {
            this.mRefreshLayout.mo8682s(false);
            this.mTvMoreCase.setVisibility(0);
        } else {
            this.mTvMoreCase.setVisibility(8);
            this.mLlLast.postDelayed(new RunnableC6857c(), 2000L);
        }
    }

    private void showRegistionRegion() {
        if (this.mTvRegion != null) {
            String registerRegionName = AccountManager.getRegisterRegionName();
            if (TextUtils.isEmpty(registerRegionName)) {
                this.mTvRegion.setText("");
                return;
            }
            if (registerRegionName.length() <= 4) {
                this.mTvRegion.setText(registerRegionName);
                return;
            }
            this.mTvRegion.setText(registerRegionName.substring(0, 3) + "...");
        }
    }

    private boolean toH5NoteView() {
        RegionMudelBean regionMudelBean = BaseFragment.mRegionBean;
        if (regionMudelBean == null || TextUtils.isEmpty(regionMudelBean.getBroadcast())) {
            return false;
        }
        Intent intent = new Intent(getActivity(), (Class<?>) WebFullActivity.class);
        intent.putExtra(C7292k1.f25365Q, BaseFragment.mRegionBean.getH5Url() + BaseFragment.mRegionBean.getBroadcast());
        startActivity(intent);
        return true;
    }

    private void urlOpen(String str, String str2, String str3) {
        if (TextUtils.equals(str2, ModuelConfig.OTYPE1)) {
            Intent intent = new Intent(getActivity(), (Class<?>) WebActivity.class);
            intent.putExtra(C7292k1.f25363P, C7337y1.m26795t(str3));
            intent.putExtra(C7292k1.f25365Q, str + AccountManager.getShareParam());
            startActivity(intent);
            return;
        }
        if (TextUtils.equals(str2, ModuelConfig.OTYPE2)) {
            Intent intent2 = new Intent(getActivity(), (Class<?>) WebActivity.class);
            intent2.putExtra(C7292k1.f25363P, C7337y1.m26795t(str3));
            intent2.putExtra(C7292k1.f25365Q, str);
            startActivity(intent2);
            return;
        }
        if (TextUtils.equals(str2, ModuelConfig.OTYPE3)) {
            C7292k1.m26394a((Context) this.mActivity, str);
        } else {
            C7292k1.m26393a(this.mActivity, str);
        }
    }

    private void urlOpenVerified(final String str, final String str2, String str3, final String str4) {
        if (TextUtils.equals(str3, ModuelConfig.OTYPE1) || TextUtils.equals(str3, ModuelConfig.OTYPE2)) {
            HashMap hashMap = new HashMap();
            hashMap.put(C7292k1.f25363P, C7337y1.m26795t(str4));
            hashMap.put(C7292k1.f25365Q, str + AccountManager.getShareParam());
            C7340z1.m26805a(this.mActivity).m26813a(18, hashMap, new IVerifyListener() { // from class: ui.fragment.k
                @Override // interfaces.IVerifyListener
                public final void onSuccessVerify() {
                    HomeFragment.this.m25570b(str4, str);
                }
            });
            return;
        }
        if (TextUtils.equals(str3, ModuelConfig.OTYPE3)) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(C7292k1.f25365Q, str);
            C7340z1.m26805a(this.mActivity).m26813a(19, hashMap2, new IVerifyListener() { // from class: ui.fragment.b
                @Override // interfaces.IVerifyListener
                public final void onSuccessVerify() {
                    HomeFragment.this.m25571c(str);
                }
            });
        } else {
            HashMap hashMap3 = new HashMap();
            hashMap3.put(C7292k1.f25365Q, str);
            C7340z1.m26805a(this.mActivity).m26813a(20, hashMap3, new IVerifyListener() { // from class: ui.fragment.i
                @Override // interfaces.IVerifyListener
                public final void onSuccessVerify() {
                    HomeFragment.this.m25567a(str2, str);
                }
            });
        }
    }

    public void autoForceRefresh() {
        this.isForceFresh = true;
        this.mRefreshLayout.mo8653e();
    }

    /* renamed from: b */
    public /* synthetic */ void m25568b(InterfaceC2876j interfaceC2876j) {
        pullToLoadMore();
    }

    /* renamed from: c */
    public /* synthetic */ void m25571c(String str) {
        C7292k1.m26394a((Context) this.mActivity, str);
    }

    /* renamed from: d */
    public /* synthetic */ void m25572d() {
        C7337y1.m26748a((Context) this.mActivity, (Class<?>) ReportNewActivity.class);
    }

    /* renamed from: e */
    public /* synthetic */ void m25573e() {
        RegionMudelBean regionMudelBean = BaseFragment.mRegionBean;
        if (regionMudelBean == null || TextUtils.isEmpty(regionMudelBean.getAssistantPolice())) {
            if (C4441b.m16416d()) {
                startActivity(PoliceInfoActivity.class);
                return;
            } else {
                startActivity(PoliceLoginActivity.class);
                return;
            }
        }
        C7292k1.m26393a(this.mActivity, BaseFragment.mRegionBean.getH5Url() + BaseFragment.mRegionBean.getAssistantPolice());
    }

    @Override // p388ui.fragment.BaseFragment
    protected int getLayoutId() {
        return C2113R.layout.fragment_home;
    }

    @Override // p388ui.fragment.BaseFragment
    protected void initPage() {
        C6049c.m24987f().m25001e(this);
        GrayManager.Companion.getInstance().setLayerGray(((BaseFragment) this).mView);
        this.mPresenter = new HomePresenter(this.mActivity, this);
        showRegistionRegion();
        initViewNewCaseList();
        initBanner();
        initListener();
        initRegionView();
    }

    @Override // p388ui.callview.HomeCallView
    public void onBannerSuccRequest(List<BannerInfo> list) {
        if (list != null && list.size() > 0) {
            this.mBannerList.clear();
            this.mBannerList = list;
            List<BannerInfo> list2 = this.mBannerList;
            if (list2 != null && list2.size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<BannerInfo> it = this.mBannerList.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getImgPath());
                }
                if (arrayList.size() > 0) {
                    this.mBanner.update(arrayList);
                }
            }
        }
        this.mPresenter.getNewCase(this.pageIndex, this.pageSize, this.mLlLast.isShown(), true);
    }

    @Override // p388ui.callview.HomeCallView
    public void onCheckPolice(boolean z, boolean z2) {
        if (z2) {
            if (z) {
                this.mIvPolicEnt.setVisibility(0);
            } else {
                this.mIvPolicEnt.setVisibility(8);
            }
        }
        RegionMudelBean regionMudelBean = BaseFragment.mRegionBean;
        if (regionMudelBean == null || TextUtils.isEmpty(regionMudelBean.getLocalApi()) || this.presenter != null) {
            this.mPresenter.getVerifyPoint();
            return;
        }
        this.presenter = new BasePagePresenter(this.mActivity);
        boolean isOpenFlowPrim = this.presenter.isOpenFlowPrim();
        StatisticsHttp.getInstance().trackWarnCall((isOpenFlowPrim && C7310c.m26520a(this.mActivity, this.presenter.checkPermissionCall()) && C7325u1.m26623a(C7325u1.f25633F, false)) ? "1" : "0", new C6858d(isOpenFlowPrim));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != C2113R.id.fl_note_view) {
            if (id != C2113R.id.iv_polic_ent) {
                return;
            }
            C7340z1.m26805a(this.mActivity).m26811a(13, new IVerifyListener() { // from class: ui.fragment.e
                @Override // interfaces.IVerifyListener
                public final void onSuccessVerify() {
                    HomeFragment.this.m25573e();
                }
            });
        } else {
            if (toH5NoteView()) {
                return;
            }
            this.mTvNoteNum.setVisibility(8);
            startActivity(NoteListActivity.class);
        }
    }

    @Override // p388ui.fragment.ToolView.InterfaceC6878b
    public void onClickToolItem(HomeToolBean homeToolBean) {
        itemTurnPage(homeToolBean.getModule(), homeToolBean.getId(), "", "", homeToolBean.getIsNeedVerified());
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEventWornThread(C7265a c7265a) {
        if (c7265a != null) {
            int m26297a = c7265a.m26297a();
            if (m26297a == 38 || m26297a == 39) {
                this.mPresenter.getVerifyHomePoint(null);
            }
        }
    }

    @Override // p388ui.callview.HomeCallView
    public void onNewCaseFail(boolean z) {
        this.mRefreshLayout.mo8658g();
        this.mRefreshLayout.mo8637b();
        if (!z) {
            this.mAdapter.m246a().clear();
            this.mAdapter.notifyDataSetChanged();
        } else if (this.mAdapter.m246a().size() <= 0) {
            loadNewCaseCache();
        }
        this.mPresenter.requestNoteDlg();
    }

    @Override // p388ui.callview.HomeCallView
    public void onNewCaseRequest(List<HomeNewCaseBean.RowsBean> list) {
        boolean z;
        try {
            this.mRefreshLayout.mo8658g();
            this.mRefreshLayout.mo8637b();
            z = true;
        } catch (Exception unused) {
        }
        if (list == null || list.size() <= 0) {
            if (this.isLoadmore) {
                this.mRefreshLayout.mo8682s(false);
                this.isLoadmore = false;
                C7307p1.m26480a(C7307p1.f25506o, (List) this.mAdapter.m246a());
                showMoreBtn(z);
                this.mPresenter.requestNoteDlg();
            }
            z = false;
            this.isLoadmore = false;
            C7307p1.m26480a(C7307p1.f25506o, (List) this.mAdapter.m246a());
            showMoreBtn(z);
            this.mPresenter.requestNoteDlg();
        }
        if (this.isLoadmore) {
            this.mAdapter.m246a().addAll(list);
            this.mAdapter.notifyDataSetChanged();
        } else {
            this.mAdapter.m249a(list);
            this.mRefreshLayout.mo8682s(true);
        }
        if (list.size() >= this.pageSize && list.size() <= this.pageSize) {
            this.mRefreshLayout.mo8682s(true);
            z = false;
            this.isLoadmore = false;
            C7307p1.m26480a(C7307p1.f25506o, (List) this.mAdapter.m246a());
            showMoreBtn(z);
            this.mPresenter.requestNoteDlg();
        }
        this.mRefreshLayout.mo8682s(false);
        this.isLoadmore = false;
        C7307p1.m26480a(C7307p1.f25506o, (List) this.mAdapter.m246a());
        showMoreBtn(z);
        this.mPresenter.requestNoteDlg();
        this.mPresenter.requestNoteDlg();
    }

    @Override // p388ui.callview.HomeCallView
    public void onNoteDlgRequest(NoteDlgBean noteDlgBean) {
        if (noteDlgBean != null) {
            if (!TextUtils.isEmpty(noteDlgBean.getTitle())) {
                C7257b1.m26173a(this.mActivity, noteDlgBean, (IOneClickListener) null);
            }
            if (noteDlgBean.isRedDot()) {
                this.mTvNoteNum.setVisibility(0);
            } else {
                this.mTvNoteNum.setVisibility(8);
            }
        } else {
            this.mTvNoteNum.setVisibility(8);
        }
        checkPolice();
    }

    @Override // p388ui.callview.HomeCallView
    public void onRedDotStatus(boolean z) {
        ToolView toolView = this.mToolitemsView;
        if (toolView != null) {
            toolView.m25597a(z);
        }
    }

    public void pullToLoadMore() {
        if (this.mRefreshLayout == null || this.mPresenter == null) {
            return;
        }
        this.isLoadmore = true;
        int size = this.mNewCaseList.size();
        int i2 = this.pageSize;
        int i3 = (size / i2) + 1;
        if (this.pageIndex >= i3) {
            this.mRefreshLayout.mo8637b();
        } else {
            this.pageIndex = i3;
            this.mPresenter.getNewCase(this.pageIndex, i2, this.mLlLast.isShown(), true);
        }
    }

    public void pullToRefresh() {
        LocalModuelConfig.getInstance().getConfigMude(this.isForceFresh, new C6856b());
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        mIsVisibleToUser = z;
        if (z) {
            StatisticsHttp.getInstance().pageOpenHttp(C4447d.f17160g);
        }
    }

    public void virusFinish() {
        this.mStandardView.m25589b();
    }

    public void virusStatus() {
        this.mStandardView.m25589b();
    }

    /* renamed from: a */
    public /* synthetic */ void m25565a(InterfaceC2876j interfaceC2876j) {
        this.isForceFresh = false;
        pullToRefresh();
    }

    /* renamed from: b */
    public /* synthetic */ void m25570b(String str, String str2) {
        Intent intent = new Intent(getActivity(), (Class<?>) WebActivity.class);
        intent.putExtra(C7292k1.f25363P, C7337y1.m26795t(str));
        intent.putExtra(C7292k1.f25365Q, str2 + AccountManager.getShareParam());
        startActivity(intent);
    }

    /* renamed from: a */
    public /* synthetic */ void m25564a(int i2) {
        List<BannerInfo> list;
        BannerInfo bannerInfo;
        if (isDouble() || (list = this.mBannerList) == null || list.size() <= 0 || this.mBannerList.size() - 1 < i2 || (bannerInfo = this.mBannerList.get(i2)) == null) {
            return;
        }
        itemTurnPage(bannerInfo.getUrl(), "", bannerInfo.getOpenType(), bannerInfo.getTitle(), bannerInfo.getIsNeedVerified());
    }

    /* renamed from: b */
    public /* synthetic */ void m25569b(String str) {
        C7292k1.m26393a(this.mActivity, str);
    }

    /* renamed from: a */
    public /* synthetic */ void m25567a(String str, final String str2) {
        if (TextUtils.equals(str, ModuelConfig.MODEL_REPORT)) {
            ReportNumHttp.getInstance().principalHttp(new ReportNumHttp.Callback() { // from class: ui.fragment.h
                @Override // network.http.ReportNumHttp.Callback
                public final void onNumSuccess() {
                    HomeFragment.this.m25569b(str2);
                }
            });
        } else {
            C7292k1.m26393a(this.mActivity, str2);
        }
    }
}
