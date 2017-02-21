
package org.usfirst.frc.team4624.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4624.robot.Robot;

/**
 *
 */
public class AutoRotate extends Command {
	
	private float	targetAngle		= 0.0f;
	private float	acceptedError	= 1.0f;
	
	public AutoRotate(float angle) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
		requires(Robot.sensorArray);
		targetAngle = angle;
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.driveTrain.stop();
		
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		boolean turn = true;
		
		float currentPos = Robot.sensorArray.getYaw();
		float targetPos;
		targetPos = targetAngle + 180;
		currentPos = currentPos + 180;
		if (targetPos > currentPos) {
			if (targetPos - currentPos >= 180) {
				turn = true;
			}
			else {
				turn = false;
			}
		}
		else {
			if (currentPos - targetPos >= 180) {
				turn = false;
			}
			else {
				turn = true;
			}
		}
		
		if (!turn) {
			Robot.driveTrain.driveJoy(0, 0, ((Math.abs(Math.abs(targetAngle) - Math.abs(Robot.sensorArray.getYaw()))) / 360) + .125);
		}
		else {
			Robot.driveTrain.driveJoy(0, 0, -((Math.abs(Math.abs(targetAngle) - Math.abs(Robot.sensorArray.getYaw()))) / 360) - .125);
		}
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (Math.abs(Math.abs(targetAngle) - Math.abs(Robot.sensorArray.getYaw())) > acceptedError);
	}
	
	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.stop();
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.driveTrain.stop();
	}
}
