
package org.usfirst.frc.team4624.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4624.robot.Robot;

/**
 *
 */
public class AdjustCamera extends Command {

    public AdjustCamera() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.cameraPanTilt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.cameraPanTilt.adjustTilt(.4);
    	if (Robot.oi.joystick.getPOV() == 0) {
    		Robot.cameraPanTilt.adjustPan(0);
    	} else if (Robot.oi.joystick.getPOV() == 90) {
    		Robot.cameraPanTilt.adjustPan(.5);
    	}
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
