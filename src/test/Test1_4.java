package test;

import java.io.IOException;

public class Test1_4 {

	static class Data{
		int a = 10;
		public int add(int value) { return a += value;}
	}
	
	public static void main(String[] args) throws IOException {
		Data data = new Data();
		
		System.out.println(data.a != 10 ? data.add(1000) : data.add(100000));
		
		
//		byte[] imageByte;
//		
//		String path = Test1_4.class.getResource("aws_logo_105x39.png").getPath();
//		
//		BufferedImage image = ImageIO.read(new File(path));
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		ImageIO.write(image, "png", baos);
//		baos.flush();
//		
//		imageByte = baos.toByteArray();
//		System.out.println(Base64.getEncoder().encodeToString(imageByte));
		
	}
}
