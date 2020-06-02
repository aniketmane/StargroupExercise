package com.example.stargroupexercise.data.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
@Root(name = "objStationData")
public class ObjStationData {
    @Element(name = "Servertime")
    public String Servertime;
    @Element(name = "Traincode")
    public String Traincode;
    @Element(name = "Stationfullname")
    public String Stationfullname;
    @Element(name = "Stationcode")
    public String Stationcode;
    @Element(name = "Querytime")
    public String Querytime;
    @Element(name = "Traindate")
    public String Traindate;
    @Element(name = "Origin")
    public String Origin;
    @Element(name = "Destination")
    public String Destination;
    @Element(name = "Origintime")
    public String Origintime;
    @Element(name = "Destinationtime")
    public String Destinationtime;
    @Element(name = "Status",required = false)
    public String Status;
    @Element(name = "Lastlocation", required = false)
    public String Lastlocation;
    @Element(name = "Duein")
    public Integer Duein;
    @Element(name = "Late")
    public Integer Late;
    @Element(name = "Exparrival")
    public String Exparrival;
    @Element(name = "Expdepart")
    public String Expdepart;
    @Element(name = "Scharrival")
    public String Scharrival;
    @Element(name = "Schdepart")
    public String Schdepart;
    @Element(name = "Direction")
    public String Direction;
    @Element(name = "Traintype")
    public String Traintype;
    @Element(name = "Locationtype")
    public String Locationtype;
}
