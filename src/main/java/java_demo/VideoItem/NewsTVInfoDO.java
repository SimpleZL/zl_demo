package java_demo.VideoItem;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2017-12-27
 */
public class NewsTVInfoDO {
    private Integer id;
    private String name;
    private String description;
    private String category;
    private String source;
    private Integer vid;
    private String bigPic;
    private String playUrl;
    private String urlHigh;
    private String urlNor;
    private Integer fileSizeHigh;
    private Integer fileSizeNor;
    private Integer playTime;
    private Integer bindNewsId;
    private Date applicationTime;
    private String bindPosition;
    private String urlDivision;
    private String guid;
    private String sourceSite;
    private Integer site;
    private Date createTime;
    private Date updateTime;
    private Integer forwardVideo;

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public String getUrlHigh() {
        return urlHigh;
    }

    public void setUrlHigh(String urlHigh) {
        this.urlHigh = urlHigh;
    }

    public String getUrlNor() {
        return urlNor;
    }

    public void setUrlNor(String urlNor) {
        this.urlNor = urlNor;
    }

    public Integer getFileSizeHigh() {
        return fileSizeHigh;
    }

    public void setFileSizeHigh(Integer fileSizeHigh) {
        this.fileSizeHigh = fileSizeHigh;
    }

    public Integer getFileSizeNor() {
        return fileSizeNor;
    }

    public void setFileSizeNor(Integer fileSizeNor) {
        this.fileSizeNor = fileSizeNor;
    }

    public Integer getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Integer playTime) {
        this.playTime = playTime;
    }

    public Integer getBindNewsId() {
        return bindNewsId;
    }

    public void setBindNewsId(Integer bindNewsId) {
        this.bindNewsId = bindNewsId;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getBindPosition() {
        return bindPosition;
    }

    public void setBindPosition(String bindPosition) {
        this.bindPosition = bindPosition;
    }

    public String getUrlDivision() {
        return urlDivision;
    }

    public void setUrlDivision(String urlDivision) {
        this.urlDivision = urlDivision;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getSourceSite() {
        return sourceSite;
    }

    public void setSourceSite(String sourceSite) {
        this.sourceSite = sourceSite;
    }

    public Integer getSite() {
        return site;
    }

    public void setSite(Integer site) {
        this.site = site;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getForwardVideo() {
        return forwardVideo;
    }

    public void setForwardVideo(Integer forwardVideo) {
        this.forwardVideo = forwardVideo;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "NewsTVInfoDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", source='" + source + '\'' +
                ", vid=" + vid +
                ", bigPic='" + bigPic + '\'' +
                ", playUrl='" + playUrl + '\'' +
                ", urlHigh='" + urlHigh + '\'' +
                ", urlNor='" + urlNor + '\'' +
                ", fileSizeHigh=" + fileSizeHigh +
                ", fileSizeNor=" + fileSizeNor +
                ", playTime=" + playTime +
                ", bindNewsId=" + bindNewsId +
                ", applicationTime=" + applicationTime +
                ", bindPosition='" + bindPosition + '\'' +
                ", urlDivision='" + urlDivision + '\'' +
                ", guid='" + guid + '\'' +
                ", sourceSite='" + sourceSite + '\'' +
                ", site=" + site +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", forwardVideo=" + forwardVideo +
                '}';
    }
}
