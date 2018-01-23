package bad.robot.blinkstick;

public interface BlinkStick {
	void setMode(Mode mode) throws BlinkstickException;
	Mode getMode() throws BlinkstickException;

	void setColor(int r, int g, int b) throws BlinkstickException;
	void setColor(int value) throws BlinkstickException;
	void setColor(Color color) throws BlinkstickException;

	void setColors(byte[] colorData) throws BlinkstickException;
	void setColors(Channel channel, byte[] colorData) throws BlinkstickException;

	void setIndexedColor(int channel, int index, int r, int g, int b) throws BlinkstickException;
	void setIndexedColor(int channel, int index, int value) throws BlinkstickException;
	void setIndexedColor(int index, Color color) throws BlinkstickException;

	void setRandomColor() throws BlinkstickException;
	void turnOff() throws BlinkstickException;

	int getColor();

	void setInfoBlock1(String value) throws BlinkstickException;
	void setInfoBlock2(String value) throws BlinkstickException;
	String getInfoBlock1() throws BlinkstickException;
	String getInfoBlock2() throws BlinkstickException;

	String getManufacturer();
	String getProductDescription();
	String getSerial();

}
