
package org.usfirst.frc.team4624.autonomous;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4624.robot.Robot;

/**
 *
 */
public class AutoAllignCamera extends Command {

    public AutoAllignCamera() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.cameraPanTilt);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	this.setTimeout(.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.cameraPanTilt.adjustPan(.5);
    	Robot.cameraPanTilt.adjustTilt(.4);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
