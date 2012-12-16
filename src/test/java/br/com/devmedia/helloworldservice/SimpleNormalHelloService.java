package br.com.devmedia.helloworldservice;

import java.io.File;
import java.net.URISyntaxException;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

public class SimpleNormalHelloService implements HelloService {

	@Override
	public PersonInfo digaOla(PersonInfo info) {
		PersonInfo info2 = new PersonInfo();
		File f;
		try {
			f = new File(SimpleNormalHelloService.class.getResource("/java.png").toURI());
			DataSource ds = new FileDataSource(f);
			DataHandler dh = new DataHandler(ds);
			info2.setBinaryData(dh);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return info2;
	}



}