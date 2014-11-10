package se.qrengine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

public class URLQRCreator {
	public void create(URL url, String ouputPath) throws FileNotFoundException {
		File file = new File(ouputPath);
		QRCode.from(url.toString()).to(ImageType.PNG).writeTo(new FileOutputStream(file));
		System.out.println("QRCode is created and saved as "+file.getAbsolutePath());
	}

	public static void main(String[] args) throws MalformedURLException,
			FileNotFoundException {
		if (args.length != 2) {
			System.out
					.println("URLQRCreator needs two parameters: URL OutputPath");
			return;
		}
		String url = args[0];
		String ouputPath = args[1];
		URLQRCreator creator = new URLQRCreator();
		creator.create(new URL(url), ouputPath);
	}
}
