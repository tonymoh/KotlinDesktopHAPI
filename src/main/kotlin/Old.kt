/*

    Without leveraging Kotlin features

    val mshSegment: MSH = adtMessage.msh
    mshSegment.fieldseparator.value = ("|")
    mshSegment.encodingcharacters.value = ("^~\\&")
    mshSegment.sendingapplication.value = ("Our System")
    mshSegment.sendingfacility.value = ("Our Facility")
    mshSegment.receivingapplication.value = ("Their Remote System")
    mshSegment.receivingfacility.value = ("Their Remote Facility")
    mshSegment.datetimeofmessage.value = currentDateTimeString
    mshSegment.messagecontrolid.value = "1234${getCurrentTimeStamp()}"
    mshSegment.versionid.value = ("2.4")

    val evnSegment: EVN = adtMessage.evn
    evnSegment.evn1_EVENTTYPECODE.value = ("A01")
    evnSegment.evn2_DATETIMEOFEVENT.value = getCurrentTimeStamp()

    val pidSegment: PID = adtMessage.pid
    pidSegment.patientname.familyName.value = ("Mouse")
    pidSegment.patientname.givenName.value = ("Mickey")
    pidSegment.setidpatientid.value = ("378785433211")
    pidSegment.patientaddress.ad1_StreetAddress.value = ("123 Main Street")
    pidSegment.patientaddress.ad3_City.value = ("Lake Buena Vista")
    pidSegment.patientaddress.ad4_StateOrProvince.value = ("FL")
    pidSegment.patientaddress.ad6_Country.value = ("USA")

    val pv1Segment: PV1 = adtMessage.pV1
    pv1Segment.assignedpatientlocation.value = ("Some Treatment Facility Name")
    pv1Segment.admissiontype.value = ("ALERT")
    pv1Segment.referringdoctor.id.value = ("99999999")
    pv1Segment.referringdoctor.familyName.value = ("Smith")
    pv1Segment.referringdoctor.givenName.value = ("Jack")
    pv1Segment.admitdatetime.value = getCurrentTimeStamp()

 */