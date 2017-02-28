package org.usfirst.frc.team4624.autonomous;

import org.usfirst.frc.team4624.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AdjustCenterX extends Command {

	NetworkTable table;
	int counter;
	boolean TorF;
	int counter2;
	double distance1;
	int outofscope;
	double avgCenterX;

	public AdjustCenterX() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
		table = NetworkTable.getTable("GRIP/myContoursReport");
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		counter = 0;
		counter2 = 0;
		TorF = false;
		outofscope = 0;
		this.setTimeout(7.5);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		double[] defaultValueCenterX = new double[0];
	
		double[] centerXs = table.getNumberArray("centerX", defaultValueCenterX);
		

		avgCenterX = 0;

		try {
			 avgCenterX = (.5 * (centerXs[1] + centerXs[0]));
		} catch (IndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}

		SmartDashboard.putNumber("avgCenterX", avgCenterX);
	
		
		
		if (avgCenterX < 400) {
			Robot.driveTrain.driveJoy(0, -.465, 0);
		} if (avgCenterX > 440) {
			Robot.driveTrain.driveJoy(0, .465, 0);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (avgCenterX > 400 && avgCenterX < 440);

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