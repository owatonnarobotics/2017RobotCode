package org.usfirst.frc.team4624.robot.subsystems;

import org.usfirst.frc.team4624.robot.Robot;
import org.usfirst.frc.team4624.robot.RobotMap;
import org.usfirst.frc.team4624.robot.commands.GetDistance;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SensorArray extends Subsystem{
	      private Ultrasonic sensor;// = new Ultrasonic(RobotMap.ECHO_CHANNEL, RobotMap.PING_CHANNEL);
	    
	    public SensorArray(){
	        sensor = new Ultrasonic(RobotMap.echoChannel, RobotMap.pingChannel);
	        sensor.setEnabled(true);
	        sensor.setAutomaticMode(true);
	    }
	   
	    protected void initDefaultCommand() {
	    	setDefaultCommand(new GetDistance());
	    }
	    
	    public double getDistance(){
	        double distance = sensor.getRangeInches();
	        return distance;
	    }
	    
	    public void displayDistance() {
	    	double distance = this.getDistance();
	    	SmartDashboard.putNumber("UltraS. Dist.", distance);
	    }
	}

