
package org.usfirst.frc.team4624.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4624.robot.Robot;

/**
 *
 */
public class Shoot extends Command {
	
	double power = .9;
	
	public Shoot() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.shooter);
		requires(Robot.agitator);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.shooter.setSpeed(0);
		Robot.agitator.stop();
		this.setTimeout(.5);
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.shooter.setSpeed(power);
		if (this.isTimedOut()) {
			Robot.agitator.start();
		}
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}
	
	// Called once after isFinished returns true
	protected void end() {
		Robot.shooter.setSpeed(0.0);
		Robot.agitator.stop();
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		Robot.shooter.setSpeed(0.0);
		Robot.agitator.stop();
	}
}
