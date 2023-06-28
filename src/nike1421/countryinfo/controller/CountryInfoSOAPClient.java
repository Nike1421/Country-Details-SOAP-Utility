package nike1421.countryinfo.controller;

import jakarta.xml.soap.MessageFactory;
import jakarta.xml.soap.MimeHeaders;
import jakarta.xml.soap.SOAPBody;
import jakarta.xml.soap.SOAPConnection;
import jakarta.xml.soap.SOAPConnectionFactory;
import jakarta.xml.soap.SOAPElement;
import jakarta.xml.soap.SOAPEnvelope;
import jakarta.xml.soap.SOAPException;
import jakarta.xml.soap.SOAPMessage;
import jakarta.xml.soap.SOAPPart;

public class CountryInfoSOAPClient {

	private static SOAPResponsePOJO callSoapWebService(String soapEndpointUrl, String soapAction, String countryISOCode) {
		SOAPResponsePOJO soapResponsePOJO = null;
		try {
			// Create SOAP Connection Factory Instance
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();

			// Create SOAP Connection
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();

			// Create SOAP Request Message
			SOAPMessage soapRequest = createSoapRequest(soapAction, countryISOCode);

			// Send SOAP Message to Web Service
			SOAPMessage soapResponse = soapConnection.call(soapRequest, soapEndpointUrl);

			// Print the SOAP Response
			System.out.println("Response SOAP Message:");
			soapResponse.writeTo(System.out);
			System.out.println();
			
			soapResponsePOJO = getResponsePOJO(soapResponse);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(
					"\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
			e.printStackTrace();
		}
		return soapResponsePOJO;
	}

	private static SOAPMessage createSoapRequest(String soapAction, String countryISOCode) throws Exception {
		// Create Message Factory Instance
		MessageFactory messageFactory = MessageFactory.newInstance();

		// Create SOAP Message Object
		SOAPMessage soapMessage = messageFactory.createMessage();

		// Add the Request Details
		createSoapEnvelope(soapMessage, countryISOCode);

		// Add Headers
		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", soapAction);

		// Save the message
		soapMessage.saveChanges();

		// Print the message for debugging purposes
		System.out.println("Request SOAP Message:");
		soapMessage.writeTo(System.out);
		System.out.println("\n");

		return soapMessage;
	}

	private static void createSoapEnvelope(SOAPMessage soapMessage, String countryISOCode) throws SOAPException {
		SOAPPart soapPart = soapMessage.getSOAPPart();

		String myNamespace = "urlns";
		String myNamespaceURI = "http://www.oorsprong.org/websamples.countryinfo";

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();

		// Add the NameSpace Declaration
		envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);

		/*
		 * Constructed SOAP Request Message: <SOAP-ENV:Envelope
		 * xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"
		 * xmlns:myNamespace="http://www.webserviceX.NET"> <SOAP-ENV:Header/>
		 * <SOAP-ENV:Body> <myNamespace:GetInfoByCity> <myNamespace:USCity>New
		 * York</myNamespace:USCity> </myNamespace:GetInfoByCity> </SOAP-ENV:Body>
		 * </SOAP-ENV:Envelope>
		 */

		// Construct the SOAP Message Body
		SOAPBody soapBody = envelope.getBody();

		// Message Body
		SOAPElement soapBodyElem = soapBody.addChildElement("FullCountryInfo", myNamespace);
		SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("sCountryISOCode");

		// Add the Parameter
		soapBodyElem1.addTextNode(countryISOCode);
	}
	
	private static SOAPResponsePOJO getResponsePOJO(SOAPMessage soapMessage) throws SOAPException{
		SOAPResponsePOJO responsePOJO = null;
		String nameSpaceString = "http://www.oorsprong.org/websamples.countryinfo";
		
		SOAPBody soapResponseBody = soapMessage.getSOAPPart().getEnvelope().getBody();
		
		
		responsePOJO = new SOAPResponsePOJO(
				soapResponseBody.getElementsByTagNameNS(nameSpaceString, "sISOCode").item(0).getTextContent(), 
				soapResponseBody.getElementsByTagNameNS(nameSpaceString, "sName").item(0).getTextContent(), 
				soapResponseBody.getElementsByTagNameNS(nameSpaceString, "sCapitalCity").item(0).getTextContent(),
				soapResponseBody.getElementsByTagNameNS(nameSpaceString, "sPhoneCode").item(0).getTextContent(),
				soapResponseBody.getElementsByTagNameNS(nameSpaceString, "sContinentCode").item(0).getTextContent(),
				soapResponseBody.getElementsByTagNameNS(nameSpaceString, "sCurrencyISOCode").item(0).getTextContent(),
				soapResponseBody.getElementsByTagNameNS(nameSpaceString, "sCountryFlag").item(0).getTextContent(),
				soapResponseBody.getElementsByTagNameNS(nameSpaceString, "sName").item(1).getTextContent()
			);
				
		return responsePOJO;
	}

	public static void main(String[] args) {
		String soapEndpointUrl = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso";
        String soapAction = "http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?op=FullCountryInfo";
        SOAPResponsePOJO respMessage = callSoapWebService(soapEndpointUrl, soapAction, "IN");
        System.out.println(respMessage.toString());
	}
}
