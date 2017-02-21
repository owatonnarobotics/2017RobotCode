
package org.usfirst.frc.team4624.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4624.robot.Robot;

/**
 *
 */
public class Drive extends Command {
	
	public Drive() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
		requires(Robot.sensorArray);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.driveTrain.stop();
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double slowFactor = .58;
		// use this for Xbox controls
		//Robot.driveTrain.driveXBox(Robot.oi.xboxController.leftStick.getX(), Robot.oi.xboxController.leftStick.getY(), 
		//		Robot.oi.xboxController.rightStick.getX());
		//use this for the twisty joystick
		if (Robot.oi.joystick.getRawButton(Robot.oi.slow)){
			Robot.driveTrain.driveJoy((Robot.oi.joystick.getX() * slowFactor), (Robot.oi.joystick.getY() * slowFactor), (Robot.oi.joystick.getTwist() * slowFactor));
		} else {
			Robot.driveTrain.driveJoy(Robot.oi.joystick.getX(), Robot.oi.joystick.getY(), Robot.oi.joystick.getTwist());
		}
		
		Robot.sensorArray.displayDistance();
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
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
