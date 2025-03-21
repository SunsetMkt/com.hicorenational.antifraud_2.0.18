package p388ui.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import bean.AccountListBean;
import bean.CaseDetailBean;
import bean.ReplyBean;
import bean.module.RegionMudelBean;
import butterknife.BindView;
import butterknife.OnClick;
import com.bumptech.glide.C1584j;
import com.bumptech.glide.ComponentCallbacks2C1576b;
import com.hicorenational.antifraud.C2113R;
import com.taobao.agoo.p201a.p202a.AbstractC3059b;
import interfaces.IClickListener;
import java.io.Serializable;
import java.util.List;
import org.greenrobot.eventbus.C6049c;
import org.greenrobot.eventbus.InterfaceC6059m;
import org.greenrobot.eventbus.ThreadMode;
import p245d.C4440a;
import p286h.C5226e1;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;
import p388ui.callview.CaseHistoryCallView;
import p388ui.presenter.CaseHistoryPresenter;
import p388ui.view.swip.SwipBackLayout;
import util.C7257b1;
import util.C7292k1;
import util.C7331w1;
import util.p395c2.C7265a;

/* compiled from: CaseDetailActivity.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010ä\u0001\u001a\u00030å\u00012\u000e\u0010æ\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010ç\u0001J\n\u0010è\u0001\u001a\u00030å\u0001H\u0016J\u0012\u0010é\u0001\u001a\u00030å\u00012\b\u0010Ò\u0001\u001a\u00030Ó\u0001J(\u0010ê\u0001\u001a\u00030å\u00012\u0007\u0010ë\u0001\u001a\u00020\u00052\u0007\u0010ì\u0001\u001a\u00020\u00052\n\u0010í\u0001\u001a\u0005\u0018\u00010î\u0001H\u0014J\n\u0010ï\u0001\u001a\u00030å\u0001H\u0016J\u0013\u0010ð\u0001\u001a\u00030å\u00012\u0007\u0010ñ\u0001\u001a\u00020WH\u0007J\n\u0010ò\u0001\u001a\u00030å\u0001H\u0014J\u0016\u0010ó\u0001\u001a\u00030å\u00012\n\u0010ô\u0001\u001a\u0005\u0018\u00010õ\u0001H\u0007J\n\u0010ö\u0001\u001a\u00030å\u0001H\u0016J\n\u0010÷\u0001\u001a\u00030å\u0001H\u0016J\u0014\u0010ø\u0001\u001a\u00030å\u00012\b\u0010Ò\u0001\u001a\u00030Ó\u0001H\u0016J\t\u0010ù\u0001\u001a\u00020\u0005H\u0016J\b\u0010ú\u0001\u001a\u00030å\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001e\u0010)\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\u001e\u00102\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010,\"\u0004\b4\u0010.R\u001e\u00105\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010,\"\u0004\b7\u0010.R\u001e\u00108\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010,\"\u0004\b:\u0010.R\u001e\u0010;\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010,\"\u0004\b=\u0010.R\u001e\u0010>\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010,\"\u0004\b@\u0010.R\u001e\u0010A\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010,\"\u0004\bC\u0010.R\u001e\u0010D\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010,\"\u0004\bF\u0010.R\u001e\u0010G\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010,\"\u0004\bI\u0010.R\u001e\u0010J\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010,\"\u0004\bL\u0010.R\u001e\u0010M\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010,\"\u0004\bO\u0010.R\u001e\u0010P\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010,\"\u0004\bR\u0010.R\u001e\u0010S\u001a\u00020*8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010,\"\u0004\bU\u0010.R\u001e\u0010V\u001a\u00020W8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001e\u0010\\\u001a\u00020W8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010Y\"\u0004\b^\u0010[R\u001e\u0010_\u001a\u00020W8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010Y\"\u0004\ba\u0010[R\u001e\u0010b\u001a\u00020W8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010Y\"\u0004\bd\u0010[R\u001e\u0010e\u001a\u00020f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001e\u0010k\u001a\u00020W8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010Y\"\u0004\bm\u0010[R\u001e\u0010n\u001a\u00020W8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010Y\"\u0004\bp\u0010[R\u001e\u0010q\u001a\u00020W8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010Y\"\u0004\bs\u0010[R\u001e\u0010t\u001a\u00020W8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010Y\"\u0004\bv\u0010[R\u001e\u0010w\u001a\u00020f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010h\"\u0004\by\u0010jR\u001e\u0010z\u001a\u00020W8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010Y\"\u0004\b|\u0010[R\u001e\u0010}\u001a\u00020f8\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010h\"\u0004\b\u007f\u0010jR!\u0010\u0080\u0001\u001a\u00020f8\u0006@\u0006X\u0087.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010h\"\u0005\b\u0082\u0001\u0010jR!\u0010\u0083\u0001\u001a\u00020W8\u0006@\u0006X\u0087.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010Y\"\u0005\b\u0085\u0001\u0010[R\"\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R$\u0010\u008c\u0001\u001a\u00030\u008d\u00018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R&\u0010\u0092\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0093\u0001\u0018\u00010 X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010#\"\u0005\b\u0095\u0001\u0010%R$\u0010\u0096\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R$\u0010\u009c\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0000\u001a\u0006\b\u009d\u0001\u0010\u0099\u0001\"\u0006\b\u009e\u0001\u0010\u009b\u0001R$\u0010\u009f\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0000\u001a\u0006\b \u0001\u0010\u0099\u0001\"\u0006\b¡\u0001\u0010\u009b\u0001R$\u0010¢\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0000\u001a\u0006\b£\u0001\u0010\u0099\u0001\"\u0006\b¤\u0001\u0010\u009b\u0001R$\u0010¥\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0000\u001a\u0006\b¦\u0001\u0010\u0099\u0001\"\u0006\b§\u0001\u0010\u009b\u0001R$\u0010¨\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0000\u001a\u0006\b©\u0001\u0010\u0099\u0001\"\u0006\bª\u0001\u0010\u009b\u0001R$\u0010«\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0000\u001a\u0006\b¬\u0001\u0010\u0099\u0001\"\u0006\b\u00ad\u0001\u0010\u009b\u0001R$\u0010®\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0000\u001a\u0006\b¯\u0001\u0010\u0099\u0001\"\u0006\b°\u0001\u0010\u009b\u0001R$\u0010±\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0000\u001a\u0006\b²\u0001\u0010\u0099\u0001\"\u0006\b³\u0001\u0010\u009b\u0001R$\u0010´\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0000\u001a\u0006\bµ\u0001\u0010\u0099\u0001\"\u0006\b¶\u0001\u0010\u009b\u0001R$\u0010·\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0000\u001a\u0006\b¸\u0001\u0010\u0099\u0001\"\u0006\b¹\u0001\u0010\u009b\u0001R$\u0010º\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0000\u001a\u0006\b»\u0001\u0010\u0099\u0001\"\u0006\b¼\u0001\u0010\u009b\u0001R$\u0010½\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0000\u001a\u0006\b¾\u0001\u0010\u0099\u0001\"\u0006\b¿\u0001\u0010\u009b\u0001R$\u0010À\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0000\u001a\u0006\bÁ\u0001\u0010\u0099\u0001\"\u0006\bÂ\u0001\u0010\u009b\u0001R$\u0010Ã\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0000\u001a\u0006\bÄ\u0001\u0010\u0099\u0001\"\u0006\bÅ\u0001\u0010\u009b\u0001R$\u0010Æ\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0000\u001a\u0006\bÇ\u0001\u0010\u0099\u0001\"\u0006\bÈ\u0001\u0010\u009b\u0001R\u001d\u0010É\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÊ\u0001\u0010\u0007\"\u0005\bË\u0001\u0010\tR\u001d\u0010Ì\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÍ\u0001\u0010\u0007\"\u0005\bÎ\u0001\u0010\tR\u001d\u0010Ï\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÐ\u0001\u0010\u0007\"\u0005\bÑ\u0001\u0010\tR\"\u0010Ò\u0001\u001a\u0005\u0018\u00010Ó\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÔ\u0001\u0010Õ\u0001\"\u0006\bÖ\u0001\u0010×\u0001R\u001d\u0010Ø\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÙ\u0001\u0010\u0007\"\u0005\bÚ\u0001\u0010\tR\u001d\u0010Û\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÜ\u0001\u0010\u0007\"\u0005\bÝ\u0001\u0010\tR\u001d\u0010Þ\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bß\u0001\u0010\u0007\"\u0005\bà\u0001\u0010\tR\u001d\u0010á\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bâ\u0001\u0010\u0007\"\u0005\bã\u0001\u0010\t¨\u0006û\u0001"}, m23546d2 = {"Lui/activity/CaseDetailActivity;", "Lui/activity/BaseActivity;", "Lui/callview/CaseHistoryCallView;", "()V", "appCount", "", "getAppCount", "()I", "setAppCount", "(I)V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "callTelCount", "getCallTelCount", "setCallTelCount", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "chargeTelCount", "getChargeTelCount", "setChargeTelCount", "linkTelCount", "getLinkTelCount", "setLinkTelCount", "mAccountAutoList", "", "Lbean/AccountListBean;", "getMAccountAutoList", "()Ljava/util/List;", "setMAccountAutoList", "(Ljava/util/List;)V", "mAccountList", "getMAccountList", "setMAccountList", "mIvAccount", "Landroid/widget/ImageView;", "getMIvAccount", "()Landroid/widget/ImageView;", "setMIvAccount", "(Landroid/widget/ImageView;)V", "mIvApp", "getMIvApp", "setMIvApp", "mIvBack", "getMIvBack", "setMIvBack", "mIvCall", "getMIvCall", "setMIvCall", "mIvDelivery", "getMIvDelivery", "setMIvDelivery", "mIvNet", "getMIvNet", "setMIvNet", "mIvRecharge", "getMIvRecharge", "setMIvRecharge", "mIvRelation", "getMIvRelation", "setMIvRelation", "mIvSignImg", "getMIvSignImg", "setMIvSignImg", "mIvSms", "getMIvSms", "setMIvSms", "mIvStatusTag", "getMIvStatusTag", "setMIvStatusTag", "mIvStopPayment", "getMIvStopPayment", "setMIvStopPayment", "mIvVictim", "getMIvVictim", "setMIvVictim", "mIvWebsite", "getMIvWebsite", "setMIvWebsite", "mLlApp", "Landroid/view/View;", "getMLlApp", "()Landroid/view/View;", "setMLlApp", "(Landroid/view/View;)V", "mLlCall", "getMLlCall", "setMLlCall", "mLlCriminalCall", "getMLlCriminalCall", "setMLlCriminalCall", "mLlCriminalNet", "getMLlCriminalNet", "setMLlCriminalNet", "mLlDeal", "Landroid/widget/LinearLayout;", "getMLlDeal", "()Landroid/widget/LinearLayout;", "setMLlDeal", "(Landroid/widget/LinearLayout;)V", "mLlDelivery", "getMLlDelivery", "setMLlDelivery", "mLlNet", "getMLlNet", "setMLlNet", "mLlRecharge", "getMLlRecharge", "setMLlRecharge", "mLlRelation", "getMLlRelation", "setMLlRelation", "mLlReply", "getMLlReply", "setMLlReply", "mLlSms", "getMLlSms", "setMLlSms", "mLlStopPayment", "getMLlStopPayment", "setMLlStopPayment", "mLlStopPaymentContent", "getMLlStopPaymentContent", "setMLlStopPaymentContent", "mLlWebsit", "getMLlWebsit", "setMLlWebsit", "mPreenter", "Lui/presenter/CaseHistoryPresenter;", "getMPreenter", "()Lui/presenter/CaseHistoryPresenter;", "setMPreenter", "(Lui/presenter/CaseHistoryPresenter;)V", "mRecyclerViewReply", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyclerViewReply", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyclerViewReply", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mReplyList", "Lbean/ReplyBean;", "getMReplyList", "setMReplyList", "mTvAppNum", "Landroid/widget/TextView;", "getMTvAppNum", "()Landroid/widget/TextView;", "setMTvAppNum", "(Landroid/widget/TextView;)V", "mTvCaseAccNum", "getMTvCaseAccNum", "setMTvCaseAccNum", "mTvCaseName", "getMTvCaseName", "setMTvCaseName", "mTvCaseNum", "getMTvCaseNum", "setMTvCaseNum", "mTvCaseTime", "getMTvCaseTime", "setMTvCaseTime", "mTvCriminalCallNum", "getMTvCriminalCallNum", "setMTvCriminalCallNum", "mTvCriminalDelivery", "getMTvCriminalDelivery", "setMTvCriminalDelivery", "mTvCriminalNet", "getMTvCriminalNet", "setMTvCriminalNet", "mTvCriminalRecharge", "getMTvCriminalRecharge", "setMTvCriminalRecharge", "mTvCriminalRelation", "getMTvCriminalRelation", "setMTvCriminalRelation", "mTvCriminalSms", "getMTvCriminalSms", "setMTvCriminalSms", "mTvPolicNum", "getMTvPolicNum", "setMTvPolicNum", "mTvSZNum", "getMTvSZNum", "setMTvSZNum", "mTvStopPaymentNum", "getMTvStopPaymentNum", "setMTvStopPaymentNum", "mTvTitle", "getMTvTitle", "setMTvTitle", "mTvWebsitNum", "getMTvWebsitNum", "setMTvWebsitNum", "mailingTelCount", "getMailingTelCount", "setMailingTelCount", "netAccountCount", "getNetAccountCount", "setNetAccountCount", "paymentCount", "getPaymentCount", "setPaymentCount", "result", "Lbean/CaseDetailBean;", "getResult", "()Lbean/CaseDetailBean;", "setResult", "(Lbean/CaseDetailBean;)V", "smsCount", "getSmsCount", "setSmsCount", "stopPaymentCount", "getStopPaymentCount", "setStopPaymentCount", "urlCount", "getUrlCount", "setUrlCount", "victimCount", "getVictimCount", "setVictimCount", "goChildPage", "", "cls", "Ljava/lang/Class;", "initPage", "initView", "onActivityResult", "requestCode", AbstractC3059b.JSON_ERRORCODE, "data", "Landroid/content/Intent;", "onBackPressed", "onClick", "view", "onDestroy", "onEvent", "refreshUIEvent", "Lutil/event/RefreshUIEvent;", "onSuccessBack", "onSuccessCommit", "onSuccessDetail", "setLayoutView", "submit", "app_offic_flavorRelease"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class CaseDetailActivity extends BaseActivity implements CaseHistoryCallView {
    private int appCount;

    @InterfaceC5817e
    private Bitmap bitmap;
    private int callTelCount;

    @InterfaceC5816d
    private String caseInfoId = "";
    private int chargeTelCount;
    private int linkTelCount;

    @InterfaceC5817e
    private List<? extends AccountListBean> mAccountAutoList;

    @InterfaceC5817e
    private List<? extends AccountListBean> mAccountList;

    @BindView(C2113R.id.iv_account)
    @InterfaceC5816d
    public ImageView mIvAccount;

    @BindView(C2113R.id.iv_app)
    @InterfaceC5816d
    public ImageView mIvApp;

    @BindView(C2113R.id.iv_back)
    @InterfaceC5816d
    public ImageView mIvBack;

    @BindView(C2113R.id.iv_call)
    @InterfaceC5816d
    public ImageView mIvCall;

    @BindView(C2113R.id.iv_delivery)
    @InterfaceC5816d
    public ImageView mIvDelivery;

    @BindView(C2113R.id.iv_net)
    @InterfaceC5816d
    public ImageView mIvNet;

    @BindView(C2113R.id.iv_recharge)
    @InterfaceC5816d
    public ImageView mIvRecharge;

    @BindView(C2113R.id.iv_relation)
    @InterfaceC5816d
    public ImageView mIvRelation;

    @BindView(C2113R.id.iv_repter_sign)
    @InterfaceC5816d
    public ImageView mIvSignImg;

    @BindView(C2113R.id.iv_sms)
    @InterfaceC5816d
    public ImageView mIvSms;

    @BindView(C2113R.id.iv_status_tag)
    @InterfaceC5816d
    public ImageView mIvStatusTag;

    @BindView(C2113R.id.iv_stop_payment)
    @InterfaceC5816d
    public ImageView mIvStopPayment;

    @BindView(C2113R.id.iv_victim)
    @InterfaceC5816d
    public ImageView mIvVictim;

    @BindView(C2113R.id.iv_website)
    @InterfaceC5816d
    public ImageView mIvWebsite;

    @BindView(C2113R.id.ll_app)
    @InterfaceC5816d
    public View mLlApp;

    @BindView(C2113R.id.ll_call)
    @InterfaceC5816d
    public View mLlCall;

    @BindView(C2113R.id.ll_criminal_call)
    @InterfaceC5816d
    public View mLlCriminalCall;

    @BindView(C2113R.id.ll_criminal_net)
    @InterfaceC5816d
    public View mLlCriminalNet;

    @BindView(C2113R.id.ll_deal)
    @InterfaceC5816d
    public LinearLayout mLlDeal;

    @BindView(C2113R.id.ll_delivery)
    @InterfaceC5816d
    public View mLlDelivery;

    @BindView(C2113R.id.ll_net)
    @InterfaceC5816d
    public View mLlNet;

    @BindView(C2113R.id.ll_recharge)
    @InterfaceC5816d
    public View mLlRecharge;

    @BindView(C2113R.id.ll_relation)
    @InterfaceC5816d
    public View mLlRelation;

    @BindView(C2113R.id.ll_reply)
    @InterfaceC5816d
    public LinearLayout mLlReply;

    @BindView(C2113R.id.ll_sms)
    @InterfaceC5816d
    public View mLlSms;

    @BindView(C2113R.id.ll_stop_payment)
    @InterfaceC5816d
    public LinearLayout mLlStopPayment;

    @BindView(C2113R.id.ll_stop_payment_content)
    @InterfaceC5816d
    public LinearLayout mLlStopPaymentContent;

    @BindView(C2113R.id.ll_websit)
    @InterfaceC5816d
    public View mLlWebsit;

    @InterfaceC5817e
    private CaseHistoryPresenter mPreenter;

    @BindView(C2113R.id.recyclerview_reply)
    @InterfaceC5816d
    public RecyclerView mRecyclerViewReply;

    @InterfaceC5817e
    private List<? extends ReplyBean> mReplyList;

    @BindView(C2113R.id.tv_app_info_detial)
    @InterfaceC5816d
    public TextView mTvAppNum;

    @BindView(C2113R.id.tv_case_account_detial)
    @InterfaceC5816d
    public TextView mTvCaseAccNum;

    @BindView(C2113R.id.tv_case_name)
    @InterfaceC5816d
    public TextView mTvCaseName;

    @BindView(C2113R.id.case_num)
    @InterfaceC5816d
    public TextView mTvCaseNum;

    @BindView(C2113R.id.case_time)
    @InterfaceC5816d
    public TextView mTvCaseTime;

    @BindView(C2113R.id.tv_criminal_call_detial)
    @InterfaceC5816d
    public TextView mTvCriminalCallNum;

    @BindView(C2113R.id.tv_criminal_delivery_detial)
    @InterfaceC5816d
    public TextView mTvCriminalDelivery;

    @BindView(C2113R.id.tv_criminal_net_detial)
    @InterfaceC5816d
    public TextView mTvCriminalNet;

    @BindView(C2113R.id.tv_criminal_recharge_detial)
    @InterfaceC5816d
    public TextView mTvCriminalRecharge;

    @BindView(C2113R.id.tv_criminal_relation_detial)
    @InterfaceC5816d
    public TextView mTvCriminalRelation;

    @BindView(C2113R.id.tv_criminal_sms_detial)
    @InterfaceC5816d
    public TextView mTvCriminalSms;

    @BindView(C2113R.id.polic_num)
    @InterfaceC5816d
    public TextView mTvPolicNum;

    @BindView(C2113R.id.tv_shizhu_detial)
    @InterfaceC5816d
    public TextView mTvSZNum;

    @BindView(C2113R.id.tv_stop_payment)
    @InterfaceC5816d
    public TextView mTvStopPaymentNum;

    @BindView(C2113R.id.tv_title)
    @InterfaceC5816d
    public TextView mTvTitle;

    @BindView(C2113R.id.tv_websit_info_detial)
    @InterfaceC5816d
    public TextView mTvWebsitNum;
    private int mailingTelCount;
    private int netAccountCount;
    private int paymentCount;

    @InterfaceC5817e
    private CaseDetailBean result;
    private int smsCount;
    private int stopPaymentCount;
    private int urlCount;
    private int victimCount;

    /* compiled from: CaseDetailActivity.kt */
    /* renamed from: ui.activity.CaseDetailActivity$a */
    public static final class C6191a implements IClickListener {
        C6191a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            CaseDetailActivity.this.finish();
        }
    }

    /* compiled from: CaseDetailActivity.kt */
    /* renamed from: ui.activity.CaseDetailActivity$b */
    public static final class C6192b implements IClickListener {
        C6192b() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
            CaseHistoryPresenter mPreenter = CaseDetailActivity.this.getMPreenter();
            if (mPreenter != null) {
                mPreenter.submitCase(CaseDetailActivity.this.getCaseInfoId(), null);
            }
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            CaseDetailActivity.this.goChildPage(PayStopListActivity.class);
        }
    }

    public final int getAppCount() {
        return this.appCount;
    }

    @InterfaceC5817e
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final int getCallTelCount() {
        return this.callTelCount;
    }

    @InterfaceC5816d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    public final int getChargeTelCount() {
        return this.chargeTelCount;
    }

    public final int getLinkTelCount() {
        return this.linkTelCount;
    }

    @InterfaceC5817e
    public final List<AccountListBean> getMAccountAutoList() {
        return this.mAccountAutoList;
    }

    @InterfaceC5817e
    public final List<AccountListBean> getMAccountList() {
        return this.mAccountList;
    }

    @InterfaceC5816d
    public final ImageView getMIvAccount() {
        ImageView imageView = this.mIvAccount;
        if (imageView == null) {
            C5544i0.m22554k("mIvAccount");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final ImageView getMIvApp() {
        ImageView imageView = this.mIvApp;
        if (imageView == null) {
            C5544i0.m22554k("mIvApp");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            C5544i0.m22554k("mIvBack");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final ImageView getMIvCall() {
        ImageView imageView = this.mIvCall;
        if (imageView == null) {
            C5544i0.m22554k("mIvCall");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final ImageView getMIvDelivery() {
        ImageView imageView = this.mIvDelivery;
        if (imageView == null) {
            C5544i0.m22554k("mIvDelivery");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final ImageView getMIvNet() {
        ImageView imageView = this.mIvNet;
        if (imageView == null) {
            C5544i0.m22554k("mIvNet");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final ImageView getMIvRecharge() {
        ImageView imageView = this.mIvRecharge;
        if (imageView == null) {
            C5544i0.m22554k("mIvRecharge");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final ImageView getMIvRelation() {
        ImageView imageView = this.mIvRelation;
        if (imageView == null) {
            C5544i0.m22554k("mIvRelation");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final ImageView getMIvSignImg() {
        ImageView imageView = this.mIvSignImg;
        if (imageView == null) {
            C5544i0.m22554k("mIvSignImg");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final ImageView getMIvSms() {
        ImageView imageView = this.mIvSms;
        if (imageView == null) {
            C5544i0.m22554k("mIvSms");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final ImageView getMIvStatusTag() {
        ImageView imageView = this.mIvStatusTag;
        if (imageView == null) {
            C5544i0.m22554k("mIvStatusTag");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final ImageView getMIvStopPayment() {
        ImageView imageView = this.mIvStopPayment;
        if (imageView == null) {
            C5544i0.m22554k("mIvStopPayment");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final ImageView getMIvVictim() {
        ImageView imageView = this.mIvVictim;
        if (imageView == null) {
            C5544i0.m22554k("mIvVictim");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final ImageView getMIvWebsite() {
        ImageView imageView = this.mIvWebsite;
        if (imageView == null) {
            C5544i0.m22554k("mIvWebsite");
        }
        return imageView;
    }

    @InterfaceC5816d
    public final View getMLlApp() {
        View view = this.mLlApp;
        if (view == null) {
            C5544i0.m22554k("mLlApp");
        }
        return view;
    }

    @InterfaceC5816d
    public final View getMLlCall() {
        View view = this.mLlCall;
        if (view == null) {
            C5544i0.m22554k("mLlCall");
        }
        return view;
    }

    @InterfaceC5816d
    public final View getMLlCriminalCall() {
        View view = this.mLlCriminalCall;
        if (view == null) {
            C5544i0.m22554k("mLlCriminalCall");
        }
        return view;
    }

    @InterfaceC5816d
    public final View getMLlCriminalNet() {
        View view = this.mLlCriminalNet;
        if (view == null) {
            C5544i0.m22554k("mLlCriminalNet");
        }
        return view;
    }

    @InterfaceC5816d
    public final LinearLayout getMLlDeal() {
        LinearLayout linearLayout = this.mLlDeal;
        if (linearLayout == null) {
            C5544i0.m22554k("mLlDeal");
        }
        return linearLayout;
    }

    @InterfaceC5816d
    public final View getMLlDelivery() {
        View view = this.mLlDelivery;
        if (view == null) {
            C5544i0.m22554k("mLlDelivery");
        }
        return view;
    }

    @InterfaceC5816d
    public final View getMLlNet() {
        View view = this.mLlNet;
        if (view == null) {
            C5544i0.m22554k("mLlNet");
        }
        return view;
    }

    @InterfaceC5816d
    public final View getMLlRecharge() {
        View view = this.mLlRecharge;
        if (view == null) {
            C5544i0.m22554k("mLlRecharge");
        }
        return view;
    }

    @InterfaceC5816d
    public final View getMLlRelation() {
        View view = this.mLlRelation;
        if (view == null) {
            C5544i0.m22554k("mLlRelation");
        }
        return view;
    }

    @InterfaceC5816d
    public final LinearLayout getMLlReply() {
        LinearLayout linearLayout = this.mLlReply;
        if (linearLayout == null) {
            C5544i0.m22554k("mLlReply");
        }
        return linearLayout;
    }

    @InterfaceC5816d
    public final View getMLlSms() {
        View view = this.mLlSms;
        if (view == null) {
            C5544i0.m22554k("mLlSms");
        }
        return view;
    }

    @InterfaceC5816d
    public final LinearLayout getMLlStopPayment() {
        LinearLayout linearLayout = this.mLlStopPayment;
        if (linearLayout == null) {
            C5544i0.m22554k("mLlStopPayment");
        }
        return linearLayout;
    }

    @InterfaceC5816d
    public final LinearLayout getMLlStopPaymentContent() {
        LinearLayout linearLayout = this.mLlStopPaymentContent;
        if (linearLayout == null) {
            C5544i0.m22554k("mLlStopPaymentContent");
        }
        return linearLayout;
    }

    @InterfaceC5816d
    public final View getMLlWebsit() {
        View view = this.mLlWebsit;
        if (view == null) {
            C5544i0.m22554k("mLlWebsit");
        }
        return view;
    }

    @InterfaceC5817e
    public final CaseHistoryPresenter getMPreenter() {
        return this.mPreenter;
    }

    @InterfaceC5816d
    public final RecyclerView getMRecyclerViewReply() {
        RecyclerView recyclerView = this.mRecyclerViewReply;
        if (recyclerView == null) {
            C5544i0.m22554k("mRecyclerViewReply");
        }
        return recyclerView;
    }

    @InterfaceC5817e
    public final List<ReplyBean> getMReplyList() {
        return this.mReplyList;
    }

    @InterfaceC5816d
    public final TextView getMTvAppNum() {
        TextView textView = this.mTvAppNum;
        if (textView == null) {
            C5544i0.m22554k("mTvAppNum");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvCaseAccNum() {
        TextView textView = this.mTvCaseAccNum;
        if (textView == null) {
            C5544i0.m22554k("mTvCaseAccNum");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvCaseName() {
        TextView textView = this.mTvCaseName;
        if (textView == null) {
            C5544i0.m22554k("mTvCaseName");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvCaseNum() {
        TextView textView = this.mTvCaseNum;
        if (textView == null) {
            C5544i0.m22554k("mTvCaseNum");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvCaseTime() {
        TextView textView = this.mTvCaseTime;
        if (textView == null) {
            C5544i0.m22554k("mTvCaseTime");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvCriminalCallNum() {
        TextView textView = this.mTvCriminalCallNum;
        if (textView == null) {
            C5544i0.m22554k("mTvCriminalCallNum");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvCriminalDelivery() {
        TextView textView = this.mTvCriminalDelivery;
        if (textView == null) {
            C5544i0.m22554k("mTvCriminalDelivery");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvCriminalNet() {
        TextView textView = this.mTvCriminalNet;
        if (textView == null) {
            C5544i0.m22554k("mTvCriminalNet");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvCriminalRecharge() {
        TextView textView = this.mTvCriminalRecharge;
        if (textView == null) {
            C5544i0.m22554k("mTvCriminalRecharge");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvCriminalRelation() {
        TextView textView = this.mTvCriminalRelation;
        if (textView == null) {
            C5544i0.m22554k("mTvCriminalRelation");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvCriminalSms() {
        TextView textView = this.mTvCriminalSms;
        if (textView == null) {
            C5544i0.m22554k("mTvCriminalSms");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvPolicNum() {
        TextView textView = this.mTvPolicNum;
        if (textView == null) {
            C5544i0.m22554k("mTvPolicNum");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvSZNum() {
        TextView textView = this.mTvSZNum;
        if (textView == null) {
            C5544i0.m22554k("mTvSZNum");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvStopPaymentNum() {
        TextView textView = this.mTvStopPaymentNum;
        if (textView == null) {
            C5544i0.m22554k("mTvStopPaymentNum");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        return textView;
    }

    @InterfaceC5816d
    public final TextView getMTvWebsitNum() {
        TextView textView = this.mTvWebsitNum;
        if (textView == null) {
            C5544i0.m22554k("mTvWebsitNum");
        }
        return textView;
    }

    public final int getMailingTelCount() {
        return this.mailingTelCount;
    }

    public final int getNetAccountCount() {
        return this.netAccountCount;
    }

    public final int getPaymentCount() {
        return this.paymentCount;
    }

    @InterfaceC5817e
    public final CaseDetailBean getResult() {
        return this.result;
    }

    public final int getSmsCount() {
        return this.smsCount;
    }

    public final int getStopPaymentCount() {
        return this.stopPaymentCount;
    }

    public final int getUrlCount() {
        return this.urlCount;
    }

    public final int getVictimCount() {
        return this.victimCount;
    }

    public final void goChildPage(@InterfaceC5817e Class<?> cls) {
        Intent intent = new Intent(this.mActivity, cls);
        intent.putExtra(C7292k1.f25338C0, this.caseInfoId);
        startActivity(intent);
    }

    @Override // p388ui.activity.BaseActivity
    public void initPage() {
        C6049c.m24987f().m25001e(this);
        SwipBackLayout.m26045a(this.mActivity).m26049a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            C5544i0.m22554k("mTvTitle");
        }
        if (textView == null) {
            C5544i0.m22545f();
        }
        textView.setText("报案信息");
        ImageView imageView = this.mIvStatusTag;
        if (imageView == null) {
            C5544i0.m22554k("mIvStatusTag");
        }
        imageView.setVisibility(8);
        LinearLayout linearLayout = this.mLlDeal;
        if (linearLayout == null) {
            C5544i0.m22554k("mLlDeal");
        }
        linearLayout.setVisibility(8);
        String stringExtra = getIntent().getStringExtra(C7292k1.f25338C0);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.caseInfoId = stringExtra;
        this.mPreenter = new CaseHistoryPresenter(this.mActivity, this);
        CaseHistoryPresenter caseHistoryPresenter = this.mPreenter;
        if (caseHistoryPresenter != null) {
            caseHistoryPresenter.getDetail(this.caseInfoId);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void initView(@InterfaceC5816d CaseDetailBean caseDetailBean) {
        C5544i0.m22546f(caseDetailBean, "result");
        this.result = caseDetailBean;
        TextView textView = this.mTvCaseName;
        if (textView == null) {
            C5544i0.m22554k("mTvCaseName");
        }
        textView.setText(caseDetailBean.getCaseName());
        TextView textView2 = this.mTvCaseTime;
        if (textView2 == null) {
            C5544i0.m22554k("mTvCaseTime");
        }
        textView2.setText(caseDetailBean.getProcessTime());
        TextView textView3 = this.mTvCaseNum;
        if (textView3 == null) {
            C5544i0.m22554k("mTvCaseNum");
        }
        textView3.setText(caseDetailBean.getCaseNumber());
        TextView textView4 = this.mTvPolicNum;
        if (textView4 == null) {
            C5544i0.m22554k("mTvPolicNum");
        }
        textView4.setText(caseDetailBean.getCaseCategoryText());
        this.victimCount = caseDetailBean.getVictimCount();
        this.paymentCount = caseDetailBean.getPaymentCount();
        this.callTelCount = caseDetailBean.getCallTelCount();
        this.chargeTelCount = caseDetailBean.getChargeTelCount();
        this.linkTelCount = caseDetailBean.getLinkTelCount();
        this.mailingTelCount = caseDetailBean.getMailingTelCount();
        this.smsCount = caseDetailBean.getSmsCount();
        this.netAccountCount = caseDetailBean.getNetAccountCount();
        this.appCount = caseDetailBean.getAppCount();
        this.urlCount = caseDetailBean.getUrlCount();
        this.stopPaymentCount = caseDetailBean.getStopPaymentCount();
        TextView textView5 = this.mTvSZNum;
        if (textView5 == null) {
            C5544i0.m22554k("mTvSZNum");
        }
        textView5.setText("" + this.victimCount + "个");
        TextView textView6 = this.mTvCaseAccNum;
        if (textView6 == null) {
            C5544i0.m22554k("mTvCaseAccNum");
        }
        textView6.setText("" + this.paymentCount + "个");
        TextView textView7 = this.mTvCriminalCallNum;
        if (textView7 == null) {
            C5544i0.m22554k("mTvCriminalCallNum");
        }
        textView7.setText("" + this.callTelCount + "个");
        TextView textView8 = this.mTvCriminalRecharge;
        if (textView8 == null) {
            C5544i0.m22554k("mTvCriminalRecharge");
        }
        textView8.setText("" + this.chargeTelCount + "个");
        TextView textView9 = this.mTvCriminalRelation;
        if (textView9 == null) {
            C5544i0.m22554k("mTvCriminalRelation");
        }
        textView9.setText("" + this.linkTelCount + "个");
        TextView textView10 = this.mTvCriminalDelivery;
        if (textView10 == null) {
            C5544i0.m22554k("mTvCriminalDelivery");
        }
        textView10.setText("" + this.mailingTelCount + "个");
        TextView textView11 = this.mTvCriminalSms;
        if (textView11 == null) {
            C5544i0.m22554k("mTvCriminalSms");
        }
        textView11.setText("" + this.smsCount + "个");
        TextView textView12 = this.mTvCriminalNet;
        if (textView12 == null) {
            C5544i0.m22554k("mTvCriminalNet");
        }
        textView12.setText("" + this.netAccountCount + "个");
        TextView textView13 = this.mTvAppNum;
        if (textView13 == null) {
            C5544i0.m22554k("mTvAppNum");
        }
        textView13.setText("" + this.appCount + "个");
        TextView textView14 = this.mTvWebsitNum;
        if (textView14 == null) {
            C5544i0.m22554k("mTvWebsitNum");
        }
        textView14.setText("" + this.urlCount + "个");
        int i2 = this.callTelCount;
        if (this.chargeTelCount + i2 + this.linkTelCount + this.mailingTelCount == 0) {
            View view = this.mLlCriminalCall;
            if (view == null) {
                C5544i0.m22554k("mLlCriminalCall");
            }
            view.setVisibility(8);
        } else {
            if (i2 == 0) {
                View view2 = this.mLlCall;
                if (view2 == null) {
                    C5544i0.m22554k("mLlCall");
                }
                view2.setVisibility(8);
            }
            if (this.chargeTelCount == 0) {
                View view3 = this.mLlRecharge;
                if (view3 == null) {
                    C5544i0.m22554k("mLlRecharge");
                }
                view3.setVisibility(8);
            }
            if (this.linkTelCount == 0) {
                View view4 = this.mLlRelation;
                if (view4 == null) {
                    C5544i0.m22554k("mLlRelation");
                }
                view4.setVisibility(8);
            }
            if (this.mailingTelCount == 0) {
                View view5 = this.mLlDelivery;
                if (view5 == null) {
                    C5544i0.m22554k("mLlDelivery");
                }
                view5.setVisibility(8);
            }
        }
        if (this.smsCount == 0) {
            View view6 = this.mLlSms;
            if (view6 == null) {
                C5544i0.m22554k("mLlSms");
            }
            view6.setVisibility(8);
        }
        int i3 = this.netAccountCount;
        if (this.appCount + i3 + this.urlCount == 0) {
            View view7 = this.mLlCriminalNet;
            if (view7 == null) {
                C5544i0.m22554k("mLlCriminalNet");
            }
            view7.setVisibility(8);
        } else {
            if (i3 == 0) {
                View view8 = this.mLlNet;
                if (view8 == null) {
                    C5544i0.m22554k("mLlNet");
                }
                view8.setVisibility(8);
            }
            if (this.appCount == 0) {
                View view9 = this.mLlApp;
                if (view9 == null) {
                    C5544i0.m22554k("mLlApp");
                }
                view9.setVisibility(8);
            }
            if (this.urlCount == 0) {
                View view10 = this.mLlWebsit;
                if (view10 == null) {
                    C5544i0.m22554k("mLlWebsit");
                }
                view10.setVisibility(8);
            }
        }
        int status = caseDetailBean.getStatus();
        if (status != 0) {
            if (status != 3) {
                if (status != 127) {
                    if (status != 5) {
                        if (status != 6) {
                            return;
                        }
                        C1584j<Drawable> mo3717a = ComponentCallbacks2C1576b.m3634a(this.mActivity).mo3717a(Integer.valueOf(C2113R.mipmap.ic_detail_back));
                        ImageView imageView = this.mIvStatusTag;
                        if (imageView == null) {
                            C5544i0.m22554k("mIvStatusTag");
                        }
                        mo3717a.m3768a(imageView);
                        ImageView imageView2 = this.mIvStatusTag;
                        if (imageView2 == null) {
                            C5544i0.m22554k("mIvStatusTag");
                        }
                        imageView2.setVisibility(0);
                        LinearLayout linearLayout = this.mLlDeal;
                        if (linearLayout == null) {
                            C5544i0.m22554k("mLlDeal");
                        }
                        linearLayout.setVisibility(8);
                        return;
                    }
                }
            }
            C1584j<Drawable> mo3717a2 = ComponentCallbacks2C1576b.m3634a(this.mActivity).mo3717a(Integer.valueOf(C2113R.mipmap.ic_detail_wait));
            ImageView imageView3 = this.mIvStatusTag;
            if (imageView3 == null) {
                C5544i0.m22554k("mIvStatusTag");
            }
            mo3717a2.m3768a(imageView3);
            ImageView imageView4 = this.mIvStatusTag;
            if (imageView4 == null) {
                C5544i0.m22554k("mIvStatusTag");
            }
            imageView4.setVisibility(0);
            LinearLayout linearLayout2 = this.mLlDeal;
            if (linearLayout2 == null) {
                C5544i0.m22554k("mLlDeal");
            }
            linearLayout2.setVisibility(0);
            RegionMudelBean m16408j = C4440a.m16408j();
            if (m16408j == null || !TextUtils.equals(m16408j.getStopPayment(), "1")) {
                LinearLayout linearLayout3 = this.mLlStopPayment;
                if (linearLayout3 == null) {
                    C5544i0.m22554k("mLlStopPayment");
                }
                linearLayout3.setVisibility(8);
                LinearLayout linearLayout4 = this.mLlStopPaymentContent;
                if (linearLayout4 == null) {
                    C5544i0.m22554k("mLlStopPaymentContent");
                }
                linearLayout4.setVisibility(8);
                return;
            }
            LinearLayout linearLayout5 = this.mLlStopPayment;
            if (linearLayout5 == null) {
                C5544i0.m22554k("mLlStopPayment");
            }
            linearLayout5.setVisibility(0);
            LinearLayout linearLayout6 = this.mLlStopPaymentContent;
            if (linearLayout6 == null) {
                C5544i0.m22554k("mLlStopPaymentContent");
            }
            linearLayout6.setVisibility(0);
            TextView textView15 = this.mTvStopPaymentNum;
            if (textView15 == null) {
                C5544i0.m22554k("mTvStopPaymentNum");
            }
            textView15.setText("添加");
            TextView textView16 = this.mTvStopPaymentNum;
            if (textView16 == null) {
                C5544i0.m22554k("mTvStopPaymentNum");
            }
            textView16.setTextColor(getResources().getColor(C2113R.color._2B4CFF));
            return;
        }
        C1584j<Drawable> mo3717a3 = ComponentCallbacks2C1576b.m3634a(this.mActivity).mo3717a(Integer.valueOf(C2113R.mipmap.ic_detail_over));
        ImageView imageView5 = this.mIvStatusTag;
        if (imageView5 == null) {
            C5544i0.m22554k("mIvStatusTag");
        }
        mo3717a3.m3768a(imageView5);
        ImageView imageView6 = this.mIvStatusTag;
        if (imageView6 == null) {
            C5544i0.m22554k("mIvStatusTag");
        }
        imageView6.setVisibility(0);
        LinearLayout linearLayout7 = this.mLlDeal;
        if (linearLayout7 == null) {
            C5544i0.m22554k("mLlDeal");
        }
        linearLayout7.setVisibility(8);
        TextView textView17 = this.mTvSZNum;
        if (textView17 == null) {
            C5544i0.m22554k("mTvSZNum");
        }
        textView17.setEnabled(false);
        TextView textView18 = this.mTvCaseAccNum;
        if (textView18 == null) {
            C5544i0.m22554k("mTvCaseAccNum");
        }
        textView18.setEnabled(false);
        TextView textView19 = this.mTvCriminalCallNum;
        if (textView19 == null) {
            C5544i0.m22554k("mTvCriminalCallNum");
        }
        textView19.setEnabled(false);
        TextView textView20 = this.mTvCriminalRecharge;
        if (textView20 == null) {
            C5544i0.m22554k("mTvCriminalRecharge");
        }
        textView20.setEnabled(false);
        TextView textView21 = this.mTvCriminalRelation;
        if (textView21 == null) {
            C5544i0.m22554k("mTvCriminalRelation");
        }
        textView21.setEnabled(false);
        TextView textView22 = this.mTvCriminalDelivery;
        if (textView22 == null) {
            C5544i0.m22554k("mTvCriminalDelivery");
        }
        textView22.setEnabled(false);
        TextView textView23 = this.mTvCriminalSms;
        if (textView23 == null) {
            C5544i0.m22554k("mTvCriminalSms");
        }
        textView23.setEnabled(false);
        TextView textView24 = this.mTvCriminalNet;
        if (textView24 == null) {
            C5544i0.m22554k("mTvCriminalNet");
        }
        textView24.setEnabled(false);
        TextView textView25 = this.mTvAppNum;
        if (textView25 == null) {
            C5544i0.m22554k("mTvAppNum");
        }
        textView25.setEnabled(false);
        TextView textView26 = this.mTvWebsitNum;
        if (textView26 == null) {
            C5544i0.m22554k("mTvWebsitNum");
        }
        textView26.setEnabled(false);
        TextView textView27 = this.mTvStopPaymentNum;
        if (textView27 == null) {
            C5544i0.m22554k("mTvStopPaymentNum");
        }
        textView27.setEnabled(false);
        ImageView imageView7 = this.mIvVictim;
        if (imageView7 == null) {
            C5544i0.m22554k("mIvVictim");
        }
        imageView7.setVisibility(4);
        ImageView imageView8 = this.mIvAccount;
        if (imageView8 == null) {
            C5544i0.m22554k("mIvAccount");
        }
        imageView8.setVisibility(4);
        ImageView imageView9 = this.mIvCall;
        if (imageView9 == null) {
            C5544i0.m22554k("mIvCall");
        }
        imageView9.setVisibility(4);
        ImageView imageView10 = this.mIvRecharge;
        if (imageView10 == null) {
            C5544i0.m22554k("mIvRecharge");
        }
        imageView10.setVisibility(4);
        ImageView imageView11 = this.mIvRelation;
        if (imageView11 == null) {
            C5544i0.m22554k("mIvRelation");
        }
        imageView11.setVisibility(4);
        ImageView imageView12 = this.mIvDelivery;
        if (imageView12 == null) {
            C5544i0.m22554k("mIvDelivery");
        }
        imageView12.setVisibility(4);
        ImageView imageView13 = this.mIvSms;
        if (imageView13 == null) {
            C5544i0.m22554k("mIvSms");
        }
        imageView13.setVisibility(4);
        ImageView imageView14 = this.mIvNet;
        if (imageView14 == null) {
            C5544i0.m22554k("mIvNet");
        }
        imageView14.setVisibility(4);
        ImageView imageView15 = this.mIvApp;
        if (imageView15 == null) {
            C5544i0.m22554k("mIvApp");
        }
        imageView15.setVisibility(4);
        ImageView imageView16 = this.mIvWebsite;
        if (imageView16 == null) {
            C5544i0.m22554k("mIvWebsite");
        }
        imageView16.setVisibility(4);
        ImageView imageView17 = this.mIvStopPayment;
        if (imageView17 == null) {
            C5544i0.m22554k("mIvStopPayment");
        }
        imageView17.setVisibility(4);
        RegionMudelBean m16408j2 = C4440a.m16408j();
        if (m16408j2 == null || !TextUtils.equals(m16408j2.getStopPayment(), "1") || this.stopPaymentCount <= 0) {
            LinearLayout linearLayout8 = this.mLlStopPayment;
            if (linearLayout8 == null) {
                C5544i0.m22554k("mLlStopPayment");
            }
            linearLayout8.setVisibility(8);
            LinearLayout linearLayout9 = this.mLlStopPaymentContent;
            if (linearLayout9 == null) {
                C5544i0.m22554k("mLlStopPaymentContent");
            }
            linearLayout9.setVisibility(8);
        } else {
            LinearLayout linearLayout10 = this.mLlStopPayment;
            if (linearLayout10 == null) {
                C5544i0.m22554k("mLlStopPayment");
            }
            linearLayout10.setVisibility(0);
            LinearLayout linearLayout11 = this.mLlStopPaymentContent;
            if (linearLayout11 == null) {
                C5544i0.m22554k("mLlStopPaymentContent");
            }
            linearLayout11.setVisibility(0);
            TextView textView28 = this.mTvStopPaymentNum;
            if (textView28 == null) {
                C5544i0.m22554k("mTvStopPaymentNum");
            }
            textView28.setText("" + this.stopPaymentCount + "个");
        }
        this.mReplyList = caseDetailBean.getReplys();
        List<? extends ReplyBean> list = this.mReplyList;
        if (list != null) {
            if (list == null) {
                C5544i0.m22545f();
            }
            if (list.size() > 0) {
                LinearLayout linearLayout12 = this.mLlReply;
                if (linearLayout12 == null) {
                    C5544i0.m22554k("mLlReply");
                }
                linearLayout12.setVisibility(0);
                RecyclerView recyclerView = this.mRecyclerViewReply;
                if (recyclerView == null) {
                    C5544i0.m22554k("mRecyclerViewReply");
                }
                recyclerView.setVisibility(0);
                CaseHistoryPresenter caseHistoryPresenter = this.mPreenter;
                if (caseHistoryPresenter != null) {
                    RecyclerView recyclerView2 = this.mRecyclerViewReply;
                    if (recyclerView2 == null) {
                        C5544i0.m22554k("mRecyclerViewReply");
                    }
                    caseHistoryPresenter.initRecycler(recyclerView2);
                    C5715y1 c5715y1 = C5715y1.f20665a;
                }
                CaseHistoryPresenter caseHistoryPresenter2 = this.mPreenter;
                if (caseHistoryPresenter2 != 0) {
                    caseHistoryPresenter2.setListData(this.mReplyList);
                    C5715y1 c5715y12 = C5715y1.f20665a;
                    return;
                }
                return;
            }
        }
        LinearLayout linearLayout13 = this.mLlReply;
        if (linearLayout13 == null) {
            C5544i0.m22554k("mLlReply");
        }
        linearLayout13.setVisibility(8);
        RecyclerView recyclerView3 = this.mRecyclerViewReply;
        if (recyclerView3 == null) {
            C5544i0.m22554k("mRecyclerViewReply");
        }
        recyclerView3.setVisibility(8);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, @InterfaceC5817e Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            C7331w1.m26688a("提交成功！");
            onSuccessCommit();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    /* renamed from: onBackPressed */
    public void m8092a() {
        List<? extends AccountListBean> list = this.mAccountList;
        if (list != null) {
            if (list == null) {
                C5544i0.m22545f();
            }
            if (list.size() > 0) {
                C7257b1.m26184a(this.mActivity, "放弃本次信息编辑？", "", "取消", "确定", C2113R.color._2D4AEB, -1, true, (IClickListener) new C6191a());
                return;
            }
        }
        super.m8092a();
    }

    @OnClick({C2113R.id.iv_back, C2113R.id.tv_shizhu_detial, C2113R.id.tv_case_account_detial, C2113R.id.tv_criminal_call_detial, C2113R.id.tv_criminal_recharge_detial, C2113R.id.tv_criminal_relation_detial, C2113R.id.tv_criminal_delivery_detial, C2113R.id.tv_criminal_sms_detial, C2113R.id.tv_criminal_net_detial, C2113R.id.tv_app_info_detial, C2113R.id.tv_websit_info_detial, C2113R.id.tv_stop_payment, C2113R.id.btn_back, C2113R.id.btn_submit})
    public final void onClick(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case C2113R.id.btn_back /* 2131296392 */:
                CaseHistoryPresenter caseHistoryPresenter = this.mPreenter;
                if (caseHistoryPresenter != null) {
                    caseHistoryPresenter.returnCase(this.caseInfoId);
                    break;
                }
                break;
            case C2113R.id.btn_submit /* 2131296406 */:
                submit();
                break;
            case C2113R.id.iv_back /* 2131296762 */:
                m8092a();
                break;
            case C2113R.id.tv_app_info_detial /* 2131297417 */:
                if (this.appCount > 0) {
                    Intent intent = new Intent(this.mActivity, (Class<?>) SignCommitAppActivity.class);
                    intent.putExtra(C7292k1.f25338C0, this.caseInfoId);
                    intent.putExtra(C7292k1.f25394d, true);
                    startActivity(intent);
                    break;
                }
                break;
            case C2113R.id.tv_case_account_detial /* 2131297451 */:
                if (this.paymentCount > 0) {
                    goChildPage(AccountListPreviewActivity.class);
                    break;
                }
                break;
            case C2113R.id.tv_criminal_call_detial /* 2131297497 */:
                if (this.callTelCount > 0) {
                    Intent intent2 = new Intent(this.mActivity, (Class<?>) SignCallActivity.class);
                    intent2.putExtra(C7292k1.f25338C0, this.caseInfoId);
                    startActivity(intent2);
                    break;
                }
                break;
            case C2113R.id.tv_criminal_delivery_detial /* 2131297499 */:
                if (this.mailingTelCount > 0) {
                    Intent intent3 = new Intent(this.mActivity, (Class<?>) SignDeliveryActivity.class);
                    intent3.putExtra(C7292k1.f25338C0, this.caseInfoId);
                    startActivity(intent3);
                    break;
                }
                break;
            case C2113R.id.tv_criminal_net_detial /* 2131297501 */:
                if (this.netAccountCount > 0) {
                    Intent intent4 = new Intent(this.mActivity, (Class<?>) CriminalSocialActivity.class);
                    intent4.putExtra(C7292k1.f25338C0, this.caseInfoId);
                    intent4.putExtra(C7292k1.f25394d, true);
                    startActivity(intent4);
                    break;
                }
                break;
            case C2113R.id.tv_criminal_recharge_detial /* 2131297503 */:
                if (this.chargeTelCount > 0) {
                    Intent intent5 = new Intent(this.mActivity, (Class<?>) SignReChargeActivity.class);
                    intent5.putExtra(C7292k1.f25338C0, this.caseInfoId);
                    startActivity(intent5);
                    break;
                }
                break;
            case C2113R.id.tv_criminal_relation_detial /* 2131297505 */:
                if (this.linkTelCount > 0) {
                    Intent intent6 = new Intent(this.mActivity, (Class<?>) SignRelationActivity.class);
                    intent6.putExtra(C7292k1.f25338C0, this.caseInfoId);
                    startActivity(intent6);
                    break;
                }
                break;
            case C2113R.id.tv_criminal_sms_detial /* 2131297507 */:
                if (this.smsCount > 0) {
                    Intent intent7 = new Intent(this.mActivity, (Class<?>) CriminalSmsActivity.class);
                    intent7.putExtra(C7292k1.f25338C0, this.caseInfoId);
                    intent7.putExtra(C7292k1.f25394d, true);
                    startActivity(intent7);
                    break;
                }
                break;
            case C2113R.id.tv_shizhu_detial /* 2131297707 */:
                if (this.victimCount > 0) {
                    goChildPage(SignCommitVictimActivity.class);
                    break;
                }
                break;
            case C2113R.id.tv_stop_payment /* 2131297727 */:
                Intent intent8 = new Intent(this.mActivity, (Class<?>) PayStopListActivity.class);
                intent8.putExtra(C7292k1.f25338C0, this.caseInfoId);
                intent8.putExtra(C7292k1.f25391c, (Serializable) this.mAccountList);
                intent8.putExtra(C7292k1.f25388b, (Serializable) this.mAccountAutoList);
                startActivity(intent8);
                break;
            case C2113R.id.tv_websit_info_detial /* 2131297815 */:
                if (this.urlCount > 0) {
                    goChildPage(SignCommitWebsiteActivity.class);
                    break;
                }
                break;
        }
    }

    @Override // p388ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C6049c.m24987f().m25003g(this);
    }

    @InterfaceC6059m(threadMode = ThreadMode.MAIN)
    public final void onEvent(@InterfaceC5817e C7265a c7265a) {
        if (c7265a != null) {
            int m26297a = c7265a.m26297a();
            if (m26297a != 303) {
                if (m26297a != 304) {
                    return;
                }
                Object m26300b = c7265a.m26300b();
                if (m26300b == null) {
                    throw new C5226e1("null cannot be cast to non-null type kotlin.collections.List<bean.AccountListBean>");
                }
                this.mAccountAutoList = (List) m26300b;
                return;
            }
            Object m26300b2 = c7265a.m26300b();
            if (m26300b2 == null) {
                throw new C5226e1("null cannot be cast to non-null type kotlin.collections.List<bean.AccountListBean>");
            }
            List<? extends AccountListBean> list = (List) m26300b2;
            this.mAccountList = list;
            RegionMudelBean m16408j = C4440a.m16408j();
            if (m16408j == null || !TextUtils.equals(m16408j.getStopPayment(), "1")) {
                LinearLayout linearLayout = this.mLlStopPayment;
                if (linearLayout == null) {
                    C5544i0.m22554k("mLlStopPayment");
                }
                linearLayout.setVisibility(8);
                LinearLayout linearLayout2 = this.mLlStopPaymentContent;
                if (linearLayout2 == null) {
                    C5544i0.m22554k("mLlStopPaymentContent");
                }
                linearLayout2.setVisibility(8);
                return;
            }
            LinearLayout linearLayout3 = this.mLlStopPayment;
            if (linearLayout3 == null) {
                C5544i0.m22554k("mLlStopPayment");
            }
            linearLayout3.setVisibility(0);
            LinearLayout linearLayout4 = this.mLlStopPaymentContent;
            if (linearLayout4 == null) {
                C5544i0.m22554k("mLlStopPaymentContent");
            }
            linearLayout4.setVisibility(0);
            if (list == null || list.size() <= 0) {
                TextView textView = this.mTvStopPaymentNum;
                if (textView == null) {
                    C5544i0.m22554k("mTvStopPaymentNum");
                }
                textView.setText("添加");
                TextView textView2 = this.mTvStopPaymentNum;
                if (textView2 == null) {
                    C5544i0.m22554k("mTvStopPaymentNum");
                }
                textView2.setTextColor(getResources().getColor(C2113R.color._2B4CFF));
                return;
            }
            TextView textView3 = this.mTvStopPaymentNum;
            if (textView3 == null) {
                C5544i0.m22554k("mTvStopPaymentNum");
            }
            textView3.setText("" + list.size() + "个");
            TextView textView4 = this.mTvStopPaymentNum;
            if (textView4 == null) {
                C5544i0.m22554k("mTvStopPaymentNum");
            }
            textView4.setTextColor(getResources().getColor(C2113R.color.black_dark));
        }
    }

    @Override // p388ui.callview.CaseHistoryCallView
    public void onSuccessBack() {
        C6049c.m24987f().m24999c(new C7265a(204, null));
        finish();
    }

    @Override // p388ui.callview.CaseHistoryCallView
    public void onSuccessCommit() {
        C6049c.m24987f().m24999c(new C7265a(205, null));
        finish();
    }

    @Override // p388ui.callview.CaseHistoryCallView
    public void onSuccessDetail(@InterfaceC5816d CaseDetailBean caseDetailBean) {
        C5544i0.m22546f(caseDetailBean, "result");
        initView(caseDetailBean);
    }

    public final void setAppCount(int i2) {
        this.appCount = i2;
    }

    public final void setBitmap(@InterfaceC5817e Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public final void setCallTelCount(int i2) {
        this.callTelCount = i2;
    }

    public final void setCaseInfoId(@InterfaceC5816d String str) {
        C5544i0.m22546f(str, "<set-?>");
        this.caseInfoId = str;
    }

    public final void setChargeTelCount(int i2) {
        this.chargeTelCount = i2;
    }

    @Override // p388ui.activity.BaseActivity
    public int setLayoutView() {
        return C2113R.layout.activity_case_history;
    }

    public final void setLinkTelCount(int i2) {
        this.linkTelCount = i2;
    }

    public final void setMAccountAutoList(@InterfaceC5817e List<? extends AccountListBean> list) {
        this.mAccountAutoList = list;
    }

    public final void setMAccountList(@InterfaceC5817e List<? extends AccountListBean> list) {
        this.mAccountList = list;
    }

    public final void setMIvAccount(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvAccount = imageView;
    }

    public final void setMIvApp(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvApp = imageView;
    }

    public final void setMIvBack(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMIvCall(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvCall = imageView;
    }

    public final void setMIvDelivery(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvDelivery = imageView;
    }

    public final void setMIvNet(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvNet = imageView;
    }

    public final void setMIvRecharge(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvRecharge = imageView;
    }

    public final void setMIvRelation(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvRelation = imageView;
    }

    public final void setMIvSignImg(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvSignImg = imageView;
    }

    public final void setMIvSms(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvSms = imageView;
    }

    public final void setMIvStatusTag(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvStatusTag = imageView;
    }

    public final void setMIvStopPayment(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvStopPayment = imageView;
    }

    public final void setMIvVictim(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvVictim = imageView;
    }

    public final void setMIvWebsite(@InterfaceC5816d ImageView imageView) {
        C5544i0.m22546f(imageView, "<set-?>");
        this.mIvWebsite = imageView;
    }

    public final void setMLlApp(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlApp = view;
    }

    public final void setMLlCall(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlCall = view;
    }

    public final void setMLlCriminalCall(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlCriminalCall = view;
    }

    public final void setMLlCriminalNet(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlCriminalNet = view;
    }

    public final void setMLlDeal(@InterfaceC5816d LinearLayout linearLayout) {
        C5544i0.m22546f(linearLayout, "<set-?>");
        this.mLlDeal = linearLayout;
    }

    public final void setMLlDelivery(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlDelivery = view;
    }

    public final void setMLlNet(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlNet = view;
    }

    public final void setMLlRecharge(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlRecharge = view;
    }

    public final void setMLlRelation(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlRelation = view;
    }

    public final void setMLlReply(@InterfaceC5816d LinearLayout linearLayout) {
        C5544i0.m22546f(linearLayout, "<set-?>");
        this.mLlReply = linearLayout;
    }

    public final void setMLlSms(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlSms = view;
    }

    public final void setMLlStopPayment(@InterfaceC5816d LinearLayout linearLayout) {
        C5544i0.m22546f(linearLayout, "<set-?>");
        this.mLlStopPayment = linearLayout;
    }

    public final void setMLlStopPaymentContent(@InterfaceC5816d LinearLayout linearLayout) {
        C5544i0.m22546f(linearLayout, "<set-?>");
        this.mLlStopPaymentContent = linearLayout;
    }

    public final void setMLlWebsit(@InterfaceC5816d View view) {
        C5544i0.m22546f(view, "<set-?>");
        this.mLlWebsit = view;
    }

    public final void setMPreenter(@InterfaceC5817e CaseHistoryPresenter caseHistoryPresenter) {
        this.mPreenter = caseHistoryPresenter;
    }

    public final void setMRecyclerViewReply(@InterfaceC5816d RecyclerView recyclerView) {
        C5544i0.m22546f(recyclerView, "<set-?>");
        this.mRecyclerViewReply = recyclerView;
    }

    public final void setMReplyList(@InterfaceC5817e List<? extends ReplyBean> list) {
        this.mReplyList = list;
    }

    public final void setMTvAppNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvAppNum = textView;
    }

    public final void setMTvCaseAccNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCaseAccNum = textView;
    }

    public final void setMTvCaseName(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCaseName = textView;
    }

    public final void setMTvCaseNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCaseNum = textView;
    }

    public final void setMTvCaseTime(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCaseTime = textView;
    }

    public final void setMTvCriminalCallNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCriminalCallNum = textView;
    }

    public final void setMTvCriminalDelivery(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCriminalDelivery = textView;
    }

    public final void setMTvCriminalNet(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCriminalNet = textView;
    }

    public final void setMTvCriminalRecharge(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCriminalRecharge = textView;
    }

    public final void setMTvCriminalRelation(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCriminalRelation = textView;
    }

    public final void setMTvCriminalSms(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvCriminalSms = textView;
    }

    public final void setMTvPolicNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvPolicNum = textView;
    }

    public final void setMTvSZNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvSZNum = textView;
    }

    public final void setMTvStopPaymentNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvStopPaymentNum = textView;
    }

    public final void setMTvTitle(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setMTvWebsitNum(@InterfaceC5816d TextView textView) {
        C5544i0.m22546f(textView, "<set-?>");
        this.mTvWebsitNum = textView;
    }

    public final void setMailingTelCount(int i2) {
        this.mailingTelCount = i2;
    }

    public final void setNetAccountCount(int i2) {
        this.netAccountCount = i2;
    }

    public final void setPaymentCount(int i2) {
        this.paymentCount = i2;
    }

    public final void setResult(@InterfaceC5817e CaseDetailBean caseDetailBean) {
        this.result = caseDetailBean;
    }

    public final void setSmsCount(int i2) {
        this.smsCount = i2;
    }

    public final void setStopPaymentCount(int i2) {
        this.stopPaymentCount = i2;
    }

    public final void setUrlCount(int i2) {
        this.urlCount = i2;
    }

    public final void setVictimCount(int i2) {
        this.victimCount = i2;
    }

    public final void submit() {
        LinearLayout linearLayout = this.mLlStopPayment;
        if (linearLayout == null) {
            C5544i0.m22554k("mLlStopPayment");
        }
        if (linearLayout.getVisibility() == 8) {
            CaseHistoryPresenter caseHistoryPresenter = this.mPreenter;
            if (caseHistoryPresenter != null) {
                caseHistoryPresenter.submitCase(this.caseInfoId, null);
                return;
            }
            return;
        }
        List<? extends AccountListBean> list = this.mAccountList;
        if (list != null) {
            if (list == null) {
                C5544i0.m22545f();
            }
            if (list.size() > 0) {
                Intent intent = new Intent(this.mActivity, (Class<?>) CaseVerifyActivity.class);
                intent.putExtra(C7292k1.f25338C0, this.caseInfoId);
                intent.putExtra(C7292k1.f25391c, (Serializable) this.mAccountList);
                startActivityForResult(intent, 100);
                return;
            }
        }
        C7257b1.m26184a(this.mActivity, "是否添加止付信息？", "", "提交案件", "去添加", -1, -1, true, (IClickListener) new C6192b());
    }
}
