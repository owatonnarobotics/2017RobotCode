package org.usfirst.frc.team4624.robot;

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
	
	public static JoystickButton	button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11;
	
	public static final int climb = 7;
	public static final int pickup = 5;
	public OI() {
		
		button1 = new JoystickButton(joystick, 1);
		button2 = new JoystickButton(joystick, 2);
		button3 = new JoystickButton(joystick, 3);
		button4 = new JoystickButton(joystick, 4);
		button5 = new JoystickButton(joystick, 5);
		button6 = new JoystickButton(joystick, 6);
		button7 = new JoystickButton(joystick, 7);
		button8 = new JoystickButton(joystick, 8);
		button9 = new JoystickButton(joystick, 9);
		button10 = new JoystickButton(joystick, 10);
		button11 = new JoystickButton(joystick, 11);
		
		//xboxController.rb.whenPressed(new ShootUp());
		//xboxController.lb.whenPressed(new ShootDown());
		//xboxController.x.whenPressed(new ShootStop());
		
	}
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	
	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.
	
	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:
	
	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());
	
	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());
	
	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
