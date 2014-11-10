package se.qrengine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

public class TextQRCreator {
	private static final Logger logger = LogManager
			.getLogger(TextQRCreator.class);

	public void create(String text, String ouputPath)
			throws FileNotFoundException {
		File file = new File(ouputPath);
		QRCode.from(text).to(ImageType.PNG).writeTo(new FileOutputStream(file));
		logger.info("QRCode is created to: " + file.getAbsolutePath());
	}

	public static void main(String[] args) throws MalformedURLException,
			FileNotFoundException {
		if (args.length != 2) {
			System.out
					.println("StringQRCreator needs two parameters: Text OutputPath");
			return;
		}
		String text = args[0];
		String ouputPath = args[1];
		TextQRCreator creator = new TextQRCreator();
		creator.create(text, ouputPath);
	}
}
