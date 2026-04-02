package ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import bean.AppInfoBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import java.util.ArrayList;
import java.util.List;
import ui.Hicore;
import util.e2;
import util.x1;

/* JADX INFO: loaded from: classes2.dex */
public class H5AppSelectedActivity extends BaseActivity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f13392g = "extra_select_limite";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f13393h = 9;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f13394i = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private adapter.f f13396c;

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
    private List<AppInfoBean> f13395b = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<String> f13397d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<List<AppInfoBean>> f13398e = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<AppInfoBean> f13399f = new ArrayList<>();

    class a implements ExpandableListView.OnChildClickListener {
        a() {
        }

        @Override // android.widget.ExpandableListView.OnChildClickListener
        public boolean onChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j2) {
            AppInfoBean appInfoBean = (AppInfoBean) ((List) H5AppSelectedActivity.this.f13398e.get(i2)).get(i3);
            H5AppSelectedActivity h5AppSelectedActivity = H5AppSelectedActivity.this;
            h5AppSelectedActivity.a(appInfoBean, h5AppSelectedActivity.f13396c);
            return true;
        }
    }

    static /* synthetic */ boolean a(ExpandableListView expandableListView, View view, int i2, long j2) {
        return true;
    }

    private void c() {
        showProgressDialog();
        final x1 x1Var = new x1(this);
        new Thread(new Runnable() { // from class: ui.activity.u
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(x1Var);
            }
        }).start();
    }

    private void initView() {
        this.mTvTitle.setText("\u9009\u62e9APP\u5e94\u7528");
        int intExtra = getIntent().getIntExtra("extra_select_limite", 0);
        if (intExtra > 0) {
            this.a = intExtra;
        }
        c();
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        initView();
    }

    @OnClick({R.id.iv_back, R.id.iv_right, R.id.btn_report})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_report) {
            if (id != R.id.iv_back) {
                return;
            }
            finish();
        } else {
            Intent intent = getIntent();
            intent.putParcelableArrayListExtra(PictureConfig.EXTRA_RESULT_SELECTION, (ArrayList) this.f13395b);
            PictureSelector.putIntentResult(this.f13395b);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_app_selected;
    }

    private void b() {
        this.f13396c = new adapter.f(this.mActivity, this.f13397d, this.f13398e);
        this.mExpandableList.setAdapter(this.f13396c);
        for (int i2 = 0; i2 < this.f13397d.size(); i2++) {
            this.mExpandableList.expandGroup(i2);
        }
        this.mExpandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() { // from class: ui.activity.t
            @Override // android.widget.ExpandableListView.OnGroupClickListener
            public final boolean onGroupClick(ExpandableListView expandableListView, View view, int i3, long j2) {
                return H5AppSelectedActivity.a(expandableListView, view, i3, j2);
            }
        });
        this.mExpandableList.setOnChildClickListener(new a());
    }

    public /* synthetic */ void a(x1 x1Var) {
        final List<AppInfoBean> listA = x1.a(new String[]{x1.f15111d}, true);
        final List<AppInfoBean> listA2 = x1Var.a();
        runOnUiThread(new Runnable() { // from class: ui.activity.v
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
        this.f13397d.add("\u672a\u5b89\u88c5\u5b89\u88c5\u5305");
        this.f13397d.add("\u5df2\u5b89\u88c5\u5e94\u7528");
        this.f13398e.add(list);
        this.f13398e.add(list2);
        this.f13399f.addAll(list);
        this.f13399f.addAll(list2);
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
            } else if (this.f13395b.size() == this.a) {
                e2.a("\u6700\u591a\u9009\u62e9" + this.a + "\u4e2a");
                return;
            }
            this.f13395b.add(appInfoBean);
            appInfoBean.setSelect(true);
        } else {
            this.f13395b.remove(appInfoBean);
            appInfoBean.setSelect(false);
        }
        fVar.notifyDataSetChanged();
    }

    private void a() {
        for (int i2 = 0; i2 < this.f13398e.size(); i2++) {
            List<AppInfoBean> list = this.f13398e.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                list.get(i3).setSelect(false);
            }
        }
        this.f13396c.a(this.f13397d, this.f13398e);
        this.f13395b.clear();
    }
}
