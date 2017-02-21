package org.usfirst.frc.team4624.autonomous;

import org.usfirst.frc.team4624.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDrive extends Command {
	
	double	xSpeed	= 0;
	double	ySpeed	= 0;
	double	rSpeed	= 0;
	double	time	= 0;
	
	/**
	 * Example auto period sequence
	 */
	public AutoDrive(double x, double y, double r, double t) {
		requires(Robot.driveTrain);
		this.xSpeed = x;
		this.ySpeed = y;
		this.rSpeed = r;
		this.time = t;
	}
	
	protected void initialize() {
		if (!(time == 0)) {
			this.setTimeout(time);
		}
		Robot.driveTrain.driveJoy(0, 0, 0);
	}
	
	protected void execute() {
		Robot.driveTrain.driveJoy(xSpeed, ySpeed, rSpeed);
	}
	
	protected boolean isFinished() {
		return this.isTimedOut();
	}
	
	protected void end() {
		Robot.driveTrain.driveJoy(0, 0, 0);
	}
	
	protected void interrupted() {
		Robot.driveTrain.driveJoy(0, 0, 0);
	}
	
}