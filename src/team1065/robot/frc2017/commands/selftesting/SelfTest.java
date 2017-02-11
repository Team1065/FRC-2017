package team1065.robot.frc2017.commands.selftesting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.filechooser.FileSystemView;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team1065.robot.frc2017.Robot;
import team1065.robot.frc2017.RobotMap;

/**
 *
 */
public class SelfTest extends CommandGroup {

	PowerDistributionPanel pdp = new PowerDistributionPanel();
	//static String Path = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + "\\Robot\\";
	
	Timer timer;	
	
	public SelfTest() {
		
		requires(Robot.climber);
		requires(Robot.driveTrain);
		requires(Robot.shooter);
		requires(Robot.intake);
		
		timer = new Timer();
		timer.start();
		
    	/*//Check for Input File and create new file if it is missing
    	System.out.println(Path);
		File Input = new File(Path + "Input.txt");
		if(!Input.exists())
		{
			File InputDirectory = new File(Path);
			try{ InputDirectory.mkdir(); System.out.println("DIR created!"); } 
		    catch(SecurityException se){ System.out.println("Insufficient Privaledges! " + se); }
			
			try{
			    PrintWriter writer = new PrintWriter(Path + "Input.txt", "UTF-8"); writer.println("Format: <Component Name>; <Component Type>; <Component Port>; <(Required for Motors) Component Normal Current at full>; <(Optional) Component Normal Current at 0>"); writer.close();
			} catch (IOException e) { System.out.println("ERROR! " + e); }
		}
		
		//Read Information from Input File and put it into a string array
		String[][] Lines = new String[][] {};
		Lines[0][0] = "";
		try(BufferedReader br = new BufferedReader(new FileReader(Path + "Input.txt"))) 
		{
		    String line = br.readLine();  line = br.readLine(); int i = 0;
		    while (line != null) {
		    	if(line != "") {Lines[i] = line.split(";");} i++;
		    	line = br.readLine(); 
		    	}
		    try{for(int j = 0; j < Lines[i].length; j++){ Lines[i][j] = Lines[i][j].trim(); }}catch(ArrayIndexOutOfBoundsException e){}
		} 
		catch (FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
    	*/
		
		//Left Front
			Robot.driveTrain.ManualMotors(1,0,0,0);
			MotorCurrentCheck(15, 1.0, "Motor Fowards");
			Robot.driveTrain.ManualMotors(0,0,0,0);
		
			Robot.driveTrain.ManualMotors(-1,0,0,0);
			MotorCurrentCheck(15, 1.0, "Motor Backwards");
			Robot.driveTrain.ManualMotors(0,0,0,0);
		
		/*//Drive Train
		//Left Front
			Robot.driveTrain.ManualMotors(1,0,0,0);
			MotorCurrentCheck(RobotMap.PDP_LEFT_FRONT_DRIVE_MOTOR_PORT, 1.0, "Left Front Motor Fowards");
			Robot.driveTrain.ManualMotors(0,0,0,0);
			
			Robot.driveTrain.ManualMotors(-1,0,0,0);
			MotorCurrentCheck(RobotMap.PDP_LEFT_FRONT_DRIVE_MOTOR_PORT, 1.0, "Left Front Motor Backwards");
			Robot.driveTrain.ManualMotors(0,0,0,0);
	
		//Right Front
			Robot.driveTrain.ManualMotors(0,1,0,0);
			MotorCurrentCheck(RobotMap.PDP_RIGHT_FRONT_DRIVE_MOTOR_PORT, 1.0, "Right Front Motor Fowards");
			Robot.driveTrain.ManualMotors(0,0,0,0);
			
			Robot.driveTrain.ManualMotors(0,-1,0,0);
			MotorCurrentCheck(RobotMap.PDP_RIGHT_FRONT_DRIVE_MOTOR_PORT, 1.0, "Right Front Motor Backwards");
			Robot.driveTrain.ManualMotors(0,0,0,0);
			
		//Left Back
			Robot.driveTrain.ManualMotors(0,0,1,0);
			MotorCurrentCheck(RobotMap.PDP_LEFT_BACK_DRIVE_MOTOR_PORT, 1.0, "Left Back Motor Fowards");
			Robot.driveTrain.ManualMotors(0,0,0,0);
			
			Robot.driveTrain.ManualMotors(0,0,-1,0);
			MotorCurrentCheck(RobotMap.PDP_LEFT_BACK_DRIVE_MOTOR_PORT, 1.0, "Left Back Motor Backwards");
			Robot.driveTrain.ManualMotors(0,0,0,0);
			
		//Right Back
			Robot.driveTrain.ManualMotors(0,0,0,1);
			MotorCurrentCheck(RobotMap.PDP_RIGHT_BACK_DRIVE_MOTOR_PORT, 1.0, "Right Back Motor Fowards");
			Robot.driveTrain.ManualMotors(0,0,0,0);
			
			Robot.driveTrain.ManualMotors(0,0,0,-1);
			MotorCurrentCheck(RobotMap.PDP_RIGHT_BACK_DRIVE_MOTOR_PORT, 1.0, "Right Back Motor Backwards");
			Robot.driveTrain.ManualMotors(0,0,0,0);
			
		//Intake
			Robot.intake.setIntake(1);
			MotorCurrentCheck(RobotMap.PDP_INTAKE_MOTOR_PORT, 1.0, "Intake Motor Inwards");
			Robot.intake.setIntake(0);
			
			Robot.intake.setIntake(-1);
			MotorCurrentCheck(RobotMap.PDP_INTAKE_MOTOR_PORT, 1.0, "Intake Motor Outwards");
			Robot.intake.setIntake(0);
		
		//Agitator
			Robot.shooter.setAgitator(1);
			MotorCurrentCheck(RobotMap.PDP_LEFT_AGITATOR_MOTOR_PORT, 1.0, "Left Agitator Motor");
			MotorCurrentCheck(RobotMap.PDP_RIGHT_AGITATOR_MOTOR_PORT, 1.0, "Right Agitator Motor");
			Robot.shooter.setAgitator(0);
			
		//Shooter
			Robot.shooter.setRpm(1);
			MotorCurrentCheck(RobotMap.PDP_TOP_SHOOTER_MOTOR_PORT, 1.0, "Top Shooter Motor");
			MotorCurrentCheck(RobotMap.PDP_BOTTOM_SHOOTER_MOTOR_PORT, 1.0, "Bottom Shooter Motor");
			Robot.shooter.setRpm(0);
		
		//Climber
			Robot.climber.goUp(); 
			MotorCurrentCheck(RobotMap.PDP_CLIMBER_MOTOR_PORT, 1.0, "Climber Up");
			Robot.climber.stop();
			
			Robot.climber.goDown(); 
			MotorCurrentCheck(RobotMap.PDP_CLIMBER_MOTOR_PORT, 1.0, "Climber Down");
			Robot.climber.stop();*/
    }
	
	void MotorCurrentCheck(int port, double current, String SystemName)
	{
		timer.reset();
		while(true)
		{
			if(pdp.getCurrent(port) >= current)
			{ SmartDashboard.putString(SystemName, "PASS"); break;}
			
			else if(timer.get() >= 1000) { SmartDashboard.putString(SystemName, "FAIL"); break;} 
		}
	}
	
	void ManualCheck(String Message, String SystemName)
	{
		SmartDashboard.putBoolean(Message, false);
		
		timer.reset();
		while(true)
		{
			if(SmartDashboard.getBoolean(Message, false))
			{ SmartDashboard.putString(SystemName, "PASS"); break;}
			else if(timer.get() >= 10000) { SmartDashboard.putString(SystemName, "FAIL"); break;} 
		}
	}
}
