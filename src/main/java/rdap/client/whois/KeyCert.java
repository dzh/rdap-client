package rdap.client.whois;

/**
 * https://www.apnic.net/manage-ip/using-whois/guide/key-cert/
 * <p>
 * Stores a PGP certificate for use with ‘mntner’ objects for authentication when performing object updates.
 * <p>
 * Example
 * key-cert:     PGPKEY-83F2A90E
 * method:       PGP
 * owner:        DEMO-ISP Hostmaster <hostmaster@demo.net>
 * fingerpr:     CE3D 4829 A392 733E A37B  B7DC 4463 4AB2 83F2 A90E
 * certif:       -----BEGIN PGP PUBLIC KEY BLOCK-----
 * certif:       Version: GnuPG v1.0.6 (GNU/Linux)
 * certif:       Comment: For info see http://www.gnupg.org
 * certif:
 * certif:       mQGiBD0GnVIRBADDmMMFTKQ1Ye7r8T+Rg4y1kqjQBd1rCVU8ifZjQBy9G7W9MZa1
 * certif:       RxOd6QpPA4x0mr9oeLXKuV3S1l85LPw8vchiL3XJyEha7WhKAFWqDSz9mclFpkeH
 * certif:       mfoFftI+C207IupyuGVatBFZlqHPPfhmvxseIAx8VqauyEliLtNlVZGRNwCg0DKN
 * certif:       KUiNRLnwuADrHBPX3EaQ6wUEAJ/wMW8xvOQFIXVZ+JFMgZTvC+KrafHqkKkEWy45
 * certif:       anfZ5glXxX7f6iOaIV8+dnkyeWaWMLVaxr9xJZV5yrcvbmr6q4f+lBK833c/65CZ
 * certif:       8HMZT6/vjyVBBnUTH466233bsRwEElQeKQytjvQOW6oP6JSIMiocNBTL97atF0h9
 * certif:       tbs3A/4ivLAWmO/jTJUguv+COE/RaaClfL21LsPCWzj5FMkblq6l4Q+O3zYVmzMF
 * certif:       HYrN9y20UJkkMlF6lLaygL/jJqHKrOyJ62mqr+djiGEmbm4RPchpGYab1ZYtSP5J
 * certif:       +HBdkLyvJwzu/EFENk8qUFwGGK648QZwdb5l0PpupIJVAhzh4LQpU29uIFRyYW4g
 * certif:       KHNvbiBmcm9tIEFQTklDKSA8c29uQGFwbmljLm5ldD6IXQQTEQIAHQUCPQadUgUJ
 * certif:       AeEzgAULBwoDBAMVAwIDFgIBAheAAAoJEERjSrKD8qkOqdIAn16HWeFUWC4UDps9
 * certif:       RL6Ih36nD7ImAKCyGujiMGf158S+xaznZErAHmUmxrkBDQQ9Bp1TEAQAm4b1a2mJ
 * certif:       5K9r523VpfEqzGAPNlnpM/in57ypE9qpwZbKvtX1pa0oevQU+G41vEQwWatlMKLY
 * certif:       Rj5NPpvAxQ5T7PyGVQ1EHL+vsFPRyQ2g4XQUytRn7Isp1/j8RmnXFNoBawaGwcuS
 * certif:       9H/RXCR6WRh7lGNwSSND5aoW1e1tiQ9GAm8AAwUD/0LFbiN6Yq28RtSBVbFrt4mW
 * certif:       rTdzLE2ROlD1AGLxc8YLlL5xx9+5H8Wx4OVJrdQGeNIA9lSv9x4dnxVLg9srXiew
 * certif:       ORDwHvyn7gvqaGHSxkKMZksB1KH0sgGBQ2gBalGZLuZwTmYGsBb2AizDy/ALf9BX
 * certif:       4/VPjQng8ZEwHtO4ZMs6iEwEGBECAAwFAj0GnVMFCQHhM4AACgkQRGNKsoPyqQ7u
 * certif:       mACfU+I4OAGKexPQy3p3ailQUhLhxIsAn3W9U0308+saZqMX0I4Lj2S3VIzz
 * certif:       =Fw7X
 * certif:       -----END PGP PUBLIC KEY BLOCK-----
 * remarks:      DEMO-ISP PGP key
 * notify:        hostmaster@demo.net
 * mnt-by:       MAINT-DEMO-AP
 * last-modified:2018-08-30T07:50:19Z
 * source:       APNIC
 *
 * @author dzh
 * @date 2019-03-06 19:12
 */
public class KeyCert {
    private String keyCert;         //  [mandatory]  [single]     [primary/lookup key]
    private String method;          //  [generated]  [single]     [ ]
    private String owner;           //  [generated]  [multiple]   [ ]
    private String fingerpr;        //  [generated]  [single]     [ ]
    private String certif;          //  [mandatory]  [multiple]   [ ]
    private String remarks;         //  [optional]   [multiple]   [ ]
    private String notify;          //  [optional]   [multiple]   [inverse key]
    private String adminC;          //  [optional]   [multiple]   [inverse key]
    private String techC;           //  [optional]   [multiple]   [inverse key]
    private String mntBy;           //  [mandatory]  [multiple]   [inverse key]
    private String lastModified;    //  [generated]  [single]     [ ]
    private String source;          //  [mandatory]  [single]     [ ]

    public String getKeyCert() {
        return keyCert;
    }

    public void setKeyCert(String keyCert) {
        this.keyCert = keyCert;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getFingerpr() {
        return fingerpr;
    }

    public void setFingerpr(String fingerpr) {
        this.fingerpr = fingerpr;
    }

    public String getCertif() {
        return certif;
    }

    public void setCertif(String certif) {
        this.certif = certif;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }

    public String getAdminC() {
        return adminC;
    }

    public void setAdminC(String adminC) {
        this.adminC = adminC;
    }

    public String getTechC() {
        return techC;
    }

    public void setTechC(String techC) {
        this.techC = techC;
    }

    public String getMntBy() {
        return mntBy;
    }

    public void setMntBy(String mntBy) {
        this.mntBy = mntBy;
    }

    public String getLastModified() {
        return lastModified;
    }

    public void setLastModified(String lastModified) {
        this.lastModified = lastModified;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
