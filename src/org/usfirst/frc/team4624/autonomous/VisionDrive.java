package org.usfirst.frc.team4624.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class VisionDrive extends CommandGroup {
	public VisionDrive() {
		addSequential(new AutoAllignCamera());
		addSequential(new MoveToThreeFeet());
		//addSequential(new AdjustRotation());
		addSequential(new AdjustCenterX());
		addSequential(new DriveLastThreeFeet());
	}
}