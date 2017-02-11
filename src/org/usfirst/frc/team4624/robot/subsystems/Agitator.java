
package org.usfirst.frc.team4624.robot.subsystems;

import org.usfirst.frc.team4624.robot.RobotMap;
import org.usfirst.frc.team4624.robot.commands.Agitate;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Agitator extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Relay mixer = new Relay(RobotMap.AGITATOR);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Agitate());
    }
    
    public void start() {
    	mixer.set(Relay.Value.kOn);
    	mixer.set(Relay.Value.kReverse);
    }
    
    public void stop() {
    	mixer.set(Relay.Value.kOff);
    }
}

