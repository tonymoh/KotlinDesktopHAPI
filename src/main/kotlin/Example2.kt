import ca.uhn.hl7v2.DefaultHapiContext
import ca.uhn.hl7v2.model.v21.message.ADT_A01
import org.jetbrains.skiko.currentNanoTime
import java.text.SimpleDateFormat
import java.util.*

/**
 * Sending HL7 Message and Receiving acknowledgement.
 * Based on the excellent set of tutorials found at https://www.saravanansubramanian.com/blog/hl72xhapisendmessage/
 * The examples have been adapted for Kotlin.
 * Note you will need HAPI Test Panel from https://hapifhir.github.io/hapi-hl7v2/hapi-testpanel/install.html
 */

fun Example2(){
    // Create a HAPI Context for managing the HL7 communication
    val myContext = DefaultHapiContext()

    // Generate a timestamp string for use in the message
    val currentDateTimeString = currentNanoTime().toString()

    // Initialize an ADT_A01 message
    val adtMessage = ADT_A01()
    adtMessage.initQuickstart("ADT", "A01", "P")

    // Set MSH segment fields
    adtMessage.msh.apply {
        fieldseparator.value = "|"
        encodingcharacters.value = "^~\\&"
        sendingapplication.value = "Our System"
        sendingfacility.value = "Our Facility"
        receivingapplication.value = "Their Remote System"
        receivingfacility.value = "Their Remote Facility"
        datetimeofmessage.value = currentDateTimeString
        messagecontrolid.value = "1234${getCurrentTimeStamp()}"
        versionid.value = "2.4"
    }

    // Set EVN segment fields
    adtMessage.evn.apply {
        evn1_EVENTTYPECODE.value = "A01"
        evn2_DATETIMEOFEVENT.value = getCurrentTimeStamp()
    }

    // Set PID segment fields
    adtMessage.pid.apply {
        patientname.apply {
            familyName.value = "Mouse"
            givenName.value = "Mickey"
        }
        setidpatientid.value = "378785433211"
        patientaddress.apply {
            ad1_StreetAddress.value = "123 Main Street"
            ad3_City.value = "Lake Buena Vista"
            ad4_StateOrProvince.value = "FL"
            ad6_Country.value = "USA"
        }
    }

    // Set PV1 segment fields
    adtMessage.pV1.apply {
        assignedpatientlocation.value = "Some Treatment Facility Name"
        admissiontype.value = "ALERT"
        referringdoctor.apply {
            id.value = "99999999"
            familyName.value = "Smith"
            givenName.value = "Jack"
        }
        admitdatetime.value = getCurrentTimeStamp()
    }

    // Send the ADT_A01 message and receive an acknowledgement
    // Needs HAPI Test Up and Running with port 52463
    val connection = myContext.newClient("localhost",52463,false)
    val initiator = connection.initiator
    val resp = initiator.sendAndReceive(adtMessage)

    // Print the received acknowledgement message
    println(resp.message)
}

/**
 * Returns the current timestamp in the format "yyyyMMddHHmmss".
 * @return The current timestamp as a string.
 */
private fun getCurrentTimeStamp(): String {
    return SimpleDateFormat("yyyyMMddHHmmss").format(Date())
}