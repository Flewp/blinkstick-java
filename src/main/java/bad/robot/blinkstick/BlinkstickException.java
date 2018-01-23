package bad.robot.blinkstick;

public class BlinkstickException extends Exception{
    public BlinkstickException() {

    }

    public BlinkstickException(String message) {
        super(message);
    }

    public BlinkstickException(Throwable cause) {
        super(cause);
    }

    public BlinkstickException(String message, Throwable cause) {
        super(message, cause);
    }
}
