package bad.robot.blinkstick;

import com.codeminders.hidapi.HIDDevice;
import com.codeminders.hidapi.HIDDeviceInfo;
import com.codeminders.hidapi.HIDManager;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static bad.robot.blinkstick.Callable.*;
import static bad.robot.blinkstick.Device.*;
import static com.codeminders.hidapi.ClassPathLibraryLoader.loadNativeHIDLibrary;
import static java.util.stream.Collectors.*;

public class Usb {

	private static boolean loaded = false;

	static {
		loadLibrary();
	}

	private static boolean loadLibrary() {
		if (!loaded)
			loaded = loadNativeHIDLibrary();
		return loaded;
	}

	public static List<Device> devices() {
		return findAllDevices()
			.stream()
			.map(info -> new Device(info.getManufacturer_string(), info.getProduct_string(), info.getSerial_number(), info.getVendor_id(), info.getProduct_id()))
			.collect(toList());
	}

	public static Optional<BlinkStick> findFirstBlinkStick() {
		return findFirstBlinkStick(true);
	}

	public static Optional<BlinkStick> findFirstBlinkStick(boolean rateLimit) {
		return findAllBlinkStickDevices()
			.stream()
			.findFirst()
			.map(hidDeviceInfo -> createBlinkStick(hidDeviceInfo, rateLimit));
	}

	public static Optional<BlinkStick> findBlinkStickBy(String serial) {
		return findBlinkStickBy(serial, true);
	}

	public static Optional<BlinkStick> findBlinkStickBy(String serial, boolean rateLimit) {
		return findAllBlinkStickDevices()
			.stream()
			.filter(info -> info.getSerial_number().equals(serial))
			.map(hidDeviceInfo -> createBlinkStick(hidDeviceInfo, rateLimit))
			.findFirst();
	}

	public static List<BlinkStick> findAllBlinkSticks() {
		return findAllBlinkSticks(true);
	}

	public static List<BlinkStick> findAllBlinkSticks(boolean rateLimit) {
		return findAllBlinkStickDevices()
            .stream()
			.map(hidDeviceInfo -> createBlinkStick(hidDeviceInfo, rateLimit))
			.collect(toList());
	}

	private static List<HIDDeviceInfo> findAllDevices() {
		Callable<List<HIDDeviceInfo>, IOException> callable = new Callable<List<HIDDeviceInfo>, IOException>() {
			public List<HIDDeviceInfo> call() throws IOException {
				return Arrays.asList(HIDManager.getInstance().listDevices());
			}
		};
		return wrapExceptions(callable);
	}

	private static List<HIDDeviceInfo> findAllBlinkStickDevices() {
		return findAllDevices()
			.stream()
			.filter(info -> info.getVendor_id() == BlinkStickVendorId && info.getProduct_id() == BlinkStickProductName)
			.collect(toList());
	}

	private static BlinkStick createBlinkStick(HIDDeviceInfo info, boolean rateLimit) {
		try {
			HIDDevice device = Optional.ofNullable(info.open()).orElseThrow(() ->
				new NullPointerException("Failed to open USB device, the native open() method returned null. Could be a OS/driver issue, check your library path. Otherwise, I have no idea.")
			);

			return rateLimit ?
				new RateLimitedBlinkStick(new CodemindersApiBlinkStick(device)).createProxy() :
				new CodemindersApiBlinkStick(device);

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
