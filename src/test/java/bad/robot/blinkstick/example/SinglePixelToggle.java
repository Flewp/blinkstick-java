package bad.robot.blinkstick.example;

import bad.robot.blinkstick.BlinkstickException;
import bad.robot.blinkstick.Colors;
import bad.robot.blinkstick.Usb;

import static bad.robot.blinkstick.Colors.Black;
import static bad.robot.blinkstick.Mode.Ws2812;

public class SinglePixelToggle {

	public static void main(String... args) {
		Usb.findFirstBlinkStick().map(stick -> {
			try {
				stick.setMode(Ws2812);
				for (int i = 0; i < 8; i++) {
					stick.setIndexedColor(i, Colors.Green);
					Sleep.sleep(200);
					stick.setIndexedColor(i, Black);
					Sleep.sleep(200);
				}
			} catch (BlinkstickException e) {
				e.printStackTrace();
			}
			return null;
		});
		System.exit(0);
	}
}
