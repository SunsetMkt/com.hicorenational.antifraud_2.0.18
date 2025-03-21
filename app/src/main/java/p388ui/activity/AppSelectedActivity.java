package p388ui.activity;

import adapter.C0082f;
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
import com.hicorenational.antifraud.C2113R;
import event.AppEventBean;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p388ui.Hicore;
import util.C7292k1;
import util.C7316r1;
import util.C7331w1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class AppSelectedActivity extends BaseActivity {

    /* renamed from: h */
    public static final String f21819h = "select_type";

    /* renamed from: i */
    public static final String f21820i = "extra_select_limite";

    /* renamed from: j */
    public static final String f21821j = "extra_select_now";

    /* renamed from: k */
    public static final String f21822k = "extra_select_can";

    /* renamed from: l */
    public static final int f21823l = 1;

    /* renamed from: m */
    public static final int f21824m = 2;

    /* renamed from: n */
    public static final int f21825n = 9;

    /* renamed from: o */
    public static final int f21826o = 1;

    /* renamed from: c */
    private List<AppInfoBean> f21829c;

    /* renamed from: d */
    private C0082f f21830d;

    @BindView(C2113R.id.btn_report)
    Button mBtnReport;

    @BindView(C2113R.id.recyclerview_app)
    ExpandableListView mExpandableList;

    @BindView(C2113R.id.iv_back)
    ImageView mIvBack;

    @BindView(C2113R.id.iv_right)
    ImageView mIvRight;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    /* renamed from: a */
    private int f21827a = 9;

    /* renamed from: b */
    private int f21828b = 0;

    /* renamed from: e */
    private List<String> f21831e = new ArrayList();

    /* renamed from: f */
    private ArrayList<List<AppInfoBean>> f21832f = new ArrayList<>();

    /* renamed from: g */
    private ArrayList<AppInfoBean> f21833g = new ArrayList<>();

    /* renamed from: ui.activity.AppSelectedActivity$a */
    class C6124a implements ExpandableListView.OnChildClickListener {
        C6124a() {
        }

        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j2) {
            AppInfoBean appInfoBean = (AppInfoBean) ((List) AppSelectedActivity.this.f21832f.get(i2)).get(i3);
            AppSelectedActivity appSelectedActivity = AppSelectedActivity.this;
            appSelectedActivity.m25201a(appInfoBean, appSelectedActivity.f21830d);
            return true;
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m25203a(ExpandableListView expandableListView, View view, int i2, long j2) {
        return true;
    }

    /* renamed from: c */
    private void m25206c() {
        showProgressDialog();
        final C7316r1 c7316r1 = new C7316r1(this);
        new Thread(new Runnable() { // from class: ui.activity.e
            @Override // java.lang.Runnable
            public final void run() {
                AppSelectedActivity.this.m25208a(c7316r1);
            }
        }).start();
    }

    private void initView() {
        C6049c.m24987f().m25001e(this);
        this.mTvTitle.setText("选择APP应用");
        this.f21828b = getIntent().getIntExtra(f21821j, 0);
        int intExtra = getIntent().getIntExtra(C7292k1.f25394d, 0);
        int intExtra2 = getIntent().getIntExtra("extra_select_limite", 0);
        if (intExtra == 2) {
            this.mIvRight.setImageResource(C2113R.drawable.iv_search);
        } else {
            this.mIvRight.setVisibility(8);
        }
        if (intExtra2 != 0) {
            this.f21827a = intExtra2;
        }
        this.f21827a -= this.f21828b;
        this.f21829c = new ArrayList();
        m25206c();
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        initView();
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(C7265a c7265a) {
        if (c7265a == null || c7265a.m26297a() != 35) {
            return;
        }
        finish();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.iv_right, C2113R.id.btn_report})
    public void onViewClicked(View view) {
        long currentTimeMillis;
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != C2113R.id.btn_report) {
            if (id == C2113R.id.iv_back) {
                finish();
                return;
            } else {
                if (id != C2113R.id.iv_right) {
                    return;
                }
                Intent intent = new Intent(this.mActivity, (Class<?>) SearchAppActivity.class);
                SearchAppActivity.f23041e = this.f21833g;
                startActivity(intent);
                return;
            }
        }
        if (this.f21829c.size() != 0) {
            for (int i2 = 0; i2 < this.f21829c.size(); i2++) {
                AppInfoBean appInfoBean = this.f21829c.get(i2);
                if (TextUtils.isEmpty(appInfoBean.getActivityName())) {
                    try {
                        currentTimeMillis = new File(appInfoBean.getPkgPath()).lastModified();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        currentTimeMillis = System.currentTimeMillis();
                    }
                    appInfoBean.setLastTime(currentTimeMillis);
                }
                C6049c.m24987f().m25000d(new C7265a(30, appInfoBean));
            }
            C6049c.m24987f().m25000d(new AppEventBean(this.f21829c));
        }
        finish();
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_app_selected;
    }

    /* renamed from: b */
    private void m25205b() {
        this.f21830d = new C0082f(this.mActivity, this.f21831e, this.f21832f);
        this.mExpandableList.setAdapter(this.f21830d);
        for (int i2 = 0; i2 < this.f21831e.size(); i2++) {
            this.mExpandableList.expandGroup(i2);
        }
        this.mExpandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() { // from class: ui.activity.c
            @Override // android.widget.ExpandableListView.OnGroupClickListener
            public final boolean onGroupClick(ExpandableListView expandableListView, View view, int i3, long j2) {
                return AppSelectedActivity.m25203a(expandableListView, view, i3, j2);
            }
        });
        this.mExpandableList.setOnChildClickListener(new C6124a());
    }

    /* renamed from: a */
    public /* synthetic */ void m25208a(C7316r1 c7316r1) {
        final List<AppInfoBean> m26537a = C7316r1.m26537a(new String[]{C7316r1.f25586d});
        final List<AppInfoBean> m26557a = c7316r1.m26557a();
        runOnUiThread(new Runnable() { // from class: ui.activity.d
            @Override // java.lang.Runnable
            public final void run() {
                AppSelectedActivity.this.m25207a(m26537a, m26557a);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m25207a(List list, List list2) {
        if (this.mActivity.isFinishing()) {
            return;
        }
        this.f21831e.add("未安装安装包");
        this.f21831e.add("已安装应用");
        this.f21832f.add(list);
        this.f21832f.add(list2);
        this.f21833g.addAll(list);
        this.f21833g.addAll(list2);
        m25205b();
        hideProgressDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m25201a(AppInfoBean appInfoBean, C0082f c0082f) {
        if (appInfoBean.getFileSize() > 209715200) {
            C7331w1.m26688a("200M以上文件不可选择");
            return;
        }
        if (!appInfoBean.isSelect()) {
            if (this.f21827a == 1) {
                m25200a();
            } else if (this.f21829c.size() == this.f21827a) {
                C7331w1.m26688a("最多选择" + this.f21827a + "个");
                return;
            }
            this.f21829c.add(appInfoBean);
            appInfoBean.setSelect(true);
        } else {
            this.f21829c.remove(appInfoBean);
            appInfoBean.setSelect(false);
        }
        c0082f.notifyDataSetChanged();
    }

    /* renamed from: a */
    private void m25200a() {
        for (int i2 = 0; i2 < this.f21832f.size(); i2++) {
            List<AppInfoBean> list = this.f21832f.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                list.get(i3).setSelect(false);
            }
        }
        this.f21830d.m292a(this.f21831e, this.f21832f);
        this.f21829c.clear();
    }
}
