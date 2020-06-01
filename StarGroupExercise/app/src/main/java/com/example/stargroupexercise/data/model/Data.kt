/*
package com.example.stargroupexercise.data.model

import org.simpleframework.xml.*

*/
/*<Servertime	:	2020-05-26T15:42:54.33
Traincode	:	E982
Stationfullname	:	Shankill
Stationcode	:	SKILL
Querytime	:	15:42:54
Traindate	:	26 May 2020
Origin	:	Bray
Destination	:	Howth
Origintime	:	16:00
Destinationtime	:	17:07
Status	:	No Information
Lastlocation	:	
Duein	:	22
Late	:	0
Exparrival	:	16:04
Expdepart	:	16:04
Scharrival	:	16:04
Schdepart	:	16:04
Direction	:	Northbound
Traintype	:	DART
Locationtype	:	S
*//*

@Root(name = "objStationData")
data class ObjStationData @JvmOverloads constructor(
    @field:Element(name = "Servertime")
    var serverTime: String = "",
    @field:Element(name = "Traincode")
    var trainCode: String = "",
    @field:Element(name = "Stationfullname")
    var stationFullName: String = "",
    @field:Element(name = "Stationcode")
    var stationCode: String = "",
    @field:Element(name = "Querytime")
    var queryTime: String = "",
    @field:Element(name = "Traindate")
    var trainDate: String = "",
    @field:Element(name = "Origin")
    var origin: String = "",
    @field:Element(name = "Destination")
    var destination: String = "",
    @field:Element(name = "Origintime")
    var originTime: String = "",
    @field:Element(name = "Destinationtime")
    var destinationTime: String = "",
    @field:Element(name = "Status")
    var status: String = "",
    @field:Element(name = "Lastlocation", required = false)
    var lastLocation: String = "",
    @field:Element(name = "Duein")
    var duein: String = "",
    @field:Element(name = "Late")
    var late: String = "",
    @field:Element(name = "Exparrival")
    var expArrival: String = "",
    @field:Element(name = "Expdepart")
    var expDepart: String = "",
    @field:Element(name = "Scharrival")
    var schArrival: String = "",
    @field:Element(name = "Schdepart")
    var schDepart: String = "",
    @field:Element(name = "Direction")
    var direction: String = "",
    @field:Element(name = "Traintype")
    var trainType: String = "",
    @field:Element(name = "Locationtype")
    var locationType: String = ""
)

@Root(name = "ArrayOfObjStationData", strict = false)
data class ArrayOfObjStationData @JvmOverloads constructor(
    */
/*  @field:Attribute(name = "xmlns:xsi",required = false)
      var xsi: String = "",
      @field:Attribute(name = "xmlns:xsd",required = false)
      var xsd: String = "",
      @field:Attribute(name = "xmlns",required = false)
      var xmlns: String = "",*//*

    @ElementList(inline = true, required = false)
    var stationData: MutableList<ObjStationData>
)
*/
