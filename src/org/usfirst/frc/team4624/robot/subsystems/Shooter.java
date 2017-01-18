
package org.usfirst.frc.team4624.robot.subsystems;

import org.usfirst.frc.team4624.robot.RobotMap;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	final VictorSP sMotor = new VictorSP(RobotMap.shooterMotor);

    public void initDefaultCommand() {
        
    }
    
    public void displayPower() {
    	double power = sMotor.get();
    	SmartDashboard.putNumber("Shooter Speed", power);
    }
    
    public void setSpeed(int speed) {
    	sMotor.set(speed);
    }
    
    public void stop() {
    	sMotor.set(0);
    }
}

