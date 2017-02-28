package org.usfirst.frc.team4624.autonomous;

import org.usfirst.frc.team4624.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class MoveToThreeFeet extends Command {

	NetworkTable table;
	double distance1;

	public MoveToThreeFeet() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
		table = NetworkTable.getTable("GRIP/myContoursReport");
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.driveTrain.driveJoy(0, 0, 0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {

		
		double[] defaultValueHeight = new double[0];
		double[] defaultValueWidth = new double[0];
		
		
		double width = 0, height = 0;

		// change the number of while loop iterations later; while(true){ } set
		// it up so when 20 iterations are the same the loop will break

		try {
			double[] heights = table.getNumberArray("height", defaultValueHeight);
			double[] widths = table.getNumberArray("width", defaultValueWidth);
			height = heights[0];
			width = widths[0];

		} catch (NullPointerException e) {
			System.err.println("Null Pointer Exception: " + e.getMessage());
		}

		
		
		SmartDashboard.putNumber("height", height);
		SmartDashboard.putNumber("width", width);

		// distance calculations
		int FOV = 480;
		double TargetHeight = .1145833;
		
		if ((height / width) <= 4 && (height / width) >= 0) {
			distance1 = (1.0357 * (TargetHeight * FOV) / (2 * height * Math.tan(.125)));
			SmartDashboard.putNumber("Distance", (distance1));
		}

		Robot.driveTrain.driveJoy(.524, 0, 0);
	}
		

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		//may need to change at competition
		return (distance1 < 4);
		
		
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrain.driveJoy(0, 0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		System.out.println("Interupted");
		Robot.driveTrain.driveJoy(0, 0, 0);
	}
}