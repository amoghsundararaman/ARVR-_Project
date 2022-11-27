package com.google.p000vr.ndk.base;

import android.util.Log;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.vr.ndk.base.Version */
public final class Version {
    public static final Version CURRENT = parse("1.150.0");
    public static final Version MIN = parse(BuildConstants.MIN_VERSION);
    public static final String TAG = "Version";
    public final int majorVersion;
    public final int minorVersion;
    public final int patchVersion;

    public Version(int i, int i2, int i3) {
        this.majorVersion = i;
        this.minorVersion = i2;
        this.patchVersion = i3;
    }

    public static Version parse(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)\\.(\\d+)").matcher(str);
        if (matcher.matches()) {
            return new Version(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)));
        }
        String valueOf = String.valueOf(str);
        Log.w(TAG, valueOf.length() != 0 ? "Failed to parse version from: ".concat(valueOf) : new String("Failed to parse version from: "));
        return null;
    }

    public final boolean isAtLeast(Version version) {
        if (this.majorVersion > version.majorVersion) {
            return true;
        }
        if (this.majorVersion < version.majorVersion) {
            return false;
        }
        if (this.minorVersion > version.minorVersion) {
            return true;
        }
        if (this.minorVersion < version.minorVersion) {
            return false;
        }
        if (this.patchVersion > version.patchVersion || this.patchVersion >= version.patchVersion) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        if (this.majorVersion == version.majorVersion && this.minorVersion == version.minorVersion && this.patchVersion == version.patchVersion) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.majorVersion), Integer.valueOf(this.minorVersion), Integer.valueOf(this.patchVersion)});
    }

    public final String toString() {
        return String.format("%d.%d.%d", new Object[]{Integer.valueOf(this.majorVersion), Integer.valueOf(this.minorVersion), Integer.valueOf(this.patchVersion)});
    }
}
