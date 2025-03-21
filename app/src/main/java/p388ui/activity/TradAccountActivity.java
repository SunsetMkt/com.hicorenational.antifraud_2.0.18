package p388ui.activity;

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
import com.hicorenational.antifraud.C2113R;
import java.util.ArrayList;
import java.util.List;
import network.http.ReportNumHttp;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import util.C7292k1;
import util.C7331w1;
import util.C7337y1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class TradAccountActivity extends BaseActivity implements BaseQuickAdapter.InterfaceC1895i {

    /* renamed from: c */
    public static boolean f23279c = false;

    /* renamed from: a */
    private SocialAccAdapter f23280a;

    /* renamed from: b */
    private List<SocialAccBean> f23281b = new ArrayList();

    @BindView(C2113R.id.btn_commit)
    Button mBtnCommit;

    @BindView(C2113R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(C2113R.id.tv_commit_tip)
    TextView mTvCommit;

    @BindView(C2113R.id.tv_select_tip)
    TextView mTvSelectTip;

    @BindView(C2113R.id.tv_title)
    TextView mTvTitle;

    /* renamed from: ui.activity.TradAccountActivity$a */
    class C6625a implements ReportNumHttp.Callback {
        C6625a() {
        }

        @Override // network.http.ReportNumHttp.Callback
        public void onNumSuccess() {
            C7337y1.m26748a((Context) TradAccountActivity.this.mActivity, (Class<?>) ReportNewActivity.class);
        }
    }

    /* renamed from: a */
    private boolean m25383a(SocialAccBean socialAccBean) {
        if (this.f23281b == null) {
            this.f23281b = new ArrayList();
            this.f23281b.add(socialAccBean);
        }
        for (int i2 = 0; i2 < this.f23281b.size(); i2++) {
            SocialAccBean socialAccBean2 = this.f23281b.get(i2);
            if (TextUtils.equals(socialAccBean2.getAccountName(), socialAccBean.getAccountName()) && TextUtils.equals(socialAccBean2.getAccountNum(), socialAccBean.getAccountNum())) {
                return true;
            }
        }
        return false;
    }

    private void forceActivity(int i2) {
        Intent intent = new Intent(this.mActivity, (Class<?>) TradAccountEditActivity.class);
        if (i2 != -1) {
            intent.putExtra(C7292k1.f25438v, i2);
            intent.putExtra(C7292k1.f25440w, this.f23281b.get(i2));
        }
        startActivity(intent);
    }

    private void getIntentData() {
        List list = (List) getIntent().getSerializableExtra(C7292k1.f25430r);
        if (list != null) {
            this.f23281b.addAll(list);
            this.f23280a.notifyDataSetChanged();
        }
    }

    private void sendData() {
        C6049c.m24987f().m25000d(new C7265a(19, this.f23281b));
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C6049c.m24987f().m25001e(this);
        this.mTvTitle.setText("添加诈骗交易账户");
        this.mTvSelectTip.setText("添加");
        this.mTvCommit.setText("提示：最多可上传20条交易账户");
        this.mBtnCommit.setText("确定");
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f23280a = new SocialAccAdapter(C2113R.layout.item_social_acc, this.f23281b);
        this.f23280a.m5103a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.f23280a);
        this.f23280a.setOnItemChildClickListener(this);
        getIntentData();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        f23279c = false;
        finish();
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEventMainThread(C7265a c7265a) {
        if (c7265a != null) {
            int m26297a = c7265a.m26297a();
            if (m26297a == 17) {
                C6049c.m24987f().m25002f(c7265a);
                SocialAccBean socialAccBean = (SocialAccBean) c7265a.m26300b();
                if (m25383a(socialAccBean)) {
                    return;
                }
                this.f23281b.add(socialAccBean);
                this.f23280a.notifyDataSetChanged();
                return;
            }
            if (m26297a != 18) {
                return;
            }
            C6049c.m24987f().m25002f(c7265a);
            SocialAccBean socialAccBean2 = (SocialAccBean) c7265a.m26300b();
            SocialAccBean socialAccBean3 = this.f23281b.get(((Integer) c7265a.m26304d()).intValue());
            socialAccBean3.setAccountNum(socialAccBean2.getAccountNum());
            socialAccBean3.setAccountName(socialAccBean2.getAccountName());
            this.f23280a.notifyDataSetChanged();
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        int id = view.getId();
        if (id == C2113R.id.iv_delete) {
            this.f23281b.remove(i2);
            baseQuickAdapter.notifyDataSetChanged();
        } else {
            if (id != C2113R.id.iv_edit) {
                return;
            }
            forceActivity(i2);
        }
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.ll_select, C2113R.id.btn_commit})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == C2113R.id.btn_commit) {
            if (f23279c) {
                ReportNumHttp.getInstance().principalHttp(new C6625a());
            }
            sendData();
            finish();
            return;
        }
        if (id == C2113R.id.iv_back) {
            sendData();
            onBackPressed();
        } else {
            if (id != C2113R.id.ll_select) {
                return;
            }
            if (this.f23281b.size() >= 20) {
                C7331w1.m26688a("最多可上传20条交易账户");
            } else {
                forceActivity(-1);
            }
        }
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_social_account;
    }
}
