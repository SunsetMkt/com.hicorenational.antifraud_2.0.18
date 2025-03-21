package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import com.taobao.accs.common.Constants;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Html.kt */
@InterfaceC5713y(m23544bv = {1, 0, 2}, m23545d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0086\b\u001a\u0017\u0010\t\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0086\b¨\u0006\u000b"}, m23546d2 = {"parseAsHtml", "Landroid/text/Spanned;", "", Constants.KEY_FLAGS, "", "imageGetter", "Landroid/text/Html$ImageGetter;", "tagHandler", "Landroid/text/Html$TagHandler;", "toHtml", "option", "core-ktx_release"}, m23547k = 2, m23548mv = {1, 1, 10})
/* loaded from: classes.dex */
public final class HtmlKt {
    @InterfaceC5816d
    public static final Spanned parseAsHtml(@InterfaceC5816d String str, int i2, @InterfaceC5817e Html.ImageGetter imageGetter, @InterfaceC5817e Html.TagHandler tagHandler) {
        C5544i0.m22546f(str, "$receiver");
        Spanned fromHtml = HtmlCompat.fromHtml(str, i2, imageGetter, tagHandler);
        C5544i0.m22521a((Object) fromHtml, "HtmlCompat.fromHtml(this… imageGetter, tagHandler)");
        return fromHtml;
    }

    @InterfaceC5816d
    public static /* bridge */ /* synthetic */ Spanned parseAsHtml$default(String str, int i2, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        if ((i3 & 2) != 0) {
            imageGetter = null;
        }
        if ((i3 & 4) != 0) {
            tagHandler = null;
        }
        C5544i0.m22546f(str, "$receiver");
        Spanned fromHtml = HtmlCompat.fromHtml(str, i2, imageGetter, tagHandler);
        C5544i0.m22521a((Object) fromHtml, "HtmlCompat.fromHtml(this… imageGetter, tagHandler)");
        return fromHtml;
    }

    @InterfaceC5816d
    public static final String toHtml(@InterfaceC5816d Spanned spanned, int i2) {
        C5544i0.m22546f(spanned, "$receiver");
        String html = HtmlCompat.toHtml(spanned, i2);
        C5544i0.m22521a((Object) html, "HtmlCompat.toHtml(this, option)");
        return html;
    }

    @InterfaceC5816d
    public static /* bridge */ /* synthetic */ String toHtml$default(Spanned spanned, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        C5544i0.m22546f(spanned, "$receiver");
        String html = HtmlCompat.toHtml(spanned, i2);
        C5544i0.m22521a((Object) html, "HtmlCompat.toHtml(this, option)");
        return html;
    }
}
