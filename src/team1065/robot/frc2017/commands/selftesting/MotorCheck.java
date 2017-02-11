package team1065.robot.frc2017.commands.selftesting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.filechooser.FileSystemView;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.CommandGroup;
import team1065.robot.frc2017.RobotMap;

/**
 *
 */
public class MotorCheck extends CommandGroup {

	PowerDistributionPanel pdp = new PowerDistributionPanel();
	private Talon TMotor;
	
	public MotorCheck(int MotorPort) {
		TMotor = new Talon(MotorPort);
    	
    	//addSequential(new DriveToDistance(0.4, 88, 15.0));
    	//addSequential(new RotateToAngle(.45, 60, 15.0));
    	//addSequential(new DriveToDistance(0.4, 30, 15.0));
    	double current = pdp.getCurrent(1);
    	
    	
    	
    }
}
