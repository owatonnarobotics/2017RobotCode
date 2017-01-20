
package org.usfirst.frc.team4624.robot.subsystems;

import org.usfirst.frc.team4624.robot.RobotMap;
import org.usfirst.frc.team4624.robot.commands.Drive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	final VictorSP fLMotor = new VictorSP(RobotMap.frontLeftMotor);
	final VictorSP fRMotor = new VictorSP(RobotMap.frontRightMotor);
	final VictorSP bLMotor = new VictorSP(RobotMap.backLeftMotor);
	final VictorSP bRMotor = new VictorSP(RobotMap.backRightMotor);
	
	RobotDrive driveTrain = new RobotDrive(fLMotor, bLMotor, fRMotor, bRMotor);
	
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Drive());
    }
    
    public void drive(double x, double y, double rotation) {
        double xmove = Math.pow(x, 3);
        double ymove = Math.pow(y,  3);
        double rmove = Math.pow(rotation, 3);
        driveTrain.mecanumDrive_Cartesian(xmove, ymove, rmove, 0);
           
    }
    
    public void driveSkid(double x1, double y1, double x2, double y2) {
    	double x1move = Math.pow(x1, 3);
    	double x2move = Math.pow(x2, 3);
    	double y1move = Math.pow(y1, 3);
    	double y2move = Math.pow(y2, 3);
    	
    	/*
    	if (x1move < .05 && x1move > -.05) {
    		fLMotor.set(-y1move);
    		bLMotor.set(-y1move);
    	} if (x1move >= .05 || x1move <= -.05) {    	
    		fLMotor.set(x1move);
    		bLMotor.set(-x1move - y1move);
    	} if (x2move < .05 && x2move > -.05) {
    		fRMotor.set(y2move);
    		bRMotor.set(y2move);
    	} if (x2move >= .05 || x2move <= -.05) {    	
    		fRMotor.set(x2move);
    		bRMotor.set(-x2move - y2move);
    	}
    	*/
    	
    	if (x2move > .05 || x2move < -.05) {
    		fLMotor.set(x2move);
    		bLMotor.set(x2move);
    		fRMotor.set(x2move);
    		bRMotor.set(x2move);
    	} if (x1move > .05 || x1move < -.05) {
    		fLMotor.set(x1move);
    		bLMotor.set(-x1move);
    		fRMotor.set(x1move);
    		bRMotor.set(-x1move);
    	} else {
    		fLMotor.set(y1move);
    		bLMotor.set(y1move);
    		fRMotor.set(y1move);
    		bRMotor.set(y1move);
    	}
    
    }
    
    public void stop() {
    	driveTrain.mecanumDrive_Cartesian(0, 0, 0, 0);
    }
    
}

