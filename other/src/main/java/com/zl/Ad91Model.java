package com.zl;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-07-24
 */
public class Ad91Model {
    public Site site;
    public Imp imp;
    public Device device;
    public Device device1;

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Imp getImp() {
        return imp;
    }

    public void setImp(Imp imp) {
        this.imp = imp;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public Device getDevice1() {
        return device1;
    }

    public void setDevice1(Device device1) {
        this.device1 = device1;
    }

    public static class Site {
        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    public class Imp {
        private int adPid;
        private Banner banner;

        public int getAdPid() {
            return adPid;
        }

        public void setAdPid(int adPid) {
            this.adPid = adPid;
        }

        public Banner getBanner() {
            return banner;
        }

        public void setBanner(Banner banner) {
            this.banner = banner;
        }
    }

    public class Banner {
        private int width;
        private int height;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    public class Device {
        private String imei;
        private String androidId;
        private String ol;
        private String ip;
        private int nt;
        private int platform;
        private String lan;
        private String rslt;
        private String osv;
        private long sendtime;
        private int timezone;
        private String idfa;
        private String mac;
        private String appVer;
        private String ua;

        public String getImei() {
            return imei;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        public String getAndroidId() {
            return androidId;
        }

        public void setAndroidId(String androidId) {
            this.androidId = androidId;
        }

        public String getOl() {
            return ol;
        }

        public void setOl(String ol) {
            this.ol = ol;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public int getNt() {
            return nt;
        }

        public void setNt(int nt) {
            this.nt = nt;
        }

        public int getPlatform() {
            return platform;
        }

        public void setPlatform(int platform) {
            this.platform = platform;
        }

        public String getLan() {
            return lan;
        }

        public void setLan(String lan) {
            this.lan = lan;
        }

        public String getRslt() {
            return rslt;
        }

        public void setRslt(String rslt) {
            this.rslt = rslt;
        }

        public String getOsv() {
            return osv;
        }

        public void setOsv(String osv) {
            this.osv = osv;
        }

        public long getSendtime() {
            return sendtime;
        }

        public void setSendtime(long sendtime) {
            this.sendtime = sendtime;
        }

        public int getTimezone() {
            return timezone;
        }

        public void setTimezone(int timezone) {
            this.timezone = timezone;
        }

        public String getIdfa() {
            return idfa;
        }

        public void setIdfa(String idfa) {
            this.idfa = idfa;
        }

        public String getMac() {
            return mac;
        }

        public void setMac(String mac) {
            this.mac = mac;
        }

        public String getAppVer() {
            return appVer;
        }

        public void setAppVer(String appVer) {
            this.appVer = appVer;
        }

        public String getUa() {
            return ua;
        }

        public void setUa(String ua) {
            this.ua = ua;
        }
    }
}
