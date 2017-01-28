package team1065.robot.frc2017.commands;

import edu.wpi.first.wpilibj.command.Command;
import team1065.robot.frc2017.Robot;


public class DriveWithJoysticks extends Command {

    public DriveWithJoysticks() {
    	requires(Robot.driveTrain);
    }

    protected void initialize() {
    }

    protected void execute() {
    	double leftY = Robot.oi.getLeftJoystickY();
    	double rightY = Robot.oi.getRightJoystickY();
    	double rightX = Robot.oi.getRightJoystickX();
    	
    	if(Robot.oi.getRightJoystickTop()){
    		//TODO: replace left top button with joystick difference calculation
    		if(Robot.oi.getLeftJoystickTop()){
    		    Robot.driveTrain.mecanumStraightDrive(rightX, rightY);
    		}
    		else{
    			Robot.driveTrain.mecanumDrive(rightX, rightY, leftY);
    		}
    	}
    	else{
    		//TODO: replace left top button with joystick difference calculation
    		if(Robot.oi.getLeftJoystickTop()){
    			Robot.driveTrain.straightDrive((leftY + rightY)/2);
    		}
    		else{
    			Robot.driveTrain.tankDrive(leftY, rightY);
    		}
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
