package org.usfirst.frc.team4624.robot;

import org.usfirst.frc.team4624.robot.commands.Agitate;
import org.usfirst.frc.team4624.robot.commands.Pickup;
import org.usfirst.frc.team4624.robot.library.XboxController;
import org.usfirst.frc.team4624.template.ExampleCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator interface to the commands and command groups that allow control
 * of the robot.
 */
public class OI {
	
	public static XboxController	xboxController	= new XboxController();
	
	public static Joystick			joystick		= new Joystick(0);
	
	public static JoystickButton	button1, button2, button3, button4, pickupButton, agitatorButton, button7, button8, button9, button10, button11;
	
	public static final int climb = 7;
	public static final int pickup = 5;
	public static final int agitate = 6;
	public static final int slow = 2;
	public static final int reverse = 3;
	public static final int shoot = 1;
	public OI() {
		
		button1        = new JoystickButton(joystick, 1);
		button2        = new JoystickButton(joystick, 2);
		button3        = new JoystickButton(joystick, 3);
		button4        = new JoystickButton(joystick, 4);
		pickupButton   = new JoystickButton(joystick, pickup);
		agitatorButton = new JoystickButton(joystick, agitate);
		button7        = new JoystickButton(joystick, 7);
		button8        = new JoystickButton(joystick, 8);
		button9        = new JoystickButton(joystick, 9);
		button10       = new JoystickButton(joystick, 10);
		button11       = new JoystickButton(joystick, 11);
		
		agitatorButton.toggleWhenActive(new Agitate());
		pickupButton.toggleWhenActive(new Pickup());
		
	}
}
