package org.usfirst.frc.team4624.autonomous;

import org.usfirst.frc.team4624.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveLastThreeFeet extends Command {

	public DriveLastThreeFeet() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		this.setTimeout(2.7);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.driveTrain.driveJoy(.524, 0, 0);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (this.isTimedOut());

	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.driveJoy(0, 0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		System.out.println("Interupted");
	}
}