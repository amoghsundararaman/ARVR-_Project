package com.unity3d.player;

import com.unity3d.player.C0049b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

class UnityWebRequest implements Runnable {

    /* renamed from: k */
    private static final HostnameVerifier f139k = new HostnameVerifier() {
        public final boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    };

    /* renamed from: a */
    private long f140a;

    /* renamed from: b */
    private String f141b;

    /* renamed from: c */
    private String f142c;

    /* renamed from: d */
    private Map f143d;

    /* renamed from: e */
    private boolean f144e;

    /* renamed from: f */
    private int f145f;

    /* renamed from: g */
    private long f146g;

    /* renamed from: h */
    private long f147h;

    /* renamed from: i */
    private boolean f148i;

    /* renamed from: j */
    private boolean f149j;

    static {
        if (CookieHandler.getDefault() == null) {
            CookieHandler.setDefault(new CookieManager());
        }
    }

    UnityWebRequest(long j, String str, Map map, String str2, boolean z, int i) {
        this.f140a = j;
        this.f141b = str2;
        this.f142c = str;
        this.f143d = map;
        this.f144e = z;
        this.f145f = i;
    }

    static void clearCookieCache(String str, String str2) {
        CookieStore cookieStore;
        CookieHandler cookieHandler = CookieHandler.getDefault();
        if (cookieHandler != null && (cookieHandler instanceof CookieManager) && (cookieStore = ((CookieManager) cookieHandler).getCookieStore()) != null) {
            if (str == null) {
                cookieStore.removeAll();
                return;
            }
            try {
                URI uri = new URI((String) null, str, str2, (String) null);
                List<HttpCookie> list = cookieStore.get(uri);
                if (list != null) {
                    for (HttpCookie remove : list) {
                        cookieStore.remove(uri, remove);
                    }
                }
            } catch (URISyntaxException unused) {
                C0057g.Log(6, String.format("UnityWebRequest: failed to parse URI %s", new Object[]{str}));
            }
        }
    }

    private static native void contentLengthCallback(long j, int i);

    private static native boolean downloadCallback(long j, ByteBuffer byteBuffer, int i);

    private static native void errorCallback(long j, int i, String str);

    private boolean hasTimedOut() {
        return this.f145f > 0 && System.currentTimeMillis() - this.f146g >= ((long) this.f145f);
    }

    private static native void headerCallback(long j, String str, String str2);

    private static native void responseCodeCallback(long j, int i);

