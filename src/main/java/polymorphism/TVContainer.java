//package polymorphism;
//
//public class TVContainer {
//	
//	// 객체 생성하지 않고 메서드 호출 가능 (메서드 하나밖에 없는 클래스의 객체 생성 하지 말고)
//	public static Object getBean (String id) {
//	// Object 타입으로 묵시적 형변환 	
//		
//		if(id.equals("lg") ) {
//			return new LgTV();
//		} else if (id.equals("samsung")) {
//			return new SamsungTV();
//		} else if (id.equals("google")) {
//			return new GoogleTV();
//		}
//		return null;
//	}
//
//}


// 티비 추가 될 때 마다 계속 자바소스 수정, 컴파일 다시됨 
// 0. TVContainer 삭제  
// 1. src/main/webapp/WEB-INF/lib 에 복붙  
// 2. src/main/resources/applicationContext.xml (source folder, Spring Bean Configuration File)



