package org.usfirst.frc.team4624.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into to a variable name. This provides flexibility changing
 * wiring, makes checking the wiring easier and significantly reduces the number of magic numbers floating around.
 */
public class RobotMap {
	
	// PWM
	public static final int	frontLeftMotor	= 10;
	public static final int	frontRightMotor	= 11;
	public static final int	backLeftMotor	= 12;
	public static final int	backRightMotor	= 13;
	public static final int	pickupMotor		= 4;
	public static final int	shooterMotor	= 5;
	public static final int	climberMotor	= 6;
	public static final int cameraPanServo  = 7;
	public static final int cameraTiltServo = 8;
	
	// DIO
	public static final int	gearBoxDistanceEcho	= 0;
	// public static final int ECHO_CHANNEL_2 = 1;
	// public static final int ECHO_CHANNEL_3 = 2;
	// public static final int ECHO_CHANNEL_4 = 3;
	// public static final int ECHO_CHANNEL_5 = 4;
	// public static final int ECHO_CHANNEL_6 = 5;
	public static final int	gearBoxDistancePing	= 6;
	public static final int	PING_CHANNEL_2	= 7;
	
	// RELAY
	public static final int	AGITATOR		= 0;
	
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
