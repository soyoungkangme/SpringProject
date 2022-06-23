package polymorphism;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionUser {
	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		CollectionBean bean = (CollectionBean) container.getBean("collection");
		
		String[] addressList = bean.getAddressList();
	    // 반환 타입만 변경 -> List<String>, Set<String>, 
		
		for (String address : addressList) {
			System.out.println("---> " + address.toString());
		}
		
		container.close();
	}

}
