package gameelements;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
public class ImageSheet {
	private BufferedImage image;
	 public ImageSheet(String x1) {
		image = (BufferedImage) getImage(x1);
		}

	public  Image grabImage(int x, int y) {
		return image.getSubimage(x*60, y*60, 60 , 60);
	}
	public static Image getImage(String path) {
		try {
			return ImageIO.read(ImageSheet.class.getResource("/resources/"+ path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}