    private void runSafe() {
        StringBuilder sb;
        String str;
        C00412 r5;
        this.f146g = System.currentTimeMillis();
        try {
            URL url = new URL(this.f141b);
            URLConnection openConnection = url.openConnection();
            openConnection.setConnectTimeout(this.f145f);
            openConnection.setReadTimeout(this.f145f);
            InputStream inputStream = null;
            if (openConnection instanceof HttpsURLConnection) {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) openConnection;
                if (this.f144e) {
                    r5 = new C0049b.C0051b() {
                        public final void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                            if (!UnityWebRequest.this.validateCertificateCallback((x509CertificateArr == null || x509CertificateArr.length <= 0) ? new byte[0] : x509CertificateArr[0].getEncoded())) {
                                throw new CertificateException();
                            }
                        }
                    };
                    httpsURLConnection.setHostnameVerifier(f139k);
                } else {
                    r5 = null;
                }
                SSLSocketFactory a = C0049b.m144a((C0049b.C0051b) r5);
                if (a != null) {
                    httpsURLConnection.setSSLSocketFactory(a);
                }
            }
            if (!url.getProtocol().equalsIgnoreCase("file") || url.getHost().isEmpty()) {
                boolean z = openConnection instanceof HttpURLConnection;
                int i = 0;
                if (z) {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                        httpURLConnection.setRequestMethod(this.f142c);
                        httpURLConnection.setInstanceFollowRedirects(false);
                        if (this.f147h > 0) {
                            if (this.f149j) {
                                httpURLConnection.setChunkedStreamingMode(0);
                            } else {
                                httpURLConnection.setFixedLengthStreamingMode((int) this.f147h);
                            }
                            if (this.f148i) {
                                httpURLConnection.addRequestProperty("Expect", "100-continue");
                            }
                        }
                    } catch (ProtocolException e) {
                        badProtocolCallback(e.toString());
                        return;
                    }
                }
                Map map = this.f143d;
                if (map != null) {
                    for (Map.Entry entry : map.entrySet()) {
                        openConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(131072);
                if (uploadCallback((ByteBuffer) null) > 0) {
                    openConnection.setDoOutput(true);
                    try {
                        OutputStream outputStream = openConnection.getOutputStream();
                        while (true) {
                            int uploadCallback = uploadCallback(allocateDirect);
                            if (uploadCallback <= 0) {
                                break;
                            } else if (hasTimedOut()) {
                                outputStream.close();
                                errorCallback(this.f140a, 14, "WebRequest timed out.");
                                return;
                            } else {
                                outputStream.write(allocateDirect.array(), allocateDirect.arrayOffset(), uploadCallback);
                            }
                        }
                    } catch (Exception e2) {
                        errorCallback(e2.toString());
                        return;
                    }
                }
                if (z) {
                    try {
                        responseCodeCallback(((HttpURLConnection) openConnection).getResponseCode());
                    } catch (UnknownHostException e3) {
                        unknownHostCallback(e3.toString());
                        return;
                    } catch (SSLException e4) {
                        sslCannotConnectCallback(e4);
                        return;
                    } catch (SocketTimeoutException e5) {
                        errorCallback(this.f140a, 14, e5.toString());
                        return;
                    } catch (IOException e6) {
                        errorCallback(e6.toString());
                        return;
                    }
                }
                Map<String, List<String>> headerFields = openConnection.getHeaderFields();
                headerCallback(headerFields);
                if ((headerFields == null || !headerFields.containsKey("content-length")) && openConnection.getContentLength() != -1) {
                    headerCallback("content-length", String.valueOf(openConnection.getContentLength()));
                }
                if ((headerFields == null || !headerFields.containsKey("content-type")) && openConnection.getContentType() != null) {
                    headerCallback("content-type", openConnection.getContentType());
                }
                if (headerFields != null && headerFields.containsKey("Set-Cookie") && CookieHandler.getDefault() != null && (CookieHandler.getDefault() instanceof CookieManager)) {
                    CookieStore cookieStore = ((CookieManager) CookieHandler.getDefault()).getCookieStore();
                    for (String str2 : headerFields.get("Set-Cookie")) {
                        try {
                            HttpCookie httpCookie = HttpCookie.parse(str2).get(i);
                            if (httpCookie.getPath() != null && !httpCookie.getPath().equals("") && (httpCookie.getDomain() == null || httpCookie.getDomain().equals(url.getHost()))) {
                                URI uri = new URI(url.getProtocol(), url.getHost(), httpCookie.getPath(), (String) null);
                                httpCookie.setDomain(url.getHost());
                                cookieStore.add(uri, httpCookie);
                            }
                        } catch (IllegalArgumentException e7) {
                            sb = new StringBuilder("UnityWebRequest: error parsing cookie '");
                            sb.append(str2);
                            sb.append("': ");
                            str = e7.getMessage();
                            sb.append(str);
                            C0057g.Log(6, sb.toString());
                            i = 0;
                        } catch (URISyntaxException e8) {
                            sb = new StringBuilder("UnityWebRequest: error constructing URI: ");
                            str = e8.getMessage();
                            sb.append(str);
                            C0057g.Log(6, sb.toString());
                            i = 0;
                        }
                        i = 0;
                    }
                }
                contentLengthCallback(openConnection.getContentLength());
                try {
                    if (openConnection instanceof HttpURLConnection) {
                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) openConnection;
                        responseCodeCallback(httpURLConnection2.getResponseCode());
                        inputStream = httpURLConnection2.getErrorStream();
                    }
                    if (inputStream == null) {
                        inputStream = openConnection.getInputStream();
                    }
                    ReadableByteChannel newChannel = Channels.newChannel(inputStream);
                    while (true) {
                        int read = newChannel.read(allocateDirect);
                        if (read != -1) {
                            if (!hasTimedOut()) {
                                if (!downloadCallback(allocateDirect, read)) {
                                    break;
                                }
                                allocateDirect.clear();
                            } else {
                                newChannel.close();
                                errorCallback(this.f140a, 14, "WebRequest timed out.");
                                return;
                            }
                        } else {
                            break;
                        }
                    }
                    newChannel.close();
                } catch (UnknownHostException e9) {
                    unknownHostCallback(e9.toString());
                } catch (SSLException e10) {
                    sslCannotConnectCallback(e10);
                } catch (SocketTimeoutException e11) {
                    errorCallback(this.f140a, 14, e11.toString());
                } catch (IOException e12) {
                    errorCallback(this.f140a, 12, e12.toString());
                } catch (Exception e13) {
                    errorCallback(e13.toString());
                }
            } else {
                malformattedUrlCallback("file:// must use an absolute path");
            }
        } catch (MalformedURLException e14) {
            malformattedUrlCallback(e14.toString());
        } catch (IOException e15) {
            errorCallback(e15.toString());
        }
    }

    private static native int uploadCallback(long j, ByteBuffer byteBuffer);

    private static native boolean validateCertificateCallback(long j, byte[] bArr);

    /* access modifiers changed from: protected */
    public void badProtocolCallback(String str) {
        C0057g.Log(6, String.format("UnityWebRequest: badProtocolCallback with error=%s url=%s", new Object[]{str, this.f141b}));
        errorCallback(this.f140a, 4, str);
    }

    /* access modifiers changed from: protected */
    public void contentLengthCallback(int i) {
        contentLengthCallback(this.f140a, i);
    }

    /* access modifiers changed from: protected */
    public boolean downloadCallback(ByteBuffer byteBuffer, int i) {
        return downloadCallback(this.f140a, byteBuffer, i);
    }

    /* access modifiers changed from: protected */
    public void errorCallback(String str) {
        C0057g.Log(6, String.format("UnityWebRequest: errorCallback with error=%s url=%s", new Object[]{str, this.f141b}));
        errorCallback(this.f140a, 2, str);
    }

    /* access modifiers changed from: protected */
    public void headerCallback(String str, String str2) {
        headerCallback(this.f140a, str, str2);
    }

    /* access modifiers changed from: protected */
    public void headerCallback(Map map) {
        if (map != null && map.size() != 0) {
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    str = "Status";
                }
                for (String headerCallback : (List) entry.getValue()) {
                    headerCallback(str, headerCallback);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void malformattedUrlCallback(String str) {
        C0057g.Log(6, String.format("UnityWebRequest: malformattedUrlCallback with error=%s url=%s", new Object[]{str, this.f141b}));
        errorCallback(this.f140a, 5, str);
    }

    /* access modifiers changed from: protected */
    public void responseCodeCallback(int i) {
        responseCodeCallback(this.f140a, i);
    }

    public void run() {
        try {
            runSafe();
        } catch (Exception e) {
            errorCallback(e.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public void setupTransferSettings(long j, boolean z, boolean z2) {
        this.f147h = j;
        this.f148i = z;
        this.f149j = z2;
    }

    /* access modifiers changed from: protected */
    public void sslCannotConnectCallback(SSLException sSLException) {
        int i;
        String sSLException2 = sSLException.toString();
        C0057g.Log(6, String.format("UnityWebRequest: sslCannotConnectCallback with error=%s url=%s", new Object[]{sSLException2, this.f141b}));
        Throwable th = sSLException;
        while (true) {
            if (th == null) {
                i = 16;
                break;
            } else if (th instanceof SSLKeyException) {
                i = 23;
                break;
            } else if ((th instanceof SSLPeerUnverifiedException) || (th instanceof CertPathValidatorException)) {
                i = 25;
            } else {
                th = th.getCause();
            }
        }
        errorCallback(this.f140a, i, sSLException2);
    }

    /* access modifiers changed from: protected */
    public void unknownHostCallback(String str) {
        C0057g.Log(6, String.format("UnityWebRequest: unknownHostCallback with error=%s url=%s", new Object[]{str, this.f141b}));
        errorCallback(this.f140a, 7, str);
    }

    /* access modifiers changed from: protected */
    public int uploadCallback(ByteBuffer byteBuffer) {
        return uploadCallback(this.f140a, byteBuffer);
    }

    /* access modifiers changed from: protected */
    public boolean validateCertificateCallback(byte[] bArr) {
        return validateCertificateCallback(this.f140a, bArr);
    }
}
