package org.usfirst.frc.team4624.autonomous;



import edu.wpi.first.wpilibj.command.CommandGroup;



public class AutoDriveAround extends CommandGroup {
    
    
    
    /**
     * Example auto period sequence
     */
    public AutoDriveAround() {
    	addSequential(new AutoDrive(0, -.7, 0, 4));
    
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