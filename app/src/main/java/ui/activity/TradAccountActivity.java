package ui.activity;

import adapter.SocialAccAdapter;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.SocialAccBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import java.util.ArrayList;
import java.util.List;
import network.http.ReportNumHttp;
import org.greenrobot.eventbus.ThreadMode;
import util.e2;
import util.g2;

/* JADX INFO: loaded from: classes2.dex */
public class TradAccountActivity extends BaseActivity implements BaseQuickAdapter.i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f13910c = false;
    private SocialAccAdapter a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<SocialAccBean> f13911b = new ArrayList();

    @BindView(R.id.btn_commit)
    Button mBtnCommit;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_commit_tip)
    TextView mTvCommit;

    @BindView(R.id.tv_select_tip)
    TextView mTvSelectTip;

    @BindView(R.id.tv_title)
    TextView mTvTitle;

    class a implements ReportNumHttp.Callback {
        a() {
        }

        @Override // network.http.ReportNumHttp.Callback
        public void onNumSuccess() {
            g2.a((Context) TradAccountActivity.this.mActivity, (Class<?>) ReportNewActivity.class);
        }
    }

    private boolean a(SocialAccBean socialAccBean) {
        if (this.f13911b == null) {
            this.f13911b = new ArrayList();
            this.f13911b.add(socialAccBean);
        }
        for (int i2 = 0; i2 < this.f13911b.size(); i2++) {
            SocialAccBean socialAccBean2 = this.f13911b.get(i2);
            if (TextUtils.equals(socialAccBean2.getAccountName(), socialAccBean.getAccountName()) && TextUtils.equals(socialAccBean2.getAccountNum(), socialAccBean.getAccountNum())) {
                return true;
            }
        }
        return false;
    }

    private void forceActivity(int i2) {
        Intent intent = new Intent(this.mActivity, (Class<?>) TradAccountEditActivity.class);
        if (i2 != -1) {
            intent.putExtra(util.p1.v, i2);
            intent.putExtra(util.p1.w, this.f13911b.get(i2));
        }
        startActivity(intent);
    }

    private void getIntentData() {
        List list = (List) getIntent().getSerializableExtra(util.p1.r);
        if (list != null) {
            this.f13911b.addAll(list);
            this.a.notifyDataSetChanged();
        }
    }

    private void sendData() {
        org.greenrobot.eventbus.c.f().d(new util.n2.a(19, this.f13911b));
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        this.mTvTitle.setText("\u6dfb\u52a0\u8bc8\u9a97\u4ea4\u6613\u8d26\u6237");
        this.mTvSelectTip.setText("\u6dfb\u52a0");
        this.mTvCommit.setText("\u63d0\u793a\uff1a\u6700\u591a\u53ef\u4e0a\u4f2020\u6761\u4ea4\u6613\u8d26\u6237");
        this.mBtnCommit.setText("\u786e\u5b9a");
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.a = new SocialAccAdapter(R.layout.item_social_acc, this.f13911b);
        this.a.a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.a);
        this.a.setOnItemChildClickListener(this);
        getIntentData();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        f13910c = false;
        finish();
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventMainThread(util.n2.a aVar) {
        if (aVar != null) {
            int iA = aVar.a();
            if (iA == 17) {
                org.greenrobot.eventbus.c.f().f(aVar);
                SocialAccBean socialAccBean = (SocialAccBean) aVar.b();
                if (a(socialAccBean)) {
                    return;
                }
                this.f13911b.add(socialAccBean);
                this.a.notifyDataSetChanged();
                return;
            }
            if (iA != 18) {
                return;
            }
            org.greenrobot.eventbus.c.f().f(aVar);
            SocialAccBean socialAccBean2 = (SocialAccBean) aVar.b();
            SocialAccBean socialAccBean3 = this.f13911b.get(((Integer) aVar.d()).intValue());
            socialAccBean3.setAccountNum(socialAccBean2.getAccountNum());
            socialAccBean3.setAccountName(socialAccBean2.getAccountName());
            this.a.notifyDataSetChanged();
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        int id = view.getId();
        if (id == R.id.iv_delete) {
            this.f13911b.remove(i2);
            baseQuickAdapter.notifyDataSetChanged();
        } else {
            if (id != R.id.iv_edit) {
                return;
            }
            forceActivity(i2);
        }
    }

    @OnClick({R.id.iv_back, R.id.ll_select, R.id.btn_commit})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.btn_commit) {
            if (f13910c) {
                ReportNumHttp.getInstance().principalHttp(new a());
            }
            sendData();
            finish();
            return;
        }
        if (id == R.id.iv_back) {
            sendData();
            onBackPressed();
        } else {
            if (id != R.id.ll_select) {
                return;
            }
            if (this.f13911b.size() >= 20) {
                e2.a("\u6700\u591a\u53ef\u4e0a\u4f2020\u6761\u4ea4\u6613\u8d26\u6237");
            } else {
                forceActivity(-1);
            }
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_social_account;
    }
}
