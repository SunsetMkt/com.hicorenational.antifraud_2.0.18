package ui.activity;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bean.SocialAccBean;
import bean.SocialTypeBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.hicorenational.antifraud.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.util.ArrayList;
import java.util.List;
import ui.callview.SocialTagsCallView;
import ui.presenter.TradAccEditPresenter;
import util.e2;

/* JADX INFO: loaded from: classes2.dex */
public class TradAccountEditActivity extends BaseActivity implements SocialTagsCallView {
    private static final String FINATYPE = "\u5176\u4ed6\u7c7b\u578b";

    /* JADX INFO: renamed from: bean, reason: collision with root package name */
    private SocialAccBean f13918bean;

    @BindView(R.id.et_account)
    TextView mEtAccount;

    @BindView(R.id.et_account_other)
    TextView mEtAccountOther;

    @BindView(R.id.et_tag_other)
    TextView mEtTagOther;

    @BindView(R.id.flow_layout)
    TagFlowLayout mFlowLayout;

    @BindView(R.id.ll_acc_nomar)
    View mLlAccNorm;

    @BindView(R.id.ll_acc_other)
    View mLlAccOther;
    private TradAccEditPresenter mPresenter;

    @BindView(R.id.tv_acc_name)
    TextView mTvAccName;

    @BindView(R.id.tv_title)
    TextView mTvTitle;
    private int pos;
    private int selectIndex;
    private com.zhy.view.flowlayout.b mTagAdapter = null;
    private List<SocialTypeBean> socialTypeBeans = new ArrayList();
    private SocialTypeBean otherType = new SocialTypeBean(FINATYPE);

    class a extends com.zhy.view.flowlayout.b<SocialTypeBean> {
        a(List list) {
            super(list);
        }

        @Override // com.zhy.view.flowlayout.b
        public View a(FlowLayout flowLayout, int i2, SocialTypeBean socialTypeBean) {
            TextView textView = (TextView) LayoutInflater.from(TradAccountEditActivity.this.mActivity).inflate(R.layout.tag_flow_trad, (ViewGroup) TradAccountEditActivity.this.mFlowLayout, false);
            textView.setText(((SocialTypeBean) TradAccountEditActivity.this.socialTypeBeans.get(i2)).getText());
            textView.setTextColor(TradAccountEditActivity.this.getResources().getColorStateList(R.color.text_choose_one));
            return textView;
        }
    }

    private int contains(List<SocialTypeBean> list, String str) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (TextUtils.equals(list.get(i2).getText(), str)) {
                return i2;
            }
        }
        return -10;
    }

    private void getIntentData() {
        this.pos = getIntent().getIntExtra(util.p1.v, 0);
        this.f13918bean = (SocialAccBean) getIntent().getSerializableExtra(util.p1.w);
    }

    public /* synthetic */ boolean a(View view, int i2, FlowLayout flowLayout) {
        if (TextUtils.equals(FINATYPE, this.socialTypeBeans.get(i2).getText())) {
            this.mLlAccOther.setVisibility(0);
            this.mLlAccNorm.setVisibility(8);
        } else {
            this.mLlAccOther.setVisibility(8);
            this.mLlAccNorm.setVisibility(0);
        }
        this.selectIndex = i2;
        this.mTvAccName.setText(this.socialTypeBeans.get(i2).getText() + "\u8d26\u6237");
        return true;
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        this.mTvTitle.setText("\u6dfb\u52a0\u8bc8\u9a97\u4ea4\u6613\u8d26\u6237");
        this.mPresenter = new TradAccEditPresenter(this.mActivity, this);
        getIntentData();
        initTagAdapter();
        this.mPresenter.getSocialTags();
    }

    protected void initTagAdapter() {
        this.mTagAdapter = new a(this.socialTypeBeans);
        this.mFlowLayout.setAdapter(this.mTagAdapter);
        this.mFlowLayout.setOnTagClickListener(new TagFlowLayout.c() { // from class: ui.activity.i1
            @Override // com.zhy.view.flowlayout.TagFlowLayout.c
            public final boolean a(View view, int i2, FlowLayout flowLayout) {
                return this.a.a(view, i2, flowLayout);
            }
        });
    }

    @Override // ui.callview.SocialTagsCallView
    public void onErrorRequest() {
    }

    @Override // ui.callview.SocialTagsCallView
    public void onSuccessRequest(List<SocialTypeBean> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.socialTypeBeans.clear();
        list.add(this.otherType);
        this.socialTypeBeans.addAll(list);
        this.mTagAdapter.c();
        SocialAccBean socialAccBean = this.f13918bean;
        if (socialAccBean == null) {
            this.selectIndex = 0;
            this.mTagAdapter.a(0);
            this.mTvAccName.setText(list.get(0).getText() + "\u8d26\u6237");
            return;
        }
        int iContains = contains(list, socialAccBean.getAccountName());
        if (iContains >= 0) {
            this.selectIndex = iContains;
            this.mTvAccName.setText(this.f13918bean.getAccountName());
            this.mEtAccount.setText(this.f13918bean.getAccountNum());
            this.mTagAdapter.a(this.selectIndex);
            return;
        }
        this.selectIndex = list.size() - 1;
        this.mLlAccOther.setVisibility(0);
        this.mLlAccNorm.setVisibility(8);
        this.mEtTagOther.setText(this.f13918bean.getAccountName());
        this.mEtAccountOther.setText(this.f13918bean.getAccountNum());
        this.mTagAdapter.a(this.selectIndex);
    }

    @OnClick({R.id.iv_back, R.id.btn_commit})
    public void onViewClicked(View view) {
        String text;
        String string;
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id != R.id.btn_commit) {
            if (id != R.id.iv_back) {
                return;
            }
            finish();
            return;
        }
        if (this.socialTypeBeans.size() > 0) {
            if (TextUtils.equals(FINATYPE, this.socialTypeBeans.get(this.selectIndex).getText())) {
                text = this.mEtTagOther.getText().toString();
                if (TextUtils.isEmpty(text)) {
                    e2.a("\u4ea4\u6613\u7c7b\u578b\u4e0d\u80fd\u4e3a\u7a7a");
                    return;
                }
                string = this.mEtAccountOther.getText().toString();
                if (TextUtils.isEmpty(string)) {
                    e2.a("\u4ea4\u6613\u8d26\u6237\u4e0d\u80fd\u4e3a\u7a7a");
                    return;
                }
            } else {
                text = this.socialTypeBeans.get(this.selectIndex).getText();
                string = this.mEtAccount.getText().toString();
                if (TextUtils.isEmpty(string)) {
                    e2.a("\u4ea4\u6613\u8d26\u6237\u4e0d\u80fd\u4e3a\u7a7a");
                    return;
                }
            }
            SocialAccBean socialAccBean = new SocialAccBean();
            socialAccBean.setAccountName(text);
            socialAccBean.setAccountNum(string);
            if (this.f13918bean != null) {
                org.greenrobot.eventbus.c.f().d(new util.n2.a(18, socialAccBean, Integer.valueOf(this.pos)));
            } else {
                org.greenrobot.eventbus.c.f().d(new util.n2.a(17, socialAccBean));
            }
            finish();
        }
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_trad_acc_edit;
    }
}
