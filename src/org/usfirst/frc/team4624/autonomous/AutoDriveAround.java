package org.usfirst.frc.team4624.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDriveAround extends CommandGroup {
	
	/**
	 * Example auto period sequence
	 */
	public AutoDriveAround() {
		addSequential(new AutoDrive(0, -.7, 0, 4));
		
	}
}