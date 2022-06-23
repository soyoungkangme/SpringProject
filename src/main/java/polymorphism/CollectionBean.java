package polymorphism;

public class CollectionBean {
	
	
	// private String[] addressList = {"성수동", "면목동", "신림동"};  ->  주소 목록이 늘거나 줄면 컴파일 다시 해야함 
	private String[] addressList;    // 배열객체의 데이터를 자바소스 아닌 xml로 관리 
	
	public String[] getAddressList() {
		return addressList;
	}
	
	public void setAddressList(String[] addressList) {   
		this.addressList = addressList;     // 외부에서 인자 받아서 멤버변수에 넣음 
	}

}

// 배열(String[]) , List<String> => 똑같이 <list> 사용, User에서 get 메서드의 반환타입만 변경 


// 세군데 변경 (String[]) 
// List<String> : 순서, 중복 O
// Set<String> : X 
// Map : 키밸류 형태로 저장 (밸류로 객체 저장 가능) 
// Properties : 키밸류 형태로 저장, 문자나 숫자만 밸류로 저장 가능 