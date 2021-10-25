package qrCodeScanner;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QrCodeGenerator {
	
	private String QR_CODE_PATH = "C:\\Users\\gaura\\OneDrive\\Desktop\\QRCode-SERVER\\";
	
	public String writeQrCode(PaytmRequestBody paytmrequestbody) throws Exception {
		
		String qrcode = QR_CODE_PATH + paytmrequestbody.getUserrName() + "-QRCODE.png";
		QRCodeWriter writer = new QRCodeWriter();
		
		BitMatrix bitMatrix = writer.encode(paytmrequestbody.getUserrName()+"\n" + paytmrequestbody.getMobileNo(), BarcodeFormat.QR_CODE, 350, 350);
		
		Path path = FileSystems.getDefault().getPath(qrcode);
		
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	
		return "Generated Succesfully";
	}

	
	public static void main(String[] args) throws Exception {
		
		QrCodeGenerator codeGenerator = new QrCodeGenerator();
		
		System.out.println(codeGenerator.writeQrCode(new PaytmRequestBody("Gauraang","8708486069")));
	}
}