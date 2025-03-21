package okio;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import p286h.InterfaceC5713y;
import p286h.p309q2.InterfaceC5482f;
import p286h.p309q2.p311t.C5544i0;
import p286h.p323z2.C5726c0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: JvmOkio.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a\u0016\u0010\b\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0001H\u0007\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\n\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\u000b\u001a%\u0010\b\u001a\u00020\u0006*\u00020\f2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0007\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u0013\u001a\n\u0010\u0011\u001a\u00020\u0012*\u00020\u000b\u001a%\u0010\u0011\u001a\u00020\u0012*\u00020\f2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0014\"\u001c\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0004¨\u0006\u0015"}, m23546d2 = {"isAndroidGetsocknameError", "", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "(Ljava/lang/AssertionError;)Z", "appendingSink", "Lokio/Sink;", "Ljava/io/File;", "sink", RequestParameters.SUBRESOURCE_APPEND, "Ljava/io/OutputStream;", "Ljava/net/Socket;", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "source", "Lokio/Source;", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "okio"}, m23547k = 5, m23548mv = {1, 1, 16}, m23551xs = "okio/Okio")
/* loaded from: classes2.dex */
final /* synthetic */ class Okio__JvmOkioKt {
    @InterfaceC5816d
    public static final Sink appendingSink(@InterfaceC5816d File file) throws FileNotFoundException {
        C5544i0.m22546f(file, "$this$appendingSink");
        return Okio.sink(new FileOutputStream(file, true));
    }

    public static final boolean isAndroidGetsocknameError(@InterfaceC5816d AssertionError assertionError) {
        C5544i0.m22546f(assertionError, "$this$isAndroidGetsocknameError");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? C5726c0.m23774c((CharSequence) message, (CharSequence) "getsockname failed", false, 2, (Object) null) : false;
    }

    @InterfaceC5482f
    @InterfaceC5816d
    public static final Sink sink(@InterfaceC5816d File file) throws FileNotFoundException {
        return sink$default(file, false, 1, null);
    }

    @InterfaceC5816d
    public static final Sink sink(@InterfaceC5816d OutputStream outputStream) {
        C5544i0.m22546f(outputStream, "$this$sink");
        return new OutputStreamSink(outputStream, new Timeout());
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z, int i2, Object obj) throws FileNotFoundException {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return Okio.sink(file, z);
    }

    @InterfaceC5816d
    public static final Source source(@InterfaceC5816d InputStream inputStream) {
        C5544i0.m22546f(inputStream, "$this$source");
        return new InputStreamSource(inputStream, new Timeout());
    }

    @InterfaceC5816d
    public static final Sink sink(@InterfaceC5816d Socket socket) throws IOException {
        C5544i0.m22546f(socket, "$this$sink");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        C5544i0.m22521a((Object) outputStream, "getOutputStream()");
        return socketAsyncTimeout.sink(new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    @InterfaceC5816d
    public static final Source source(@InterfaceC5816d Socket socket) throws IOException {
        C5544i0.m22546f(socket, "$this$source");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        C5544i0.m22521a((Object) inputStream, "getInputStream()");
        return socketAsyncTimeout.source(new InputStreamSource(inputStream, socketAsyncTimeout));
    }

    @InterfaceC5482f
    @InterfaceC5816d
    public static final Sink sink(@InterfaceC5816d File file, boolean z) throws FileNotFoundException {
        C5544i0.m22546f(file, "$this$sink");
        return Okio.sink(new FileOutputStream(file, z));
    }

    @InterfaceC5816d
    public static final Source source(@InterfaceC5816d File file) throws FileNotFoundException {
        C5544i0.m22546f(file, "$this$source");
        return Okio.source(new FileInputStream(file));
    }

    @InterfaceC5816d
    @IgnoreJRERequirement
    public static final Sink sink(@InterfaceC5816d Path path, @InterfaceC5816d OpenOption... openOptionArr) throws IOException {
        C5544i0.m22546f(path, "$this$sink");
        C5544i0.m22546f(openOptionArr, "options");
        OutputStream newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        C5544i0.m22521a((Object) newOutputStream, "Files.newOutputStream(this, *options)");
        return Okio.sink(newOutputStream);
    }

    @InterfaceC5816d
    @IgnoreJRERequirement
    public static final Source source(@InterfaceC5816d Path path, @InterfaceC5816d OpenOption... openOptionArr) throws IOException {
        C5544i0.m22546f(path, "$this$source");
        C5544i0.m22546f(openOptionArr, "options");
        InputStream newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        C5544i0.m22521a((Object) newInputStream, "Files.newInputStream(this, *options)");
        return Okio.source(newInputStream);
    }
}
