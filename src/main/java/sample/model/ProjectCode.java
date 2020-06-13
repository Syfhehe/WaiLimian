package sample.model;

import java.util.Date;
import java.util.List;

public class ProjectCode {

  private Long id;

  private String name;

  private float areaOfStructure;

  private String design;

  private String location;

  private String company;

  private float length;

  private float width;

  private float height;

  private Date openTime;

  private String city;

  private String position;

  private String area;

  private String style;

  private String shape;

  private String scope;

  private String later;

  private String vertical;

  private Date updateTime;

  private User opUser;

  private User creator;

  private List<Picture> pictures;

  private Boolean tab;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getAreaOfStructure() {
    return areaOfStructure;
  }

  public void setAreaOfStructure(float areaOfStructure) {
    this.areaOfStructure = areaOfStructure;
  }

  public String getDesign() {
    return design;
  }

  public void setDesign(String design) {
    this.design = design;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public float getLength() {
    return length;
  }

  public void setLength(float length) {
    this.length = length;
  }

  public float getWidth() {
    return width;
  }

  public void setWidth(float width) {
    this.width = width;
  }

  public float getHeight() {
    return height;
  }

  public void setHeight(float height) {
    this.height = height;
  }

  public Date getOpenTime() {
    return openTime;
  }

  public void setOpenTime(Date openTime) {
    this.openTime = openTime;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getShape() {
    return shape;
  }

  public void setShape(String shape) {
    this.shape = shape;
  }

  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }

  public String getLater() {
    return later;
  }

  public void setLater(String later) {
    this.later = later;
  }

  public String getVertical() {
    return vertical;
  }

  public void setVertical(String vertical) {
    this.vertical = vertical;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public User getOpUser() {
    return opUser;
  }

  public void setOpUser(User opUser) {
    this.opUser = opUser;
  }

  public User getCreator() {
    return creator;
  }

  public void setCreator(User creator) {
    this.creator = creator;
  }
  
  public Boolean getTab() {
    return tab;
  }

  public void setTab(Boolean tab) {
    this.tab = tab;
  }

  public List<Picture> getPictures() {
    return pictures;
  }

  public void setPictures(List<Picture> pictures) {
    this.pictures = pictures;
  }

 
}