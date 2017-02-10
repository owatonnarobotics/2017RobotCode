
package org.usfirst.frc.team4624.robot.subsystems;

import org.usfirst.frc.team4624.robot.RobotMap;
import org.usfirst.frc.team4624.robot.commands.Pickup;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeMech extends Subsystem {
    
	final VictorSP pMotor = new VictorSP(RobotMap.pickupMotor);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Pickup());
    }
    
    public void pickup() {
    	pMotor.set(1.0);
    }
    
    public void extrude() {
    	pMotor.set(-1.0);
    }
    
    public void stop() {
    	pMotor.stopMotor();
    }
}

