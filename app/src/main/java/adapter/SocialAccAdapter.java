package adapter;

import android.text.TextUtils;
import bean.SocialAccBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import java.util.List;

/* loaded from: classes.dex */
public class SocialAccAdapter extends BaseQuickAdapter<SocialAccBean, BaseViewHolder> {

    /* renamed from: V */
    private List<SocialAccBean> f334V;

    /* renamed from: W */
    private boolean f335W;

    public SocialAccAdapter(int i2, List<SocialAccBean> list) {
        super(i2, list);
        this.f334V = list;
        this.f335W = false;
    }

    /* renamed from: k */
    public void m290k(boolean z) {
        this.f335W = z;
    }

    /* renamed from: m */
    public void m291m(int i2) {
        this.f334V.remove(i2);
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void m289a(List<SocialAccBean> list) {
        this.f334V.clear();
        this.f334V.addAll(list);
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void m288a(int i2, SocialAccBean socialAccBean) {
        this.f334V.set(i2, socialAccBean);
        notifyItemChanged(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, SocialAccBean socialAccBean) {
        String accountName = socialAccBean.getAccountName();
        String accountNum = socialAccBean.getAccountNum();
        String accountOtherName = socialAccBean.getAccountOtherName();
        if (TextUtils.isEmpty(accountOtherName)) {
            accountOtherName = accountName;
        }
        baseViewHolder.m5211a(C2113R.id.tv_name, (CharSequence) accountOtherName);
        baseViewHolder.m5211a(C2113R.id.tv_acc_num, (CharSequence) accountNum);
        baseViewHolder.m5194a(C2113R.id.iv_edit);
        baseViewHolder.m5194a(C2113R.id.iv_delete);
        baseViewHolder.m5194a(C2113R.id.cl_item);
        if (this.f335W) {
            baseViewHolder.m5224c(C2113R.id.iv_edit).setVisibility(8);
            baseViewHolder.m5224c(C2113R.id.iv_delete).setVisibility(8);
            baseViewHolder.m5224c(C2113R.id.iv_arrow).setVisibility(0);
        }
    }
}
