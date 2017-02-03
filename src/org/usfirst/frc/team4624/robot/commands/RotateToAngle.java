package org.usfirst.frc.team4624.robot.commands;

import org.usfirst.frc.team4624.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RotateToAngle extends Command {

	float targetAngle;
	boolean turnRight;
	public boolean isDone = false;
	boolean move = false;

	public RotateToAngle(float x) {
		targetAngle = x;

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.driveTrain.stop();
	
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// use this for Xbox controls
		// Robot.driveTrain.driveRaw(Robot.oi.xboxController.leftStick.getX(),
		// Robot.oi.xboxController.leftStick.getY(),
		// Robot.oi.xboxController.rightStick.getX());
		// use this for the twisty joystick
		if(Robot.oi.joystick.getRawButton(Robot.oi.turnFoward)){
			targetAngle = 0.0f;
			move = true;
		}
		if(Robot.oi.joystick.getRawButton(Robot.oi.turnRight)){
			targetAngle = 90.0f;
			move = true;
		}
		if(Robot.oi.joystick.getRawButton(Robot.oi.turnBack)){
			targetAngle = 179.9f;
			move = true;
		}
		if(Robot.oi.joystick.getRawButton(Robot.oi.turnFoward)){
			targetAngle = -90.0f;
			move = true;
		}
		if(move){
			whichWay();
			Robot.driveTrain.autoRotate(turnRight, targetAngle);
			move = false;
		}
	
	}

	public void whichWay() {
		targetAngle = targetAngle + 180;
		float actualAngle = Robot.navX.getYaw() + 180;

		if (targetAngle > actualAngle) {
			if (targetAngle - actualAngle < 180) {
				turnRight = true;
			}
		} else if (actualAngle - targetAngle > 180) {
			turnRight = true;

		} else {
			turnRight = false;
		}

	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isDone;
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