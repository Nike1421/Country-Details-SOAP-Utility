package nike1421.countryinfo.controller;

import jakarta.xml.soap.*;

public class SOAPClient {
	private static void createSOAPEnvelope(SOAPMessage soapMessage) throws SOAPException{
		SOAPPart soapPart = soapMessage.getSOAPPart();
		
		String myNamespace = "dataacc";
        String myNamespaceURI = "http://www.dataaccess.com/webservicesserver/";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);

            /*
            Constructed SOAP Request Message:
            <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:myNamespace="http://www.webserviceX.NET">
                <SOAP-ENV:Header/>
                <SOAP-ENV:Body>
                    <myNamespace:GetInfoByCity>
                        <myNamespace:USCity>New York</myNamespace:USCity>
                    </myNamespace:GetInfoByCity>
                </SOAP-ENV:Body>
            </SOAP-ENV:Envelope>
            */

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("NumberToWords", myNamespace);
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("ubiNum");
        soapBodyElem1.addTextNode("500");
        
        System.out.println(soapMessage.toString());
		
	}
	
	private static SOAPMessage createSOAPRequest(String soapAction) throws Exception{
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		
		createSOAPEnvelope(soapMessage);
		
		MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);

        soapMessage.saveChanges();

        /* Print the request message, just for debugging purposes */
        System.out.println("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println("\n");
		
		return soapMessage;
	}
	
	private static void callSoapWebService(String soapEndpointUrl, String soapAction) {
        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction), soapEndpointUrl);

            // Print the SOAP Response
            System.out.println("Response SOAP Message:");
            soapResponse.writeTo(System.out);
            System.out.println();

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }
    } 
	
	public static void main(String[] args) {
		String soapEndpointUrl = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso";
        String soapAction = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso?op=NumberToWords";

        callSoapWebService(soapEndpointUrl, soapAction);
	}
}
