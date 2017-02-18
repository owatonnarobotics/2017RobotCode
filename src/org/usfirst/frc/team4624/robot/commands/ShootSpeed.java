
package org.usfirst.frc.team4624.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4624.robot.Robot;

/**
 *
 */
public class ShootSpeed extends Command {
	
	public ShootSpeed() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.shooter);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.shooter.setSpeed(0);
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double power = 1 - ((Robot.oi.joystick.getThrottle() + 1)/2);
		Robot.shooter.setSpeed(power);
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}
	
	// Called once after isFinished returns true
	protected void end() {
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
