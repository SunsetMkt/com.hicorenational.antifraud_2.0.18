package p388ui.activity;

import adapter.PayStopSelAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.AccountListBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.C2113R;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.C6049c;
import p388ui.Hicore;
import util.C7292k1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class PayStopSelectActivity extends BaseActivity implements BaseQuickAdapter.InterfaceC1895i {

    /* renamed from: a */
    private PayStopSelAdapter f22644a;

    /* renamed from: b */
    private List<AccountListBean> f22645b = new ArrayList();

    @BindView(C2113R.id.btn_commit)
    Button mBtnCommit;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    /* renamed from: a */
    private List<AccountListBean> m25301a() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f22645b.size(); i2++) {
            AccountListBean accountListBean = this.f22645b.get(i2);
            if (accountListBean.isSelect()) {
                arrayList.add(accountListBean);
            }
        }
        return arrayList;
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("选择止付账户");
        this.f22645b = (List) getIntent().getSerializableExtra(C7292k1.f25391c);
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f22644a = new PayStopSelAdapter(C2113R.layout.item_paystop_sel, this.f22645b);
        this.f22644a.m5103a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.f22644a);
        this.f22644a.setOnItemChildClickListener(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        if (view.getId() != C2113R.id.iv_select) {
            return;
        }
        AccountListBean accountListBean = this.f22645b.get(i2);
        ImageView imageView = (ImageView) view;
        if (accountListBean.isSelect()) {
            imageView.setImageResource(C2113R.mipmap.checkbox_unchecked_circle);
            accountListBean.setSelect(false);
        } else {
            imageView.setImageResource(C2113R.mipmap.checkbox_checked_circle);
            accountListBean.setSelect(true);
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.btn_commit})
    public void onViewClicked(View view) {
        if (Hicore.getApp().isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != C2113R.id.btn_commit) {
            if (id != C2113R.id.iv_back) {
                return;
            }
            onBackPressed();
        } else {
            C6049c.m24987f().m25000d(new C7265a(301, m25301a()));
            C6049c.m24987f().m25000d(new C7265a(302, this.f22645b));
            finish();
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_paystop_sel_list;
    }
}
