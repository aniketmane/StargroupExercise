package com.example.stargroupexercise.data.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "ArrayOfObjStationData")
public class ArrayOfObjStationData {
    @ElementList(inline = true, required = false)
    public List<ObjStationData> stationData;
}