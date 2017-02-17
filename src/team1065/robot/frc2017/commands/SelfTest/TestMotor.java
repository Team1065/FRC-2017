package team1065.robot.frc2017.commands.SelfTest;

import edu.wpi.first.wpilibj.command.Command;
import team1065.robot.lib.MooseMotor;

/**
 *
 */
public class TestMotor extends Command {
    MooseMotor motor;
    boolean pass;
    public TestMotor(MooseMotor motor) {
    	this.motor = motor;
    	this.setTimeout(3);
    	pass = false;
    }
    public TestMotor(MooseMotor motor,double time) {
    	this.motor = motor;
    	this.setTimeout(time);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//TODO
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return this.isTimedOut() || pass;
    }

    // Called once after isFinished returns true
    protected void end() {
    	if(pass){
    		//TODO
    	}
    	else{
    		//TODO
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
