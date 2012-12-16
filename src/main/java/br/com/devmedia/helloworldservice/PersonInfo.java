package br.com.devmedia.helloworldservice;


import javax.activation.DataHandler;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlType;


@XmlType
public class PersonInfo {
	
	private DataHandler binaryData;

	@XmlMimeType("application/octet-stream")
	public DataHandler getBinaryData() {
		return binaryData;
	}

	public void setBinaryData(DataHandler binaryData) {
		this.binaryData = binaryData;
	}
	
	
}