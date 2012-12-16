package br.com.devmedia.helloworldservice;

import java.io.File;
import java.net.URISyntaxException;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.xml.namespace.QName;
import javax.xml.ws.Binding;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class HelloWorldServiceTest {


	public static HelloService getHelloServiceNormal() {
		QName serviceName = new QName(HelloService.NS, "HelloServiceService");
		QName portName = new QName(HelloService.NS, "HelloServicePort");

		Service service = Service.create(serviceName);
		service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING,
				"http://localhost:9292/hello");

		HelloService hello = service.getPort(portName, HelloService.class);
		SOAPBinding binding = (SOAPBinding) ((BindingProvider)hello).getBinding();
		binding.setMTOMEnabled(true);
		return hello;
	}
	

	
	@Test
	public void testNormal() throws Exception {
		HelloService hello = getHelloServiceNormal();
		PersonInfo info = new PersonInfo();
		File f;
		try {
			f = new File(SimpleNormalHelloService.class.getResource("/java.png").toURI());
			DataSource ds = new FileDataSource(f);
			DataHandler dh = new DataHandler(ds);
			info.setBinaryData(dh);
			PersonInfo result = hello.digaOla(info);
			result.getBinaryData();
			Assert.assertNotNull(result);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}


}
