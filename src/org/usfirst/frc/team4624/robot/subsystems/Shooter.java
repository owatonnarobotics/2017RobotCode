
package org.usfirst.frc.team4624.robot.subsystems;

import org.usfirst.frc.team4624.robot.RobotMap;
import org.usfirst.frc.team4624.robot.commands.Drive;
import org.usfirst.frc.team4624.robot.commands.ShootSpeed;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem {
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	
	final VictorSP sMotor = new VictorSP(RobotMap.shooterMotor);
	
	public void initDefaultCommand() {
		setDefaultCommand(new ShootSpeed());
	}
	
	public void displayPower() {
		double power = sMotor.get();
		SmartDashboard.putNumber("Shooter Speed", power);
	}
	
	public void setSpeed(double speed) {
		sMotor.set(speed);
	}
	
	public void incrementSpeed(int dir) {
		if (dir > 0) {
			sMotor.set(sMotor.getSpeed() + .1);
		}
	}
	
	public void stop() {
		sMotor.set(0);
	}
}
