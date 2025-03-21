package okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import p286h.InterfaceC5713y;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.InterfaceC5482f;
import p324i.p336c.p337a.InterfaceC5816d;

@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"okio/Okio__JvmOkioKt", "okio/Okio__OkioKt"}, m23547k = 4, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class Okio {
    @InterfaceC5816d
    public static final Sink appendingSink(@InterfaceC5816d File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.appendingSink(file);
    }

    @InterfaceC5481e(name = "blackhole")
    @InterfaceC5816d
    public static final Sink blackhole() {
        return Okio__OkioKt.blackhole();
    }

    @InterfaceC5816d
    public static final BufferedSink buffer(@InterfaceC5816d Sink sink) {
        return Okio__OkioKt.buffer(sink);
    }

    public static final boolean isAndroidGetsocknameError(@InterfaceC5816d AssertionError assertionError) {
        return Okio__JvmOkioKt.isAndroidGetsocknameError(assertionError);
    }

    @InterfaceC5482f
    @InterfaceC5816d
    public static final Sink sink(@InterfaceC5816d File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink$default(file, false, 1, null);
    }

    @InterfaceC5482f
    @InterfaceC5816d
    public static final Sink sink(@InterfaceC5816d File file, boolean z) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink(file, z);
    }

    @InterfaceC5816d
    public static final Source source(@InterfaceC5816d File file) throws FileNotFoundException {
        return Okio__JvmOkioKt.source(file);
    }

    @InterfaceC5816d
    public static final BufferedSource buffer(@InterfaceC5816d Source source) {
        return Okio__OkioKt.buffer(source);
    }

    @InterfaceC5816d
    public static final Sink sink(@InterfaceC5816d OutputStream outputStream) {
        return Okio__JvmOkioKt.sink(outputStream);
    }

    @InterfaceC5816d
    public static final Source source(@InterfaceC5816d InputStream inputStream) {
        return Okio__JvmOkioKt.source(inputStream);
    }

    @InterfaceC5816d
    public static final Sink sink(@InterfaceC5816d Socket socket) throws IOException {
        return Okio__JvmOkioKt.sink(socket);
    }

    @InterfaceC5816d
    public static final Source source(@InterfaceC5816d Socket socket) throws IOException {
        return Okio__JvmOkioKt.source(socket);
    }

    @InterfaceC5816d
    @IgnoreJRERequirement
    public static final Sink sink(@InterfaceC5816d Path path, @InterfaceC5816d OpenOption... openOptionArr) throws IOException {
        return Okio__JvmOkioKt.sink(path, openOptionArr);
    }

    @InterfaceC5816d
    @IgnoreJRERequirement
    public static final Source source(@InterfaceC5816d Path path, @InterfaceC5816d OpenOption... openOptionArr) throws IOException {
        return Okio__JvmOkioKt.source(path, openOptionArr);
    }
}
