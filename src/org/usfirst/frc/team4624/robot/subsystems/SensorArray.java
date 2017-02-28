
package org.usfirst.frc.team4624.robot.subsystems;

import org.usfirst.frc.team4624.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class SensorArray extends Subsystem {
	
	private Ultrasonic	sensor;
	private AHRS		navX;
	
	public void initDefaultCommand() {
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public SensorArray() {
		sensor = new Ultrasonic(RobotMap.gearBoxDistancePing, RobotMap.gearBoxDistanceEcho);
		sensor.setEnabled(true);
		sensor.setAutomaticMode(true);
		try {
			navX = new AHRS(SPI.Port.kMXP);
		}
		catch (RuntimeException ex) {
			DriverStation.reportError("Error instantiating navX MXP: " + ex.getMessage(), true);
		}
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
	
	public float getYaw() {
		return navX.getYaw();
	}
	
	public void resetNavX() {
		navX.reset();
	}
}
