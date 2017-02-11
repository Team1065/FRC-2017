package team1065.robot.frc2017.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import team1065.robot.frc2017.Robot;

/**
 *
 */
public class DriveToDistance extends Command {
	double speed, distance;
	
    public DriveToDistance(double speed, double distance, double time) {
    	requires(Robot.driveTrain);
    	this.speed = speed;
        this.distance = Math.abs(distance);
        this.setTimeout(time);
    }

    //set speed negative to go backwards
    protected void initialize() {
    	Robot.driveTrain.resetEncoder();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double motorSpeed = speed;
    	if(Math.abs(Robot.driveTrain.getEncoderDistance()) > distance-12){ //slow down 12 inches from the target
    		motorSpeed = motorSpeed * 0.5;
    	}
    	
    	Robot.driveTrain.straightDrive(motorSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.driveTrain.getEncoderDistance()) >= distance || this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
