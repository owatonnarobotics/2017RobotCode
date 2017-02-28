
package org.usfirst.frc.team4624.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4624.robot.Robot;

/**
 *
 */
public class DriveToPeg extends Command {
	
	double strafeSpeed = .6;
	double yawCorrection;

    public DriveToPeg() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.stop();
    	Robot.sensorArray.resetNavX();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(Math.abs(Robot.sensorArray.getYaw()) < 2 ){
    		yawCorrection = 0;
    	} else {
    		if (Robot.sensorArray.getYaw() > 0) {
    			yawCorrection = -.2;
    		} else {
    			yawCorrection = .2;
    		}
    	}
    	
    	Robot.driveTrain.driveJoy(strafeSpeed, 0, yawCorrection);
    	System.out.println(Robot.sensorArray.getDistance());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.sensorArray.getDistance() < 10);
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
