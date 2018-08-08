package test;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

public class Test1_4 {
	
	public static void main(String[] args) throws IOException {
		
		byte[] imageByte;
		
		String path = Test1_4.class.getResource("aws_logo_105x39.png").getPath();
		
		BufferedImage image = ImageIO.read(new File(path));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(image, "png", baos);
		baos.flush();
		
		imageByte = baos.toByteArray();
		System.out.println(Base64.getEncoder().encodeToString(imageByte));
		
	}
}
