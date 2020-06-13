package sample.model;

public class UploadFileResponse {
  private String name;
  private String status = "done";
  private String url;
  private String thumbUrl;
  private String fileType;
  private long size;

  public UploadFileResponse(String name, String url, String thumbUrl, String fileType, long size) {
    this.name = name;
    this.url = url;
    this.thumbUrl = thumbUrl;
    this.fileType = fileType;
    this.size = size;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getThumbUrl() {
    return thumbUrl;
  }

  public void setThumbUrl(String thumbUrl) {
    this.thumbUrl = thumbUrl;
  }
}
