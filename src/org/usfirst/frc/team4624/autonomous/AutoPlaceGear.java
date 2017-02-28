package org.usfirst.frc.team4624.autonomous;



import org.usfirst.frc.team4624.robot.commands.DriveToPeg;

import edu.wpi.first.wpilibj.command.CommandGroup;



public class AutoPlaceGear extends CommandGroup {
    
    
    
    /**
     * Example auto period sequence
     */
    public AutoPlaceGear() {
    	addSequential(new DriveToPeg());
        /*
        addSequential( new DriveToTote() );
        addSequential( new GrabTote() );
        addSequential( new LiftTote() );
        addSequential( new MoveToZone() );
        addSequential( new TurnToCenter() );
        addSequential( new IdentifyStack() );
        addSequential( new DriveToTote2() );
        addSequential( new StackTote() );
        addSequential( new AlignYourself() );
        */
    }
}