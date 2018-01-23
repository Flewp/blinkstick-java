package bad.robot.blinkstick.example;

import bad.robot.blinkstick.BlinkstickException;

import static bad.robot.blinkstick.Usb.devices;
import static bad.robot.blinkstick.Usb.findAllBlinkSticks;

public class Devices {
    public static void main(String... args) {
        devices().forEach(device -> System.out.println(device.toString()));
        findAllBlinkSticks().forEach(blinkStick -> {
            try {
                System.out.printf("%n%s in %s mode, colour %s%n", blinkStick.getProductDescription(), blinkStick.getMode(), blinkStick.getColor());
            } catch (BlinkstickException e) {
                e.printStackTrace();
            }
        });
        System.exit(0);
    }
}
