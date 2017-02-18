package org.usfirst.frc.team4624.robot.subsystems;

import org.usfirst.frc.team4624.robot.RobotMap;
import org.usfirst.frc.team4624.robot.commands.Agitate;
import org.usfirst.frc.team4624.robot.commands.Climb;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem{
	
	

	VictorSP climber = new VictorSP(RobotMap.climberMotor);
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new Climb());
		
	}
	
	
	public void climb(){
		climber.set(1.0);
	}
	
	public void stop(){
		climber.disable();
	}

}
