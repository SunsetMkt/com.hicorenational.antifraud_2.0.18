package ui.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import bean.AppInfoBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import event.AppEventBean;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import ui.Hicore;
import util.e2;
import util.x1;

/* JADX INFO: loaded from: classes2.dex */
public class AppSelectedActivity extends BaseActivity {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f13092h = "select_type";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f13093i = "extra_select_limite";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f13094j = "extra_select_now";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f13095k = "extra_select_can";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f13096l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f13097m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f13098n = 9;
    public static final int o = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<AppInfoBean> f13100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private adapter.f f13101d;

    @BindView(R.id.btn_report)
    Button mBtnReport;

    @BindView(R.id.recyclerview_app)
    ExpandableListView mExpandableList;

    @BindView(R.id.iv_back)
    ImageView mIvBack;

    @BindView(R.id.iv_right)
    ImageView mIvRight;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private int a = 9;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13099b = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<String> f13102e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<List<AppInfoBean>> f13103f = new ArrayList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ArrayList<AppInfoBean> f13104g = new ArrayList<>();

    class a implements ExpandableListView.OnChildClickListener {
        a() {
        }

        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j2) {
            AppInfoBean appInfoBean = (AppInfoBean) ((List) AppSelectedActivity.this.f13103f.get(i2)).get(i3);
            AppSelectedActivity appSelectedActivity = AppSelectedActivity.this;
            appSelectedActivity.a(appInfoBean, appSelectedActivity.f13101d);
            return true;
        }
    }

    static /* synthetic */ boolean a(ExpandableListView expandableListView, View view, int i2, long j2) {
        return true;
    }

    private void c() {
        showProgressDialog();
        final x1 x1Var = new x1(this);
        new Thread(new Runnable() { // from class: ui.activity.g
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(x1Var);
            }
        }).start();
    }

    private void initView() {
        org.greenrobot.eventbus.c.f().e(this);
        this.mTvTitle.setText("\u9009\u62e9APP\u5e94\u7528");
        this.f13099b = getIntent().getIntExtra(f13094j, 0);
        int intExtra = getIntent().getIntExtra(util.p1.f15012d, 0);
        int intExtra2 = getIntent().getIntExtra("extra_select_limite", 0);
        if (intExtra == 2) {
            this.mIvRight.setImageResource(R.drawable.iv_search);
        } else {
            this.mIvRight.setVisibility(8);
        }
        if (intExtra2 != 0) {
            this.a = intExtra2;
        }
        this.a -= this.f13099b;
        this.f13100c = new ArrayList();
        c();
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        initView();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(util.n2.a aVar) {
        if (aVar == null || aVar.a() != 35) {
            return;
        }
        finish();
    }

    @OnClick({R.id.iv_back, R.id.iv_right, R.id.btn_report})
    public void onViewClicked(View view) {
        long jCurrentTimeMillis;
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_report) {
            if (id == R.id.iv_back) {
                finish();
                return;
            } else {
                if (id != R.id.iv_right) {
                    return;
                }
                Intent intent = new Intent(this.mActivity, (Class<?>) SearchAppActivity.class);
                SearchAppActivity.f13767e = this.f13104g;
                startActivity(intent);
                return;
            }
        }
        if (this.f13100c.size() != 0) {
            for (int i2 = 0; i2 < this.f13100c.size(); i2++) {
                AppInfoBean appInfoBean = this.f13100c.get(i2);
                if (TextUtils.isEmpty(appInfoBean.getActivityName())) {
                    try {
                        jCurrentTimeMillis = new File(appInfoBean.getPkgPath()).lastModified();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        jCurrentTimeMillis = System.currentTimeMillis();
                    }
                    appInfoBean.setLastTime(jCurrentTimeMillis);
                }
                org.greenrobot.eventbus.c.f().d(new util.n2.a(30, appInfoBean));
            }
            org.greenrobot.eventbus.c.f().d(new AppEventBean(this.f13100c));
        }
        finish();
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_app_selected;
    }

    private void b() {
        this.f13101d = new adapter.f(this.mActivity, this.f13102e, this.f13103f);
        this.mExpandableList.setAdapter(this.f13101d);
        for (int i2 = 0; i2 < this.f13102e.size(); i2++) {
            this.mExpandableList.expandGroup(i2);
        }
        this.mExpandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() { // from class: ui.activity.e
            @Override // android.widget.ExpandableListView.OnGroupClickListener
            public final boolean onGroupClick(ExpandableListView expandableListView, View view, int i3, long j2) {
                return AppSelectedActivity.a(expandableListView, view, i3, j2);
            }
        });
        this.mExpandableList.setOnChildClickListener(new a());
    }

    public /* synthetic */ void a(x1 x1Var) {
        final List<AppInfoBean> listA = x1.a(new String[]{x1.f15111d});
        final List<AppInfoBean> listA2 = x1Var.a();
        runOnUiThread(new Runnable() { // from class: ui.activity.f
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(listA, listA2);
            }
        });
    }

    public /* synthetic */ void a(List list, List list2) {
        if (this.mActivity.isFinishing()) {
            return;
        }
        this.f13102e.add("\u672a\u5b89\u88c5\u5b89\u88c5\u5305");
        this.f13102e.add("\u5df2\u5b89\u88c5\u5e94\u7528");
        this.f13103f.add(list);
        this.f13103f.add(list2);
        this.f13104g.addAll(list);
        this.f13104g.addAll(list2);
        b();
        hideProgressDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppInfoBean appInfoBean, adapter.f fVar) {
        if (appInfoBean.getFileSize() > 209715200) {
            e2.a("200M\u4ee5\u4e0a\u6587\u4ef6\u4e0d\u53ef\u9009\u62e9");
            return;
        }
        if (!appInfoBean.isSelect()) {
            if (this.a == 1) {
                a();
            } else if (this.f13100c.size() == this.a) {
                e2.a("\u6700\u591a\u9009\u62e9" + this.a + "\u4e2a");
                return;
            }
            this.f13100c.add(appInfoBean);
            appInfoBean.setSelect(true);
        } else {
            this.f13100c.remove(appInfoBean);
            appInfoBean.setSelect(false);
        }
        fVar.notifyDataSetChanged();
    }

    private void a() {
        for (int i2 = 0; i2 < this.f13103f.size(); i2++) {
            List<AppInfoBean> list = this.f13103f.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                list.get(i3).setSelect(false);
            }
        }
        this.f13101d.a(this.f13102e, this.f13103f);
        this.f13100c.clear();
    }
}
