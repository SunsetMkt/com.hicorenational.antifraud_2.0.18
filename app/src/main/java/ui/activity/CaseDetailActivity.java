package ui.activity;

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
import com.hicorenational.antifraud.R;
import i.y1;
import interfaces.IClickListener;
import java.io.Serializable;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;
import ui.callview.CaseHistoryCallView;
import ui.presenter.CaseHistoryPresenter;
import ui.view.swip.SwipBackLayout;
import util.e2;

/* JADX INFO: compiled from: CaseDetailActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.y(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b;\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u00e4\u0001\u001a\u00030\u00e5\u00012\u000e\u0010\u00e6\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u00e7\u0001J\n\u0010\u00e8\u0001\u001a\u00030\u00e5\u0001H\u0016J\u0012\u0010\u00e9\u0001\u001a\u00030\u00e5\u00012\b\u0010\u00d2\u0001\u001a\u00030\u00d3\u0001J(\u0010\u00ea\u0001\u001a\u00030\u00e5\u00012\u0007\u0010\u00eb\u0001\u001a\u00020\u00052\u0007\u0010\u00ec\u0001\u001a\u00020\u00052\n\u0010\u00ed\u0001\u001a\u0005\u0018\u00010\u00ee\u0001H\u0014J\n\u0010\u00ef\u0001\u001a\u00030\u00e5\u0001H\u0016J\u0013\u0010\u00f0\u0001\u001a\u00030\u00e5\u00012\u0007\u0010\u00f1\u0001\u001a\u00020WH\u0007J\n\u0010\u00f2\u0001\u001a\u00030\u00e5\u0001H\u0014J\u0016\u0010\u00f3\u0001\u001a\u00030\u00e5\u00012\n\u0010\u00f4\u0001\u001a\u0005\u0018\u00010\u00f5\u0001H\u0007J\n\u0010\u00f6\u0001\u001a\u00030\u00e5\u0001H\u0016J\n\u0010\u00f7\u0001\u001a\u00030\u00e5\u0001H\u0016J\u0014\u0010\u00f8\u0001\u001a\u00030\u00e5\u00012\b\u0010\u00d2\u0001\u001a\u00030\u00d3\u0001H\u0016J\t\u0010\u00f9\u0001\u001a\u00020\u0005H\u0016J\b\u0010\u00fa\u0001\u001a\u00030\u00e5\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001e\u0010)\u001a\u00020*8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u00020*8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\u001e\u00102\u001a\u00020*8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010,\"\u0004\b4\u0010.R\u001e\u00105\u001a\u00020*8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010,\"\u0004\b7\u0010.R\u001e\u00108\u001a\u00020*8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010,\"\u0004\b:\u0010.R\u001e\u0010;\u001a\u00020*8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010,\"\u0004\b=\u0010.R\u001e\u0010>\u001a\u00020*8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010,\"\u0004\b@\u0010.R\u001e\u0010A\u001a\u00020*8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010,\"\u0004\bC\u0010.R\u001e\u0010D\u001a\u00020*8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010,\"\u0004\bF\u0010.R\u001e\u0010G\u001a\u00020*8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010,\"\u0004\bI\u0010.R\u001e\u0010J\u001a\u00020*8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010,\"\u0004\bL\u0010.R\u001e\u0010M\u001a\u00020*8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010,\"\u0004\bO\u0010.R\u001e\u0010P\u001a\u00020*8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010,\"\u0004\bR\u0010.R\u001e\u0010S\u001a\u00020*8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010,\"\u0004\bU\u0010.R\u001e\u0010V\u001a\u00020W8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001e\u0010\\\u001a\u00020W8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u0010Y\"\u0004\b^\u0010[R\u001e\u0010_\u001a\u00020W8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010Y\"\u0004\ba\u0010[R\u001e\u0010b\u001a\u00020W8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u0010Y\"\u0004\bd\u0010[R\u001e\u0010e\u001a\u00020f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001e\u0010k\u001a\u00020W8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u0010Y\"\u0004\bm\u0010[R\u001e\u0010n\u001a\u00020W8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u0010Y\"\u0004\bp\u0010[R\u001e\u0010q\u001a\u00020W8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\br\u0010Y\"\u0004\bs\u0010[R\u001e\u0010t\u001a\u00020W8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bu\u0010Y\"\u0004\bv\u0010[R\u001e\u0010w\u001a\u00020f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bx\u0010h\"\u0004\by\u0010jR\u001e\u0010z\u001a\u00020W8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b{\u0010Y\"\u0004\b|\u0010[R\u001e\u0010}\u001a\u00020f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b~\u0010h\"\u0004\b\u007f\u0010jR!\u0010\u0080\u0001\u001a\u00020f8\u0006@\u0006X\u0087.\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010h\"\u0005\b\u0082\u0001\u0010jR!\u0010\u0083\u0001\u001a\u00020W8\u0006@\u0006X\u0087.\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010Y\"\u0005\b\u0085\u0001\u0010[R\"\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R$\u0010\u008c\u0001\u001a\u00030\u008d\u00018\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R&\u0010\u0092\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0093\u0001\u0018\u00010 X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0094\u0001\u0010#\"\u0005\b\u0095\u0001\u0010%R$\u0010\u0096\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001R$\u0010\u009c\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u009d\u0001\u0010\u0099\u0001\"\u0006\b\u009e\u0001\u0010\u009b\u0001R$\u0010\u009f\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00a0\u0001\u0010\u0099\u0001\"\u0006\b\u00a1\u0001\u0010\u009b\u0001R$\u0010\u00a2\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00a3\u0001\u0010\u0099\u0001\"\u0006\b\u00a4\u0001\u0010\u009b\u0001R$\u0010\u00a5\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00a6\u0001\u0010\u0099\u0001\"\u0006\b\u00a7\u0001\u0010\u009b\u0001R$\u0010\u00a8\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00a9\u0001\u0010\u0099\u0001\"\u0006\b\u00aa\u0001\u0010\u009b\u0001R$\u0010\u00ab\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00ac\u0001\u0010\u0099\u0001\"\u0006\b\u00ad\u0001\u0010\u009b\u0001R$\u0010\u00ae\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00af\u0001\u0010\u0099\u0001\"\u0006\b\u00b0\u0001\u0010\u009b\u0001R$\u0010\u00b1\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00b2\u0001\u0010\u0099\u0001\"\u0006\b\u00b3\u0001\u0010\u009b\u0001R$\u0010\u00b4\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00b5\u0001\u0010\u0099\u0001\"\u0006\b\u00b6\u0001\u0010\u009b\u0001R$\u0010\u00b7\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00b8\u0001\u0010\u0099\u0001\"\u0006\b\u00b9\u0001\u0010\u009b\u0001R$\u0010\u00ba\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00bb\u0001\u0010\u0099\u0001\"\u0006\b\u00bc\u0001\u0010\u009b\u0001R$\u0010\u00bd\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00be\u0001\u0010\u0099\u0001\"\u0006\b\u00bf\u0001\u0010\u009b\u0001R$\u0010\u00c0\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00c1\u0001\u0010\u0099\u0001\"\u0006\b\u00c2\u0001\u0010\u009b\u0001R$\u0010\u00c3\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00c4\u0001\u0010\u0099\u0001\"\u0006\b\u00c5\u0001\u0010\u009b\u0001R$\u0010\u00c6\u0001\u001a\u00030\u0097\u00018\u0006@\u0006X\u0087.\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00c7\u0001\u0010\u0099\u0001\"\u0006\b\u00c8\u0001\u0010\u009b\u0001R\u001d\u0010\u00c9\u0001\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00ca\u0001\u0010\u0007\"\u0005\b\u00cb\u0001\u0010\tR\u001d\u0010\u00cc\u0001\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00cd\u0001\u0010\u0007\"\u0005\b\u00ce\u0001\u0010\tR\u001d\u0010\u00cf\u0001\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d0\u0001\u0010\u0007\"\u0005\b\u00d1\u0001\u0010\tR\"\u0010\u00d2\u0001\u001a\u0005\u0018\u00010\u00d3\u0001X\u0086\u000e\u00a2\u0006\u0012\n\u0000\u001a\u0006\b\u00d4\u0001\u0010\u00d5\u0001\"\u0006\b\u00d6\u0001\u0010\u00d7\u0001R\u001d\u0010\u00d8\u0001\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00d9\u0001\u0010\u0007\"\u0005\b\u00da\u0001\u0010\tR\u001d\u0010\u00db\u0001\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00dc\u0001\u0010\u0007\"\u0005\b\u00dd\u0001\u0010\tR\u001d\u0010\u00de\u0001\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00df\u0001\u0010\u0007\"\u0005\b\u00e0\u0001\u0010\tR\u001d\u0010\u00e1\u0001\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u00e2\u0001\u0010\u0007\"\u0005\b\u00e3\u0001\u0010\t\u00a8\u0006\u00fb\u0001"}, d2 = {"Lui/activity/CaseDetailActivity;", "Lui/activity/BaseActivity;", "Lui/callview/CaseHistoryCallView;", "()V", "appCount", "", "getAppCount", "()I", "setAppCount", "(I)V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "callTelCount", "getCallTelCount", "setCallTelCount", "caseInfoId", "", "getCaseInfoId", "()Ljava/lang/String;", "setCaseInfoId", "(Ljava/lang/String;)V", "chargeTelCount", "getChargeTelCount", "setChargeTelCount", "linkTelCount", "getLinkTelCount", "setLinkTelCount", "mAccountAutoList", "", "Lbean/AccountListBean;", "getMAccountAutoList", "()Ljava/util/List;", "setMAccountAutoList", "(Ljava/util/List;)V", "mAccountList", "getMAccountList", "setMAccountList", "mIvAccount", "Landroid/widget/ImageView;", "getMIvAccount", "()Landroid/widget/ImageView;", "setMIvAccount", "(Landroid/widget/ImageView;)V", "mIvApp", "getMIvApp", "setMIvApp", "mIvBack", "getMIvBack", "setMIvBack", "mIvCall", "getMIvCall", "setMIvCall", "mIvDelivery", "getMIvDelivery", "setMIvDelivery", "mIvNet", "getMIvNet", "setMIvNet", "mIvRecharge", "getMIvRecharge", "setMIvRecharge", "mIvRelation", "getMIvRelation", "setMIvRelation", "mIvSignImg", "getMIvSignImg", "setMIvSignImg", "mIvSms", "getMIvSms", "setMIvSms", "mIvStatusTag", "getMIvStatusTag", "setMIvStatusTag", "mIvStopPayment", "getMIvStopPayment", "setMIvStopPayment", "mIvVictim", "getMIvVictim", "setMIvVictim", "mIvWebsite", "getMIvWebsite", "setMIvWebsite", "mLlApp", "Landroid/view/View;", "getMLlApp", "()Landroid/view/View;", "setMLlApp", "(Landroid/view/View;)V", "mLlCall", "getMLlCall", "setMLlCall", "mLlCriminalCall", "getMLlCriminalCall", "setMLlCriminalCall", "mLlCriminalNet", "getMLlCriminalNet", "setMLlCriminalNet", "mLlDeal", "Landroid/widget/LinearLayout;", "getMLlDeal", "()Landroid/widget/LinearLayout;", "setMLlDeal", "(Landroid/widget/LinearLayout;)V", "mLlDelivery", "getMLlDelivery", "setMLlDelivery", "mLlNet", "getMLlNet", "setMLlNet", "mLlRecharge", "getMLlRecharge", "setMLlRecharge", "mLlRelation", "getMLlRelation", "setMLlRelation", "mLlReply", "getMLlReply", "setMLlReply", "mLlSms", "getMLlSms", "setMLlSms", "mLlStopPayment", "getMLlStopPayment", "setMLlStopPayment", "mLlStopPaymentContent", "getMLlStopPaymentContent", "setMLlStopPaymentContent", "mLlWebsit", "getMLlWebsit", "setMLlWebsit", "mPreenter", "Lui/presenter/CaseHistoryPresenter;", "getMPreenter", "()Lui/presenter/CaseHistoryPresenter;", "setMPreenter", "(Lui/presenter/CaseHistoryPresenter;)V", "mRecyclerViewReply", "Landroidx/recyclerview/widget/RecyclerView;", "getMRecyclerViewReply", "()Landroidx/recyclerview/widget/RecyclerView;", "setMRecyclerViewReply", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mReplyList", "Lbean/ReplyBean;", "getMReplyList", "setMReplyList", "mTvAppNum", "Landroid/widget/TextView;", "getMTvAppNum", "()Landroid/widget/TextView;", "setMTvAppNum", "(Landroid/widget/TextView;)V", "mTvCaseAccNum", "getMTvCaseAccNum", "setMTvCaseAccNum", "mTvCaseName", "getMTvCaseName", "setMTvCaseName", "mTvCaseNum", "getMTvCaseNum", "setMTvCaseNum", "mTvCaseTime", "getMTvCaseTime", "setMTvCaseTime", "mTvCriminalCallNum", "getMTvCriminalCallNum", "setMTvCriminalCallNum", "mTvCriminalDelivery", "getMTvCriminalDelivery", "setMTvCriminalDelivery", "mTvCriminalNet", "getMTvCriminalNet", "setMTvCriminalNet", "mTvCriminalRecharge", "getMTvCriminalRecharge", "setMTvCriminalRecharge", "mTvCriminalRelation", "getMTvCriminalRelation", "setMTvCriminalRelation", "mTvCriminalSms", "getMTvCriminalSms", "setMTvCriminalSms", "mTvPolicNum", "getMTvPolicNum", "setMTvPolicNum", "mTvSZNum", "getMTvSZNum", "setMTvSZNum", "mTvStopPaymentNum", "getMTvStopPaymentNum", "setMTvStopPaymentNum", "mTvTitle", "getMTvTitle", "setMTvTitle", "mTvWebsitNum", "getMTvWebsitNum", "setMTvWebsitNum", "mailingTelCount", "getMailingTelCount", "setMailingTelCount", "netAccountCount", "getNetAccountCount", "setNetAccountCount", "paymentCount", "getPaymentCount", "setPaymentCount", "result", "Lbean/CaseDetailBean;", "getResult", "()Lbean/CaseDetailBean;", "setResult", "(Lbean/CaseDetailBean;)V", "smsCount", "getSmsCount", "setSmsCount", "stopPaymentCount", "getStopPaymentCount", "setStopPaymentCount", "urlCount", "getUrlCount", "setUrlCount", "victimCount", "getVictimCount", "setVictimCount", "goChildPage", "", "cls", "Ljava/lang/Class;", "initPage", "initView", "onActivityResult", "requestCode", com.taobao.agoo.a.a.b.JSON_ERRORCODE, "data", "Landroid/content/Intent;", "onBackPressed", "onClick", "view", "onDestroy", "onEvent", "refreshUIEvent", "Lutil/event/RefreshUIEvent;", "onSuccessBack", "onSuccessCommit", "onSuccessDetail", "setLayoutView", "submit", "app_offic_flavorRelease"}, k = 1, mv = {1, 1, 16})
public final class CaseDetailActivity extends BaseActivity implements CaseHistoryCallView {
    private int appCount;

    @j.c.a.e
    private Bitmap bitmap;
    private int callTelCount;

    @j.c.a.d
    private String caseInfoId = "";
    private int chargeTelCount;
    private int linkTelCount;

    @j.c.a.e
    private List<? extends AccountListBean> mAccountAutoList;

    @j.c.a.e
    private List<? extends AccountListBean> mAccountList;

    @BindView(R.id.iv_account)
    @j.c.a.d
    public ImageView mIvAccount;

    @BindView(R.id.iv_app)
    @j.c.a.d
    public ImageView mIvApp;

    @BindView(R.id.iv_back)
    @j.c.a.d
    public ImageView mIvBack;

    @BindView(R.id.iv_call)
    @j.c.a.d
    public ImageView mIvCall;

    @BindView(R.id.iv_delivery)
    @j.c.a.d
    public ImageView mIvDelivery;

    @BindView(R.id.iv_net)
    @j.c.a.d
    public ImageView mIvNet;

    @BindView(R.id.iv_recharge)
    @j.c.a.d
    public ImageView mIvRecharge;

    @BindView(R.id.iv_relation)
    @j.c.a.d
    public ImageView mIvRelation;

    @BindView(R.id.iv_repter_sign)
    @j.c.a.d
    public ImageView mIvSignImg;

    @BindView(R.id.iv_sms)
    @j.c.a.d
    public ImageView mIvSms;

    @BindView(R.id.iv_status_tag)
    @j.c.a.d
    public ImageView mIvStatusTag;

    @BindView(R.id.iv_stop_payment)
    @j.c.a.d
    public ImageView mIvStopPayment;

    @BindView(R.id.iv_victim)
    @j.c.a.d
    public ImageView mIvVictim;

    @BindView(R.id.iv_website)
    @j.c.a.d
    public ImageView mIvWebsite;

    @BindView(R.id.ll_app)
    @j.c.a.d
    public View mLlApp;

    @BindView(R.id.ll_call)
    @j.c.a.d
    public View mLlCall;

    @BindView(R.id.ll_criminal_call)
    @j.c.a.d
    public View mLlCriminalCall;

    @BindView(R.id.ll_criminal_net)
    @j.c.a.d
    public View mLlCriminalNet;

    @BindView(R.id.ll_deal)
    @j.c.a.d
    public LinearLayout mLlDeal;

    @BindView(R.id.ll_delivery)
    @j.c.a.d
    public View mLlDelivery;

    @BindView(R.id.ll_net)
    @j.c.a.d
    public View mLlNet;

    @BindView(R.id.ll_recharge)
    @j.c.a.d
    public View mLlRecharge;

    @BindView(R.id.ll_relation)
    @j.c.a.d
    public View mLlRelation;

    @BindView(R.id.ll_reply)
    @j.c.a.d
    public LinearLayout mLlReply;

    @BindView(R.id.ll_sms)
    @j.c.a.d
    public View mLlSms;

    @BindView(R.id.ll_stop_payment)
    @j.c.a.d
    public LinearLayout mLlStopPayment;

    @BindView(R.id.ll_stop_payment_content)
    @j.c.a.d
    public LinearLayout mLlStopPaymentContent;

    @BindView(R.id.ll_websit)
    @j.c.a.d
    public View mLlWebsit;

    @j.c.a.e
    private CaseHistoryPresenter mPreenter;

    @BindView(R.id.recyclerview_reply)
    @j.c.a.d
    public RecyclerView mRecyclerViewReply;

    @j.c.a.e
    private List<? extends ReplyBean> mReplyList;

    @BindView(R.id.tv_app_info_detial)
    @j.c.a.d
    public TextView mTvAppNum;

    @BindView(R.id.tv_case_account_detial)
    @j.c.a.d
    public TextView mTvCaseAccNum;

    @BindView(R.id.tv_case_name)
    @j.c.a.d
    public TextView mTvCaseName;

    @BindView(R.id.case_num)
    @j.c.a.d
    public TextView mTvCaseNum;

    @BindView(R.id.case_time)
    @j.c.a.d
    public TextView mTvCaseTime;

    @BindView(R.id.tv_criminal_call_detial)
    @j.c.a.d
    public TextView mTvCriminalCallNum;

    @BindView(R.id.tv_criminal_delivery_detial)
    @j.c.a.d
    public TextView mTvCriminalDelivery;

    @BindView(R.id.tv_criminal_net_detial)
    @j.c.a.d
    public TextView mTvCriminalNet;

    @BindView(R.id.tv_criminal_recharge_detial)
    @j.c.a.d
    public TextView mTvCriminalRecharge;

    @BindView(R.id.tv_criminal_relation_detial)
    @j.c.a.d
    public TextView mTvCriminalRelation;

    @BindView(R.id.tv_criminal_sms_detial)
    @j.c.a.d
    public TextView mTvCriminalSms;

    @BindView(R.id.polic_num)
    @j.c.a.d
    public TextView mTvPolicNum;

    @BindView(R.id.tv_shizhu_detial)
    @j.c.a.d
    public TextView mTvSZNum;

    @BindView(R.id.tv_stop_payment)
    @j.c.a.d
    public TextView mTvStopPaymentNum;

    @BindView(R.id.tv_title)
    @j.c.a.d
    public TextView mTvTitle;

    @BindView(R.id.tv_websit_info_detial)
    @j.c.a.d
    public TextView mTvWebsitNum;
    private int mailingTelCount;
    private int netAccountCount;
    private int paymentCount;

    @j.c.a.e
    private CaseDetailBean result;
    private int smsCount;
    private int stopPaymentCount;
    private int urlCount;
    private int victimCount;

    /* JADX INFO: compiled from: CaseDetailActivity.kt */
    public static final class a implements IClickListener {
        a() {
        }

        @Override // interfaces.IClickListener
        public void cancelBtn() {
        }

        @Override // interfaces.IClickListener
        public void clickOKBtn() {
            CaseDetailActivity.this.finish();
        }
    }

    /* JADX INFO: compiled from: CaseDetailActivity.kt */
    public static final class b implements IClickListener {
        b() {
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

    @j.c.a.e
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final int getCallTelCount() {
        return this.callTelCount;
    }

    @j.c.a.d
    public final String getCaseInfoId() {
        return this.caseInfoId;
    }

    public final int getChargeTelCount() {
        return this.chargeTelCount;
    }

    public final int getLinkTelCount() {
        return this.linkTelCount;
    }

    @j.c.a.e
    public final List<AccountListBean> getMAccountAutoList() {
        return this.mAccountAutoList;
    }

    @j.c.a.e
    public final List<AccountListBean> getMAccountList() {
        return this.mAccountList;
    }

    @j.c.a.d
    public final ImageView getMIvAccount() {
        ImageView imageView = this.mIvAccount;
        if (imageView == null) {
            i.q2.t.i0.k("mIvAccount");
        }
        return imageView;
    }

    @j.c.a.d
    public final ImageView getMIvApp() {
        ImageView imageView = this.mIvApp;
        if (imageView == null) {
            i.q2.t.i0.k("mIvApp");
        }
        return imageView;
    }

    @j.c.a.d
    public final ImageView getMIvBack() {
        ImageView imageView = this.mIvBack;
        if (imageView == null) {
            i.q2.t.i0.k("mIvBack");
        }
        return imageView;
    }

    @j.c.a.d
    public final ImageView getMIvCall() {
        ImageView imageView = this.mIvCall;
        if (imageView == null) {
            i.q2.t.i0.k("mIvCall");
        }
        return imageView;
    }

    @j.c.a.d
    public final ImageView getMIvDelivery() {
        ImageView imageView = this.mIvDelivery;
        if (imageView == null) {
            i.q2.t.i0.k("mIvDelivery");
        }
        return imageView;
    }

    @j.c.a.d
    public final ImageView getMIvNet() {
        ImageView imageView = this.mIvNet;
        if (imageView == null) {
            i.q2.t.i0.k("mIvNet");
        }
        return imageView;
    }

    @j.c.a.d
    public final ImageView getMIvRecharge() {
        ImageView imageView = this.mIvRecharge;
        if (imageView == null) {
            i.q2.t.i0.k("mIvRecharge");
        }
        return imageView;
    }

    @j.c.a.d
    public final ImageView getMIvRelation() {
        ImageView imageView = this.mIvRelation;
        if (imageView == null) {
            i.q2.t.i0.k("mIvRelation");
        }
        return imageView;
    }

    @j.c.a.d
    public final ImageView getMIvSignImg() {
        ImageView imageView = this.mIvSignImg;
        if (imageView == null) {
            i.q2.t.i0.k("mIvSignImg");
        }
        return imageView;
    }

    @j.c.a.d
    public final ImageView getMIvSms() {
        ImageView imageView = this.mIvSms;
        if (imageView == null) {
            i.q2.t.i0.k("mIvSms");
        }
        return imageView;
    }

    @j.c.a.d
    public final ImageView getMIvStatusTag() {
        ImageView imageView = this.mIvStatusTag;
        if (imageView == null) {
            i.q2.t.i0.k("mIvStatusTag");
        }
        return imageView;
    }

    @j.c.a.d
    public final ImageView getMIvStopPayment() {
        ImageView imageView = this.mIvStopPayment;
        if (imageView == null) {
            i.q2.t.i0.k("mIvStopPayment");
        }
        return imageView;
    }

    @j.c.a.d
    public final ImageView getMIvVictim() {
        ImageView imageView = this.mIvVictim;
        if (imageView == null) {
            i.q2.t.i0.k("mIvVictim");
        }
        return imageView;
    }

    @j.c.a.d
    public final ImageView getMIvWebsite() {
        ImageView imageView = this.mIvWebsite;
        if (imageView == null) {
            i.q2.t.i0.k("mIvWebsite");
        }
        return imageView;
    }

    @j.c.a.d
    public final View getMLlApp() {
        View view = this.mLlApp;
        if (view == null) {
            i.q2.t.i0.k("mLlApp");
        }
        return view;
    }

    @j.c.a.d
    public final View getMLlCall() {
        View view = this.mLlCall;
        if (view == null) {
            i.q2.t.i0.k("mLlCall");
        }
        return view;
    }

    @j.c.a.d
    public final View getMLlCriminalCall() {
        View view = this.mLlCriminalCall;
        if (view == null) {
            i.q2.t.i0.k("mLlCriminalCall");
        }
        return view;
    }

    @j.c.a.d
    public final View getMLlCriminalNet() {
        View view = this.mLlCriminalNet;
        if (view == null) {
            i.q2.t.i0.k("mLlCriminalNet");
        }
        return view;
    }

    @j.c.a.d
    public final LinearLayout getMLlDeal() {
        LinearLayout linearLayout = this.mLlDeal;
        if (linearLayout == null) {
            i.q2.t.i0.k("mLlDeal");
        }
        return linearLayout;
    }

    @j.c.a.d
    public final View getMLlDelivery() {
        View view = this.mLlDelivery;
        if (view == null) {
            i.q2.t.i0.k("mLlDelivery");
        }
        return view;
    }

    @j.c.a.d
    public final View getMLlNet() {
        View view = this.mLlNet;
        if (view == null) {
            i.q2.t.i0.k("mLlNet");
        }
        return view;
    }

    @j.c.a.d
    public final View getMLlRecharge() {
        View view = this.mLlRecharge;
        if (view == null) {
            i.q2.t.i0.k("mLlRecharge");
        }
        return view;
    }

    @j.c.a.d
    public final View getMLlRelation() {
        View view = this.mLlRelation;
        if (view == null) {
            i.q2.t.i0.k("mLlRelation");
        }
        return view;
    }

    @j.c.a.d
    public final LinearLayout getMLlReply() {
        LinearLayout linearLayout = this.mLlReply;
        if (linearLayout == null) {
            i.q2.t.i0.k("mLlReply");
        }
        return linearLayout;
    }

    @j.c.a.d
    public final View getMLlSms() {
        View view = this.mLlSms;
        if (view == null) {
            i.q2.t.i0.k("mLlSms");
        }
        return view;
    }

    @j.c.a.d
    public final LinearLayout getMLlStopPayment() {
        LinearLayout linearLayout = this.mLlStopPayment;
        if (linearLayout == null) {
            i.q2.t.i0.k("mLlStopPayment");
        }
        return linearLayout;
    }

    @j.c.a.d
    public final LinearLayout getMLlStopPaymentContent() {
        LinearLayout linearLayout = this.mLlStopPaymentContent;
        if (linearLayout == null) {
            i.q2.t.i0.k("mLlStopPaymentContent");
        }
        return linearLayout;
    }

    @j.c.a.d
    public final View getMLlWebsit() {
        View view = this.mLlWebsit;
        if (view == null) {
            i.q2.t.i0.k("mLlWebsit");
        }
        return view;
    }

    @j.c.a.e
    public final CaseHistoryPresenter getMPreenter() {
        return this.mPreenter;
    }

    @j.c.a.d
    public final RecyclerView getMRecyclerViewReply() {
        RecyclerView recyclerView = this.mRecyclerViewReply;
        if (recyclerView == null) {
            i.q2.t.i0.k("mRecyclerViewReply");
        }
        return recyclerView;
    }

    @j.c.a.e
    public final List<ReplyBean> getMReplyList() {
        return this.mReplyList;
    }

    @j.c.a.d
    public final TextView getMTvAppNum() {
        TextView textView = this.mTvAppNum;
        if (textView == null) {
            i.q2.t.i0.k("mTvAppNum");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvCaseAccNum() {
        TextView textView = this.mTvCaseAccNum;
        if (textView == null) {
            i.q2.t.i0.k("mTvCaseAccNum");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvCaseName() {
        TextView textView = this.mTvCaseName;
        if (textView == null) {
            i.q2.t.i0.k("mTvCaseName");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvCaseNum() {
        TextView textView = this.mTvCaseNum;
        if (textView == null) {
            i.q2.t.i0.k("mTvCaseNum");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvCaseTime() {
        TextView textView = this.mTvCaseTime;
        if (textView == null) {
            i.q2.t.i0.k("mTvCaseTime");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvCriminalCallNum() {
        TextView textView = this.mTvCriminalCallNum;
        if (textView == null) {
            i.q2.t.i0.k("mTvCriminalCallNum");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvCriminalDelivery() {
        TextView textView = this.mTvCriminalDelivery;
        if (textView == null) {
            i.q2.t.i0.k("mTvCriminalDelivery");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvCriminalNet() {
        TextView textView = this.mTvCriminalNet;
        if (textView == null) {
            i.q2.t.i0.k("mTvCriminalNet");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvCriminalRecharge() {
        TextView textView = this.mTvCriminalRecharge;
        if (textView == null) {
            i.q2.t.i0.k("mTvCriminalRecharge");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvCriminalRelation() {
        TextView textView = this.mTvCriminalRelation;
        if (textView == null) {
            i.q2.t.i0.k("mTvCriminalRelation");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvCriminalSms() {
        TextView textView = this.mTvCriminalSms;
        if (textView == null) {
            i.q2.t.i0.k("mTvCriminalSms");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvPolicNum() {
        TextView textView = this.mTvPolicNum;
        if (textView == null) {
            i.q2.t.i0.k("mTvPolicNum");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvSZNum() {
        TextView textView = this.mTvSZNum;
        if (textView == null) {
            i.q2.t.i0.k("mTvSZNum");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvStopPaymentNum() {
        TextView textView = this.mTvStopPaymentNum;
        if (textView == null) {
            i.q2.t.i0.k("mTvStopPaymentNum");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvTitle() {
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        return textView;
    }

    @j.c.a.d
    public final TextView getMTvWebsitNum() {
        TextView textView = this.mTvWebsitNum;
        if (textView == null) {
            i.q2.t.i0.k("mTvWebsitNum");
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

    @j.c.a.e
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

    public final void goChildPage(@j.c.a.e Class<?> cls) {
        Intent intent = new Intent(this.mActivity, cls);
        intent.putExtra(util.p1.C0, this.caseInfoId);
        startActivity(intent);
    }

    @Override // ui.activity.BaseActivity
    public void initPage() {
        org.greenrobot.eventbus.c.f().e(this);
        SwipBackLayout.a(this.mActivity).a();
        TextView textView = this.mTvTitle;
        if (textView == null) {
            i.q2.t.i0.k("mTvTitle");
        }
        if (textView == null) {
            i.q2.t.i0.f();
        }
        textView.setText("\u62a5\u6848\u4fe1\u606f");
        ImageView imageView = this.mIvStatusTag;
        if (imageView == null) {
            i.q2.t.i0.k("mIvStatusTag");
        }
        imageView.setVisibility(8);
        LinearLayout linearLayout = this.mLlDeal;
        if (linearLayout == null) {
            i.q2.t.i0.k("mLlDeal");
        }
        linearLayout.setVisibility(8);
        String stringExtra = getIntent().getStringExtra(util.p1.C0);
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
    public final void initView(@j.c.a.d CaseDetailBean caseDetailBean) {
        i.q2.t.i0.f(caseDetailBean, "result");
        this.result = caseDetailBean;
        TextView textView = this.mTvCaseName;
        if (textView == null) {
            i.q2.t.i0.k("mTvCaseName");
        }
        textView.setText(caseDetailBean.getCaseName());
        TextView textView2 = this.mTvCaseTime;
        if (textView2 == null) {
            i.q2.t.i0.k("mTvCaseTime");
        }
        textView2.setText(caseDetailBean.getProcessTime());
        TextView textView3 = this.mTvCaseNum;
        if (textView3 == null) {
            i.q2.t.i0.k("mTvCaseNum");
        }
        textView3.setText(caseDetailBean.getCaseNumber());
        TextView textView4 = this.mTvPolicNum;
        if (textView4 == null) {
            i.q2.t.i0.k("mTvPolicNum");
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
            i.q2.t.i0.k("mTvSZNum");
        }
        textView5.setText("" + this.victimCount + "\u4e2a");
        TextView textView6 = this.mTvCaseAccNum;
        if (textView6 == null) {
            i.q2.t.i0.k("mTvCaseAccNum");
        }
        textView6.setText("" + this.paymentCount + "\u4e2a");
        TextView textView7 = this.mTvCriminalCallNum;
        if (textView7 == null) {
            i.q2.t.i0.k("mTvCriminalCallNum");
        }
        textView7.setText("" + this.callTelCount + "\u4e2a");
        TextView textView8 = this.mTvCriminalRecharge;
        if (textView8 == null) {
            i.q2.t.i0.k("mTvCriminalRecharge");
        }
        textView8.setText("" + this.chargeTelCount + "\u4e2a");
        TextView textView9 = this.mTvCriminalRelation;
        if (textView9 == null) {
            i.q2.t.i0.k("mTvCriminalRelation");
        }
        textView9.setText("" + this.linkTelCount + "\u4e2a");
        TextView textView10 = this.mTvCriminalDelivery;
        if (textView10 == null) {
            i.q2.t.i0.k("mTvCriminalDelivery");
        }
        textView10.setText("" + this.mailingTelCount + "\u4e2a");
        TextView textView11 = this.mTvCriminalSms;
        if (textView11 == null) {
            i.q2.t.i0.k("mTvCriminalSms");
        }
        textView11.setText("" + this.smsCount + "\u4e2a");
        TextView textView12 = this.mTvCriminalNet;
        if (textView12 == null) {
            i.q2.t.i0.k("mTvCriminalNet");
        }
        textView12.setText("" + this.netAccountCount + "\u4e2a");
        TextView textView13 = this.mTvAppNum;
        if (textView13 == null) {
            i.q2.t.i0.k("mTvAppNum");
        }
        textView13.setText("" + this.appCount + "\u4e2a");
        TextView textView14 = this.mTvWebsitNum;
        if (textView14 == null) {
            i.q2.t.i0.k("mTvWebsitNum");
        }
        textView14.setText("" + this.urlCount + "\u4e2a");
        int i2 = this.callTelCount;
        if (this.chargeTelCount + i2 + this.linkTelCount + this.mailingTelCount == 0) {
            View view = this.mLlCriminalCall;
            if (view == null) {
                i.q2.t.i0.k("mLlCriminalCall");
            }
            view.setVisibility(8);
        } else {
            if (i2 == 0) {
                View view2 = this.mLlCall;
                if (view2 == null) {
                    i.q2.t.i0.k("mLlCall");
                }
                view2.setVisibility(8);
            }
            if (this.chargeTelCount == 0) {
                View view3 = this.mLlRecharge;
                if (view3 == null) {
                    i.q2.t.i0.k("mLlRecharge");
                }
                view3.setVisibility(8);
            }
            if (this.linkTelCount == 0) {
                View view4 = this.mLlRelation;
                if (view4 == null) {
                    i.q2.t.i0.k("mLlRelation");
                }
                view4.setVisibility(8);
            }
            if (this.mailingTelCount == 0) {
                View view5 = this.mLlDelivery;
                if (view5 == null) {
                    i.q2.t.i0.k("mLlDelivery");
                }
                view5.setVisibility(8);
            }
        }
        if (this.smsCount == 0) {
            View view6 = this.mLlSms;
            if (view6 == null) {
                i.q2.t.i0.k("mLlSms");
            }
            view6.setVisibility(8);
        }
        int i3 = this.netAccountCount;
        if (this.appCount + i3 + this.urlCount == 0) {
            View view7 = this.mLlCriminalNet;
            if (view7 == null) {
                i.q2.t.i0.k("mLlCriminalNet");
            }
            view7.setVisibility(8);
        } else {
            if (i3 == 0) {
                View view8 = this.mLlNet;
                if (view8 == null) {
                    i.q2.t.i0.k("mLlNet");
                }
                view8.setVisibility(8);
            }
            if (this.appCount == 0) {
                View view9 = this.mLlApp;
                if (view9 == null) {
                    i.q2.t.i0.k("mLlApp");
                }
                view9.setVisibility(8);
            }
            if (this.urlCount == 0) {
                View view10 = this.mLlWebsit;
                if (view10 == null) {
                    i.q2.t.i0.k("mLlWebsit");
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
                        com.bumptech.glide.j<Drawable> jVarA = com.bumptech.glide.b.a(this.mActivity).a(Integer.valueOf(R.mipmap.ic_detail_back));
                        ImageView imageView = this.mIvStatusTag;
                        if (imageView == null) {
                            i.q2.t.i0.k("mIvStatusTag");
                        }
                        jVarA.a(imageView);
                        ImageView imageView2 = this.mIvStatusTag;
                        if (imageView2 == null) {
                            i.q2.t.i0.k("mIvStatusTag");
                        }
                        imageView2.setVisibility(0);
                        LinearLayout linearLayout = this.mLlDeal;
                        if (linearLayout == null) {
                            i.q2.t.i0.k("mLlDeal");
                        }
                        linearLayout.setVisibility(8);
                        return;
                    }
                }
            }
            com.bumptech.glide.j<Drawable> jVarA2 = com.bumptech.glide.b.a(this.mActivity).a(Integer.valueOf(R.mipmap.ic_detail_wait));
            ImageView imageView3 = this.mIvStatusTag;
            if (imageView3 == null) {
                i.q2.t.i0.k("mIvStatusTag");
            }
            jVarA2.a(imageView3);
            ImageView imageView4 = this.mIvStatusTag;
            if (imageView4 == null) {
                i.q2.t.i0.k("mIvStatusTag");
            }
            imageView4.setVisibility(0);
            LinearLayout linearLayout2 = this.mLlDeal;
            if (linearLayout2 == null) {
                i.q2.t.i0.k("mLlDeal");
            }
            linearLayout2.setVisibility(0);
            RegionMudelBean regionMudelBeanJ = e.a.j();
            if (regionMudelBeanJ == null || !TextUtils.equals(regionMudelBeanJ.getStopPayment(), "1")) {
                LinearLayout linearLayout3 = this.mLlStopPayment;
                if (linearLayout3 == null) {
                    i.q2.t.i0.k("mLlStopPayment");
                }
                linearLayout3.setVisibility(8);
                LinearLayout linearLayout4 = this.mLlStopPaymentContent;
                if (linearLayout4 == null) {
                    i.q2.t.i0.k("mLlStopPaymentContent");
                }
                linearLayout4.setVisibility(8);
                return;
            }
            LinearLayout linearLayout5 = this.mLlStopPayment;
            if (linearLayout5 == null) {
                i.q2.t.i0.k("mLlStopPayment");
            }
            linearLayout5.setVisibility(0);
            LinearLayout linearLayout6 = this.mLlStopPaymentContent;
            if (linearLayout6 == null) {
                i.q2.t.i0.k("mLlStopPaymentContent");
            }
            linearLayout6.setVisibility(0);
            TextView textView15 = this.mTvStopPaymentNum;
            if (textView15 == null) {
                i.q2.t.i0.k("mTvStopPaymentNum");
            }
            textView15.setText("\u6dfb\u52a0");
            TextView textView16 = this.mTvStopPaymentNum;
            if (textView16 == null) {
                i.q2.t.i0.k("mTvStopPaymentNum");
            }
            textView16.setTextColor(getResources().getColor(R.color._2B4CFF));
            return;
        }
        com.bumptech.glide.j<Drawable> jVarA3 = com.bumptech.glide.b.a(this.mActivity).a(Integer.valueOf(R.mipmap.ic_detail_over));
        ImageView imageView5 = this.mIvStatusTag;
        if (imageView5 == null) {
            i.q2.t.i0.k("mIvStatusTag");
        }
        jVarA3.a(imageView5);
        ImageView imageView6 = this.mIvStatusTag;
        if (imageView6 == null) {
            i.q2.t.i0.k("mIvStatusTag");
        }
        imageView6.setVisibility(0);
        LinearLayout linearLayout7 = this.mLlDeal;
        if (linearLayout7 == null) {
            i.q2.t.i0.k("mLlDeal");
        }
        linearLayout7.setVisibility(8);
        TextView textView17 = this.mTvSZNum;
        if (textView17 == null) {
            i.q2.t.i0.k("mTvSZNum");
        }
        textView17.setEnabled(false);
        TextView textView18 = this.mTvCaseAccNum;
        if (textView18 == null) {
            i.q2.t.i0.k("mTvCaseAccNum");
        }
        textView18.setEnabled(false);
        TextView textView19 = this.mTvCriminalCallNum;
        if (textView19 == null) {
            i.q2.t.i0.k("mTvCriminalCallNum");
        }
        textView19.setEnabled(false);
        TextView textView20 = this.mTvCriminalRecharge;
        if (textView20 == null) {
            i.q2.t.i0.k("mTvCriminalRecharge");
        }
        textView20.setEnabled(false);
        TextView textView21 = this.mTvCriminalRelation;
        if (textView21 == null) {
            i.q2.t.i0.k("mTvCriminalRelation");
        }
        textView21.setEnabled(false);
        TextView textView22 = this.mTvCriminalDelivery;
        if (textView22 == null) {
            i.q2.t.i0.k("mTvCriminalDelivery");
        }
        textView22.setEnabled(false);
        TextView textView23 = this.mTvCriminalSms;
        if (textView23 == null) {
            i.q2.t.i0.k("mTvCriminalSms");
        }
        textView23.setEnabled(false);
        TextView textView24 = this.mTvCriminalNet;
        if (textView24 == null) {
            i.q2.t.i0.k("mTvCriminalNet");
        }
        textView24.setEnabled(false);
        TextView textView25 = this.mTvAppNum;
        if (textView25 == null) {
            i.q2.t.i0.k("mTvAppNum");
        }
        textView25.setEnabled(false);
        TextView textView26 = this.mTvWebsitNum;
        if (textView26 == null) {
            i.q2.t.i0.k("mTvWebsitNum");
        }
        textView26.setEnabled(false);
        TextView textView27 = this.mTvStopPaymentNum;
        if (textView27 == null) {
            i.q2.t.i0.k("mTvStopPaymentNum");
        }
        textView27.setEnabled(false);
        ImageView imageView7 = this.mIvVictim;
        if (imageView7 == null) {
            i.q2.t.i0.k("mIvVictim");
        }
        imageView7.setVisibility(4);
        ImageView imageView8 = this.mIvAccount;
        if (imageView8 == null) {
            i.q2.t.i0.k("mIvAccount");
        }
        imageView8.setVisibility(4);
        ImageView imageView9 = this.mIvCall;
        if (imageView9 == null) {
            i.q2.t.i0.k("mIvCall");
        }
        imageView9.setVisibility(4);
        ImageView imageView10 = this.mIvRecharge;
        if (imageView10 == null) {
            i.q2.t.i0.k("mIvRecharge");
        }
        imageView10.setVisibility(4);
        ImageView imageView11 = this.mIvRelation;
        if (imageView11 == null) {
            i.q2.t.i0.k("mIvRelation");
        }
        imageView11.setVisibility(4);
        ImageView imageView12 = this.mIvDelivery;
        if (imageView12 == null) {
            i.q2.t.i0.k("mIvDelivery");
        }
        imageView12.setVisibility(4);
        ImageView imageView13 = this.mIvSms;
        if (imageView13 == null) {
            i.q2.t.i0.k("mIvSms");
        }
        imageView13.setVisibility(4);
        ImageView imageView14 = this.mIvNet;
        if (imageView14 == null) {
            i.q2.t.i0.k("mIvNet");
        }
        imageView14.setVisibility(4);
        ImageView imageView15 = this.mIvApp;
        if (imageView15 == null) {
            i.q2.t.i0.k("mIvApp");
        }
        imageView15.setVisibility(4);
        ImageView imageView16 = this.mIvWebsite;
        if (imageView16 == null) {
            i.q2.t.i0.k("mIvWebsite");
        }
        imageView16.setVisibility(4);
        ImageView imageView17 = this.mIvStopPayment;
        if (imageView17 == null) {
            i.q2.t.i0.k("mIvStopPayment");
        }
        imageView17.setVisibility(4);
        RegionMudelBean regionMudelBeanJ2 = e.a.j();
        if (regionMudelBeanJ2 == null || !TextUtils.equals(regionMudelBeanJ2.getStopPayment(), "1") || this.stopPaymentCount <= 0) {
            LinearLayout linearLayout8 = this.mLlStopPayment;
            if (linearLayout8 == null) {
                i.q2.t.i0.k("mLlStopPayment");
            }
            linearLayout8.setVisibility(8);
            LinearLayout linearLayout9 = this.mLlStopPaymentContent;
            if (linearLayout9 == null) {
                i.q2.t.i0.k("mLlStopPaymentContent");
            }
            linearLayout9.setVisibility(8);
        } else {
            LinearLayout linearLayout10 = this.mLlStopPayment;
            if (linearLayout10 == null) {
                i.q2.t.i0.k("mLlStopPayment");
            }
            linearLayout10.setVisibility(0);
            LinearLayout linearLayout11 = this.mLlStopPaymentContent;
            if (linearLayout11 == null) {
                i.q2.t.i0.k("mLlStopPaymentContent");
            }
            linearLayout11.setVisibility(0);
            TextView textView28 = this.mTvStopPaymentNum;
            if (textView28 == null) {
                i.q2.t.i0.k("mTvStopPaymentNum");
            }
            textView28.setText("" + this.stopPaymentCount + "\u4e2a");
        }
        this.mReplyList = caseDetailBean.getReplys();
        List<? extends ReplyBean> list = this.mReplyList;
        if (list != null) {
            if (list == null) {
                i.q2.t.i0.f();
            }
            if (list.size() > 0) {
                LinearLayout linearLayout12 = this.mLlReply;
                if (linearLayout12 == null) {
                    i.q2.t.i0.k("mLlReply");
                }
                linearLayout12.setVisibility(0);
                RecyclerView recyclerView = this.mRecyclerViewReply;
                if (recyclerView == null) {
                    i.q2.t.i0.k("mRecyclerViewReply");
                }
                recyclerView.setVisibility(0);
                CaseHistoryPresenter caseHistoryPresenter = this.mPreenter;
                if (caseHistoryPresenter != null) {
                    RecyclerView recyclerView2 = this.mRecyclerViewReply;
                    if (recyclerView2 == null) {
                        i.q2.t.i0.k("mRecyclerViewReply");
                    }
                    caseHistoryPresenter.initRecycler(recyclerView2);
                    y1 y1Var = y1.a;
                }
                CaseHistoryPresenter caseHistoryPresenter2 = this.mPreenter;
                if (caseHistoryPresenter2 != 0) {
                    caseHistoryPresenter2.setListData(this.mReplyList);
                    y1 y1Var2 = y1.a;
                    return;
                }
                return;
            }
        }
        LinearLayout linearLayout13 = this.mLlReply;
        if (linearLayout13 == null) {
            i.q2.t.i0.k("mLlReply");
        }
        linearLayout13.setVisibility(8);
        RecyclerView recyclerView3 = this.mRecyclerViewReply;
        if (recyclerView3 == null) {
            i.q2.t.i0.k("mRecyclerViewReply");
        }
        recyclerView3.setVisibility(8);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onActivityResult(int i2, int i3, @j.c.a.e Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1) {
            e2.a("\u63d0\u4ea4\u6210\u529f\uff01");
            onSuccessCommit();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        List<? extends AccountListBean> list = this.mAccountList;
        if (list != null) {
            if (list == null) {
                i.q2.t.i0.f();
            }
            if (list.size() > 0) {
                util.f1.a(this.mActivity, "\u653e\u5f03\u672c\u6b21\u4fe1\u606f\u7f16\u8f91\uff1f", "", "\u53d6\u6d88", "\u786e\u5b9a", R.color._2D4AEB, -1, true, (IClickListener) new a());
                return;
            }
        }
        super.onBackPressed();
    }

    @OnClick({R.id.iv_back, R.id.tv_shizhu_detial, R.id.tv_case_account_detial, R.id.tv_criminal_call_detial, R.id.tv_criminal_recharge_detial, R.id.tv_criminal_relation_detial, R.id.tv_criminal_delivery_detial, R.id.tv_criminal_sms_detial, R.id.tv_criminal_net_detial, R.id.tv_app_info_detial, R.id.tv_websit_info_detial, R.id.tv_stop_payment, R.id.btn_back, R.id.btn_submit})
    public final void onClick(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "view");
        if (isDouble()) {
        }
        switch (view.getId()) {
            case R.id.btn_back /* 2131296403 */:
                CaseHistoryPresenter caseHistoryPresenter = this.mPreenter;
                if (caseHistoryPresenter != null) {
                    caseHistoryPresenter.returnCase(this.caseInfoId);
                }
                break;
            case R.id.btn_submit /* 2131296419 */:
                submit();
                break;
            case R.id.iv_back /* 2131296808 */:
                onBackPressed();
                break;
            case R.id.tv_app_info_detial /* 2131297575 */:
                if (this.appCount > 0) {
                    Intent intent = new Intent(this.mActivity, (Class<?>) SignCommitAppActivity.class);
                    intent.putExtra(util.p1.C0, this.caseInfoId);
                    intent.putExtra(util.p1.f15012d, true);
                    startActivity(intent);
                }
                break;
            case R.id.tv_case_account_detial /* 2131297609 */:
                if (this.paymentCount > 0) {
                    goChildPage(AccountListPreviewActivity.class);
                }
                break;
            case R.id.tv_criminal_call_detial /* 2131297655 */:
                if (this.callTelCount > 0) {
                    Intent intent2 = new Intent(this.mActivity, (Class<?>) SignCallActivity.class);
                    intent2.putExtra(util.p1.C0, this.caseInfoId);
                    startActivity(intent2);
                }
                break;
            case R.id.tv_criminal_delivery_detial /* 2131297657 */:
                if (this.mailingTelCount > 0) {
                    Intent intent3 = new Intent(this.mActivity, (Class<?>) SignDeliveryActivity.class);
                    intent3.putExtra(util.p1.C0, this.caseInfoId);
                    startActivity(intent3);
                }
                break;
            case R.id.tv_criminal_net_detial /* 2131297659 */:
                if (this.netAccountCount > 0) {
                    Intent intent4 = new Intent(this.mActivity, (Class<?>) CriminalSocialActivity.class);
                    intent4.putExtra(util.p1.C0, this.caseInfoId);
                    intent4.putExtra(util.p1.f15012d, true);
                    startActivity(intent4);
                }
                break;
            case R.id.tv_criminal_recharge_detial /* 2131297661 */:
                if (this.chargeTelCount > 0) {
                    Intent intent5 = new Intent(this.mActivity, (Class<?>) SignReChargeActivity.class);
                    intent5.putExtra(util.p1.C0, this.caseInfoId);
                    startActivity(intent5);
                }
                break;
            case R.id.tv_criminal_relation_detial /* 2131297663 */:
                if (this.linkTelCount > 0) {
                    Intent intent6 = new Intent(this.mActivity, (Class<?>) SignRelationActivity.class);
                    intent6.putExtra(util.p1.C0, this.caseInfoId);
                    startActivity(intent6);
                }
                break;
            case R.id.tv_criminal_sms_detial /* 2131297665 */:
                if (this.smsCount > 0) {
                    Intent intent7 = new Intent(this.mActivity, (Class<?>) CriminalSmsActivity.class);
                    intent7.putExtra(util.p1.C0, this.caseInfoId);
                    intent7.putExtra(util.p1.f15012d, true);
                    startActivity(intent7);
                }
                break;
            case R.id.tv_shizhu_detial /* 2131297868 */:
                if (this.victimCount > 0) {
                    goChildPage(SignCommitVictimActivity.class);
                }
                break;
            case R.id.tv_stop_payment /* 2131297888 */:
                Intent intent8 = new Intent(this.mActivity, (Class<?>) PayStopListActivity.class);
                intent8.putExtra(util.p1.C0, this.caseInfoId);
                intent8.putExtra(util.p1.f15011c, (Serializable) this.mAccountList);
                intent8.putExtra(util.p1.f15010b, (Serializable) this.mAccountAutoList);
                startActivity(intent8);
                break;
            case R.id.tv_websit_info_detial /* 2131297977 */:
                if (this.urlCount > 0) {
                    goChildPage(SignCommitWebsiteActivity.class);
                }
                break;
        }
    }

    @Override // ui.activity.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        org.greenrobot.eventbus.c.f().g(this);
    }

    @org.greenrobot.eventbus.m(threadMode = ThreadMode.MAIN)
    public final void onEvent(@j.c.a.e util.n2.a aVar) {
        if (aVar != null) {
            int iA = aVar.a();
            if (iA != 303) {
                if (iA != 304) {
                    return;
                }
                Object objB = aVar.b();
                if (objB == null) {
                    throw new i.e1("null cannot be cast to non-null type kotlin.collections.List<bean.AccountListBean>");
                }
                this.mAccountAutoList = (List) objB;
                return;
            }
            Object objB2 = aVar.b();
            if (objB2 == null) {
                throw new i.e1("null cannot be cast to non-null type kotlin.collections.List<bean.AccountListBean>");
            }
            List<? extends AccountListBean> list = (List) objB2;
            this.mAccountList = list;
            RegionMudelBean regionMudelBeanJ = e.a.j();
            if (regionMudelBeanJ == null || !TextUtils.equals(regionMudelBeanJ.getStopPayment(), "1")) {
                LinearLayout linearLayout = this.mLlStopPayment;
                if (linearLayout == null) {
                    i.q2.t.i0.k("mLlStopPayment");
                }
                linearLayout.setVisibility(8);
                LinearLayout linearLayout2 = this.mLlStopPaymentContent;
                if (linearLayout2 == null) {
                    i.q2.t.i0.k("mLlStopPaymentContent");
                }
                linearLayout2.setVisibility(8);
                return;
            }
            LinearLayout linearLayout3 = this.mLlStopPayment;
            if (linearLayout3 == null) {
                i.q2.t.i0.k("mLlStopPayment");
            }
            linearLayout3.setVisibility(0);
            LinearLayout linearLayout4 = this.mLlStopPaymentContent;
            if (linearLayout4 == null) {
                i.q2.t.i0.k("mLlStopPaymentContent");
            }
            linearLayout4.setVisibility(0);
            if (list == null || list.size() <= 0) {
                TextView textView = this.mTvStopPaymentNum;
                if (textView == null) {
                    i.q2.t.i0.k("mTvStopPaymentNum");
                }
                textView.setText("\u6dfb\u52a0");
                TextView textView2 = this.mTvStopPaymentNum;
                if (textView2 == null) {
                    i.q2.t.i0.k("mTvStopPaymentNum");
                }
                textView2.setTextColor(getResources().getColor(R.color._2B4CFF));
                return;
            }
            TextView textView3 = this.mTvStopPaymentNum;
            if (textView3 == null) {
                i.q2.t.i0.k("mTvStopPaymentNum");
            }
            textView3.setText("" + list.size() + "\u4e2a");
            TextView textView4 = this.mTvStopPaymentNum;
            if (textView4 == null) {
                i.q2.t.i0.k("mTvStopPaymentNum");
            }
            textView4.setTextColor(getResources().getColor(R.color.black_dark));
        }
    }

    @Override // ui.callview.CaseHistoryCallView
    public void onSuccessBack() {
        org.greenrobot.eventbus.c.f().c(new util.n2.a(204, null));
        finish();
    }

    @Override // ui.callview.CaseHistoryCallView
    public void onSuccessCommit() {
        org.greenrobot.eventbus.c.f().c(new util.n2.a(205, null));
        finish();
    }

    @Override // ui.callview.CaseHistoryCallView
    public void onSuccessDetail(@j.c.a.d CaseDetailBean caseDetailBean) {
        i.q2.t.i0.f(caseDetailBean, "result");
        initView(caseDetailBean);
    }

    public final void setAppCount(int i2) {
        this.appCount = i2;
    }

    public final void setBitmap(@j.c.a.e Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public final void setCallTelCount(int i2) {
        this.callTelCount = i2;
    }

    public final void setCaseInfoId(@j.c.a.d String str) {
        i.q2.t.i0.f(str, "<set-?>");
        this.caseInfoId = str;
    }

    public final void setChargeTelCount(int i2) {
        this.chargeTelCount = i2;
    }

    @Override // ui.activity.BaseActivity
    public int setLayoutView() {
        return R.layout.activity_case_history;
    }

    public final void setLinkTelCount(int i2) {
        this.linkTelCount = i2;
    }

    public final void setMAccountAutoList(@j.c.a.e List<? extends AccountListBean> list) {
        this.mAccountAutoList = list;
    }

    public final void setMAccountList(@j.c.a.e List<? extends AccountListBean> list) {
        this.mAccountList = list;
    }

    public final void setMIvAccount(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvAccount = imageView;
    }

    public final void setMIvApp(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvApp = imageView;
    }

    public final void setMIvBack(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvBack = imageView;
    }

    public final void setMIvCall(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvCall = imageView;
    }

    public final void setMIvDelivery(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvDelivery = imageView;
    }

    public final void setMIvNet(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvNet = imageView;
    }

    public final void setMIvRecharge(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvRecharge = imageView;
    }

    public final void setMIvRelation(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvRelation = imageView;
    }

    public final void setMIvSignImg(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvSignImg = imageView;
    }

    public final void setMIvSms(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvSms = imageView;
    }

    public final void setMIvStatusTag(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvStatusTag = imageView;
    }

    public final void setMIvStopPayment(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvStopPayment = imageView;
    }

    public final void setMIvVictim(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvVictim = imageView;
    }

    public final void setMIvWebsite(@j.c.a.d ImageView imageView) {
        i.q2.t.i0.f(imageView, "<set-?>");
        this.mIvWebsite = imageView;
    }

    public final void setMLlApp(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlApp = view;
    }

    public final void setMLlCall(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlCall = view;
    }

    public final void setMLlCriminalCall(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlCriminalCall = view;
    }

    public final void setMLlCriminalNet(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlCriminalNet = view;
    }

    public final void setMLlDeal(@j.c.a.d LinearLayout linearLayout) {
        i.q2.t.i0.f(linearLayout, "<set-?>");
        this.mLlDeal = linearLayout;
    }

    public final void setMLlDelivery(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlDelivery = view;
    }

    public final void setMLlNet(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlNet = view;
    }

    public final void setMLlRecharge(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlRecharge = view;
    }

    public final void setMLlRelation(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlRelation = view;
    }

    public final void setMLlReply(@j.c.a.d LinearLayout linearLayout) {
        i.q2.t.i0.f(linearLayout, "<set-?>");
        this.mLlReply = linearLayout;
    }

    public final void setMLlSms(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlSms = view;
    }

    public final void setMLlStopPayment(@j.c.a.d LinearLayout linearLayout) {
        i.q2.t.i0.f(linearLayout, "<set-?>");
        this.mLlStopPayment = linearLayout;
    }

    public final void setMLlStopPaymentContent(@j.c.a.d LinearLayout linearLayout) {
        i.q2.t.i0.f(linearLayout, "<set-?>");
        this.mLlStopPaymentContent = linearLayout;
    }

    public final void setMLlWebsit(@j.c.a.d View view) {
        i.q2.t.i0.f(view, "<set-?>");
        this.mLlWebsit = view;
    }

    public final void setMPreenter(@j.c.a.e CaseHistoryPresenter caseHistoryPresenter) {
        this.mPreenter = caseHistoryPresenter;
    }

    public final void setMRecyclerViewReply(@j.c.a.d RecyclerView recyclerView) {
        i.q2.t.i0.f(recyclerView, "<set-?>");
        this.mRecyclerViewReply = recyclerView;
    }

    public final void setMReplyList(@j.c.a.e List<? extends ReplyBean> list) {
        this.mReplyList = list;
    }

    public final void setMTvAppNum(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvAppNum = textView;
    }

    public final void setMTvCaseAccNum(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCaseAccNum = textView;
    }

    public final void setMTvCaseName(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCaseName = textView;
    }

    public final void setMTvCaseNum(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCaseNum = textView;
    }

    public final void setMTvCaseTime(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCaseTime = textView;
    }

    public final void setMTvCriminalCallNum(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCriminalCallNum = textView;
    }

    public final void setMTvCriminalDelivery(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCriminalDelivery = textView;
    }

    public final void setMTvCriminalNet(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCriminalNet = textView;
    }

    public final void setMTvCriminalRecharge(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCriminalRecharge = textView;
    }

    public final void setMTvCriminalRelation(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCriminalRelation = textView;
    }

    public final void setMTvCriminalSms(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvCriminalSms = textView;
    }

    public final void setMTvPolicNum(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvPolicNum = textView;
    }

    public final void setMTvSZNum(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvSZNum = textView;
    }

    public final void setMTvStopPaymentNum(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvStopPaymentNum = textView;
    }

    public final void setMTvTitle(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
        this.mTvTitle = textView;
    }

    public final void setMTvWebsitNum(@j.c.a.d TextView textView) {
        i.q2.t.i0.f(textView, "<set-?>");
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

    public final void setResult(@j.c.a.e CaseDetailBean caseDetailBean) {
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
            i.q2.t.i0.k("mLlStopPayment");
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
                i.q2.t.i0.f();
            }
            if (list.size() > 0) {
                Intent intent = new Intent(this.mActivity, (Class<?>) CaseVerifyActivity.class);
                intent.putExtra(util.p1.C0, this.caseInfoId);
                intent.putExtra(util.p1.f15011c, (Serializable) this.mAccountList);
                startActivityForResult(intent, 100);
                return;
            }
        }
        util.f1.a(this.mActivity, "\u662f\u5426\u6dfb\u52a0\u6b62\u4ed8\u4fe1\u606f\uff1f", "", "\u63d0\u4ea4\u6848\u4ef6", "\u53bb\u6dfb\u52a0", -1, -1, true, (IClickListener) new b());
    }
}
