package com.syf.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.syf.eum.AreaEnum;
import com.syf.eum.CityEnum;
import com.syf.eum.LaterEnum;
import com.syf.eum.PositionEnum;
import com.syf.eum.ScopeEnum;
import com.syf.eum.ShapeEnum;
import com.syf.eum.StyleEnum;
import com.syf.eum.VerticalEnum;

@Table(name = "project")
@Entity
public class Project {

  @Id
  @NotNull
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull
  private String name;
  
  @Column
  private float areaOfStructure;
  
  @Column
  private String design;
  
  @Column
  private String location;
  
  @Column
  private String company;
  
  @Column
  private float length;
  
  @Column
  private float width;
  
  @Column
  private float height;
  
  @Column
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
  private  Date updateTime;
  
  @Column
  private String opType;
  
  private User opUser;
  
  
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

  public String getOpType() {
    return opType;
  }

  public void setOpType(String opType) {
    this.opType = opType;
  }

  public User getOpUser() {
    return opUser;
  }

  public void setOpUser(User opUser) {
    this.opUser = opUser;
  }

}
