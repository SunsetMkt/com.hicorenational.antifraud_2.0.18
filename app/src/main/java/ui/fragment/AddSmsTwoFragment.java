package ui.fragment;

import adapter.SmsPictureAdapter;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.CriminalSmsBean;
import bean.SmsPictureBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import interfaces.IClickListener;
import java.util.ArrayList;
import java.util.List;
import manager.AccountManager;
import ui.activity.CriminalSmsAddActivity;
import util.e2;
import util.f1;
import util.y1;

/* JADX INFO: loaded from: classes2.dex */
public class AddSmsTwoFragment extends BaseFragment {

    /* JADX INFO: renamed from: b */
    private CriminalSmsAddActivity f14169b;

    /* JADX INFO: renamed from: c */
    private SmsPictureAdapter f14170c;

    @BindView(R.id.confirm)
    TextView mBtnCommit;

    @BindView(R.id.et_describe)
    EditText mEtDescribe;

    @BindView(R.id.et_phone)
    EditText mEtPhone;

    @BindView(R.id.tv_victim_phone)
    EditText mEtVictimPhone;

    @BindView(R.id.ll_picture)
    LinearLayout mLlPicture;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_describe_label)
    TextView mTvDescribeLabel;

    @BindView(R.id.tv_time)
    TextView mTvTime;

    @BindView(R.id.tv_tip)
    TextView mTvTip;

    @BindView(R.id.tv_tip_picture)
    TextView mTvTipPicture;
    private CriminalSmsBean a = null;

    /* JADX INFO: renamed from: d */
    private List<LocalMedia> f14171d = new ArrayList();

    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getParent().requestDisallowInterceptTouchEvent(false);
            int action = motionEvent.getAction() & 255;
            if (action == 1) {
                AddSmsTwoFragment.this.mEtDescribe.setFocusable(true);
                AddSmsTwoFragment.this.mEtDescribe.setFocusableInTouchMode(true);
            } else if (action == 2) {
                AddSmsTwoFragment.this.mEtDescribe.setFocusable(false);
            }
            return false;
        }
    }

    class b implements SmsPictureAdapter.b {
        b() {
        }

        @Override // adapter.SmsPictureAdapter.b
        public void onItemClickListener(int i2, List<LocalMedia> list) {
            AddSmsTwoFragment.this.f14169b.onItemClickListener(i2, list);
        }
    }

    class c implements BaseQuickAdapter.i {
        c() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
        public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            AddSmsTwoFragment.this.f14169b.onItemChildClick(baseQuickAdapter, view, i2);
        }
    }

    class d implements IClickListener {
        d() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            AddSmsTwoFragment.this.f14169b.confirm(AddSmsTwoFragment.this.a);
        }
    }

    private void h() {
        this.mRecyclerview.setLayoutManager(new GridLayoutManager(this.mActivity, 3));
        List<LocalMedia> list = this.f14171d;
        this.f14169b.getClass();
        this.f14170c = new SmsPictureAdapter(R.layout.recyclerview_feedback, list, 6, this.f14169b.isOnlyShow());
        this.f14170c.a(this.mRecyclerview);
        this.f14170c.setOnItemClickListener(new b());
        this.f14170c.setOnItemChildClickListener(new c());
        this.mRecyclerview.setAdapter(this.f14170c);
    }

    private void i() {
        this.mEtPhone.setEnabled(false);
        this.mEtDescribe.setEnabled(false);
        this.mEtVictimPhone.setEnabled(false);
        this.mTvTime.setCompoundDrawables(null, null, null, null);
        this.mTvTime.setEnabled(false);
        if (TextUtils.isEmpty(this.a.getContent())) {
            this.mTvTip.setVisibility(8);
            this.mTvDescribeLabel.setVisibility(8);
            this.mEtDescribe.setVisibility(8);
        } else {
            this.mEtDescribe.setEnabled(false);
        }
        if (this.f14171d.size() <= 0) {
            this.mTvTip.setVisibility(4);
            this.mLlPicture.setVisibility(8);
        }
        this.mBtnCommit.setVisibility(8);
    }

    public void d() {
        String string = this.mEtPhone.getText().toString();
        String string2 = this.mEtDescribe.getText().toString();
        if (this.mEtVictimPhone.length() == 0) {
            e2.a("\u8bf7\u8f93\u5165\u63a5\u6536\u77ed\u4fe1\u53f7\u7801");
            return;
        }
        if (TextUtils.isEmpty(string)) {
            e2.a("\u8bf7\u8f93\u5165\u6d89\u8bc8\u77ed\u4fe1\u53f7\u7801");
            return;
        }
        if (this.mTvTime.length() == 0) {
            e2.a("\u8bf7\u9009\u62e9\u6d89\u8bc8\u77ed\u4fe1\u63a5\u6536\u65f6\u95f4");
            return;
        }
        if (TextUtils.isEmpty(string2) && this.f14171d.size() <= 0) {
            e2.a("\u6d89\u8bc8\u77ed\u4fe1\u5185\u5bb9\u53ca\u4e0a\u4f20\u5f69\u4fe1\u56fe\u7247\u81f3\u5c11\u5f55\u5165\u4e00\u9879");
            return;
        }
        if (this.a == null) {
            this.a = new CriminalSmsBean();
        }
        this.a.setVictimMobile(this.mEtVictimPhone.getText().toString());
        this.a.setSuspectMobile(string);
        this.a.setDeliveryTime(this.mTvTime.getText().toString());
        this.a.setContent(string2);
        this.a.setVictimMobile(this.mEtVictimPhone.getText().toString());
        this.a.setDeliveryTime(this.mTvTime.getText().toString());
        if (TextUtils.equals(string, AccountManager.getVisiblePhone())) {
            f1.a(this.mActivity, "\u6dfb\u52a0\u7684\u6d89\u8bc8\u77ed\u4fe1\u4e2d\u5305\u542b\u60a8\u7684\u767b\u5f55\u53f7\u7801\uff0c\u786e\u5b9a\u6dfb\u52a0\u4e2a\u4eba\u53d1\u9001\u77ed\u4fe1\u4e3a\u6d89\u8bc8\u77ed\u4fe1\uff1f", "", "\u53d6\u6d88", "\u786e\u5b9a", R.color._A8B4F7, R.color.blue, true, (IClickListener) new d());
        } else {
            this.f14169b.confirm(this.a);
        }
    }

    public CriminalSmsBean e() {
        return this.a;
    }

    public List<LocalMedia> f() {
        return this.f14171d;
    }

    public void g() {
        this.f14170c.notifyDataSetChanged();
    }

    @Override // ui.fragment.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_sms_multimedia;
    }

    @Override // ui.fragment.BaseFragment
    public void initPage() {
        this.f14169b = (CriminalSmsAddActivity) this.mActivity;
        this.mEtDescribe.setOnTouchListener(new a());
        try {
            CriminalSmsBean criminalSmsBean = ((CriminalSmsAddActivity) this.mActivity).getCriminalSmsBean();
            if (criminalSmsBean.getSmsType() == 2) {
                this.a = criminalSmsBean;
            }
            if (this.a != null) {
                String victimMobile = this.a.getVictimMobile();
                String suspectMobile = this.a.getSuspectMobile();
                String deliveryTime = this.a.getDeliveryTime();
                String content = this.a.getContent();
                if (!TextUtils.isEmpty(victimMobile)) {
                    this.mEtVictimPhone.setText(victimMobile);
                }
                if (!TextUtils.isEmpty(suspectMobile)) {
                    this.mEtPhone.setText(suspectMobile);
                }
                if (!TextUtils.isEmpty(deliveryTime)) {
                    this.mTvTime.setText(deliveryTime);
                }
                if (!TextUtils.isEmpty(content)) {
                    this.mEtDescribe.setText(content);
                }
                List<SmsPictureBean> smsDetails = this.a.getSmsDetails();
                if (smsDetails != null && smsDetails.size() > 0) {
                    for (int i2 = 0; i2 < smsDetails.size(); i2++) {
                        SmsPictureBean smsPictureBean = smsDetails.get(i2);
                        LocalMedia localMedia = new LocalMedia();
                        localMedia.setPath(smsPictureBean.getLocalPath());
                        localMedia.setCompressPath(smsPictureBean.getFilePath());
                        localMedia.setOriginalPath(smsPictureBean.getSmsDetailID());
                        this.f14171d.add(localMedia);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.a == null) {
            this.a = new CriminalSmsBean();
            this.a.setSmsType(2);
            this.a.setSmsTypeText(this.f14169b.strs[1]);
        }
        this.f14169b.setChildBean(this.a);
        h();
        if (this.f14169b.isOnlyShow()) {
            i();
        }
    }

    @OnClick({R.id.tv_time, R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.confirm) {
            d();
        } else {
            if (id != R.id.tv_time) {
                return;
            }
            y1.a(this.mActivity, this.mTvTime);
        }
    }
}
