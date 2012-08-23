*------------------------------------------------------------------------------
* 
*------------------------------------------------------------------------------
    SUBROUTINE T24TComponentImpl.doStuff(name, student, responseDetails)
*------------------------------------------------------------------------------
* @author aphethean@temenos.com
* @stereotype subroutine
* @package com.sandbox.tafjeemix.tcomponent
*!
* In/out parameters:  
* name - String, IN
* student - Student (Single), IN
* responseDetails - ResponseDetails, OUT
*
*------------------------------------------------------------------------------
    $INSERT I_responseDetails
    $INSERT I_TComponent_Student

*------------------------------------------------------------------------------
    GOSUB initialise
    GOSUB process
    GOSUB finalise

    RETURN
*------------------------------------------------------------------------------
process:* Let's do some stuff
    OPEN "F.CUSTOMER" TO FILEVAR ELSE STUFF.ERROR="Could not open F.CUSTOMER"
    WRITE student TO FILEVAR,name ON ERROR
        STUFF.ERROR="Write failed"
    END
*
    RETURN

*------------------------------------------------------------------------------
initialise:* Get ready
    STUFF.ERROR=""
    response = ''
    responseDetails = '' 
    responseDetails.serviceName = "T24TComponentImpl.doStuff"
*
    RETURN

*------------------------------------------------------------------------------
finalise:* Set and return responseDetails with warnings or errors.    
    IF STUFF.ERROR="" THEN
        responseDetails.returnCode="SUCCESS"
    END ELSE
        responseDetails.returnCode="FAILURE"        
        response.messageCode=101
        response.messageType="FATAL.ERROR"
        response.messageText=STUFF.ERROR
        response.messageInfo=""
        responseDetails.responses=response
    END
*
    RETURN
    
*------------------------------------------------------------------------------

    END
