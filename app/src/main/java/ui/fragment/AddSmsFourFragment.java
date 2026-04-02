package ui.fragment;

import adapter.SmsPictureAdapter;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bean.BrandBean;
import bean.CriminalSmsBean;
import bean.SmsPictureBean;
import butterknife.BindView;
import butterknife.OnClick;
import c.a.a.e.i;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hicorenational.antifraud.R;
import com.luck.picture.lib.entity.LocalMedia;
import java.util.ArrayList;
import java.util.List;
import ui.activity.CriminalSmsAddActivity;
import util.e2;
import util.y1;

/* JADX INFO: loaded from: classes2.dex */
public class AddSmsFourFragment extends BaseFragment {

    /* JADX INFO: renamed from: b */
    private CriminalSmsAddActivity f14146b;

    /* JADX INFO: renamed from: c */
    private SmsPictureAdapter f14147c;

    @BindView(R.id.confirm)
    TextView mBtnCommit;

    @BindView(R.id.et_brand_other)
    EditText mEtBrandOther;

    @BindView(R.id.et_describe)
    EditText mEtDescribe;

    @BindView(R.id.tv_victim_phone)
    EditText mEtVictimPhone;

    @BindView(R.id.gp_brand_other)
    Group mGpBrandOther;

    @BindView(R.id.ll_picture)
    LinearLayout mLlPicture;

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerview;

    @BindView(R.id.tv_brand)
    TextView mTvBrand;

    @BindView(R.id.tv_time)
    TextView mTvTime;

    @BindView(R.id.tv_tip_picture)
    TextView mTvTipPicture;
    private CriminalSmsBean a = null;

    /* JADX INFO: renamed from: d */
    private List<LocalMedia> f14148d = new ArrayList();

