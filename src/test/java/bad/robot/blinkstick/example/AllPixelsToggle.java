package bad.robot.blinkstick.example;

import bad.robot.blinkstick.BlinkstickException;
import bad.robot.blinkstick.Usb;

import static bad.robot.blinkstick.Colors.Black;
import static bad.robot.blinkstick.Colors.Red;
import static bad.robot.blinkstick.Mode.Normal;

public class AllPixelsToggle {

	public static void main(String... args) {
		Usb.findFirstBlinkStick().map(stick -> {
			try {
				stick.setMode(Normal);
				stick.setColor(Red);
				Sleep.sleep(200);
				stick.setColor(Black);
				Sleep.sleep(200);
			} catch (BlinkstickException e) {
				e.printStackTrace();
			}
			return null;
		});
		System.exit(0);
	}
}
