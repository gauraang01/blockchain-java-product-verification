package qrCodeScanner;

public class PaytmRequestBody {

	private String userrName;
	private String mobileNo;
	
	public PaytmRequestBody(String userrName, String mobileNo) {
		super();
		this.userrName = userrName;
		this.mobileNo = mobileNo;
	}
	
	
	public String getUserrName() {
		return userrName;
	}
	public void setUserrName(String userrName) {
		this.userrName = userrName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
}