    class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getParent().requestDisallowInterceptTouchEvent(false);
            int action = motionEvent.getAction() & 255;
            if (action == 1) {
                AddSmsFourFragment.this.mEtDescribe.setFocusable(true);
                AddSmsFourFragment.this.mEtDescribe.setFocusableInTouchMode(true);
            } else if (action == 2) {
                AddSmsFourFragment.this.mEtDescribe.setFocusable(false);
            }
            return false;
        }
    }

    class b implements i.b<BrandBean> {
        b() {
        }

        @Override // c.a.a.e.i.b
        public void a(int i2, BrandBean brandBean) {
            AddSmsFourFragment.this.a.setOsBrandType(brandBean.getOsBrandType());
            AddSmsFourFragment.this.a.setOsBrandTypeText(brandBean.getOsBrandTypeText());
            AddSmsFourFragment.this.mTvBrand.setText(brandBean.getOsBrandTypeText());
            if (brandBean.getEx() == 1) {
                AddSmsFourFragment.this.mGpBrandOther.setVisibility(0);
            } else {
                AddSmsFourFragment.this.mGpBrandOther.setVisibility(8);
            }
        }
    }

    class c implements SmsPictureAdapter.b {
        c() {
        }

        @Override // adapter.SmsPictureAdapter.b
        public void onItemClickListener(int i2, List<LocalMedia> list) {
            AddSmsFourFragment.this.f14146b.onItemClickListener(i2, list);
        }
    }

    class d implements BaseQuickAdapter.i {
        d() {
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter.i
        public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
            AddSmsFourFragment.this.f14146b.onItemChildClick(baseQuickAdapter, view, i2);
        }
    }

    private void h() {
        this.mRecyclerview.setLayoutManager(new GridLayoutManager(this.mActivity, 3));
        List<LocalMedia> list = this.f14148d;
        this.f14146b.getClass();
        this.f14147c = new SmsPictureAdapter(R.layout.recyclerview_feedback, list, 6, this.f14146b.isOnlyShow());
        this.f14147c.a(this.mRecyclerview);
        this.f14147c.setOnItemClickListener(new c());
        this.f14147c.setOnItemChildClickListener(new d());
        this.mRecyclerview.setAdapter(this.f14147c);
    }

    private void i() {
        this.mTvBrand.setEnabled(false);
        this.mEtDescribe.setEnabled(false);
        this.mEtVictimPhone.setEnabled(false);
        this.mEtBrandOther.setEnabled(false);
        this.mTvTime.setCompoundDrawables(null, null, null, null);
        this.mTvTime.setEnabled(false);
        if (this.f14148d.size() <= 0) {
            this.mLlPicture.setVisibility(8);
        }
        this.mBtnCommit.setVisibility(8);
    }

    public CriminalSmsBean d() {
        return this.a;
    }

    public List<LocalMedia> e() {
        return this.f14148d;
    }

    public void f() {
        this.f14147c.notifyDataSetChanged();
    }

    public void g() {
        String string = this.mEtDescribe.getText().toString();
        if (this.mEtVictimPhone.length() == 0) {
            e2.a("\u8bf7\u8f93\u5165\u63a5\u6536\u77ed\u4fe1\u53f7\u7801");
            return;
        }
        if (this.mTvBrand.length() == 0) {
            e2.a("\u8bf7\u9009\u62e9\u63a5\u6536\u77ed\u4fe1\u624b\u673a\u54c1\u724c");
            return;
        }
        if (this.mGpBrandOther.getVisibility() == 0 && this.mEtBrandOther.length() == 0) {
            e2.a("\u8bf7\u8f93\u5165\u624b\u673a\u54c1\u724c\u540d\u79f0");
            return;
        }
        if (this.mTvTime.length() == 0) {
            e2.a("\u8bf7\u9009\u62e9\u6d89\u8bc8\u77ed\u4fe1\u63a5\u6536\u65f6\u95f4");
            return;
        }
        if (TextUtils.isEmpty(string)) {
            e2.a("\u8bf7\u8f93\u5165\u6d89\u8bc8\u77ed\u4fe1\u5185\u5bb9");
            return;
        }
        if (this.a == null) {
            this.a = new CriminalSmsBean();
        }
        if (this.mGpBrandOther.getVisibility() == 0) {
            this.a.setOsBrandTypeText(this.mEtBrandOther.getText().toString());
        }
        this.a.setVictimMobile(this.mEtVictimPhone.getText().toString());
        this.a.setDeliveryTime(this.mTvTime.getText().toString());
        this.a.setContent(string);
        this.a.setVictimMobile(this.mEtVictimPhone.getText().toString());
        this.a.setDeliveryTime(this.mTvTime.getText().toString());
        this.f14146b.confirm(this.a);
    }

    @Override // ui.fragment.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_sms_ip;
    }

    @Override // ui.fragment.BaseFragment
    public void initPage() {
        this.f14146b = (CriminalSmsAddActivity) this.mActivity;
        this.mEtDescribe.setOnTouchListener(new a());
        try {
            CriminalSmsBean criminalSmsBean = ((CriminalSmsAddActivity) this.mActivity).getCriminalSmsBean();
            if (criminalSmsBean.getSmsType() == 4) {
                this.a = criminalSmsBean;
            }
            if (this.a != null) {
                String victimMobile = this.a.getVictimMobile();
                String deliveryTime = this.a.getDeliveryTime();
                this.a.getOsBrandTypeText();
                String content = this.a.getContent();
                if (!TextUtils.isEmpty(victimMobile)) {
                    this.mEtVictimPhone.setText(victimMobile);
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
                        this.f14148d.add(localMedia);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.a == null) {
            this.a = new CriminalSmsBean();
            this.a.setSmsType(4);
            this.a.setSmsTypeText(this.f14146b.strs[3]);
        }
        this.f14146b.setChildBean(this.a);
        h();
        this.mGpBrandOther.setVisibility(8);
        if (this.f14146b.isOnlyShow()) {
            i();
        }
    }

    @OnClick({R.id.tv_time, R.id.tv_brand, R.id.confirm})
    public void onViewClicked(View view) {
        if (isDouble()) {
            return;
        }
        int id = view.getId();
        if (id == R.id.confirm) {
            g();
        } else if (id == R.id.tv_brand) {
            this.f14146b.brandPick(new b());
        } else {
            if (id != R.id.tv_time) {
                return;
            }
            y1.a(this.mActivity, this.mTvTime);
        }
    }

    public void a(List<BrandBean> list) {
        CriminalSmsBean criminalSmsBean = this.a;
        if (criminalSmsBean == null || TextUtils.isEmpty(criminalSmsBean.getOsBrandType())) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            BrandBean brandBean = list.get(i2);
            if (TextUtils.equals(this.a.getOsBrandType(), brandBean.getOsBrandType())) {
                this.mTvBrand.setText(brandBean.getOsBrandTypeText());
                if (brandBean.getEx() == 1) {
                    this.mEtBrandOther.setText(this.a.getOsBrandTypeText());
                    this.mGpBrandOther.setVisibility(0);
                    return;
                }
                return;
            }
        }
    }
}
