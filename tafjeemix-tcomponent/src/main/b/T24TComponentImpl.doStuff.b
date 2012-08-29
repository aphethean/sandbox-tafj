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
    FILENAME="FBNK.CUSTOMER"
    OPEN FILENAME TO FILEVAR THEN
        IF student="Guy" THEN
            STUFF.ERROR="This student was not accepted."
        END ELSE
            WRITE student TO FILEVAR,name ON ERROR
                STUFF.ERROR="Write failed"
            END
        END
    END ELSE 
        STUFF.ERROR="Could not open ":FILENAME
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
        responseList=""
        response.messageCode=101
        response.messageType="FATAL.ERROR"
        response.messageText=STUFF.ERROR
        response.messageInfo=""
        response=response.messageCode:VM:response.messageType:VM:response.messageText:VM:response.messageInfo
        responseList<-1>=response

        responseDetails.returnCode="FAILURE"    
        responseDetails.responses=LOWER(responseList)
    END
*
    RETURN
    
*------------------------------------------------------------------------------

    END
