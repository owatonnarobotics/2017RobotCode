
package org.usfirst.frc.team4624.robot.subsystems;

import org.usfirst.frc.team4624.robot.RobotMap;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SensorArray extends Subsystem {
	
	private Ultrasonic sensor;
	
	public void initDefaultCommand() {
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public SensorArray() {
		sensor = new Ultrasonic(RobotMap.PING_CHANNEL_1, RobotMap.ECHO_CHANNEL_1);
		sensor.setEnabled(true);
		sensor.setAutomaticMode(true);
	}
	
	public double getDistance() {
		double distance = 0;
		distance = sensor.getRangeInches();
		return distance;
	}
	
	/**
	 * outputs the distance sensor info to the SmartDashboard
	 * 
	 */
	public void displayDistance() {
		double distance = this.getDistance();
		SmartDashboard.putNumber("U.S. Dist1: ", distance);
	}
}
