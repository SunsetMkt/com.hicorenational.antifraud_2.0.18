package adapter;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import bean.AccountListBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import java.util.List;
import p245d.C4443d;

/* loaded from: classes.dex */
public class PayStopSelAdapter extends BaseQuickAdapter<AccountListBean, BaseViewHolder> {
    public PayStopSelAdapter(int i2, List<AccountListBean> list) {
        super(i2, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, AccountListBean accountListBean) {
        ImageView imageView = (ImageView) baseViewHolder.m5224c(C2113R.id.iv_select);
        TextView textView = (TextView) baseViewHolder.m5224c(C2113R.id.tv_suspect_type);
        TextView textView2 = (TextView) baseViewHolder.m5224c(C2113R.id.tv_suspect_account);
        baseViewHolder.m5211a(C2113R.id.tv_suspect_name, (CharSequence) accountListBean.getSuspectName());
        baseViewHolder.m5211a(C2113R.id.tv_time, (CharSequence) accountListBean.getPaymentTime());
        baseViewHolder.m5211a(C2113R.id.tv_transfer_money, (CharSequence) (accountListBean.getTransferAmount() + ""));
        baseViewHolder.m5194a(C2113R.id.iv_select);
        if (accountListBean.isSelect()) {
            imageView.setImageResource(C2113R.mipmap.checkbox_checked_circle);
        } else {
            imageView.setImageResource(C2113R.mipmap.checkbox_unchecked_circle);
        }
        if (TextUtils.isEmpty(accountListBean.getSuspectAccountTypeText())) {
            textView.setText(C4443d.f16920D);
        } else {
            textView.setText(accountListBean.getSuspectAccountTypeText());
        }
        if (TextUtils.isEmpty(accountListBean.getSuspectAccount())) {
            textView2.setText(C4443d.f16920D);
        } else {
            textView2.setText(accountListBean.getSuspectAccount());
        }
    }
}
