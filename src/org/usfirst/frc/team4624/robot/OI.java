package org.usfirst.frc.team4624.robot;

import org.usfirst.frc.team4624.robot.commands.Agitate;
import org.usfirst.frc.team4624.robot.commands.AutoRotate;
import org.usfirst.frc.team4624.robot.commands.Pickup;
import org.usfirst.frc.team4624.robot.commands.Shoot;
import org.usfirst.frc.team4624.robot.library.XboxController;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator interface to the commands and command groups that allow control
 * of the robot.
 */
public class OI {
	
	public static XboxController	xboxController	= new XboxController();
	
	public static Joystick			joystick		= new Joystick(0);
	
	public static JoystickButton	shooterButton, button2, button3, button4, pickupButton, agitatorButton, button7, button8,
			turnForwardButton, turnLeftButton, turnBackButton, turnRightButton;
	
	public static final int			shoot			= 1;
	public static final int			slow			= 2;
	public static final int			reverse			= 3;
	
	public static final int			pickup			= 5;
	public static final int			agitate			= 6;
	public static final int			climb			= 7;
	public static final int			resetNavX		= 8;
	public static final int			turnForward		= 9;
	public static final int			turnLeft		= 10;
	public static final int			turnBack		= 11;
	public static final int			turnRight		= 12;
	
	public OI() {
		
		shooterButton = new JoystickButton(joystick, shoot);
		button2 = new JoystickButton(joystick, 2);
		button3 = new JoystickButton(joystick, 3);
		button4 = new JoystickButton(joystick, 4);
		pickupButton = new JoystickButton(joystick, pickup);
		agitatorButton = new JoystickButton(joystick, agitate);
		button7 = new JoystickButton(joystick, 7);
		button8 = new JoystickButton(joystick, resetNavX);
		turnForwardButton = new JoystickButton(joystick, turnForward);
		turnLeftButton = new JoystickButton(joystick, turnLeft);
		turnBackButton = new JoystickButton(joystick, turnBack);
		turnRightButton = new JoystickButton(joystick, turnRight);
		
		shooterButton.toggleWhenActive(new Shoot());
		agitatorButton.toggleWhenActive(new Agitate());
		pickupButton.toggleWhenActive(new Pickup());
		turnForwardButton.whenPressed(new AutoRotate(0.0f));
		turnLeftButton.whenPressed(new AutoRotate(90.0f));
		turnBackButton.whenPressed(new AutoRotate(179.0f));
		turnRightButton.whenPressed(new AutoRotate(-90.0f));
		
	}
}
