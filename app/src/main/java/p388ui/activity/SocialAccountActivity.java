package p388ui.activity;

import adapter.SocialAccAdapter;
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
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import util.C7292k1;
import util.C7331w1;
import util.p395c2.C7265a;

/* loaded from: classes2.dex */
public class SocialAccountActivity extends BaseActivity implements BaseQuickAdapter.InterfaceC1895i {

    /* renamed from: a */
    private SocialAccAdapter f23226a;

    /* renamed from: b */
    private List<SocialAccBean> f23227b = new ArrayList();

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

    /* renamed from: a */
    private boolean m25380a(SocialAccBean socialAccBean) {
        if (this.f23227b == null) {
            this.f23227b = new ArrayList();
            this.f23227b.add(socialAccBean);
        }
        for (int i2 = 0; i2 < this.f23227b.size(); i2++) {
            SocialAccBean socialAccBean2 = this.f23227b.get(i2);
            if (TextUtils.equals(socialAccBean2.getAccountName(), socialAccBean.getAccountName()) && TextUtils.equals(socialAccBean2.getAccountNum(), socialAccBean.getAccountName())) {
                return true;
            }
        }
        return false;
    }

    private void forceActivity(int i2) {
        Intent intent = new Intent(this.mActivity, (Class<?>) SocialAccountEditActivity.class);
        if (i2 != -1) {
            intent.putExtra(C7292k1.f25438v, i2);
            intent.putExtra(C7292k1.f25440w, this.f23227b.get(i2));
        }
        startActivity(intent);
    }

    private void getIntentData() {
        List list = (List) getIntent().getSerializableExtra(C7292k1.f25424o);
        if (list != null) {
            this.f23227b.addAll(list);
            this.f23226a.notifyDataSetChanged();
        }
    }

    private void sendData() {
        C6049c.m24987f().m25000d(new C7265a(16, this.f23227b));
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C6049c.m24987f().m25001e(this);
        this.mTvTitle.setText("添加诈骗社交账号");
        this.mTvSelectTip.setText("添加");
        this.mTvCommit.setText("提示：最多可上传20条社交账号");
        this.mBtnCommit.setText("确定");
        this.mRecyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f23226a = new SocialAccAdapter(C2113R.layout.item_social_acc, this.f23227b);
        this.f23226a.m5103a(this.mRecyclerview);
        this.mRecyclerview.setAdapter(this.f23226a);
        this.f23226a.setOnItemChildClickListener(this);
        getIntentData();
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
            if (m26297a == 14) {
                SocialAccBean socialAccBean = (SocialAccBean) c7265a.m26300b();
                if (m25380a(socialAccBean)) {
                    return;
                }
                this.f23227b.add(socialAccBean);
                this.f23226a.notifyDataSetChanged();
                return;
            }
            if (m26297a != 15) {
                return;
            }
            SocialAccBean socialAccBean2 = (SocialAccBean) c7265a.m26300b();
            SocialAccBean socialAccBean3 = this.f23227b.get(((Integer) c7265a.m26304d()).intValue());
            socialAccBean3.setAccountNum(socialAccBean2.getAccountNum());
            socialAccBean3.setAccountName(socialAccBean2.getAccountName());
            this.f23226a.notifyDataSetChanged();
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter.InterfaceC1895i
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
        int id = view.getId();
        if (id == C2113R.id.iv_delete) {
            this.f23227b.remove(i2);
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
            sendData();
            finish();
        } else if (id == C2113R.id.iv_back) {
            sendData();
            finish();
        } else {
            if (id != C2113R.id.ll_select) {
                return;
            }
            if (this.f23227b.size() >= 20) {
                C7331w1.m26688a("最多可上传20条社交账号");
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
