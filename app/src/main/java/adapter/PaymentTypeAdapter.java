package adapter;

import bean.CaseDivisonBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hicorenational.antifraud.C2113R;
import java.util.List;

/* loaded from: classes.dex */
public class PaymentTypeAdapter extends BaseQuickAdapter<CaseDivisonBean, BaseViewHolder> {
    public PaymentTypeAdapter(List<CaseDivisonBean> list) {
        super(C2113R.layout.item_payment_type, list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo204a(BaseViewHolder baseViewHolder, CaseDivisonBean caseDivisonBean) {
        baseViewHolder.m5211a(C2113R.id.tv_txet, (CharSequence) caseDivisonBean.getName()).m5194a(C2113R.id.tv_txet);
    }
}
