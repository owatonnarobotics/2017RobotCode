
package org.usfirst.frc.team4624.robot.subsystems;

import org.usfirst.frc.team4624.robot.RobotMap;
import org.usfirst.frc.team4624.robot.commands.AdjustCamera;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CameraPanTilt extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new AdjustCamera());
    }
    
    Servo pan = new Servo(RobotMap.cameraPanServo);
    Servo tilt = new Servo(RobotMap.cameraTiltServo);
    
    public void adjustPan(double position) {
    	pan.set(position);
    }
    
    public void adjustTilt(double position) {
    	tilt.set(position);
    }
    
    public double getPan() {
    	return pan.getPosition();
    }
    
    public double getTilt() {
    	return tilt.getPosition();
    }
}

