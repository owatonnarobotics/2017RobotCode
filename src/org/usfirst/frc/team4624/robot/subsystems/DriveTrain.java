
package org.usfirst.frc.team4624.robot.subsystems;

import org.usfirst.frc.team4624.robot.Robot;
import org.usfirst.frc.team4624.robot.RobotMap;
import org.usfirst.frc.team4624.robot.commands.Drive;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		double ymove = Math.pow(y, 3);
		double rmove = Math.pow(rotation, 3);
		driveTrain.mecanumDrive_Cartesian(xmove, ymove, rmove, 0);

	}

	public void driveRaw(double x1, double y1, double x2) {
		double x1move = (Math.pow(x1, 3));
		double x2move = Math.pow(x2, 3);
		double y1move = Math.pow(y1, 3);

		double deadZone = .07;

		if (x1move < deadZone && x1move > -deadZone) {
			x1move = 0;
		}
		if (y1move < deadZone && y1move > -deadZone) {
			y1move = 0;
		}
		if (x2move < deadZone && x2move > -deadZone) {
			x2move = 0;
		}

		if ((Robot.oi.joystick.getRawButton(1))) { // should invert controls
			set(fLMotor, (-x1move + y1move + (x2move / 2)));
			set(bLMotor, (x1move + y1move + (x2move / 2)));
			set(fRMotor, (-x1move - y1move + (x2move / 2)));
			set(bRMotor, (x1move - y1move + (x2move / 2)));
		} else {
			set(fLMotor, (x1move - y1move + (x2move / 2)));
			set(bLMotor, (-x1move - y1move + (x2move / 2)));
			set(fRMotor, (x1move + y1move + (x2move / 2)));
			set(bRMotor, (-x1move + y1move + (x2move / 2)));
		}
	}

	/**
	 * Rotates to a given angle based on the NavX's gyro
	 * 
	 * @param targetAngle
	 *            targeted angle
	 */

	@SuppressWarnings("deprecation")
	public void autoRotate(float targetAngle) {
		float acceptedError = 2.0f;
		boolean turn = false;
		int timeSince = 1;

		while (Math.abs(Math.abs(targetAngle) - Math.abs(Robot.navX.getYaw())) > acceptedError) {
			//SmartDashboard.putNumber("NavX Gyro: ", Robot.navX.getYaw());
			turn = whichWay(targetAngle);

			if (!turn) {
				set(fLMotor, ((Math.abs(Math.abs(targetAngle) - Math.abs(Robot.navX.getYaw()))) / 360) + .1);
				set(fRMotor, ((Math.abs(Math.abs(targetAngle) - Math.abs(Robot.navX.getYaw()))) / 360) + .1);
				set(bLMotor, ((Math.abs(Math.abs(targetAngle) - Math.abs(Robot.navX.getYaw()))) / 360) + .1);
				set(bRMotor, ((Math.abs(Math.abs(targetAngle) - Math.abs(Robot.navX.getYaw())))/ 360) + .1);
				
			} else {
				set(fLMotor, -((Math.abs(Math.abs(targetAngle) - Math.abs(Robot.navX.getYaw()))) / 360) - .1);
				set(fRMotor, -((Math.abs(Math.abs(targetAngle) - Math.abs(Robot.navX.getYaw()))) / 360) - .1);
				set(bLMotor, -((Math.abs(Math.abs(targetAngle) - Math.abs(Robot.navX.getYaw()))) / 360) - .1);
				set(bRMotor, -((Math.abs(Math.abs(targetAngle) - Math.abs(Robot.navX.getYaw()))) / 360) - .1);
			
			}
			SmartDashboard.putInt("Time Since: ", timeSince);
		}

	}

	/**
	 * Determines which way the robot should turn.
	 * 
	 * @param target
	 *            The targeted angle (Float)
	 * @return True if it should turn counter-clockwise
	 */

	public static boolean whichWay(float target) {
		// true = counter-clockwise

		float currentPos = Robot.navX.getYaw();
		float targetPos;
		targetPos = target + 180;
		currentPos = currentPos + 180;
		if (targetPos > currentPos) {
			if (targetPos - currentPos >= 180) {
				return true;
			} else
				return false;
		} else {
			if (currentPos - targetPos >= 180) {
				return false;
			} else
				return true;
		}
	}

	public void stop() {
		fLMotor.setDisabled();
		bLMotor.setDisabled();
		fRMotor.setDisabled();
		bRMotor.setDisabled();
	}

	public void set(VictorSP motor, double speed) {
		if (speed == 0) {
			motor.setDisabled();
		} else {
			motor.set(speed);
		}
	}
}
