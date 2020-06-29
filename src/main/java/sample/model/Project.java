package sample.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import sample.eum.AreaEnum;
import sample.eum.CityEnum;
import sample.eum.LaterEnum;
import sample.eum.PositionEnum;
import sample.eum.ScopeEnum;
import sample.eum.ShapeEnum;
import sample.eum.StyleEnum;
import sample.eum.VerticalEnum;

@Table(name = "project")
@Entity
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String name;

  @Column
  private float areaOfStructure;

  @Lob
  @Column(length = 5000)
  private String design;

  @Column
  private String location;

  @Column
  private String company;

  @Column
  private String material;
  
  @Column
  private float length;

  @Column
  private float width;

  @Column
  private float height;

  @Column
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date openTime;

  @Column
  @Enumerated(EnumType.STRING)
  private CityEnum city;

  @Column
  @Enumerated(EnumType.STRING)
  private PositionEnum position;

  @Column
  @Enumerated(EnumType.STRING)
  private AreaEnum area;

  @Column
  @Enumerated(EnumType.STRING)
  private StyleEnum style;

  @Column
  @Enumerated(EnumType.STRING)
  private ShapeEnum shape;

  @Column
  @Enumerated(EnumType.STRING)
  private ScopeEnum scope;

  @Column
  @Enumerated(EnumType.STRING)
  private LaterEnum later;

  @Column
  @Enumerated(EnumType.STRING)
  private VerticalEnum vertical;

  @Column
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date updateTime;

  @ManyToOne
  private User opUser;

  @ManyToOne
  private User creator;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "projectid")
  private List<Picture> pictures;

  @Column
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

  public String getDesign() {
    return design;
  }

  public void setDesign(String design) {
    this.design = design;
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

  public PositionEnum getPosition() {
    return position;
  }

  public void setPosition(PositionEnum position) {
    this.position = position;
  }

  public AreaEnum getArea() {
    return area;
  }

  public void setArea(AreaEnum area) {
    this.area = area;
  }

  public StyleEnum getStyle() {
    return style;
  }

  public void setStyle(StyleEnum style) {
    this.style = style;
  }

  public ShapeEnum getShape() {
    return shape;
  }

  public void setShape(ShapeEnum shape) {
    this.shape = shape;
  }

  public ScopeEnum getScope() {
    return scope;
  }

  public void setScope(ScopeEnum scope) {
    this.scope = scope;
  }

  public LaterEnum getLater() {
    return later;
  }

  public void setLater(LaterEnum later) {
    this.later = later;
  }

  public VerticalEnum getVertical() {
    return vertical;
  }

  public void setVertical(VerticalEnum vertical) {
    this.vertical = vertical;
  }

  public CityEnum getCity() {
    return city;
  }

  public void setCity(CityEnum city) {
    this.city = city;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public float getAreaOfStructure() {
    return areaOfStructure;
  }

  public void setAreaOfStructure(float areaOfStructure) {
    this.areaOfStructure = areaOfStructure;
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

  public String getMaterial() {
    return material;
  }

  public void setMaterial(String material) {
    this.material = material;
  }

}
