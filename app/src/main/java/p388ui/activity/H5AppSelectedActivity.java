package p388ui.activity;

import adapter.C0082f;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import bean.AppInfoBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.C2113R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import java.util.ArrayList;
import java.util.List;
import p388ui.Hicore;
import util.C7316r1;
import util.C7331w1;

/* loaded from: classes2.dex */
public class H5AppSelectedActivity extends BaseActivity {

    /* renamed from: g */
    public static final String f22358g = "extra_select_limite";

    /* renamed from: h */
    public static final int f22359h = 9;

    /* renamed from: i */
    public static final int f22360i = 1;

    /* renamed from: c */
    private C0082f f22363c;

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
    private int f22361a = 9;

    /* renamed from: b */
    private List<AppInfoBean> f22362b = new ArrayList();

    /* renamed from: d */
    private List<String> f22364d = new ArrayList();

    /* renamed from: e */
    private ArrayList<List<AppInfoBean>> f22365e = new ArrayList<>();

    /* renamed from: f */
    private ArrayList<AppInfoBean> f22366f = new ArrayList<>();

    /* renamed from: ui.activity.H5AppSelectedActivity$a */
    class C6321a implements ExpandableListView.OnChildClickListener {
        C6321a() {
        }

        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j2) {
            AppInfoBean appInfoBean = (AppInfoBean) ((List) H5AppSelectedActivity.this.f22365e.get(i2)).get(i3);
            H5AppSelectedActivity h5AppSelectedActivity = H5AppSelectedActivity.this;
            h5AppSelectedActivity.m25244a(appInfoBean, h5AppSelectedActivity.f22363c);
            return true;
        }
    }

    /* renamed from: a */
    static /* synthetic */ boolean m25246a(ExpandableListView expandableListView, View view, int i2, long j2) {
        return true;
    }

    /* renamed from: c */
    private void m25249c() {
        showProgressDialog();
        final C7316r1 c7316r1 = new C7316r1(this);
        new Thread(new Runnable() { // from class: ui.activity.s
            @Override // java.lang.Runnable
            public final void run() {
                H5AppSelectedActivity.this.m25251a(c7316r1);
            }
        }).start();
    }

    private void initView() {
        this.mTvTitle.setText("选择APP应用");
        int intExtra = getIntent().getIntExtra("extra_select_limite", 0);
        if (intExtra > 0) {
            this.f22361a = intExtra;
        }
        m25249c();
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        initView();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.iv_right, C2113R.id.btn_report})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != C2113R.id.btn_report) {
            if (id != C2113R.id.iv_back) {
                return;
            }
            finish();
        } else {
            Intent intent = getIntent();
            intent.putParcelableArrayListExtra(PictureConfig.EXTRA_RESULT_SELECTION, (ArrayList) this.f22362b);
            PictureSelector.putIntentResult(this.f22362b);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_app_selected;
    }

    /* renamed from: b */
    private void m25248b() {
        this.f22363c = new C0082f(this.mActivity, this.f22364d, this.f22365e);
        this.mExpandableList.setAdapter(this.f22363c);
        for (int i2 = 0; i2 < this.f22364d.size(); i2++) {
            this.mExpandableList.expandGroup(i2);
        }
        this.mExpandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() { // from class: ui.activity.r
            @Override // android.widget.ExpandableListView.OnGroupClickListener
            public final boolean onGroupClick(ExpandableListView expandableListView, View view, int i3, long j2) {
                return H5AppSelectedActivity.m25246a(expandableListView, view, i3, j2);
            }
        });
        this.mExpandableList.setOnChildClickListener(new C6321a());
    }

    /* renamed from: a */
    public /* synthetic */ void m25251a(C7316r1 c7316r1) {
        final List<AppInfoBean> m26538a = C7316r1.m26538a(new String[]{C7316r1.f25586d}, true);
        final List<AppInfoBean> m26557a = c7316r1.m26557a();
        runOnUiThread(new Runnable() { // from class: ui.activity.t
            @Override // java.lang.Runnable
            public final void run() {
                H5AppSelectedActivity.this.m25250a(m26538a, m26557a);
            }
        });
    }

    /* renamed from: a */
    public /* synthetic */ void m25250a(List list, List list2) {
        if (this.mActivity.isFinishing()) {
            return;
        }
        this.f22364d.add("未安装安装包");
        this.f22364d.add("已安装应用");
        this.f22365e.add(list);
        this.f22365e.add(list2);
        this.f22366f.addAll(list);
        this.f22366f.addAll(list2);
        m25248b();
        hideProgressDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m25244a(AppInfoBean appInfoBean, C0082f c0082f) {
        if (appInfoBean.getFileSize() > 209715200) {
            C7331w1.m26688a("200M以上文件不可选择");
            return;
        }
        if (!appInfoBean.isSelect()) {
            if (this.f22361a == 1) {
                m25243a();
            } else if (this.f22362b.size() == this.f22361a) {
                C7331w1.m26688a("最多选择" + this.f22361a + "个");
                return;
            }
            this.f22362b.add(appInfoBean);
            appInfoBean.setSelect(true);
        } else {
            this.f22362b.remove(appInfoBean);
            appInfoBean.setSelect(false);
        }
        c0082f.notifyDataSetChanged();
    }

    /* renamed from: a */
    private void m25243a() {
        for (int i2 = 0; i2 < this.f22365e.size(); i2++) {
            List<AppInfoBean> list = this.f22365e.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                list.get(i3).setSelect(false);
            }
        }
        this.f22363c.m292a(this.f22364d, this.f22365e);
        this.f22362b.clear();
    }
}
