
package org.usfirst.frc.team4624.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4624.robot.Robot;

/**
 *
 */
public class Agitate extends Command {
	
	public static boolean move = false;

    public Agitate() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.agitator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.agitator.stop();
    	try {
			this.wait(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.joystick.getRawButton(Robot.oi.agitate)){
    		move = !move;
    	}
    	if(move){
    		Robot.agitator.start();
    	}else Robot.agitator.stop();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.agitator.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.agitator.stop();
    }
}
