import com.temboo.core.*;
import com.temboo.Library.Twilio.SMSMessages.SendSMS;
import com.temboo.Library.Twilio.SMSMessages.SendSMS.SendSMSInputSet;

// Instantiate the session
TembooSession session = new TembooSession("accountName", "myFirstApp", "abc123xxxxxxxxxxxxxx");

// Act as a proxy on behalf of the JavaScript SDK
TembooProxy tembooProxy = new TembooProxy();

// Instantiate the Choreo
SendSMS sendSMSChoreo = new SendSMS(session);

// Add Choreo proxy with an ID matching that specified by the JS SDK client
tembooProxy.addChoreo("jsSendSMS", sendSMSChoreo);

// Get an input object for the Choreo
SendSMSInputSet sendSMSInputs = sendSMSChoreo.newInputSet();

// Set credential to use for execution
sendSMSInputs.setCredential("TwillioCredentialswithPicturetomom");

tembooProxy.setDefaultInputs("jsSendSMS", sendSMSInputs);

// Whitelist client inputs
tembooProxy.allowUserInputs("jsSendSMS", "From");

// Execute the requested Choreo. httpPostData contains the contents of the JavaScript client POST
// request. How this variable is populated will depend on your Java web server implementation
String result = tembooProxy.execute(httpPostData.get("temboo_proxy"), true);