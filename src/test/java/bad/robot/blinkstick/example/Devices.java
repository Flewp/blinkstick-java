package bad.robot.blinkstick.example;

import static bad.robot.blinkstick.Usb.devices;
import static bad.robot.blinkstick.Usb.findAllBlinkSticks;

public class Devices {
	public static void main(String... args) {
		devices().forEach(device -> System.out.println(device.toString()));
		findAllBlinkSticks().forEach(blinkStick -> System.out.printf("%n%s in %s mode, colour %s%n", blinkStick.getProduct(), blinkStick.getMode(), blinkStick.getColorString()));
		System.exit(0);
	}

}